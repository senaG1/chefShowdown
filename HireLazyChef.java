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
    public HireLazyChef(int cost, int teamCash, Restaurant restaurant) {
        value = cost;
        this.restaurant = restaurant;
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Hire_LazyChef.png");
        setImage(image);
    }
    
    public void addedToWorld() {
        
    }
    
    public void act()
    {   
        if (DayWorld.timer == 100 && teamCash > value + 200) {
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
