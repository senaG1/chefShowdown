import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Cohen class is a Greenfoot actor, that inherits from SuperSmoothMover.
 * <p>
 * This class is mostly used for the muitple Mr. Cohen images and to let the image "move".
 * 
 * @author Isabel Powell
 * @version 3 Nov. 22 2025 
 */
public class Cohen extends SuperSmoothMover
{
    private GreenfootImage image;
    private boolean isGold;
    
    private double gravity = 0.5;
    private double verSpeed = 0;
    
    private boolean doAction;
    private boolean jumping;
    private double ogY;
    
    /**
     * Constructor for Cohen - creates a new Cohen.
     * This is called from Story World and End World.
     * 
     * @param img    Lets other classes call this class to create an image as an object
     * @param gold  True if image is the special gold image
     * 
     */
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
        if(doAction && !jumping){
            initalHop(); 
        }
        if(jumping){
            hop();
        }
    }

    /**
     * Switches current image to new image, can be used for any image
     * 
     * @param newImage    String word of new file name
     * @return void     Will run if called, returns nothings
     * 
     */
    public void switchImage(String newImage){
        image = new GreenfootImage(newImage);
        
        if(isGold){
            image.scale(image.getWidth() * 1/6, image.getHeight()*1/6);
        }
        else{
            image.scale(image.getWidth() * 1/2, image.getHeight() * 1/2);
        }
        setImage(image);
    }
    
    private void initalHop(){
        jumping = true;
        ogY = getPreciseY();
        verSpeed = -8;
        doAction = false;
    }
    
    private void hop(){
        setLocation(getPreciseX(), getPreciseY() + verSpeed); //Moves object up
        verSpeed += gravity; //Creates sorta realisic gravity
        if(getPreciseY() >= ogY){
            setLocation(getPreciseX(), ogY); //Forces object to snap to OG coord
            jumping = false; //Stops muitple jumps
            verSpeed = 0;
        }
    }
    /**
     * This method is for other classes such as story world, and end World to call from.
     * To get the Cohens to do actions.
     * 
     * @return void    if called from, doAction will become true
     */
    public void callAction(){
        doAction = true;
    }
    
}
