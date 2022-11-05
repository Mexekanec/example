package com.integral.examplemod.gui;

import com.integral.examplemod.ExampleMod;


import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.gui.Gui;




@SideOnly(Side.CLIENT)
public class over extends Gui {
	int anim;



	@SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void renderOverlay(RenderGameOverlayEvent event) {   
    	ResourceLocation Overlay = new ResourceLocation(ExampleMod.MODID, "textures/gui/over.png"); 
    	Minecraft mc = Minecraft.getMinecraft();
    	if (this.anim == 1)
            if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
                mc.renderEngine.bindTexture(Overlay);
                drawTexturedModalRect(25,225, 9,212 , 85, 25);
           
            }
    }
    
    public void setInt(int valnt) {
    	anim = valnt;
}

	
}