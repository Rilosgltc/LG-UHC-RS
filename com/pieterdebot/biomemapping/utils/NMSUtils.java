/*     */ package com.pieterdebot.biomemapping.utils;
/*     */ 
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.bukkit.Bukkit;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NMSUtils
/*     */ {
/*  15 */   private static final String version = getVersion();
/*     */   
/*     */   public static String getVersion() {
/*  18 */     if (version != null) {
/*  19 */       return version;
/*     */     }
/*  21 */     String name = Bukkit.getServer().getClass().getPackage().getName();
/*  22 */     return name.substring(name.lastIndexOf('.') + 1) + ".";
/*     */   }
/*     */ 
/*     */   
/*     */   public static Object getHandle(Object craftObject) {
/*     */     try {
/*  28 */       return getMethod(craftObject.getClass(), "getHandle").invoke(craftObject, new Object[0]);
/*  29 */     } catch (ReflectiveOperationException|IllegalArgumentException ex) {
/*  30 */       ex.printStackTrace();
/*  31 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Object getServer(Object o) {
/*     */     try {
/*  37 */       return getMethod(o.getClass(), "getServer").invoke(o, new Object[0]);
/*  38 */     } catch (ReflectiveOperationException|IllegalArgumentException ex) {
/*  39 */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Method getMethod(Class<?> c, String name) throws ReflectiveOperationException {
/*  44 */     return getMethod(c, name, -1);
/*     */   }
/*     */   
/*     */   public static void removeFinal(Field field) throws IllegalAccessException {
/*     */     try {
/*  49 */       Field modifiersField = Field.class.getDeclaredField("modifiers");
/*  50 */       modifiersField.setAccessible(true);
/*  51 */       modifiersField.setInt(field, field.getModifiers() & 0xFFFFFFEF);
/*  52 */     } catch (ReflectiveOperationException ex) {
/*  53 */       throw new IllegalAccessException("Modifying of field modifiers is not supported on your version of Java!");
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Method getMethod(Class<?> c, String name, int args) throws ReflectiveOperationException {
/*  58 */     for (Method method : c.getMethods()) {
/*  59 */       if (method.getName().equals(name) && (args == -1 || method.getParameterCount() == args)) {
/*  60 */         method.setAccessible(true);
/*  61 */         return method;
/*     */       } 
/*     */     } 
/*     */     
/*  65 */     for (Method method : c.getDeclaredMethods()) {
/*  66 */       if (method.getName().equals(name) && (args == -1 || method.getParameterCount() == args)) {
/*  67 */         method.setAccessible(true);
/*  68 */         return method;
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     throw new ReflectiveOperationException("Method " + name + " not found in " + c.getName());
/*     */   }
/*     */ 
/*     */   
/*     */   public static Method getMethod(Class<?> c, String name, Class<?>... argTypes) throws ReflectiveOperationException {
/*  77 */     for (Method method : c.getMethods()) {
/*  78 */       if (method.getName().equals(name) && Arrays.equals((Object[])method.getParameterTypes(), (Object[])argTypes)) {
/*  79 */         method.setAccessible(true);
/*  80 */         return method;
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     for (Method method : c.getDeclaredMethods()) {
/*  85 */       if (method.getName().equals(name) && Arrays.equals((Object[])method.getParameterTypes(), (Object[])argTypes)) {
/*  86 */         method.setAccessible(true);
/*  87 */         return method;
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     throw new ReflectiveOperationException("Method " + name + " not found in " + c.getName());
/*     */   }
/*     */   
/*     */   public static List<Field> getAnnotatedFields(Class<?> c, Class<? extends Annotation> annotation) {
/*  95 */     List<Field> fields = new ArrayList<>();
/*  96 */     for (Field field : c.getFields()) {
/*  97 */       if (field.isAnnotationPresent(annotation)) {
/*  98 */         field.setAccessible(true);
/*  99 */         fields.add(field);
/*     */       } 
/*     */     } 
/*     */     
/* 103 */     for (Field field : c.getDeclaredFields()) {
/* 104 */       if (field.isAnnotationPresent(annotation)) {
/* 105 */         field.setAccessible(true);
/* 106 */         fields.add(field);
/*     */       } 
/*     */     } 
/*     */     
/* 110 */     return fields;
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemappin\\utils\NMSUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */