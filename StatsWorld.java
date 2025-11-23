import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatsWorld here.
 * 
 * @author Oscar Ho 
 * @version 11-22
 */
public class StatsWorld extends World
{
    private GreenfootImage background;
    private int leftTeamCash;
    private int rightTeamCash;
    private double leftTeamRating;
    private double rightTeamRating;
    
    /**
     * Constructor for StatsWorld - creates a new StatsWorld
     * This is called from EndingWorld
     * 
     * @param leftCash  Amount of cash Blue team has
     * @param rightCash Amount of cash Red team has
     * @param leftRating   End rating for Blue team
     * @param rightRating   End rating for Red team
     */
    public StatsWorld(int leftCash, int rightCash, double leftRating, double rightRating) {    
        super(960, 640, 1); 
        
        // Store the team stats
        this.leftTeamCash = leftCash;
        this.rightTeamCash = rightCash;
        this.leftTeamRating = leftRating;
        this.rightTeamRating = rightRating;
        
        prepare();
    }
    
    // will change later depending on image given
    private void prepare() {
        background = new GreenfootImage("bg_stat.png");
        setBackground(background);
        StatScreen screen = new StatScreen("blueStat.png", 320);
        addObject(screen, 480, 320);
        screen.callAction();
        
        GreenfootImage poster = new GreenfootImage("jesuspixel.png");
        poster.scale(45, 62);
        background.drawImage(poster, 694 , 209);
        
        Label gameOverLabel = new Label("Game Over!", 30);
        Label leftCashLabel = new Label("Blue Team Cash: $" + leftTeamCash, 30);
        Label leftRatingLabel = new Label("Blue Team Rating: " + String.format("%.2f", leftTeamRating) + " Stars", 30);
        Label rightCashLabel = new Label("Red Team Cash: $" + rightTeamCash, 30);
        Label rightRatingLabel = new Label("Red Team Rating: " + String.format("%.2f", rightTeamRating) + " Stars", 30);
        
        addObject(gameOverLabel, 960 / 2, 180);
        addObject(leftCashLabel, 960 / 2, 250);
        addObject(leftRatingLabel, 960 / 2, 300);
        addObject(rightCashLabel, 960 / 2, 380);
        addObject(rightRatingLabel, 960 / 2, 430);
    }
    
    /**
     * Returns Blue team cash
     * @return int Blue team cash
     */
    public int getLeftTeamCash() {
        return leftTeamCash;
    }
    
    /**
     * Returns Red team cash
     * @return int Red team cash
     */
    public int getRightTeamCash() {
        return rightTeamCash;
    }
    
    /**
     * Returns Blue team rating
     * @return double Blue team rating
     */
    public double getLeftTeamRating() {
        return leftTeamRating;
    }
    
    /**
     * Returns Red team rating
     * @return double Red team rating
     */
    public double getRightTeamRating() {
        return rightTeamRating;
    }
}
    
