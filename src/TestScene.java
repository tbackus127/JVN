import java.awt.Dimension;

import com.rath.jvn.core.data.Scene;
import com.rath.jvn.core.data.SceneData;
import com.rath.jvn.core.engine.GameFrame;
import com.rath.jvn.core.registry.BackgroundRegistry;
import com.rath.jvn.core.registry.RegistryException;
import com.rath.jvn.core.registry.SpriteRegistry;

public class TestScene {

  public static void main(String[] args) {

    try {
      BackgroundRegistry.registerBG("NormalBG", "res/img/bg/testBG.png");
      BackgroundRegistry.registerBG("DarkBG", "res/img/bg/testBG2.png");
      SpriteRegistry.registerSprite("Alien1", "norm", SpriteRegistry.NORMAL, "res/img/sprites/ayylmao01.png");
      SpriteRegistry.registerSprite("Alien1", "sad", SpriteRegistry.NORMAL, "res/img/sprites/ayylmao02.png");
      SpriteRegistry.registerSprite("Alien2", "sad", SpriteRegistry.NORMAL, "res/img/sprites/ayylmao2-02.png");
    }
    catch (RegistryException e) {
      System.err.println(e.getMessage());
    }

    final String scName = "Test Scene";
    final int spriteCount = 2;
    final String[] sprites = new String[spriteCount];
    sprites[0] = null;
    sprites[1] = null;
    final String bgID = "NormalBG";
    final String bgmID = null;
    final String[] script = new String[9];
    script[0] = "This is a normal message.";
    script[1] = "This is a longer message that will hopefully span more than one line. Here, I'll add another sentence in just so it does. Then I can test text wrapping with this one.";
    script[2] = "A quote break should happen here.\\qb{}This line should not appear until the text is advanced again.";
    script[3] = "Multiple\\qb{} quote\\qb{} breaks.\\qb{}.\\qb{}.";
    script[4] = "\\name{Kebert Xela}Nameplate test.";
    script[5] = "Changing BG...\\qb{}\\bg{DarkBG}Changed.";
    script[6] = "Adding sprite.\\qb{}\\ssp{1}\\chsp{Alien1,norm,0}Alien1 added.";
    script[7] = "Changing emote.\\qb{}\\chse{Alien1,sad}Alien1 is now sad.";
    script[8] = "Adding alien #2.\\qb{}\\ssp{2}\\chsp{Alien2,sad}Alien 2 added.";
    final SceneData d = new SceneData(scName, spriteCount, sprites, bgID, bgmID, script);
    final Scene s = new Scene(d);

    @SuppressWarnings("unused")
    final GameFrame f = new GameFrame(s, "JVN - Test Scene", new Dimension(800, 600));
    f.render();
    
  }
}
