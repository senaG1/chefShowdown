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
    private int currentCash;
    private double finalRating;
    
    public TeamUI teamBlueUI;
    public TeamUI teamRedUI;
    
    private static int labelHeight = 30;
    private static int labelSize = 25;
    private int uiOffset = 340;
    
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    
    public Restaurant(String team, int xLocation) {
        this.team = team;
        
        drawImage();
    }
    
    public void addedToWorld(World w){
        rw = (RestaurantWorld) w;
        teamBlueUI = new TeamUI(rw, 340, labelHeight, labelSize, team);
        teamRedUI = new TeamUI(rw, 810, labelHeight, labelSize, team);
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
    
    private void addUI(String team) {
        if (team.equals("Blue")) {
            
        } else {
            
        }
    }
    
    private void drawImage() {
        int worldWidth = 960;
        int worldHeight = 640;
    
        GreenfootImage img = new GreenfootImage(worldWidth / 2, worldHeight);
    
        img.setColor(new Color(0, 0, 0, 0));
        img.fill();
    
        setImage(img);
    }
    
    public String getTeam() {
        return team;
    }
    
    public double getFinalRating() {
        return finalRating;
    }
}
