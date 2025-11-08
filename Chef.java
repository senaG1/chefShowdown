import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.Arrays;

public abstract class Chef extends SuperSmoothMover
{
    protected int cookSpeed, cost, salary, cookCount, orders, xMovement, yMovement, walkSpeed;
    protected String side;
    protected boolean isCooking;
    protected SuperStatBar cookBar;

    public Chef()
    {
        isCooking = false;
        cookBar = new SuperStatBar(cookSpeed, 0, this, 40, 10, -20, Color.YELLOW, Color.DARK_GRAY);
        cookCount = 1;
        orders = 1;
        xMovement = 200;
        yMovement = 240;
        walkSpeed = 3;
        setImage("pixelCoden.png");//testing
        enableStaticRotation();
    }

    public void addedToWorld(World w){
        getWorld().addObject(cookBar, getX(), getY());
        if(getX() <= w.getWidth() / 2){//on left side, works for blue restaurant
            side = "L";
        }else{//on right side, works for red restaurant
            side = "R";
        }

    }

    public void act(){
        cookBar.update(cookCount);
        if(!isCooking && orders > 0){
            cook();
        }
        walk();
    }

    public void takeOrder(){
        orders ++;
    }

    protected void cook(){
        isCooking = true;
        while(cookCount < 0){
            cookCount++;
        }
        isCooking = false;
        orders--;
        cookCount = 0;
    }

    protected void walk(){
        if(side.equals("L")){
            if(getRotation() % 180 == 0){
                for(int i = 0; i < xMovement/walkSpeed; i++){
                    move(-walkSpeed);
                }     
            }else{
                for(int i = 0; i < yMovement/walkSpeed; i++){
                    move(walkSpeed);
                }     
            }
        }else{
            if(getRotation() % 180 == 0){
                for(int i = 0; i < xMovement/walkSpeed; i++){
                    move(walkSpeed);
                }     
            }else{
                for(int i = 0; i < yMovement/walkSpeed; i++){
                    move(walkSpeed);
                }     
            }
        }

        sleepFor(15);
        turn(90);
    }

    protected void checkQueue(){

    }

    protected void setRestaurant(){

    }

    protected void quit(){//if the restaurant does not have enough money to pay the chef's salary, the chef will despawn

    }   
}
