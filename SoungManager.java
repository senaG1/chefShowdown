import greenfoot.*;
/**
 * Write a description of class SoungManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SoungManager  
{
    // Arrays to store multiple copies of each sound
    private static GreenfootSound[] coinSounds;
    private static GreenfootSound[] wearMaskSounds;
    
    // Indices to track which copy to play next
    private static int coinIndex = 0;
    private static int wearMaskIndex = 0;
    
    static {
        initializeSounds();
    }
    
    private static void initializeSounds() {
        // Thud - knocked down frequently, needs more copies
        coinSounds = new GreenfootSound[15];
        for (int i = 0; i < coinSounds.length; i++) {
            coinSounds[i] = new GreenfootSound("coin.wav");
            coinSounds[i].setVolume(45);
        }
        
    }
}
