
package com.rath.jvn.core.data;

import java.awt.Dimension;

/**
 * This class acts as a struct for game-wide global settings, such as resolution or framerate.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class GameSettings {

  /** The width and height of the game window. */
  private final Dimension dim;

  /**
   * Default constructor.
   * 
   * @param winDim a Dimension with the desired width and height of the game window.
   */
  public GameSettings(final Dimension winDim) {
    this.dim = winDim;
  }

  /**
   * Gets the resolution of the game window.
   * 
   * @return a Dimension object.
   */
  public Dimension getDim() {
    return this.dim;
  }

  /**
   * Gets the width of the game window.
   * 
   * @return the width of the Dimension, casted to an int.
   */
  public int getWidth() {
    return (int) dim.getWidth();
  }

  /**
   * Gets the height of the game window.
   * 
   * @return the height of the Dimension, casted to an int.
   */
  public int getHeight() {
    return (int) dim.getHeight();
  }
}
