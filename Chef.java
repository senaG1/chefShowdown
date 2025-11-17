import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public abstract class Chef extends SuperSmoothMover
{
    protected int cookSpeed, cost, salary, cookCount, orders, walkSpeed;
    protected int upperBound, lowerBound, farBound, closeBound;//movement box (close and far from center x of screen)
    protected int centreX;
    protected String side;
    protected boolean isCooking;
    protected SuperStatBar cookBar;
    protected SuperSpeechBubble orderBubble;
    protected GreenfootImage image;
    protected int skill, foodX, foodY;
    protected ArrayList<GreenfootImage> orderImages;
    protected ArrayList<ArrayList<String>> foodItems;

    public Chef()
    {
        isCooking = false;

        cookCount = 0;
        orders = 0;
        
        walkSpeed = 5;

        upperBound = 260;
        lowerBound = 540;
        farBound = 240;
        closeBound = 40;

        //image for testing purposes
        image = new GreenfootImage ("ChefCohen.png");
        setImage(image);
        
        enableStaticRotation();
        
        orderImages = new ArrayList<GreenfootImage>();
        foodItems = new ArrayList<ArrayList<String>>();
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

    public void act(){
        walk();
        cookBar.update(cookCount);
        if(orders > 0){
            cook();
        }
    }
    
    public boolean onTeamBlue(){
        return side.equals("L");
    }
    
    public boolean isCooking(){
        return isCooking;
    }
    
    protected void nextOrder(){
        World w = getWorld();
        if(w != null){
            w.addObject(new Food(foodItems.get(0).get(0), skill, 0), foodX, foodY);
        }
        if(!orderImages.isEmpty()){
            orderImages.remove(0);
        }
        if(!foodItems.isEmpty()){
            foodItems.remove(0);
        }
        if(orderBubble != null){
            w.removeObject(orderBubble);
        }
        if(!orderImages.isEmpty()){
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, orderImages.get(0), true, true);
        }
        if(orderBubble != null){
            w.addObject(orderBubble, getX(), getY());
        }
    }
    
    
    //gets the image and name of the order from a customer
    public void takeOrder(GreenfootImage img, ArrayList<String> orderNames){
        orders ++;
        orderImages.add(img);
        foodItems.add(orderNames);
        orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, img, true, true);
        getWorld().addObject(orderBubble, getX(), getY());
    }

    protected void cook(){
        cookCount++;
        if(cookCount < cookSpeed){
            isCooking = true;
        }else{
            nextOrder();
            isCooking = false;
            orders--;
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

    protected void checkQueue(){

    }

    protected void quit(){//if the restaurant does not have enough money to pay the chef's salary, the chef will despawn

    }   
}
