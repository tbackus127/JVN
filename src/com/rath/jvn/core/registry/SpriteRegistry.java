
package com.rath.jvn.core.registry;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

/**
 * This class handles registering sprites and fetching them by name instead of ID or filename.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SpriteRegistry {

  /** The symbol used to separate the sprite name in the registry. */
  private static final char SPRITE_NAME_SEPARATOR = '_';

  /** Sprite mode for normal sprites. */
  public static final int NORMAL = 0;

  /** Sprite mode for text box faces. */
  public static final int FACE = 1;

  /** Sprite mode for generic pictures. */
  public static final int PICTURE = 2;

  /** The sprite map using the name as a key and the image as a value. */
  private static HashMap<String, BufferedImage> spriteMap = new HashMap<String, BufferedImage>();

  /**
   * Registers a sprite with the system.
   * 
   * @param charName the character's name.
   * @param charEmote the character's emotion.
   * @param imgPath the path to the image file.
   * @throws RegistryException if the sprite is already registered.
   */
  public static final void registerSprite(final String charName, final String charEmote, final int mode,
      final String imgPath) throws RegistryException {
    
    // TODO: Take mode into consideration
    final String key = getCombinedSpriteName(charName, charEmote);

    if (spriteMap.containsKey(key)) {
      throw new RegistryException("sprite", key, true);
    }

    final File imgFile = new File(imgPath);
    BufferedImage val = null;

    // Read the image in
    try {
      val = ImageIO.read(imgFile);
    }
    catch (IOException e) {
      e.printStackTrace();
    }

    // Add to the map
    spriteMap.put(key, val);

  }

  /**
   * Gets a sprite by their name and emotion.
   * 
   * @param charName the name of the character.
   * @param charEmote the character's emotion.
   * @return the sprite as a BufferedImage.
   * @throws RegistryException if the sprite has not yet been registered.
   * @throws SpriteFetchException if there was an error reading the sprite into a BufferedImage.
   */
  public static final BufferedImage getSprite(final String charName, final String charEmote)
      throws RegistryException, SpriteFetchException {

    final String key = getCombinedSpriteName(charName, charEmote);

    // Check if the sprite is registered
    if (!spriteMap.containsKey(key)) {
      throw new RegistryException("sprite", key, false);
    }

    // Check for registry errors
    final BufferedImage img = spriteMap.get(key);
    if (img == null) {
      throw new SpriteFetchException(key, img);
    }

    return img;
  }

  /**
   * Gets the combined String for use with the sprite map.
   * 
   * @param charName the name of the character.
   * @param charEmote the emotion of the character.
   * @return the combined String.
   */
  private static String getCombinedSpriteName(final String charName, final String charEmote) {
    return charName + SPRITE_NAME_SEPARATOR + charEmote;
  }
}
