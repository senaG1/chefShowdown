import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rat - Individual rat that scurries across the screen during a rat infestation.
 * Runs from bottom to top and fades out after reaching the top.
 * 
 * @author Sena Godek 
 * @version 2025
 */
public class Rat extends SuperSmoothMover
{
    private GreenfootImage image;
    private int speed;
    private int fadeTimer;
    private String side; // "Red" or "Blue"
    private boolean startFading;
    
    /**
     * Constructor for Rat.
     * @param speed - How fast the rat moves upward
     */
    public Rat(int speed, String side)
    {
        image = new GreenfootImage("rat.png");
        image.scale(image.getWidth() / 2, image.getHeight() / 2);
        setImage(image);
        this.speed = speed;
        this.fadeTimer = 120; // Fade over 2 seconds
        this.startFading = false;
        this.side = side;
    }
    
    public void act()
    {
        // Check if still in world (safety check)
        if (getWorld() == null) {
            return;
        }
        
        // Move upward
        setLocation(getX(), getY() - speed);
        
        // Remove if off screen (check this FIRST before fading logic)
        if (getY() < -20)
        {
            getWorld().removeObject(this);
            return;
        }
        
        // Start fading when near the top of the screen
        if (getY() < 100 && !startFading)
        {
            startFading = true;
        }
        
        // Fade out
        if (startFading)
        {
            fadeTimer--;
            double percent = fadeTimer / 120.0;
            int transparency = (int)(percent * 255);
            image.setTransparency(transparency);
            
            // Remove when fully faded
            if (fadeTimer <= 0)
            {
                getWorld().removeObject(this);
                return;
            }
        }
    }
    
     /**
     * Get which side this rat is on
     * @return "Red" or "Blue"
     */
    public String getSide()
    {
        return side;
    }
}
