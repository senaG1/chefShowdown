import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The StartWorld class is a Greenfoot World.
 * <p>
 * When added, it will have a button object that will setWorld to StoryWorld.
 * 
 * @author Isabel Powell 
 * @version Nov 10 2025
 */
public class StartWorld extends World
{
    private GreenfootImage background;
    private Button button;
    private int timer = -1;
    private boolean switching = false;
    private boolean hasStarted =  false;
    private boolean music = false;
    
    /**
     * Constructor for StartWorld - creates a new StartWorld.
     * Added when Simulation is first opened.
     * 
     */
    public StartWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        
        background = new GreenfootImage("start_Screen.png");
        setBackground(background);
        button = new Button("startButton(1).png", "small_button.png");
        addObject(button, 480, 376);
    }
    
    public void act()
    {
        if(Greenfoot.mouseClicked(button))
        {
            SoundManager.playFasterGameStart();
            switching = true;
            timer = 110;
        }
        
        if(switching){
            timer--;
            if(timer <=0){
                SoundManager.stopAllSounds();
                Greenfoot.setWorld(new StoryWorld());  
            }
        }
    }
    
    /**
     * Called when the world is stopped. Stops all background music and sound effects.
     */
    public void stopped() {
        SoundManager.stopAllSounds();
    }
    
    /**
     * Called when the world is started/resumed. Restarts background music only if resuming.
     */
    public void started() {
        if(!music){
            SoundManager.playStartBg();
            music = true;
            return;
        }
        SoundManager.playStartBg();
    }
    
}
