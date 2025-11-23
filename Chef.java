import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Chef is an actor that walks around in a Restaurant and cooks orders of food for Customers.
 * <p>
 * It will only interact with Customers on the same side (L/R) of the world.
 * 
 * @author Cayden Chan
 * @version November 2025
 */
public abstract class Chef extends SuperSmoothMover
{
    protected int cookSpeed, cost, salary, cookCount, foodPerOrder, walkSpeed, currentFood;
    protected int upperBound, lowerBound, farBound, closeBound;//movement box (close and far from center x of screen)
    protected int centreX;
    protected String side, foodItem;
    protected boolean isCooking;
    protected SuperStatBar cookBar;
    protected SuperSpeechBubble orderBubble;
    protected GreenfootImage image, orderImage;
    protected int skill, foodX, foodY;
    protected Customer currentCustomer;
    protected Food food;
    
    /**
     * Default constructor called by all Chef subclasses.
     * Sets up the same walk cycle for all chefs.
     */
    public Chef()
    {
        isCooking = false;

        cookCount = 0;
        walkSpeed = 5;

        upperBound = 260;
        lowerBound = 540;
        farBound = 240;
        closeBound = 40;

        enableStaticRotation();
    }

    public void addedToWorld(World w){
        cookBar = new SuperStatBar(cookSpeed, 0, this, 40, 10, -30, Color.YELLOW, Color.DARK_GRAY);
        w.addObject(cookBar, getX(), getY());
        if(getX() <= w.getWidth() / 2){//on left side, works for blue restaurant
            side = "L";
            turn(180);
            foodX = 100;
        }else{//on right side, works for red restaurant
            side = "R";
            foodX = 860;
        }
        foodY = 300;
        centreX = w.getWidth()/2;
    }
    
    /**
     * <li> walks in a rectangle in the kitchen area of its restaurant </li>
     * <li> if there is an order, cook the order (update the timer) </li>
     * <li> updates the superStatBar for cooking time </li>
     */
    public void act(){
        walk();
        cookBar.update(cookCount);
        if(isCooking){
            cook();
        }   
    }
    
    /**
     * Returns which side of the screen the chef is on
     * 
     * @return boolean  left side returns true, right side returns false
     */
    public boolean onTeamBlue(){
        return side.equals("L");
    }
    
    /**
     * Returns if the chef is currently cooking an order
     * 
     * @return boolean  true if cooking, false if not cooking
     */
    public boolean isCooking(){
        return isCooking;
    }

    protected void nextOrder(){
        World w = getWorld();
        
        //customer gets food
        if(w != null && foodItem != null){
            food = new Food(foodItem, skill, 0);
            w.addObject(food, foodX, foodY);
        }
        currentCustomer.pickUpOrder(food);
    
        //next order starts
        if(orderBubble != null){
            w.removeObject(orderBubble);
        }
        if(orderImage != null && foodItem != null){
            GreenfootImage foodImg = new GreenfootImage(foodItem + ".png");
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, foodImg, true, true);
        }
        if(orderBubble != null){
            w.addObject(orderBubble, getX(), getY());
        }
    }

    /**
     * If the chef is not currently cooking, it will take a customer's order and begin cooking it
     * <p>
     * Creates new superSpeechBubble with the order image
     * 
     * @param img   the image of the customer's order
     * @param orderName    the name of the food the customer is ordering
     * @param c the customer that is ordering
     */
    public boolean takeOrder(GreenfootImage img, String orderName, Customer c){
        if(!isCooking){
            isCooking = true;
            currentFood = 0;
            orderImage = new GreenfootImage(img);
            foodItem = orderName;
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, img, true, true);
            getWorld().addObject(orderBubble, getX(), getY());
            currentCustomer = c;
            return true;
        }else{
            return false;
        }
    }

    protected void cook(){
        if(cookCount < cookSpeed){
            isCooking = true;
            cookCount++;
        }else{
            nextOrder();
            isCooking = false;
            cookCount = 0;
            if(orderBubble != null){
                getWorld().removeObject(orderBubble);
            }
            sleepFor(45);
        }
    }

    //walks in a rectangle
    protected void walk(){
        move(walkSpeed);
        if(getY() >= lowerBound || getY() <= upperBound){
            sleepFor(15);
            if(side.equals("L")){
                turn(-90);
            }else{
                turn(90);
            }
            if(getY() >= lowerBound){
                setLocation(getX(), lowerBound - 5);
            }else{
                setLocation(getX(), upperBound + 5);
            }
        }
        if(side.equals("L")){
            if(getX() >= centreX - closeBound || getX() <= centreX - farBound){
                turn(-90);
                sleepFor(15);
                if(getX() >= centreX-closeBound){
                    setLocation(centreX - closeBound - 5, getY());
                }else{
                    setLocation(centreX - farBound + 5, getY());
                }
            }
        }else{
            if(getX() <= centreX + closeBound || getX() >= centreX + farBound){
                turn(90);
                sleepFor(15);
                if(getX() <= centreX+closeBound){
                    setLocation(centreX + closeBound + 5, getY());
                }else{
                    setLocation(centreX + farBound - 5, getY());
                }
            }
        }

    }
    
    public int getSalary() {
        return salary;
    }
    
    /**
     * if the restaurant does not have enough money to pay the chef's salary, the chef will despawn
     */
    public void quit(){
        getWorld().removeObject(this);
    }   
}
