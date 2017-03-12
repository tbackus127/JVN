
package com.rath.jvn.editor.wizards;

import javax.swing.JFrame;

import com.rath.jvn.editor.EditorFrame;

public class NewProjectFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  
  public NewProjectFrame(final EditorFrame parent) {
    super("New Project");
    
    final NewProjectPanel npp = new NewProjectPanel();
    add(npp);
    
    pack();
    setResizable(false);
    setLocationRelativeTo(parent);
    setVisible(true);
    
  }
  
}
