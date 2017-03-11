
package com.rath.jvn.editor.scene;

import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class SceneEditorQuotePanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private final DefaultListModel<String> listMod = new DefaultListModel<String>();
  private final JList<String> commands = new JList<String>(this.listMod);

  public SceneEditorQuotePanel(final String commandString) {
    super();
    setLayout(new BorderLayout());

    final JLabel cmdLabel = new JLabel("Commands");
    add(cmdLabel, BorderLayout.NORTH);

    final JScrollPane listScroller = new JScrollPane(this.commands);
    add(listScroller, BorderLayout.CENTER);

    setVisible(true);
  }
}
