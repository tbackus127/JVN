
package com.rath.jvn.core.data;

import java.io.Serializable;

/**
 * This class serves as a template for Scenes and MenuScenes.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public abstract class AbstractScene implements Serializable {

  /** Serial version UID. */
  protected static final long serialVersionUID = 1L;

  /** The name of the scene. */
  protected String sceneName;

  /**
   * Gets the name of the Scene.
   * 
   * @return the user-defined Scene name as a String.
   */
  public final String getSceneName() {
    return sceneName;
  }

  /**
   * Sets the name of the Scene.
   * 
   * @param sceneName gets the Scene name as a String.
   */
  public final void setSceneName(String sceneName) {
    this.sceneName = sceneName;
  }
}
