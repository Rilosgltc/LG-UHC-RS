/*     */ package com.pieterdebot.biomemapping.version;
/*     */ 
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import com.pieterdebot.biomemapping.utils.NMSUtils;
/*     */ import java.lang.reflect.Method;
/*     */ import net.minecraft.data.worldgen.biome.BiomeRegistry;
/*     */ import net.minecraft.data.worldgen.biome.EndBiomes;
/*     */ import net.minecraft.data.worldgen.biome.NetherBiomes;
/*     */ import net.minecraft.data.worldgen.biome.OverworldBiomes;
/*     */ import net.minecraft.resources.ResourceKey;
/*     */ import net.minecraft.world.level.biome.BiomeBase;
/*     */ import net.minecraft.world.level.biome.Biomes;
/*     */ 
/*     */ 
/*     */ public class Wrapper_1_18_R1
/*     */   implements VersionWrapper
/*     */ {
/*     */   public boolean biomeSupported(Biome biome) {
/*  19 */     return (getResourceKey(biome) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  24 */     ResourceKey<BiomeBase> oldBiomeResourceKey = getResourceKey(oldBiome);
/*     */     
/*  26 */     Method registerMethod = NMSUtils.getMethod(BiomeRegistry.class, "a", 2);
/*  27 */     registerMethod.invoke(null, new Object[] { oldBiomeResourceKey, getBiomeBase(newBiome) });
/*     */   }
/*     */   
/*     */   private ResourceKey<BiomeBase> getResourceKey(Biome biome) {
/*  31 */     switch (biome) {
/*     */       case THE_VOID:
/*  33 */         return Biomes.a;
/*     */       case PLAINS:
/*  35 */         return Biomes.b;
/*     */       case SUNFLOWER_PLAINS:
/*  37 */         return Biomes.c;
/*     */       case SNOWY_TUNDRA:
/*  39 */         return Biomes.d;
/*     */       case ICE_SPIKES:
/*  41 */         return Biomes.e;
/*     */       case DESERT:
/*  43 */         return Biomes.f;
/*     */       case SWAMP:
/*  45 */         return Biomes.g;
/*     */       case FOREST:
/*  47 */         return Biomes.h;
/*     */       case FLOWER_FOREST:
/*  49 */         return Biomes.i;
/*     */       case BIRCH_FOREST:
/*  51 */         return Biomes.j;
/*     */       case DARK_FOREST:
/*  53 */         return Biomes.k;
/*     */       case TALL_BIRCH_FOREST:
/*  55 */         return Biomes.l;
/*     */       case GIANT_TREE_TAIGA:
/*  57 */         return Biomes.m;
/*     */       case GIANT_SPRUCE_TAIGA:
/*  59 */         return Biomes.n;
/*     */       case TAIGA:
/*  61 */         return Biomes.o;
/*     */       case SNOWY_TAIGA:
/*  63 */         return Biomes.p;
/*     */       case SAVANNA:
/*  65 */         return Biomes.q;
/*     */       case SAVANNA_PLATEAU:
/*  67 */         return Biomes.r;
/*     */       case MOUNTAINS:
/*  69 */         return Biomes.s;
/*     */       case GRAVELLY_MOUNTAINS:
/*  71 */         return Biomes.t;
/*     */       case WOODED_MOUNTAINS:
/*  73 */         return Biomes.u;
/*     */       case SHATTERED_SAVANNA:
/*  75 */         return Biomes.v;
/*     */       case JUNGLE:
/*  77 */         return Biomes.w;
/*     */       case JUNGLE_EDGE:
/*  79 */         return Biomes.x;
/*     */       case BAMBOO_JUNGLE:
/*  81 */         return Biomes.y;
/*     */       case BADLANDS:
/*  83 */         return Biomes.z;
/*     */       case ERODED_BADLANDS:
/*  85 */         return Biomes.A;
/*     */       case WOODED_BADLANDS_PLATEAU:
/*  87 */         return Biomes.B;
/*     */       case MEADOW:
/*  89 */         return Biomes.C;
/*     */       case GROVE:
/*  91 */         return Biomes.D;
/*     */       case SNOWY_SLOPES:
/*  93 */         return Biomes.E;
/*     */       case FROZEN_PEAKS:
/*  95 */         return Biomes.F;
/*     */       case JAGGED_PEAKS:
/*  97 */         return Biomes.G;
/*     */       case STORY_PEAKS:
/*  99 */         return Biomes.H;
/*     */       case RIVER:
/* 101 */         return Biomes.I;
/*     */       case FROZEN_RIVER:
/* 103 */         return Biomes.J;
/*     */       case BEACH:
/* 105 */         return Biomes.K;
/*     */       case SNOWY_BEACH:
/* 107 */         return Biomes.L;
/*     */       case STONE_SHORE:
/* 109 */         return Biomes.M;
/*     */       case WARM_OCEAN:
/* 111 */         return Biomes.N;
/*     */       case LUKEWARM_OCEAN:
/* 113 */         return Biomes.O;
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 115 */         return Biomes.P;
/*     */       case OCEAN:
/* 117 */         return Biomes.Q;
/*     */       case DEEP_OCEAN:
/* 119 */         return Biomes.R;
/*     */       case COLD_OCEAN:
/* 121 */         return Biomes.S;
/*     */       case DEEP_COLD_OCEAN:
/* 123 */         return Biomes.T;
/*     */       case FROZEN_OCEAN:
/* 125 */         return Biomes.U;
/*     */       case DEEP_FROZEN_OCEAN:
/* 127 */         return Biomes.V;
/*     */       case MUSHROOM_FIELDS:
/* 129 */         return Biomes.W;
/*     */       case DRIPSTONE_CAVES:
/* 131 */         return Biomes.X;
/*     */       case LUSH_CAVES:
/* 133 */         return Biomes.Y;
/*     */       case NETHER_WASTES:
/* 135 */         return Biomes.Z;
/*     */       case WARPED_FOREST:
/* 137 */         return Biomes.aa;
/*     */       case CRIMSON_FOREST:
/* 139 */         return Biomes.ab;
/*     */       case SOUL_SAND_VALLEY:
/* 141 */         return Biomes.ac;
/*     */       case BASALT_DELTAS:
/* 143 */         return Biomes.ad;
/*     */       case THE_END:
/* 145 */         return Biomes.ae;
/*     */       case END_HIGHLANDS:
/* 147 */         return Biomes.af;
/*     */       case END_MIDLANDS:
/* 149 */         return Biomes.ag;
/*     */       case SMALL_END_ISLANDS:
/* 151 */         return Biomes.ah;
/*     */       case END_BARRENS:
/* 153 */         return Biomes.ai;
/*     */     } 
/*     */     
/* 156 */     return null;
/*     */   }
/*     */   
/*     */   private BiomeBase getBiomeBase(Biome biome) {
/* 160 */     switch (biome) {
/*     */       case THE_VOID:
/* 162 */         return OverworldBiomes.i();
/*     */       case PLAINS:
/* 164 */         return OverworldBiomes.a(false, false, false);
/*     */       case SUNFLOWER_PLAINS:
/* 166 */         return OverworldBiomes.a(true, false, false);
/*     */       case SNOWY_TUNDRA:
/* 168 */         return OverworldBiomes.a(false, true, false);
/*     */       case ICE_SPIKES:
/* 170 */         return OverworldBiomes.a(false, true, true);
/*     */       case DESERT:
/* 172 */         return OverworldBiomes.d();
/*     */       case SWAMP:
/* 174 */         return OverworldBiomes.h();
/*     */       case FOREST:
/* 176 */         return OverworldBiomes.b(false, false, false);
/*     */       case FLOWER_FOREST:
/* 178 */         return OverworldBiomes.b(false, false, true);
/*     */       case BIRCH_FOREST:
/* 180 */         return OverworldBiomes.b(true, false, false);
/*     */       case DARK_FOREST:
/* 182 */         return OverworldBiomes.g();
/*     */       case TALL_BIRCH_FOREST:
/* 184 */         return OverworldBiomes.b(true, true, false);
/*     */       case GIANT_TREE_TAIGA:
/* 186 */         return OverworldBiomes.a(false);
/*     */       case GIANT_SPRUCE_TAIGA:
/* 188 */         return OverworldBiomes.a(true);
/*     */       case TAIGA:
/* 190 */         return OverworldBiomes.h(false);
/*     */       case SNOWY_TAIGA:
/* 192 */         return OverworldBiomes.h(true);
/*     */       case SAVANNA:
/* 194 */         return OverworldBiomes.a(false, false);
/*     */       case SAVANNA_PLATEAU:
/* 196 */         return OverworldBiomes.a(false, true);
/*     */       case MOUNTAINS:
/* 198 */         return OverworldBiomes.b(false);
/*     */       case GRAVELLY_MOUNTAINS:
/* 200 */         return OverworldBiomes.b(false);
/*     */       case WOODED_MOUNTAINS:
/* 202 */         return OverworldBiomes.b(true);
/*     */       case SHATTERED_SAVANNA:
/* 204 */         return OverworldBiomes.a(true, false);
/*     */       case JUNGLE:
/* 206 */         return OverworldBiomes.b();
/*     */       case JUNGLE_EDGE:
/* 208 */         return OverworldBiomes.a();
/*     */       case BAMBOO_JUNGLE:
/* 210 */         return OverworldBiomes.c();
/*     */       case BADLANDS:
/* 212 */         return OverworldBiomes.c(false);
/*     */       case ERODED_BADLANDS:
/* 214 */         return OverworldBiomes.c(false);
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 216 */         return OverworldBiomes.c(true);
/*     */       case MEADOW:
/* 218 */         return OverworldBiomes.j();
/*     */       case GROVE:
/* 220 */         return OverworldBiomes.o();
/*     */       case SNOWY_SLOPES:
/* 222 */         return OverworldBiomes.n();
/*     */       case FROZEN_PEAKS:
/* 224 */         return OverworldBiomes.k();
/*     */       case JAGGED_PEAKS:
/* 226 */         return OverworldBiomes.l();
/*     */       case STORY_PEAKS:
/* 228 */         return OverworldBiomes.m();
/*     */       case RIVER:
/* 230 */         return OverworldBiomes.i(false);
/*     */       case FROZEN_RIVER:
/* 232 */         return OverworldBiomes.i(true);
/*     */       case BEACH:
/* 234 */         return OverworldBiomes.b(false, false);
/*     */       case SNOWY_BEACH:
/* 236 */         return OverworldBiomes.b(true, false);
/*     */       case STONE_SHORE:
/* 238 */         return OverworldBiomes.b(false, true);
/*     */       case WARM_OCEAN:
/* 240 */         return OverworldBiomes.f();
/*     */       case LUKEWARM_OCEAN:
/* 242 */         return OverworldBiomes.f(false);
/*     */       case DEEP_LUKEWARM_OCEAN:
/* 244 */         return OverworldBiomes.f(true);
/*     */       case OCEAN:
/* 246 */         return OverworldBiomes.e(false);
/*     */       case DEEP_OCEAN:
/* 248 */         return OverworldBiomes.e(true);
/*     */       case COLD_OCEAN:
/* 250 */         return OverworldBiomes.d(false);
/*     */       case DEEP_COLD_OCEAN:
/* 252 */         return OverworldBiomes.g(false);
/*     */       case FROZEN_OCEAN:
/* 254 */         return OverworldBiomes.d(true);
/*     */       case DEEP_FROZEN_OCEAN:
/* 256 */         return OverworldBiomes.g(true);
/*     */       case MUSHROOM_FIELDS:
/* 258 */         return OverworldBiomes.e();
/*     */       case DRIPSTONE_CAVES:
/* 260 */         return OverworldBiomes.q();
/*     */       case LUSH_CAVES:
/* 262 */         return OverworldBiomes.p();
/*     */       case NETHER_WASTES:
/* 264 */         return NetherBiomes.a();
/*     */       case WARPED_FOREST:
/* 266 */         return NetherBiomes.e();
/*     */       case CRIMSON_FOREST:
/* 268 */         return NetherBiomes.d();
/*     */       case SOUL_SAND_VALLEY:
/* 270 */         return NetherBiomes.b();
/*     */       case BASALT_DELTAS:
/* 272 */         return NetherBiomes.c();
/*     */       case THE_END:
/* 274 */         return EndBiomes.b();
/*     */       case END_HIGHLANDS:
/* 276 */         return EndBiomes.d();
/*     */       case END_MIDLANDS:
/* 278 */         return EndBiomes.c();
/*     */       case SMALL_END_ISLANDS:
/* 280 */         return EndBiomes.e();
/*     */       case END_BARRENS:
/* 282 */         return EndBiomes.a();
/*     */     } 
/* 284 */     return getBiomeBase(Biome.PLAINS);
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_18_R1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */