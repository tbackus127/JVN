
package com.rath.jvn.editor.scene;

import java.awt.Color;

import javax.swing.JPanel;

/**
 * This class acts as a wrapper panel for the Scene editor.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneEditorPanel extends JPanel {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public SceneEditorPanel() {
    super();
    setOpaque(true);
    setBackground(Color.CYAN);
    
    final SceneEditorPanelTop topPanel = new SceneEditorPanelTop();
    add(topPanel);
    
    final SceneEditorPanelBottom botPanel = new SceneEditorPanelBottom();
    add(botPanel);
    
    setVisible(true);
  }

}
