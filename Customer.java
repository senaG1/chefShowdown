import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Customer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Customer extends SuperSmoothMover
{
    private GreenfootImage image;
    private static int nextCustomerIndex = 0;
    protected int customerIndex;
    private static final int LINE_X = 62;
    private static final int LINE_START_Y = 512;
    private static final int SPACING = 30;
    private static final double MOVE_SPEED = 3.0;
    protected boolean inLine;    
    private boolean hasWaitingSpot;
    private int waitingX;
    private int waitingY;
    protected int actTimer;
    protected SuperStatBar patience;
    protected int maxPatience = 2100; // 35 secs before patience runs out
    protected int currentPatience = 2100;
    protected Restaurant restaurant;
    
    public Customer()
    {
        image = new GreenfootImage("regular_Cust.png");
        setImage(image);
        customerIndex = nextCustomerIndex;
        nextCustomerIndex++;
        inLine = true;
        actTimer = 240;
        //restaurant = (Restaurant) getOneIntersectingObject(Restaurant.class);
    }
    
    public void addedToWorld(World world)
    {
        patience = new SuperStatBar(maxPatience, currentPatience, this, 40, 8, -22, Color.BLUE, Color.RED);
        world.addObject(patience, getX(), getY());
    }
    
    public void act()
    {
        actTimer--;
        currentPatience--;
        patience.update(currentPatience);
        if(actTimer == 0)
        {
            inLine = false;
            actTimer = 240;
        }
        if(isInLine())
        {
            lineUp();
        }
        else
        {
            waitOrder();
        }
        
        if(currentPatience == 0)
        {
            getWorld().removeObject(this);
        }
    }
    
    // Sends customers in line to wait at the waiting space
    // Currently needs implementation after method for taking customer's orders is made
    public void waitOrder()
    {
        int currentX = getX();
        int currentY = getY();
        if(!hasWaitingSpot)
        {
            int attempts = 0;
            boolean spotFound = false;
            // Ensures that customers don't wait at a spot where there is already a customer waiting
            while(!spotFound && attempts < 50)  
                {
                int testX = Greenfoot.getRandomNumber(78 - 11 + 1) + 11;
                int testY = Greenfoot.getRandomNumber(426 - 212 + 1) + 212;
                
                boolean occupied = false;
                ArrayList<Customer> customers = (ArrayList<Customer>) getWorld().getObjects(Customer.class);
            
                for(Customer c : customers)
                {
                    if(c != this && !c.isInLine())
                    {
                        double dist = Math.sqrt(Math.pow(c.getX() - testX, 2) + Math.pow(c.getY() - testY, 2));
                        if(dist < 40)
                        {
                            occupied = true;
                            break;
                        }
                    }
                }
                
                if(!occupied)
                {
                    waitingX = testX;
                    waitingY = testY;
                    hasWaitingSpot = true;
                    spotFound = true;
                }
                
                attempts++;
            }
            
            // If no spot found after 50 attempts, just pick a random one anyway
            if(spotFound == false)
            {
                waitingX = Greenfoot.getRandomNumber(78 - 11 + 1) + 11;
                waitingY = Greenfoot.getRandomNumber(426 - 212 + 1) + 212;
                hasWaitingSpot = true;
            }
        }
        
        // Move towards the waiting spot
        double dx = waitingX - currentX;
        double dy = waitingY - currentY;
        double distance = Math.sqrt(dx * dx + dy * dy);
        
        if (distance > MOVE_SPEED)
        {
            double moveX = (dx / distance) * MOVE_SPEED;
            double moveY = (dy / distance) * MOVE_SPEED;
            setLocation(currentX + (int)moveX, currentY + (int)moveY);
        }
        else if (distance > 0)
        {
            setLocation(waitingX, waitingY);
        }
    }
        
    
    // Has customers line up, max 5 customers at a time
    public void lineUp()
    {
        ArrayList<Customer> customers = (ArrayList<Customer>) getWorld().getObjects(Customer.class);
        
        int myPosition = 0;
        for(Customer c : customers)
        {
            if(c.isInLine())
            {
                if (c.customerIndex < this.customerIndex)
                {
                    myPosition++;
                }
            }
        }
        if(isInLine())
        {
            int currentX = getX();
            int currentY = getY();
            int targetX = LINE_X;
            int targetY = LINE_START_Y + myPosition * SPACING;
            double dx = targetX - currentX;
            double dy = targetY - currentY;
            double distance = Math.sqrt(dx * dx + dy * dy);
            if (distance > MOVE_SPEED)
            {
                double moveX = (dx / distance) * MOVE_SPEED;
                double moveY = (dy / distance) * MOVE_SPEED;
                setLocation(currentX + (int)moveX, currentY + (int)moveY);
            }
            else if (distance > 0)
            {
                setLocation(targetX, targetY);
            }
            
        }
        
    }
    
    public boolean isInLine()
    {
        return inLine;    
    }
    
}
