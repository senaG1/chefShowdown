import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class TeamUI here.
 * 
 * @author Jiayu Chen
 * @version 11-13
 */
public class TeamUI extends SuperSmoothMover {
    private Label cashLabel;
    private Label cashCounter;
    private Label ratingLabel;
    private UI_Image cashIcon;
    private UI_Image starIcon;
    
    private int profit;
    
    private Stars stars;
    private int numReviews = 0;
    
    private static ArrayList<Stars> teamRating = new ArrayList<>();
    
    private static int maxRating = 5;
    private int cash;
    private int rating = 0;
    
    private GreenfootImage starImage;

    public TeamUI(World world, int xOffset, int labelHeight, int labelSize, String teamColor) {
        cashLabel = new Label("CASH: ", labelSize);
        cashCounter = new Label(cash, labelSize);
        ratingLabel = new Label("RATING: ", labelSize);

        GreenfootImage cashImage = new GreenfootImage("cash.png");
        cashIcon = new UI_Image(cashImage);

        starImage = new GreenfootImage("star_rating/stars11.png");
        starImage.scale(190, 40);
        starIcon = new UI_Image(starImage);

        // Positioning
        world.addObject(cashLabel, xOffset, labelHeight);
        world.addObject(cashCounter, xOffset + 60, labelHeight);
        world.addObject(cashIcon, xOffset + 110, labelHeight);
        world.addObject(ratingLabel, xOffset - 280, labelHeight);
        world.addObject(starIcon, xOffset - 140, labelHeight - 5);
    }

    public void updateCash(int newCash) {
        cash += newCash;
        cashCounter.setValue(cash); // This updates the label
    }

    public void updateRating(int newRating) {
        numReviews++;
        rating = (rating + newRating) / numReviews;
        starImage = new GreenfootImage("star_rating/stars" + rating + ".png");
        starIcon = new UI_Image(starImage);
    }

    public int getCash() {
        return cash;
    }

    public double getRating() {
        return rating;
    }
}
