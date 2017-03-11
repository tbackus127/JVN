import java.awt.Dimension;

import com.rath.jvn.core.Scene;
import com.rath.jvn.core.SceneData;
import com.rath.jvn.core.registry.AnimationRegistry;
import com.rath.jvn.core.registry.BackgroundRegistry;
import com.rath.jvn.core.registry.RegistryException;
import com.rath.jvn.core.registry.SpriteRegistry;
import com.rath.jvn.game.GameFrame;

public class TestGrisaiaScene {

  public static void main(String[] args) {

    try {
      SpriteRegistry.registerSprite("Sachi", "Stare01", SpriteRegistry.NORMAL, "resx/img/sprites/Sachi/stare01.png");
      SpriteRegistry.registerSprite("Sachi", "Smile02", SpriteRegistry.NORMAL, "resx/img/sprites/Sachi/smile02.png");
      SpriteRegistry.registerSprite("Sachi", "Smile03", SpriteRegistry.NORMAL, "resx/img/sprites/Sachi/smile03.png");
      SpriteRegistry.registerSprite("Michiru", "FEyesClosed01", SpriteRegistry.FACE,
          "resx/img/sprites/Michiru/face-EyesClosed01.png");
      SpriteRegistry.registerSprite("Sachi", "Stare02", SpriteRegistry.NORMAL, "resx/img/sprites/Sachi/stare02.png");
      SpriteRegistry.registerSprite("Michiru", "FCri", SpriteRegistry.FACE, "resx/img/sprites/Michiru/face-Cry.png");
      SpriteRegistry.registerSprite("Michiru", "FCringe", SpriteRegistry.FACE,
          "resx/img/sprites/Michiru/face-Cringe.png");

      BackgroundRegistry.registerBG("DormHall", "resx/img/bg/dormHall.png");
      BackgroundRegistry.registerBG("MichiRoom", "resx/img/bg/michiRoom.png");

      AnimationRegistry.registerAnimation("QuickShake", "resx/ani/quickShake.jvnani");
      AnimationRegistry.registerAnimation("VertShake", "resx/ani/vertShake.jvnani");
    }
    catch (RegistryException e) {
      System.err.println(e.getMessage());
    }

    final String scName = "Test Scene - Sachi Slap";
    final int spriteCount = 1;
    final int[] sprites = new int[spriteCount];
    sprites[0] = -1;
    final int bgID = -1;
    final int bgmID = -1;
    final int qpos = 0;
    final String[] script = new String[9];

    script[0] = "\\sel{Sachi}\\em{Stare01}\\vox{S13-TheDoor}The door's locked...";
    script[1] = "\\sel{Sachi}\\em{Smile02}\\vox{S13-IllJust}I'll just pick the lock.";
    script[2] = "\\sel{Sachi}\\sfx{DoorOpen02}\\wsfx{}\\bg{MichirusRoom}\\em{Smile03}\\vox{S13-GoodMorn}Good morning, Michiru-sama!";
    script[3] = "\\sel{Michiru}\\face{MichiruEyesClosed01}\\vox{S13-SunDairy}Stupid Yuuji... it's 'tsundere', not 'Sun Dairy'...";
    script[4] = "\\sel{Sachi}\\em{Stare02}\\vox{S13-PreSlapHmm}...";
    script[5] = "\\sel{Sachi}\\em{Stare02}\\vox{S13-WhereGoods}Where are the goods?";
    script[6] = "\\sel{Michiru}\\sfx{Slap}\\face{MichiCringe}\\ani{FACE,QuickShake,false}\\vox{S13-Slapped01}Nnn...";
    script[7] = "\\copy{5}";
    script[8] = "\\sel{Michiru}\\sfx{Slap}\\face{MichiCringe}\\ani{FACE,QuickShake,false}\\vox{S13-Slapped02}Nnnnnn...";
    script[9] = "\\copy{5}";
    script[10] = "\\sel{Michiru}\\sfx{Slap}\\face{MichiSurp}\\ani{FACE,VertShake,false}\\vox{S13-Slapped03}Hwaaugh! Sachi!?";
    script[11] = "\\copy{5}";
    script[12] = "\\sel{Michiru}\\sfx{Slap}\\face{MichiSurp}\\ani{FACE,VertShake,false}\\vox{S13-Slapped04}Ow...\\p{400}\\sfx{Slap}\\face{MichiCri}\\ani{FACE,VertShake,false}Ouch!!";
    script[13] = "\\copy{5}";

    final SceneData d = new SceneData(scName, spriteCount, sprites, bgID, bgmID, qpos, script);
    final Scene s = new Scene(d);

    @SuppressWarnings("unused")
    final GameFrame f = new GameFrame(s, scName, new Dimension(800, 600));
  }
}
