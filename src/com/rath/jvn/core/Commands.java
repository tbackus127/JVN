
package com.rath.jvn.core;

import java.util.HashMap;

public class Commands {

  public static final String CMD_BG = "bg";
  public static final String CMD_BGM = "bgm";
  public static final String CMD_SFX = "sfx";
  public static final String CMD_VOX = "vox";
  public static final String CMD_CHG_SPR = "chsp";
  public static final String CMD_CHG_EMO = "em";
  public static final String CMD_JMP = "jmp";
  public static final String CMD_ANI_SPR = "anis";
  public static final String CMD_ANI_SCR = "anic";
  public static final String CMD_PIC = "pic";
  public static final String CMD_RM_PIC = "delp";
  public static final String CMD_FACE = "face";
  public static final String CMD_SPR_POS = "ssp";
  public static final String CMD_MV_SPR = "mvsp";
  public static final String CMD_SEL = "sel";
  public static final String CMD_PAUSE = "p";
  public static final String CMD_VAR = "var";
  public static final String CMD_FLAG = "flg";
  public static final String CMD_QB = "qb";
  public static final String CMD_CHOI = "choi";

  // Keep this static to avoid memory leaks and too many anonymous classes.
  public static final HashMap<String, Integer> COMMAND_RULES = new HashMap<String, Integer>() {

    private static final long serialVersionUID = 1L;

    {
      // Select the current speaker. Arg0:Str = Character
      put(CMD_SEL, 1);

      // Play a character's voice. Arg0:Str = Voice entry name
      put(CMD_VOX, 1);

      // Pause the interpreter. Arg0:int = time in ms
      put(CMD_PAUSE, 1);

      // Quote break. The interpreter will not advance past this point until the reader advances the text.
      put(CMD_QB, 0);

      // Plays a sound effect. Arg0:Str = SFX entry to play
      put(CMD_SFX, 1);

      // Changes a character's sprite to the specified emotion. Arg0:Str = Emotion ID
      put(CMD_CHG_EMO, 1);

      // Animates a sprite with the given animation. Arg0:Str = Animation ID
      put(CMD_ANI_SPR, 1);

      // Animates the screen with the given animation. Arg0:Str = Animation ID
      put(CMD_ANI_SCR, 1);

      // Moves a character to the given sprite position. Arg0:Str = Character ID, Arg1:int = sprite position.
      put(CMD_MV_SPR, 2);

      // Changes the background. Arg0:Str = Background ID
      put(CMD_BG, 1);

      // Displays a picture in the picture area. Arg0:Str = picture ID.
      put(CMD_PIC, 1);

      // Changes the background music. Arg0:Str = BGM ID, Arg1:double = Volume
      put(CMD_BGM, 2);

      // Changes the number of available sprite positions. Arg0:int = Number of positions
      put(CMD_SPR_POS, 1);

      // Sets the current quote to the specified one. Arg0:int = quote to jump to
      put(CMD_JMP, 1);

      // Displays a face in the text box. Arg0:int = Sprite ID (must be a face).
      put(CMD_FACE, 1);

      // Sets a variable to the specified value. Arg0:Str = Var ID, Arg1:int = value.
      put(CMD_VAR, 2);

      // Switches a flag on or off. Arg0:Str = Flag ID, Arg1:bool = value.
      put(CMD_FLAG, 2);

      // "choi" = Choices. {"Choice 1", <quote to jump to if chosen>, "Choice 2", <jump>, ...}; must be even.
    }
  };
}
