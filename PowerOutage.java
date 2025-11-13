import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class PowerOutage here.
 * 
 * @author Sena Godek
 * @version 2025
 */
public class PowerOutage extends Effect
{
    private int actCount;      // Tracks remaining duration of the power outage
    private int totalFadeTime; // Duration of the fade-out effect at the end
    private boolean customersRemoved = false; // Ensures customers are only removed once
    
    /**
     * Constructor for PowerOutage
     * @param side - "Red" or "Blue" to specify which restaurant loses power
     */
    public PowerOutage(String side)
    {
        super(300, side); 
        drawimage();
        actCount = 240;
        totalFadeTime = 90;
    }
    
     /**
     * loseCustomers - Abstract method implementation from Effect class.
     * Removes 50% of customers when power goes out (they leave due to the outage).
     * It also gaurentees at least 2 customers leaving.
     */
    public void loseCustomers()
    {
        // Remove 33% of customers when power goes out
        ArrayList<Customer> allCustomers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
         // Filter to only customers on this side
        ArrayList<Customer> customersOnThisSide = new ArrayList<Customer>();
        for (Customer c : allCustomers)
        {
            if (c.isOnSide(restaurantSide))  // Use customer's isOnSide method
            {
                customersOnThisSide.add(c);
            }
        }
        
        // If there are no customers, nothing to do
        if (customersOnThisSide.isEmpty()) {
            return;
        }
        
        // Remove at least 2 customers (or all if less than 2)
        int guaranteedRemovals = Math.min(2, customersOnThisSide.size());
        
        // Remove the first 2 customers (guaranteed)
        for (int i = 0; i < guaranteedRemovals; i++) {
            customersOnThisSide.get(i).giveUp();
        }
        
        // For remaining customers, 50% chance they leave
        // Go backwards to safely remove while iterating
        for (int i = customersOnThisSide.size() - 1; i >= guaranteedRemovals; i--) {
            if (Greenfoot.getRandomNumber(2) == 0) {
                customersOnThisSide.get(i).giveUp();
            }
        }
    }
    
    public void act()
    {
        // Remove customers on first act only
        if (!customersRemoved) {
            loseCustomers();
            customersRemoved = true;
        }
        
        actCount--;
        if (actCount == 0){
            getWorld().removeObject(this);
            return;
        }
        fade(actCount, totalFadeTime);
    }
    
    private void drawimage() {
        image = new GreenfootImage(1200, 800);
        image.setColor(new Color(0, 0, 0, 0)); // Transparent by default
        image.fill();
        
        // Only darken the affected side
        image.setColor(new Color(0, 0, 40, 80));
        if (restaurantSide.equals("Blue"))
        {
            // Fill left half (Blue side)
            image.fillRect(0, 0, 600, 800);
        }
        else // Red side
        {
            // Fill right half (Red side)
            image.fillRect(600, 0, 600, 800);
        }
        
        setImage(image);
    }
}
