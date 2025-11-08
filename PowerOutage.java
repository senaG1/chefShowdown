import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class PowerOutage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PowerOutage extends Effect
{
    private int actCount;
    private int totalFadeTime;
    private boolean customersRemoved = false;
    
    public PowerOutage()
    {
        super(300); 
        drawimage();
        actCount = 240;
        totalFadeTime = 90;
    }
    
    public void loseCustomers()
    {
        // Remove 33% of customers when power goes out
        ArrayList<Customer> customers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
        // Go backwards through the list to safely remove while iterating
        for (int i = customers.size() - 1; i >= 0; i--) {
            if (Greenfoot.getRandomNumber(3) == 0) {  // 33% chance
                getWorld().removeObject(customers.get(i));
            }
        }
    }
    
    public void act()
    {
        // Remove customers on first act only
        if (!customersRemoved) {
            ArrayList<Customer> customers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
            for (int i = customers.size() - 1; i >= 0; i--) {
                if (Greenfoot.getRandomNumber(3) == 0) {
                    getWorld().removeObject(customers.get(i));
                }
            }
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
        image = new GreenfootImage(2048, 800);
        image.setColor(new Color(0, 0, 40, 80));
        image.fill();
        setImage(image);
    }
}
