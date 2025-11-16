import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class can be used for any object that moves downwards
 * 
 * @author Isabel Powell
 * @version (a version number or a date)
 */
public class StatScreen extends SuperSmoothMover
{
    private GreenfootImage image;
    private double verSpeed = 6;
    private boolean doAction;
    private double yCord; //Y position where object will stop
    private boolean isAtY = false;
    
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
    
    public boolean isAtPosition(){
        return isAtY;
    }
    
    /*
     * Public method is used to call from to start action
     */
    public void callAction(){
        doAction = true;
    }
}
