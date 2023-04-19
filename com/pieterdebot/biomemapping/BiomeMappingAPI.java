/*    */ package com.pieterdebot.biomemapping;
/*    */ 
/*    */ import com.pieterdebot.biomemapping.version.VersionWrapper;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_10_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_11_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_12_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_13_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_13_R2;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_14_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_15_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_16_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_16_R2;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_16_R3;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_17_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_18_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_18_R2;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_19_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_8_R3;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_9_R1;
/*    */ import com.pieterdebot.biomemapping.version.Wrapper_1_9_R2;
/*    */ import org.bukkit.Bukkit;
/*    */ 
/*    */ public class BiomeMappingAPI
/*    */   implements VersionWrapper {
/*    */   private static final String v1_8_R3 = "v1_8_R3";
/*    */   private static final String v1_9_R1 = "v1_9_R1";
/*    */   private static final String v1_9_R2 = "v1_9_R2";
/*    */   private static final String v1_10_R1 = "v1_10_R1";
/* 29 */   private final VersionWrapper wrapper = getWrapper(); private static final String v1_11_R1 = "v1_11_R1"; private static final String v1_12_R1 = "v1_12_R1"; private static final String v1_13_R1 = "v1_13_R1"; private static final String v1_13_R2 = "v1_13_R2"; private static final String v1_14_R1 = "v1_14_R1"; private static final String v1_15_R1 = "v1_15_R1";
/*    */   private static final String v1_16_R1 = "v1_16_R1";
/*    */   private static final String v1_16_R2 = "v1_16_R2";
/*    */   private static final String v1_16_R3 = "v1_16_R3";
/*    */   private static final String v1_17_R1 = "v1_17_R1";
/*    */   private static final String v1_18_R1 = "v1_18_R1";
/*    */   private static final String v1_18_R2 = "v1_18_R2";
/*    */   private static final String v1_19_R1 = "v1_19_R1";
/*    */   
/*    */   public boolean biomeSupported(Biome biome) {
/* 39 */     return this.wrapper.biomeSupported(biome);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/* 51 */     this.wrapper.replaceBiomes(oldBiome, newBiome);
/*    */   }
/*    */   
/*    */   private VersionWrapper getWrapper() {
/* 55 */     String name = Bukkit.getServer().getClass().getPackage().getName();
/* 56 */     String version = name.substring(name.lastIndexOf('.') + 1);
/*    */     
/* 58 */     switch (version) {
/*    */       case "v1_8_R3":
/* 60 */         return (VersionWrapper)new Wrapper_1_8_R3();
/*    */       case "v1_9_R1":
/* 62 */         return (VersionWrapper)new Wrapper_1_9_R1();
/*    */       case "v1_9_R2":
/* 64 */         return (VersionWrapper)new Wrapper_1_9_R2();
/*    */       case "v1_10_R1":
/* 66 */         return (VersionWrapper)new Wrapper_1_10_R1();
/*    */       case "v1_11_R1":
/* 68 */         return (VersionWrapper)new Wrapper_1_11_R1();
/*    */       case "v1_12_R1":
/* 70 */         return (VersionWrapper)new Wrapper_1_12_R1();
/*    */       case "v1_13_R1":
/* 72 */         return (VersionWrapper)new Wrapper_1_13_R1();
/*    */       case "v1_13_R2":
/* 74 */         return (VersionWrapper)new Wrapper_1_13_R2();
/*    */       case "v1_14_R1":
/* 76 */         return (VersionWrapper)new Wrapper_1_14_R1();
/*    */       case "v1_15_R1":
/* 78 */         return (VersionWrapper)new Wrapper_1_15_R1();
/*    */       case "v1_16_R1":
/* 80 */         return (VersionWrapper)new Wrapper_1_16_R1();
/*    */       case "v1_16_R2":
/* 82 */         return (VersionWrapper)new Wrapper_1_16_R2();
/*    */       case "v1_16_R3":
/* 84 */         return (VersionWrapper)new Wrapper_1_16_R3();
/*    */       case "v1_17_R1":
/* 86 */         return (VersionWrapper)new Wrapper_1_17_R1();
/*    */       case "v1_18_R1":
/* 88 */         return (VersionWrapper)new Wrapper_1_18_R1();
/*    */       case "v1_18_R2":
/* 90 */         return (VersionWrapper)new Wrapper_1_18_R2();
/*    */       case "v1_19_R1":
/* 92 */         return (VersionWrapper)new Wrapper_1_19_R1();
/*    */     } 
/*    */     
/* 95 */     throw new RuntimeException("Version " + version + " is not supported!");
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\BiomeMappingAPI.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */