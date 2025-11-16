import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
/**
 * Write a description of class Customer here.
 * 
 * @author Oscar Ho 
 * @version 15-11
 */
public class Customer extends SuperSmoothMover
{
    private GreenfootImage image;
    protected RestaurantWorld rw;
    private Chef chef;
    private static int nextCustomerIndex = 0;
    protected int customerIndex;
    protected int LINE_X;
    protected int LINE_START_Y;
    private static final int SPACING = 30;
    private static final double MOVE_SPEED = 3.0;
    protected boolean inLine;    
    protected boolean hasWaitingSpot;
    protected int waitingX;
    protected int waitingY;
    protected int actTimer;
    protected SuperStatBar patience;
    protected int maxPatience = 2100; // 35 secs before patience runs out
    protected int currentPatience = 2100;
    private int targetX;
    private int targetY;
    protected String[] menu = {"nuggets", "fries", "hash", "burger", "crispy", "filet", "mcflurry", "apple", "coffee", "smoothie"};
    protected int[] prices = {59, 39, 19, 109, 107, 79, 69, 22, 49, 75};
    protected String[] order;
    protected SuperSpeechBubble orderBubble;
    protected GreenfootImage orderImage;
    protected boolean givingUp = false;
    private boolean test = true;
    protected boolean orderTaken = false;
    protected boolean leavingStore = false;
    protected boolean waitingOrder = false;
    protected boolean orderRecieved = false;
    private boolean teamBlue;

    private int rating;
    
    protected Restaurant restaurant;

    private static final int BLUE_MIN_X = 0;
    private static final int BLUE_MAX_X = 480;  // Left half of 960
    private static final int RED_MIN_X = 480;
    private static final int RED_MAX_X = 960;   // Right half of 960

    public Customer(Restaurant restaurant)
    {
        image = new GreenfootImage("regular_Cust.png");
        setImage(image);
        customerIndex = nextCustomerIndex;
        nextCustomerIndex++;
        inLine = true;
        actTimer = 180;
        this.restaurant = restaurant;
    }

    public void addedToWorld(World w){
        if(getX() > w.getWidth()/2){
            teamBlue = false;
        }else{
            teamBlue = true;
        }
        ArrayList<Chef> chefs = (ArrayList<Chef>) w.getObjects(Chef.class);
        for(Chef c : w.getObjects(Chef.class)){//preferably takes an order to a chef that is not busy
            if(!c.isCooking()){
                if((teamBlue && c.onTeamBlue()) || (!teamBlue && !c.onTeamBlue())){//chef and customer on same side
                    chef = c;
                    break;
                }
            }
        }
        if(chef == null){//no chef without an order, take an order with the first chef on the correct side
            for(Chef c : w.getObjects(Chef.class)){
                if((teamBlue && c.onTeamBlue()) || (!teamBlue && !c.onTeamBlue())){//chef and customer on same side
                    chef = c;
                    break;
                }
            }
        }
        rw = (RestaurantWorld) w;
    }

    private GreenfootImage getImageForItem(String item){
        if(item.equals("nuggets"))
        {
            return new GreenfootImage("nuggets.png");
        }
        else if(item.equals("fries"))
        {
            return new GreenfootImage("fries.png");
        }
        else if(item.equals("hash"))
        {
            return new GreenfootImage("hash.png");
        }
        else if(item.equals("burger"))
        {
            return new GreenfootImage("burger.png");
        }
        else if(item.equals("crispy"))
        {
            return new GreenfootImage("crispy.png");
        }
        else if(item.equals("filet"))
        {
            return new GreenfootImage("filet.png");
        }
        else if(item.equals("apple"))
        {
            return new GreenfootImage("apple.png");
        }
        else if(item.equals("mcflurry"))
        {
            return new GreenfootImage("mcflurry.png");
        }
        else if(item.equals("coffee"))
        {
            return new GreenfootImage("coffee.png");
        }
        else if(item.equals("smoothie"))
        {
            return new GreenfootImage("smoothie.png");
        }
        return null;
    }

    public void act()
    {
        if (givingUp)
        {
            walkToExit();
            return;  
        }

        if (orderRecieved)
        {
            leaveWithFood();
            leavingStore = true;
            return;
        }

        if (orderTaken)
        {
            currentPatience--;
            if (patience != null) 
            {
                patience.update(currentPatience);
            }

            if (currentPatience <= 0)
            {
                giveUp();
                return;
            }
        }

        if (inLine)
        {
            lineUp();

            ArrayList<Customer> customers = (ArrayList<Customer>) getWorld().getObjects(Customer.class);
            int myPosition = 0;
            for(Customer c : customers)
            {
                if(c.isInLine() && c.customerIndex < this.customerIndex)
                {
                    myPosition++;
                }
            }

            if (myPosition == 0)
            {
                actTimer--;
                if (actTimer <= 0)
                {
                    generateOrder();
                    inLine = false;
                    orderTaken = true;

                    if(orderImage != null)
                    {
                        patience = new SuperStatBar(maxPatience, currentPatience, this, 50, 8, -30, Color.BLUE, Color.RED);
                        getWorld().addObject(patience, getX(), getY());
                        orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
                        getWorld().addObject(orderBubble, getX(), getY());
                    }

                    actTimer = 180;
                }
            }
            else
            {
                actTimer = 180;
            }
        }
        else if (orderTaken && !waitingOrder)
        {
            waitingOrder = true;
        }
        else if (waitingOrder)
        {
            waitOrder();
        }
    }

