package com.pieterdebot.biomemapping.version;

import com.pieterdebot.biomemapping.Biome;

public interface VersionWrapper {
  boolean biomeSupported(Biome paramBiome);
  
  void replaceBiomes(Biome paramBiome1, Biome paramBiome2) throws Exception;
}


/* Location:              C:\Users\Rilos\Downloads\werewolfplugin-1.10-SNAPSHOT.jar!\com\pieterdebot\biomemapping\version\VersionWrapper.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */