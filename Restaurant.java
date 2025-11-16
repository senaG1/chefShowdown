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
    
    private String team;
    private int numChefs;
    private int currentCash;
    private double finalRating;
    
    public TeamUI teamBlueUI;
    public TeamUI teamRedUI;
    
    private static int labelHeight = 30;
    private static int labelSize = 25;
    private int uiOffset = 340;
    
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    
    private int custSpawnX;
    private int custSpawnY;
    private int custLineX;
    private int custLineY;
    
    public Restaurant(int chefs, int cash, String team, int xLocation) {
        numChefs = chefs;
        currentCash = cash;
        
        this.team = team;
        
        if (team.equals("Red")) {
            custLineX = 909;
            custLineY = 512;
            custSpawnX = 909;
            custSpawnY = 628;
        } else {
            custLineX = 62;
            custLineY = 512;
            custSpawnX = 51;
            custSpawnY = 628;
        }
        
        drawImage();
    }
    
    public void addedToWorld(World w){
        rw = (RestaurantWorld) w;
        teamBlueUI = new TeamUI(rw, 340, labelHeight, labelSize, team, currentCash);
        teamRedUI = new TeamUI(rw, 810, labelHeight, labelSize, team, currentCash);
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
    
    public void updateCash() {
        
    }
    
    private void addUI(String team) {
        if (team.equals("Blue")) {
            
        } else {
            
        }
    }
    
    public void collectCash(int amount) {
        this.currentCash += amount;
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
    
    public double getFinalRating() {
        return finalRating;
    }
}
