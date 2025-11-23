import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cheap chef that cooks very slowly
 * 
 * @author Cayden Chan
 * @version November 2025
 */
public class LazyChef extends Chef
{
    /**
     * Default constructor for LazyChef: sets the salary, image, cook speed and skill
     */
    public LazyChef(){
        salary = 5;
        setImage("lazy_chef.png");
        cookSpeed = 300;
        skill = 2;
    }

    public void act()
    {
        super.act();
    }
}
