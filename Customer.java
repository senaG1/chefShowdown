import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer extends SuperSmoothMover
{
    private int timeSpent;
    /**
     * Act - do whatever the Customer wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        
    }
    
    public Customer()
    {
        timeSpent = 0;
    }
    
    public void lineUp()
    {
        ArrayList<Customer> totalCustomers = (ArrayList<Customer>)getWorld().getObjects(Customer.class);
        
    }
}
