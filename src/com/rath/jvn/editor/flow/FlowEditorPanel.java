
package com.rath.jvn.editor.flow;

import java.awt.Color;

import javax.swing.JPanel;

import com.rath.jvn.editor.EditorFrame;

/**
 * This class acts as a wrapper panel for the Scene editor.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class FlowEditorPanel extends JPanel {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public FlowEditorPanel() {
    super();
    setMinimumSize(EditorFrame.MIN_DIM);
    setOpaque(true);
    setBackground(Color.DARK_GRAY);
    setVisible(true);
  }

}
