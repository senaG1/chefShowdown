import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TeamUI here.
 * 
 * @author Jiayu Chen
 * @version 11-10
 */
public class TeamUI extends SuperSmoothMover {
    private Label cashLabel;
    private Label cashCounter;
    private Label ratingLabel;
    private UI_Image cashIcon;
    private UI_Image starIcon;
    
    private int profit;
    
    private Stars stars;
    private int numReviews;

    private int cash;
    private int rating;

    public TeamUI(World world, int xOffset, int labelHeight, int labelSize, String teamColor) {
        cash = 1000;
        rating = 0;

        cashLabel = new Label("CASH: ", labelSize);
        cashCounter = new Label(cash, labelSize);
        ratingLabel = new Label("RATING: ", labelSize);

        GreenfootImage cashImage = new GreenfootImage("cash.png");
        cashIcon = new UI_Image(cashImage);

        GreenfootImage starImage = new GreenfootImage("star_rating/stars11.png");
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
        cash = newCash;
        cashCounter.setValue(cash); // This updates the label
    }

    public void updateRating(double newRating) {
        numReviews++;
        rating = (int) (rating + newRating) / numReviews;
        GreenfootImage img = new GreenfootImage("star_rating/stars" + rating + ".png");
    }

    public int getCash() {
        return cash;
    }

    public double getRating() {
        return rating;
    }
}
