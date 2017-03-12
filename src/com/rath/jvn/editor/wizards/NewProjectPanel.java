
package com.rath.jvn.editor.wizards;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

public class NewProjectPanel extends JPanel {
  
  private static final long serialVersionUID = 1L;
  
  public NewProjectPanel() {
    super();
    setSize(getPreferredSize());
    setVisible(true);
    setLayout(new GridBagLayout());
    
    @SuppressWarnings("unused")
    final GridBagConstraints gb = new GridBagConstraints();
  }
  
  @Override
  public Dimension getPreferredSize() {
    return new Dimension(480, 480);
  }
  
  @Override
  public Dimension getMinimumSize() {
    return getPreferredSize();
  }
  
  @Override
  public Dimension getMaximumSize() {
    return getPreferredSize();
  }
}
