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
    //Here for now, will change when settings world added days 
    private int maxDays = 3;

    //Constants
    private static int labelHeight = 30;
    private static int labelSize = 25;
    
    // Effect cooldown timers - prevent multiple effects on same side at once
    private int blueEffectCooldown = 0;
    private int redEffectCooldown = 0;
    private static final int EFFECT_COOLDOWN_TIME = 600; // 10 seconds
    
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
            restaurantBlue = new Restaurant(SettingsWorld.getBlueChefs(), SettingsWorld.getStartMoneyBlue(), "Blue", 0);
            addObject(restaurantBlue, 0, height);
        }
        if (restaurantRed == null) {
            restaurantRed = new Restaurant(SettingsWorld.getRedChefs(), SettingsWorld.getStartMoneyRed(), "Red", width/2);
            addObject(restaurantRed, width/2, height);
        }
        //testing
        
        addChefs();
       
        
        addKitchenObjects();
        setPaintOrder(SuperStatBar.class, SuperSpeechBubble.class);
    }

    public void act()
    {
        actTimer--;
        actCount++;
        dayTimer--;
        
        // Countdown cooldown timers
        if (blueEffectCooldown > 0) blueEffectCooldown--;
        
        if (redEffectCooldown > 0) redEffectCooldown--;
        
        if(actTimer == 0)
        {
            addCustomers();
            actTimer = 180;
        }

        if (actCount % 2300 == 0){
            trySpawnEffect("Blue", "PowerOutage");
        }

        if (actCount % 1500 == 0){
            trySpawnEffect("Blue", "RatInfestation");
        }

        if (actCount % 1200 == 0){
            trySpawnEffect("Red", "PowerOutage");
        }
        
        if (actCount % 1900 == 0){
            trySpawnEffect("Red", "RatInfestation");
        }

        if(dayTimer == 0){
            removeCustomers();
            int leftCash = restaurantBlue.getCash();
            int rightCash = restaurantRed.getCash();
            double leftRating = restaurantBlue.getRating();
            double rightRating = restaurantRed.getRating();
            Greenfoot.setWorld(new DayWorld(this, leftCash, leftRating, rightCash, rightRating));
            dayTimer = 3600;
        }
        
        if(currentDay == maxDays)
        {
            endGame();
        }
    }
    
    /**
     * Attempts to spawn an effect on the specified side.
     * If that side already has an active effect, waits for cooldown.
     */
    private void trySpawnEffect(String side, String effectType){
        if(side.equals("Blue")){
            //No active effect on Blue side, spawn it
            spawnEffect(side, effectType);
            blueEffectCooldown = EFFECT_COOLDOWN_TIME;
        }else if(side.equals("Red")){ 
            if(redEffectCooldown == 0){
                // No active effect on Red side, spawn it
                spawnEffect(side, effectType);
                redEffectCooldown = EFFECT_COOLDOWN_TIME;
            }
        }
    }
    
    /**
     * Actually spawns the effect
     */
    private void spawnEffect(String side, String effectType){
        if(effectType.equals("PowerOutage")){
            int x = side.equals("Blue")? 512 : 485;
            addObject(new PowerOutage(side), x, 400);
        } else if(effectType.equals("RatInfestation")){
            addObject(new RatInfestation(side), 0, 0);
        }
    }
    
    public void stopped() {
        SoundManager.stopAllSounds();
    }
    
    private void addChefs() {
        // Get the chef counts from SettingsWorld
        ArrayList<Integer> blueChefCounts = SettingsWorld.getBlueChefs();
        ArrayList<Integer> redChefCounts = SettingsWorld.getRedChefs();
        
        // Define spawn positions for blue side (left side of screen)
        int[] blueXPositions = {210, 282, 340, 415};
        int[] blueYPositions = {265, 265, 465, 465};
        
        // Define spawn positions for red side (right side of screen)
        int[] redXPositions = {540, 628, 702, 760};
        int[] redYPositions = {265, 265, 465, 465};
        
        // Create and add blue chefs based on counts
        ArrayList<Chef> blueChefs = new ArrayList<Chef>();
        
        // Add Master Chefs (index 0)
        for (int i = 0; i < blueChefCounts.get(0); i++) {
            blueChefs.add(new MasterChef());
        }
        // Add Cohen Chefs (index 1)
        for (int i = 0; i < blueChefCounts.get(1); i++) {
            blueChefs.add(new ChefCohenBlue());
        }
        // Add Hungry Chefs (index 2)
        for (int i = 0; i < blueChefCounts.get(2); i++) {
            blueChefs.add(new HungryChef());
        }
        // Add Lazy Chefs (index 3)
        for (int i = 0; i < blueChefCounts.get(3); i++) {
            blueChefs.add(new LazyChef());
        }
        
        // Add blue chefs to the world
        int blueIndex = 0;
        for (Chef chef : blueChefs) {
            if (blueIndex < blueXPositions.length) {
                addObject(chef, blueXPositions[blueIndex], blueYPositions[blueIndex]);
                blueIndex++;
            }
        }
        
        // Create and add red chefs based on counts
        ArrayList<Chef> redChefs = new ArrayList<Chef>();
        
        // Add Master Chefs (index 0)
        for (int i = 0; i < redChefCounts.get(0); i++) {
            redChefs.add(new MasterChef());
        }
        // Add Cohen Chefs (index 1)
        for (int i = 0; i < redChefCounts.get(1); i++) {
            redChefs.add(new ChefCohenRed());
        }
        // Add Hungry Chefs (index 2)
        for (int i = 0; i < redChefCounts.get(2); i++) {
            redChefs.add(new HungryChef());
        }
        // Add Lazy Chefs (index 3)
        for (int i = 0; i < redChefCounts.get(3); i++) {
            redChefs.add(new LazyChef());
        }
        
        // Add red chefs to the world
        int redIndex = 0;
        for (Chef chef : redChefs) {
            if (redIndex < redXPositions.length) {
                addObject(chef, redXPositions[redIndex], redYPositions[redIndex]);
                redIndex++;
            }
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
        Greenfoot.setWorld(new EndingWorld(leftCash, rightCash, leftRating, rightRating));
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
