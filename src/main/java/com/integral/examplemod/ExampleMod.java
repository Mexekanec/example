package com.integral.examplemod;




import org.apache.logging.log4j.Logger;

import com.integral.examplemod.client.Render;
import com.integral.examplemod.events.TickHandler;
import com.integral.examplemod.gui.over;
import com.integral.examplemod.managers.PacMen;
import com.integral.examplemod.managers.PacketManager;
import com.integral.examplemod.proxy.CommonProxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;






@Mod(modid = ExampleMod.MODID, version = ExampleMod.VERSION, name = ExampleMod.NAME)
public class ExampleMod {
    public static final String MODID="examplemod";
    public static final String NAME="examplemod";
    public static final String VERSION="1.0.0";

    private final over over = new over();
    private final Render clientRender = new Render();
    private final TickHandler tickHandler = new TickHandler();
    
    

    
@SidedProxy(clientSide = "com.integral.examplemod.proxy.ClientProxy", serverSide = "com.integral.examplemod.proxy.ServerProxy")
public static CommonProxy proxy;

private static Logger logger;

@EventHandler
public void preInit(FMLPreInitializationEvent event) {  
	proxy.preInit(event);
        PacketManager.load(); 
        PacMen.load();
        logger = event.getModLog();
}

@EventHandler
public void init(FMLInitializationEvent event) {
    PacketManager.load();
	proxy.init(event);
}
@EventHandler
public void postInit(FMLPostInitializationEvent event) {
	proxy.postInit(event);
}


@SideOnly(Side.CLIENT)
@EventHandler
public void preInitClient(FMLPreInitializationEvent event) {
	proxy.preInit(event);
	MinecraftForge.EVENT_BUS.register(this.over);
    MinecraftForge.EVENT_BUS.register(this.clientRender);

}

@SideOnly(Side.CLIENT)
@EventHandler
public void initClient(FMLInitializationEvent event) { 
	proxy.init(event);
}

@SideOnly(Side.CLIENT)
@EventHandler
public void postInitClient(FMLPostInitializationEvent event) {
	proxy.postInit(event);
}


@SideOnly(Side.SERVER)
@EventHandler
public void preInitServer(FMLPreInitializationEvent event) {
	proxy.preInit(event);

}

@SideOnly(Side.SERVER)
@EventHandler
public void initServer(FMLInitializationEvent event) {	
	proxy.init(event);
}

@SideOnly(Side.SERVER)
@EventHandler
public void postInitServer(FMLPostInitializationEvent event) {
	proxy.postInit(event);
}

    public Render getRender() {
        return this.clientRender;
    }
    
	@SideOnly(Side.CLIENT)
    public over getOver() {
    	return this.over;
    }
    
    


@Mod.Instance
public static ExampleMod instance;  



    @EventHandler
    public void serverLoad(FMLServerStartingEvent event) {
        // NO-OP
	MinecraftForge.EVENT_BUS.register(this.tickHandler);

    }
}