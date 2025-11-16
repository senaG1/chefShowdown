import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ChefCohen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ChefCohen extends Customer
{
    private GreenfootImage image;
    public ChefCohen(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("ChefCohen.png");
        setImage(image);
        
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    /**
     * Act - do whatever the ChefCohen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
