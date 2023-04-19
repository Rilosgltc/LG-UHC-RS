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
/*    */ class JsonLiteral
/*    */   extends JsonValue
/*    */ {
/*    */   private final String value;
/*    */   private final boolean isNull;
/*    */   private final boolean isTrue;
/*    */   private final boolean isFalse;
/*    */   
/*    */   JsonLiteral(String value) {
/* 36 */     this.value = value;
/* 37 */     this.isNull = "null".equals(value);
/* 38 */     this.isTrue = "true".equals(value);
/* 39 */     this.isFalse = "false".equals(value);
/*    */   }
/*    */ 
/*    */   
/*    */   void write(JsonWriter writer) throws IOException {
/* 44 */     writer.writeLiteral(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 49 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 54 */     return this.value.hashCode();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isNull() {
/* 59 */     return this.isNull;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTrue() {
/* 64 */     return this.isTrue;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isFalse() {
/* 69 */     return this.isFalse;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isBoolean() {
/* 74 */     return (this.isTrue || this.isFalse);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean asBoolean() {
/* 79 */     return this.isNull ? super.asBoolean() : this.isTrue;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object object) {
/* 84 */     if (this == object) {
/* 85 */       return true;
/*    */     }
/* 87 */     if (object == null) {
/* 88 */       return false;
/*    */     }
/* 90 */     if (getClass() != object.getClass()) {
/* 91 */       return false;
/*    */     }
/* 93 */     JsonLiteral other = (JsonLiteral)object;
/* 94 */     return this.value.equals(other.value);
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonLiteral.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */