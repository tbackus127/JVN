
package com.rath.jvn.editor.scene;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

/**
 * This class acts as a wrapper for the script.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class SceneScriptHeaderPanel extends JPanel {

  /** Serial Version UID. */
  private static final long serialVersionUID = 1L;

  /** Default message for a new quote in the script. */
  private static final String DEFAULT_MESSAGE = "---";

  /** Handle to the list model. */
  private final DefaultListModel<String> listMod;

  /**
   * Default constructor.
   * 
   * @param list the script as a JList of Strings.
   * @param listMod the list model.
   */
  public SceneScriptHeaderPanel(final JList<String> list, final DefaultListModel<String> lm) {
    super();

    this.listMod = lm;
    setLayout(new FlowLayout(FlowLayout.LEFT));

    // Label
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
        renumberList();
      }

    });
    add(insButton);

    // Delete button
    final JButton rmButton = new JButton("Delete");
    rmButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent evt) {

        final int index = list.getSelectedIndex();

        if (index >= 0) {
          listMod.remove(index);
          renumberList();
        }
      }

    });

    add(rmButton);
  }

  /**
   * Renumbers the script.
   */
  private void renumberList() {
    for (int i = 0; i < this.listMod.size(); i++) {

      final String originalStr = listMod.getElementAt(i);
      
      // If the quote is already numbered
      if(originalStr.matches("\\d+:\\s+.*")) {
        
        // Numbered wrong
        if(!originalStr.startsWith("" + i + ": ")) {
          final int colIndex = originalStr.indexOf(": ");
          final String newStr = ("" + i + ": ") + originalStr.substring(colIndex + 2);
          listMod.remove(i);
          listMod.add(i, newStr);
          continue;
        }
        continue;
      }
      
      // Not numbered
      listMod.remove(i);
      listMod.add(i, ("" + i + ": ") + originalStr);
    }
  }
}
