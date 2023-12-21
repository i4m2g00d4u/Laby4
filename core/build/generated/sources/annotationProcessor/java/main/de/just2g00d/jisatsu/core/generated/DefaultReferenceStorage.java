package de.just2g00d.jisatsu.core.generated;

import de.just2g00d.jisatsu.versioned.MinecraftVersionController;
import net.labymod.api.reference.ReferenceStorageAccessor;
import net.labymod.api.service.annotation.AutoService;
import org.jetbrains.annotations.NotNull;

@AutoService(ReferenceStorageAccessor.class)
public class DefaultReferenceStorage implements ReferenceStorageAccessor {
  @NotNull
  public MinecraftVersionController minecraftVersionController() {
    return null;
  }
}
