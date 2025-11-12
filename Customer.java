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
    private World rw;
    private static int nextCustomerIndex = 0;
    protected int customerIndex;
    private static final int LINE_X = 62;
    private static final int LINE_START_Y = 512;
    private static final int SPACING = 30;
    private static final double MOVE_SPEED = 3.0;
    protected boolean inLine;    
    protected boolean hasWaitingSpot;
    protected int waitingX;
    protected int waitingY;
    protected int actTimer = 120; // 2 secs
    protected SuperStatBar patience;
    protected int maxPatience = 2100; // 35 secs before patience runs out
    protected int currentPatience = 2100;
    protected int rating;
    protected String[] menu = {"nuggets", "fries", "hash", "big cohen", "crispy", "filet", "mcflurry", "apple", "coffee", "smoothie"};
    protected int[] prices = {51, 36, 17, 105, 107, 76, 59, 22, 34, 45};
    protected String[] order;
    protected SuperSpeechBubble orderBubble;
    protected GreenfootImage orderImage;
    protected boolean givingUp = false;
    private boolean test = false;
    protected boolean orderTaken = false;
    protected boolean leavingStore = false;
    protected boolean waitingOrder = false;
    protected boolean orderRecieved = false;
    
    @Override
    public void addedToWorld(World w) {
        System.out.println("addedToWorld called");
        if (w instanceof RestaurantWorld) {
            rw = (RestaurantWorld) w;
            System.out.println("World assigned: " + rw);
            order = generateOrder();
        }
    }
    
    public Customer()
    {
        image = new GreenfootImage("regular_Cust.png");
        setImage(image);
        customerIndex = nextCustomerIndex;
        nextCustomerIndex++;
        inLine = true;
        actTimer = 240;
    }
   
    public void act()
    {
        if(getX() == 62 && getY() == 512)
        {
            actTimer--;
            if(actTimer == 0)
            {
                inLine = false;
            }
        }
        if(waitingOrder)
        {
            currentPatience--;
            if(orderRecieved)
            {
                leaveWithFood();
                return;
            }
            else
            {
                checkOrderRecieved();
            }
        }        
        if(leavingStore)
        {
            walkToExit();
            return; 
        }       
        if(isInLine())
        {
            lineUp();
        }
        else
        {
            if(!orderTaken)
            {   
                takeOrder();
                orderTaken = true;
            }
            else
            {
                waitOrder();
            }
        }  
        if(currentPatience <= 0 && !givingUp)
        {
            giveUp();
        }
        
        if(currentPatience == 0)
        {
            giveUp();
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
    
    // Has customer choose random items from menu
    // Can choose up to 3 items
    public String[] generateOrder()
    {
        int numOrder = Greenfoot.getRandomNumber(2)+1;
        ArrayList<String> availibleItems = new ArrayList<>();
        for(String item : menu)
        {   
            availibleItems.add(item);
        }
        order = new String[numOrder];
        
        ArrayList<GreenfootImage> itemImages = new ArrayList<>();
        
        for(int i = 0; i < numOrder; i++)
        {
            int randomIndex = Greenfoot.getRandomNumber(availibleItems.size());
            order[i] = availibleItems.remove(randomIndex);
            itemImages.add(getItemImage(order[i]));
            UI ui = new UI(this.getWorld());
            ui.addCashToTeam(0, prices[i]);
        }
        
        createCompositeOrderImage(itemImages);
        
        return order;
    }

    
    public void takeOrder()
    {
        patience = new SuperStatBar(maxPatience, currentPatience, this, 50, 8, -30, Color.BLUE, Color.RED);
        getWorld().addObject(patience, getX(), getY());
        orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
        getWorld().addObject(orderBubble, getX(), getY());
        waitOrder();
    }
    
    private void createCompositeOrderImage(ArrayList<GreenfootImage> images)
    {
        if(images.isEmpty()) return;
        
        int itemSize = 30; // Adjust size as needed
        int spacing = 5;
        int totalWidth = images.size() * (itemSize + spacing) - spacing;
        
        // Create a transparent canvas
        orderImage = new GreenfootImage(totalWidth, itemSize);
        orderImage.setColor(new Color(0, 0, 0, 0)); // Transparent
        orderImage.fill();
        
        // Draw each item image
        int xPos = 0;
        for(GreenfootImage img : images)
        {
            GreenfootImage scaledImg = new GreenfootImage(img);
            scaledImg.scale(itemSize, itemSize);
            orderImage.drawImage(scaledImg, xPos, 0);
            xPos += itemSize + spacing;
        }
    }
    
    private GreenfootImage getItemImage(String item)
    {
        GreenfootImage img = null;
        
        if(item.equals("nuggets"))
        {
            img = new GreenfootImage("nuggets.png");
        }
        else if(item.equals("fries"))
        {
            img = new GreenfootImage("fries.png");
        }
        else if(item.equals("hash"))
        {
            img = new GreenfootImage("hash.png");
        }
        else if(item.equals("big cohen"))
        {
            img = new GreenfootImage("burger.png");
        }
        else if(item.equals("crispy"))
        {
            img = new GreenfootImage("crispy.png");
        }
        else if(item.equals("filet"))
        {
            img = new GreenfootImage("filet.png");
        }
        else if(item.equals("apple"))
        {
            img = new GreenfootImage("apple.png");
        }
        else if(item.equals("mcflurry"))
        {
            img = new GreenfootImage("mcflurry.png");
        }
        else if(item.equals("coffee"))
        {
            img = new GreenfootImage("coffee.png");
        }
        else if(item.equals("smoothie"))
        {
            img = new GreenfootImage("smoothie.png");
        }
        
        return img;
    }
    
    // Sends customers in line to wait at the waiting space
    // Currently needs implementation after method for taking customer's orders is made
    public void waitOrder()
    {
        waitingOrder = true;
        if(patience != null)
        {
            patience.update(currentPatience);
        }
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

    
    public void leaveWithFood()
    {
        orderImage = new GreenfootImage("happy.png");
        orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
        getWorld().addObject(orderBubble, getX(), getY());
        walkToExit();
        if(currentPatience >= 29)
        {
            rating = 5;
        }
        else if(currentPatience < 29 && currentPatience >= 23)
        {
            rating = 4;
        }
        else if(currentPatience < 23 && currentPatience >= 17)
        {
            rating = 3;
        }
        else if(currentPatience < 17 && currentPatience >= 11)
        {
            rating = 2;
        }
        else if(currentPatience < 11 && currentPatience >= 5)
        {
            rating = 1;
        }
        else
        {
            rating = 0;
        }
    }
    
    public void checkOrderRecieved()
    {
        
    }
    
    // If patience runs out or an effect is caused, removes from world
    public void giveUp()
    {
        if (!givingUp)
        {
            waitingOrder = false;
            givingUp = true;
            leavingStore = true;  
            orderImage = new GreenfootImage("angry.png");
            
            if (orderBubble != null && orderBubble.getWorld() != null)
            {
                getWorld().removeObject(orderBubble);
            }
            
            // Remove patience bar
            if (patience != null && patience.getWorld() != null)
            {
                getWorld().removeObject(patience);
            }
            
            // Show angry bubble briefly
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
            getWorld().addObject(orderBubble, getX(), getY());
            
            inLine = false;
            hasWaitingSpot = false;
        }
    }
        
    private void walkToExit()
    {
        int currentY = getY();
        int worldHeight = getWorld().getHeight();
    
        if (currentY < worldHeight - 5)
        {
            setLocation(getX(), currentY + (int)MOVE_SPEED * 1.15);
        }
        else
        {
            // Remove bubble when exiting
            if (orderBubble != null && orderBubble.getWorld() != null)
            {
                getWorld().removeObject(orderBubble);
            }
            if (patience != null && patience.getWorld() != null)
            {
                getWorld().removeObject(patience);
            }
            getWorld().removeObject(this);
        }
    }
    
    public void setOrderRecieved()
    {
        orderRecieved = true;
    }
    
    public boolean isInLine()
    {
        return inLine;    
    }
    
    
}
