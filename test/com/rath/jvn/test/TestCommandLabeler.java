
package com.rath.jvn.test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.rath.jvn.editor.scene.CommandInterpreter;

public class TestQuoteInterpreter {
  
  @Test
  public void testEmptyCases() {
    
    // An empty command should return null.
    String[] res = CommandInterpreter.interpretCommands("");
    assertNull(res);
    
    // A null command should also return null.
    res = CommandInterpreter.interpretCommands(null);
    assertNull(res);
  }
  
  // Should return null when there is a syntax error
  @Test
  public void testSyntaxError() {
    
    String quote = "\\{\\qb{}}";
    String[] res = CommandInterpreter.interpretCommands(quote);
    assertNull(res);
    
    quote = "\\}";
    res = CommandInterpreter.interpretCommands(quote);
    assertNull(res);
    
    quote = "\\{}";
    res = CommandInterpreter.interpretCommands(quote);
    assertNull(res);
  }
  
  // Invalid command names should output an error message
  @Test
  public void testBadCommands() {
    
    // Nonexistent command
    String quote = "\\invcmd{}";
    String[] res = CommandInterpreter.interpretCommands(quote);
    assertTrue(res[0].equals(CommandInterpreter.BAD_COMMAND_LABEL));
    
    // Wrong argument counts
    quote = "\\qb{34}";
    res = CommandInterpreter.interpretCommands(quote);
    assertTrue(res[0].equals(CommandInterpreter.BAD_COMMAND_LABEL));
    quote = "\\sel{}";
    res = CommandInterpreter.interpretCommands(quote);
    assertTrue(res[0].equals(CommandInterpreter.BAD_COMMAND_LABEL));
    quote = "\\sel{a,b}";
    res = CommandInterpreter.interpretCommands(quote);
    assertTrue(res[0].equals(CommandInterpreter.BAD_COMMAND_LABEL));
  }
  
  // Command translation
  @Test
  public void testValidCommands() {
    
    final String sep = CommandInterpreter.COMMAND_LABEL_SEPARATOR;
    
    String quote = "\\sel{BestGirl}";
    String[] exp = { CommandInterpreter.LBL_SEL + sep + "BestGirl" };
    assertTrue(CommandInterpreter.interpretCommands(quote)[0].equals(exp[0]));
    
    quote = "\\qb{}";
    exp[0] = CommandInterpreter.LBL_QB;
    assertTrue(CommandInterpreter.interpretCommands(quote)[0].equals(exp[0]));
  }
}
