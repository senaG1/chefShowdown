import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paparazzi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paparazzi extends Effect
{
    private GreenfootImage flash;
    public Paparazzi()
    {
        super(240);
        
        actCount = 30;
        totalFadeTime = 15;
    }
    
    public void loseCustomers()
    {
        // All Karens leave
    }
    
    public void act()
    {
        for (int i = 0; i < 8; i++) {
            flash = new GreenfootImage("flash/flash" + i + ".png");
            flash.scale(400, 400);
            setImage(flash);
        }
    }
}
