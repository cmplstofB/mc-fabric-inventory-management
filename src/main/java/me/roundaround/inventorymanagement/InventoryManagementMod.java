package me.roundaround.inventorymanagement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import me.roundaround.inventorymanagement.client.InventoryButtonsManager;
import me.roundaround.inventorymanagement.network.AutoStackPacket;
import me.roundaround.inventorymanagement.network.SortInventoryPacket;
import me.roundaround.inventorymanagement.network.TransferAllPacket;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public final class InventoryManagementMod implements ModInitializer, ClientModInitializer {
  public static final String MOD_ID = "inventorymanagement";
  public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

  @Override
  public void onInitialize() {
    SortInventoryPacket.registerReceive();
    AutoStackPacket.registerReceive();
    TransferAllPacket.registerReceive();
  }

  @Override
  public void onInitializeClient() {
    InventoryButtonsManager.INSTANCE.init();
  }
}
