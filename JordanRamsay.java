import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JordanRamsay here.
 * 
 * @author Isabel Powell
 * @version (a version number or a date)
 */
public class JordanRamsay extends Customer
{
    private GreenfootImage image;
    private boolean isPaying = false;
    
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
        super.act();
        
    }
    
    public void pickUpOrder(Food f){
        super.pickUpOrder(f);
        String side = "";
        double patiencePercent = (double)currentPatience/maxPatience * 100;
        RestaurantWorld w = (RestaurantWorld)getWorld();
        if(this.getWorld() != null)
        {
            side = getRestaurantSide();
        }
        
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
