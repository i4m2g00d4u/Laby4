package de.just2g00d.jisatsu.features.command.list;

import net.labymod.api.client.chat.command.Command;

public class Test_CMD extends Command {

  public Test_CMD() {
    super("test", "noah", "vincent");
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {

    System.out.println("Test command wurde erfolgreich ausgeführt!");

    return false;
  }
}
