import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The EndingWorld class is a Greenfoot World.
 * <p>
 * When added, it will begin to display textboxes, created by SuperSpeechBubble.
 * Will have images called from Cohen Class
 * 
 * @author Isabel Powel
 * @version 1 Nov. 19 2025
 */
public class EndingWorld extends World
{
    private GreenfootImage background;
    private int timer = 0;
    private String imageColour;

    private Cohen goldenCohen;
    private Cohen redCohen;
    private Cohen blueCohen;

    private int leftCash;
    private double rightRating;
    private int rightCash;
    private double leftRating;
    
    //Speech bubbles
    private SuperSpeechBubble talkingBubble;
    private SuperSpeechBubble secondBubble;

    //Win/lose varibles
    private Cohen winCohen;
    private Cohen loseCohen;
    private String winner;
    //Checks if the players tied
    private boolean tie = false;

    /**
     * Constructor for EndingWorld - creates a new EndingWorld.
     * This is called from Restaurant World.
     * 
     * @param leftCash     Amount of cash Blue team has
     * @param leftRating    Amount of stars blue team has
     * @param rightCash       amount of cash Red team has
     * @param rightRating     amount of stars Red team has
     */
    public EndingWorld(int leftCash, int rightCash, double leftRating, double rightRating)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(960, 640, 1);

        this.leftCash = leftCash;
        this.rightCash = rightCash;
        this.leftRating = leftRating;
        this.rightRating = rightRating;

        background = new GreenfootImage("end_Bg.png");
        setBackground(background);

        goldenCohen = new Cohen("golden_Cohen.PNG", true);
        redCohen = new Cohen("red_Cohen.PNG", false);
        blueCohen = new Cohen("blue_Cohen.PNG", false);

        addObject(goldenCohen, 178, 444);
        addObject(redCohen, 490, 398);
        addObject(blueCohen, 743, 398);

        findWiner();

        timer = 0;
        conversation();
        //SoundManager.playEndGame();
        prepare();
    }

    public void act(){
        timer++;
        conversation();
    }
    
    private void conversation(){
        if(talkingBubble != null && talkingBubble.getWorld() != null && timer%180 == 0){
            removeObject(talkingBubble);
        }
        
        if(secondBubble != null && secondBubble.getWorld() != null && timer%180 == 0){
            removeObject(secondBubble);
        }
        
        if(tie){
            tieConversation();
        }
        else{
            winConversation();
        }
        
    }
    
    private void tieConversation(){
        
        if(timer == 0){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, " Both players fought long and hard.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 190){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "But only one can win this challenge.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 370){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Will it be Red Cohen or Blue Cohen?", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 550){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "The winner is…", true, false);
            addObject(talkingBubble, 0, 0);
        }
        //This is TIE
        if(timer == 720){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "both, just kidding, you guys will share this hat", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 920){
            talkingBubble = new SuperSpeechBubble(blueCohen, 200, 400, 80, 30, 60, "Yay!! I WON! ", true, false);
            addObject(talkingBubble, 0, 0);
            blueCohen.switchImage("happy_Blue.png");
            
        }
        
        if(timer == 1100){
            secondBubble = new SuperSpeechBubble(redCohen, 200, 400, 80, 30, 60, "You mean WE won, right? ", true, false);
            addObject(secondBubble, 0, 0);
            redCohen.switchImage("happy_Red.png");
        }
        
        if(timer == 1280){
            
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Take this hat and split it into Two pieces.", true, false);
            addObject(talkingBubble, 0, 0);
            goldenCohen.switchImage("golden_Hat.png");
        }
        //This IS TIE
        if(timer == 1460){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Become the half Cohens you were meant to be!", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 1640){
            talkingBubble = new SuperSpeechBubble(blueCohen, 200, 400, 80, 30, 60, " Thank you, Master Chef Cohen!", true, false);
            addObject(talkingBubble, 0, 0);
            secondBubble = new SuperSpeechBubble(redCohen, 200, 400, 80, 30, 60, "Thank you, Master Chef Cohen!", true, false);
            addObject(secondBubble, 0, 0);
        }

        if(timer == 1820){
            Greenfoot.setWorld(new StatsWorld(leftCash, rightCash, leftRating, rightRating));
        }
    }
    
    private void winConversation(){

        if(timer == 0){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, " Both players fought long and hard.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        
        if(timer == 190){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "But Only one can win this challenge.", true, false);
            addObject(talkingBubble, 0, 0);
        }
        //THIS IS WIN
        if(timer == 370){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Will it be Red Cohen or Blue Cohen?", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 550){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "The winner is…", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 720){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, winner, true, false);
            addObject(talkingBubble, 0, 0);
            winCohen.switchImage(imageColour);
            
        }

        if(timer == 920){
            
            talkingBubble = new SuperSpeechBubble(winCohen, 200, 400, 80, 30, 60, "Yay!! OF COURSE I WON! ", true, false);
            addObject(talkingBubble, 0, 0);
        }
        //THIS IS WIN
        if(timer == 1100){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Take this hat. It’s yours now.", true, false);
            addObject(talkingBubble, 0, 0);
            goldenCohen.switchImage("golden_Hat.png");
        }

        if(timer == 1280){
            talkingBubble = new SuperSpeechBubble(goldenCohen, 200, 400, 80, 30, 60, "Become the Cohen you were meant to be!", true, false);
            addObject(talkingBubble, 0, 0);
        }
        //THIS IS WIN
        if(timer == 1460){
            talkingBubble = new SuperSpeechBubble(winCohen, 200, 400, 80, 30, 60, " Thank you, Master Chef Cohen!", true, false);
            addObject(talkingBubble, 0, 0);
        }

        if(timer == 1640){
            Greenfoot.setWorld(new StatsWorld(leftCash, rightCash, leftRating, rightRating));
        }

        //redCohen.callAction();
    }
    //Finds winner based on rating score
    private void findWiner(){
        if(rightRating > leftRating){
            winner = "Red";
            winCohen = redCohen;
            loseCohen = blueCohen;
            imageColour = "happy_Red.png";
        }
        else if(leftRating > rightRating){
            winner = "Blue";
            winCohen = blueCohen;
            loseCohen = redCohen;
            imageColour = "happy_Blue.png";
        }
        else{
            winner = "Tie";
            tie = true;
            winCohen = blueCohen;
            loseCohen = redCohen;
            imageColour = "happy_Blue.png";
        }
    }

    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
