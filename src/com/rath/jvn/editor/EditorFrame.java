
package com.rath.jvn.editor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class controls the main editor frame.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class EditorFrame extends JFrame {

  /** The preferred size of the window. */
  private static final transient Dimension PREFERRED_DIM = new Dimension(1024, 800);

  /** The minimum size of the window. */
  private static final transient Dimension MIN_DIM = new Dimension(800, 600);

  /** The program version string. */
  private static final String PROGRAM_VERSION = "dev03032017";

  /** The name of this program. */
  public static final String PROGRAM_NAME = "JVN";

  /** The editor title. */
  private static final String PROGRAM_NAME_STRING = PROGRAM_NAME + " - " + PROGRAM_VERSION;

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor. Starts the editor.
   */
  public EditorFrame() {
    super(PROGRAM_NAME_STRING);

    // TODO: Remove once done resizing
    getContentPane().setBackground(Color.BLACK);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

    final EditorMenuBar menuBar = new EditorMenuBar();
    setJMenuBar(menuBar);

    final EditorPanel tabPanel = new EditorPanel();
    add(tabPanel, BorderLayout.CENTER);

    setVisible(true);
  }

  /**
   * Gets the preferred size of the editor window.
   * 
   * @return the global constant PREFERRED_DIM as a Dimension.
   */
  @Override
  public Dimension getPreferredSize() {
    return PREFERRED_DIM;
  }

  /**
   * Gets the minimum size of the editor window.
   * 
   * @return the global constant MIN_DIM as a Dimension.
   */
  @Override
  public Dimension getMinimumSize() {
    return MIN_DIM;
  }
}
