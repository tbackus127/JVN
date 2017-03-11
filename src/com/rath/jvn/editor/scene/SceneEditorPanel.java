
package com.rath.jvn.editor.scene;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import com.rath.jvn.editor.EditorFrame;

/**
 * This class acts as a wrapper panel for the Scene editor.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneEditorPanel extends JSplitPane {
  
  /** Serial version UID. */
  private static final long serialVersionUID = 1L;
  
  /**
   * Default constructor.
   */
  public SceneEditorPanel(final Dimension winSize) {
    super();
    this.setOrientation(JSplitPane.VERTICAL_SPLIT);
    setOpaque(true);
    setBackground(Color.CYAN);
    
    final SceneEditorPanelTop topPanel = new SceneEditorPanelTop(winSize);
    setTopComponent(topPanel);
    
    final SceneEditorPanelBottom botPanel = new SceneEditorPanelBottom(winSize);
    setBottomComponent(botPanel);
    this.setVisible(true);
  }
  
  /**
   * Sets whether or not this panel is visible and sets the divider location.
   * 
   * @param v true if visible; false if not.
   */
  @Override
  public void setVisible(final boolean v) {
    super.setVisible(v);
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        setDividerLocation(EditorFrame.DIV_HORIZ_PERC);
      }
    });
  }
  
  @Override
  public Dimension getPreferredSize() {
    return EditorFrame.PREFERRED_DIM;
  }
  
  @Override
  public Dimension getMinimumSize() {
    return EditorFrame.MIN_DIM;
  }
}
