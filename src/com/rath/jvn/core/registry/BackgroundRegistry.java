
package com.rath.jvn.core.registry;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class BackgroundRegistry {
  
  private static final HashMap<String, BufferedImage> bgMap = new HashMap<String, BufferedImage>();
  
  /**
   * Registers a background image by name.
   * 
   * @param bgName
   * @param bgImgPath
   * @throws RegistryException
   */
  public static final void registerBG(final String bgName, final String bgImgPath) throws RegistryException {
    
    // Check if the BG is already registered
    if (bgMap.containsKey(bgName)) {
      throw new RegistryException("background", bgName, true);
    }
    
    final File imgFile = new File(bgImgPath);
    BufferedImage val = null;
    
    // Read the image in
    try {
      val = ImageIO.read(imgFile);
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    // Add to the map
    bgMap.put(bgName, val);
  }
  
  /**
   * Gets a background image from the map.
   * 
   * @param bgName
   * @return
   * @throws RegistryException
   * @throws SpriteFetchException
   */
  public static final BufferedImage getSprite(final String bgName) throws RegistryException, SpriteFetchException {
    
    // Check if the BG is registered
    if (!bgMap.containsKey(bgName)) {
      throw new RegistryException("background", bgName, false);
    }
    
    // Check for registry errors
    final BufferedImage img = bgMap.get(bgName);
    if (img == null) {
      throw new SpriteFetchException(bgName, img);
    }
    
    return img;
  }
}
