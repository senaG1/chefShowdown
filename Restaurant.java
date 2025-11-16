import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Restaurant here.
 * 
 * @author Jiayu Chen
 * @version 11-15 1.1
 */
public class Restaurant extends SuperSmoothMover
{
    private RestaurantWorld rw;
    public TeamUI teamUI;
    
    private String team;
    private int numChefs;
    private int currentCash;
    private double finalRating;
    
    private static int labelHeight = 30;
    private static int labelSize = 25;
    private int uiOffset = 340;
    
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    
    private int custSpawnX;
    private int custSpawnY;
    private int custLineX;
    private int custLineY;
    private int teamBannerX;
    
    private int numReviews = 0;
    private int totalRating;
    
    public Restaurant(int chefs, int cash, String team, int xLocation) {
        numChefs = chefs;
        currentCash = cash;
        
        this.team = team;
        
        if (team.equals("Red")) {
            custLineX = 909;
            custLineY = 512;
            custSpawnX = 909;
            custSpawnY = 628;
            teamBannerX = 810;
        } else {
            custLineX = 62;
            custLineY = 512;
            custSpawnX = 51;
            custSpawnY = 628;
            teamBannerX = 340;
        }
        
        drawImage();
    }
    
    public void addedToWorld(World w) {
        rw = (RestaurantWorld) w;
        teamUI = new TeamUI(rw, teamBannerX, labelHeight, labelSize, team, SettingsWorld.getStartMoneyRed()); 
    }
    
    public void act() {
    
    }
    
    private void hireChef(Chef chef) {
        // based on setting world, spawns specified chef at its respective points
    }
    
    private void spawnCustomer() {
        // spawns random customer at it's specific lane
    }
    
    private void purchaseEffect() {
        // check how much cash it has
        // decide which effect it wants to buy
        // "buff" --> Influencer
        // "sabatoge" --> rat infestation/power outage (power outage can just be a random occurance though)
    }
    
    public void collectCash(int amount) {
        currentCash += amount;
        teamUI.updateCash(currentCash);
    }
    
    public void recordRating(int rating) {
        numReviews++;
        totalRating += rating;
        double averageRating = totalRating / numReviews;
        double roundedRating = roundNearestRating(averageRating);
        teamUI.updateRating(roundedRating);
    }

    private double roundNearestRating(double rating) {
        int integerRating = (int) rating;
        double decimalRating = rating - integerRating;
        if (decimalRating < 0.25) {
            decimalRating = 0.0;
        } else if (decimalRating >= 0.75) {
            decimalRating = 1.0;
        } else {
            decimalRating = 0.5;
        }
        return integerRating + decimalRating;
    }
    
    private void drawImage() {
        int worldWidth = 960;
        int worldHeight = 640;
    
        GreenfootImage img = new GreenfootImage(worldWidth / 2, worldHeight);
    
        img.setColor(new Color(0, 0, 0, 0));
        img.fill();
    
        setImage(img);
    }
    
    public int getCustSpawnX() {
        return this.custSpawnX;
    }
    
    public int getCustSpawnY() {
        return this.custSpawnY;
    }
    
    public int getCustLineX() {
        return this.custLineX;
    }
    
    public int getCustLineY() {
        return this.custLineY;
    }
    
    public String getTeam() {
        return team;
    }
    
    public int getCash() {
        return currentCash;
    }
    
    public double getRating() {
        return finalRating;
    }
    
    public double getFinalRating() {
        return finalRating;
    }
}
