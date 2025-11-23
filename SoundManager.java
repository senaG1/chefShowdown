import greenfoot.*;
/**
 * Write a description of class SoungManager here.
 * 
 * coin sound by chieuk from pixabay
 * paprazzi by ShidenBeatsMusic from pixabay
 * leave by AberrantRealities from pixabay
 * rat by SOUND_GARAGE from pixabay
 * endGame by Superpuyofãns1234 from pixabay
 * fasterGameStart by Universfield from pixabay
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
    private static GreenfootSound[] fasterGameStartSounds;
    private static GreenfootSound[] increaseStarSounds;
    private static GreenfootSound[] electrivityOutSounds;
    private static GreenfootSound[] moneySounds;
    private static GreenfootSound backgroundSound; // background music
    
    // Indices to track which copy to play next
    private static int coinIndex = 0;
    private static int nextDayIndex = 0;
    private static int paparazziIndex = 0;
    private static int leaveIndex = 0;
    private static int ratIndex = 0;
    private static int endGameIndex = 0;
    private static int fasterGameStartIndex = 0;
    private static int increaseStarIndex = 0;
    private static int electrivityOutIndex = 0;
    private static int moneyIndex = 0;
    
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
            coinSounds[i].setVolume(100);
        }
        
        // nextDay - 
        nextDaySounds = new GreenfootSound[15];
        for (int i = 0; i < nextDaySounds.length; i++) {
            nextDaySounds[i] = new GreenfootSound("nextDay.wav");
            nextDaySounds[i].setVolume(100);
        }
        
        // paparazzi - 
        paparazziSounds = new GreenfootSound[15];
        for (int i = 0; i < paparazziSounds.length; i++) {
            paparazziSounds[i] = new GreenfootSound("paparazzi.wav");
            paparazziSounds[i].setVolume(100);
        }
        
        // leave - 
        leaveSounds = new GreenfootSound[15];
        for (int i = 0; i < leaveSounds.length; i++) {
            leaveSounds[i] = new GreenfootSound("leave.wav");
            leaveSounds[i].setVolume(100);
        }
        
        // rat - 
        ratSounds = new GreenfootSound[15];
        for (int i = 0; i < ratSounds.length; i++) {
            ratSounds[i] = new GreenfootSound("rat.wav");
            ratSounds[i].setVolume(100);
        }
        
        // endGame - 
        endGameSounds = new GreenfootSound[15];
        for (int i = 0; i < endGameSounds.length; i++) {
            endGameSounds[i] = new GreenfootSound("endGame.wav");
            endGameSounds[i].setVolume(100);
        }
        
        // fasterGameStart - 
        fasterGameStartSounds = new GreenfootSound[15];
        for (int i = 0; i < fasterGameStartSounds.length; i++) {
            fasterGameStartSounds[i] = new GreenfootSound("fasterGameStart.wav");
            fasterGameStartSounds[i].setVolume(100);
        }
        
        // increaseStar - 
        increaseStarSounds = new GreenfootSound[15];
        for (int i = 0; i < increaseStarSounds.length; i++) {
            increaseStarSounds[i] = new GreenfootSound("increaseStar.wav");
            increaseStarSounds[i].setVolume(100);
        }
        
        // electrivityOut - 
        electrivityOutSounds = new GreenfootSound[15];
        for (int i = 0; i < electrivityOutSounds.length; i++) {
            electrivityOutSounds[i] = new GreenfootSound("electricityOut.wav");
            electrivityOutSounds[i].setVolume(100);
        }
        
        // generateOrder -
        moneySounds = new GreenfootSound[15];
        for (int i = 0; i < moneySounds.length; i++){
            moneySounds[i] = new GreenfootSound("money.wav");
            moneySounds[i].setVolume(100);
        }
        
        backgroundSound = new GreenfootSound("backgroundmusic.mp3");
        backgroundSound.setVolume(20);
        
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
    public static void playNextDay() {
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
     * Play fasterGameStart sound
     */
    public static void playFasterGameStart() {
        fasterGameStartSounds[fasterGameStartIndex].play();
        fasterGameStartIndex++;
        if (fasterGameStartIndex >= fasterGameStartSounds.length) {
            fasterGameStartIndex = 0;
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
    
    /**
     * Play money sound
     */
    public static void playMoney() {
        moneySounds[moneyIndex].play();
        moneyIndex++;
        if (moneyIndex >= moneySounds.length) {
            moneyIndex = 0;
        }
    }
    
    
    public static void playBackground(){
        if(backgroundSound != null)
        {
            backgroundSound.stop();
        }
        backgroundSound = new GreenfootSound("backgroundmusic.mp3");
        backgroundSound.setVolume(20);
        backgroundSound.playLoop();
    }
    
        public static void stopBackgroundMusic() {
        if (backgroundSound != null) {
            backgroundSound.stop();
            backgroundSound = null;
        }
    }
    
    public static void pauseBackgroundMusic() {
        if (backgroundSound != null && backgroundSound.isPlaying()) {
            backgroundSound.pause();
        }
    }
    
    public static void resumeBackgroundMusic() {
        if (backgroundSound != null) {
            backgroundSound.play();
        }
    }
    
    /**
     * Stop all sounds (call this when game ends or is stopped)
     */
    public static void stopAllSounds() {
        // Stop all coin sounds
        for (int i = 0; i < coinSounds.length; i++) {
            coinSounds[i].stop();
        }
        
        // Stop all nextDay sounds
        for (int i = 0; i < nextDaySounds.length; i++) {
            nextDaySounds[i].stop();
        }
        
        // Stop all paparazzi sounds
        for (int i = 0; i < paparazziSounds.length; i++) {
            paparazziSounds[i].stop();
        }
        
        // Stop all leave sounds
        for (int i = 0; i < leaveSounds.length; i++) {
            leaveSounds[i].stop();
        }
        
        // Stop all rat sounds
        for (int i = 0; i < ratSounds.length; i++) {
            ratSounds[i].stop();
        }
        
        // Stop all endGame sounds
        for (int i = 0; i < endGameSounds.length; i++) {
            endGameSounds[i].stop();
        }
        
        // Stop all fasterGameStart sounds
        for (int i = 0; i < fasterGameStartSounds.length; i++) {
            fasterGameStartSounds[i].stop();
        }
        
        // Stop all increaseStar sounds
        for (int i = 0; i < increaseStarSounds.length; i++) {
            increaseStarSounds[i].stop();
        }
        
        // Stop all electricityOut sounds
        for (int i = 0; i < electrivityOutSounds.length; i++) {
            electrivityOutSounds[i].stop();
        }
        
        // Stop all money sounds
        for (int i = 0; i < moneySounds.length; i++) {
            moneySounds[i].stop();
        }
        
        // Stop background sound
        stopBackgroundMusic();
    }
}
