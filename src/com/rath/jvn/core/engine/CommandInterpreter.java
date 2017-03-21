package com.rath.jvn.core.engine;

import com.rath.jvn.core.data.SceneData;

public class CommandInterpreter {

  private static final String REGEX_CMD_SPLITTER = "";
  
  private SceneData data;
  
  public CommandInterpreter(final SceneData d) {
    this.data = d;
  }
  
  public void execute(final String quote) {
    final String[] commands = quote.split(REGEX_CMD_SPLITTER);
  }
  
  public static final void advanceText(final SceneData sc, final String quote) {
    
  }
}
