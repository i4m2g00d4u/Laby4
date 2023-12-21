package de.just2g00d.jisatsu;

import de.just2g00d.jisatsu.features.command.CommandConfiguration;
import net.labymod.api.addon.AddonConfig;
import net.labymod.api.client.gui.screen.widget.widgets.input.SwitchWidget.SwitchSetting;
import net.labymod.api.configuration.loader.annotation.ConfigName;
import net.labymod.api.configuration.loader.property.ConfigProperty;
import net.labymod.api.configuration.settings.annotation.SettingSection;

@ConfigName("settings")
public class JisatsuConfiguration extends AddonConfig {

  @SwitchSetting(hotkey = true)
  public ConfigProperty<Boolean> enabled = new ConfigProperty<>(true);

  @SettingSection("commands")
  public CommandConfiguration commandConfiguration = new CommandConfiguration();

  @Override
  public ConfigProperty<Boolean> enabled() {
    return enabled;
  }


}
