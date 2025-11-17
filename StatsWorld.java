import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatsWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatsWorld extends World
{
    private GreenfootImage background;
    private int leftTeamCash;
    private int rightTeamCash;
    private double leftTeamRating;
    private double rightTeamRating;
    
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
        addObject(screen, 480, 300);
        screen.callAction();
        
        Label gameOverLabel = new Label("Game Over!", 30);
        Label leftCashLabel = new Label("Blue Team Cash: $" + leftTeamCash, 30);
        Label leftRatingLabel = new Label("Blue Team Rating: " + String.format("%.2f", leftTeamRating) + " Stars", 30);
        Label rightCashLabel = new Label("Red Team Cash: $" + rightTeamCash, 30);
        Label rightRatingLabel = new Label("Red Team Rating: " + String.format("%.2f", rightTeamRating) + " Stars", 30);
        
        addObject(gameOverLabel, 960 / 2, 150);
        addObject(leftCashLabel, 960 / 2, 220);
        addObject(leftRatingLabel, 960 / 2, 270);
        addObject(rightCashLabel, 960 / 2, 350);
        addObject(rightRatingLabel, 960 / 2, 400);
    }
    
    public int getLeftTeamCash() {
        return leftTeamCash;
    }
    
    public int getRightTeamCash() {
        return rightTeamCash;
    }
    
    public double getLeftTeamRating() {
        return leftTeamRating;
    }
    
    public double getRightTeamRating() {
        return rightTeamRating;
    }
}
    
