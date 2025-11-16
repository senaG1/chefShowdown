import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RegularCustomer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RegularCustomer extends Customer
{
    private GreenfootImage image;
    public RegularCustomer(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("regular_Cust.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    
    /**
     * Act - do whatever the RegularCustomer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public void act()
    {
        super.act();
    }
}
