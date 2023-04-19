/*     */ package com.pieterdebot.biomemapping.version;
/*     */ 
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import com.pieterdebot.biomemapping.utils.NMSUtils;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import net.minecraft.data.worldgen.WorldGenSurfaceComposites;
/*     */ import net.minecraft.data.worldgen.biome.BiomeRegistry;
/*     */ import net.minecraft.data.worldgen.biome.BiomesSettingsDefault;
/*     */ import net.minecraft.world.level.biome.BiomeBase;
/*     */ import net.minecraft.world.level.biome.Biomes;
/*     */ 
/*     */ 
/*     */ public class Wrapper_1_17_R1
/*     */   implements VersionWrapper
/*     */ {
/*     */   public boolean biomeSupported(Biome biome) {
/*  18 */     return (getBiomeField(biome) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  23 */     Object newBiomeResourceKey = getResourceKey(newBiome);
/*     */     
/*  25 */     Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 3);
/*  26 */     registerMethod.invoke(null, new Object[] { Integer.valueOf(oldBiome.getId()), newBiomeResourceKey, getBiomeBase(newBiome) });
/*     */   }
/*     */   
/*     */   private Object getResourceKey(Biome biome) throws ReflectiveOperationException {
/*  30 */     Field field = Biomes.class.getField(getBiomeField(biome));
/*  31 */     field.setAccessible(true);
/*  32 */     return field.get(null);
/*     */   }
/*     */   
/*     */   private String getBiomeField(Biome biome) {
/*  36 */     switch (biome) {
/*     */       case OCEAN:
/*  38 */         return "a";
/*     */       case PLAINS:
/*  40 */         return "b";
/*     */       case DESERT:
/*  42 */         return "c";
/*     */       case MOUNTAINS:
/*  44 */         return "d";
/*     */       case FOREST:
/*  46 */         return "e";
/*     */       case TAIGA:
/*  48 */         return "f";
/*     */       case SWAMP:
/*  50 */         return "g";
/*     */       case RIVER:
/*  52 */         return "h";
/*     */       case NETHER_WASTES:
/*  54 */         return "i";
/*     */       case THE_END:
/*  56 */         return "j";
/*     */       case FROZEN_OCEAN:
/*  58 */         return "k";
/*     */       case FROZEN_RIVER:
/*  60 */         return "l";
/*     */       case SNOWY_TUNDRA:
/*  62 */         return "m";
/*     */       case SNOWY_MOUNTAINS:
/*  64 */         return "n";
/*     */       case MUSHROOM_FIELDS:
/*  66 */         return "o";
/*     */       case MUSHROOM_FIELD_SHORE:
/*  68 */         return "p";
/*     */       case BEACH:
/*  70 */         return "q";
/*     */       case DESERT_HILLS:
/*  72 */         return "r";
/*     */       case WOODED_HILLS:
/*  74 */         return "s";
/*     */       case TAIGA_HILLS:
/*  76 */         return "t";
/*     */       case MOUNTAIN_EDGE:
/*  78 */         return "u";
/*     */       case JUNGLE:
/*  80 */         return "v";
/*     */       case JUNGLE_HILLS:
/*  82 */         return "w";
/*     */       case JUNGLE_EDGE:
/*  84 */         return "x";
/*     */       case DEEP_OCEAN:
/*  86 */         return "y";
/*     */       case STONE_SHORE:
/*  88 */         return "z";
/*     */       case SNOWY_BEACH:
/*  90 */         return "A";
/*     */       case BIRCH_FOREST:
/*  92 */         return "B";
/*     */       case BIRCH_FOREST_HILLS:
/*  94 */         return "C";
/*     */       case DARK_FOREST:
/*  96 */         return "D";
/*     */       case SNOWY_TAIGA:
/*  98 */         return "E";
/*     */       case SNOWY_TAIGA_HILLS:
/* 100 */         return "F";
/*     */       case GIANT_TREE_TAIGA:
/* 102 */         return "G";
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 104 */         return "H";
/*     */       case WOODED_MOUNTAINS:
/* 106 */         return "I";
/*     */       case SAVANNA:
/* 108 */         return "J";
/*     */       case SAVANNA_PLATEAU:
/* 110 */         return "K";
/*     */       case BADLANDS:
/* 112 */         return "L";
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 114 */         return "M";
/*     */       case BADLANDS_PLATEAU:
/* 116 */         return "N";
/*     */       case SMALL_END_ISLANDS:
/* 118 */         return "O";
/*     */       case END_MIDLANDS:
/* 120 */         return "P";
/*     */       case END_HIGHLANDS:
/* 122 */         return "Q";
/*     */       case END_BARRENS:
/* 124 */         return "R";
/*     */       case WARM_OCEAN:
/* 126 */         return "S";
/*     */       case LUKEWARM_OCEAN:
/* 128 */         return "T";
/*     */       case COLD_OCEAN:
/* 130 */         return "U";
/*     */       case DEEP_WARM_OCEAN:
/* 132 */         return "V";
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 134 */         return "W";
/*     */       case DEEP_COLD_OCEAN:
/* 136 */         return "X";
/*     */       case DEEP_FROZEN_OCEAN:
/* 138 */         return "Y";
/*     */       case THE_VOID:
/* 140 */         return "Z";
/*     */       case SUNFLOWER_PLAINS:
/* 142 */         return "aa";
/*     */       case DESERT_LAKES:
/* 144 */         return "ab";
/*     */       case GRAVELLY_MOUNTAINS:
/* 146 */         return "ac";
/*     */       case FLOWER_FOREST:
/* 148 */         return "ad";
/*     */       case TAIGA_MOUNTAINS:
/* 150 */         return "ae";
/*     */       case SWAMP_HILLS:
/* 152 */         return "af";
/*     */       case ICE_SPIKES:
/* 154 */         return "ag";
/*     */       case MODIFIED_JUNGLE:
/* 156 */         return "ah";
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 158 */         return "ai";
/*     */       case TALL_BIRCH_FOREST:
/* 160 */         return "aj";
/*     */       case TALL_BIRCH_HILLS:
/* 162 */         return "ak";
/*     */       case DARK_FOREST_HILLS:
/* 164 */         return "al";
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 166 */         return "am";
/*     */       case GIANT_SPRUCE_TAIGA:
/* 168 */         return "an";
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 170 */         return "ao";
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 172 */         return "ap";
/*     */       case SHATTERED_SAVANNA:
/* 174 */         return "aq";
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 176 */         return "ar";
/*     */       case ERODED_BADLANDS:
/* 178 */         return "as";
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 180 */         return "at";
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 182 */         return "au";
/*     */       case BAMBOO_JUNGLE:
/* 184 */         return "av";
/*     */       case BAMBOO_JUNGLE_HILLS:
/* 186 */         return "aw";
/*     */       case SOUL_SAND_VALLEY:
/* 188 */         return "ax";
/*     */       case CRIMSON_FOREST:
/* 190 */         return "ay";
/*     */       case WARPED_FOREST:
/* 192 */         return "az";
/*     */       case BASALT_DELTAS:
/* 194 */         return "aA";
/*     */       case DRIPSTONE_CAVES:
/* 196 */         return "aB";
/*     */       case LUSH_CAVES:
/* 198 */         return "aC";
/*     */     } 
/* 200 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) {
/* 205 */     switch (biome) {
/*     */       case OCEAN:
/* 207 */         return BiomesSettingsDefault.c(false);
/*     */       case PLAINS:
/* 209 */         return BiomesSettingsDefault.a(false);
/*     */       case DESERT:
/* 211 */         return BiomesSettingsDefault.a(0.125F, 0.05F, true, true, true);
/*     */       case MOUNTAINS:
/* 213 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.m, false);
/*     */       case FOREST:
/* 215 */         return BiomesSettingsDefault.c(0.1F, 0.2F);
/*     */       case TAIGA:
/* 217 */         return BiomesSettingsDefault.a(0.2F, 0.2F, false, false, true, false);
/*     */       case SWAMP:
/* 219 */         return BiomesSettingsDefault.d(-0.2F, 0.1F, false);
/*     */       case RIVER:
/* 221 */         return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.5F, 4159204, false);
/*     */       case NETHER_WASTES:
/* 223 */         return BiomesSettingsDefault.s();
/*     */       case THE_END:
/* 225 */         return BiomesSettingsDefault.i();
/*     */       case FROZEN_OCEAN:
/* 227 */         return BiomesSettingsDefault.e(false);
/*     */       case FROZEN_RIVER:
/* 229 */         return BiomesSettingsDefault.a(-0.5F, 0.0F, 0.0F, 3750089, true);
/*     */       case SNOWY_TUNDRA:
/* 231 */         return BiomesSettingsDefault.a(0.125F, 0.05F, false, false);
/*     */       case SNOWY_MOUNTAINS:
/* 233 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, true);
/*     */       case MUSHROOM_FIELDS:
/* 235 */         return BiomesSettingsDefault.a(0.2F, 0.3F);
/*     */       case MUSHROOM_FIELD_SHORE:
/* 237 */         return BiomesSettingsDefault.a(0.0F, 0.025F);
/*     */       case BEACH:
/* 239 */         return BiomesSettingsDefault.a(0.0F, 0.025F, 0.8F, 0.4F, 4159204, false, false);
/*     */       case DESERT_HILLS:
/* 241 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, true, false);
/*     */       case WOODED_HILLS:
/* 243 */         return BiomesSettingsDefault.c(0.45F, 0.3F);
/*     */       case TAIGA_HILLS:
/* 245 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false, false, false, false);
/*     */       case MOUNTAIN_EDGE:
/* 247 */         return BiomesSettingsDefault.a(0.8F, 0.3F, WorldGenSurfaceComposites.j, true);
/*     */       case JUNGLE:
/* 249 */         return BiomesSettingsDefault.a();
/*     */       case JUNGLE_HILLS:
/* 251 */         return BiomesSettingsDefault.e();
/*     */       case JUNGLE_EDGE:
/* 253 */         return BiomesSettingsDefault.b();
/*     */       case DEEP_OCEAN:
/* 255 */         return BiomesSettingsDefault.c(true);
/*     */       case STONE_SHORE:
/* 257 */         return BiomesSettingsDefault.a(0.1F, 0.8F, 0.2F, 0.3F, 4159204, false, true);
/*     */       case SNOWY_BEACH:
/* 259 */         return BiomesSettingsDefault.a(0.0F, 0.025F, 0.05F, 0.3F, 4020182, true, false);
/*     */       case BIRCH_FOREST:
/* 261 */         return BiomesSettingsDefault.a(0.1F, 0.2F, false);
/*     */       case BIRCH_FOREST_HILLS:
/* 263 */         return BiomesSettingsDefault.a(0.45F, 0.3F, false);
/*     */       case DARK_FOREST:
/* 265 */         return BiomesSettingsDefault.c(0.1F, 0.2F, false);
/*     */       case SNOWY_TAIGA:
/* 267 */         return BiomesSettingsDefault.a(0.2F, 0.2F, true, false, false, true);
/*     */       case SNOWY_TAIGA_HILLS:
/* 269 */         return BiomesSettingsDefault.a(0.45F, 0.3F, true, false, false, false);
/*     */       case GIANT_TREE_TAIGA:
/* 271 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.3F, false);
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 273 */         return BiomesSettingsDefault.a(0.45F, 0.3F, 0.3F, false);
/*     */       case WOODED_MOUNTAINS:
/* 275 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.j, true);
/*     */       case SAVANNA:
/* 277 */         return BiomesSettingsDefault.a(0.125F, 0.05F, 1.2F, false, false);
/*     */       case SAVANNA_PLATEAU:
/* 279 */         return BiomesSettingsDefault.m();
/*     */       case BADLANDS:
/* 281 */         return BiomesSettingsDefault.b(0.1F, 0.2F, false);
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 283 */         return BiomesSettingsDefault.b(1.5F, 0.025F);
/*     */       case BADLANDS_PLATEAU:
/* 285 */         return BiomesSettingsDefault.b(1.5F, 0.025F, true);
/*     */       case SMALL_END_ISLANDS:
/* 287 */         return BiomesSettingsDefault.l();
/*     */       case END_MIDLANDS:
/* 289 */         return BiomesSettingsDefault.j();
/*     */       case END_HIGHLANDS:
/* 291 */         return BiomesSettingsDefault.k();
/*     */       case END_BARRENS:
/* 293 */         return BiomesSettingsDefault.h();
/*     */       case WARM_OCEAN:
/* 295 */         return BiomesSettingsDefault.o();
/*     */       case LUKEWARM_OCEAN:
/* 297 */         return BiomesSettingsDefault.d(false);
/*     */       case COLD_OCEAN:
/* 299 */         return BiomesSettingsDefault.b(false);
/*     */       case DEEP_WARM_OCEAN:
/* 301 */         return BiomesSettingsDefault.p();
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 303 */         return BiomesSettingsDefault.d(true);
/*     */       case DEEP_COLD_OCEAN:
/* 305 */         return BiomesSettingsDefault.b(true);
/*     */       case DEEP_FROZEN_OCEAN:
/* 307 */         return BiomesSettingsDefault.e(true);
/*     */       case THE_VOID:
/* 309 */         return BiomesSettingsDefault.r();
/*     */       case SUNFLOWER_PLAINS:
/* 311 */         return BiomesSettingsDefault.a(true);
/*     */       case DESERT_LAKES:
/* 313 */         return BiomesSettingsDefault.a(0.225F, 0.25F, false, false, false);
/*     */       case GRAVELLY_MOUNTAINS:
/* 315 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
/*     */       case FLOWER_FOREST:
/* 317 */         return BiomesSettingsDefault.q();
/*     */       case TAIGA_MOUNTAINS:
/* 319 */         return BiomesSettingsDefault.a(0.3F, 0.4F, false, true, false, false);
/*     */       case SWAMP_HILLS:
/* 321 */         return BiomesSettingsDefault.d(-0.1F, 0.3F, true);
/*     */       case ICE_SPIKES:
/* 323 */         return BiomesSettingsDefault.a(0.425F, 0.45000002F, true, false);
/*     */       case MODIFIED_JUNGLE:
/* 325 */         return BiomesSettingsDefault.d();
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 327 */         return BiomesSettingsDefault.c();
/*     */       case TALL_BIRCH_FOREST:
/* 329 */         return BiomesSettingsDefault.a(0.2F, 0.4F, true);
/*     */       case TALL_BIRCH_HILLS:
/* 331 */         return BiomesSettingsDefault.a(0.55F, 0.5F, true);
/*     */       case DARK_FOREST_HILLS:
/* 333 */         return BiomesSettingsDefault.c(0.2F, 0.4F, true);
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 335 */         return BiomesSettingsDefault.a(0.3F, 0.4F, true, true, false, false);
/*     */       case GIANT_SPRUCE_TAIGA:
/* 337 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/* 339 */         return BiomesSettingsDefault.a(0.2F, 0.2F, 0.25F, true);
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 341 */         return BiomesSettingsDefault.a(1.0F, 0.5F, WorldGenSurfaceComposites.k, false);
/*     */       case SHATTERED_SAVANNA:
/* 343 */         return BiomesSettingsDefault.a(0.3625F, 1.225F, 1.1F, true, true);
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 345 */         return BiomesSettingsDefault.a(1.05F, 1.2125001F, 1.0F, true, true);
/*     */       case ERODED_BADLANDS:
/* 347 */         return BiomesSettingsDefault.n();
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 349 */         return BiomesSettingsDefault.b(0.45F, 0.3F);
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 351 */         return BiomesSettingsDefault.b(0.45F, 0.3F, true);
/*     */       case BAMBOO_JUNGLE:
/* 353 */         return BiomesSettingsDefault.f();
/*     */       case BAMBOO_JUNGLE_HILLS:
/* 355 */         return BiomesSettingsDefault.g();
/*     */       case SOUL_SAND_VALLEY:
/* 357 */         return BiomesSettingsDefault.t();
/*     */       case CRIMSON_FOREST:
/* 359 */         return BiomesSettingsDefault.v();
/*     */       case WARPED_FOREST:
/* 361 */         return BiomesSettingsDefault.w();
/*     */       case BASALT_DELTAS:
/* 363 */         return BiomesSettingsDefault.u();
/*     */       case DRIPSTONE_CAVES:
/* 365 */         return BiomesSettingsDefault.y();
/*     */       case LUSH_CAVES:
/* 367 */         return BiomesSettingsDefault.x();
/*     */     } 
/* 369 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_17_R1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */