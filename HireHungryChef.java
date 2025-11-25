import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HireChef here.
 * 
 * @author Jiayu Chen
 * @version November 23 2025
 */
public class HireHungryChef extends Actor
{
    private GreenfootImage image;
    private Restaurant restaurant;
    private int value;
    private boolean isBought;
    private int teamCash;
    private RestaurantWorld rw;
    private int purchaseRange;
    public HireHungryChef(int cost, int teamCash, Restaurant restaurant) {
        value = cost;
        purchaseRange = value + 100;
        this.restaurant = restaurant;
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Hire_HungryChef.png");
        setImage(image);
    }
    
    public void addedToWorld() {
        
    }
    
    public void act()
    {   
        teamCash = restaurant.getCash();
        if (DayWorld.timer == 400 && teamCash > purchaseRange) {
            getWorld().removeObject(this);
            restaurant.collectCash(-value);
            HungryChef newChef = new HungryChef();
            restaurant.hireChef(newChef, restaurant);
            
            SoundManager.playMoney();
            isBought = true;
        }
        
        isBought = false;
    }
}
