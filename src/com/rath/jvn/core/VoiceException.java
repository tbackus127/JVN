
package com.rath.jvn.core;

import java.io.File;

public class VoiceException extends Exception {

  private static final long serialVersionUID = 1L;
  private final String voxKey;
  private final File voxFile;

  public VoiceException(final String vk, final File vf) {
    this.voxKey = vk;
    this.voxFile = vf;
  }

  @Override
  public String getMessage() {
    return "There was an error returning the voice file from the registry's voice map.\n"
        + "This should not happen; please submit an issue on the project's GitHub repository or contact"
        + " the author with a step-by-step procedure that tells how to replicate this error.\n" + "Error: get("
        + this.voxKey + "," + this.voxFile + ")";
  }
}
