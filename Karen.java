import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Write a description of class Karen here.
 * 
 * @author Isabel Powell
 * @version (a version number or a date)
 */
public class Karen extends Customer
{
    private GreenfootImage image;
    private int diameter = 50; //Size of circle
    private boolean complained;
    private int decreaseRate = 1; //Drains patence by 1
    
    public Karen(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("Karen_00.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    
    public void addedToWorld() {
        
    }
    
    /**
     * Act - do whatever the Karen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        super.act();
        
        if(orderTaken && !orderRecieved && !givingUp){
            complain();
        }
    }
    //Decreases the patience of other customers --> decreases the rating of the restaurant
    private void complain(){
        ArrayList<Customer> closeCustomers = (ArrayList<Customer>)getObjectsInRange(diameter/2, Customer.class);
        
        for(Customer cust : closeCustomers){
            //System.out.println("I am in range" + cust.getX());
            if(cust != this && cust.orderTaken){
                cust.currentPatience -= decreaseRate;
                //System.out.println("I am decreasing" + currentPatience);
            }
            
            if(cust.currentPatience < 0){
                cust.currentPatience = 0;
            }
        }
    }
    
    
}
