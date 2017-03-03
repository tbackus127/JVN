import javax.swing.SwingUtilities;

import com.rath.jvn.editor.EditorFrame;

/**
 * Main class.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class Main {

  /**
   * Main method.
   * 
   * @param args runtime args (currently unused).
   */
  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {

        @SuppressWarnings("unused")
        final EditorFrame f = new EditorFrame();
      }
    });
  }
}
