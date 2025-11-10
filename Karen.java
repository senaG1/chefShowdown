import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Karen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Karen extends Customer
{
    private GreenfootImage image;
    //Karens should be more impatient
    protected int maxPatience = 1050; // 17.5 secs before patience runs out
    protected int currentPatience = 1050;
    public Karen(){
        super();
        image = new GreenfootImage ("Karen_00.png");
        image.scale(image.getWidth()*3, image.getHeight()*3);
        setImage(image);
    }
    /**
     * Act - do whatever the Karen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
    }
}
