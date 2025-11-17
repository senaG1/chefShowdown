import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * The TeamUI class updates the cash and rating data for each respective team.
 * 
 * @author Jiayu Chen
 * @version Nov 17th, 2025
 */
public class TeamUI extends SuperSmoothMover {
    private Label cashLabel;
    private Label cashCounter;
    private Label ratingLabel;
    private UI_Image cashIcon;
    private UI_Image starIcon;
    
    private int profit;
    private int salary;
    private int numReviews = 0;
    
    private static double maxRating = 5.0;
    private int startingCash;
    private double rating;
    
    private GreenfootImage starImage = new GreenfootImage("star_rating/stars11.png");
    
    /**
     * Constructor for the TeamUI class.
     * Initializes the UI with a reference to the world, location and team.
     * 
     * @param world         The world it gets added to.
     * @param xOffset       The x location of the label.
     * @param labelHeight   The y location from the top of the world.
     * @param labelSize     The size of the label.
     * @param team          The team assigned to the UI.
     * @param startingCash  The starting cash for each team.
     */
    public TeamUI(World world, int xOffset, int labelHeight, int labelSize, String team, int startingCash) {
        cashLabel = new Label("CASH: ", labelSize);
        cashCounter = new Label(startingCash, labelSize);
        ratingLabel = new Label("RATING: ", labelSize);

        GreenfootImage cashImage = new GreenfootImage("cash.png");
        cashIcon = new UI_Image(cashImage);

        starImage.scale(190, 40);
        starIcon = new UI_Image(starImage);

        // Positioning
        world.addObject(cashLabel, xOffset, labelHeight);
        world.addObject(cashCounter, xOffset + 60, labelHeight);
        world.addObject(cashIcon, xOffset + 110, labelHeight);
        world.addObject(ratingLabel, xOffset - 280, labelHeight);
        world.addObject(starIcon, xOffset - 140, labelHeight - 5);
    }
    
    /**
     * Updates the cash label each time Restaurant collects or spends cash.
     * 
     * @param newCash   Takes the current cash value from each restaurant.
     */
    public void updateCash(int newCash) {
        cashCounter.setValue(newCash); // This updates the label
    }
    
    /**
     * Updates the rating images each time the Restaurant recieves a new rating.
     * 
     * @param roundedRating     Takes the rounded rating from the restaurant to
     *                          set the closest represented image of the actual average rating.
     */
    public void updateRating(double roundedRating) {
        starImage = new GreenfootImage("star_rating/stars" + roundedRating + ".png");
        starImage.scale(190, 40);
        starIcon.setImage(starImage);
    }
}
