import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public abstract class Chef extends SuperSmoothMover
{
    protected int cookSpeed, cost, salary, cookCount, foodPerOrder, walkSpeed, currentFood;
    protected int upperBound, lowerBound, farBound, closeBound;//movement box (close and far from center x of screen)
    protected int centreX;
    protected String side;
    protected boolean isCooking;
    protected SuperStatBar cookBar;
    protected SuperSpeechBubble orderBubble;
    protected GreenfootImage image, orderImage;
    protected int skill, foodX, foodY;
    protected ArrayList<String> foodItems;

    public Chef()
    {
        isCooking = false;

        cookCount = 0;
        walkSpeed = 5;

        upperBound = 260;
        lowerBound = 540;
        farBound = 240;
        closeBound = 40;

        //image for testing purposes
        image = new GreenfootImage ("ChefCohen.png");
        setImage(image);

        enableStaticRotation();

        foodItems = new ArrayList<String>();
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
        if(isCooking){
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
        
        if(w != null && !foodItems.isEmpty()){
            w.addObject(new Food(foodItems.get(0), skill, 0), foodX, foodY);
        }
        if(currentFood == foodPerOrder - 1){
            foodItems.clear();
        }else{
            currentFood++;
        }
        if(orderBubble != null){
            w.removeObject(orderBubble);
        }
        if(orderImage != null && foodItems != null && !foodItems.isEmpty()){
            GreenfootImage foodImg = new GreenfootImage(foodItems.get(currentFood)+ ".png");
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, foodImg, true, true);
        }
        if(orderBubble != null){
            w.addObject(orderBubble, getX(), getY());
        }
    }

    //gets the image and name of the order from a customer
    //returns whether or not the order was received
    public boolean takeOrder(GreenfootImage img, ArrayList<String> orderNames){
        if(!isCooking){
            isCooking = true;
            foodPerOrder = orderNames.size();
            currentFood = 0;
            orderImage = new GreenfootImage(img);
            foodItems = orderNames;
            orderBubble = new SuperSpeechBubble(this, 50, 55, 50, 15, 30, img, true, true);
            getWorld().addObject(orderBubble, getX(), getY());
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

    protected void quit(){//if the restaurant does not have enough money to pay the chef's salary, the chef will despawn

    }   
}
