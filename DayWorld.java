import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayWorld extends World
{
    private int day;
    private int timer;
    private GreenfootImage background;
    /**
     * Constructor for objects of class DayWorld.
     * 
     */
    public DayWorld(int day)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        this.day = day;
        this.timer = 0;
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        
        
    }
    
    
}
