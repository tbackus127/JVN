
package com.rath.jvn.editor.scene;

import java.util.HashMap;

public class CommandInterpreter {

  private static final HashMap<String, Integer> commandRules = new HashMap<String, Integer>() {

    {
      // Select the current speaker. Arg0:Str = Character
      put("sel", 1);

      // Play a character's voice. Arg0:Str = Voice entry name
      put("vox", 1);

      // Pause the interpreter. Arg0:int = time in ms
      put("p", 1);

      // Quote break. The interpreter will not advance past this point until the reader advances the text.
      put("qb", 0);

      // Plays a sound effect. Arg0:Str = SFX entry to play
      put("sfx", 1);

      // Changes a character's sprite to the specified emotion. Arg0:Str = Emotion ID
      put("em", 1);

      // Animates a sprite with the given animation. Arg0:Str = Animation ID
      put("anis", 1);

      // Animates the screen with the given animation. Arg0:Str = Animation ID
      put("aniscr", 1);

      // Moves a character to the given sprite position. Arg0:Str = Character ID, Arg1:int = sprite position.
      put("mvsp", 2);

      // Changes the background. Arg0:Str = Background ID
      put("bg", 1);

      // Displays a picture in the picture area. Arg0:Str = picture ID.
      put("pic", 1);

      // Changes the background music. Arg0:Str = BGM ID, Arg1:double = Volume
      put("bgm", 2);

      // Changes the number of available sprite positions. Arg0:int = Number of positions
      put("sp", 1);

      // Sets the current quote to the specified one. Arg0:int = quote to jump to
      put("jmp", 1);

      // Displays a face in the text box. Arg0:int = Sprite ID (must be a face).
      put("face", 1);

      // Sets a variable to the specified value. Arg0:Str = Var ID, Arg1:int = value.
      put("var", 2);

      // Switches a flag on or off. Arg0:Str = Flag ID, Arg1:bool = value.
      put("flg", 2);

      // "choi" = Choices. {"Choice 1", <quote to jump to if chosen>, "Choice 2", <jump>, ...}; must be even.
    }
  };

  private static final String[] interpretCommands(final String[] script) {

    final String[] result = new String[script.length];

    return result;
  }
}
