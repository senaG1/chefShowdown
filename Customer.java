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
    private int customerIndex;
    private static final int LINE_X = 62;
    private static final int LINE_START_Y = 512;
    private static final int SPACING = 30;
    private static final double MOVE_SPEED = 2.0;
    private boolean inLine;
    public Customer()
    {
        image = new GreenfootImage("regular_Cust.png");
        setImage(image);
        customerIndex = nextCustomerIndex;
        nextCustomerIndex++;
        inLine = true;
    }
    
    public void act()
    {
        lineUp();
        
    }
    
    public void waitOrder()
    {
        Random random = new Random();
        ArrayList<Customer> customers = (ArrayList<Customer>) getWorld().getObjects(Customer.class);
        for(Customer c : customers)
        {
            if(c.isInLine() == false)
            {
                int randY = random.nextInt(426 - 212 + 1) + 212;
                int randX = random.nextInt(78 - 11 + 1) + 11;
                setLocation(randX, randY);
            }
        }
    }
    
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
            this.inLine = false;
            waitOrder();
        }
    }
    
    public boolean isInLine()
    {
        return inLine;    
    }
    
    
}
