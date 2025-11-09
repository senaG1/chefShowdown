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
    public RegularCustomer(){
        super();
        image = new GreenfootImage ("regular_Cust.png");
        image.scale(image.getWidth()*4, image.getHeight()*4);
        setImage(image);
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
