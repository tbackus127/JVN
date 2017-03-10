
package com.rath.jvn.game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.rath.jvn.core.Scene;

public class GamePanel extends JPanel {
  
  /** Minimum size of the preview window. */
  private static final Dimension MIN_DIM = new Dimension(360, 240);
  
  /** Serial version UID. */
  private static final long serialVersionUID = 1L;
  
  private final Timer repaintTimer;
  
  /** The scene to render data from. */
  private Scene scene;
  
  public GamePanel(final Scene sc) {
    super();
    setMinimumSize(MIN_DIM);
    setVisible(true);
    this.repaintTimer = new Timer(0, new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent evt) {
        repaint();
      }
    });
    this.repaintTimer.setDelay((int) (1000D / 60D));
  }
  
  public void startTimer() {
    this.repaintTimer.start();
  }
  
  public void stopTimer() {
    this.repaintTimer.stop();
  }
  
  public void updateScene(final Scene sc) {
    this.scene = sc;
  }
  
  @Override
  public Dimension getMinimumSize() {
    return MIN_DIM;
  }
  
  @Override
  public void paintComponent(final Graphics g) {
    
  }
}
