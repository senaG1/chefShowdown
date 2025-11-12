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
    
    public PowerOutage()
    {
        super(300); 
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
        ArrayList<Customer> customers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
        // If there are no customers, nothing to do
        if (customers.isEmpty()) {
            return;
        }
        
        // Remove at least 2 customers (or all if less than 2)
        int guaranteedRemovals = Math.min(2, customers.size());
        
        // Remove the first 2 customers (guaranteed)
        for (int i = 0; i < guaranteedRemovals; i++) {
            customers.get(i).giveUp();
        }
        
        // For remaining customers, 50% chance they leave
        // Go backwards to safely remove while iterating
        for (int i = customers.size() - 1; i >= guaranteedRemovals; i--) {
            if (Greenfoot.getRandomNumber(2) == 0) {
                customers.get(i).giveUp();
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
        image = new GreenfootImage(1100, 700);
        image.setColor(new Color(0, 0, 40, 80));
        image.fill();
        setImage(image);
    }
}
