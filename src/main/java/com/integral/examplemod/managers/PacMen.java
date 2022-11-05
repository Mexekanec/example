package com.integral.examplemod.managers;

import com.integral.examplemod.packets.PacketTwo;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacMen {
    private static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("over");
    
    public static void load() {
        INSTANCE.registerMessage(PacketTwo.Handler2.class, PacketTwo.class, 1, Side.CLIENT);
    }

    public static void sendOverUpdate(int a, EntityPlayerMP player) {
        INSTANCE.sendTo(new PacketTwo(a),
                player);
    } 
}