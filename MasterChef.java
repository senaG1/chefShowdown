import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * High cost chef that cooks very fast
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MasterChef extends Chef
{
    private int actCount;

    public MasterChef(){
        setImage("master_chef.png");
        cookSpeed = 120;
        skill = 5;
    }
    
    public void act()
    {
        super.act();
        actCount++;
    }
}
