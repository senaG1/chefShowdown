import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * RatInfestation - Spawns rats that run across the screen and causes customers to leave.
 * Decreases restaurant popularity and removes customers who are disgusted by the rats.
 * 
 * @author Sena Godek 
 * @version 2025
 */
public class RatInfestation extends Effect
{
    private int spawnTimer;
    private int totalDuration;
    private boolean customersRemoved;
    
    /**
     * Constructor for RatInfestation.
     * Creates a rat infestation that lasts 60 seconds (3600 acts).
     */
    public RatInfestation(String side)
    {
        super(600, side);
        this.spawnTimer = 0;
        this.totalDuration = 600;
        this.customersRemoved = false;
    }
    
    /**
     * loseCustomers - Removes customers who leave due to seeing rats.
     * At least 3 customers will leave, and remaining customers have a 60% chance of leaving.
     * TODO: Also decrease restaurant star rating when that system is implemented.
     */
    public void loseCustomers()
    {
        // Get all customers currently in the world
        ArrayList<Customer> customers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
        // If there are no customers, nothing to do
        if (customers.isEmpty()) {
            return;
        }
        
        // For all customers, 30% chance they leave
        for (int i = customers.size() - 1; i >= 0; i--) {
            if (Greenfoot.getRandomNumber(10) < 3) {  // 30% chance
                getWorld().removeObject(customers.get(i));
            }
        }
        // TODO: When star rating system is added, decrease stars here
        // Example: restaurantWorld.decreaseStars(1);
    }
    
    /**
     * act - Spawns rats every 10 seconds and manages the infestation duration.
     */
    public void act()
    {
        // Remove customers once at the start
        if (!customersRemoved) {
            loseCustomers();
            customersRemoved = true;
        }
        
        spawnTimer--;
        
        // Spawn rats every 10 seconds (600 acts)
        if (spawnTimer <= 0)
        {
            spawnRats();
            spawnTimer = 600; // Reset to 10 seconds
        }
        
        // Countdown and remove when done
        actCount--;
        if (actCount <= 0)
        {
            getWorld().removeObject(this);
            return;
        }
    }
    
     /**
     * spawnRats - Spawns 10-18 rats at random positions at the bottom of the screen.
     * Each rat runs upward at a slightly different speed for variety.
     */
    private void spawnRats()
    {
        // Spawn between 10 and 18 rats
        int numRats = Greenfoot.getRandomNumber(9) + 10;
        
        for (int i = 0; i < numRats; i++)
        {
            int x;
            
            // Check which side this infestation is for
            if (restaurantSide.equals("Blue"))
            {
                x = Greenfoot.getRandomNumber(310) + 30; 
            }
            else // Red side
            {
                x = Greenfoot.getRandomNumber(450) + 495;
            }
            int y = 630; // Bottom of screen
            
            // Random speed between 2-5 pixels per act
            int speed = Greenfoot.getRandomNumber(4) + 2;
            
            // Add the rat to the world
            getWorld().addObject(new Rat(speed, restaurantSide), x, y);
        }
    }
}
