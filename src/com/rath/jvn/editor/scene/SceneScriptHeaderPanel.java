
package com.rath.jvn.editor.scene;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class SceneScriptHeaderPanel extends JPanel {

  /** Serial Version UID. */
  private static final long serialVersionUID = 1L;

  /** Default message for a new quote in the script. */
  private static final String DEFAULT_MESSAGE = "---";

  public SceneScriptHeaderPanel(final JList<String> list, final DefaultListModel<String> listMod) {
    super();
    setLayout(new FlowLayout(FlowLayout.LEFT));

    final JLabel scriptLabel = new JLabel("  Script");
    add(scriptLabel);

    // Insert button
    final JButton insButton = new JButton("Insert");
    insButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent evt) {
        final int index = list.getSelectedIndex();
        if (index < 0) {

          // append
          listMod.addElement(DEFAULT_MESSAGE);

        } else {

          // insert after
          listMod.add(index, DEFAULT_MESSAGE);

        }
      }

    });
    add(insButton);

    // Delete button
    final JButton rmButton = new JButton("Delete");
    rmButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent evt) {

        final int index = list.getSelectedIndex();
        
        if(index >= 0) {
          listMod.remove(index);
        }
      }

    });

    add(rmButton);
  }
}
