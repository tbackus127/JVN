
package com.rath.jvn.core.registry;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.rath.jvn.core.SpriteImageException;

/**
 * This class handles registering sprites and fetching them by name instead of ID or filename.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SpriteRegistry {

  /** The symbol used to separate the sprite name in the registry. */
  private static final char SPRITE_NAME_SEPARATOR = '_';

  /** The sprite map using the name as a key and the image as a value. */
  private static HashMap<String, BufferedImage> spriteMap = new HashMap<String, BufferedImage>();

  /**
   * Registers a sprite with the system.
   * 
   * @param charName the character's name.
   * @param charEmote the character's emotion.
   * @param imgPath the path to the image file.
   */
  public static void registerSprite(final String charName, final String charEmote, final String imgPath) {
    final String key = getCombinedSpriteName(charName, charEmote);
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
   * @throws SpriteNotRegisteredException
   * @throws SpriteImageException
   */
  public static BufferedImage getSprite(final String charName, final String charEmote)
      throws SpriteNotRegisteredException, SpriteImageException {

    final String key = getCombinedSpriteName(charName, charEmote);

    // Check if the sprite is registered
    if (!spriteMap.containsKey(key)) {
      throw new SpriteNotRegisteredException(key);
    }

    // Check for registry errors
    final BufferedImage img = spriteMap.get(key);
    if (img == null) {
      throw new SpriteImageException(key, img);
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
