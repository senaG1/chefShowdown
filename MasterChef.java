import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * High cost chef that cooks very fast
 * 
 * @author Cayden Chan
 * @version November 2025
 */
public class MasterChef extends Chef
{
    /**
     * Default constructor for MasterChef: sets the salary, image, cook speed and skill
     */
    public MasterChef(){
        salary = 30;
        setImage("master_chef.png");
        cookSpeed = 120;
        skill = 5;
    }
    
    public void act()
    {
        super.act();
    }
}
