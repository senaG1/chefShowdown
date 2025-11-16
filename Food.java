import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author Jiayu Chen
 * @version 11-13 1.0
 */
public class Food extends SuperSmoothMover
{
    private GreenfootImage image;
    private int quality;
    private int orderNumber;
    public Food(String type, int quality, int orderNumber) {
        image = new GreenfootImage(type + ".png");
        image.scale(52, 52);
        setImage(image);
        
        this.quality = quality;
        this.orderNumber = orderNumber;
    }
    
    public void act()
    {
        
    }
    
    public int getOrderNumber() {
        return orderNumber;
    }
}
