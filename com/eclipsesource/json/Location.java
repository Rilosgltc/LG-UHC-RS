/*    */ package com.eclipsesource.json;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Location
/*    */ {
/*    */   public final int offset;
/*    */   public final int line;
/*    */   public final int column;
/*    */   
/*    */   Location(int offset, int line, int column) {
/* 46 */     this.offset = offset;
/* 47 */     this.column = column;
/* 48 */     this.line = line;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 53 */     return this.line + ":" + this.column;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 58 */     return this.offset;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean equals(Object obj) {
/* 63 */     if (this == obj) {
/* 64 */       return true;
/*    */     }
/* 66 */     if (obj == null) {
/* 67 */       return false;
/*    */     }
/* 69 */     if (getClass() != obj.getClass()) {
/* 70 */       return false;
/*    */     }
/* 72 */     Location other = (Location)obj;
/* 73 */     return (this.offset == other.offset && this.column == other.column && this.line == other.line);
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\Location.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */