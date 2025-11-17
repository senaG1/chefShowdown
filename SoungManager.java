import greenfoot.*;
/**
 * Write a description of class SoungManager here.
 * 
 * coin sound by chieuk from pixabay
 * pop sound by OxidVideos from pixabay
 * paprazzi by SoundReality from pixabay
 * leave by AberrantRealities from pixabay
 * 
 * @author Sena Godek
 * @version 2025
 */
public class SoungManager  
{
    // Arrays to store multiple copies of each sound
    private static GreenfootSound[] coinSounds;
    private static GreenfootSound[] popSounds;
    private static GreenfootSound[] paparazziSounds;
    private static GreenfootSound[] leaveSounds;
    
    // Indices to track which copy to play next
    private static int coinIndex = 0;
    private static int popIndex = 0;
    private static int paparazziIndex = 0;
    private static int leaveIndex = 0;
    
    static {
        initializeSounds();
    }
    
    private static void initializeSounds() {
        // coin - 
        coinSounds = new GreenfootSound[15];
        for (int i = 0; i < coinSounds.length; i++) {
            coinSounds[i] = new GreenfootSound("coin.wav");
            coinSounds[i].setVolume(45);
        }
        
        // pop - 
        popSounds = new GreenfootSound[15];
        for (int i = 0; i < popSounds.length; i++) {
            popSounds[i] = new GreenfootSound("pop.wav");
            popSounds[i].setVolume(45);
        }
        
        // paparazzi - 
        paparazziSounds = new GreenfootSound[15];
        for (int i = 0; i < paparazziSounds.length; i++) {
            paparazziSounds[i] = new GreenfootSound("paparazzi.wav");
            paparazziSounds[i].setVolume(45);
        }
        
        // leave - 
        leaveSounds = new GreenfootSound[15];
        for (int i = 0; i < leaveSounds.length; i++) {
            leaveSounds[i] = new GreenfootSound("leave.wav");
            leaveSounds[i].setVolume(45);
        }
        
    }
}
