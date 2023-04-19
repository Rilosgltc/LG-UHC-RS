/*    */ package com.eclipsesource.json;
/*    */ 
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
/*    */ 
/*    */ public abstract class WriterConfig
/*    */ {
/* 35 */   public static WriterConfig MINIMAL = new WriterConfig()
/*    */     {
/*    */       JsonWriter createWriter(Writer writer) {
/* 38 */         return new JsonWriter(writer);
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 46 */   public static WriterConfig PRETTY_PRINT = PrettyPrint.indentWithSpaces(2);
/*    */   
/*    */   abstract JsonWriter createWriter(Writer paramWriter);
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\WriterConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */