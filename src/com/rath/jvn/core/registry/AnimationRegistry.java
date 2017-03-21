
package com.rath.jvn.core.registry;

import java.io.File;
import java.util.HashMap;

import com.rath.jvn.core.data.SpriteAnimation;

public class AnimationRegistry {

  /** Animation that affects the positioning of sprites. */
  public static final int SPRITE_PATH = 0;

  /** Animation that adds animation to existing sprites. */
  public static final int SPRITE_DECO = 1;

  /** Animation that affects the entire screen. */
  public static final int SCREEN_ANI = 2;

  /** Map that allows fetching animation data by name. */
  private static final HashMap<String, SpriteAnimation> aniMap = new HashMap<String, SpriteAnimation>();

  /**
   * Registers a background image by name.
   * 
   * @param bgName
   * @param bgImgPath
   * @throws RegistryException
   */
  public static final void registerAnimation(final String aniName, final String aniDataPath) throws RegistryException {

    // Check if the BG is already registered
    if (aniMap.containsKey(aniName)) {
      throw new RegistryException("background", aniName, true);
    }

    @SuppressWarnings("unused")
    final File aniFile = new File(aniDataPath);

    // TODO: Read animation data from file
    // TODO: Set animation type
    // try {
    // val = ImageIO.read(imgFile);
    // } catch (IOException e) {
    // e.printStackTrace();
    // }

    // Add to the map
    // aniMap.put(aniName, val);
  }

  /**
   * Gets a background image from the map.
   * 
   * @param bgName
   * @return
   * @throws RegistryException
   * @throws AnimationFetchException
   */
  public static final SpriteAnimation getSprite(final String aniName)
      throws RegistryException, SpriteFetchException, AnimationFetchException {

    // Check if the BG is registered
    if (!aniMap.containsKey(aniName)) {
      throw new RegistryException("animation", aniName, false);
    }

    // Check for registry errors
    final SpriteAnimation ani = aniMap.get(aniName);
    if (ani == null) {
      throw new AnimationFetchException(aniName, ani);
    }

    return ani;
  }
}
