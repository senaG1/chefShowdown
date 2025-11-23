import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Medium speed chef who will occasionally eat the food he is cooking, resetting the cook timer
 * 
 * @author Cayden Chan
 * @version November 2025
 */
public class HungryChef extends Chef
{
    private int actCount;
    
    /**
     * Default constructor for HungryChef: sets the salary, image, cook speed and skill
     */
    public HungryChef(){
        salary = 8;
        setImage("hungry_chef.png");
        cookSpeed = 180;
        actCount = 0;
        skill = 4;
    }

    public void act()
    {
        super.act();
        actCount++;
    }

    protected void cook(){
        cookCount++;
        if(cookCount < cookSpeed){
            isCooking = true;
            if(actCount % 300 == 0){//eats a customer's food every 5 seconds and restarts cooking
                actCount = 0;
                cookCount = 0;
                //play sound effect (to be added
            }
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

}
