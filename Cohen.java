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
    private boolean isGold;
    public Cohen(String img, boolean gold){
        isGold = gold;
        image = new GreenfootImage(img);
        if(isGold){
            image.scale(image.getWidth() * 1/6, image.getHeight()*1/6);
        }
        else{
            image.scale(image.getWidth() * 1/2, image.getHeight() * 1/2);
        }
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
