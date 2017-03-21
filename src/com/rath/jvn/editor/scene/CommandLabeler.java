
package com.rath.jvn.editor.scene;

import static com.rath.jvn.core.Commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class CommandLabeler {
  
  public static final String BAD_COMMAND_LABEL = "!! BAD COMMAND !!";
  public static final String REGEX_SPLITTER = "(?<!\\\\)}";
  public static final String COMMAND_LABEL_SEPARATOR = ": ";
  
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
  
  @SuppressWarnings("unused")
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
        if (!COMMAND_RULES.containsKey(command)) {
          cmdList.add(BAD_COMMAND_LABEL);
          System.out.println("Invalid command. Command \"" + command + "\" is not valid.");
          continue;
        }
        
        // If it is valid, check correct argument count
        int argCount = cmdArgs.length;
        if (argCount == 1 && cmdArgs[0].isEmpty()) {
          argCount = 0;
        }
        final int corArgCnt = COMMAND_RULES.get(command);
        if (corArgCnt != argCount) {
          
          cmdList.add(BAD_COMMAND_LABEL);
          System.out.println("Bad argument count. Expected " + COMMAND_RULES.get(command) + ", got " + argCount);
          continue;
        }
        
        // Build label with args
        String cmdLabel = commandLabels.get(command);
        if (COMMAND_RULES.get(command) > 0) {
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
