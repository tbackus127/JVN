
package com.rath.jvn.core.registry;

public class SpriteNotRegisteredException extends Exception {

  private static final long serialVersionUID = 1L;
  private final String spriteKey;

  public SpriteNotRegisteredException(final String sk) {
    this.spriteKey = sk;
  }

  @Override
  public String getMessage() {
    return "The sprite \"" + this.spriteKey + "\" is not registered with the system and cannot be used.";
  }
}
