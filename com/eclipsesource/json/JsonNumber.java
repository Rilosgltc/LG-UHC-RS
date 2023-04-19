/*    */ package com.eclipsesource.json;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ class JsonNumber
/*    */   extends JsonValue
/*    */ {
/*    */   private final String string;
/*    */   
/*    */   JsonNumber(String string) {
/* 33 */     if (string == null) {
/* 34 */       throw new NullPointerException("string is null");
/*    */     }
/* 36 */     this.string = string;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 41 */     return this.string;
/*    */   }
/*    */ 
/*    */   
/*    */   void write(JsonWriter writer) throws IOException {
/* 46 */     writer.writeNumber(this.string);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isNumber() {
/* 51 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int asInt() {
/* 56 */     return Integer.parseInt(this.string, 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public long asLong() {
/* 61 */     return Long.parseLong(this.string, 10);
/*    */   }
/*    */ 
/*    */   
/*    */   public float asFloat() {
/* 66 */     return Float.parseFloat(this.string);
/*    */   }
/*    */ 
/*    */   
/*    */   public double asDouble() {
/* 71 */     return Double.parseDouble(this.string);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 76 */     return this.string.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 81 */     if (this == object) {
/* 82 */       return true;
/*    */     }
/* 84 */     if (object == null) {
/* 85 */       return false;
/*    */     }
/* 87 */     if (getClass() != object.getClass()) {
/* 88 */       return false;
/*    */     }
/* 90 */     JsonNumber other = (JsonNumber)object;
/* 91 */     return this.string.equals(other.string);
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonNumber.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */