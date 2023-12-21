package de.just2g00d.jisatsu.features.command.list;

import net.labymod.api.client.chat.command.Command;
import net.labymod.core.labyconnect.protocol.packets.PacketPlayServerStatus;
import net.labymod.core.main.LabyMod;

public class ServerStatus_CMD extends Command {


  public ServerStatus_CMD() {
    super("status");
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    PacketPlayServerStatus serverStatus = new PacketPlayServerStatus("§cVincent du süßer", 25565);
    LabyMod.getInstance().labyConnect().sendPacket(serverStatus);
    System.out.println("T");

    return false;
  }
}
