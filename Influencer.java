import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Influencer class is a Greenfoot actor, that inherits from Customer.
 * <p>
 * When added into world, it will add an effect, and add another customer with it.
 * @author Isabel Powell
 * @version Nov. 16th 2025
 */
public class Influencer extends Customer
{
    private GreenfootImage image;
    private boolean firstAct = true;
    private boolean hasPaparzzi = false;
    /**
     * Constructor for Influencer - creates a new Influencer.
     * This is called from Restaurant World.
     * 
     * @param restaurant    restaurant object
     */
    public Influencer(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("influencer_00.png");
        image.scale(image.getWidth()*2, image.getHeight()*2);
        setImage(image);
        
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    
    public void act()
    {
        super.act();
        Paparazzi effect;
        if (!hasPaparzzi && isInPositon() && inLine) {
            effect = new Paparazzi(); //Adds Paparazzi effect
            rw.addObject(effect, getX(), getY() - 100); //Calls world to add this
            
            RestaurantWorld w = (RestaurantWorld)getWorld();
            //Calls from Restaurant World to add One customer on the same team as Influencer
            w.spawnCustomers(1, restaurant.getTeam()); 
            hasPaparzzi = true; //Paparzzi is only spawned once
            
            //firstAct = false;
        }
    }
    //Ensures that Influencer is in line BEFORE spawning a new customer
    private boolean isInPositon(){
        int xCord = (getX() >= 480) ? LINE_X - 20 : LINE_X;
        double distance = Math.abs(getX() - xCord);
        return distance < 10;
    }
    
}
