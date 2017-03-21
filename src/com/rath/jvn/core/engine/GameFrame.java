
package com.rath.jvn.core.engine;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.rath.jvn.core.data.Scene;

public class GameFrame extends JFrame {
  
  /** Serial Version UID. */
  private static final long serialVersionUID = 1L;
  
  public GameFrame(final Scene s, final String title, final Dimension windowSize) {
    super(title);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(windowSize);
    setResizable(false);
    setLocationRelativeTo(null);
    
    final GamePanel gp = new GamePanel(s);
    add(gp);
    
    setVisible(true);
  }
}
