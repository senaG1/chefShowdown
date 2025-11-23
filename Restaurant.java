import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * The Restaurant class is responsible for managing the UI and for taking information from Chef and Customer
 * <li> tracks how much cash the restaurant has</li>
 * <li> pays the Chefs</li>
 * <li> takes Customers' ratings and cash</li>
 * <li> updates UI with cash and rating</li>
 * 
 * @author Jiayu Chen, Cayden Chan
 * @version November 2025
 */
public class Restaurant extends SuperSmoothMover
{
    private RestaurantWorld rw;
    private TeamUI teamUI;
    
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
    
    private int actCount;
    
    /**
     * Sets up the UI display, and draws the image for the restaurant.
     * 
     * @param numChefs  the number of chefs selected in SettingsWorld
     * @param cash  starting cash selected in SettingsWorld
     * @param team  which side the restaurant is (blue or red)
     * @param xLoaction the location of the restaurant based on the side
     */
    public Restaurant(ArrayList<Integer> numChefs, int cash, String team, int xLocation) {
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
        teamUI = new TeamUI(rw, teamBannerX, labelHeight, labelSize, team, currentCash); 
    }
    
    public void act() {
        actCount++;
        if(actCount >= 600){
            actCount = 0;
            chefs = new ArrayList(getWorld().getObjects(Chef.class));
            for(Chef c : chefs){//each restaurant will only pay its own chefs
                if((c.onTeamBlue() && team.equals("Blue")) || (!c.onTeamBlue() && team.equals("Red"))){
                    payChef(c);
                }
            }
        }
    }
    
    private void payChef(Chef c){
        collectCash(-c.getSalary());
        if(currentCash == 0){
            c.quit();
        }
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
    
    /**
     * Updates the amount of cash the restaurant has
     * 
     * @param amount    the increase/decrease in cash
     */
    public void collectCash(int amount) {
        currentCash += amount;
        teamUI.updateCash(currentCash);
    }
    
    /**
     * takes a customer's rating and updates the UI with the new average
     * 
     * @param rating    the Customer's rating out of five
     */
    public void recordRating(int rating) {
        // numReviews++;
        System.out.println("num reviews: " + numReviews);
        totalRating += rating;
        double averageRating = totalRating / numReviews;
        double roundedRating = roundNearestRating(averageRating);
        finalRating = roundedRating;
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
    
    public int addNumReviews(int reviewCount) {
        numReviews += reviewCount;
        return numReviews;
    }
    
    /**
     * returns all chefs currently in the world
     */
    public ArrayList<Chef> getChefs() {
        return chefs;
    }
    
    /**
     * returns x position of customer spawn point
     */
    public int getCustSpawnX() {
        return this.custSpawnX;
    }
    
    /**
     * returns y position of customer spawn point
     */
    public int getCustSpawnY() {
        return this.custSpawnY;
    }
    
    /**
     * returns x position of the start of the Customer line
     */
    public int getCustLineX() {
        return this.custLineX;
    }
    
    /**
     * returns y position of the start of the Customer line
     */
    public int getCustLineY() {
        return this.custLineY;
    }
    
    /**
     * returns which team the restaurant is (Blue/Red)
     */
    public String getTeam() {
        return team;
    }
    /**
     * returns how much cash the restaurant currently has
     */
    public int getCash() {
        return currentCash;
    }
    /**
     * returns the restaurant's current average rating
     */
    public double getRating() {
        return finalRating;
    }
}
