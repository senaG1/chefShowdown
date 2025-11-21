import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class can be used for any object that moves downwards.
 * 
 * @author Isabel Powell
 * @version Nov. 17 2025
 */
public class StatScreen extends SuperSmoothMover
{
    private GreenfootImage image;
    private double verSpeed = 6;
    private boolean doAction;
    private double yCord; //Y position where object will stop
    private boolean isAtY = false;
    /**
     * Constructor for StatScreen - creates a new StatScreen.
     * This is called from StatsWorld.
     * 
     * @param costumeName   Lets other classes call this class to create an image as an object
     * @param yCord     For other classes to speically where the object should slide down from.
     */
    public StatScreen(String costumeName, double yCord) {
        image = new GreenfootImage(costumeName);
        //image.scale(image.getWidth() * 2, image.getHeight() * 2);
        setImage(image);
        this.yCord = yCord;
        this.doAction = false;
    }
    
    /**
     * Act - do whatever the StatScreen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
       if(doAction && !isAtY){
           sideDown();
       }
        
    }
    
    private void sideDown(){
        if(getPreciseY() < yCord){
            setLocation(getPreciseX(), getPreciseY() + verSpeed);
            
            if(getPreciseY() >= yCord){
                setLocation(getPreciseX(), yCord);
                isAtY = true;
            }
        }
        
    }
    
    private boolean isAtPosition(){
        return isAtY;
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
