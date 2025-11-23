import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A regular Chef with a modest salary and average quality
 * 
 * @author Cayden Chan
 * @version November 2025
 */
public class ChefCohen extends Chef
{
    /**
     * Default constructor for ChefCohen: sets the salary, image, cook speed and skill
     */
    public ChefCohen()
    {
        salary = 10;
        setImage("ChefCohen.png");
        cookSpeed = 210;
        skill = 3;
    }
    
    public void act()
    {
        super.act();
    }
}
