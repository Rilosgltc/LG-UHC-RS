/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
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
/*     */ public final class Json
/*     */ {
/*  63 */   public static final JsonValue NULL = new JsonLiteral("null");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final JsonValue TRUE = new JsonLiteral("true");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   public static final JsonValue FALSE = new JsonLiteral("false");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(int value) {
/*  83 */     return new JsonNumber(Integer.toString(value, 10));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(long value) {
/*  94 */     return new JsonNumber(Long.toString(value, 10));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(float value) {
/* 105 */     if (Float.isInfinite(value) || Float.isNaN(value)) {
/* 106 */       throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
/*     */     }
/* 108 */     return new JsonNumber(cutOffPointZero(Float.toString(value)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(double value) {
/* 119 */     if (Double.isInfinite(value) || Double.isNaN(value)) {
/* 120 */       throw new IllegalArgumentException("Infinite and NaN values not permitted in JSON");
/*     */     }
/* 122 */     return new JsonNumber(cutOffPointZero(Double.toString(value)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(String string) {
/* 133 */     return (string == null) ? NULL : new JsonString(string);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonValue value(boolean value) {
/* 144 */     return value ? TRUE : FALSE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonArray array() {
/* 154 */     return new JsonArray();
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
/*     */   public static JsonArray array(int... values) {
/* 166 */     if (values == null) {
/* 167 */       throw new NullPointerException("values is null");
/*     */     }
/* 169 */     JsonArray array = new JsonArray();
/* 170 */     for (int value : values) {
/* 171 */       array.add(value);
/*     */     }
/* 173 */     return array;
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
/*     */   public static JsonArray array(long... values) {
/* 185 */     if (values == null) {
/* 186 */       throw new NullPointerException("values is null");
/*     */     }
/* 188 */     JsonArray array = new JsonArray();
/* 189 */     for (long value : values) {
/* 190 */       array.add(value);
/*     */     }
/* 192 */     return array;
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
/*     */   public static JsonArray array(float... values) {
/* 204 */     if (values == null) {
/* 205 */       throw new NullPointerException("values is null");
/*     */     }
/* 207 */     JsonArray array = new JsonArray();
/* 208 */     for (float value : values) {
/* 209 */       array.add(value);
/*     */     }
/* 211 */     return array;
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
/*     */   public static JsonArray array(double... values) {
/* 223 */     if (values == null) {
/* 224 */       throw new NullPointerException("values is null");
/*     */     }
/* 226 */     JsonArray array = new JsonArray();
/* 227 */     for (double value : values) {
/* 228 */       array.add(value);
/*     */     }
/* 230 */     return array;
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
/*     */   public static JsonArray array(boolean... values) {
/* 242 */     if (values == null) {
/* 243 */       throw new NullPointerException("values is null");
/*     */     }
/* 245 */     JsonArray array = new JsonArray();
/* 246 */     for (boolean value : values) {
/* 247 */       array.add(value);
/*     */     }
/* 249 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonArray array(String... strings) {
/* 260 */     if (strings == null) {
/* 261 */       throw new NullPointerException("values is null");
/*     */     }
/* 263 */     JsonArray array = new JsonArray();
/* 264 */     for (String value : strings) {
/* 265 */       array.add(value);
/*     */     }
/* 267 */     return array;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonObject object() {
/* 277 */     return new JsonObject();
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
/*     */   public static JsonValue parse(String string) {
/* 291 */     if (string == null) {
/* 292 */       throw new NullPointerException("string is null");
/*     */     }
/* 294 */     DefaultHandler handler = new DefaultHandler();
/* 295 */     (new JsonParser(handler)).parse(string);
/* 296 */     return handler.getValue();
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
/*     */   public static JsonValue parse(Reader reader) throws IOException {
/* 316 */     if (reader == null) {
/* 317 */       throw new NullPointerException("reader is null");
/*     */     }
/* 319 */     DefaultHandler handler = new DefaultHandler();
/* 320 */     (new JsonParser(handler)).parse(reader);
/* 321 */     return handler.getValue();
/*     */   }
/*     */   
/*     */   private static String cutOffPointZero(String string) {
/* 325 */     if (string.endsWith(".0")) {
/* 326 */       return string.substring(0, string.length() - 2);
/*     */     }
/* 328 */     return string;
/*     */   }
/*     */   
/*     */   static class DefaultHandler
/*     */     extends JsonHandler<JsonArray, JsonObject>
/*     */   {
/*     */     protected JsonValue value;
/*     */     
/*     */     public JsonArray startArray() {
/* 337 */       return new JsonArray();
/*     */     }
/*     */ 
/*     */     
/*     */     public JsonObject startObject() {
/* 342 */       return new JsonObject();
/*     */     }
/*     */ 
/*     */     
/*     */     public void endNull() {
/* 347 */       this.value = Json.NULL;
/*     */     }
/*     */ 
/*     */     
/*     */     public void endBoolean(boolean bool) {
/* 352 */       this.value = bool ? Json.TRUE : Json.FALSE;
/*     */     }
/*     */ 
/*     */     
/*     */     public void endString(String string) {
/* 357 */       this.value = new JsonString(string);
/*     */     }
/*     */ 
/*     */     
/*     */     public void endNumber(String string) {
/* 362 */       this.value = new JsonNumber(string);
/*     */     }
/*     */ 
/*     */     
/*     */     public void endArray(JsonArray array) {
/* 367 */       this.value = array;
/*     */     }
/*     */ 
/*     */     
/*     */     public void endObject(JsonObject object) {
/* 372 */       this.value = object;
/*     */     }
/*     */ 
/*     */     
/*     */     public void endArrayValue(JsonArray array) {
/* 377 */       array.add(this.value);
/*     */     }
/*     */ 
/*     */     
/*     */     public void endObjectValue(JsonObject object, String name) {
/* 382 */       object.add(name, this.value);
/*     */     }
/*     */     
/*     */     JsonValue getValue() {
/* 386 */       return this.value;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\Json.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */