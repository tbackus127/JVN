package com.rath.jvn.core.data;

import java.awt.Dimension;

public class GameSettings {

  private final Dimension dim;
  
  public GameSettings(final Dimension winDim) {
    this.dim = winDim;
  }

  public Dimension getDim() {
    return this.dim;
  }
  
  public int getWidth() {
    return (int) dim.getWidth();
  }

  public int getHeight() {
    return (int) dim.getHeight();
  }
}
