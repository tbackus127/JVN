
package com.rath.jvn.editor.scene;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.rath.jvn.core.Scene;

/**
 * This panel shows a WYSIWYG preview of the current scene's at the selected script point.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneEditorPreviewPanel extends JPanel {
  
  /** Serial version UID. */
  private static final long serialVersionUID = 1L;
  
  /** The current Scene data. */
  private Scene scene;
  
  /**
   * Default constructor.
   */
  public SceneEditorPreviewPanel(final Scene sc) {
    super();
    this.scene = sc;
  }
  
  /**
   * Updates the preview panel.
   * 
   * @param sc the Scene data to be rendered.
   */
  public void updateScene(final Scene sc) {
    this.scene = sc;
  }
  
  /**
   * Rendering method.
   * 
   * @param g the Graphics object that will be used to paint with.
   */
  @Override
  public void paintComponent(Graphics g) {
    
  }
}
