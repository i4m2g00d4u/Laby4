package de.just2g00d.jisatsu.features.modules;

import de.just2g00d.jisatsu.features.modules.utils.Module;
import de.just2g00d.jisatsu.manager.ManagerClass;
import java.util.ArrayList;
import java.util.List;

public class ModuleManager implements ManagerClass {

  private List<Module> modules;

  @Override
  public void onEnable() {
    modules = new ArrayList<>();

  }

  @Override
  public void onDisable() {
      for(Module module : modules) {
        module.setEnabled(false);
      }
  }
}
