import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paparazzi here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paparazzi extends Effect
{
    private int imageCount;
    public Paparazzi()
    {
        super(240);
        
        image = new GreenfootImage("flash/flash0.png");
        
        actCount = 120;
        totalFadeTime = 45;
        imageCount = 0;
    }
    
    public void loseCustomers()
    {
        // All Karens leave
    }
    
    public void act()
    {
        super.act();
        image = new GreenfootImage("flash/flash" + imageCount + ".png");
        image.scale(400, 400);
        setImage(image);
        if (actCount % 10 == 0 && imageCount < 8) {
            imageCount++;
        }
    }
}
