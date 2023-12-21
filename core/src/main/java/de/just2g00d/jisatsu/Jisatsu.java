package de.just2g00d.jisatsu;

import de.just2g00d.jisatsu.manager.Manager;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.models.addon.annotation.AddonMain;

@AddonMain
public class Jisatsu extends LabyAddon<JisatsuConfiguration> {

  private Manager manager;


  @Override
  public void enable() {
    manager = new Manager();
    this.registerSettingCategory();

  }

  @Override
  protected Class<? extends JisatsuConfiguration> configurationClass() {
    return JisatsuConfiguration.class;
  }
}
