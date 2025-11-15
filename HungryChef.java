import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Medium speed chef who will occasionally eat the food he is cooking
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HungryChef extends Chef
{
    private int actCount;

    public HungryChef(){
        cookSpeed = 180;
        actCount = 0;
    }

    public void act()
    {
        super.act();
        actCount++;
    }

    protected void cook(){
        if(cookCount < cookSpeed){
            isCooking = true;
            cookCount++;
            if(actCount % 300 == 0){//eats a customer's food every 5 seconds and restarts cooking
                actCount = 0;
                cookCount = 0;
                //play sound effect 
            }
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

}
