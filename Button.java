import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.*; 
 
/**
 * The Button class creates an interactive button that the user can click.
 *
 * @author Yehuda (1/2 of Nosson1459 - greenfoot.org user name)
 * @version Nov 2025 - Modified by Grace Tao
 */
public class Button extends Actor {
    private GreenfootImage image;
    private GreenfootImage image_2;
    private Actor actorHoveredOver = null;
    private boolean clicked = false;
    
    /**
     * The constructor of the Button class.
     * 
     * @param image1    Takes the first image and sets it.
     * @param image2    Takes the second image and stores it.
     */
    public Button(String image1, String image2){
        image = new GreenfootImage (image1);
        image_2 = new GreenfootImage(image2);
        setImage(image);
    }
    
    public void act(){
        if (mouseHoveringOver(this)) {
            setImage(image_2);
        }
        else {
        setImage(image);
        }
        
        if(Greenfoot.mouseClicked(this)){
            clicked = true;
        } else {
            clicked = false;
        }
    }
    /**
     * This method checks to see which button the mouse is hovering over
     */
    public boolean isClicked() {
        return clicked;
    }
    
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
    
    public void scale(int ratio) {
        image.scale(image.getWidth()*ratio, image.getHeight()*ratio);
        image_2.scale(image_2.getWidth()*ratio, image_2.getHeight()*ratio);
        
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