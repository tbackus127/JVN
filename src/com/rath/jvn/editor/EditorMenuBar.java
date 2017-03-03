
package com.rath.jvn.editor;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

/**
 * This class contains the menu bar for the program.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class EditorMenuBar extends JMenuBar {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  /**
   * Default constructor.
   */
  public EditorMenuBar() {
    super();

    // File
    final JMenu fileMenu = new JMenu("File");
    fileMenu.setMnemonic(KeyEvent.VK_F);

    // File -> New Project
    final JMenuItem newProjItem = new JMenuItem("New Project");
    newProjItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    newProjItem.setMnemonic(KeyEvent.VK_N);
    newProjItem.getAccessibleContext()
        .setAccessibleDescription("Closes the currently running project and opens a new one.");
    fileMenu.add(newProjItem);

    // File -> Open Project...
    final JMenuItem openProjItem = new JMenuItem("Open Project...");
    openProjItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    openProjItem.setMnemonic(KeyEvent.VK_P);
    openProjItem.getAccessibleContext()
        .setAccessibleDescription("Open a " + EditorFrame.PROGRAM_NAME + " project from file.");
    fileMenu.add(openProjItem);

    // File -> Save Project
    final JMenuItem saveProjItem = new JMenuItem("Save Project");
    saveProjItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    saveProjItem.setMnemonic(KeyEvent.VK_S);
    saveProjItem.getAccessibleContext().setAccessibleDescription("Saves all changes to the project.");
    fileMenu.add(saveProjItem);

    // File -> Save Project As...
    final JMenuItem saveasProjItem = new JMenuItem("Save Project As...");
    saveasProjItem
        .setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
    saveasProjItem.setMnemonic(KeyEvent.VK_V);
    saveasProjItem.getAccessibleContext().setAccessibleDescription("Saves the entire project to the specified file.");
    fileMenu.add(saveasProjItem);

    fileMenu.addSeparator();

    // File -> Close Project
    final JMenuItem closeProjItem = new JMenuItem("Close Project");
    closeProjItem.getAccessibleContext().setAccessibleDescription("Closes the project and exits the program.");
    closeProjItem.setMnemonic(KeyEvent.VK_X);
    fileMenu.add(closeProjItem);

    add(fileMenu);
    setVisible(true);

  }
}
