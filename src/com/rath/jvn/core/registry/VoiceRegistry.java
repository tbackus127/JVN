
package com.rath.jvn.core.registry;

import java.io.File;
import java.util.HashMap;

import com.rath.jvn.core.VoiceException;

public class VoiceRegistry {

  private static final HashMap<String, File> voxMap = new HashMap<String, File>();

  public static final void registerVoice(final String voxName, final File voiceFile) throws RegistryException {

    if (voxMap.containsKey(voxName)) {
      throw new RegistryException("voice", voxName, true);
    }

    voxMap.put(voxName, voiceFile);
  }

  public static final File getVoice(final String voxName) throws RegistryException, VoiceException {
    if (!voxMap.containsKey(voxName)) {
      throw new RegistryException("voice", voxName, false);
    }

    final File vox = voxMap.get(voxName);

    if (vox == null) {
      throw new VoiceException(voxName, vox);
    }

    return vox;
  }
}
