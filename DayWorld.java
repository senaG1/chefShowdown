import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class DayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DayWorld extends World
{
    private int timer = 0;
    private GreenfootImage background;
    private Font dayFont;
    private RestaurantWorld restWorld;
    private int blueCash;
    private int redCash;
    
    /**
     * Constructor for objects of class DayWorld.
     * 
     */
    public DayWorld(RestaurantWorld restWorld)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        this.restWorld = restWorld;
        this.timer = 0;
        
        restWorld.tomorrow();
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        getBackground().setColor(Color.WHITE);        
        dayFont = new Font ("Comic Sans MS", false, false, 100);
        getBackground().setFont(dayFont); 
        getBackground().drawString("Day " + restWorld.getCurrentDay(), 360, 320);
    }
    
    public void act(){
        timer++;
        
        if(timer == 150){
            Greenfoot.setWorld(restWorld);
        }
    }
    
    
    
}
