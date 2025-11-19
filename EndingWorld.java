import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EndingWorld here.
 * 
 * @author Isabel Powel
 * @version (a version number or a date)
 */
public class EndingWorld extends World
{
    private GreenfootImage background;
    protected SuperSpeechBubble talkingBubble;
    private int timer = 0;
    
    
    private Cohen goldenCohen;
    private Cohen redCohen;
    private Cohen blueCohen;
    
    private int leftCash;
    private double rightRating;
    private int rightCash;
    private double leftRating;
    
    //Win/lose varibles
    private Cohen winCohen;
    private Cohen loseCohen;
    private String winner;
    
    /**
     * Constructor for objects of class EndingWorld.
     * 
     */
    public EndingWorld(int leftCash, int rightCash, double leftRating, double rightRating)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);
        
        this.leftCash = leftCash;
        this.rightCash = rightCash;
        this.leftRating = leftRating;
        this.rightRating = rightRating;
        
        background = new GreenfootImage("story_Background.jpg");
        setBackground(background);
        
        goldenCohen = new Cohen("golden_Cohen.PNG", true);
        redCohen = new Cohen("red_Cohen.PNG", false);
        blueCohen = new Cohen("blue_Cohen.PNG", false);
        
        addObject(goldenCohen, 178, 444);
        addObject(redCohen, 743, 398);
        addObject(blueCohen, 900, 398);
        
        findWiner();
        
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
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, " Both players fought long and hard. Only one can win this challenge.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 190){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Will it be Red Cohen or Blue Cohen?", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 370){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "The winner is…", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 550){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Blue ", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 720){
            
            talkingBubble = new SuperSpeechBubble(winCohen, 200, 400, 80, 30, 60, "Yay!! OF COURSE I WON! ", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 920){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Take this hat. It’s yours now.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 1100){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Become the Cohen you were meant to be!", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
         if(timer == 1280){
            talkingBubble = new SuperSpeechBubble(blueCohen, 200, 400, 80, 30, 60, " Thank you, Master Chef Cohen!", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 1460){
            Greenfoot.setWorld(new StatsWorld(leftCash, rightCash, leftRating, rightRating));
        }
        
       
        //redCohen.callAction();
        
    }
    //Finds winner based on rating score
    private void findWiner(){
        if(rightRating > leftRating){
            winner = "Blue";
            winCohen = blueCohen;
            loseCohen = redCohen;
        }
        else if(leftRating > rightRating){
            winner = "Red";
            winCohen = redCohen;
            loseCohen = blueCohen;
        }
    }
    
    
    
}
