import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Hires a Masterchef in a restaurant.
 * 
 * @author Jiayu Chen
 * @version November 23 2025
 */
public class HireMasterChef extends Actor
{
    private GreenfootImage image;
    private Restaurant restaurant;
    private int value;
    private boolean isBought;
    private int teamCash;
    private RestaurantWorld rw;
    private int purchaseRange;
    
    /**
     * The constructor for HireMasterChef
     * 
     * @param cost          Takes the cost of the chef being hired
     * @param teamCash      Takes the current amount of cash of the restaurant hiring
     * @param restaurant    Takes the restaurant that is hiring the chef
     */
    public HireMasterChef(int cost, int teamCash, Restaurant restaurant) {
        value = cost;
        purchaseRange = value + 300;
        this.restaurant = restaurant;
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Hire_MasterChef.png");
        setImage(image);
    }
    
    public void addedToWorld() {
        
    }
    
    public void act()
    {   
        teamCash = restaurant.getCash();
        if (DayWorld.timer == 200 && teamCash > purchaseRange) {
            getWorld().removeObject(this);
            restaurant.collectCash(-value);
            MasterChef newChef = new MasterChef();
            restaurant.hireChef(newChef, restaurant);
            
            SoundManager.playMoney();
            isBought = true;
        }
        
        isBought = false;
    }
}
