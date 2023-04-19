/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonParser
/*     */ {
/*     */   private static final int MAX_NESTING_LEVEL = 1000;
/*     */   private static final int MIN_BUFFER_SIZE = 10;
/*     */   private static final int DEFAULT_BUFFER_SIZE = 1024;
/*     */   private final JsonHandler<Object, Object> handler;
/*     */   private Reader reader;
/*     */   private char[] buffer;
/*     */   private int bufferOffset;
/*     */   private int index;
/*     */   private int fill;
/*     */   private int line;
/*     */   private int lineOffset;
/*     */   private int current;
/*     */   private StringBuilder captureBuffer;
/*     */   private int captureStart;
/*     */   private int nestingLevel;
/*     */   
/*     */   public JsonParser(JsonHandler<?, ?> handler) {
/*  69 */     if (handler == null) {
/*  70 */       throw new NullPointerException("handler is null");
/*     */     }
/*  72 */     this.handler = (JsonHandler)handler;
/*  73 */     handler.parser = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(String string) {
/*  86 */     if (string == null) {
/*  87 */       throw new NullPointerException("string is null");
/*     */     }
/*  89 */     int bufferSize = Math.max(10, Math.min(1024, string.length()));
/*     */     try {
/*  91 */       parse(new StringReader(string), bufferSize);
/*  92 */     } catch (IOException exception) {
/*     */       
/*  94 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(Reader reader) throws IOException {
/* 114 */     parse(reader, 1024);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void parse(Reader reader, int buffersize) throws IOException {
/* 135 */     if (reader == null) {
/* 136 */       throw new NullPointerException("reader is null");
/*     */     }
/* 138 */     if (buffersize <= 0) {
/* 139 */       throw new IllegalArgumentException("buffersize is zero or negative");
/*     */     }
/* 141 */     this.reader = reader;
/* 142 */     this.buffer = new char[buffersize];
/* 143 */     this.bufferOffset = 0;
/* 144 */     this.index = 0;
/* 145 */     this.fill = 0;
/* 146 */     this.line = 1;
/* 147 */     this.lineOffset = 0;
/* 148 */     this.current = 0;
/* 149 */     this.captureStart = -1;
/* 150 */     read();
/* 151 */     skipWhiteSpace();
/* 152 */     readValue();
/* 153 */     skipWhiteSpace();
/* 154 */     if (!isEndOfText()) {
/* 155 */       throw error("Unexpected character");
/*     */     }
/*     */   }
/*     */   
/*     */   private void readValue() throws IOException {
/* 160 */     switch (this.current) {
/*     */       case 110:
/* 162 */         readNull();
/*     */         return;
/*     */       case 116:
/* 165 */         readTrue();
/*     */         return;
/*     */       case 102:
/* 168 */         readFalse();
/*     */         return;
/*     */       case 34:
/* 171 */         readString();
/*     */         return;
/*     */       case 91:
/* 174 */         readArray();
/*     */         return;
/*     */       case 123:
/* 177 */         readObject();
/*     */         return;
/*     */       case 45:
/*     */       case 48:
/*     */       case 49:
/*     */       case 50:
/*     */       case 51:
/*     */       case 52:
/*     */       case 53:
/*     */       case 54:
/*     */       case 55:
/*     */       case 56:
/*     */       case 57:
/* 190 */         readNumber();
/*     */         return;
/*     */     } 
/* 193 */     throw expected("value");
/*     */   }
/*     */ 
/*     */   
/*     */   private void readArray() throws IOException {
/* 198 */     Object array = this.handler.startArray();
/* 199 */     read();
/* 200 */     if (++this.nestingLevel > 1000) {
/* 201 */       throw error("Nesting too deep");
/*     */     }
/* 203 */     skipWhiteSpace();
/* 204 */     if (readChar(']')) {
/* 205 */       this.nestingLevel--;
/* 206 */       this.handler.endArray(array);
/*     */       return;
/*     */     } 
/*     */     while (true) {
/* 210 */       skipWhiteSpace();
/* 211 */       this.handler.startArrayValue(array);
/* 212 */       readValue();
/* 213 */       this.handler.endArrayValue(array);
/* 214 */       skipWhiteSpace();
/* 215 */       if (!readChar(',')) {
/* 216 */         if (!readChar(']')) {
/* 217 */           throw expected("',' or ']'");
/*     */         }
/* 219 */         this.nestingLevel--;
/* 220 */         this.handler.endArray(array);
/*     */         return;
/*     */       } 
/*     */     }  }
/* 224 */   private void readObject() throws IOException { Object object = this.handler.startObject();
/* 225 */     read();
/* 226 */     if (++this.nestingLevel > 1000) {
/* 227 */       throw error("Nesting too deep");
/*     */     }
/* 229 */     skipWhiteSpace();
/* 230 */     if (readChar('}')) {
/* 231 */       this.nestingLevel--;
/* 232 */       this.handler.endObject(object);
/*     */       return;
/*     */     } 
/*     */     while (true) {
/* 236 */       skipWhiteSpace();
/* 237 */       this.handler.startObjectName(object);
/* 238 */       String name = readName();
/* 239 */       this.handler.endObjectName(object, name);
/* 240 */       skipWhiteSpace();
/* 241 */       if (!readChar(':')) {
/* 242 */         throw expected("':'");
/*     */       }
/* 244 */       skipWhiteSpace();
/* 245 */       this.handler.startObjectValue(object, name);
/* 246 */       readValue();
/* 247 */       this.handler.endObjectValue(object, name);
/* 248 */       skipWhiteSpace();
/* 249 */       if (!readChar(',')) {
/* 250 */         if (!readChar('}')) {
/* 251 */           throw expected("',' or '}'");
/*     */         }
/* 253 */         this.nestingLevel--;
/* 254 */         this.handler.endObject(object);
/*     */         return;
/*     */       } 
/*     */     }  } private String readName() throws IOException {
/* 258 */     if (this.current != 34) {
/* 259 */       throw expected("name");
/*     */     }
/* 261 */     return readStringInternal();
/*     */   }
/*     */   
/*     */   private void readNull() throws IOException {
/* 265 */     this.handler.startNull();
/* 266 */     read();
/* 267 */     readRequiredChar('u');
/* 268 */     readRequiredChar('l');
/* 269 */     readRequiredChar('l');
/* 270 */     this.handler.endNull();
/*     */   }
/*     */   
/*     */   private void readTrue() throws IOException {
/* 274 */     this.handler.startBoolean();
/* 275 */     read();
/* 276 */     readRequiredChar('r');
/* 277 */     readRequiredChar('u');
/* 278 */     readRequiredChar('e');
/* 279 */     this.handler.endBoolean(true);
/*     */   }
/*     */   
/*     */   private void readFalse() throws IOException {
/* 283 */     this.handler.startBoolean();
/* 284 */     read();
/* 285 */     readRequiredChar('a');
/* 286 */     readRequiredChar('l');
/* 287 */     readRequiredChar('s');
/* 288 */     readRequiredChar('e');
/* 289 */     this.handler.endBoolean(false);
/*     */   }
/*     */   
/*     */   private void readRequiredChar(char ch) throws IOException {
/* 293 */     if (!readChar(ch)) {
/* 294 */       throw expected("'" + ch + "'");
/*     */     }
/*     */   }
/*     */   
/*     */   private void readString() throws IOException {
/* 299 */     this.handler.startString();
/* 300 */     this.handler.endString(readStringInternal());
/*     */   }
/*     */   
/*     */   private String readStringInternal() throws IOException {
/* 304 */     read();
/* 305 */     startCapture();
/* 306 */     while (this.current != 34) {
/* 307 */       if (this.current == 92) {
/* 308 */         pauseCapture();
/* 309 */         readEscape();
/* 310 */         startCapture(); continue;
/* 311 */       }  if (this.current < 32) {
/* 312 */         throw expected("valid string character");
/*     */       }
/* 314 */       read();
/*     */     } 
/*     */     
/* 317 */     String string = endCapture();
/* 318 */     read();
/* 319 */     return string;
/*     */   } private void readEscape() throws IOException {
/*     */     char[] hexChars;
/*     */     int i;
/* 323 */     read();
/* 324 */     switch (this.current) {
/*     */       case 34:
/*     */       case 47:
/*     */       case 92:
/* 328 */         this.captureBuffer.append((char)this.current);
/*     */         break;
/*     */       case 98:
/* 331 */         this.captureBuffer.append('\b');
/*     */         break;
/*     */       case 102:
/* 334 */         this.captureBuffer.append('\f');
/*     */         break;
/*     */       case 110:
/* 337 */         this.captureBuffer.append('\n');
/*     */         break;
/*     */       case 114:
/* 340 */         this.captureBuffer.append('\r');
/*     */         break;
/*     */       case 116:
/* 343 */         this.captureBuffer.append('\t');
/*     */         break;
/*     */       case 117:
/* 346 */         hexChars = new char[4];
/* 347 */         for (i = 0; i < 4; i++) {
/* 348 */           read();
/* 349 */           if (!isHexDigit()) {
/* 350 */             throw expected("hexadecimal digit");
/*     */           }
/* 352 */           hexChars[i] = (char)this.current;
/*     */         } 
/* 354 */         this.captureBuffer.append((char)Integer.parseInt(new String(hexChars), 16));
/*     */         break;
/*     */       default:
/* 357 */         throw expected("valid escape sequence");
/*     */     } 
/* 359 */     read();
/*     */   }
/*     */   
/*     */   private void readNumber() throws IOException {
/* 363 */     this.handler.startNumber();
/* 364 */     startCapture();
/* 365 */     readChar('-');
/* 366 */     int firstDigit = this.current;
/* 367 */     if (!readDigit()) {
/* 368 */       throw expected("digit");
/*     */     }
/* 370 */     if (firstDigit != 48) {
/* 371 */       while (readDigit());
/*     */     }
/*     */     
/* 374 */     readFraction();
/* 375 */     readExponent();
/* 376 */     this.handler.endNumber(endCapture());
/*     */   }
/*     */   
/*     */   private boolean readFraction() throws IOException {
/* 380 */     if (!readChar('.')) {
/* 381 */       return false;
/*     */     }
/* 383 */     if (!readDigit()) {
/* 384 */       throw expected("digit");
/*     */     }
/* 386 */     while (readDigit());
/*     */     
/* 388 */     return true;
/*     */   }
/*     */   
/*     */   private boolean readExponent() throws IOException {
/* 392 */     if (!readChar('e') && !readChar('E')) {
/* 393 */       return false;
/*     */     }
/* 395 */     if (!readChar('+')) {
/* 396 */       readChar('-');
/*     */     }
/* 398 */     if (!readDigit()) {
/* 399 */       throw expected("digit");
/*     */     }
/* 401 */     while (readDigit());
/*     */     
/* 403 */     return true;
/*     */   }
/*     */   
/*     */   private boolean readChar(char ch) throws IOException {
/* 407 */     if (this.current != ch) {
/* 408 */       return false;
/*     */     }
/* 410 */     read();
/* 411 */     return true;
/*     */   }
/*     */   
/*     */   private boolean readDigit() throws IOException {
/* 415 */     if (!isDigit()) {
/* 416 */       return false;
/*     */     }
/* 418 */     read();
/* 419 */     return true;
/*     */   }
/*     */   
/*     */   private void skipWhiteSpace() throws IOException {
/* 423 */     while (isWhiteSpace()) {
/* 424 */       read();
/*     */     }
/*     */   }
/*     */   
/*     */   private void read() throws IOException {
/* 429 */     if (this.index == this.fill) {
/* 430 */       if (this.captureStart != -1) {
/* 431 */         this.captureBuffer.append(this.buffer, this.captureStart, this.fill - this.captureStart);
/* 432 */         this.captureStart = 0;
/*     */       } 
/* 434 */       this.bufferOffset += this.fill;
/* 435 */       this.fill = this.reader.read(this.buffer, 0, this.buffer.length);
/* 436 */       this.index = 0;
/* 437 */       if (this.fill == -1) {
/* 438 */         this.current = -1;
/* 439 */         this.index++;
/*     */         return;
/*     */       } 
/*     */     } 
/* 443 */     if (this.current == 10) {
/* 444 */       this.line++;
/* 445 */       this.lineOffset = this.bufferOffset + this.index;
/*     */     } 
/* 447 */     this.current = this.buffer[this.index++];
/*     */   }
/*     */   
/*     */   private void startCapture() {
/* 451 */     if (this.captureBuffer == null) {
/* 452 */       this.captureBuffer = new StringBuilder();
/*     */     }
/* 454 */     this.captureStart = this.index - 1;
/*     */   }
/*     */   
/*     */   private void pauseCapture() {
/* 458 */     int end = (this.current == -1) ? this.index : (this.index - 1);
/* 459 */     this.captureBuffer.append(this.buffer, this.captureStart, end - this.captureStart);
/* 460 */     this.captureStart = -1;
/*     */   }
/*     */   
/*     */   private String endCapture() {
/* 464 */     int start = this.captureStart;
/* 465 */     int end = this.index - 1;
/* 466 */     this.captureStart = -1;
/* 467 */     if (this.captureBuffer.length() > 0) {
/* 468 */       this.captureBuffer.append(this.buffer, start, end - start);
/* 469 */       String captured = this.captureBuffer.toString();
/* 470 */       this.captureBuffer.setLength(0);
/* 471 */       return captured;
/*     */     } 
/* 473 */     return new String(this.buffer, start, end - start);
/*     */   }
/*     */   
/*     */   Location getLocation() {
/* 477 */     int offset = this.bufferOffset + this.index - 1;
/* 478 */     int column = offset - this.lineOffset + 1;
/* 479 */     return new Location(offset, this.line, column);
/*     */   }
/*     */   
/*     */   private ParseException expected(String expected) {
/* 483 */     if (isEndOfText()) {
/* 484 */       return error("Unexpected end of input");
/*     */     }
/* 486 */     return error("Expected " + expected);
/*     */   }
/*     */   
/*     */   private ParseException error(String message) {
/* 490 */     return new ParseException(message, getLocation());
/*     */   }
/*     */   
/*     */   private boolean isWhiteSpace() {
/* 494 */     return (this.current == 32 || this.current == 9 || this.current == 10 || this.current == 13);
/*     */   }
/*     */   
/*     */   private boolean isDigit() {
/* 498 */     return (this.current >= 48 && this.current <= 57);
/*     */   }
/*     */   
/*     */   private boolean isHexDigit() {
/* 502 */     return ((this.current >= 48 && this.current <= 57) || (this.current >= 97 && this.current <= 102) || (this.current >= 65 && this.current <= 70));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isEndOfText() {
/* 508 */     return (this.current == -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonParser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */