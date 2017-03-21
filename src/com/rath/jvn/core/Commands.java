
package com.rath.jvn.core;

import java.util.HashMap;

/**
 * This class contains the script mnemonics for commands.
 * 
 * @author Tim Backus tbackus127@gmail.com
 *
 */
public class Commands {

  /** Set background. */
  public static final String CMD_BG = "bg";

  /** Set background music. */
  public static final String CMD_BGM = "bgm";

  /** Play sound effect. */
  public static final String CMD_SFX = "sfx";

  /** Play voice. */
  public static final String CMD_VOX = "vox";

  /** Change the sprite of a character to another of their sprites. */
  public static final String CMD_CHG_SPR = "chsp";

  /** Change the emotion of one character to another of their emotions. */
  public static final String CMD_CHG_EMO = "em";

  /** Jump to the specified quote position. */
  public static final String CMD_JMP = "jmp";

  /** Play a sprite animation. */
  public static final String CMD_ANI_SPR = "anis";

  /** Play an animation on the entire screen. */
  public static final String CMD_ANI_SCR = "anic";

  /** Show an image in the middle of the screen; it is treated as a sprite with ID="$PIC". */
  public static final String CMD_PIC = "pic";

  /** Removes the displayed image from the screen. */
  public static final String CMD_RM_PIC = "delp";

  /** Shows a character face image in the text box. */
  public static final String CMD_FACE = "face";

  /**
   * Sets the number of available sprite positions. Sprite positions will be divided equally along the horizontal axis
   * of the game window, and centered.
   */
  public static final String CMD_SPR_POS = "ssp";

  /** Moves the specified character to the desired sprite position. */
  public static final String CMD_MV_SPR = "mvsp";

  /** Selects the character that is currently talking. Also used to shorten many commands. */
  public static final String CMD_SEL = "sel";

  /** Pause text advancement for a specified length of time, in milliseconds. */
  public static final String CMD_PAUSE = "p";

  /** Set the value of a game variable. */
  public static final String CMD_VAR = "var";

  /** Set the value of a game flag. */
  public static final String CMD_FLAG = "flg";

  /** Stops the text from advancing until the player advances the text manually. */
  public static final String CMD_QB = "qb";

  /** Performs choice branching. */
  public static final String CMD_CHOI = "choi";

  // Keep this static to avoid memory leaks and too many anonymous classes.
  /** Commands and how many arguments they take. */
  public static final HashMap<String, Integer> COMMAND_RULES = new HashMap<String, Integer>() {

    /** Serial version UID. */
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
