/*    */ package com.eclipsesource.json;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class WritingBuffer
/*    */   extends Writer
/*    */ {
/*    */   private final Writer writer;
/*    */   private final char[] buffer;
/* 38 */   private int fill = 0;
/*    */   
/*    */   WritingBuffer(Writer writer) {
/* 41 */     this(writer, 16);
/*    */   }
/*    */   
/*    */   WritingBuffer(Writer writer, int bufferSize) {
/* 45 */     this.writer = writer;
/* 46 */     this.buffer = new char[bufferSize];
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(int c) throws IOException {
/* 51 */     if (this.fill > this.buffer.length - 1) {
/* 52 */       flush();
/*    */     }
/* 54 */     this.buffer[this.fill++] = (char)c;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(char[] cbuf, int off, int len) throws IOException {
/* 59 */     if (this.fill > this.buffer.length - len) {
/* 60 */       flush();
/* 61 */       if (len > this.buffer.length) {
/* 62 */         this.writer.write(cbuf, off, len);
/*    */         return;
/*    */       } 
/*    */     } 
/* 66 */     System.arraycopy(cbuf, off, this.buffer, this.fill, len);
/* 67 */     this.fill += len;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(String str, int off, int len) throws IOException {
/* 72 */     if (this.fill > this.buffer.length - len) {
/* 73 */       flush();
/* 74 */       if (len > this.buffer.length) {
/* 75 */         this.writer.write(str, off, len);
/*    */         return;
/*    */       } 
/*    */     } 
/* 79 */     str.getChars(off, off + len, this.buffer, this.fill);
/* 80 */     this.fill += len;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void flush() throws IOException {
/* 88 */     this.writer.write(this.buffer, 0, this.fill);
/* 89 */     this.fill = 0;
/*    */   }
/*    */   
/*    */   public void close() throws IOException {}
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\WritingBuffer.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */