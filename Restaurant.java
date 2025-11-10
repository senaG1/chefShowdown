import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Restaurant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restaurant extends SuperSmoothMover
{
    protected String name;
    protected double money;
    protected double rating;
    protected ArrayList<Chef> chefs;
    protected ArrayList<Customer> customers;
    
    public Restaurant(String name, double money) {
        this.name = name;
        this.money = money;
        
        drawImage();
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    protected void hireChef(Chef chef) {
        
    }
    
    protected void upgrade() {
        
    }
    
    protected void levelUp() {
        
    }
    
    protected void earnMoney(double amount) {
        money += amount;
    }
    
    protected void loseMoney(double amount) {
        money -= amount;
    }
    
    private void drawImage() {
        int worldWidth = 960;
        int worldHeight = 640;
    
        GreenfootImage img = new GreenfootImage(worldWidth / 2, worldHeight);
    
        img.setColor(new Color(0, 0, 0, 0));
        img.fill();
    
        setImage(img);
    }
    
    public String getName() {
        return name;
    }
}
