import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Cheap chef that cooks very slowly
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LazyChef extends Chef
{
    private int actCount;

    public LazyChef(){
        salary = 5;
        setImage("lazy_chef.png");
        cookSpeed = 300;
        skill = 2;
    }
    
    public void act()
    {
        super.act();
        actCount++;
    }
}
