import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * User Interface that shows the viewers the current ratings of each restaurant
 * and how much cash they have.
 * 
 * The rating counter will show a double from 1-5 accompanied with star icons.
 * 
 * The cash counter will update the amount of cash each team has.
 * 
 * @author Jiayu Chen
 * @version 11-6
 */
public class UI extends SuperSmoothMover
{
    private static int labelHeight = 38;
    private static int labelSize = 25;
    private GreenfootImage ui = new GreenfootImage("UI.png");
    
    private Label cashLabelA;
    private Label ratingLabelA;
    private Label cashLabelB;
    private Label ratingLabelB;
    
    private UI_Image cashIconA;
    private UI_Image cashIconB;
    
    // initially each restaurant starts with $1000 to hire chefs and price their menus etc.
    public int cashCounter = 1000;
    
    // initially each restaurant has a rating of 0 because they just opened.
    public double starRating = 0;
    
    public UI(World world) {
        setImage(ui);
        world.addObject(this, 960, 40);
        
        GreenfootImage cashImage = new GreenfootImage("cash.png");
        cashIconA = new UI_Image(cashImage);
        cashIconB = new UI_Image(cashImage);
        
        // labels for the UI
        cashLabelA = new Label("CASH: ", labelSize);
        ratingLabelA = new Label("RATING: ", labelSize);
        cashLabelB = new Label("CASH: ", labelSize);
        ratingLabelB = new Label("RATING: ", labelSize);
        
        // add labels and images to UI
        addImages(world);
    }
    
    public void act() {
        // Add your action code here.
    }
    
    private void addImages(World w) {
        // blue team
        w.addObject(cashLabelA, 310, labelHeight);
        w.addObject(cashIconA, 450, labelHeight);
        w.addObject(ratingLabelA, 60, labelHeight);
        
        // red team
        w.addObject(cashLabelB, 780, labelHeight);
        w.addObject(cashIconB, 920, labelHeight);
        w.addObject(ratingLabelB, 530, labelHeight);
    }
}
