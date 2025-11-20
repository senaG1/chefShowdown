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
 * electrivityOut by DB sound from pixabay 
 * 
 * @author Sena Godek
 * @version 2025
 */
public class SoundManager  
{
    // Arrays to store multiple copies of each sound
    private static GreenfootSound[] coinSounds;
    private static GreenfootSound[] nextDaySounds;
    private static GreenfootSound[] paparazziSounds;
    private static GreenfootSound[] leaveSounds;
    private static GreenfootSound[] ratSounds;
    private static GreenfootSound[] endGameSounds;
    private static GreenfootSound[] gameStartSounds;
    private static GreenfootSound[] increaseStarSounds;
    private static GreenfootSound[] electrivityOutSounds;
    
    // Indices to track which copy to play next
    private static int coinIndex = 0;
    private static int nextDayIndex = 0;
    private static int paparazziIndex = 0;
    private static int leaveIndex = 0;
    private static int ratIndex = 0;
    private static int endGameIndex = 0;
    private static int gameStartIndex = 0;
    private static int increaseStarIndex = 0;
    private static int electrivityOutIndex = 0;
    
     static {
        initializeSounds();
    }
    
    /**
     * Initialize all sound arrays with multiple copies.
     */
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
            nextDaySounds[i] = new GreenfootSound("nextDay.wav");
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
        
        // endGame - 
        endGameSounds = new GreenfootSound[15];
        for (int i = 0; i < endGameSounds.length; i++) {
            endGameSounds[i] = new GreenfootSound("endGame.wav");
            endGameSounds[i].setVolume(45);
        }
        
        // gameStart - 
        gameStartSounds = new GreenfootSound[15];
        for (int i = 0; i < gameStartSounds.length; i++) {
            gameStartSounds[i] = new GreenfootSound("gameStart.wav");
            gameStartSounds[i].setVolume(45);
        }
        
        // increaseStar - 
        increaseStarSounds = new GreenfootSound[15];
        for (int i = 0; i < increaseStarSounds.length; i++) {
            increaseStarSounds[i] = new GreenfootSound("increaseStar.wav");
            increaseStarSounds[i].setVolume(45);
        }
        
        // electrivityOut - 
        electrivityOutSounds = new GreenfootSound[15];
        for (int i = 0; i < electrivityOutSounds.length; i++) {
            electrivityOutSounds[i] = new GreenfootSound("electrivityOut.wav");
            electrivityOutSounds[i].setVolume(45);
        }
    }
    
    /**
     * Play coin sound
     */
    public static void playCoin() {
        coinSounds[coinIndex].play();
        coinIndex++;
        if (coinIndex >= coinSounds.length) {
            coinIndex = 0;
        }
    }
    
    /**
     * Play nextDay sound
     */
    public static void playnextDay() {
        nextDaySounds[nextDayIndex].play();
        nextDayIndex++;
        if (nextDayIndex >= nextDaySounds.length) {
            nextDayIndex = 0;
        }
    }
    
    /**
     * Play nextDay sound
     */
    public static void playPaparazzi() {
        paparazziSounds[paparazziIndex].play();
        paparazziIndex++;
        if (paparazziIndex >= paparazziSounds.length) {
            paparazziIndex = 0;
        }
    }
    
    /**
     * Play leave sound
     */
    public static void playLeave() {
        leaveSounds[leaveIndex].play();
        leaveIndex++;
        if (leaveIndex >= leaveSounds.length) {
            leaveIndex = 0;
        }
    }
    
    /**
     * Play rat sound
     */
    public static void playRat() {
        ratSounds[ratIndex].play();
        ratIndex++;
        if (ratIndex >= ratSounds.length) {
            ratIndex = 0;
        }
    }
    
    /**
     * Play EndGame sound
     */
    public static void playEndGame() {
        endGameSounds[endGameIndex].play();
        endGameIndex++;
        if (endGameIndex >= endGameSounds.length) {
            endGameIndex = 0;
        }
    }
    
    /**
     * Play GameStart sound
     */
    public static void playGameStart() {
        gameStartSounds[gameStartIndex].play();
        gameStartIndex++;
        if (gameStartIndex >= gameStartSounds.length) {
            gameStartIndex = 0;
        }
    }
    
    /**
     * Play IncreaseStar sound
     */
    public static void playIncreaseStar() {
        increaseStarSounds[increaseStarIndex].play();
        increaseStarIndex++;
        if (increaseStarIndex >= increaseStarSounds.length) {
            increaseStarIndex = 0;
        }
    }
    
    /**
     * Play electrivityOut sound
     */
    public static void playElectrivityOut() {
        electrivityOutSounds[electrivityOutIndex].play();
        electrivityOutIndex++;
        if (electrivityOutIndex >= electrivityOutSounds.length) {
            electrivityOutIndex = 0;
        }
    }
}
