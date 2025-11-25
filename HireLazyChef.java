import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HireChef here.
 * 
 * @author Jiayu Chen
 * @version November 23 2025
 */
public class HireLazyChef extends Actor
{
    private GreenfootImage image;
    private Restaurant restaurant;
    private int value;
    private boolean isBought;
    private int teamCash;
    private RestaurantWorld rw;
    private int purchaseRange;
    
    /**
     * The constructor for HireLazyChef
     * 
     * @param cost          Takes the cost of the chef being hired
     * @param teamCash      Takes the current amount of cash of the restaurant hiring
     * @param restaurant    Takes the restaurant that is hiring the chef
     */
    public HireLazyChef(int cost, int teamCash, Restaurant restaurant) {
        value = cost;
        purchaseRange = value + 200;
        this.restaurant = restaurant;
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Hire_LazyChef.png");
        setImage(image);
    }
    
    public void addedToWorld() {
        
    }
    
    public void act()
    {   
        teamCash = restaurant.getCash();
        if (DayWorld.timer == 300 && teamCash > purchaseRange) {
            getWorld().removeObject(this);
            restaurant.collectCash(-value);
            LazyChef newChef = new LazyChef();
            restaurant.hireChef(newChef, restaurant);

            SoundManager.playMoney();
            isBought = true;
        }
        
        isBought = false;
    }
}
