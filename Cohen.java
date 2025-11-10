import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CohenMaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cohen extends SuperSmoothMover
{
    private GreenfootImage image;
    
    public Cohen(String img){
        image = new GreenfootImage(img);
        //image.scale(image.getWidth() * 2, image.getHeight() * 2);
        setImage(image);
    }
    /**
     * Act - do whatever the CohenMaker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
