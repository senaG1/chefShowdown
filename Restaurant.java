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
    private String name;
    private double money;
    private double rating;
    private ArrayList<Chef> chefs;
    private ArrayList<Customer> customers;
    private ArrayList<String> orderItems;
    
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
    
    public void addItemsToOrder(String[] items) {
        for(String item: items) {
            orderItems.add(item);
        }
    }
    
    public String getName() {
        return name;
    }
}
