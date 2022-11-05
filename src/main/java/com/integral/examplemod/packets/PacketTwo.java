package com.integral.examplemod.packets;

import com.integral.examplemod.ExampleMod;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class PacketTwo implements IMessage {
    private int scor;

    public PacketTwo() {
    }

    public PacketTwo(final int scor) {
        this.scor = scor;
    }

    public int isEnableInt() {
        return this.scor;
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(this.scor);
      }

      @Override
      public void fromBytes(ByteBuf buf) {
        this.scor = buf.readInt();
      }

    public static class Handler2 implements IMessageHandler<PacketTwo, IMessage> {

        @Override
        public IMessage onMessage(PacketTwo message, MessageContext ctx) {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
                final int score = message.isEnableInt();

               ExampleMod.instance.getOver().setInt(score);
            }

            return null;
        }
    }
}