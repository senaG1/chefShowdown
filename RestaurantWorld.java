import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
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
    private ArrayList<Customer> customers;
    
    public RestaurantWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        
        background = new GreenfootImage("restaurant_bg.png");
        background.scale(background.getWidth() * 5/2, background.getHeight() * 5/2 );
        setBackground(background);
        
        ui = new UI(this);
        
        actCount = 0;
        
        //testing
        addObject(new ChefCohenBlue(), 415, 265);
        addObject(new ChefCohenBlue(), 525, 265);
        
        addKitchenObjects();
        setPaintOrder(SuperStatBar.class, SuperSpeechBubble.class);
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
        
        if (actCount % 800 == 0){
            addObject(new PowerOutage(), 512, 400);
        }
        
        if (actCount % 1200 == 0){
            addObject(new RatInfestation(), 0, 0); // Position doesn't matter for this effect
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
    //Currently the right side spawn does not work
    private void addCustomers()
    {
        int rand = Greenfoot.getRandomNumber(30);
        int customerType = Greenfoot.getRandomNumber(10);
        
            //boolean spawnAtRed = Greenfoot.getRandomNumber(2) == 0 ? true : false;
            boolean spawnAtRed = false;
        if (spawnAtRed){
            if(customerType <= 4) {
                addObject(new RegularCustomer(), 908, 628);
            }
            else if(customerType <= 6) {
                addObject(new Karen(), 908, 628);
            }
            else if(customerType <= 9){
                addObject(new Influencer(), 908, 628);
            }
            else{
                addObject(new ChefCohen(), 908, 628);
            }
            } else {
            if(customerType <= 4) {
                addObject(new RegularCustomer(), 51, 628);
            }
            else if(customerType <= 6) {
                addObject(new Karen(), 51, 628);
            }
            else if(customerType <= 9){
                addObject(new Influencer(), 51, 628);
            }
            else{
                addObject(new ChefCohen(), 51, 628);
            }
            
        }
    }
    
    
}
