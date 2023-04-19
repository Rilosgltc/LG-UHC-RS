/*    */ package com.pieterdebot.biomemapping.version;
/*    */ 
/*    */ import com.pieterdebot.biomemapping.Biome;
/*    */ import java.lang.reflect.Field;
/*    */ import net.minecraft.server.v1_8_R3.BiomeBase;
/*    */ 
/*    */ 
/*    */ public class Wrapper_1_8_R3
/*    */   implements VersionWrapper
/*    */ {
/*    */   public boolean biomeSupported(Biome biome) {
/*    */     try {
/* 13 */       getBiomeBase(biome);
/* 14 */       return true;
/* 15 */     } catch (ReflectiveOperationException ex) {
/* 16 */       return false;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/* 22 */     BiomeBase[] biomes = BiomeBase.getBiomes();
/*    */     
/* 24 */     BiomeBase newBiomeBase = getBiomeBase(newBiome);
/*    */     
/* 26 */     biomes[oldBiome.getId()] = newBiomeBase;
/*    */   }
/*    */   
/*    */   private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException {
/* 30 */     Field field = BiomeBase.class.getField(biome.getOldName());
/* 31 */     field.setAccessible(true);
/* 32 */     return (BiomeBase)field.get(null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_8_R3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */