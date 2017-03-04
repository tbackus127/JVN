
package com.rath.jvn.core.registry;

public class RegistryException extends Exception {
  
  private static final long serialVersionUID = 1L;
  private final String type;
  private final String spriteKey;
  private final boolean alreadyReg;
  
  public RegistryException(final String type, final String sk, final boolean ar) {
    this.type = type;
    this.spriteKey = sk;
    this.alreadyReg = ar;
  }
  
  @Override
  public String getMessage() {
    if (alreadyReg) {
      return "The " + this.type + " \"" + this.spriteKey + "\" is already registered with the system.";
    }
    return "The " + this.type + " \"" + this.spriteKey + "\" is not registered with the system and cannot be used.";
  }
}
