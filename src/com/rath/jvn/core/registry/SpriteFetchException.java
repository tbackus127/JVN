
package com.rath.jvn.core.registry;

import java.awt.image.BufferedImage;

public class SpriteFetchException extends Exception {

  private static final long serialVersionUID = 1L;
  private final String spriteKey;
  private final BufferedImage spriteImg;

  public SpriteFetchException(final String sk, final BufferedImage img) {
    this.spriteKey = sk;
    this.spriteImg = img;
  }

  @Override
  public String getMessage() {
    return "There was an error returning the sprite from the registry's sprite map.\n"
        + "This should not happen; please submit an issue on the project's GitHub repository or contact"
        + " the author with a step-by-step procedure that tells how to replicate this error.\n" + "Error: get("
        + this.spriteKey + "," + this.spriteImg + ")";
  }
}
