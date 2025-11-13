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
    public Influencer(boolean spawnAtRed){
        super();
        image = new GreenfootImage ("influencer_00.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        if(spawnAtRed)
        {
            LINE_X = 909;
            LINE_START_Y = 512;
        }
        else
        {
            LINE_X = 62;
            LINE_START_Y = 512;
        }
    }
    
    public void act()
    {
        super.act();
        
        if (firstAct) {
            Paparazzi effect = new Paparazzi();
            rw.addObject(effect, getX(), getY() - 100);
            rw.teamRedUI.updateRating(5);
            firstAct = false;
        }   
    }
}
