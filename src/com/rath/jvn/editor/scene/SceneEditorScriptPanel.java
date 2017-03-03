
package com.rath.jvn.editor.scene;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.rath.jvn.core.Scene;

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
  private String[] script;

  /** The scene's script box. */
  private final JList<String> quoteList;

  public SceneEditorScriptPanel(final Dimension winSize) {
    this(winSize, null);
  }

  /**
   * Default constructor.
   */
  public SceneEditorScriptPanel(final Dimension winSize, final Scene sc) {
    super();
    setOpaque(true);
    setBackground(Color.CYAN);
    setLayout(new BorderLayout());

    if (sc == null) {
      this.script = new String[256];
      for(int i = 0; i < this.script.length; i++) {
        this.script[i] = "";
      }
    } else {
      this.script = sc.getScript();
    }

    this.quoteList = new JList<String>(this.script);
    this.quoteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    final JScrollPane listScroller = new JScrollPane(this.quoteList);
    add(listScroller, BorderLayout.CENTER);

    setVisible(true);
  }

}
