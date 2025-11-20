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
    protected String restaurantSide; // Red or Blue
    
    protected static final int BLUE_MIN_X = 0;
    protected static final int BLUE_MAX_X = 480; // Left half of 960
    protected static final int RED_MIN_X = 480;
    protected static final int RED_MAX_X = 960; // Right half of 960
    
    /**
     * Constructor for Effect
     * @param duration - how long the effect lasts before fading out
     * @param side - Red or Blue to specify which restaurant is affected
     */
    public Effect(int duration)
    {
        this(duration, "Blue"); // Default to Blue side
    }
    
    
    /**
     * Constructor for Effect
     * @param duration - how long the effect lasts before fading out
     * @param side - "Red" or "Blue" to specify which restaurant is affected
     */
    public Effect(int duration, String side)
    //not important
    {
        this.actCount = duration;
        this.totalFadeTime = duration;
        this.restaurantSide = side;
    }
    
    protected void fade(int timeLeft, int totalFadeTime)
    {
        double percent = timeLeft/ (double)totalFadeTime;
        if(percent > 1.00){
            return;
        }
        int newTransparency = (int)(percent*255);
        image.setTransparency (newTransparency);
    }
    
    /**
     * Check if a customer is on this effect's side
     * @param customer - the customer to check
     * @return true if customer is on the same side as this effect
     */
    protected boolean isCustomerOnThisSide(Customer customer)
    {
        // Use the customer's own method to determine their side
        return customer.getRestaurantSide().equals(restaurantSide);
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
    
    /**
     * Get which restaurant side this effect is for
     * @return "Red" or "Blue"
     */
    public String getRestaurantSide()
    {
        return restaurantSide;
    }
}
