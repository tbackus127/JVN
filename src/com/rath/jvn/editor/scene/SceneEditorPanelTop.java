
package com.rath.jvn.editor.scene;

import java.awt.Dimension;

import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;

import com.rath.jvn.core.Scene;
import com.rath.jvn.editor.EditorFrame;
import com.rath.jvn.game.GamePanel;

/**
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneEditorPanelTop extends JSplitPane {
  
  private static final long serialVersionUID = 1L;
  
  public SceneEditorPanelTop(final Dimension winSize) {
    super();
    
    final SceneEditorScriptPanel scrPanel = new SceneEditorScriptPanel(winSize);
    setLeftComponent(scrPanel);
    
    final GamePanel gPanel = new GamePanel(new Scene(null));
    setRightComponent(gPanel);
    
    this.setVisible(true);
  }
  
  @Override
  public void setVisible(final boolean v) {
    super.setVisible(v);
    
    SwingUtilities.invokeLater(new Runnable() {
      
      @Override
      public void run() {
        setDividerLocation(EditorFrame.DIV_VERT_PERC);
      }
    });
  }
  
}
