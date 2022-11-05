package com.integral.examplemod.managers;


import com.integral.examplemod.packets.Packet;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


public final class PacketManager {
    private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("render");
    
    public static void load() {
        INSTANCE.registerMessage(Packet.Handler.class, Packet.class, 0, Side.CLIENT);
    }

    public static void sendRenderUpdate(boolean b, EntityPlayerMP player) {
        INSTANCE.sendTo(new Packet(b),
                player);
    }  
}
