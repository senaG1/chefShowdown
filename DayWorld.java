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
    private int day;
    private int timer = 0;
    private GreenfootImage background;
    private Font dayFont;
    private int blueCash;
    private int redCash;
    
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
        
        getBackground().setColor(Color.WHITE);        
        dayFont = new Font ("Comic Sans MS", false, false, 100);
        getBackground().setFont(dayFont); 
        getBackground().drawString("Day " + day, 360, 320);
    }
    
    public void act(){
        timer++;
        
        if(timer == 60){
            Greenfoot.setWorld(new RestaurantWorld(day));
        }
    }
    
    
}
