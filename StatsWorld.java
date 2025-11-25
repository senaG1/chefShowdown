import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The StatsWorld displays the final data of both restaurants at the end of the simulation.
 * 
 * @author Oscar Ho 
 * @version 11-22
 */
public class StatsWorld extends World
{
    protected GreenfootImage background;
    protected int leftTeamCash;
    protected int rightTeamCash;
    protected double leftTeamRating;
    protected double rightTeamRating;
    protected Font statFont;
    
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
        statFont = new Font("Times New Roman", false, false, 30);
        setPaintOrder(TextDisplay.class, StatScreen.class);
        
        prepare();
    }
    
    // will change later depending on image given
    private void prepare() {

        background = new GreenfootImage("bg_stat.png");
        setBackground(background);
        GreenfootImage poster = new GreenfootImage("jesuspixel.png");
        poster.scale(45, 62);
        background.drawImage(poster, 694 , 209);
        
        StatScreen screen = new StatScreen("blueStat.png", 320);
        addObject(screen, 480, 320);
        screen.callAction();
        
        String[] textLines = {
        "Game Over!",
        "Blue Team Cash: $" + leftTeamCash,
        "Blue Team Rating: " + String.format("%.2f", leftTeamRating) + " Stars",
        "Red Team Cash: $" + rightTeamCash,
        "Red Team Rating: " + String.format("%.2f", rightTeamRating) + " Stars"
        };
        TextDisplay textDisplay = new TextDisplay(textLines, statFont, Color.BLACK, 960, 640);
        addObject(textDisplay, 480, 320);
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
    
