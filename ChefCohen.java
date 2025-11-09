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
    public ChefCohen(){
        super();
        image = new GreenfootImage ("pixelCoden.png");
        image.scale(image.getWidth()*4, image.getHeight()*4);
        setImage(image);
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
