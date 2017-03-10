
package com.rath.jvn.editor.scene;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
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
  private ArrayList<String> script;

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
    setLayout(new BorderLayout());

    this.script = new ArrayList<String>();

    final DefaultListModel listMod = new DefaultListModel<String>(); 
    this.quoteList = new JList<String>(listMod);
    this.quoteList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.quoteList.setFixedCellHeight(16);
    final JScrollPane listScroller = new JScrollPane(this.quoteList);
    add(listScroller, BorderLayout.CENTER);

    final SceneScriptHeaderPanel header = new SceneScriptHeaderPanel(this.quoteList, listMod);
    add(header, BorderLayout.NORTH);

    setVisible(true);
  }

  @Override
  public Dimension getMinimumSize() {
    return new Dimension(240, (int) super.getMinimumSize().getHeight());
  }
}
