/*     */ package com.pieterdebot.biomemapping.version;
/*     */ 
/*     */ import com.pieterdebot.biomemapping.Biome;
/*     */ import java.lang.reflect.Field;
/*     */ import net.minecraft.server.v1_9_R2.BiomeBase;
/*     */ import net.minecraft.server.v1_9_R2.Biomes;
/*     */ import net.minecraft.server.v1_9_R2.MinecraftKey;
/*     */ 
/*     */ 
/*     */ public class Wrapper_1_9_R2
/*     */   implements VersionWrapper
/*     */ {
/*     */   public boolean biomeSupported(Biome biome) {
/*  14 */     return (getBiomeField(biome) != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public void replaceBiomes(Biome oldBiome, Biome newBiome) throws Exception {
/*  19 */     Field newBiomeField = Biomes.class.getField(getBiomeField(newBiome));
/*  20 */     BiomeBase newBiomeBase = (BiomeBase)newBiomeField.get(null);
/*  21 */     BiomeBase.REGISTRY_ID.a(oldBiome.getId(), new MinecraftKey(newBiome.name().toLowerCase()), newBiomeBase);
/*     */   }
/*     */   
/*     */   private String getBiomeField(Biome biome) {
/*  25 */     switch (biome) {
/*     */       case OCEAN:
/*  27 */         return "a";
/*     */       case PLAINS:
/*  29 */         return "c";
/*     */       case DESERT:
/*  31 */         return "d";
/*     */       case MOUNTAINS:
/*  33 */         return "e";
/*     */       case FOREST:
/*  35 */         return "f";
/*     */       case TAIGA:
/*  37 */         return "g";
/*     */       case SWAMP:
/*  39 */         return "h";
/*     */       case RIVER:
/*  41 */         return "i";
/*     */       case NETHER_WASTES:
/*  43 */         return "j";
/*     */       case THE_END:
/*  45 */         return "k";
/*     */       case FROZEN_OCEAN:
/*  47 */         return "l";
/*     */       case FROZEN_RIVER:
/*  49 */         return "m";
/*     */       case SNOWY_TUNDRA:
/*  51 */         return "n";
/*     */       case SNOWY_MOUNTAINS:
/*  53 */         return "o";
/*     */       case MUSHROOM_FIELDS:
/*  55 */         return "p";
/*     */       case MUSHROOM_FIELD_SHORE:
/*  57 */         return "q";
/*     */       case BEACH:
/*  59 */         return "r";
/*     */       case DESERT_HILLS:
/*  61 */         return "s";
/*     */       case WOODED_HILLS:
/*  63 */         return "t";
/*     */       case TAIGA_HILLS:
/*  65 */         return "u";
/*     */       case MOUNTAIN_EDGE:
/*  67 */         return "v";
/*     */       case JUNGLE:
/*  69 */         return "w";
/*     */       case JUNGLE_HILLS:
/*  71 */         return "x";
/*     */       case JUNGLE_EDGE:
/*  73 */         return "y";
/*     */       case DEEP_OCEAN:
/*  75 */         return "z";
/*     */       case STONE_SHORE:
/*  77 */         return "A";
/*     */       case SNOWY_BEACH:
/*  79 */         return "B";
/*     */       case BIRCH_FOREST:
/*  81 */         return "C";
/*     */       case BIRCH_FOREST_HILLS:
/*  83 */         return "D";
/*     */       case DARK_FOREST:
/*  85 */         return "E";
/*     */       case SNOWY_TAIGA:
/*  87 */         return "F";
/*     */       case SNOWY_TAIGA_HILLS:
/*  89 */         return "G";
/*     */       case GIANT_TREE_TAIGA:
/*  91 */         return "H";
/*     */       case GIANT_SPRUCE_TAIGA_HILLS:
/*  93 */         return "I";
/*     */       case WOODED_MOUNTAINS:
/*  95 */         return "J";
/*     */       case SAVANNA:
/*  97 */         return "K";
/*     */       case SAVANNA_PLATEAU:
/*  99 */         return "L";
/*     */       case BADLANDS:
/* 101 */         return "M";
/*     */       case WOODED_BADLANDS_PLATEAU:
/* 103 */         return "N";
/*     */       case BADLANDS_PLATEAU:
/* 105 */         return "O";
/*     */       case THE_VOID:
/* 107 */         return "P";
/*     */       case SUNFLOWER_PLAINS:
/* 109 */         return "Q";
/*     */       case DESERT_LAKES:
/* 111 */         return "R";
/*     */       case GRAVELLY_MOUNTAINS:
/* 113 */         return "S";
/*     */       case FLOWER_FOREST:
/* 115 */         return "T";
/*     */       case TAIGA_MOUNTAINS:
/* 117 */         return "U";
/*     */       case SWAMP_HILLS:
/* 119 */         return "V";
/*     */       case ICE_SPIKES:
/* 121 */         return "W";
/*     */       case MODIFIED_JUNGLE:
/* 123 */         return "X";
/*     */       case MODIFIED_JUNGLE_EDGE:
/* 125 */         return "Y";
/*     */       case TALL_BIRCH_FOREST:
/* 127 */         return "Z";
/*     */       case TALL_BIRCH_HILLS:
/* 129 */         return "aa";
/*     */       case DARK_FOREST_HILLS:
/* 131 */         return "ab";
/*     */       case SNOWY_TAIGA_MOUNTAINS:
/* 133 */         return "ac";
/*     */       case GIANT_SPRUCE_TAIGA:
/* 135 */         return "ad";
/*     */       case GIANT_TREE_TAIGA_HILLS:
/* 137 */         return "ae";
/*     */       case MODIFIED_GRAVELLY_MOUNTAINS:
/* 139 */         return "af";
/*     */       case SHATTERED_SAVANNA:
/* 141 */         return "ag";
/*     */       case SHATTERED_SAVANNA_PLATEAU:
/* 143 */         return "ah";
/*     */       case ERODED_BADLANDS:
/* 145 */         return "ai";
/*     */       case MODIFIED_WOODED_BADLANDS_PLATEAU:
/* 147 */         return "aj";
/*     */       case MODIFIED_BADLANDS_PLATEAU:
/* 149 */         return "ak";
/*     */     } 
/* 151 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\Wrapper_1_9_R2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */