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
    public static int timer = 0;
    private GreenfootImage background;
    private Font dayFont;
    private Font teamFont;
    private Font statFont;
    private RestaurantWorld restWorld;
        
    private int blueCash;
    private double blueRating;
    private int redCash;
    private double redRating;
    
    private Restaurant restaurantBlue;
    private Restaurant restaurantRed;
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
        
        this.restaurantBlue = restWorld.getBlueRestaurant();
        this.restaurantRed = restWorld.getRedRestaurant();

        
        SoundManager.stopAllSounds();
        restWorld.tomorrow(); //Calls public method in restaurant world
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        getBackground().setColor(Color.WHITE);        
        dayFont = new Font ("Times New Roman", true, false, 70);
        teamFont = new Font("Times New Roman", true, false, 50);
        statFont = new Font("Times New Roman", false, false, 35);
        //Number of day
        getBackground().setFont(dayFont); 
        getBackground().drawString("Day " + restWorld.getCurrentDay(), 400, 100);
        //For Blue Team (blue Colour)
        getBackground().setColor(Color.BLUE);
        getBackground().setFont(teamFont);
        getBackground().drawString("Blue Team:", 120, 100);
        //For blue Stats
        getBackground().setColor(Color.WHITE);
        getBackground().setFont(statFont);
        getBackground().drawString("Current Rating: " + blueRating + " Stars", 95, 200);
        getBackground().drawString("Current Rating: " + redRating + " Stars", 575, 200);
        //For red Team:
        getBackground().setColor(Color.RED);
        getBackground().setFont(teamFont);
        getBackground().drawString("Red Team: ", 620, 100);
        getBackground().setColor(Color.WHITE);
        
        getBackground().drawString("Current Cash: $" + blueCash, 20, 160);
        getBackground().drawString("Current Cash: $" + redCash, 500, 160);
       
        //Hires chefs for blue
        addObject(new HireMasterChef(300, blueCash, restaurantBlue), 146, 319);
        addObject(new HireLazyChef(200, blueCash, restaurantBlue), 348, 319);
        addObject(new HireHungryChef(100, blueCash, restaurantBlue), 258, 523);
        //Hires chefs for red
        addObject(new HireMasterChef(300, redCash, restaurantRed), 599, 319);
        addObject(new HireLazyChef(200, redCash, restaurantRed), 786, 319);
        addObject(new HireHungryChef(100, redCash, restaurantRed), 704, 523);
        
        SoundManager.playNextDay();
    }
    
    public void act(){
        timer++;
        
        if(timer == 500){
            Greenfoot.setWorld(restWorld);
            SoundManager.playBackground();
        }
    }
}
