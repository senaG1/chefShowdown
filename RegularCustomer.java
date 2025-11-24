import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The RegularCustomer class is a Greenfoot actor, that inherits from Customer.
 * <p>
 * When added into world, it will be exactly what Customer is with nothing different.
 * 
 * @author Isabel Powell
 * @version Nov 12 2025
 */
public class RegularCustomer extends Customer
{
    private GreenfootImage image;
    
    /**
     * Constructor for RegularCustomer - creates a new RegularCustomer.
     * This is called from Restaurant World.
     * 
     * @param restaurant    restaurant object
     */
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
