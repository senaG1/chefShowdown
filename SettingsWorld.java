import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author Grace Tao
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    // Blue restaurant settings
    private static int numChefsBlue;
    private static int startMoneyBlue;
    
    // Red restaurant settings
    private static int numChefsRed;
    private static int startMoneyRed;
    
    private GreenfootImage blueMenu;
    private GreenfootImage redMenu;
    
    private GreenfootImage background;
    
    // Blue restaurant buttons
    private Button chefPlusBlue;
    private Button chefMinusBlue;
    private Button moneyPlusBlue;
    private Button moneyMinusBlue;
    
    // Red restaurant buttons
    private Button chefPlusRed;
    private Button chefMinusRed;
    private Button moneyPlusRed;
    private Button moneyMinusRed;
    
    // Blue chef buttons
    private Button masterBlue;
    private Button cohenBlue;
    private Button hungryBlue;
    private Button lazyBlue;
    
    // Red chef buttons
    private Button masterRed;
    private Button cohenRed;
    private Button hungryRed;
    private Button lazyRed;
    
    private Button nextBtn;
    private Button playBtn;
    
    private ArrayList<Chef> blueChefs;
    private ArrayList<Chef> redChefs;
    
    private Restaurant restaurantBlue;
    private Restaurant restaurantRed;
    
    private final int MIN_CHEFS = 1;
    private final int MAX_CHEFS = 3;
    private final int MIN_MONEY = 500;
    private final int MAX_MONEY = 5000;
    private final int MONEY_INCREMENT = 100;
    
    private final int BLUE_CENTER_X = 280;
    private final int BLUE_CHEF_Y = 320;
    private final int BLUE_MONEY_Y = 390;
    
    private final int RED_CENTER_X = 680;
    private final int RED_CHEF_Y = 320;
    private final int RED_MONEY_Y = 390;
    
    public SettingsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        
        numChefsBlue = 1;
        startMoneyBlue = 1000;
        
        // Red restaurant settings
        numChefsRed = 1;
        startMoneyRed = 1000;
        
        background = new GreenfootImage("bg_settings.png");
        background.scale(background.getWidth() * 5/2, background.getHeight() * 5/2 );
        setBackground(background);
        
        blueMenu = new GreenfootImage(140, 100);
        
        addObjectsToWorld();
    }
    
    private void addObjectsToWorld(){
        // BLUE RESTAURANT BUTTONS
        // Buttons for chefs
        chefMinusBlue = new Button("minus_1.png", "minus_2.png");
        chefMinusBlue.scale(2);
        chefPlusBlue = new Button("plus_1.png", "plus_2.png");
        chefPlusBlue.scale(2);
        addObject(chefMinusBlue, BLUE_CENTER_X - 60, BLUE_CHEF_Y);
        addObject(chefPlusBlue, BLUE_CENTER_X + 20, BLUE_CHEF_Y);
        
        // Buttons for money
        moneyMinusBlue = new Button("minus_1.png", "minus_2.png");
        moneyMinusBlue.scale(2);
        moneyPlusBlue = new Button("plus_1.png", "plus_2.png");
        moneyPlusBlue.scale(2);
        addObject(moneyMinusBlue, BLUE_CENTER_X - 60, BLUE_MONEY_Y);
        addObject(moneyPlusBlue, BLUE_CENTER_X + 60, BLUE_MONEY_Y);
        
        // RED RESTAURANT BUTTONS
        // Buttons for chefs
        chefMinusRed = new Button("minus_1.png", "minus_2.png");
        chefMinusRed.scale(2);
        chefPlusRed = new Button("plus_1.png", "plus_2.png");
        chefPlusRed.scale(2);
        addObject(chefMinusRed, RED_CENTER_X - 60, RED_CHEF_Y);
        addObject(chefPlusRed, RED_CENTER_X + 20, RED_CHEF_Y);
        
        // Buttons for money
        moneyMinusRed = new Button("minus_1.png", "minus_2.png");
        moneyMinusRed.scale(2);
        moneyPlusRed = new Button("plus_1.png", "plus_2.png");
        moneyPlusRed.scale(2);
        addObject(moneyMinusRed, RED_CENTER_X - 60, RED_MONEY_Y);
        addObject(moneyPlusRed, RED_CENTER_X + 60, RED_MONEY_Y);
        
        nextBtn = new Button("next_1.png", "next_2.png");
        nextBtn.scale(3);
        addObject(nextBtn, 775, 520);
        
        // FOR CHEF CHOOSING SCREEN
        // Blue chef buttons
        masterBlue = new Button("masterBtn_1.png", "masterBtn_2.png");
        masterBlue.scale(3/2);
        
        cohenBlue = new Button("cohenBtn_1.png", "cohenBtn_2.png");
        cohenBlue.scale(3/2);
        
        hungryBlue = new Button("hungryBtn_1.png", "hungryBtn_2.png");
        hungryBlue.scale(3/2);
        
        lazyBlue = new Button("lazyBtn_1.png", "lazyBtn_2.png");
        lazyBlue.scale(3/2);
        
        // Red chef buttons
        masterRed = new Button("masterBtn_1.png", "masterBtn_2.png");
        masterRed.scale(3/2);
        
        cohenRed = new Button("cohenBtn_1.png", "cohenBtn_2.png");
        cohenRed.scale(3/2);
        
        hungryRed = new Button("hungryBtn_1.png", "hungryBtn_2.png");
        hungryRed.scale(3/2);
        
        lazyRed = new Button("lazyBtn_1.png", "lazyBtn_2.png");
        lazyRed.scale(3/2);
        
        playBtn = new Button("play_1.png", "play_2.png");
        playBtn.scale(2);
        
        updateDisplay1();
    }
    
    public void act() {
        checkButtons();
    }
    
    private void checkButtons()
    {
        if (chefMinusBlue.isClicked() && numChefsBlue > MIN_CHEFS)
        {
            numChefsBlue--;
            updateDisplay1();
        }
        if (chefPlusBlue.isClicked() && numChefsBlue < MAX_CHEFS)
        {
            numChefsBlue++;
            updateDisplay1();
        }
        
        if (moneyMinusBlue.isClicked() && startMoneyBlue > MIN_MONEY)
        {
            startMoneyBlue -= MONEY_INCREMENT;
            updateDisplay1();
        }
        if (moneyPlusBlue.isClicked() && startMoneyBlue < MAX_MONEY)
        {
            startMoneyBlue += MONEY_INCREMENT;
            updateDisplay1();
        }
        
        if (chefMinusRed.isClicked() && numChefsRed > MIN_CHEFS)
        {
            numChefsRed--;
            updateDisplay1();
        }
        if (chefPlusRed.isClicked() && numChefsRed < MAX_CHEFS)
        {
            numChefsRed++;
            updateDisplay1();
        }
        
        if (moneyMinusRed.isClicked() && startMoneyRed > MIN_MONEY)
        {
            startMoneyRed -= MONEY_INCREMENT;
            updateDisplay1();
        }
        if (moneyPlusRed.isClicked() && startMoneyRed < MAX_MONEY)
        {
            startMoneyRed += MONEY_INCREMENT;
            updateDisplay1();
        }
        
        if(nextBtn.isClicked()) {
            List objects = getObjects(null); 
            removeObjects(objects);  
            setBackground(new GreenfootImage(background));
            chooseChefs();
        }
        
        if(masterRed.isClicked()) {
            redChefs.add(new MasterChef());
            
        }
        
        if (playBtn.isClicked())
        {
            startGame();
        }
    }
    
    private void updateDisplay1() {
        // Get the background image
        setBackground(new GreenfootImage(background));
        GreenfootImage bg = getBackground();
        
        bg.setColor(new Color(99, 66, 66));
        
        // Draw title
        bg.setFont(new Font("Consolas", true, false, 64));
        bg.drawString("OPTIONS", 360, 200);
        
        // BLUE RESTAURANT (LEFT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(50, 100, 200)); 
        bg.drawString("BLUE", BLUE_CENTER_X - 50, 250);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", false, false, 24));
        bg.drawString("Chefs", BLUE_CENTER_X - 70, BLUE_CHEF_Y - 20);
        
        bg.setFont(new Font("Consolas", true, false, 28));
        bg.drawString(String.valueOf(numChefsBlue), BLUE_CENTER_X - 25, BLUE_CHEF_Y + 5);
        
        bg.setFont(new Font("Consolas", false, false, 24));
        bg.drawString("Money", BLUE_CENTER_X - 70, BLUE_MONEY_Y - 20);
        
        bg.setFont(new Font("Consolas", true, false, 28));
        bg.drawString("$" + startMoneyBlue, BLUE_CENTER_X - 40, BLUE_MONEY_Y + 5);
        
        // RED RESTAURANT (RIGHT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(200, 50, 50)); 
        bg.drawString("RED", RED_CENTER_X - 40, 250);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", false, false, 24));
        bg.drawString("Chefs", RED_CENTER_X - 70, RED_CHEF_Y - 20);
        
        bg.setFont(new Font("Consolas", true, false, 28));
        bg.drawString(String.valueOf(numChefsRed), RED_CENTER_X - 25, RED_CHEF_Y + 5);
        
        bg.setFont(new Font("Consolas", false, false, 24));
        bg.drawString("Money", RED_CENTER_X - 70, RED_MONEY_Y - 20);
        
        bg.setFont(new Font("Consolas", true, false, 28));
        bg.drawString("$" + startMoneyRed, RED_CENTER_X - 40, RED_MONEY_Y + 5);
    }
    
    private void updateDisplay2() {
        
    }
    
    private void chooseChefs() {
        // Get the background image
        setBackground(new GreenfootImage(background));
        GreenfootImage bg = getBackground();
        
        bg.setColor(new Color(99, 66, 66));
        
        // Draw title
        bg.setFont(new Font("Consolas", true, false, 64));
        bg.drawString("CHOOSE CHEFS", 280, 200);
        bg.setFont(new Font("Consolas", true, false, 24));
        
        // BLUE RESTAURANT (LEFT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(50, 100, 200)); 
        bg.drawString("BLUE", BLUE_CENTER_X - 35, 240);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", true, false, 20));
        
        bg.drawString("Master", BLUE_CENTER_X - 78, BLUE_CHEF_Y - 45);
        addObject(masterBlue, BLUE_CENTER_X - 50, BLUE_CHEF_Y - 10);
        bg.drawString("Cohen", BLUE_CENTER_X + 22, BLUE_CHEF_Y - 45);
        addObject(cohenBlue, BLUE_CENTER_X + 50, BLUE_CHEF_Y - 10);
        bg.drawString("Hungry", BLUE_CENTER_X - 78, BLUE_CHEF_Y + 45);
        addObject(hungryBlue, BLUE_CENTER_X - 50, BLUE_CHEF_Y + 80);
        bg.drawString("Lazy", BLUE_CENTER_X + 22, BLUE_CHEF_Y + 45);
        addObject(lazyBlue, BLUE_CENTER_X + 50, BLUE_CHEF_Y + 80);
        
        bg.drawString("Selection: ", BLUE_CENTER_X - 80, 470);
        
        // RED RESTAURANT (RIGHT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(200, 50, 50)); 
        bg.drawString("RED", RED_CENTER_X - 35, 240);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", true, false, 20));
        
        bg.drawString("Master", RED_CENTER_X - 78, RED_CHEF_Y - 45);
        addObject(masterRed, RED_CENTER_X - 50, RED_CHEF_Y - 10);
        bg.drawString("Cohen", RED_CENTER_X + 22, RED_CHEF_Y - 45);
        addObject(cohenRed, RED_CENTER_X + 50, RED_CHEF_Y - 10);
        bg.drawString("Hungry", RED_CENTER_X - 78, RED_CHEF_Y + 45);
        addObject(hungryRed, RED_CENTER_X - 50, RED_CHEF_Y + 80);
        bg.drawString("Lazy", RED_CENTER_X + 22, RED_CHEF_Y + 45);
        addObject(lazyRed, RED_CENTER_X + 50, RED_CHEF_Y + 80);
        
        bg.drawString("Selection: ", RED_CENTER_X - 80, 470);;
        
        addObject(playBtn, 480, 520);
    }
    
    private void startGame()
    {
        restaurantBlue = new Restaurant(numChefsBlue, startMoneyBlue, "Blue", 0);
        restaurantRed = new Restaurant(numChefsRed, startMoneyRed, "Red", getWidth()/2);
        
        Greenfoot.setWorld(new RestaurantWorld());
    }
    
    public static int getStartMoneyBlue() {
        return startMoneyBlue;
    }
    
    public static int getStartMoneyRed() {
        return startMoneyRed;
    }
    
    public static int getNumBlueChefs() {
        return numChefsBlue;
    }
    
    public static int getNumRedChefs() {
        return numChefsRed;
    }
}
