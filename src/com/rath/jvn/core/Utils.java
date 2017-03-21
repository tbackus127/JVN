
package com.rath.jvn.core;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 * This class acts as a utility suite for various operations.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class Utils {

  /**
   * Scales a BufferedImage to the specified dimensions.
   * 
   * @param imgSrc the original image.
   * @param x length of the image.
   * @param y height of the image.
   * @return the scaled BufferedImage.
   */
  public static final BufferedImage scaleImage(final BufferedImage imgSrc, final int x, final int y) {
    return convertImage(imgSrc.getScaledInstance(x, y, Image.SCALE_SMOOTH));
  }

  /**
   * Converts an Image into a BufferedImage when casting does not work.
   * 
   * @param img the Image to convert to a BufferedImage.
   * @return the BufferedImage that was converted.
   */
  private static final BufferedImage convertImage(final Image img) {
    final BufferedImage result = new BufferedImage(img.getWidth(null), img.getHeight(null),
        BufferedImage.TYPE_INT_ARGB);
    result.getGraphics().drawImage(img, 0, 0, null);
    return result;
  }
}
