import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Effect - Abstract superclass for temporary visual and gameplay effects.
 * 
 * Provides fade-out functionality and automatic removal after a duration.
 * 
 * @Sena Godek 
 * @version: 2025
 */
public abstract class Effect extends SuperSmoothMover
{
    protected int actCount; // tracks how many acts have occurred 
    protected int totalFadeTime; //Total time for fade effect
    protected GreenfootImage image;
    protected boolean hasTriggered = false; //Track if effect triggered
    
    /**
     * Constructor for Effect
     * @param duration - how long the effect lasts before fading out
     */
    public Effect(int duration)
    {
        this.actCount = duration;
        this.totalFadeTime = duration;
    }
    
    protected void fade(int timeLeft, int totalFadeTime){
        double percent = timeLeft/ (double)totalFadeTime;
        if(percent > 1.00){
            return;
        }
        int newTransparency = (int)(percent*255);
        image.setTransparency (newTransparency);
    }
    
    public void act()
    {
         if(!hasTriggered) {
            loseCustomers(); // this method is done once
            hasTriggered = true;
        }
        actCount--;
        fade(actCount, totalFadeTime);
        
        if(actCount == 0){
            getWorld().removeObject(this);
            return;
        }
    }
    
    public abstract void loseCustomers();
}
