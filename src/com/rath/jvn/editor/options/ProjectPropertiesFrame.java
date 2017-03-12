
package com.rath.jvn.editor.options;

import javax.swing.JFrame;

import com.rath.jvn.editor.EditorFrame;

public class ProjectPropertiesFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  
  public ProjectPropertiesFrame(final EditorFrame parent) {
    super("Project Properties");
    
    final ProjectPropertiesPanel propPanel = new ProjectPropertiesPanel();
    add(propPanel);
    pack();
    
    setResizable(false);
    setLocationRelativeTo(parent);
    setVisible(true);
  }
}
