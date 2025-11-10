import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Influencer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Influencer extends Customer
{
    private GreenfootImage image;
    private World w;
    public Influencer(){
        super();
        image = new GreenfootImage ("influencer_00.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
    }
    /**
     * Act - do whatever the Influencer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
    
    public void addedToWorld(World w) {
        getWorld().addObject(new Paparazzi(), getX(), getY());
    }
}
