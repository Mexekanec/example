package com.integral.examplemod.events;


import com.integral.examplemod.managers.PacMen;
import com.integral.examplemod.managers.PacketManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public final class TickHandler {

    @SubscribeEvent
    public void onTick(final TickEvent.PlayerTickEvent event) {
        final TickEvent.Phase phase = event.phase;

        if (phase == TickEvent.Phase.END) {
            final EntityPlayer entityPlayer = event.player;
            final Scoreboard scoreboard = entityPlayer.getWorldScoreboard();
            final ScoreObjective scoreObjective = scoreboard.getObjective("render");
            final Score score = scoreboard.getOrCreateScore(entityPlayer.getName(), scoreObjective);
            final int value = score.getScorePoints();
            entityPlayer.sendStatusMessage(new TextComponentString("переменная: " + value), true);
            if (value == 1) {
                PacketManager.sendRenderUpdate(true, (EntityPlayerMP) entityPlayer);
            }         
            else if (value == 2) {
                PacketManager.sendRenderUpdate(false, (EntityPlayerMP) entityPlayer);
        }
            final EntityPlayer entityPlayer2 = event.player;
            final Scoreboard scoreboard1 = entityPlayer2.getWorldScoreboard();
            final ScoreObjective scoreObjective1 = scoreboard1.getObjective("score");
            final Score score1 = scoreboard1.getOrCreateScore(entityPlayer2.getName(), scoreObjective1);
            final int valueOver = score1.getScorePoints();
            entityPlayer.sendStatusMessage(new TextComponentString("переменная: " + valueOver), true);
            if (valueOver == 1) {
                PacMen.sendOverUpdate(1, (EntityPlayerMP) entityPlayer2);      
            }
            else if (valueOver == 2) 
            	PacMen.sendOverUpdate(0, (EntityPlayerMP) entityPlayer2);    
        }
    }
}