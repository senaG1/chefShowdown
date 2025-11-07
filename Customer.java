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
    private static int nextCustomerIndex = 0;
    private int customerIndex;
    private static final int LINE_X = 62;
    private static final int LINE_START_Y = 512;
    private static final int SPACING = 30;
    private static final double MOVE_SPEED = 2.0;
    private boolean inLine;
    private GreenfootImage image;
    
    public Customer()
    {
        image = new GreenfootImage("regular_Cust.png");
        image.scale(image.getWidth()*3, image.getHeight()*3);
        setImage(image);
        customerIndex = nextCustomerIndex;
        nextCustomerIndex++;
        inLine = true;
    }
    
    public void act()
    {
        lineUp();
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
        }
    }
    
    public boolean isInLine()
    {
        return inLine;    
    }
    
    
}