    // If patience runs out or an effect is caused, removes from world
    public void giveUp()
    {
        if (!givingUp)
        {
            givingUp = true;
            orderImage = new GreenfootImage("angry.png");

            // Remove old bubble if it exists
            if (orderBubble != null && orderBubble.getWorld() != null)
            {
                getWorld().removeObject(orderBubble);
            }

            if (patience != null && patience.getWorld() != null)
            {
                getWorld().removeObject(patience);
            }

            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
            getWorld().addObject(orderBubble, getX(), getY());
            inLine = false;
            hasWaitingSpot = false;
            
            restaurant.recordRating(1);
        }
    }

    // Has customer choose random items from menu
    // Can choose up to 3 items
    public String[] generateOrder()
    {
        int numOrder = Greenfoot.getRandomNumber(2)+1;
        ArrayList<String> availibleItems = new ArrayList<>();
        GreenfootImage currentOrder = new GreenfootImage("happy.png");
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
            itemImages.add(getImageForItem(order[i]));
            currentOrder = getImageForItem(order[i]);
            pay(prices[i]);
        }
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(order));
        chef.takeOrder(currentOrder, arrayList);
        createCompositeOrderImage(itemImages);

        return order;
    }
    
    private void pay(int amount) {
        this.restaurant.collectCash(amount);
    }

    private void createCompositeOrderImage(ArrayList<GreenfootImage> images)
    {
        if(images.isEmpty()) 
        {
            return;
        }

        int itemSize = 30;
        int spacing = 5;
        int totalWidth = images.size() * (itemSize + spacing) - spacing;

        orderImage = new GreenfootImage(totalWidth, itemSize);
        orderImage.setColor(new Color(0, 0, 0, 0));
        orderImage.fill();

        int xPos = 0;
        for(GreenfootImage img : images)
        {
            GreenfootImage scaledImg = new GreenfootImage(img);
            scaledImg.scale(itemSize, itemSize);
            orderImage.drawImage(scaledImg, xPos, 0);
            xPos += itemSize + spacing;
        }
    }

    /**
     * Determines which restaurant side this customer is on based on X position
     * @return "Blue" if on left side, "Red" if on right side
     */
    public String getRestaurantSide()
    {
        int x = getX();

        if (x >= BLUE_MIN_X && x < BLUE_MAX_X)
        {
            return "Blue";
        }
        else
        {
            return "Red";
        }
    }

    /**
     * Check if this customer is on a specific restaurant side
     * @param side - "Red" or "Blue"
     * @return true if customer is on that side
     */
    public boolean isOnSide(String side)
    {
        return getRestaurantSide().equals(side);
    }

    // Sends customers in line to wait at the waiting space
    // Currently needs implementation after method for taking customer's orders is made
    public void waitOrder(){
        int currentX = getX();
        int currentY = getY();
        if(!hasWaitingSpot)
        {
            int attempts = 0;
            boolean spotFound = false;
            int testX = 0;
            int testY = 0;
            // Ensures that customers don't wait at a spot where there is already a customer waiting
            while(!spotFound && attempts < 50)
            {
                if(LINE_X == 909)
                {
                    testX = Greenfoot.getRandomNumber(946 - 884 + 1) + 884;
                    testY = Greenfoot.getRandomNumber(426 - 212 + 1) + 212;
                }
                else
                {
                    testX = Greenfoot.getRandomNumber(78 - 11 + 1) + 11;
                    testY = Greenfoot.getRandomNumber(426 - 212 + 1) + 212;
                }

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

    public void leaveWithFood() {
        if (orderBubble != null && orderBubble.getWorld() != null)
        {
            getWorld().removeObject(orderBubble);
        }

        orderImage = new GreenfootImage("happy.png");
        orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImage, true, true);
        getWorld().addObject(orderBubble, getX(), getY());

        // Give rating based off of time spent in restaurant waiting for food
        double patiencePercent = (double)currentPatience / maxPatience * 100;
        if(patiencePercent >= 80)
        {
            rating = 5;
        }
        else if(patiencePercent >= 60)
        {
            rating = 4;
        }
        else if(patiencePercent >= 40)
        {
            rating = 3;
        }
        else if(patiencePercent >= 20)
        {
            rating = 2;
        }
        else if(patiencePercent > 0)
        {
            rating = 1;
        }
        else
        {
            rating = 0;
        }
        
        restaurant.recordRating(rating);
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
            if(getX() >= 480 && getX() <= 960)
            {
                targetX = LINE_X - 20;
            }
            else
            {
                targetX = LINE_X;
            }
            targetY = LINE_START_Y + myPosition * SPACING;
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

    private void walkToExit() {
        int currentY = getY();
        int worldHeight = getWorld().getHeight();
        if (currentY < worldHeight - 5)
        {
            setLocation(getX(), currentY + (int)MOVE_SPEED);
            setLocation(getX(), currentY + (int)MOVE_SPEED * 1.5);
        }
        else
        {
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

    public boolean isInLine(){
        return inLine;    
    }

    public void setOrderRecieved()
    {
        orderRecieved = true;
    }

    public int getRating()
    {
        return rating;
    }

    public String[] getOrder()
    {
        return order;
    }
}