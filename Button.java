import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.*; 
 
/**
 * Write a description of class Buttons here.
 *
 * @author Yehuda (1/2 of Nosson1459 - greenfoot.org user name)
 * @version (a version number or a date)
 */
public class Button extends Actor {
    private GreenfootImage image;
    private GreenfootImage sImage;
    private Actor actorHoveredOver = null;
    
    public Button(String image1, String image2){
        image = new GreenfootImage (image1);
        sImage = new GreenfootImage(image2);
        setImage(image);
    }
    
    public void act(){
        if (mouseHoveringOver(this)) {
            
            setImage(sImage);
        }
        else {
        setImage(image);
        }
        
        if(Greenfoot.mouseClicked(this)){
            Greenfoot.setWorld(new StoryWorld());
        }
    }
    /**
     * This method checks to see which button the mouse is hovering over
     */
    private void hoverOwner() {
        if ((actorHoveredOver == null || actorHoveredOver.getWorld() == null)
                && Greenfoot.mouseMoved(this)) {
            actorHoveredOver = this;
        } else if (actorHoveredOver == this && Greenfoot.mouseMoved(null)
                && !Greenfoot.mouseMoved(this)) {
            actorHoveredOver = null;
        }
    }
 
    /**
     * This methods returns true if the mouse is hovering over the specified
     * button.
     *
     * @param button the button to see if hovering over
     * @return true, if mouse is over specified button
     */
    public boolean mouseHoveringOver(Actor actor) {
        hoverOwner();
        return actorHoveredOver == actor;
    }
 
    /**
     * Gets the button that the mouse is hovering over.
     *
     * @return the button that the mouse is over
     */
    public Actor getHoverOwner() {
        return actorHoveredOver;
    }
}