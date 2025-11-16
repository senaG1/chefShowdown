import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Influencer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Influencer extends Customer
{
    private GreenfootImage image;
    private boolean firstAct = true;
    public Influencer(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("influencer_00.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    
    public void act()
    {
        super.act();
        Paparazzi effect;
        if (firstAct) {
            effect = new Paparazzi();
            rw.addObject(effect, getX(), getY() - 100);
            firstAct = false;
        } else {
            
        }
    }
}
