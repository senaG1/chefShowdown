import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CelebEndorsement here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CelebEndorsement extends Actor
{
    private GreenfootImage image;
    private int value;
    private int teamCash;
    private boolean isBought;
    private RestaurantWorld rw;
    public CelebEndorsement(int teamCash) {
        this.teamCash = teamCash;
        image = new GreenfootImage("Buffs/Celeb_Endorsement.png");
        setImage(image);
    }
    
    public void addedToWorld(World w){
        rw = (RestaurantWorld) w;
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
}
