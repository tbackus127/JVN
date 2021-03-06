
package com.rath.jvn.core.data;

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
  private int spriteCount;

  /** The sprites currently in the scene. */
  private String[] sprites;

  /** The currently displayed background ID. */
  private String bgID;

  /** The currently playing background music ID. */
  private String bgmID;

  /** The current script position. */
  private String currentQuote;

  /** The script of the scene. */
  private final String[] script;

  /**
   * Default constructor. Constructs an empty scene.
   * 
   * @param name the name of the Scene as a String.
   * @param scr the script.
   */
  public SceneData(final String name, String[] scr) {
    this(name, 0, null, null, null, scr);
  }

  /**
   * Constructs a new scene, specifying the number of sprite positions, sprites, current background, current BGM, and
   * the script.
   * 
   * @param n the name of the Scene as a String.
   * @param sc the number of sprite positions.
   * @param sp the sprites and their positions.
   * @param bg the current background ID.
   * @param bgm the currently playing BGM ID.
   * @param scr the script.
   */
  public SceneData(final String n, final int sc, final String[] sp, final String bg, final String bgm,
      final String[] scr) {

    this.sceneName = n;
    this.spriteCount = sc;
    this.sprites = sp;
    this.bgID = bg;
    this.bgmID = bgm;
    this.currentQuote = "";
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
   * @return the number of available sprite positions, from 0.
   */
  public int getSpriteCount() {
    return spriteCount;
  }

  /**
   * Gets the current sprites as an array in their positions.
   * 
   * @return an array with the indexes of sprite names representing their respective positions on screen.
   */
  public String[] getSprites() {
    return sprites;
  }

  /**
   * Gets the background name.
   * 
   * @return an int.
   */
  public String getBgID() {
    return bgID;
  }

  /**
   * Gets the ID of the playing background music.
   * 
   * @return an int.
   */
  public String getBgmID() {
    return bgmID;
  }

  /**
   * Gets the current line in the script.
   * 
   * @return an int.
   */
  public String getCurrentQuote() {
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
