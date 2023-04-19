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
/*    */ class JsonString
/*    */   extends JsonValue
/*    */ {
/*    */   private final String string;
/*    */   
/*    */   JsonString(String string) {
/* 33 */     if (string == null) {
/* 34 */       throw new NullPointerException("string is null");
/*    */     }
/* 36 */     this.string = string;
/*    */   }
/*    */ 
/*    */   
/*    */   void write(JsonWriter writer) throws IOException {
/* 41 */     writer.writeString(this.string);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isString() {
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public String asString() {
/* 51 */     return this.string;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 56 */     return this.string.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 61 */     if (this == object) {
/* 62 */       return true;
/*    */     }
/* 64 */     if (object == null) {
/* 65 */       return false;
/*    */     }
/* 67 */     if (getClass() != object.getClass()) {
/* 68 */       return false;
/*    */     }
/* 70 */     JsonString other = (JsonString)object;
/* 71 */     return this.string.equals(other.string);
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonString.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */