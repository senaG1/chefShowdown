import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartWorld here.
 * 
 * @author Isabel Powell 
 * @version (a version number or a date)
 */
public class StartWorld extends World
{
    private GreenfootImage background;
    /**
     * Constructor for objects of class StartWorld.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        
        background = new GreenfootImage("start_Screen.png");
        setBackground(background);
        
        addObject(new Button("small_button.png", "startButton.png"), 480, 376);
    }
   
}
