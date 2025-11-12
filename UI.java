import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * User Interface that shows the viewers the current ratings of each restaurant
 * and how much cash they have.
 * 
 * The rating counter will show a double from 1-5 accompanied with star icons.
 * 
 * The cash counter will update the amount of cash each team has.
 * 
 * @author Jiayu Chen
 * @version 2.2.0
 * - added star images to UI
 */
public class UI extends SuperSmoothMover
{
    private static int labelHeight = 38;
    private static int labelSize = 25;
    private GreenfootImage ui = new GreenfootImage("UI.png");
    
    private TeamUI teamRed;
    private TeamUI teamBlue;
    
    private static int maxRating = 5;
    
    private static ArrayList<Stars> teamRating = new ArrayList<>();
    
    // initially each restaurant starts with $1000 to hire chefs and price their menus etc.
    public int cashCounter = 1000;
    
    // initially each restaurant has a rating of 0 because they just opened.
    public double starRating = 0;
    
    /**
     * 
     * @param world 
     * 
     */
    public UI(World world) {
        setImage(ui);
        world.addObject(this, 960, 40);
        
        teamRed = new TeamUI(world, 340, labelHeight, labelSize, "red");
        teamBlue = new TeamUI(world, 810, labelHeight, labelSize, "blue");
    }
    
    public void act() {
        teamRed.updateCash(teamRed.getCash());
        teamBlue.updateCash(teamBlue.getCash());
        
        teamRed.updateRating(teamBlue.getRating());
        teamBlue.updateRating(teamBlue.getRating());
    }
}
