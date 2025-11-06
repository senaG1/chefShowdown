import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KitchenObject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KitchenObject extends Actor
{
    private GreenfootImage image;
    
    public KitchenObject(String costumeName) {
        image = new GreenfootImage(costumeName);
        image.scale(image.getWidth() * 2, image.getHeight() * 2);
        setImage(image);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
