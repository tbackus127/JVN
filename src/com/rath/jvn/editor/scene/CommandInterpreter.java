
package com.rath.jvn.editor.scene;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CommandInterpreter {
  
  public static final String BAD_COMMAND_LABEL = "!! BAD COMMAND !!";
  public static final String REGEX_SPLITTER = "(?<!\\\\)}";
  public static final String COMMAND_LABEL_SEPARATOR = ": ";
  
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
  
  public static final String LBL_TEXT = "Show text";
  public static final String LBL_BG = "Set background";
  public static final String LBL_BGM = "Set BGM";
  public static final String LBL_SFX = "Play SFX";
  public static final String LBL_VOX = "Play voice";
  public static final String LBL_CHG_SPR = "Change Sprite";
  public static final String LBL_CHG_EMO = "Change Emotion";
  public static final String LBL_JMP = "Jump to quote";
  public static final String LBL_ANI_SPR = "Animate sprite";
  public static final String LBL_ANI_SCR = "Animate screen";
  public static final String LBL_PIC = "Show picture";
  public static final String LBL_RM_PIC = "Erase picture";
  public static final String LBL_FACE = "Set textbox face";
  public static final String LBL_SPR_POS = "Set sprite positions";
  public static final String LBL_MV_SPR = "Move sprite";
  public static final String LBL_SEL = "Set current character";
  public static final String LBL_PAUSE = "Pause text advancement";
  public static final String LBL_VAR = "Set variable";
  public static final String LBL_FLAG = "Set flag";
  public static final String LBL_QB = "Pause until player advances text.";
  public static final String LBL_CHOI = "Choice branching";
  
  private static final HashSet<String> specialCommands = new HashSet<String>() {
    
    private static final long serialVersionUID = 1L;
    
    {
      add(CMD_CHOI);
    }
  };
  
  private static final HashMap<String, String> commandLabels = new HashMap<String, String>() {
    
    private static final long serialVersionUID = 1L;
    
    {
      put(CMD_SEL, LBL_SEL);
      put(CMD_VOX, LBL_VOX);
      put(CMD_PAUSE, LBL_PAUSE);
      put(CMD_QB, LBL_QB);
      put(CMD_SFX, LBL_SFX);
      put(CMD_CHG_EMO, LBL_CHG_EMO);
      put(CMD_ANI_SPR, LBL_ANI_SPR);
      put(CMD_ANI_SCR, LBL_ANI_SCR);
      put(CMD_MV_SPR, LBL_MV_SPR);
      put(CMD_BG, LBL_BG);
      put(CMD_PIC, LBL_PIC);
      put(CMD_BGM, LBL_BGM);
      put(CMD_SPR_POS, LBL_SPR_POS);
      put(CMD_JMP, LBL_JMP);
      put(CMD_FACE, LBL_FACE);
      put(CMD_VAR, LBL_VAR);
      put(CMD_FLAG, LBL_FLAG);
    }
  };
  
  // Keep this static to avoid memory leaks and too many anonymous classes.
  private static final HashMap<String, Integer> commandRules = new HashMap<String, Integer>() {
    
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
  
  /**
   * Changes a command string into a series of human-readable commands.
   * 
   * @param quote
   * @return
   */
  
  public static final String[] interpretCommands(final String quote) {
    
    // Empty cases
    if (quote == null) return null;
    if (quote.length() <= 0) return null;
    
    final ArrayList<String> cmdList = new ArrayList<String>();
    
    // Split into tokens by "}"s.
    final String[] cmdTokens = quote.split(REGEX_SPLITTER);
    if (cmdTokens.length <= 0) return null;
    
    // Go through all tokens
    for (int i = 0; i < cmdTokens.length; i++) {
      
      // Ignore empty tokens
      if (cmdTokens[i].length() <= 0) {
        continue;
      }
      
      // If the token starts with a backslash, treat it as a command
      if (cmdTokens[i].startsWith("\\")) {
        
        final int cbIndex = cmdTokens[i].indexOf("{");
        
        // If there is no open curly brace, null everything
        if (cbIndex <= 1) {
          System.out.println("Syntax error.");
          return null;
        }
        
        // Extract the command name
        final String command = cmdTokens[i].substring(1, cbIndex).trim();
        
        System.out.println("Command: " + command);
        
        // Extract the comma-delimited command arguments as an array
        final String[] cmdArgs = cmdTokens[i].substring(cbIndex + 1, cmdTokens[i].length()).split("\\s*,\\s*");
        
        System.out.println("  Args: " + Arrays.toString(cmdArgs));
        
        // If it's not a valid command, error and move on
        if (!commandRules.containsKey(command)) {
          cmdList.add(BAD_COMMAND_LABEL);
          System.out.println("Invalid command. Command \"" + command + "\" is not valid.");
          continue;
        }
        
        // If it is valid, check correct argument count
        int argCount = cmdArgs.length;
        if (argCount == 1 && cmdArgs[0].isEmpty()) {
          argCount = 0;
        }
        final int corArgCnt = commandRules.get(command);
        if (corArgCnt != argCount) {
          
          cmdList.add(BAD_COMMAND_LABEL);
          System.out.println("Bad argument count. Expected " + commandRules.get(command) + ", got " + argCount);
          continue;
        }
        
        // Build label with args
        String cmdLabel = commandLabels.get(command);
        if (commandRules.get(command) > 0) {
          cmdLabel += COMMAND_LABEL_SEPARATOR;
        }
        
        if (argCount > 0) cmdLabel += cmdArgs[0];
        for (int j = 1; j < argCount; j++) {
          if (cmdArgs[0].length() <= 0) continue;
          cmdLabel += ", " + cmdArgs[j];
        }
        cmdList.add(cmdLabel);
        System.out.println("Parsed \"" + quote + "\"\n as \"" + cmdLabel + "\"");
      } else {
        
        // Otherwise, treat it as a literal string
        cmdList.add(LBL_TEXT + COMMAND_LABEL_SEPARATOR + "\"" + cmdTokens[i] + "\"");
      }
    }
    
    // Convert to String array
    final String[] result = new String[cmdList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = cmdList.get(i);
    }
    return result;
  }
}
