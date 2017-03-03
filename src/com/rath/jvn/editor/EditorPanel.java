
package com.rath.jvn.editor;

import javax.swing.JTabbedPane;

import com.rath.jvn.editor.flow.FlowEditorPanel;
import com.rath.jvn.editor.menu.MenuEditorPanel;
import com.rath.jvn.editor.scene.SceneEditorPanel;

/**
 * This class contains various Scene, Flow, and other types of panels as tabs.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class EditorPanel extends JTabbedPane {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public EditorPanel() {
    super();

    final SceneEditorPanel scPanel = new SceneEditorPanel();
    addTab("Scene 1", scPanel);

    final FlowEditorPanel flPanel = new FlowEditorPanel();
    addTab("Flow Editor", flPanel);

    final MenuEditorPanel mnPanel = new MenuEditorPanel();
    addTab("Menu 1", mnPanel);

    setOpaque(true);
    setVisible(true);
  }
}
