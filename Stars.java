import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stars here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stars extends SuperSmoothMover
{
    private GreenfootImage[] frames;
    private int currentFrame = 0;
    private int frameDelay = 4;
    private int delayCount = 0;

    public Stars() {
        frames = new GreenfootImage[12];
        for (int i = 0; i < 12; i++) {
            frames[i] = new GreenfootImage("images/star_rating/stars/" + i);
            // frames[i].scale(24, 24);
        }
        setImage(frames[0]);
    }

    public void act() {
        delayCount++;
        if (delayCount >= frameDelay) {
            currentFrame = (currentFrame + 1) % frames.length;
            setImage(frames[currentFrame]);
            delayCount = 0;
        }
    }
}
