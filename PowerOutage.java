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
    private ArrayList<Customer> customer;
    private int actCount;
    private int totalFadeTime;
    private boolean firstAct;
    
    public PowerOutage()
    {
        super(300); 
        drawimage();
        actCount = 240;
        totalFadeTime = 90;
    }
    
    /**
     * 
     * @param w The World you are being added to.
     */    
    public void addedToWorld (World w){
        if (firstAct){
            // Knock out 25% of Pedestrians with wind!
            customer = (ArrayList<Customer>)w.getObjects(Customer.class);
            for (Customer c : customer){
                // Roll a random number 0-2, 33.33% chance of a 0
                if (Greenfoot.getRandomNumber(3) == 0){
                    getWorld().removeObject(c);
                }
            }
            firstAct = false;
        }
    }
    
    public void loseCustomers()
    {
        
    }
    
    public void act()
    {
        actCount--;
        if (actCount == 0){
            getWorld().removeObject(this);
            return;
        }
        fade (actCount, totalFadeTime);
    }
    
    private void drawimage() {
        image = new GreenfootImage(2048, 800);
        image.setColor(new Color(0, 0, 40, 80));
        image.fill();
        setImage(image);
    }
}
