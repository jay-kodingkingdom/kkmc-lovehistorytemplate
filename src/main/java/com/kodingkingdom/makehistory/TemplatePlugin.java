package com.kodingkingdom.makehistory;
import java.util.logging.Level;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public class TemplatePlugin extends JavaPlugin implements Listener{
	Template x=new Template(this);
	@Override
    public void onEnable(){x.Live();} 
    @Override
    public void onDisable(){x.Die();}
        
    public Template getEduCraft(){return x;}
    
    static TemplatePlugin singleton;
    public TemplatePlugin(){singleton=this;}
    public static TemplatePlugin getPlugin(){return singleton;}
    public static void debug(String msg){
    		singleton.getLogger().log(Level.INFO
    				, msg);}}