import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class SettingsWorld here.
 * 
 * @author Grace Tao
 * @version Nov 2025
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
    private Button plusMasterBlue;
    private Button minusMasterBlue;
    private Button plusCohenBlue;
    private Button minusCohenBlue;
    private Button plusHungryBlue;
    private Button minusHungryBlue;
    private Button plusLazyBlue;
    private Button minusLazyBlue;
    
    // Red chef buttons
    private Button plusMasterRed;
    private Button minusMasterRed;
    private Button plusCohenRed;
    private Button minusCohenRed;
    private Button plusHungryRed;
    private Button minusHungryRed;
    private Button plusLazyRed;
    private Button minusLazyRed;
    
    private Button nextBtn;
    private Button playBtn;
    
    private int numMasterRed;
    private int numCohenRed;
    private int numHungryRed;
    private int numLazyRed;
    
    private int numMasterBlue;
    private int numCohenBlue;
    private int numHungryBlue;
    private int numLazyBlue;
    
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
        plusMasterBlue = new Button("plus_1.png", "plus_2.png");
        plusMasterBlue.scale(2);
        
        plusCohenBlue = new Button("plus_1.png", "plus_2.png");
        plusCohenBlue.scale(2);
        
        plusHungryBlue = new Button("plus_1.png", "plus_2.png");
        plusHungryBlue.scale(2);
        
        plusLazyBlue = new Button("plus_1.png", "plus_2.png");
        plusLazyBlue.scale(2);
        
        minusMasterBlue = new Button("minus_1.png", "minus_2.png");
        minusMasterBlue.scale(2);
        
        minusCohenBlue = new Button("minus_1.png", "minus_2.png");
        minusCohenBlue.scale(2);
        
        minusHungryBlue = new Button("minus_1.png", "minus_2.png");
        minusHungryBlue.scale(2);
        
        minusLazyBlue = new Button("minus_1.png", "minus_2.png");
        minusLazyBlue.scale(2);
        
        // Red chef buttons
        plusMasterRed = new Button("plus_1.png", "plus_2.png");
        plusMasterRed.scale(2);
        
        plusCohenRed = new Button("plus_1.png", "plus_2.png");
        plusCohenRed.scale(2);
        
        plusHungryRed = new Button("plus_1.png", "plus_2.png");
        plusHungryRed.scale(2);
        
        plusLazyRed = new Button("plus_1.png", "plus_2.png");
        plusLazyRed.scale(2);
        
        minusMasterRed = new Button("minus_1.png", "minus_2.png");
        minusMasterRed.scale(2);
        
        minusCohenRed = new Button("minus_1.png", "minus_2.png");
        minusCohenRed.scale(2);
        
        minusHungryRed = new Button("minus_1.png", "minus_2.png");
        minusHungryRed.scale(2);
        
        minusLazyRed = new Button("minus_1.png", "minus_2.png");
        minusLazyRed.scale(2);
        
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
        
        if((numMasterRed + numCohenRed + numHungryRed + numLazyRed) < numChefsRed) {
            if(plusMasterRed.isClicked()) {
                numMasterRed++;
                updateDisplay2();
            }
            if(plusCohenRed.isClicked()) {
                numCohenRed++;
                updateDisplay2();
            }
            if(plusHungryRed.isClicked()) {
                numHungryRed++;
                updateDisplay2();
            }
            if(plusLazyRed.isClicked()) {
                numLazyRed++;
                updateDisplay2();
            }
            
            if(minusMasterRed.isClicked()) {
                numMasterRed--;
                updateDisplay2();
            }
            if(minusCohenRed.isClicked()) {
                numCohenRed--;
                updateDisplay2();
            }
            if(minusHungryRed.isClicked()) {
                numHungryRed--;
                updateDisplay2();
            }
            if(minusLazyRed.isClicked()) {
                numLazyRed--;
                updateDisplay2();
            }
        }
        
        if((numMasterBlue + numCohenBlue + numHungryBlue + numLazyBlue) < numChefsBlue) {
            if(plusMasterBlue.isClicked()) {
                numMasterBlue++;
                updateDisplay2();
            }
            if(plusCohenBlue.isClicked()) {
                numCohenBlue++;
                updateDisplay2();
            }
            if(plusHungryBlue.isClicked()) {
                numHungryBlue++;
                updateDisplay2();
            }
            if(plusLazyBlue.isClicked()) {
                numLazyBlue++;
                updateDisplay2();
            }
            
            if(minusMasterBlue.isClicked()) {
                numMasterBlue--;
                updateDisplay2();
            }
            if(minusCohenBlue.isClicked()) {
                numCohenBlue--;
                updateDisplay2();
            }
            if(minusHungryBlue.isClicked()) {
                numHungryBlue--;
                updateDisplay2();
            }
            if(minusLazyBlue.isClicked()) {
                numLazyBlue--;
                updateDisplay2();
            }
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
        bg.drawString("BLUE", BLUE_CENTER_X - 35, 260);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", true, false, 20));
        
        bg.drawString("Master", BLUE_CENTER_X - 68, BLUE_CHEF_Y - 15);
        addObject(minusMasterBlue, BLUE_CENTER_X - 88, BLUE_CHEF_Y + 15);
        addObject(plusMasterBlue, BLUE_CENTER_X - 8, BLUE_CHEF_Y + 15);
        bg.drawImage(new GreenfootImage("master_chef.png"), BLUE_CENTER_X - 98, BLUE_CHEF_Y - 45);
        
        bg.drawString("Cohen", BLUE_CENTER_X + 42, BLUE_CHEF_Y - 15);
        addObject(minusCohenBlue, BLUE_CENTER_X - 88, BLUE_CHEF_Y + 15);
        addObject(plusCohenBlue, BLUE_CENTER_X - 8, BLUE_CHEF_Y + 15);
        bg.drawImage(new GreenfootImage("master_chef.png"), BLUE_CENTER_X - 98, BLUE_CHEF_Y - 45);
        
        bg.drawString("Hungry", BLUE_CENTER_X - 98, BLUE_CHEF_Y + 85);
        bg.drawString("Lazy", BLUE_CENTER_X + 52, BLUE_CHEF_Y + 85);        
        
        
        // RED RESTAURANT (RIGHT SIDE)
        bg.setFont(new Font("Consolas", true, false, 32));
        bg.setColor(new Color(200, 50, 50)); 
        bg.drawString("RED", RED_CENTER_X - 35, 240);
        
        bg.setColor(new Color(99, 66, 66));
        bg.setFont(new Font("Consolas", true, false, 20));
        
        bg.drawString("Master", RED_CENTER_X - 98, RED_CHEF_Y - 45);
        bg.drawString("Cohen", RED_CENTER_X + 42, RED_CHEF_Y - 45);
        bg.drawString("Hungry", RED_CENTER_X - 98, RED_CHEF_Y + 45);
        bg.drawString("Lazy", RED_CENTER_X + 42, RED_CHEF_Y + 45);  
        
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
