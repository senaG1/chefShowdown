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
    //Counters
    private int actCount;
    private int actTimer = 180;
    private int dayTimer = 1800;
    
    private ArrayList<Customer> customers;
    //Restaurants
    public Restaurant restaurantBlue;
    public Restaurant restaurantRed;
    
    private int width = 960;
    private int height = 640;
    
    private int currentDay;
    private boolean spawnAtRed;

    //Constants
    private static int labelHeight = 30;
    private static int labelSize = 25;
    
    public RestaurantWorld() {
        this(1);
        
        prepare();
    }

    public RestaurantWorld(int currentDay)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        this.currentDay = currentDay;

        background = new GreenfootImage("restaurant_bg.png");
        background.scale(background.getWidth() * 5/2, background.getHeight() * 5/2 );
        setBackground(background);
        
        actCount = 0;
        
        if (restaurantBlue == null) {
            restaurantBlue = new Restaurant(SettingsWorld.getNumBlueChefs(), SettingsWorld.getStartMoneyBlue(), "Blue", 0);
            addObject(restaurantBlue, 0, height);
        }
        if (restaurantRed == null) {
            restaurantRed = new Restaurant(SettingsWorld.getNumRedChefs(), SettingsWorld.getStartMoneyRed(), "Red", width/2);
            addObject(restaurantRed, width/2, height);
        }
        //testing
        addObject(new ChefCohenBlue(), 415, 265);
        addObject(new ChefCohenRed(), 525, 265);
        addObject(new HungryChef(), 415, 465);
        addObject(new HungryChef(), 525, 465);
        
        addKitchenObjects();
        setPaintOrder(SuperStatBar.class, SuperSpeechBubble.class);
    }

    public void act()
    {
        actTimer--;
        actCount++;
        dayTimer--;
        if(actTimer == 0)
        {
            addCustomers();
            actTimer = 180;
        }

        if (actCount % 600 == 0){
            //addObject(new PowerOutage("Blue"), 512, 400);
        }

        if (actCount % 800 == 0){
            //addObject(new RatInfestation("Blue"), 0, 0);
        }

        if (actCount % 500 == 0){
            //addObject(new PowerOutage("Red"), 485, 400);
        }

        if (actCount % 900 == 0){
            //addObject(new RatInfestation("Red"), 0, 0);
        }

        if(dayTimer == 0){
            removeCustomers();
            Greenfoot.setWorld(new DayWorld(this));
            dayTimer = 3600;
        }
        
        if(currentDay == 4)
        {
            endGame();
        }
        
    }
    
    public void tomorrow(){
        currentDay++;
    }
    
    public int getCurrentDay(){
        return currentDay;
    }
    
    private void endGame()
    {
        int leftCash = restaurantBlue.getCash();
        int rightCash = restaurantRed.getCash();
        double leftRating = restaurantBlue.getRating();
        double rightRating = restaurantRed.getRating();
        Greenfoot.setWorld(new StatsWorld(leftCash, rightCash, leftRating, rightRating));
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
        addObject(new KitchenObject("counter_shelf_veggies.png"), 318, 590);
        addObject(new KitchenObject("grill_back_meat.png"), 410, 594);

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

        addObject(new KitchenObject("grill_back_meat.png"), 548, 594);
        addObject(new KitchenObject("stove_back_off.png"), 622, 596);
        addObject(new KitchenObject("counter_shelf_veggies.png"), 696, 590);
    }
    //Spawns customers
    private void addCustomers()
    {
        int customerType = Greenfoot.getRandomNumber(10);
        
        Restaurant spawnRestaurant = Greenfoot.getRandomNumber(2) == 0 ? restaurantBlue : restaurantRed;
        if(customerType <= 4) {
            addObject(new RegularCustomer(spawnRestaurant), spawnRestaurant.getCustSpawnX(), spawnRestaurant.getCustSpawnY());
        }
        else if(customerType <= 6) {
            addObject(new Karen(spawnRestaurant), spawnRestaurant.getCustSpawnX(), spawnRestaurant.getCustSpawnY());
        }
        else if(customerType <= 9){
            addObject(new Influencer(spawnRestaurant), spawnRestaurant.getCustSpawnX(), spawnRestaurant.getCustSpawnY());
        }
        else{
            addObject(new ChefCohen(spawnRestaurant), spawnRestaurant.getCustSpawnX(), spawnRestaurant.getCustSpawnY());
        }
    }
    
    //Removes all customers when it switches the day
    private void removeCustomers(){
        ArrayList<Customer> cust = (ArrayList<Customer>) getObjects(Customer.class);
        
        for(Customer c : cust){
            removeObject(c);
        }
    }
    
    public void spawnCustomers(int amountOfCust, String restaurant){
        Restaurant rest = restaurant.equals("Blue") ? restaurantBlue : restaurantRed;
        for(int i = 0; i < amountOfCust; i++){
            int customerType = Greenfoot.getRandomNumber(10);
            
            if(customerType <= 5) {
                addObject(new RegularCustomer(rest), rest.getCustSpawnX(), rest.getCustSpawnY());
            }
            else if(customerType <= 7) {
                addObject(new Karen(rest), rest.getCustSpawnX(), rest.getCustSpawnY());
            }
            else{
                addObject(new ChefCohen(rest), rest.getCustSpawnX(), rest.getCustSpawnY());
            }
            
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
