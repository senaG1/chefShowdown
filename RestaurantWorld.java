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
    private int actCount;
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
        
        actCount = 0;
        
        addKitchenObjects();
    }
    
    public void act()
    {
        actTimer--;
        actCount++;
        if(actTimer == 0)
        {
            addCustomers();
            actTimer = 180;
        }
        
        if (actCount % 360 == 0){
            addObject(new PowerOutage(), 512, 400);
        }
    }
    
    private void addKitchenObjects() {
        addObject(new KitchenObject("fridge.png"), 540, 174);
        addObject(new KitchenObject("sink_double.png"), 628, 190);
        addObject(new KitchenObject("stove_front_off.png"), 702, 195);
        addObject(new KitchenObject("fryer.png"), 760, 191);
        
        addObject(new KitchenObject("bread_station.png"), 777, 350);
        addObject(new KitchenObject("sink_single_side.png"), 777, 420);
        addObject(new KitchenObject("dishes_side.png"), 775, 466);
        
        addObject(new KitchenObject("grill_back.png"), 540, 598);
        addObject(new KitchenObject("stove_back_off.png"), 614, 600);
        addObject(new KitchenObject("counter_shelf.png"), 688, 594);
    }
    
    private void addCustomers()
    {
        addObject(new Customer(), 51, 628);
    }
}
