
package com.rath.jvn.core;

/**
 * This class serves as a struct for a Scene's data.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneData {

  /** The name of the Scene seen in the editor. */
  private final String sceneName;

  /** The maximum number of sprite positions. */
  private final int spriteCount;

  /** The sprites currently in the scene. */
  private final int[] sprites;

  /** The currently displayed background ID. */
  private final int bgID;

  /** The currently playing background music ID. */
  private final int bgmID;

  /** The current script position. */
  private final int currentQuote;

  /** The script of the scene. */
  private final String[] script;

  /**
   * Default constructor.
   * 
   * @param n the name of the Scene as a String.
   * @param sc the number of sprite positions.
   * @param sp the sprites and their positions.
   * @param bg the current background ID.
   * @param bgm the currently playing BGM ID.
   * @param q the current line of the script.
   * @param scr the script.
   */
  public SceneData(final String n, final int sc, final int[] sp, final int bg, final int bgm, final int q,
      final String[] scr) {

    this.sceneName = n;
    this.spriteCount = sc;
    this.sprites = sp;
    this.bgID = bg;
    this.bgmID = bgm;
    this.currentQuote = q;
    this.script = scr;
  }

  /**
   * Gets the name of the scene.
   * 
   * @return the name of the scene as a String.
   */
  public String getSceneName() {
    return sceneName;
  }

  /**
   * Gets the number of sprite positions.
   * 
   * @return an int.
   */
  public int getSpriteCount() {
    return spriteCount;
  }

  /**
   * Gets the current sprites as an array.
   * 
   * @return an array with the indexes of sprite IDs representing their respective positions on screen.
   */
  public int[] getSprites() {
    return sprites;
  }

  /**
   * Gets the background ID.
   * 
   * @return an int.
   */
  public int getBgID() {
    return bgID;
  }

  /**
   * Gets the ID of the playing background music.
   * 
   * @return an int.
   */
  public int getBgmID() {
    return bgmID;
  }

  /**
   * Gets the current line in the script.
   * 
   * @return an int.
   */
  public int getCurrentQuote() {
    return currentQuote;
  }

  /**
   * Gets the entire Scene's script.
   * 
   * @return an array of Strings, indexed sequentially.
   */
  public String[] getScript() {
    return script;
  }
}