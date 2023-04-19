/*     */ package com.pieterdebot.biomemapping.version;
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import com.pieterdebot.biomemapping.utils.NMSUtils;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.v1_16_R1.BiomeBase;
/*     */ import net.minecraft.server.v1_16_R1.BiomeBirchForestHillsMutated;
/*     */ import net.minecraft.server.v1_16_R1.BiomeMesaPlataeu;
/*     */ import net.minecraft.server.v1_16_R1.Biomes;
/*     */ 
/*     */ public class Wrapper_1_16_R1 implements VersionWrapper {
/*  14 */   private static final Biome[] HASH_SET_BIOMES = new Biome[] { Biome.OCEAN, Biome.PLAINS, Biome.DESERT, Biome.MOUNTAINS, Biome.FOREST, Biome.TAIGA, Biome.SWAMP, Biome.RIVER, Biome.FROZEN_RIVER, Biome.SNOWY_TUNDRA, Biome.SNOWY_MOUNTAINS, Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE, Biome.BEACH, Biome.DESERT_HILLS, Biome.WOODED_HILLS, Biome.TAIGA_HILLS, Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.DEEP_OCEAN, Biome.STONE_SHORE, Biome.SNOWY_BEACH, Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.DARK_FOREST, Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.WOODED_MOUNTAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.BADLANDS, Biome.WOODED_BADLANDS_PLATEAU, Biome.BADLANDS_PLATEAU };
/*     */ 
/*     */   
/*     */   public boolean biomeSupported(Biome biome) {
/*     */     try {
/*  19 */       Biomes.class.getField(biome.name());
/*  20 */       return true;
/*  21 */     } catch (NoSuchFieldException ex) {
/*  22 */       return false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  28 */     Method registerMethod = NMSUtils.getMethod(Biomes.class, "a");
/*     */     
/*  30 */     Field biomeBaseHashSet = BiomeBase.class.getField("c");
/*  31 */     NMSUtils.removeFinal(biomeBaseHashSet);
/*     */ 
/*     */     
/*  34 */     Field oldBiomeField = getField(oldBiome);
/*     */ 
/*     */     
/*  37 */     Object newBiomeBase = registerMethod.invoke(null, new Object[] { Integer.valueOf(oldBiome.getId()), oldBiome.name().toLowerCase(), getBiomeBase(newBiome) });
/*     */     
/*  39 */     oldBiomeField.set(null, newBiomeBase);
/*     */     
/*  41 */     Set<Object> hashSet = (Set<Object>)biomeBaseHashSet.get(null);
/*  42 */     hashSet.clear();
/*  43 */     for (Biome biome : HASH_SET_BIOMES) {
/*  44 */       hashSet.add(getField(biome).get(null));
/*     */     }
/*     */     
/*  47 */     biomeBaseHashSet.set(null, hashSet);
/*     */   }
/*     */   
/*     */   private Field getField(Biome biome) throws ReflectiveOperationException {
/*  51 */     Field field = Biomes.class.getField(biome.name());
/*  52 */     field.setAccessible(true);
/*  53 */     NMSUtils.removeFinal(field);
/*  54 */     return field;
/*     */   }
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException {
/*  58 */     switch (biome) {
/*     */       case OCEAN:
/*  60 */         return (BiomeBase)new BiomeOcean();
/*     */       case PLAINS:
/*  62 */         return getBiomeBaseInstance((Class)BiomePlains.class);
/*     */       case DESERT:
/*  64 */         return (BiomeBase)new BiomeDesert();
/*     */       case MOUNTAINS:
/*  66 */         return getBiomeBaseInstance((Class)BiomeBigHills.class);
/*     */       case FOREST:
/*  68 */         return (BiomeBase)new BiomeForest();
/*     */       case TAIGA:
/*  70 */         return (BiomeBase)new BiomeTaiga();
/*     */       case SWAMP:
/*  72 */         return getBiomeBaseInstance((Class)BiomeSwamp.class);
/*     */       case RIVER:
/*  74 */         return (BiomeBase)new BiomeRiver();
/*     */       case NETHER_WASTES:
/*  76 */         return getBiomeBaseInstance((Class)BiomeHell.class);
/*     */       case THE_END:
/*  78 */         return (BiomeBase)new BiomeTheEnd();
/*     */       case FROZEN_OCEAN:
/*  80 */         return (BiomeBase)new BiomeFrozenOcean();
/*     */       case FROZEN_RIVER:
/*  82 */         return (BiomeBase)new BiomeFrozenRiver();
/*     */       case SNOWY_TUNDRA:
/*  84 */         return (BiomeBase)new BiomeIcePlains();
/*     */       case SNOWY_MOUNTAINS:
/*  86 */         return (BiomeBase)new BiomeIceMountains();
/*     */       case MUSHROOM_FIELDS:
/*  88 */         return (BiomeBase)new BiomeMushrooms();
/*     */       case MUSHROOM_FIELD_SHORE:
/*  90 */         return (BiomeBase)new BiomeMushroomIslandShore();
/*     */       case BEACH:
/*  92 */         return (BiomeBase)new BiomeBeach();
/*     */       case DESERT_HILLS:
/*  94 */         return (BiomeBase)new BiomeDesertHills();
/*     */       case WOODED_HILLS:
/*  96 */         return (BiomeBase)new BiomeForestHills();
/*     */       case TAIGA_HILLS:
/*  98 */         return (BiomeBase)new BiomeTaigaHills();
/*     */       case MOUNTAIN_EDGE:
/* 100 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsEdge.class);
/*     */       case JUNGLE:
/* 102 */         return (BiomeBase)new BiomeJungle();
/*     */       case JUNGLE_HILLS:
/* 104 */         return (BiomeBase)new BiomeJungleHills();
/*     */       case JUNGLE_EDGE:
/* 106 */         return (BiomeBase)new BiomeJungleEdge();
/*     */       case DEEP_OCEAN:
/* 108 */         return (BiomeBase)new BiomeDeepOcean();
/*     */       case STONE_SHORE:
/* 110 */         return (BiomeBase)new BiomeStoneBeach();
/*     */       case SNOWY_BEACH:
/* 112 */         return (BiomeBase)new BiomeColdBeach();
/*     */       case BIRCH_FOREST:
/* 114 */         return (BiomeBase)new BiomeBirchForest();
/*     */       case BIRCH_FOREST_HILLS:
/* 116 */         return (BiomeBase)new BiomeBirchForestHills();
/*     */       case DARK_FOREST:
/* 118 */         return (BiomeBase)new BiomeRoofedForest();
/*     */       case SNOWY_TAIGA:
/* 120 */         return (BiomeBase)new BiomeColdTaiga();
/*     */       case SNOWY_TAIGA_HILLS:
/* 122 */         return (BiomeBase)new BiomeColdTaigaHills();
/*     */       case GIANT_TREE_TAIGA:
/* 124 */         return (BiomeBase)new BiomeMegaTaiga();
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 126 */         return (BiomeBase)new BiomeMegaTaigaHills();
/*     */       case WOODED_MOUNTAINS:
/* 128 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsWithTrees.class);
/*     */       case SAVANNA:
/* 130 */         return getBiomeBaseInstance((Class)BiomeSavanna.class);
/*     */       case SAVANNA_PLATEAU:
/* 132 */         return getBiomeBaseInstance((Class)BiomeSavannaPlateau.class);
/*     */       case BADLANDS:
/* 134 */         return (BiomeBase)new BiomeMesa();
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 136 */         return (BiomeBase)new BiomeMesaPlataeu();
/*     */       case BADLANDS_PLATEAU:
/* 138 */         return (BiomeBase)new BiomeMesaPlataeuClear();
/*     */       case SMALL_END_ISLANDS:
/* 140 */         return (BiomeBase)new BiomeTheEndFloatingIslands();
/*     */       case END_MIDLANDS:
/* 142 */         return (BiomeBase)new BiomeTheEndMediumIsland();
/*     */       case END_HIGHLANDS:
/* 144 */         return (BiomeBase)new BiomeTheEndHighIsland();
/*     */       case END_BARRENS:
/* 146 */         return (BiomeBase)new BiomeTheEndBarrenIsland();
/*     */       case WARM_OCEAN:
/* 148 */         return (BiomeBase)new BiomeWarmOcean();
/*     */       case LUKEWARM_OCEAN:
/* 150 */         return (BiomeBase)new BiomeLukewarmOcean();
/*     */       case COLD_OCEAN:
/* 152 */         return (BiomeBase)new BiomeColdOcean();
/*     */       case DEEP_WARM_OCEAN:
/* 154 */         return (BiomeBase)new BiomeWarmDeepOcean();
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 156 */         return (BiomeBase)new BiomeLukewarmDeepOcean();
/*     */       case DEEP_COLD_OCEAN:
/* 158 */         return (BiomeBase)new BiomeColdDeepOcean();
/*     */       case DEEP_FROZEN_OCEAN:
/* 160 */         return (BiomeBase)new BiomeFrozenDeepOcean();
/*     */       case THE_VOID:
/* 162 */         return (BiomeBase)new BiomeVoid();
/*     */       case SUNFLOWER_PLAINS:
/* 164 */         return getBiomeBaseInstance((Class)BiomeSunflowerPlains.class);
/*     */       case DESERT_LAKES:
/* 166 */         return (BiomeBase)new BiomeDesertMutated();
/*     */       case GRAVELLY_MOUNTAINS:
/* 168 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsMutated.class);
/*     */       case FLOWER_FOREST:
/* 170 */         return (BiomeBase)new BiomeFlowerForest();
/*     */       case TAIGA_MOUNTAINS:
/* 172 */         return (BiomeBase)new BiomeTaigaMutated();
/*     */       case SWAMP_HILLS:
/* 174 */         return getBiomeBaseInstance((Class)BiomeSwamplandMutated.class);
/*     */       case ICE_SPIKES:
/* 176 */         return (BiomeBase)new BiomeIcePlainsSpikes();
/*     */       case MODIFIED_JUNGLE:
/* 178 */         return (BiomeBase)new BiomeJungleMutated();
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 180 */         return (BiomeBase)new BiomeJungleEdgeMutated();
/*     */       case TALL_BIRCH_FOREST:
/* 182 */         return (BiomeBase)new BiomeBirchForestMutated();
/*     */       case TALL_BIRCH_HILLS:
/* 184 */         return (BiomeBase)new BiomeBirchForestHillsMutated();
/*     */       case DARK_FOREST_HILLS:
/* 186 */         return (BiomeBase)new BiomeBirchForestHillsMutated();
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 188 */         return (BiomeBase)new BiomeColdTaigaMutated();
/*     */       case GIANT_SPRUCE_TAIGA:
/* 190 */         return (BiomeBase)new BiomeMegaSpruceTaiga();
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 192 */         return (BiomeBase)new BiomeRedwoodTaigaHillsMutated();
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 194 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsWithTreesMutated.class);
/*     */       case SHATTERED_SAVANNA:
/* 196 */         return (BiomeBase)new BiomeSavannaMutated();
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 198 */         return (BiomeBase)new BiomeSavannaPlateauMutated();
/*     */       case ERODED_BADLANDS:
/* 200 */         return (BiomeBase)new BiomeMesaBryce();
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 202 */         return (BiomeBase)new BiomeMesaPlateauMutated();
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 204 */         return (BiomeBase)new BiomeMesaPlateauClearMutated();
/*     */       case BAMBOO_JUNGLE:
/* 206 */         return (BiomeBase)new BiomeBambooJungle();
/*     */       case BAMBOO_JUNGLE_HILLS:
/* 208 */         return (BiomeBase)new BiomeBambooJungleHills();
/*     */       case SOUL_SAND_VALLEY:
/* 210 */         return getBiomeBaseInstance((Class)BiomeSoulSandValley.class);
/*     */       case CRIMSON_FOREST:
/* 212 */         return getBiomeBaseInstance((Class)BiomeCrimsonForest.class);
/*     */       case WARPED_FOREST:
/* 214 */         return getBiomeBaseInstance((Class)BiomeWarpedForest.class);
/*     */       case BASALT_DELTAS:
/* 216 */         return getBiomeBaseInstance((Class)BiomeBasaltDeltas.class);
/*     */     } 
/* 218 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ 
/*     */   
/*     */   private BiomeBase getBiomeBaseInstance(Class<? extends BiomeBase> biomeBaseClass) throws ReflectiveOperationException {
/* 223 */     Constructor<?> constructor = biomeBaseClass.getDeclaredConstructor(new Class[0]);
/* 224 */     constructor.setAccessible(true);
/*     */     
/* 226 */     return (BiomeBase)constructor.newInstance(new Object[0]);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_16_R1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */