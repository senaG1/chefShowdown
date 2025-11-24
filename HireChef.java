import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HireChef here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HireChef extends Actor
{
    private GreenfootImage image;
    private Restaurant restaurant;
    private int value;
    private boolean isBought;
    private int teamCash;
    public HireChef(int cost, int teamCash) {
        value = cost;
        this.restaurant = restaurant;
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Hire_MasterChef.png");
        setImage(image);
    }
    
    public void addedToWorld() {
        
    }
    
    public void act()
    {
        if (DayWorld.timer == 150 && teamCash > value + 200) {
            getWorld().removeObject(this);
            SoundManager.playMoney();
            isBought = true;
        }
        
        isBought = false;
    }
    
    private void drawImage() {
        
    }
}
