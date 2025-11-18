import greenfoot.*;
/**
 * Write a description of class SoungManager here.
 * 
 * coin sound by chieuk from pixabay
 * paprazzi by ShidenBeatsMusic from pixabay
 * leave by AberrantRealities from pixabay
 * rat by SOUND_GARAGE from pixabay
 * endGame by Superpuyofãns1234 from pixabay
 * gameStart by Universfield from pixabay
 * increaseStar by freesound_CrunchpixStudio from pixabay
 * nextDay by MixKit
 * 
 * @author Sena Godek
 * @version 2025
 */
public class SoungManager  
{
    // Arrays to store multiple copies of each sound
    private static GreenfootSound[] coinSounds;
    private static GreenfootSound[] nextDaySounds;
    private static GreenfootSound[] paparazziSounds;
    private static GreenfootSound[] leaveSounds;
    private static GreenfootSound[] ratSounds;
    
    // Indices to track which copy to play next
    private static int coinIndex = 0;
    private static int nextDayIndex = 0;
    private static int paparazziIndex = 0;
    private static int leaveIndex = 0;
    private static int ratIndex = 0;
    
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
        
        // nextDay - 
        nextDaySounds = new GreenfootSound[15];
        for (int i = 0; i < nextDaySounds.length; i++) {
            nextDaySounds[i].setVolume(45);
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
        
        // rat - 
        ratSounds = new GreenfootSound[15];
        for (int i = 0; i < ratSounds.length; i++) {
            ratSounds[i] = new GreenfootSound("rat.wav");
            ratSounds[i].setVolume(45);
        }
        
    }
}
