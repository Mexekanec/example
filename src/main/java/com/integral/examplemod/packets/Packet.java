package com.integral.examplemod.packets;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import com.integral.examplemod.ExampleMod;

public final class Packet implements IMessage {
    private boolean enable;

    public Packet() {
    }

    public Packet(final boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return this.enable;
    }

    @Override
    public void fromBytes(final ByteBuf buf) {
        this.enable = buf.readBoolean();
    }

    @Override
    public void toBytes(final ByteBuf buf) {
        buf.writeBoolean(this.enable);
    }

    public static class Handler implements IMessageHandler<Packet, IMessage> {

        @Override
        public IMessage onMessage(Packet message, MessageContext ctx) {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                final boolean value = message.isEnable();

                ExampleMod.instance.getRender().setEnable(value);
            }

            return null;
        }
    }
}