
package com.rath.jvn.core.data;

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

  /** Data for this scene. */
  private final SceneData data;

  /**
   * Default constructor.
   * 
   * @param d the prepackaged scene data.
   */
  public Scene(final SceneData d) {
    this.data = d;
  }

  /**
   * Gets the current data for this scene.
   * 
   * @return a SceneData object.
   * @throws SceneDataMissingException
   */
  public final SceneData getData() throws SceneDataMissingException {
    if (this.data == null) {
      throw new SceneDataMissingException();
    }
    return this.data;
  }

  /**
   * Writes this scene's data to file.
   */
  public void writeScene() {
    // TODO: Actually write scene data
    // this.data.writeToFile("scene/" + sceneName + ".jvnsc");
  }
}
