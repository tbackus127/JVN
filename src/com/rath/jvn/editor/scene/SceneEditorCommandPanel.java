
package com.rath.jvn.editor.scene;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SceneEditorCommandPanel extends JPanel {
  
  private static final long serialVersionUID = 1L;
  
  public SceneEditorCommandPanel(final Dimension parDim) {
    super();
    setLayout(new GridBagLayout());
    
    final GridBagConstraints gb = new GridBagConstraints();
    gb.anchor = GridBagConstraints.NORTHWEST;
    gb.fill = GridBagConstraints.BOTH;
    gb.insets = new Insets(4, 4, 4, 4);
    gb.weightx = 1.0D;
    gb.weighty = 1.0D;
    
    gb.gridx = 0;
    gb.gridy = 0;
    final JButton btn1 = new JButton("Ignore");
    add(btn1, gb);
    
    gb.gridx = 1;
    final JButton btn2 = new JButton("these");
    add(btn2, gb);
    
    gb.gridx = 2;
    final JButton btn3 = new JButton("for now.");
    add(btn3, gb);
    
    setVisible(true);
  }
}
