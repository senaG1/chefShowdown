import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author Grace Tao
 * @version (a version number or a date)
 */
public class SettingsWorld extends World
{
    // Blue restaurant settings
    private static int numChefsBlue = 1;
    private static int startMoneyBlue = 1000;
    
    // Red restaurant settings
    private static int numChefsRed = 1;
    private static int startMoneyRed = 1000;
    
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
    
    private Restaurant restaurantBlue;
    private Restaurant restaurantRed;
    
    private final int MIN_CHEFS = 1;
    private final int MAX_CHEFS = 5;
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
        addObject(chefMinusBlue, BLUE_CENTER_X - 40, BLUE_CHEF_Y);
        addObject(chefPlusBlue, BLUE_CENTER_X + 40, BLUE_CHEF_Y);
        
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
        addObject(chefMinusRed, RED_CENTER_X - 40, RED_CHEF_Y);
        addObject(chefPlusRed, RED_CENTER_X + 40, RED_CHEF_Y);
        
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
        
        playBtn = new Button("play_1.png", "play_2.png");
        playBtn.scale(2);
        //addObject(playBtn, 480, 500);
        
        updateDisplay();
    }
    
    public void act() {
        checkButtons();
    }
    
    private void checkButtons()
    {
        if (chefMinusBlue.isClicked() && numChefsBlue > MIN_CHEFS)
        {
            numChefsBlue--;
            updateDisplay();
        }
        if (chefPlusBlue.isClicked() && numChefsBlue < MAX_CHEFS)
        {
            numChefsBlue++;
            updateDisplay();
        }
        
        if (moneyMinusBlue.isClicked() && startMoneyBlue > MIN_MONEY)
        {
            startMoneyBlue -= MONEY_INCREMENT;
            updateDisplay();
        }
        if (moneyPlusBlue.isClicked() && startMoneyBlue < MAX_MONEY)
        {
            startMoneyBlue += MONEY_INCREMENT;
            updateDisplay();
        }
        
        if (chefMinusRed.isClicked() && numChefsRed > MIN_CHEFS)
        {
            numChefsRed--;
            updateDisplay();
        }
        if (chefPlusRed.isClicked() && numChefsRed < MAX_CHEFS)
        {
            numChefsRed++;
            updateDisplay();
        }
        
        if (moneyMinusRed.isClicked() && startMoneyRed > MIN_MONEY)
        {
            startMoneyRed -= MONEY_INCREMENT;
            updateDisplay();
        }
        if (moneyPlusRed.isClicked() && startMoneyRed < MAX_MONEY)
        {
            startMoneyRed += MONEY_INCREMENT;
            updateDisplay();
        }
        
        if(nextBtn.isClicked()) {
            List objects = getObjects(null); 
            removeObjects(objects);  
            setBackground(new GreenfootImage(background));
            chooseChefs();
        }
        
        if (playBtn.isClicked())
        {
            startGame();
        }
    }
    
    private void updateDisplay() {
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
        bg.drawString(String.valueOf(numChefsBlue), BLUE_CENTER_X - 5, BLUE_CHEF_Y + 5);
        
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
        bg.drawString(String.valueOf(numChefsRed), RED_CENTER_X - 5, RED_CHEF_Y + 5);
        
        bg.setFont(new Font("Consolas", false, false, 24));
        bg.drawString("Money", RED_CENTER_X - 70, RED_MONEY_Y - 20);
        
        bg.setFont(new Font("Consolas", true, false, 28));
        bg.drawString("$" + startMoneyRed, RED_CENTER_X - 40, RED_MONEY_Y + 5);
    }
    
    private void chooseChefs() {
        // Get the background image
        setBackground(new GreenfootImage(background));
        GreenfootImage bg = getBackground();
        
        bg.setColor(new Color(99, 66, 66));
        
        // Draw title
        bg.setFont(new Font("Consolas", true, false, 64));
        bg.drawString("CHOOSE CHEFS", 285, 200);
        
        // BLUE RESTAURANT (LEFT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(50, 100, 200)); 
        bg.drawString("BLUE", BLUE_CENTER_X - 50, 250);
        
        masterBlue = new Button("masterBtn_1.png", "masterBtn_2.png");
        masterBlue.scale(3/2);
        addObject(masterBlue, BLUE_CENTER_X - 40, BLUE_CHEF_Y);
        
        cohenBlue = new Button("cohenBtn_1.png", "cohenBtn_2.png");
        cohenBlue.scale(3/2);
        addObject(cohenBlue, BLUE_CENTER_X + 40, BLUE_CHEF_Y);
        
        // RED RESTAURANT (RIGHT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(200, 50, 50)); 
        bg.drawString("RED", RED_CENTER_X - 40, 250);
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
