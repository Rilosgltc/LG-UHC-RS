/*     */ package com.eclipsesource.json;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.ObjectInputStream;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JsonObject
/*     */   extends JsonValue
/*     */   implements Iterable<JsonObject.Member>
/*     */ {
/*     */   private final List<String> names;
/*     */   private final List<JsonValue> values;
/*     */   private transient HashIndexTable table;
/*     */   
/*     */   public JsonObject() {
/*  83 */     this.names = new ArrayList<String>();
/*  84 */     this.values = new ArrayList<JsonValue>();
/*  85 */     this.table = new HashIndexTable();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonObject(JsonObject object) {
/*  95 */     this(object, false);
/*     */   }
/*     */   
/*     */   private JsonObject(JsonObject object, boolean unmodifiable) {
/*  99 */     if (object == null) {
/* 100 */       throw new NullPointerException("object is null");
/*     */     }
/* 102 */     if (unmodifiable) {
/* 103 */       this.names = Collections.unmodifiableList(object.names);
/* 104 */       this.values = Collections.unmodifiableList(object.values);
/*     */     } else {
/* 106 */       this.names = new ArrayList<String>(object.names);
/* 107 */       this.values = new ArrayList<JsonValue>(object.values);
/*     */     } 
/* 109 */     this.table = new HashIndexTable();
/* 110 */     updateHashIndex();
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
/*     */   public static JsonObject readFrom(Reader reader) throws IOException {
/* 134 */     return JsonValue.readFrom(reader).asObject();
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
/*     */   public static JsonObject readFrom(String string) {
/* 151 */     return JsonValue.readFrom(string).asObject();
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
/*     */   public static JsonObject unmodifiableObject(JsonObject object) {
/* 168 */     return new JsonObject(object, true);
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
/*     */   public JsonObject add(String name, int value) {
/* 190 */     add(name, Json.value(value));
/* 191 */     return this;
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
/*     */   public JsonObject add(String name, long value) {
/* 213 */     add(name, Json.value(value));
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
/*     */   public JsonObject add(String name, float value) {
/* 236 */     add(name, Json.value(value));
/* 237 */     return this;
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
/*     */   public JsonObject add(String name, double value) {
/* 259 */     add(name, Json.value(value));
/* 260 */     return this;
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
/*     */   public JsonObject add(String name, boolean value) {
/* 282 */     add(name, Json.value(value));
/* 283 */     return this;
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
/*     */   public JsonObject add(String name, String value) {
/* 305 */     add(name, Json.value(value));
/* 306 */     return this;
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
/*     */   public JsonObject add(String name, JsonValue value) {
/* 328 */     if (name == null) {
/* 329 */       throw new NullPointerException("name is null");
/*     */     }
/* 331 */     if (value == null) {
/* 332 */       throw new NullPointerException("value is null");
/*     */     }
/* 334 */     this.table.add(name, this.names.size());
/* 335 */     this.names.add(name);
/* 336 */     this.values.add(value);
/* 337 */     return this;
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
/*     */   public JsonObject set(String name, int value) {
/* 358 */     set(name, Json.value(value));
/* 359 */     return this;
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
/*     */   public JsonObject set(String name, long value) {
/* 380 */     set(name, Json.value(value));
/* 381 */     return this;
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
/*     */   public JsonObject set(String name, float value) {
/* 402 */     set(name, Json.value(value));
/* 403 */     return this;
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
/*     */   public JsonObject set(String name, double value) {
/* 424 */     set(name, Json.value(value));
/* 425 */     return this;
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
/*     */   public JsonObject set(String name, boolean value) {
/* 446 */     set(name, Json.value(value));
/* 447 */     return this;
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
/*     */   public JsonObject set(String name, String value) {
/* 468 */     set(name, Json.value(value));
/* 469 */     return this;
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
/*     */   public JsonObject set(String name, JsonValue value) {
/* 489 */     if (name == null) {
/* 490 */       throw new NullPointerException("name is null");
/*     */     }
/* 492 */     if (value == null) {
/* 493 */       throw new NullPointerException("value is null");
/*     */     }
/* 495 */     int index = indexOf(name);
/* 496 */     if (index != -1) {
/* 497 */       this.values.set(index, value);
/*     */     } else {
/* 499 */       this.table.add(name, this.names.size());
/* 500 */       this.names.add(name);
/* 501 */       this.values.add(value);
/*     */     } 
/* 503 */     return this;
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
/*     */   public JsonObject remove(String name) {
/* 516 */     if (name == null) {
/* 517 */       throw new NullPointerException("name is null");
/*     */     }
/* 519 */     int index = indexOf(name);
/* 520 */     if (index != -1) {
/* 521 */       this.table.remove(index);
/* 522 */       this.names.remove(index);
/* 523 */       this.values.remove(index);
/*     */     } 
/* 525 */     return this;
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
/*     */   public JsonObject merge(JsonObject object) {
/* 538 */     if (object == null) {
/* 539 */       throw new NullPointerException("object is null");
/*     */     }
/* 541 */     for (Member member : object) {
/* 542 */       set(member.name, member.value);
/*     */     }
/* 544 */     return this;
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
/*     */   public JsonValue get(String name) {
/* 557 */     if (name == null) {
/* 558 */       throw new NullPointerException("name is null");
/*     */     }
/* 560 */     int index = indexOf(name);
/* 561 */     return (index != -1) ? this.values.get(index) : null;
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
/*     */   public int getInt(String name, int defaultValue) {
/* 579 */     JsonValue value = get(name);
/* 580 */     return (value != null) ? value.asInt() : defaultValue;
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
/*     */   public long getLong(String name, long defaultValue) {
/* 598 */     JsonValue value = get(name);
/* 599 */     return (value != null) ? value.asLong() : defaultValue;
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
/*     */   public float getFloat(String name, float defaultValue) {
/* 617 */     JsonValue value = get(name);
/* 618 */     return (value != null) ? value.asFloat() : defaultValue;
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
/*     */   public double getDouble(String name, double defaultValue) {
/* 636 */     JsonValue value = get(name);
/* 637 */     return (value != null) ? value.asDouble() : defaultValue;
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
/*     */   public boolean getBoolean(String name, boolean defaultValue) {
/* 655 */     JsonValue value = get(name);
/* 656 */     return (value != null) ? value.asBoolean() : defaultValue;
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
/*     */   public String getString(String name, String defaultValue) {
/* 673 */     JsonValue value = get(name);
/* 674 */     return (value != null) ? value.asString() : defaultValue;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 683 */     return this.names.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEmpty() {
/* 692 */     return this.names.isEmpty();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> names() {
/* 703 */     return Collections.unmodifiableList(this.names);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Member> iterator() {
/* 713 */     final Iterator<String> namesIterator = this.names.iterator();
/* 714 */     final Iterator<JsonValue> valuesIterator = this.values.iterator();
/* 715 */     return new Iterator<Member>()
/*     */       {
/*     */         public boolean hasNext() {
/* 718 */           return namesIterator.hasNext();
/*     */         }
/*     */         
/*     */         public JsonObject.Member next() {
/* 722 */           String name = namesIterator.next();
/* 723 */           JsonValue value = valuesIterator.next();
/* 724 */           return new JsonObject.Member(name, value);
/*     */         }
/*     */         
/*     */         public void remove() {
/* 728 */           throw new UnsupportedOperationException();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void write(JsonWriter writer) throws IOException {
/* 736 */     writer.writeObjectOpen();
/* 737 */     Iterator<String> namesIterator = this.names.iterator();
/* 738 */     Iterator<JsonValue> valuesIterator = this.values.iterator();
/* 739 */     if (namesIterator.hasNext()) {
/* 740 */       writer.writeMemberName(namesIterator.next());
/* 741 */       writer.writeMemberSeparator();
/* 742 */       ((JsonValue)valuesIterator.next()).write(writer);
/* 743 */       while (namesIterator.hasNext()) {
/* 744 */         writer.writeObjectSeparator();
/* 745 */         writer.writeMemberName(namesIterator.next());
/* 746 */         writer.writeMemberSeparator();
/* 747 */         ((JsonValue)valuesIterator.next()).write(writer);
/*     */       } 
/*     */     } 
/* 750 */     writer.writeObjectClose();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isObject() {
/* 755 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public JsonObject asObject() {
/* 760 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 765 */     int result = 1;
/* 766 */     result = 31 * result + this.names.hashCode();
/* 767 */     result = 31 * result + this.values.hashCode();
/* 768 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 773 */     if (this == obj) {
/* 774 */       return true;
/*     */     }
/* 776 */     if (obj == null) {
/* 777 */       return false;
/*     */     }
/* 779 */     if (getClass() != obj.getClass()) {
/* 780 */       return false;
/*     */     }
/* 782 */     JsonObject other = (JsonObject)obj;
/* 783 */     return (this.names.equals(other.names) && this.values.equals(other.values));
/*     */   }
/*     */   
/*     */   int indexOf(String name) {
/* 787 */     int index = this.table.get(name);
/* 788 */     if (index != -1 && name.equals(this.names.get(index))) {
/* 789 */       return index;
/*     */     }
/* 791 */     return this.names.lastIndexOf(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
/* 797 */     inputStream.defaultReadObject();
/* 798 */     this.table = new HashIndexTable();
/* 799 */     updateHashIndex();
/*     */   }
/*     */   
/*     */   private void updateHashIndex() {
/* 803 */     int size = this.names.size();
/* 804 */     for (int i = 0; i < size; i++) {
/* 805 */       this.table.add(this.names.get(i), i);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Member
/*     */   {
/*     */     private final String name;
/*     */     
/*     */     private final JsonValue value;
/*     */ 
/*     */     
/*     */     Member(String name, JsonValue value) {
/* 818 */       this.name = name;
/* 819 */       this.value = value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 828 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public JsonValue getValue() {
/* 837 */       return this.value;
/*     */     }
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 842 */       int result = 1;
/* 843 */       result = 31 * result + this.name.hashCode();
/* 844 */       result = 31 * result + this.value.hashCode();
/* 845 */       return result;
/*     */     }
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
/*     */     public boolean equals(Object object) {
/* 863 */       if (this == object) {
/* 864 */         return true;
/*     */       }
/* 866 */       if (object == null) {
/* 867 */         return false;
/*     */       }
/* 869 */       if (getClass() != object.getClass()) {
/* 870 */         return false;
/*     */       }
/* 872 */       Member other = (Member)object;
/* 873 */       return (this.name.equals(other.name) && this.value.equals(other.value));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   static class HashIndexTable
/*     */   {
/* 880 */     private final byte[] hashTable = new byte[32];
/*     */ 
/*     */     
/*     */     public HashIndexTable() {}
/*     */     
/*     */     public HashIndexTable(HashIndexTable original) {
/* 886 */       System.arraycopy(original.hashTable, 0, this.hashTable, 0, this.hashTable.length);
/*     */     }
/*     */     
/*     */     void add(String name, int index) {
/* 890 */       int slot = hashSlotFor(name);
/* 891 */       if (index < 255) {
/*     */         
/* 893 */         this.hashTable[slot] = (byte)(index + 1);
/*     */       } else {
/* 895 */         this.hashTable[slot] = 0;
/*     */       } 
/*     */     }
/*     */     
/*     */     void remove(int index) {
/* 900 */       for (int i = 0; i < this.hashTable.length; i++) {
/* 901 */         if (this.hashTable[i] == index + 1) {
/* 902 */           this.hashTable[i] = 0;
/* 903 */         } else if (this.hashTable[i] > index + 1) {
/* 904 */           this.hashTable[i] = (byte)(this.hashTable[i] - 1);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     int get(Object name) {
/* 910 */       int slot = hashSlotFor(name);
/*     */       
/* 912 */       return (this.hashTable[slot] & 0xFF) - 1;
/*     */     }
/*     */     
/*     */     private int hashSlotFor(Object element) {
/* 916 */       return element.hashCode() & this.hashTable.length - 1;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\eclipsesource\json\JsonObject.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */