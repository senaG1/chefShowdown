import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * RatInfestation - Spawns rats that run across the screen and causes customers to leave.
 * Decreases restaurant popularity by removing 1-2 customers and lowering rating.
 * Lasts 10 seconds with rats spawning every 10 seconds.
 * 
 * @author Sena Godek 
 * @version 2025
 */
public class RatInfestation extends Effect
{
    private int spawnTimer;               // Timer for spawning next batch of rats
    private int totalDuration;            // Total effect duration
    private boolean customersRemoved;     // Flag to remove customers only once
    private Restaurant targetRestaurant;  // The affected restaurant
    
    /**
     * Constructor - Creates a 10 second rat infestation effect.
     * 
     * @param side "Blue" or "Red" restaurant side
     */
    public RatInfestation(String side){
        super(600, side);
        this.spawnTimer = 0;
        this.totalDuration = 600;
        this.customersRemoved = false;
    }
    
    /**
     * Gets reference to the correct restaurant when added to world.
     * Needed to affect that restaurant's rating.
     * 
     * @param w The world this effect is being added to
     */
     public void addedToWorld(World w) {
        RestaurantWorld rw = (RestaurantWorld) w;
        // Get the correct restaurant based on side
        if (restaurantSide.equals("Blue")) {
            targetRestaurant = rw.restaurantBlue;
        } else {
            targetRestaurant = rw.restaurantRed;
        }
    }
    
    /**
     * loseCustomers - Removes customers who leave due to seeing rats.
     * At least 3 customers will leave, and remaining customers have a 60% chance of leaving.
     */
    public void loseCustomers()
    {
         // Get all customers currently in the world
        ArrayList<Customer> customers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
        if (customers.isEmpty()) {
            return;
        }
        
        // Filter customers to only those on this restaurant's side
        ArrayList<Customer> sideCustomers = new ArrayList<Customer>();
        for (Customer c : customers) {
            if (c.getRestaurantSide().equals(restaurantSide)) {
                sideCustomers.add(c);
            }
        }
        
        if (sideCustomers.isEmpty()) {
            return;
        }
        
        // Remove only 1-2 customers (very few)
        int customersToRemove = Math.min(2, sideCustomers.size());
        customersToRemove = Greenfoot.getRandomNumber(2) + 1; // 1 or 2 customers
        
        for (int i = 0; i < customersToRemove && i < sideCustomers.size(); i++) {
            Customer c = sideCustomers.get(i);
            if (c.getWorld() != null) {
                getWorld().removeObject(c);
            }
        }
        
        // Decrease rating by adding 2-3 bad reviews (1-2 stars each)
        if (targetRestaurant != null) {
            int badReviews = 1;
            for (int i = 0; i < badReviews; i++) {
                int badRating = Greenfoot.getRandomNumber(2) + 1;
                targetRestaurant.addNumReviews(1);
                targetRestaurant.recordRating(badRating);
            }
        }
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
        SoundManager.playRat();
    }
}
