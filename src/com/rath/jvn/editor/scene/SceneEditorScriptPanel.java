
package com.rath.jvn.editor.scene;

import javax.swing.JList;
import javax.swing.JPanel;

/**
 * This panel will contain the current open scene's script.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneEditorScriptPanel extends JPanel {
  
  /** Serial version UID. */
  private static final long serialVersionUID = 1L;
  
  /** The scene's script. */
  private final JList<String> quoteList;
  
  /**
   * Default constructor.
   */
  public SceneEditorScriptPanel() {
    super();
    this.quoteList = new JList<String>();
  }
  
}
