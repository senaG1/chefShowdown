import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The SuperSpeechBubble class is a Greenfoot actor, that inherits from Actor.
 * <p>
 * It will draw Speech bubble of any size depending on the variables passed, and can
 * draw words or show images on the bubbles depending on what is passed.
 * 
 * @author Jordan Cohen, edited by Isabel Powell and Oscar Ho
 * @version Nov. 20 2025
 */
public class SuperSpeechBubble extends Actor
{
    // Static Variables
    private static final String STANDARD_FONT_NAME = "Comic Sans MS";
    private static final int STANDARD_FONT_SIZE = 18;
    private final Font STANDARD_FONT = new Font (STANDARD_FONT_NAME, true, false, STANDARD_FONT_SIZE);
    
    // Class Variables
    private GreenfootImage image;
    private String text;
    private boolean isThought;
    private Actor owner;
    private int offset;
    private boolean autoFit;
    private Font font;
    
    private int offsetX;
    private int offsetY;
    /**
     * Constructor for SuperSpeechBubble - creates a new SuperSpeechBubble.
     * This is called from Customer, and can create words in the bubble.
     * 
     * @param owner    The actor that this bubble should follow
     * @param offset    The distance from the actor to the bubble
     * @param width     The width of the bubble
     * @param height    The height of the bubble
     * @param stemHeight    The height of the stem of the bubble
     * @param stemStart     Where the stem of the bubble will first appear (how far from actor)
     * @param text        The words that will appear in the bubble
     * @param facingRight   Is Actor facing right or left
     * @param isThought     Is the actor speaking or thinking
     */
    public SuperSpeechBubble (Actor owner, int offset, int width, int height, int stemHeight, int stemStart, String text, boolean facingRight, boolean isThought){
        
        font = STANDARD_FONT;
        image = drawBubble (width, height, stemHeight, stemStart, text, facingRight, isThought, true, font);
        setImage(image);
        this.owner = owner;
        this.offset = offset;
        
    }

    /**
     * Second Constructor for SuperSpeechBubble - creates a new SuperSpeechBubble.
     * This is called from Customer, and can create an image in the bubble.
     * 
     * @param owner    The actor that this bubble should follow
     * @param offset    The distance from the actor to the bubble
     * @param width     The width of the bubble
     * @param height    The height of the bubble
     * @param stemHeight    The height of the stem of the bubble
     * @param contentImage  The image that should be placed into the bubble
     * @param facingRight   Is Actor facing right or left
     * @param isThought     Is the actor speaking or thinking
     */
    public SuperSpeechBubble (Actor owner, int offset, int width, int height, int stemHeight, int stemStart, GreenfootImage contentImage, boolean facingRight, boolean isThought){
        
        image = drawBubbleWithImage (width, height, stemHeight, stemStart, contentImage, facingRight, isThought);
        setImage(image);
        this.owner = owner;
        this.offset = offset;
        
    }
    /**
     * Adds object to World
     * 
     * @param w    The World that it will be added to
     * @return void     Will run if called, returns nothings
     */
    public void addedToWorld (World w){
        setLocation (owner.getX(), owner.getY() - offset);
    }
    
    public void act()
    {
        if (owner != null && owner.getWorld() != null)
        {
            setLocation(owner.getX(), owner.getY() - offset);
        }
        else
        {
            if (getWorld() != null)
            {
                getWorld().removeObject(this);
            }
        }
    }
    
    // New method that allows drawing speech bubbles with image instead
    private static GreenfootImage drawBubbleWithImage (int width, int height, int stemHeight, int stemStart, GreenfootImage contentImage, boolean facingRight, boolean isThought){
        GreenfootImage bubble = new GreenfootImage(width, height + stemHeight);
        
        int stemWidth = width / 4;
        // draw the Stem
        int[] xCoords = new int[3];
        int[] yCoords = new int[3];
        xCoords[0] = stemStart;
        yCoords[0] = height/2;
        yCoords[2] = height/2;
        if (facingRight){
            xCoords[1] = stemStart + (stemWidth/2);
            yCoords[1] = stemHeight + height;
            
            xCoords[2] = stemStart + stemWidth;        
        }
        
        // draw the Stem + it's outline
        bubble.setColor (Color.BLACK);
        bubble.drawPolygon (xCoords, yCoords, 3);
        
        // draw the oval + it's outline
        bubble.setColor (Color.BLACK);
        bubble.drawOval (0, 0, width, height);
        
        bubble.setColor (Color.WHITE);
        bubble.fillOval (0, 0, width, height);
        
    
        
        bubble.setColor (Color.WHITE);
        bubble.fillPolygon (xCoords, yCoords, 3);
        
        // Draw the image centered in the bubble
        if (contentImage != null) {
            // Scale the image to fit inside the bubble with some padding
            int padding = 10;
            int maxImageWidth = width - (padding * 2);
            int maxImageHeight = height - (padding * 2);
            
            // Scale image if needed
            GreenfootImage scaledImage = new GreenfootImage(contentImage);
            if (scaledImage.getWidth() > maxImageWidth || scaledImage.getHeight() > maxImageHeight) {
                scaledImage.scale(maxImageWidth, maxImageHeight);
            }
            
            // Center the image in the bubble
            int imageX = (width - scaledImage.getWidth()) / 2;
            int imageY = (height - scaledImage.getHeight()) / 2;
            
            bubble.drawImage(scaledImage, imageX, imageY);
        }
        
        return bubble;
        
    }
    
    private static GreenfootImage drawBubble (int width, int height, int stemHeight, int stemStart, String text, boolean facingRight, boolean isThought, boolean autoFit, Font font){
        GreenfootImage bubble = new GreenfootImage(width, height + stemHeight);
        
        int stemWidth = width / 4;
        // draw the Stem
        int[] xCoords = new int[3];
        int[] yCoords = new int[3];
        xCoords[0] = stemStart;
        yCoords[0] = height/2;
        yCoords[2] = height/2;
        if (facingRight){
            xCoords[1] = stemStart + (stemWidth/2);
            yCoords[1] = stemHeight + height;
            
            xCoords[2] = stemStart + stemWidth;        
        }
        
        // draw the Stem + it's outline
        
        
        bubble.setColor (Color.BLACK);
        bubble.drawPolygon (xCoords, yCoords, 3);
        
        // draw the oval + it's outline
        bubble.setColor (Color.BLACK);
        bubble.drawOval (0, 0, width, height);
        
        bubble.setColor (Color.WHITE);
        bubble.fillOval (0, 0, width, height);
        
        bubble.setColor (Color.WHITE);
        bubble.fillPolygon (xCoords, yCoords, 3);
        
        // Draw Text
        bubble.setFont (font);
        //Code below was added 
        bubble.setColor(Color.BLACK);
        //Image of text
        GreenfootImage textImage = new GreenfootImage(text, font.getSize(), Color.BLACK, new Color(0,0, 0, 0));
        
        int textX = (width - textImage.getWidth())/2;
        int textY = (height - textImage.getHeight())/2;
        
        bubble.drawImage(textImage, textX, textY);
        
        
        return bubble;
    }
}
