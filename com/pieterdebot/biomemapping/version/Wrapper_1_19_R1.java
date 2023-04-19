/*     */ package com.pieterdebot.biomemapping.version;
/*     */ 
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import net.minecraft.data.RegistryGeneration;
/*     */ import net.minecraft.data.worldgen.biome.EndBiomes;
/*     */ import net.minecraft.data.worldgen.biome.NetherBiomes;
/*     */ import net.minecraft.data.worldgen.biome.OverworldBiomes;
/*     */ import net.minecraft.resources.ResourceKey;
/*     */ import net.minecraft.world.level.biome.BiomeBase;
/*     */ import net.minecraft.world.level.biome.Biomes;
/*     */ 
/*     */ public class Wrapper_1_19_R1
/*     */   implements VersionWrapper
/*     */ {
/*     */   public boolean biomeSupported(Biome biome) {
/*  16 */     return (getResourceKey(biome) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) {
/*  21 */     ResourceKey<BiomeBase> oldBiomeResourceKey = getResourceKey(oldBiome);
/*  22 */     RegistryGeneration.a(RegistryGeneration.j, oldBiomeResourceKey, getBiomeBase(newBiome));
/*     */   }
/*     */   
/*     */   private ResourceKey<BiomeBase> getResourceKey(Biome biome) {
/*  26 */     switch (biome) {
/*     */       case THE_VOID:
/*  28 */         return Biomes.a;
/*     */       case PLAINS:
/*  30 */         return Biomes.b;
/*     */       case SUNFLOWER_PLAINS:
/*  32 */         return Biomes.c;
/*     */       case SNOWY_TUNDRA:
/*  34 */         return Biomes.d;
/*     */       case ICE_SPIKES:
/*  36 */         return Biomes.e;
/*     */       case DESERT:
/*  38 */         return Biomes.f;
/*     */       case SWAMP:
/*  40 */         return Biomes.g;
/*     */       case MANGROVE_SWAMP:
/*  42 */         return Biomes.h;
/*     */       case FOREST:
/*  44 */         return Biomes.i;
/*     */       case FLOWER_FOREST:
/*  46 */         return Biomes.j;
/*     */       case BIRCH_FOREST:
/*  48 */         return Biomes.k;
/*     */       case DARK_FOREST:
/*  50 */         return Biomes.l;
/*     */       case TALL_BIRCH_FOREST:
/*  52 */         return Biomes.m;
/*     */       case GIANT_TREE_TAIGA:
/*  54 */         return Biomes.n;
/*     */       case GIANT_SPRUCE_TAIGA:
/*  56 */         return Biomes.o;
/*     */       case TAIGA:
/*  58 */         return Biomes.p;
/*     */       case SNOWY_TAIGA:
/*  60 */         return Biomes.q;
/*     */       case SAVANNA:
/*  62 */         return Biomes.r;
/*     */       case SAVANNA_PLATEAU:
/*  64 */         return Biomes.s;
/*     */       case MOUNTAINS:
/*  66 */         return Biomes.t;
/*     */       case GRAVELLY_MOUNTAINS:
/*  68 */         return Biomes.u;
/*     */       case WOODED_MOUNTAINS:
/*  70 */         return Biomes.v;
/*     */       case SHATTERED_SAVANNA:
/*  72 */         return Biomes.w;
/*     */       case JUNGLE:
/*  74 */         return Biomes.x;
/*     */       case JUNGLE_EDGE:
/*  76 */         return Biomes.y;
/*     */       case BAMBOO_JUNGLE:
/*  78 */         return Biomes.z;
/*     */       case BADLANDS:
/*  80 */         return Biomes.A;
/*     */       case ERODED_BADLANDS:
/*  82 */         return Biomes.B;
/*     */       case WOODED_BADLANDS_PLATEAU:
/*  84 */         return Biomes.C;
/*     */       case MEADOW:
/*  86 */         return Biomes.D;
/*     */       case GROVE:
/*  88 */         return Biomes.E;
/*     */       case SNOWY_SLOPES:
/*  90 */         return Biomes.F;
/*     */       case FROZEN_PEAKS:
/*  92 */         return Biomes.G;
/*     */       case JAGGED_PEAKS:
/*  94 */         return Biomes.H;
/*     */       case STORY_PEAKS:
/*  96 */         return Biomes.I;
/*     */       case RIVER:
/*  98 */         return Biomes.J;
/*     */       case FROZEN_RIVER:
/* 100 */         return Biomes.K;
/*     */       case BEACH:
/* 102 */         return Biomes.L;
/*     */       case SNOWY_BEACH:
/* 104 */         return Biomes.M;
/*     */       case STONE_SHORE:
/* 106 */         return Biomes.N;
/*     */       case WARM_OCEAN:
/* 108 */         return Biomes.O;
/*     */       case LUKEWARM_OCEAN:
/* 110 */         return Biomes.P;
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 112 */         return Biomes.Q;
/*     */       case OCEAN:
/* 114 */         return Biomes.R;
/*     */       case DEEP_OCEAN:
/* 116 */         return Biomes.S;
/*     */       case COLD_OCEAN:
/* 118 */         return Biomes.T;
/*     */       case DEEP_COLD_OCEAN:
/* 120 */         return Biomes.U;
/*     */       case FROZEN_OCEAN:
/* 122 */         return Biomes.V;
/*     */       case DEEP_FROZEN_OCEAN:
/* 124 */         return Biomes.W;
/*     */       case MUSHROOM_FIELDS:
/* 126 */         return Biomes.X;
/*     */       case DRIPSTONE_CAVES:
/* 128 */         return Biomes.Y;
/*     */       case LUSH_CAVES:
/* 130 */         return Biomes.Z;
/*     */       case ANCIENT_CITIES:
/* 132 */         return Biomes.aa;
/*     */       case NETHER_WASTES:
/* 134 */         return Biomes.ab;
/*     */       case WARPED_FOREST:
/* 136 */         return Biomes.ac;
/*     */       case CRIMSON_FOREST:
/* 138 */         return Biomes.ad;
/*     */       case SOUL_SAND_VALLEY:
/* 140 */         return Biomes.ae;
/*     */       case BASALT_DELTAS:
/* 142 */         return Biomes.af;
/*     */       case THE_END:
/* 144 */         return Biomes.ag;
/*     */       case END_HIGHLANDS:
/* 146 */         return Biomes.ah;
/*     */       case END_MIDLANDS:
/* 148 */         return Biomes.ai;
/*     */       case SMALL_END_ISLANDS:
/* 150 */         return Biomes.aj;
/*     */       case END_BARRENS:
/* 152 */         return Biomes.ak;
/*     */     } 
/*     */     
/* 155 */     return null;
/*     */   }
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) {
/* 159 */     switch (biome) {
/*     */       case THE_VOID:
/* 161 */         return OverworldBiomes.j();
/*     */       case PLAINS:
/* 163 */         return OverworldBiomes.a(false, false, false);
/*     */       case SUNFLOWER_PLAINS:
/* 165 */         return OverworldBiomes.a(true, false, false);
/*     */       case SNOWY_TUNDRA:
/* 167 */         return OverworldBiomes.a(false, true, false);
/*     */       case ICE_SPIKES:
/* 169 */         return OverworldBiomes.a(false, true, true);
/*     */       case DESERT:
/* 171 */         return OverworldBiomes.d();
/*     */       case SWAMP:
/* 173 */         return OverworldBiomes.h();
/*     */       case MANGROVE_SWAMP:
/* 175 */         return OverworldBiomes.i();
/*     */       case FOREST:
/* 177 */         return OverworldBiomes.b(false, false, false);
/*     */       case FLOWER_FOREST:
/* 179 */         return OverworldBiomes.b(false, false, true);
/*     */       case BIRCH_FOREST:
/* 181 */         return OverworldBiomes.b(true, false, false);
/*     */       case DARK_FOREST:
/* 183 */         return OverworldBiomes.g();
/*     */       case TALL_BIRCH_FOREST:
/* 185 */         return OverworldBiomes.b(true, true, false);
/*     */       case GIANT_TREE_TAIGA:
/* 187 */         return OverworldBiomes.a(false);
/*     */       case GIANT_SPRUCE_TAIGA:
/* 189 */         return OverworldBiomes.a(true);
/*     */       case TAIGA:
/* 191 */         return OverworldBiomes.h(false);
/*     */       case SNOWY_TAIGA:
/* 193 */         return OverworldBiomes.h(true);
/*     */       case SAVANNA:
/* 195 */         return OverworldBiomes.a(false, false);
/*     */       case SAVANNA_PLATEAU:
/* 197 */         return OverworldBiomes.a(false, true);
/*     */       case MOUNTAINS:
/* 199 */         return OverworldBiomes.b(false);
/*     */       case GRAVELLY_MOUNTAINS:
/* 201 */         return OverworldBiomes.b(false);
/*     */       case WOODED_MOUNTAINS:
/* 203 */         return OverworldBiomes.b(true);
/*     */       case SHATTERED_SAVANNA:
/* 205 */         return OverworldBiomes.a(true, false);
/*     */       case JUNGLE:
/* 207 */         return OverworldBiomes.b();
/*     */       case JUNGLE_EDGE:
/* 209 */         return OverworldBiomes.a();
/*     */       case BAMBOO_JUNGLE:
/* 211 */         return OverworldBiomes.c();
/*     */       case BADLANDS:
/* 213 */         return OverworldBiomes.c(false);
/*     */       case ERODED_BADLANDS:
/* 215 */         return OverworldBiomes.c(false);
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 217 */         return OverworldBiomes.c(true);
/*     */       case MEADOW:
/* 219 */         return OverworldBiomes.k();
/*     */       case GROVE:
/* 221 */         return OverworldBiomes.p();
/*     */       case SNOWY_SLOPES:
/* 223 */         return OverworldBiomes.o();
/*     */       case FROZEN_PEAKS:
/* 225 */         return OverworldBiomes.l();
/*     */       case JAGGED_PEAKS:
/* 227 */         return OverworldBiomes.m();
/*     */       case STORY_PEAKS:
/* 229 */         return OverworldBiomes.n();
/*     */       case RIVER:
/* 231 */         return OverworldBiomes.i(false);
/*     */       case FROZEN_RIVER:
/* 233 */         return OverworldBiomes.i(true);
/*     */       case BEACH:
/* 235 */         return OverworldBiomes.b(false, false);
/*     */       case SNOWY_BEACH:
/* 237 */         return OverworldBiomes.b(true, false);
/*     */       case STONE_SHORE:
/* 239 */         return OverworldBiomes.b(false, true);
/*     */       case WARM_OCEAN:
/* 241 */         return OverworldBiomes.f();
/*     */       case LUKEWARM_OCEAN:
/* 243 */         return OverworldBiomes.f(false);
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 245 */         return OverworldBiomes.f(true);
/*     */       case OCEAN:
/* 247 */         return OverworldBiomes.e(false);
/*     */       case DEEP_OCEAN:
/* 249 */         return OverworldBiomes.e(true);
/*     */       case COLD_OCEAN:
/* 251 */         return OverworldBiomes.d(false);
/*     */       case DEEP_COLD_OCEAN:
/* 253 */         return OverworldBiomes.g(false);
/*     */       case FROZEN_OCEAN:
/* 255 */         return OverworldBiomes.d(true);
/*     */       case DEEP_FROZEN_OCEAN:
/* 257 */         return OverworldBiomes.g(true);
/*     */       case MUSHROOM_FIELDS:
/* 259 */         return OverworldBiomes.e();
/*     */       case DRIPSTONE_CAVES:
/* 261 */         return OverworldBiomes.r();
/*     */       case LUSH_CAVES:
/* 263 */         return OverworldBiomes.q();
/*     */       case ANCIENT_CITIES:
/* 265 */         return OverworldBiomes.s();
/*     */       case NETHER_WASTES:
/* 267 */         return NetherBiomes.a();
/*     */       case WARPED_FOREST:
/* 269 */         return NetherBiomes.e();
/*     */       case CRIMSON_FOREST:
/* 271 */         return NetherBiomes.d();
/*     */       case SOUL_SAND_VALLEY:
/* 273 */         return NetherBiomes.b();
/*     */       case BASALT_DELTAS:
/* 275 */         return NetherBiomes.c();
/*     */       case THE_END:
/* 277 */         return EndBiomes.b();
/*     */       case END_HIGHLANDS:
/* 279 */         return EndBiomes.d();
/*     */       case END_MIDLANDS:
/* 281 */         return EndBiomes.c();
/*     */       case SMALL_END_ISLANDS:
/* 283 */         return EndBiomes.e();
/*     */       case END_BARRENS:
/* 285 */         return EndBiomes.a();
/*     */     } 
/* 287 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_19_R1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */