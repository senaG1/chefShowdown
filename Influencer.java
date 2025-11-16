import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Influencer here.
 * 
 * @author Isabel Powell
 * @version (a version number or a date)
 */
public class Influencer extends Customer
{
    private GreenfootImage image;
    private boolean firstAct = true;
    private boolean hasPaparzzi = false;
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
            effect = new Paparazzi();
            rw.addObject(effect, getX(), getY() - 100);
            
            RestaurantWorld w = (RestaurantWorld)getWorld();
            w.spawnCustomers(1, restaurant.getTeam());
            hasPaparzzi = true;
            
            //firstAct = false;
        }
    }
    
    private boolean isInPositon(){
        int xCord = (getX() >= 480) ? LINE_X - 20 : LINE_X;
        double distance = Math.abs(getX() - xCord);
        return distance < 10;
    }
    
}
