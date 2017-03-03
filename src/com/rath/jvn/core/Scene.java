
package com.rath.jvn.core;

import java.io.Serializable;

/**
 * This class handles a scene's data, and the operations performed on it.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class Scene extends AbstractScene implements Serializable {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /** Number of sprite positions. */
  private int spriteCount = -1;

  /** Sprites by ID in their positions as indeces in the array. */
  private int[] sprites = null;

  /** Currently shown background image. */
  private int bgID = -1;

  /** Currently playing background music. */
  private int bgmID = -1;

  /** The current position in the script. */
  private int currentQuote = 0;

  /** The script data as an in-order array. */
  private String[] script;

  /**
   * Default constructor.
   * 
   * @param d the prepackaged scene data.
   */
  public Scene(final SceneData d) {

    if (d == null) return;

    sceneName = d.getSceneName();
    this.spriteCount = d.getSpriteCount();
    this.bgID = d.getBgID();
    this.bgmID = d.getBgmID();
    this.currentQuote = d.getCurrentQuote();
    this.script = d.getScript();
  }

  /**
   * Gets the background image ID.
   * 
   * @return an int.
   */
  public final int getBG() {
    return this.bgID;
  }

  /**
   * Sets the background image ID.
   * 
   * @param id the ID of the background image.
   */
  public final void setBG(final int id) {
    this.bgID = id;
  }

  /**
   * Gets the ID of the currently playing song.
   * 
   * @return the BGM ID as an int.
   */
  public final int getBgmID() {
    return bgmID;
  }

  /**
   * Sets the ID of the currently playing song.
   * 
   * @param bgmID the BGM ID to be played, as an int.
   */
  public final void setBgmID(int bgmID) {
    this.bgmID = bgmID;
  }

  /**
   * Gets the current number of sprite positions.
   * 
   * @return the sprite position count as an int.
   */
  public final int getSpriteCount() {
    return this.spriteCount;
  }

  /**
   * Sets the number of available sprite positions.
   * 
   * @param count the number of positions as an int.
   */
  public final void setSpritePosCount(final int count) {
    this.spriteCount = count;
  }

  /**
   * Removes a sprite from the sprite array.
   * 
   * @param pos the position of the sprite to erase.
   */
  public final void eraseSprite(final int pos) {
    this.sprites[pos] = -1;

    // TODO: Integrate with registry system.
  }

  /**
   * Sets a sprite to be rendered.
   * 
   * @param pos the position of the sprite.
   * @param id the ID of the sprite.
   */
  public final void setSprite(final int pos, final int id) {
    this.sprites[pos] = id;

    // TODO: Integrate with registry system.
  }

  /**
   * Sets the current text to the next quote.
   */
  public final void advanceText() {
    this.currentQuote++;
  }

  /**
   * Gets the current quote.
   * 
   * @return the current line to be printed on screen as a String.
   */
  public final String getCurrentText() {
    return this.script[this.currentQuote];
  }

  /**
   * Gets the scene's script.
   * 
   * @return an array of Strings.
   */
  public String[] getScript() {
    return this.script;
  }
}
