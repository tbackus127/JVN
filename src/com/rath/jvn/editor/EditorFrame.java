
package com.rath.jvn.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

/**
 * This class controls the main editor frame.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class EditorFrame extends JFrame {

  /** The preferred size of the window. */
  public static final transient Dimension PREFERRED_DIM = new Dimension(1280, 720);

  /** The minimum size of the window. */
  public static final transient Dimension MIN_DIM = new Dimension(800, 600);

  /** Relative location of the horizontal divider. */
  public static final transient double DIV_HORIZ_PERC = 0.8D;

  /** Relative location of the vertical divider. */
  public static final transient double DIV_VERT_PERC = 0.3D;

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

    setLayout(new GridLayout());
    setMinimumSize(MIN_DIM);
    setSize(PREFERRED_DIM);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);

    final EditorMenuBar menuBar = new EditorMenuBar();
    setJMenuBar(menuBar);

    final Dimension windowDim = this.getSize();
    System.out.println(windowDim);
    final EditorPanel tabPanel = new EditorPanel(windowDim);
    add(tabPanel, BorderLayout.CENTER);

    pack();
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
