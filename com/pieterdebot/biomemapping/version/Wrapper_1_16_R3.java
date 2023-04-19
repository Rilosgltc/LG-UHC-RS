/*     */ package com.pieterdebot.biomemapping.version;
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import com.pieterdebot.biomemapping.utils.NMSUtils;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import net.minecraft.server.v1_16_R3.BiomeBase;
/*     */ import net.minecraft.server.v1_16_R3.BiomeRegistry;
/*     */ import net.minecraft.server.v1_16_R3.Biomes;
/*     */ import net.minecraft.server.v1_16_R3.BiomesSettingsDefault;
/*     */ import net.minecraft.server.v1_16_R3.WorldGenSurfaceComposites;
/*     */ 
/*     */ public class Wrapper_1_16_R3 implements VersionWrapper {
/*     */   public boolean biomeSupported(Biome biome) {
/*     */     try {
/*  15 */       Biomes.class.getField(biome.name());
/*  16 */       return true;
/*  17 */     } catch (NoSuchFieldException ex) {
/*  18 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  24 */     Object newBiomeResourceKey = getResourceKey(newBiome);
/*     */     
/*  26 */     Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 3);
/*  27 */     registerMethod.invoke(null, new Object[] { Integer.valueOf(oldBiome.getId()), newBiomeResourceKey, getBiomeBase(newBiome) });
/*     */   }
/*     */   
/*     */   private Object getResourceKey(Biome biome) throws ReflectiveOperationException {
/*  31 */     Field field = Biomes.class.getField(biome.name());
/*  32 */     field.setAccessible(true);
/*  33 */     return field.get(null);
/*     */   }
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) {
/*  37 */     switch (biome) {
/*     */       case OCEAN:
/*  39 */         return BiomesSettingsDefault.c(false);
/*     */       case PLAINS:
/*  41 */         return BiomesSettingsDefault.a(false);
/*     */       case DESERT:
/*  43 */         return BiomesSettingsDefault.a(0.125F, 0.05F, true, true, true);
/*     */       case MOUNTAINS:
/*  45 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.m, false);
/*     */       case FOREST:
/*  47 */         return BiomesSettingsDefault.c(0.1F, 0.2F);
/*     */       case TAIGA:
/*  49 */         return BiomesSettingsDefault.a(0.2F, 0.2F, false, false, true, false);
/*     */       case SWAMP:
/*  51 */         return BiomesSettingsDefault.d(-0.2F, 0.1F, false);
/*     */       case RIVER:
/*  53 */         return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.5F, 4159204, false);
/*     */       case NETHER_WASTES:
/*  55 */         return BiomesSettingsDefault.s();
/*     */       case THE_END:
/*  57 */         return BiomesSettingsDefault.i();
/*     */       case FROZEN_OCEAN:
/*  59 */         return BiomesSettingsDefault.e(false);
/*     */       case FROZEN_RIVER:
/*  61 */         return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.0F, 3750089, true);
/*     */       case SNOWY_TUNDRA:
/*  63 */         return BiomesSettingsDefault.a(0.125F, 0.05F, false, false);
/*     */       case SNOWY_MOUNTAINS:
/*  65 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, true);
/*     */       case MUSHROOM_FIELDS:
/*  67 */         return BiomesSettingsDefault.a(0.2F, 0.3F);
/*     */       case MUSHROOM_FIELD_SHORE:
/*  69 */         return BiomesSettingsDefault.a(0.0F, 0.025F);
/*     */       case BEACH:
/*  71 */         return BiomesSettingsDefault.a(0.0F, 0.025F, 0.8F, 0.4F, 4159204, false, false);
/*     */       case DESERT_HILLS:
/*  73 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, true, false);
/*     */       case WOODED_HILLS:
/*  75 */         return BiomesSettingsDefault.c(0.45F, 0.3F);
/*     */       case TAIGA_HILLS:
/*  77 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, false, false, false);
/*     */       case MOUNTAIN_EDGE:
/*  79 */         return BiomesSettingsDefault.a(0.8F, 0.3F, WorldGenSurfaceComposites.j, true);
/*     */       case JUNGLE:
/*  81 */         return BiomesSettingsDefault.a();
/*     */       case JUNGLE_HILLS:
/*  83 */         return BiomesSettingsDefault.e();
/*     */       case JUNGLE_EDGE:
/*  85 */         return BiomesSettingsDefault.b();
/*     */       case DEEP_OCEAN:
/*  87 */         return BiomesSettingsDefault.c(true);
/*     */       case STONE_SHORE:
/*  89 */         return BiomesSettingsDefault.a(0.1F, 0.8F, 0.2F, 0.3F, 4159204, false, true);
/*     */       case SNOWY_BEACH:
/*  91 */         return BiomesSettingsDefault.a(0.0F, 0.025F, 0.05F, 0.3F, 4020182, true, false);
/*     */       case BIRCH_FOREST:
/*  93 */         return BiomesSettingsDefault.a(0.1F, 0.2F, false);
/*     */       case BIRCH_FOREST_HILLS:
/*  95 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false);
/*     */       case DARK_FOREST:
/*  97 */         return BiomesSettingsDefault.c(0.1F, 0.2F, false);
/*     */       case SNOWY_TAIGA:
/*  99 */         return BiomesSettingsDefault.a(0.2F, 0.2F, true, false, false, true);
/*     */       case SNOWY_TAIGA_HILLS:
/* 101 */         return BiomesSettingsDefault.a(0.45F, 0.3F, true, false, false, false);
/*     */       case GIANT_TREE_TAIGA:
/* 103 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.3F, false);
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 105 */         return BiomesSettingsDefault.a(0.45F, 0.3F, 0.3F, false);
/*     */       case WOODED_MOUNTAINS:
/* 107 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.j, true);
/*     */       case SAVANNA:
/* 109 */         return BiomesSettingsDefault.a(0.125F, 0.05F, 1.2F, false, false);
/*     */       case SAVANNA_PLATEAU:
/* 111 */         return BiomesSettingsDefault.m();
/*     */       case BADLANDS:
/* 113 */         return BiomesSettingsDefault.b(0.1F, 0.2F, false);
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 115 */         return BiomesSettingsDefault.b(1.5F, 0.025F);
/*     */       case BADLANDS_PLATEAU:
/* 117 */         return BiomesSettingsDefault.b(1.5F, 0.025F, true);
/*     */       case SMALL_END_ISLANDS:
/* 119 */         return BiomesSettingsDefault.l();
/*     */       case END_MIDLANDS:
/* 121 */         return BiomesSettingsDefault.j();
/*     */       case END_HIGHLANDS:
/* 123 */         return BiomesSettingsDefault.k();
/*     */       case END_BARRENS:
/* 125 */         return BiomesSettingsDefault.h();
/*     */       case WARM_OCEAN:
/* 127 */         return BiomesSettingsDefault.o();
/*     */       case LUKEWARM_OCEAN:
/* 129 */         return BiomesSettingsDefault.d(false);
/*     */       case COLD_OCEAN:
/* 131 */         return BiomesSettingsDefault.b(false);
/*     */       case DEEP_WARM_OCEAN:
/* 133 */         return BiomesSettingsDefault.p();
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 135 */         return BiomesSettingsDefault.d(true);
/*     */       case DEEP_COLD_OCEAN:
/* 137 */         return BiomesSettingsDefault.b(true);
/*     */       case DEEP_FROZEN_OCEAN:
/* 139 */         return BiomesSettingsDefault.e(true);
/*     */       case THE_VOID:
/* 141 */         return BiomesSettingsDefault.r();
/*     */       case SUNFLOWER_PLAINS:
/* 143 */         return BiomesSettingsDefault.a(true);
/*     */       case DESERT_LAKES:
/* 145 */         return BiomesSettingsDefault.a(0.225F, 0.25F, false, false, false);
/*     */       case GRAVELLY_MOUNTAINS:
/* 147 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
/*     */       case FLOWER_FOREST:
/* 149 */         return BiomesSettingsDefault.q();
/*     */       case TAIGA_MOUNTAINS:
/* 151 */         return BiomesSettingsDefault.a(0.3F, 0.4F, false, true, false, false);
/*     */       case SWAMP_HILLS:
/* 153 */         return BiomesSettingsDefault.d(-0.1F, 0.3F, true);
/*     */       case ICE_SPIKES:
/* 155 */         return BiomesSettingsDefault.a(0.425F, 0.45000002F, true, false);
/*     */       case MODIFIED_JUNGLE:
/* 157 */         return BiomesSettingsDefault.d();
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 159 */         return BiomesSettingsDefault.c();
/*     */       case TALL_BIRCH_FOREST:
/* 161 */         return BiomesSettingsDefault.a(0.2F, 0.4F, true);
/*     */       case TALL_BIRCH_HILLS:
/* 163 */         return BiomesSettingsDefault.a(0.55F, 0.5F, true);
/*     */       case DARK_FOREST_HILLS:
/* 165 */         return BiomesSettingsDefault.c(0.2F, 0.4F, true);
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 167 */         return BiomesSettingsDefault.a(0.3F, 0.4F, true, true, false, false);
/*     */       case GIANT_SPRUCE_TAIGA:
/* 169 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 171 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 173 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
/*     */       case SHATTERED_SAVANNA:
/* 175 */         return BiomesSettingsDefault.a(0.3625F, 1.225F, 1.1F, true, true);
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 177 */         return BiomesSettingsDefault.a(1.05F, 1.2125001F, 1.0F, true, true);
/*     */       case ERODED_BADLANDS:
/* 179 */         return BiomesSettingsDefault.n();
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 181 */         return BiomesSettingsDefault.b(0.45F, 0.3F);
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 183 */         return BiomesSettingsDefault.b(0.45F, 0.3F, true);
/*     */       case BAMBOO_JUNGLE:
/* 185 */         return BiomesSettingsDefault.f();
/*     */       case BAMBOO_JUNGLE_HILLS:
/* 187 */         return BiomesSettingsDefault.g();
/*     */       case SOUL_SAND_VALLEY:
/* 189 */         return BiomesSettingsDefault.t();
/*     */       case CRIMSON_FOREST:
/* 191 */         return BiomesSettingsDefault.v();
/*     */       case WARPED_FOREST:
/* 193 */         return BiomesSettingsDefault.w();
/*     */       case BASALT_DELTAS:
/* 195 */         return BiomesSettingsDefault.u();
/*     */     } 
/* 197 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_16_R3.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */