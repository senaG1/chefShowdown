import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paparazzi here.
 * 
 * @author Jiayu Chen
 * @version 11-10 1.1
 */
public class Paparazzi extends Effect
{
    private GreenfootImage[] flashAnimation = new GreenfootImage[7];
    
    private int animationFrame;
    private int animationTimer;
    private static int animationSpeed = 4;
    
    public Paparazzi()
    {
        super(240);
        for (int i = 0; i < 7; i++) {
            GreenfootImage img = new GreenfootImage("images/flash/" + i + ".png");
            flashAnimation[i] = img;
        }
        setImage(flashAnimation[0]);
    }
    
    public void act()
    {
        super.act();
        animateFlash();
    }
    
    /**
     * Animates the paparazzi camera flashes
     */
    private void animateFlash() {
        animationTimer++;
        if (animationTimer >= animationSpeed) {
            animationTimer = 0;
            animationFrame = (animationFrame + 1) % flashAnimation.length;
            setImage(flashAnimation[animationFrame]);
        }
    }
    
    public void loseCustomers()
    {
        // All Karens leave
    }
}
