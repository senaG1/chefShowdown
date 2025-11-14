import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Medium speed chef who will occasionally eat the food he is cooking
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HungryChef extends Chef
{
    public HungryChef(){
        cookSpeed = 180;
    }
    
    public void act()
    {
        super.act();
    }
    
    protected void cook(){
        if(cookCount < cookSpeed){
            isCooking = true;
            cookCount++;
            if(Greenfoot.getRandomNumber(10) == 0){//eats a customer's food occasionally and resets the timer
                cookCount = 0;
                //play sound effect 
            }
        }else{
            //nextOrder();
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
