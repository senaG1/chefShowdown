import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestaurantWorld extends World
{
    private GreenfootImage background;
    private int actTimer = 180;
    public UI ui;
    
    public RestaurantWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        
        background = new GreenfootImage("restaurant_bg.png");
        background.scale(background.getWidth() * 5/2, background.getHeight() * 5/2 );
        setBackground(background);
        
        ui = new UI(this);
        
        addKitchenObjects();
    }
    
    public void act()
    {
        actTimer--;
        if(actTimer == 0)
        {
            addCustomers();
            actTimer = 180;
        }
    }
    
    private void addKitchenObjects() {
        addObject(new KitchenObject("fridge.png"), 210, 174);
        addObject(new KitchenObject("sink_double.png"), 428, 190);
        addObject(new KitchenObject("stove_front_off.png"), 402, 195);
        
        
        
        addObject(new KitchenObject("fridge.png"), 540, 174);
        addObject(new KitchenObject("sink_double.png"), 628, 190);
        addObject(new KitchenObject("stove_front_off.png"), 702, 195);
        addObject(new KitchenObject("fryer.png"), 760, 191);
        
        addObject(new KitchenObject("counter_side_small.png"), 520, 332);
        addObject(new KitchenObject("mixer_left.png"), 520, 298);
        addObject(new KitchenObject("bread_station_left.png"), 520, 392);
        addObject(new KitchenObject("sink_single_left.png"), 520, 462);
        addObject(new KitchenObject("dishes_left.png"), 522, 508);
        addObject(new KitchenObject("counter_left.png"), 520, 582);
        
        addObject(new KitchenObject("grill_back.png"), 590, 598);
        addObject(new KitchenObject("stove_back_off.png"), 664, 600);
        addObject(new KitchenObject("counter_shelf.png"), 738, 594);
    }
    
    private void addCustomers()
    {
        addObject(new Customer(), 51, 628);
    }
}
