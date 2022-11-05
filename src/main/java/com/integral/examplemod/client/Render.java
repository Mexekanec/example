package com.integral.examplemod.client;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public final class Render {
    private boolean enableScan;

    @SubscribeEvent
    public void onEntityRenderPre(RenderLivingEvent.Pre event) {
        if (this.enableScan) {
        Entity entity = event.getEntity(); {
        if (entity instanceof EntityPlayer)
            GL11.glDisable(GL11.GL_DEPTH_TEST);
    }
    }
    }
    @SubscribeEvent
    public void onEntityRenderPost(RenderLivingEvent.Post event) {
        if (this.enableScan) {
        Entity entity = event.getEntity(); {
        if (entity instanceof EntityPlayer)
            GL11.glEnable(GL11.GL_DEPTH_TEST);
    }
    }
    }
    public void setEnable(boolean value) {
        enableScan = value;
    }
   
}
