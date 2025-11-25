import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Scales and sets the images for kitchen objects.
 * 
 * @author Grace Tao
 * @version Nov 2025
 */
public class KitchenObject extends Actor
{
    private GreenfootImage image;
    
    /**
     * The constructor for KitchenObject.
     * 
     * @param costumeName   Takes the name of the png.file of the image
     */
    public KitchenObject(String costumeName) {
        image = new GreenfootImage(costumeName);
        image.scale(image.getWidth() * 2, image.getHeight() * 2);
        setImage(image);
    }
}
