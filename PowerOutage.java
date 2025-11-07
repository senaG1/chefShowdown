import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public PowerOutage()
    {
        super(300); 
        drawimage();
        actCount = 240;
        totalFadeTime = 90;
    }
    
    public void loseCustomers()
    {
        // Empty for now
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    private void drawimage() {
        image = new GreenfootImage(2048, 800);
        image.setColor(new Color(0, 0, 40, 80));
        image.fill();
        setImage(image);
    }
}
