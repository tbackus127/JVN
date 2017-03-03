
package com.rath.jvn.game;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;

import com.rath.jvn.core.Scene;

public class GamePanel extends JPanel {

  /** Minimum size of the preview window. */
  private static final Dimension MIN_DIM = new Dimension(360, 240);

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /** The scene to render data from. */
  private Scene scene;

  public GamePanel(final Scene sc) {
    super();
    setOpaque(true);
    setBackground(Color.BLACK);
    setSize(MIN_DIM);
    setVisible(true);
  }

  public void updateScene(final Scene sc) {
    this.scene = sc;
  }

  @Override
  public Dimension getMinimumSize() {
    return MIN_DIM;
  }

}
