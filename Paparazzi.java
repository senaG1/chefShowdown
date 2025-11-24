import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Creates a flash of cameras whenever an Influencer enters a restaurant.
 * 
 * @author Jiayu Chen
 * @version November 22, 2025
 */
public class Paparazzi extends Effect
{
    private int imageCount;
    private int decreaseRate = 25;
    /**
     * The constructor for the Paparazzi class. It sets the initial image for the effect and how long it lasts.
     */
    public Paparazzi()
    {
        super(240);
        
        image = new GreenfootImage("flash/flash0.png");
        
        actCount = 120;
        totalFadeTime = 45;
        imageCount = 0;
    }
    
    /**
     * All Karens near this effect will leave.
     */
    public void loseCustomers()
    {
        int diameter = 500;
        ArrayList<Karen> karensInRange = (ArrayList<Karen>)getObjectsInRange(diameter/2, Karen.class);
        
        for(Karen karen : karensInRange){
            if(karen.orderTaken){
                karen.giveUp();
            }
        }
    }
    
    public void act()
    {
        super.act();
        image = new GreenfootImage("flash/flash" + imageCount + ".png");
        image.scale(400, 400);
        setImage(image);
        if (actCount % 10 == 0 && imageCount < 8) {
            imageCount++;
            SoundManager.playPaparazzi();
        }
    }
}
