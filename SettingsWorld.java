import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    private int numChefs;
    private int money;
    private GreenfootImage background;
    
    public SettingsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        background = new GreenfootImage("bg_settings.png");
        background.scale(background.getWidth() * 2, background.getHeight() * 2 );
        setBackground(background);
        addObjectsToWorld();
    }
    
    private void addObjectsToWorld(){
        addObject(new Button("plus_1.png", "plus_2.png"), 300, 300);
    }
    
}
