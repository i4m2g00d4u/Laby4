package de.just2g00d.jisatsu.features.command;

import de.just2g00d.jisatsu.features.command.list.ServerStatus_CMD;
import de.just2g00d.jisatsu.features.command.list.Test_CMD;
import de.just2g00d.jisatsu.manager.ManagerClass;
import net.labymod.api.Laby;
import net.labymod.api.client.chat.command.Command;
import java.util.ArrayList;
import java.util.List;

public class CommandManager implements ManagerClass {

  private List<Command> commands;

  @Override
  public void onEnable() {
    commands = new ArrayList<>();

    commands.add(new Test_CMD());
    commands.add(new ServerStatus_CMD());


    for(Command cmd : commands) {
      Laby.labyAPI().commandService().register(cmd);
    }
  }

  @Override
  public void onDisable() {
    for(Command cmd : commands) {
      Laby.labyAPI().commandService().unregister(cmd);
    }
  }

}
