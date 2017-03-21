
package com.rath.jvn.core.engine;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.Timer;

import com.rath.jvn.core.Utils;
import com.rath.jvn.core.data.GameSettings;
import com.rath.jvn.core.data.Scene;
import com.rath.jvn.core.data.SceneDataMissingException;
import com.rath.jvn.core.registry.BackgroundRegistry;
import com.rath.jvn.core.registry.RegistryException;
import com.rath.jvn.core.registry.SpriteFetchException;

public class GamePanel extends JPanel {

  /** Serial version UID. */
  private static final long serialVersionUID = 1L;

  private final Dimension size;

  private final Timer repaintTimer;

  /** The scene to render data from. */
  private Scene scene;

  public GamePanel(final GameSettings settings, final Scene sc) {
    super();
    this.size = settings.getDim();
    this.scene = sc;
    setMinimumSize(this.size);
    setVisible(true);
    this.repaintTimer = new Timer(0, new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent evt) {
        repaint();
      }
    });
    this.repaintTimer.setDelay((int) (1000D / 60D));
  }

  public void startTimer() {
    this.repaintTimer.start();
  }

  public void stopTimer() {
    this.repaintTimer.stop();
  }

  public void updateScene(final Scene sc) {
    this.scene = sc;
  }

  @Override
  public Dimension getMinimumSize() {
    return this.size;
  }

  @Override
  public void paintComponent(final Graphics g) {
    final Graphics2D g2 = (Graphics2D) g;

    g2.setColor(Color.BLACK);
    g2.fillRect(0, 0, getWidth(), getHeight());

    renderBG(g2);
    renderSprites(g2);
    renderTextBox(g2);
  }

  private void renderBG(final Graphics2D g) {
    try {
      final BufferedImage bg = Utils.scaleImage(BackgroundRegistry.getBackground(this.scene.getData().getBgID()),
          (int) size.getWidth(), (int) size.getHeight());
      g.drawImage(bg, 0, 0, null);
    }
    catch (RegistryException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (SpriteFetchException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch (SceneDataMissingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  private void renderSprites(final Graphics2D g) {

  }

  private void renderTextBox(final Graphics2D g) {

  }
}
