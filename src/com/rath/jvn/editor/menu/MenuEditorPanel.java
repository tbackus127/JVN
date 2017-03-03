
package com.rath.jvn.editor.menu;

import java.awt.Color;

import javax.swing.JPanel;

import com.rath.jvn.editor.EditorFrame;

/**
 * This class acts as a wrapper panel for the Scene editor.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class MenuEditorPanel extends JPanel {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public MenuEditorPanel() {
    super();
    setMinimumSize(EditorFrame.MIN_DIM);
    setOpaque(true);
    setBackground(Color.ORANGE);
    setVisible(true);
  }

}
