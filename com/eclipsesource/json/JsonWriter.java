/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
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
/*     */ class JsonWriter
/*     */ {
/*     */   private static final int CONTROL_CHARACTERS_END = 31;
/*  32 */   private static final char[] QUOT_CHARS = new char[] { '\\', '"' };
/*  33 */   private static final char[] BS_CHARS = new char[] { '\\', '\\' };
/*  34 */   private static final char[] LF_CHARS = new char[] { '\\', 'n' };
/*  35 */   private static final char[] CR_CHARS = new char[] { '\\', 'r' };
/*  36 */   private static final char[] TAB_CHARS = new char[] { '\\', 't' };
/*     */ 
/*     */   
/*  39 */   private static final char[] UNICODE_2028_CHARS = new char[] { '\\', 'u', '2', '0', '2', '8' };
/*  40 */   private static final char[] UNICODE_2029_CHARS = new char[] { '\\', 'u', '2', '0', '2', '9' };
/*  41 */   private static final char[] HEX_DIGITS = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*     */   
/*     */   protected final Writer writer;
/*     */ 
/*     */   
/*     */   JsonWriter(Writer writer) {
/*  47 */     this.writer = writer;
/*     */   }
/*     */   
/*     */   protected void writeLiteral(String value) throws IOException {
/*  51 */     this.writer.write(value);
/*     */   }
/*     */   
/*     */   protected void writeNumber(String string) throws IOException {
/*  55 */     this.writer.write(string);
/*     */   }
/*     */   
/*     */   protected void writeString(String string) throws IOException {
/*  59 */     this.writer.write(34);
/*  60 */     writeJsonString(string);
/*  61 */     this.writer.write(34);
/*     */   }
/*     */   
/*     */   protected void writeArrayOpen() throws IOException {
/*  65 */     this.writer.write(91);
/*     */   }
/*     */   
/*     */   protected void writeArrayClose() throws IOException {
/*  69 */     this.writer.write(93);
/*     */   }
/*     */   
/*     */   protected void writeArraySeparator() throws IOException {
/*  73 */     this.writer.write(44);
/*     */   }
/*     */   
/*     */   protected void writeObjectOpen() throws IOException {
/*  77 */     this.writer.write(123);
/*     */   }
/*     */   
/*     */   protected void writeObjectClose() throws IOException {
/*  81 */     this.writer.write(125);
/*     */   }
/*     */   
/*     */   protected void writeMemberName(String name) throws IOException {
/*  85 */     this.writer.write(34);
/*  86 */     writeJsonString(name);
/*  87 */     this.writer.write(34);
/*     */   }
/*     */   
/*     */   protected void writeMemberSeparator() throws IOException {
/*  91 */     this.writer.write(58);
/*     */   }
/*     */   
/*     */   protected void writeObjectSeparator() throws IOException {
/*  95 */     this.writer.write(44);
/*     */   }
/*     */   
/*     */   protected void writeJsonString(String string) throws IOException {
/*  99 */     int length = string.length();
/* 100 */     int start = 0;
/* 101 */     for (int index = 0; index < length; index++) {
/* 102 */       char[] replacement = getReplacementChars(string.charAt(index));
/* 103 */       if (replacement != null) {
/* 104 */         this.writer.write(string, start, index - start);
/* 105 */         this.writer.write(replacement);
/* 106 */         start = index + 1;
/*     */       } 
/*     */     } 
/* 109 */     this.writer.write(string, start, length - start);
/*     */   }
/*     */   
/*     */   private static char[] getReplacementChars(char ch) {
/* 113 */     if (ch > '\\') {
/* 114 */       if (ch < ' ' || ch > ' ')
/*     */       {
/* 116 */         return null;
/*     */       }
/* 118 */       return (ch == ' ') ? UNICODE_2028_CHARS : UNICODE_2029_CHARS;
/*     */     } 
/* 120 */     if (ch == '\\') {
/* 121 */       return BS_CHARS;
/*     */     }
/* 123 */     if (ch > '"')
/*     */     {
/* 125 */       return null;
/*     */     }
/* 127 */     if (ch == '"') {
/* 128 */       return QUOT_CHARS;
/*     */     }
/* 130 */     if (ch > '\037') {
/* 131 */       return null;
/*     */     }
/* 133 */     if (ch == '\n') {
/* 134 */       return LF_CHARS;
/*     */     }
/* 136 */     if (ch == '\r') {
/* 137 */       return CR_CHARS;
/*     */     }
/* 139 */     if (ch == '\t') {
/* 140 */       return TAB_CHARS;
/*     */     }
/* 142 */     return new char[] { '\\', 'u', '0', '0', HEX_DIGITS[ch >> 4 & 0xF], HEX_DIGITS[ch & 0xF] };
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */