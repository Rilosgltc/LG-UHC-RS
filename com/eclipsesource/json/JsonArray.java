/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
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
/*     */ public class JsonArray
/*     */   extends JsonValue
/*     */   implements Iterable<JsonValue>
/*     */ {
/*     */   private final List<JsonValue> values;
/*     */   
/*     */   public JsonArray() {
/*  71 */     this.values = new ArrayList<JsonValue>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonArray(JsonArray array) {
/*  81 */     this(array, false);
/*     */   }
/*     */   
/*     */   private JsonArray(JsonArray array, boolean unmodifiable) {
/*  85 */     if (array == null) {
/*  86 */       throw new NullPointerException("array is null");
/*     */     }
/*  88 */     if (unmodifiable) {
/*  89 */       this.values = Collections.unmodifiableList(array.values);
/*     */     } else {
/*  91 */       this.values = new ArrayList<JsonValue>(array.values);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static JsonArray readFrom(Reader reader) throws IOException {
/* 116 */     return JsonValue.readFrom(reader).asArray();
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
/*     */   @Deprecated
/*     */   public static JsonArray readFrom(String string) {
/* 133 */     return JsonValue.readFrom(string).asArray();
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
/*     */   public static JsonArray unmodifiableArray(JsonArray array) {
/* 149 */     return new JsonArray(array, true);
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
/*     */   public JsonArray add(int value) {
/* 161 */     this.values.add(Json.value(value));
/* 162 */     return this;
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
/*     */   public JsonArray add(long value) {
/* 174 */     this.values.add(Json.value(value));
/* 175 */     return this;
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
/*     */   public JsonArray add(float value) {
/* 187 */     this.values.add(Json.value(value));
/* 188 */     return this;
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
/*     */   public JsonArray add(double value) {
/* 200 */     this.values.add(Json.value(value));
/* 201 */     return this;
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
/*     */   public JsonArray add(boolean value) {
/* 213 */     this.values.add(Json.value(value));
/* 214 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonArray add(String value) {
/* 225 */     this.values.add(Json.value(value));
/* 226 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonArray add(JsonValue value) {
/* 237 */     if (value == null) {
/* 238 */       throw new NullPointerException("value is null");
/*     */     }
/* 240 */     this.values.add(value);
/* 241 */     return this;
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
/*     */   public JsonArray set(int index, int value) {
/* 258 */     this.values.set(index, Json.value(value));
/* 259 */     return this;
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
/*     */   public JsonArray set(int index, long value) {
/* 276 */     this.values.set(index, Json.value(value));
/* 277 */     return this;
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
/*     */   public JsonArray set(int index, float value) {
/* 294 */     this.values.set(index, Json.value(value));
/* 295 */     return this;
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
/*     */   public JsonArray set(int index, double value) {
/* 312 */     this.values.set(index, Json.value(value));
/* 313 */     return this;
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
/*     */   public JsonArray set(int index, boolean value) {
/* 330 */     this.values.set(index, Json.value(value));
/* 331 */     return this;
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
/*     */   public JsonArray set(int index, String value) {
/* 348 */     this.values.set(index, Json.value(value));
/* 349 */     return this;
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
/*     */   public JsonArray set(int index, JsonValue value) {
/* 365 */     if (value == null) {
/* 366 */       throw new NullPointerException("value is null");
/*     */     }
/* 368 */     this.values.set(index, value);
/* 369 */     return this;
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
/*     */   public JsonArray remove(int index) {
/* 383 */     this.values.remove(index);
/* 384 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 393 */     return this.values.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 402 */     return this.values.isEmpty();
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
/*     */   public JsonValue get(int index) {
/* 416 */     return this.values.get(index);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<JsonValue> values() {
/* 427 */     return Collections.unmodifiableList(this.values);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<JsonValue> iterator() {
/* 437 */     final Iterator<JsonValue> iterator = this.values.iterator();
/* 438 */     return new Iterator<JsonValue>()
/*     */       {
/*     */         public boolean hasNext() {
/* 441 */           return iterator.hasNext();
/*     */         }
/*     */         
/*     */         public JsonValue next() {
/* 445 */           return iterator.next();
/*     */         }
/*     */         
/*     */         public void remove() {
/* 449 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   void write(JsonWriter writer) throws IOException {
/* 456 */     writer.writeArrayOpen();
/* 457 */     Iterator<JsonValue> iterator = iterator();
/* 458 */     if (iterator.hasNext()) {
/* 459 */       ((JsonValue)iterator.next()).write(writer);
/* 460 */       while (iterator.hasNext()) {
/* 461 */         writer.writeArraySeparator();
/* 462 */         ((JsonValue)iterator.next()).write(writer);
/*     */       } 
/*     */     } 
/* 465 */     writer.writeArrayClose();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isArray() {
/* 470 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonArray asArray() {
/* 475 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 480 */     return this.values.hashCode();
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
/*     */   public boolean equals(Object object) {
/* 498 */     if (this == object) {
/* 499 */       return true;
/*     */     }
/* 501 */     if (object == null) {
/* 502 */       return false;
/*     */     }
/* 504 */     if (getClass() != object.getClass()) {
/* 505 */       return false;
/*     */     }
/* 507 */     JsonArray other = (JsonArray)object;
/* 508 */     return this.values.equals(other.values);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonArray.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */