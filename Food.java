import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Food here.
 * 
 * @author Jiayu Chen
 * @version 11-10 1.0
 */
public class Food extends SuperSmoothMover
{
    protected GreenfootImage image;
    
    protected int cost;
    protected int quality;
    
    protected boolean dirty;
    public Food() {
        image = new GreenfootImage("burger.png");
        setImage(image);
    }
    
    public void act()
    {
        
    }
}
