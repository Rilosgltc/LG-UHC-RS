/*     */ package com.pieterdebot.biomemapping;
/*     */ 
/*     */ public enum Biome {
/*   4 */   OCEAN(0),
/*   5 */   PLAINS(1),
/*   6 */   DESERT(2),
/*   7 */   MOUNTAINS(3, "EXTREME_HILLS"),
/*   8 */   FOREST(4),
/*   9 */   TAIGA(5),
/*  10 */   SWAMP(6, "SWAMPLAND"),
/*  11 */   RIVER(7),
/*  12 */   NETHER_WASTES(8, "HELL"),
/*  13 */   THE_END(9, "SKY"),
/*  14 */   FROZEN_OCEAN(10),
/*  15 */   FROZEN_RIVER(11),
/*  16 */   SNOWY_TUNDRA(12, "ICE_PLAINS"),
/*  17 */   SNOWY_MOUNTAINS(13, "ICE_MOUNTAINS"),
/*  18 */   MUSHROOM_FIELDS(14, "MUSHROOM_ISLAND"),
/*  19 */   MUSHROOM_FIELD_SHORE(15, "MUSHROOM_SHORE"),
/*  20 */   BEACH(16),
/*  21 */   DESERT_HILLS(17),
/*  22 */   WOODED_HILLS(18, "FOREST_HILLS"),
/*  23 */   TAIGA_HILLS(19, "TAIGA_HILLS"),
/*  24 */   MOUNTAIN_EDGE(20, "SMALL_MOUNTAINS"),
/*  25 */   JUNGLE(21),
/*  26 */   JUNGLE_HILLS(22),
/*  27 */   JUNGLE_EDGE(23),
/*  28 */   DEEP_OCEAN(24),
/*  29 */   STONE_SHORE(25, "STONE_BEACH"),
/*  30 */   SNOWY_BEACH(26, "COLD_BEACH"),
/*  31 */   BIRCH_FOREST(27),
/*  32 */   BIRCH_FOREST_HILLS(28),
/*  33 */   DARK_FOREST(29, "ROOFED_FOREST"),
/*  34 */   SNOWY_TAIGA(30, "COLD_TAIGA"),
/*  35 */   SNOWY_TAIGA_HILLS(31, "COLD_TAIGA_HILLS"),
/*  36 */   GIANT_TREE_TAIGA(32, "MEGA_TAIGA"),
/*  37 */   GIANT_TREE_TAIGA_HILLS(33, "MEGA_TAIGA_HILLS"),
/*  38 */   WOODED_MOUNTAINS(34, "EXTREME_HILLS_PLUS"),
/*  39 */   SAVANNA(35),
/*  40 */   SAVANNA_PLATEAU(36),
/*  41 */   BADLANDS(37, "MESA"),
/*  42 */   WOODED_BADLANDS_PLATEAU(38, "MESA_PLATEAU_F"),
/*  43 */   BADLANDS_PLATEAU(39, "MESA_PLATEAU"),
/*  44 */   SMALL_END_ISLANDS(40),
/*  45 */   END_MIDLANDS(41),
/*  46 */   END_HIGHLANDS(42),
/*  47 */   END_BARRENS(43),
/*  48 */   WARM_OCEAN(44),
/*  49 */   LUKEWARM_OCEAN(45),
/*  50 */   COLD_OCEAN(46),
/*  51 */   DEEP_WARM_OCEAN(47),
/*  52 */   DEEP_LUKEWARM_OCEAN(48),
/*  53 */   DEEP_COLD_OCEAN(49),
/*  54 */   DEEP_FROZEN_OCEAN(50),
/*  55 */   THE_VOID(127),
/*  56 */   SUNFLOWER_PLAINS(129),
/*  57 */   DESERT_LAKES(130),
/*  58 */   GRAVELLY_MOUNTAINS(131),
/*  59 */   FLOWER_FOREST(132),
/*  60 */   TAIGA_MOUNTAINS(133),
/*  61 */   SWAMP_HILLS(134),
/*  62 */   ICE_SPIKES(140),
/*  63 */   MODIFIED_JUNGLE(149),
/*  64 */   MODIFIED_JUNGLE_EDGE(151),
/*  65 */   TALL_BIRCH_FOREST(155),
/*  66 */   TALL_BIRCH_HILLS(156),
/*  67 */   DARK_FOREST_HILLS(157),
/*  68 */   SNOWY_TAIGA_MOUNTAINS(158),
/*  69 */   GIANT_SPRUCE_TAIGA(160),
/*  70 */   GIANT_SPRUCE_TAIGA_HILLS(161),
/*  71 */   MODIFIED_GRAVELLY_MOUNTAINS(162),
/*  72 */   SHATTERED_SAVANNA(163),
/*  73 */   SHATTERED_SAVANNA_PLATEAU(164),
/*  74 */   ERODED_BADLANDS(165),
/*  75 */   MODIFIED_WOODED_BADLANDS_PLATEAU(166),
/*  76 */   MODIFIED_BADLANDS_PLATEAU(167),
/*  77 */   BAMBOO_JUNGLE(168),
/*  78 */   BAMBOO_JUNGLE_HILLS(169),
/*  79 */   SOUL_SAND_VALLEY(170),
/*  80 */   CRIMSON_FOREST(171),
/*  81 */   WARPED_FOREST(172),
/*  82 */   BASALT_DELTAS(173),
/*  83 */   DRIPSTONE_CAVES(174),
/*  84 */   LUSH_CAVES(175),
/*  85 */   MEADOW(176),
/*  86 */   GROVE(177),
/*  87 */   SNOWY_SLOPES(178),
/*  88 */   FROZEN_PEAKS(179),
/*  89 */   JAGGED_PEAKS(180),
/*  90 */   STORY_PEAKS(181),
/*  91 */   MANGROVE_SWAMP(182),
/*  92 */   ANCIENT_CITIES(183);
/*     */   
/*     */   private final int id;
/*     */   private final String oldName;
/*     */   
/*     */   Biome(int id, String oldName) {
/*  98 */     this.id = id;
/*  99 */     this.oldName = oldName;
/*     */   }
/*     */   
/*     */   Biome(int id) {
/* 103 */     this.id = id;
/* 104 */     this.oldName = name();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getId() {
/* 112 */     return this.id;
/*     */   }
/*     */   
/*     */   public String getOldName() {
/* 116 */     return this.oldName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOcean() {
/* 124 */     switch (this) {
/*     */       case OCEAN:
/*     */       case COLD_OCEAN:
/*     */       case DEEP_COLD_OCEAN:
/*     */       case DEEP_FROZEN_OCEAN:
/*     */       case DEEP_LUKEWARM_OCEAN:
/*     */       case DEEP_OCEAN:
/*     */       case DEEP_WARM_OCEAN:
/*     */       case FROZEN_OCEAN:
/*     */       case LUKEWARM_OCEAN:
/*     */       case WARM_OCEAN:
/* 135 */         return true;
/*     */     } 
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isJungle() {
/* 146 */     switch (this) {
/*     */       case JUNGLE:
/*     */       case JUNGLE_EDGE:
/*     */       case JUNGLE_HILLS:
/*     */       case BAMBOO_JUNGLE:
/*     */       case BAMBOO_JUNGLE_HILLS:
/*     */       case MODIFIED_JUNGLE:
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 154 */         return true;
/*     */     } 
/* 156 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNether() {
/* 165 */     switch (this) {
/*     */       case NETHER_WASTES:
/*     */       case SOUL_SAND_VALLEY:
/*     */       case CRIMSON_FOREST:
/*     */       case WARPED_FOREST:
/*     */       case BASALT_DELTAS:
/* 171 */         return true;
/*     */     } 
/* 173 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTheEnd() {
/* 182 */     switch (this) {
/*     */       case END_BARRENS:
/*     */       case END_HIGHLANDS:
/*     */       case END_MIDLANDS:
/*     */       case THE_END:
/*     */       case SMALL_END_ISLANDS:
/* 188 */         return true;
/*     */     } 
/* 190 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\Biome.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */