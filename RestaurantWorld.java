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
        
        if (actCount % 1200 == 0){
            addObject(new PowerOutage(), 512, 400);
        }
    }
    
    private void addKitchenObjects() {
        // Kitchen objects for blue side
        addObject(new KitchenObject("fridge.png"), 210, 174);
        addObject(new KitchenObject("fryer.png"), 282, 191);
        addObject(new KitchenObject("stove_front_off.png"), 340, 195);
        addObject(new KitchenObject("sink_double.png"), 415, 190);
        
        
        addObject(new KitchenObject("dishes_left.png"), 194, 320);
        addObject(new KitchenObject("sink_single_left.png"), 192, 380);
        addObject(new KitchenObject("bread_station_left.png"), 192, 440);
        addObject(new KitchenObject("counter_side_small.png"), 192, 512);
        addObject(new KitchenObject("mixer_left.png"), 192, 480);
        addObject(new KitchenObject("counter_left.png"), 192, 578);
        
        addObject(new KitchenObject("stove_back_off.png"), 244, 596);
        addObject(new KitchenObject("counter_shelf.png"), 318, 590);
        addObject(new KitchenObject("grill_back.png"), 410, 594);
        
        
        // Kitchen objects for red side
        addObject(new KitchenObject("fridge.png"), 540, 174);
        addObject(new KitchenObject("sink_double.png"), 628, 190);
        addObject(new KitchenObject("stove_front_off.png"), 702, 195);
        addObject(new KitchenObject("fryer.png"), 760, 191);
        
        addObject(new KitchenObject("counter_side_small.png"), 766, 330);
        addObject(new KitchenObject("mixer_right.png"), 766, 290);
        addObject(new KitchenObject("bread_station_right.png"), 766, 390);
        addObject(new KitchenObject("sink_single_right.png"), 766, 460);
        addObject(new KitchenObject("dishes_right.png"), 764, 506);
        addObject(new KitchenObject("counter_left.png"), 766, 578);
        
        addObject(new KitchenObject("grill_back.png"), 548, 594);
        addObject(new KitchenObject("stove_back_off.png"), 622, 596);
        addObject(new KitchenObject("counter_shelf.png"), 696, 590);
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
