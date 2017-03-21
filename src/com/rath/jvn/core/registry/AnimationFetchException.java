package com.rath.jvn.core.registry;

import com.rath.jvn.core.data.SpriteAnimation;

public class AnimationFetchException extends Exception {

  private static final long serialVersionUID = 1L;
  private final String aniName;
  private final SpriteAnimation animationData;
  
  public AnimationFetchException(final String aniName, final SpriteAnimation ani) {
    this.aniName = aniName;
    this.animationData = ani;
  }
  
  @Override
  public String getMessage() {
    return "Animation " + this.aniName + " is null!\nData: " + this.animationData;
  }
}
