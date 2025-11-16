import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CohenMaker here.
 * 
 * @author Isabel Powell
 * @version 2 
 */
public class Cohen extends SuperSmoothMover
{
    private GreenfootImage image;
    private boolean isGold;
    
    private double gravity = 0.2;
    private double verSpeed = -6;
    private double horSpeed;
    
    private boolean doAction;
    
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
        if(doAction){
            hop();
        }
    }
    
    private void hop(){
        setLocation(getPreciseX(), getPreciseY() + verSpeed);
        turn(2); 
        verSpeed += gravity; 
        doAction = false;
    }
    
    public void callAction(){
        doAction = true;
    }
    
}
