package de.just2g00d.jisatsu.features.modules.utils;

import de.just2g00d.jisatsu.features.modules.utils.ModuleCategory;
import net.labymod.api.Laby;

public class Module {

  private String name;
  private String description;

  private ModuleCategory category;

  private boolean toggled;

  public Module(String name, String description, ModuleCategory category) {
    this.name = name;
    this.description = description;
    this.category = category;
  }

  public void onEnable() {
   if(!requireEvents()) return;
    Laby.labyAPI().eventBus().registerListener(this);
  }

  public void onDisable() {
    if(!requireEvents()) return;
    Laby.labyAPI().eventBus().unregisterListener(this);
  }

  public void setEnabled(boolean enabled) {
    if(enabled) {
      if(isToggled()) return;
      onEnable();
      toggled = true;
    } else {
      if(!isToggled()) return;
      onDisable();
      toggled = false;
    }
  }

  public void onToggle() {
    if(toggled) {
      onDisable();
      toggled = false;
    } else {
      onEnable();
      toggled = true;
    }
  }

  public boolean requireEvents() {
    return false;
  }

  public boolean isToggled() {
    return toggled;
  }

  public String getDescription() {
    return description;
  }

  public String getName() {
    return name;
  }

  public ModuleCategory getCategory() {
    return category;
  }
}