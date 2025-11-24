import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The JordanRamsay class is a Greenfoot actor, that inherits from Customer.
 * <p>
 * When added into world, after picking up its food, it will either give the restaurant it is at
 * A lot of money or will deduct money from one of them.
 * 
 * @author Isabel Powell
 * @version Nov. 23 2025
 */
public class JordanRamsay extends Customer
{
    private GreenfootImage image;
    private boolean isPaying = false;
    /**
     * Constructor for JordanRamsay - creates a new JordanRamsay.
     * This is called from Restaurant World.
     * 
     * @param restaurant    restaurant object
     */
    public JordanRamsay(Restaurant restaurant){
        super(restaurant);
        image = new GreenfootImage ("JordanRam.png");
        setImage(image);
        //System.out.println("I am in world");
        
        LINE_X = restaurant.getCustLineX();
        LINE_START_Y = restaurant.getCustLineY();
    }
    /**
     * Act - do whatever the ChefCohen wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(getWorld() == null){ return;}
        super.act();
        
    }
    
    /**
     * OverLoads pickUpOrder from Customer class, but also keeps the orignal code from Customer
     * While changing it to, either deduct cash or add some as a tip
     * 
     * @param f    The food that Jordan Cohen will get
     * @return void     Will run if called, returns nothings
     * 
     */
    public void pickUpOrder(Food f){
        super.pickUpOrder(f);
        //Gives patience percentage
        double patiencePercent = (double)currentPatience/maxPatience * 100;
        RestaurantWorld w = (RestaurantWorld)getWorld(); //What side this is on
        String side = getRestaurantSide();
        
        //System.out.println("patance :" + patiencePercent);
        
        if(patiencePercent > 70){
                w.giveCash(100, side);
                //System.out.println("I have given money" + side);
            }
            else{
                w.deductCash(150, side);
                //System.out.println("I have taken money" + side);
            }
        
    }
}
