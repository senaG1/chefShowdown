import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StoryWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StoryWorld extends World
{
    private GreenfootImage background;
    protected SuperSpeechBubble talkingBubble;
    private int timer = 0;
    
    private Cohen goldenCohen;
    private Cohen redCohen;
    private Cohen blueCohen;
    
    /**
     * Constructor for objects of class StoryWorld.
     * 
     */
    public StoryWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1); 
        
        background = new GreenfootImage("story_Background.jpg");
        setBackground(background);
        
        goldenCohen = new Cohen("golden_Cohen.PNG", true);
        redCohen = new Cohen("red_Cohen.PNG", false);
        blueCohen = new Cohen("blue_Cohen.PNG", false);
        
        addObject(goldenCohen, 178, 444);
        addObject(redCohen, 743, 398);
        addObject(blueCohen, 900, 398);
        
        timer = 0;
        conversation();
        
    }
    
    public void act(){
        timer++;
        conversation();
    }
    
    private void conversation(){
        if(talkingBubble != null && talkingBubble.getWorld() != null && timer%180 == 0){
            removeObject(talkingBubble);
        }
        
        if(timer == 0){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Hello, my McTrainees . It’s time for your final test!", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 190){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Only one of you can become a real Chef Cohen.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 370){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Whoever has the highest star rating will win.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 550){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Allowing them to become a Chef Cohen just like me.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 720){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Good luck.", true, false);
            addObject(talkingBubble, 0, 0);
        }
    }
}
