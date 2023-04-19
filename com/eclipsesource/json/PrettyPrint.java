/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Arrays;
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
/*     */ public class PrettyPrint
/*     */   extends WriterConfig
/*     */ {
/*     */   private final char[] indentChars;
/*     */   
/*     */   protected PrettyPrint(char[] indentChars) {
/*  42 */     this.indentChars = indentChars;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrettyPrint singleLine() {
/*  51 */     return new PrettyPrint(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrettyPrint indentWithSpaces(int number) {
/*  62 */     if (number < 0) {
/*  63 */       throw new IllegalArgumentException("number is negative");
/*     */     }
/*  65 */     char[] chars = new char[number];
/*  66 */     Arrays.fill(chars, ' ');
/*  67 */     return new PrettyPrint(chars);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PrettyPrint indentWithTabs() {
/*  76 */     return new PrettyPrint(new char[] { '\t' });
/*     */   }
/*     */ 
/*     */   
/*     */   protected JsonWriter createWriter(Writer writer) {
/*  81 */     return new PrettyPrintWriter(writer, this.indentChars);
/*     */   }
/*     */   
/*     */   private static class PrettyPrintWriter
/*     */     extends JsonWriter {
/*     */     private final char[] indentChars;
/*     */     private int indent;
/*     */     
/*     */     private PrettyPrintWriter(Writer writer, char[] indentChars) {
/*  90 */       super(writer);
/*  91 */       this.indentChars = indentChars;
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeArrayOpen() throws IOException {
/*  96 */       this.indent++;
/*  97 */       this.writer.write(91);
/*  98 */       writeNewLine();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeArrayClose() throws IOException {
/* 103 */       this.indent--;
/* 104 */       writeNewLine();
/* 105 */       this.writer.write(93);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeArraySeparator() throws IOException {
/* 110 */       this.writer.write(44);
/* 111 */       if (!writeNewLine()) {
/* 112 */         this.writer.write(32);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeObjectOpen() throws IOException {
/* 118 */       this.indent++;
/* 119 */       this.writer.write(123);
/* 120 */       writeNewLine();
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeObjectClose() throws IOException {
/* 125 */       this.indent--;
/* 126 */       writeNewLine();
/* 127 */       this.writer.write(125);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeMemberSeparator() throws IOException {
/* 132 */       this.writer.write(58);
/* 133 */       this.writer.write(32);
/*     */     }
/*     */ 
/*     */     
/*     */     protected void writeObjectSeparator() throws IOException {
/* 138 */       this.writer.write(44);
/* 139 */       if (!writeNewLine()) {
/* 140 */         this.writer.write(32);
/*     */       }
/*     */     }
/*     */     
/*     */     private boolean writeNewLine() throws IOException {
/* 145 */       if (this.indentChars == null) {
/* 146 */         return false;
/*     */       }
/* 148 */       this.writer.write(10);
/* 149 */       for (int i = 0; i < this.indent; i++) {
/* 150 */         this.writer.write(this.indentChars);
/*     */       }
/* 152 */       return true;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\PrettyPrint.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */