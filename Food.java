import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Food class spawns food for the customers to pick up and affects the customer review.
 * 
 * @author Jiayu Chen
 * @version Novermber 23, 2025
 */
public class Food extends SuperSmoothMover
{
    private GreenfootImage image;
    private int quality;
    /**
     * The constructor for the Food class that creates the food and determines its quality.
     * 
     * @param type Takes in the type of food the customer orders.
     * @param quality The quality of food based on the chefs cooking skill and/or who cooks the food (hungry chef decreases the food quality)
     */
    public Food(String type, int quality) {
        image = new GreenfootImage(type + ".png");
        image.scale(52, 52);
        setImage(image);
        
        this.quality = quality;
    }
   
    public int getQuality(){
        return quality;
    }
}
