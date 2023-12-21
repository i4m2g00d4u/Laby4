package de.just2g00d.jisatsu.manager;

import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.Config;
import net.labymod.api.configuration.loader.annotation.Exclude;
import net.labymod.api.configuration.loader.annotation.ParentSwitch;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingListener;
import net.labymod.api.configuration.settings.annotation.SettingListener.EventType;
import net.labymod.api.configuration.settings.type.SettingElement;

public class ManagerConfiguration extends Config {
  @Exclude
  private final transient Class<?> clazz;

  public ManagerConfiguration(Class<?> clazz) {
    this.clazz = clazz;
  }

  @ParentSwitch
  @SwitchSetting
  public ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);


  @SettingListener(target = "enabled", type = EventType.INITIALIZE)
  public void onList(SettingElement element) {
    Manager.manager.addManager(getClazz(), enabled);
  }

  public Class<?> getClazz() {
    return clazz;
  }
}
