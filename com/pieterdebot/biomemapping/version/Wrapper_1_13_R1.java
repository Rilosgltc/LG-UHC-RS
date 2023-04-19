/*     */ package com.pieterdebot.biomemapping.version;
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import com.pieterdebot.biomemapping.utils.NMSUtils;
/*     */ import java.lang.reflect.Constructor;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.Set;
/*     */ import net.minecraft.server.v1_13_R1.BiomeBase;
/*     */ import net.minecraft.server.v1_13_R1.BiomeBirchForestHillsMutated;
/*     */ import net.minecraft.server.v1_13_R1.BiomeMushroomIslandShore;
/*     */ import net.minecraft.server.v1_13_R1.BiomePlains;
/*     */ 
/*     */ public class Wrapper_1_13_R1 implements VersionWrapper {
/*  14 */   private static final Biome[] HASH_SET_BIOMES = new Biome[] { Biome.OCEAN, Biome.PLAINS, Biome.DESERT, Biome.MOUNTAINS, Biome.FOREST, Biome.TAIGA, Biome.SWAMP, Biome.RIVER, Biome.FROZEN_RIVER, Biome.SNOWY_TUNDRA, Biome.SNOWY_MOUNTAINS, Biome.MUSHROOM_FIELDS, Biome.MUSHROOM_FIELD_SHORE, Biome.BEACH, Biome.DESERT_HILLS, Biome.WOODED_HILLS, Biome.TAIGA_HILLS, Biome.JUNGLE, Biome.JUNGLE_HILLS, Biome.JUNGLE_EDGE, Biome.DEEP_OCEAN, Biome.STONE_SHORE, Biome.SNOWY_BEACH, Biome.BIRCH_FOREST, Biome.BIRCH_FOREST_HILLS, Biome.DARK_FOREST, Biome.SNOWY_TAIGA, Biome.SNOWY_TAIGA_HILLS, Biome.GIANT_TREE_TAIGA, Biome.GIANT_TREE_TAIGA_HILLS, Biome.WOODED_MOUNTAINS, Biome.SAVANNA, Biome.SAVANNA_PLATEAU, Biome.BADLANDS, Biome.WOODED_BADLANDS_PLATEAU, Biome.BADLANDS_PLATEAU };
/*     */ 
/*     */   
/*     */   public boolean biomeSupported(Biome biome) {
/*  18 */     return (getBiomeField(biome) != null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  24 */     Method registerMethod = NMSUtils.getMethod(BiomeBase.class, "a", new Class[] { int.class, String.class, BiomeBase.class });
/*     */     
/*  26 */     Field biomeBaseHashSet = BiomeBase.class.getField("aG");
/*  27 */     NMSUtils.removeFinal(biomeBaseHashSet);
/*     */ 
/*     */     
/*  30 */     registerMethod.invoke(null, new Object[] { Integer.valueOf(oldBiome.getId()), oldBiome.name().toLowerCase(), getBiomeBase(newBiome) });
/*     */     
/*  32 */     Set<Object> hashSet = (Set<Object>)biomeBaseHashSet.get(null);
/*  33 */     hashSet.clear();
/*  34 */     for (Biome biome : HASH_SET_BIOMES) {
/*  35 */       hashSet.add(getField(biome).get(null));
/*     */     }
/*     */     
/*  38 */     biomeBaseHashSet.set(null, hashSet);
/*     */   }
/*     */   
/*     */   private Field getField(Biome biome) throws ReflectiveOperationException {
/*  42 */     Field field = Biomes.class.getField(getBiomeField(biome));
/*  43 */     field.setAccessible(true);
/*  44 */     NMSUtils.removeFinal(field);
/*  45 */     return field;
/*     */   }
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) throws ReflectiveOperationException {
/*  49 */     switch (biome) {
/*     */       case OCEAN:
/*  51 */         return (BiomeBase)new BiomeOcean();
/*     */       case PLAINS:
/*  53 */         return getBiomeBaseInstance((Class)BiomePlains.class);
/*     */       case DESERT:
/*  55 */         return (BiomeBase)new BiomeDesert();
/*     */       case MOUNTAINS:
/*  57 */         return getBiomeBaseInstance((Class)BiomeBigHills.class);
/*     */       case FOREST:
/*  59 */         return (BiomeBase)new BiomeForest();
/*     */       case TAIGA:
/*  61 */         return (BiomeBase)new BiomeTaiga();
/*     */       case SWAMP:
/*  63 */         return getBiomeBaseInstance((Class)BiomeSwamp.class);
/*     */       case RIVER:
/*  65 */         return (BiomeBase)new BiomeRiver();
/*     */       case NETHER_WASTES:
/*  67 */         return getBiomeBaseInstance((Class)BiomeHell.class);
/*     */       case THE_END:
/*  69 */         return (BiomeBase)new BiomeTheEnd();
/*     */       case FROZEN_OCEAN:
/*  71 */         return (BiomeBase)new BiomeFrozenOcean();
/*     */       case FROZEN_RIVER:
/*  73 */         return (BiomeBase)new BiomeFrozenRiver();
/*     */       case SNOWY_TUNDRA:
/*  75 */         return (BiomeBase)new BiomeIcePlains();
/*     */       case SNOWY_MOUNTAINS:
/*  77 */         return (BiomeBase)new BiomeIceMountains();
/*     */       case MUSHROOM_FIELDS:
/*  79 */         return (BiomeBase)new BiomeMushrooms();
/*     */       case MUSHROOM_FIELD_SHORE:
/*  81 */         return (BiomeBase)new BiomeMushroomIslandShore();
/*     */       case BEACH:
/*  83 */         return (BiomeBase)new BiomeBeach();
/*     */       case DESERT_HILLS:
/*  85 */         return (BiomeBase)new BiomeDesertHills();
/*     */       case WOODED_HILLS:
/*  87 */         return (BiomeBase)new BiomeForestHills();
/*     */       case TAIGA_HILLS:
/*  89 */         return (BiomeBase)new BiomeTaigaHills();
/*     */       case MOUNTAIN_EDGE:
/*  91 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsEdge.class);
/*     */       case JUNGLE:
/*  93 */         return (BiomeBase)new BiomeJungle();
/*     */       case JUNGLE_HILLS:
/*  95 */         return (BiomeBase)new BiomeJungleHills();
/*     */       case JUNGLE_EDGE:
/*  97 */         return (BiomeBase)new BiomeJungleEdge();
/*     */       case DEEP_OCEAN:
/*  99 */         return (BiomeBase)new BiomeDeepOcean();
/*     */       case STONE_SHORE:
/* 101 */         return (BiomeBase)new BiomeStoneBeach();
/*     */       case SNOWY_BEACH:
/* 103 */         return (BiomeBase)new BiomeColdBeach();
/*     */       case BIRCH_FOREST:
/* 105 */         return (BiomeBase)new BiomeBirchForest();
/*     */       case BIRCH_FOREST_HILLS:
/* 107 */         return (BiomeBase)new BiomeBirchForestHills();
/*     */       case DARK_FOREST:
/* 109 */         return (BiomeBase)new BiomeRoofedForest();
/*     */       case SNOWY_TAIGA:
/* 111 */         return (BiomeBase)new BiomeColdTaiga();
/*     */       case SNOWY_TAIGA_HILLS:
/* 113 */         return (BiomeBase)new BiomeColdTaigaHills();
/*     */       case GIANT_TREE_TAIGA:
/* 115 */         return (BiomeBase)new BiomeMegaTaiga();
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 117 */         return (BiomeBase)new BiomeMegaTaigaHills();
/*     */       case WOODED_MOUNTAINS:
/* 119 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsWithTrees.class);
/*     */       case SAVANNA:
/* 121 */         return getBiomeBaseInstance((Class)BiomeSavanna.class);
/*     */       case SAVANNA_PLATEAU:
/* 123 */         return getBiomeBaseInstance((Class)BiomeSavannaPlateau.class);
/*     */       case BADLANDS:
/* 125 */         return (BiomeBase)new BiomeMesa();
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 127 */         return (BiomeBase)new BiomeMesaPlataeu();
/*     */       case BADLANDS_PLATEAU:
/* 129 */         return (BiomeBase)new BiomeMesaPlataeuClear();
/*     */       case SMALL_END_ISLANDS:
/* 131 */         return (BiomeBase)new BiomeTheEndFloatingIslands();
/*     */       case END_MIDLANDS:
/* 133 */         return (BiomeBase)new BiomeTheEndMediumIsland();
/*     */       case END_HIGHLANDS:
/* 135 */         return (BiomeBase)new BiomeTheEndHighIsland();
/*     */       case END_BARRENS:
/* 137 */         return (BiomeBase)new BiomeTheEndBarrenIsland();
/*     */       case WARM_OCEAN:
/* 139 */         return (BiomeBase)new BiomeWarmOcean();
/*     */       case LUKEWARM_OCEAN:
/* 141 */         return (BiomeBase)new BiomeLukewarmOcean();
/*     */       case COLD_OCEAN:
/* 143 */         return (BiomeBase)new BiomeColdOcean();
/*     */       case DEEP_WARM_OCEAN:
/* 145 */         return (BiomeBase)new BiomeWarmDeepOcean();
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 147 */         return (BiomeBase)new BiomeLukewarmDeepOcean();
/*     */       case DEEP_COLD_OCEAN:
/* 149 */         return (BiomeBase)new BiomeColdDeepOcean();
/*     */       case DEEP_FROZEN_OCEAN:
/* 151 */         return (BiomeBase)new BiomeFrozenDeepOcean();
/*     */       case THE_VOID:
/* 153 */         return (BiomeBase)new BiomeVoid();
/*     */       case SUNFLOWER_PLAINS:
/* 155 */         return getBiomeBaseInstance((Class)BiomeSunflowerPlains.class);
/*     */       case DESERT_LAKES:
/* 157 */         return (BiomeBase)new BiomeDesertMutated();
/*     */       case GRAVELLY_MOUNTAINS:
/* 159 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsMutated.class);
/*     */       case FLOWER_FOREST:
/* 161 */         return (BiomeBase)new BiomeFlowerForest();
/*     */       case TAIGA_MOUNTAINS:
/* 163 */         return (BiomeBase)new BiomeTaigaMutated();
/*     */       case SWAMP_HILLS:
/* 165 */         return getBiomeBaseInstance((Class)BiomeSwamplandMutated.class);
/*     */       case ICE_SPIKES:
/* 167 */         return (BiomeBase)new BiomeIcePlainsSpikes();
/*     */       case MODIFIED_JUNGLE:
/* 169 */         return (BiomeBase)new BiomeJungleMutated();
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 171 */         return (BiomeBase)new BiomeJungleEdgeMutated();
/*     */       case TALL_BIRCH_FOREST:
/* 173 */         return (BiomeBase)new BiomeBirchForestMutated();
/*     */       case TALL_BIRCH_HILLS:
/* 175 */         return (BiomeBase)new BiomeBirchForestHillsMutated();
/*     */       case DARK_FOREST_HILLS:
/* 177 */         return (BiomeBase)new BiomeBirchForestHillsMutated();
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 179 */         return (BiomeBase)new BiomeColdTaigaMutated();
/*     */       case GIANT_SPRUCE_TAIGA:
/* 181 */         return (BiomeBase)new BiomeMegaSpruceTaiga();
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 183 */         return (BiomeBase)new BiomeRedwoodTaigaHillsMutated();
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 185 */         return getBiomeBaseInstance((Class)BiomeExtremeHillsWithTreesMutated.class);
/*     */       case SHATTERED_SAVANNA:
/* 187 */         return (BiomeBase)new BiomeSavannaMutated();
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 189 */         return (BiomeBase)new BiomeSavannaPlateauMutated();
/*     */       case ERODED_BADLANDS:
/* 191 */         return (BiomeBase)new BiomeMesaBryce();
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 193 */         return (BiomeBase)new BiomeMesaPlateauMutated();
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 195 */         return (BiomeBase)new BiomeMesaPlateauClearMutated();
/*     */     } 
/* 197 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ 
/*     */   
/*     */   private BiomeBase getBiomeBaseInstance(Class<? extends BiomeBase> biomeBaseClass) throws ReflectiveOperationException {
/* 202 */     Constructor<?> constructor = biomeBaseClass.getDeclaredConstructor(new Class[0]);
/* 203 */     constructor.setAccessible(true);
/*     */     
/* 205 */     return (BiomeBase)constructor.newInstance(new Object[0]);
/*     */   }
/*     */   
/*     */   private String getBiomeField(Biome biome) {
/* 209 */     switch (biome) {
/*     */       case OCEAN:
/* 211 */         return "a";
/*     */       case PLAINS:
/* 213 */         return "c";
/*     */       case DESERT:
/* 215 */         return "d";
/*     */       case MOUNTAINS:
/* 217 */         return "e";
/*     */       case FOREST:
/* 219 */         return "f";
/*     */       case TAIGA:
/* 221 */         return "g";
/*     */       case SWAMP:
/* 223 */         return "h";
/*     */       case RIVER:
/* 225 */         return "i";
/*     */       case NETHER_WASTES:
/* 227 */         return "j";
/*     */       case THE_END:
/* 229 */         return "k";
/*     */       case FROZEN_OCEAN:
/* 231 */         return "l";
/*     */       case FROZEN_RIVER:
/* 233 */         return "m";
/*     */       case SNOWY_TUNDRA:
/* 235 */         return "n";
/*     */       case SNOWY_MOUNTAINS:
/* 237 */         return "o";
/*     */       case MUSHROOM_FIELDS:
/* 239 */         return "p";
/*     */       case MUSHROOM_FIELD_SHORE:
/* 241 */         return "q";
/*     */       case BEACH:
/* 243 */         return "r";
/*     */       case DESERT_HILLS:
/* 245 */         return "s";
/*     */       case WOODED_HILLS:
/* 247 */         return "t";
/*     */       case TAIGA_HILLS:
/* 249 */         return "u";
/*     */       case MOUNTAIN_EDGE:
/* 251 */         return "v";
/*     */       case JUNGLE:
/* 253 */         return "w";
/*     */       case JUNGLE_HILLS:
/* 255 */         return "x";
/*     */       case JUNGLE_EDGE:
/* 257 */         return "y";
/*     */       case DEEP_OCEAN:
/* 259 */         return "z";
/*     */       case STONE_SHORE:
/* 261 */         return "A";
/*     */       case SNOWY_BEACH:
/* 263 */         return "B";
/*     */       case BIRCH_FOREST:
/* 265 */         return "C";
/*     */       case BIRCH_FOREST_HILLS:
/* 267 */         return "D";
/*     */       case DARK_FOREST:
/* 269 */         return "E";
/*     */       case SNOWY_TAIGA:
/* 271 */         return "F";
/*     */       case SNOWY_TAIGA_HILLS:
/* 273 */         return "G";
/*     */       case GIANT_TREE_TAIGA:
/* 275 */         return "H";
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 277 */         return "I";
/*     */       case WOODED_MOUNTAINS:
/* 279 */         return "J";
/*     */       case SAVANNA:
/* 281 */         return "K";
/*     */       case SAVANNA_PLATEAU:
/* 283 */         return "L";
/*     */       case BADLANDS:
/* 285 */         return "M";
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 287 */         return "N";
/*     */       case BADLANDS_PLATEAU:
/* 289 */         return "O";
/*     */       case SMALL_END_ISLANDS:
/* 291 */         return "P";
/*     */       case END_MIDLANDS:
/* 293 */         return "Q";
/*     */       case END_HIGHLANDS:
/* 295 */         return "R";
/*     */       case END_BARRENS:
/* 297 */         return "S";
/*     */       case WARM_OCEAN:
/* 299 */         return "T";
/*     */       case LUKEWARM_OCEAN:
/* 301 */         return "U";
/*     */       case COLD_OCEAN:
/* 303 */         return "V";
/*     */       case DEEP_WARM_OCEAN:
/* 305 */         return "W";
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 307 */         return "X";
/*     */       case DEEP_COLD_OCEAN:
/* 309 */         return "Y";
/*     */       case DEEP_FROZEN_OCEAN:
/* 311 */         return "Z";
/*     */       case THE_VOID:
/* 313 */         return "aa";
/*     */       case SUNFLOWER_PLAINS:
/* 315 */         return "ab";
/*     */       case DESERT_LAKES:
/* 317 */         return "ac";
/*     */       case GRAVELLY_MOUNTAINS:
/* 319 */         return "ad";
/*     */       case FLOWER_FOREST:
/* 321 */         return "ae";
/*     */       case TAIGA_MOUNTAINS:
/* 323 */         return "af";
/*     */       case SWAMP_HILLS:
/* 325 */         return "ag";
/*     */       case ICE_SPIKES:
/* 327 */         return "ah";
/*     */       case MODIFIED_JUNGLE:
/* 329 */         return "ai";
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 331 */         return "aj";
/*     */       case TALL_BIRCH_FOREST:
/* 333 */         return "ak";
/*     */       case TALL_BIRCH_HILLS:
/* 335 */         return "al";
/*     */       case DARK_FOREST_HILLS:
/* 337 */         return "am";
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 339 */         return "an";
/*     */       case GIANT_SPRUCE_TAIGA:
/* 341 */         return "ao";
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 343 */         return "ap";
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 345 */         return "aq";
/*     */       case SHATTERED_SAVANNA:
/* 347 */         return "ar";
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 349 */         return "as";
/*     */       case ERODED_BADLANDS:
/* 351 */         return "at";
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 353 */         return "au";
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 355 */         return "av";
/*     */     } 
/* 357 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_13_R1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */