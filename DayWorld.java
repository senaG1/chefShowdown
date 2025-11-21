import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The DayWorld class is a Greenfoot World.
 * <p>
 * When added, it will show the user each team's cash, rating, and day count.
 * 
 * @author Isabel Powell
 * @version (a version number or a date)
 */
public class DayWorld extends World
{
    private int timer = 0;
    private GreenfootImage background;
    private Font dayFont;
    private Font teamFont;
    private Font statFont;
    private RestaurantWorld restWorld;
    
    private int blueCash;
    private double blueRating;
    private int redCash;
    private double redRating;
    /**
     * Constructor for DayWorld - creates a new DayWorld.
     * This is called from Restaurant World.
     * 
     * @param restWorld    restaurant object
     * @param blueCash     Amount of cash Blue team has
     * @param blueRating    Amount of stars blue team has
     * @param redCash       amount of cash Red team has
     * @param redRating     amount of stars Red team has
     * 
     */
    public DayWorld(RestaurantWorld restWorld, int blueCash, double blueRating, int redCash, double redRating)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        this.restWorld = restWorld;
        this.timer = 0;
        
        this.blueCash = blueCash;
        this.blueRating = blueRating;
        this.redCash = redCash;
        this.redRating = redRating;
        
        SoundManager.stopAllSounds();
        restWorld.tomorrow();
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        getBackground().setColor(Color.WHITE);        
        dayFont = new Font ("Times New Roman", true, false, 100);
        teamFont = new Font("Times New Roman", true, false, 60);
        statFont = new Font("Times New Roman", false, false, 35);
        getBackground().setFont(dayFont); 
        getBackground().drawString("Day " + restWorld.getCurrentDay(), 357, 220);
        getBackground().setFont(teamFont);
        getBackground().drawString("Blue Team:", 90, 380);
        getBackground().drawString("Red Team: ", 580, 380);
        getBackground().setFont(statFont);
        getBackground().drawString("Current Cash: $" + blueCash, 95, 460);
        getBackground().drawString("Current Cash: $" + redCash, 575, 460);
        getBackground().drawString("Current Rating: " + blueRating + " Stars", 95, 500);
        getBackground().drawString("Current Rating: " + redRating + " Stars", 575, 500);
        
        SoundManager.playNextDay();
    }
    
    public void act(){
        timer++;
        
        if(timer == 300){
            Greenfoot.setWorld(restWorld);
        }
    }
}
