import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Chef extends SuperSmoothMover
{
    protected int speed, cost, salary;
    protected Restaurant myRestaurant;
    
    public Chef()
    {
        
    }
    
    protected void cook(){
        sleepFor(speed);
    }
    
    public void addedToWorld(World w){
        if(getX() <= w.getWidth() / 2){//on left side, works for blue restaurant
            
        }else{//on right side, works for red restaurant
            
        }
    }
    
    public void checkQueue(){
        
    }
    
    public void setRestaurant(){
        
    }
    
    public void quit(){//if the restaurant does not have enough money to pay the chef's salary, the chef will despawn
        
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
}
