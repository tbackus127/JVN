
package com.rath.jvn.core;

public class AnimationException extends Exception {

  private static final long serialVersionUID = 1L;
  private final String aniKey;
  private final SpriteAnimation ani;

  public AnimationException(final String ak, final SpriteAnimation sa) {
    this.aniKey = ak;
    this.ani = sa;
  }

  @Override
  public String getMessage() {
    return "There was an error returning the animation from the registry's animation map.\n"
        + "This should not happen; please submit an issue on the project's GitHub repository or contact"
        + " the author with a step-by-step procedure that tells how to replicate this error.\n" + "Error: get("
        + this.aniKey + "," + this.ani + ")";
  }
}
