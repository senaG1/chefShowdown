import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Displays text (Used mainly for StatsWorld)
 * 
 * @author Oscar Ho 
 * @version 24-11
 */
public class TextDisplay extends Actor
{
    /**
     * Builds new text display
     * @param lines Array of String texts
     * @param font Font text is written in
     * @param color Color text is written in
     * @param width width of display
     * @param length length of display
     */
    public TextDisplay(String[] lines, Font font, Color color, int width, int height)
    {
        GreenfootImage img = new GreenfootImage(width, height);
        img.setColor(new Color(0, 0, 0, 0));
        img.fill();
        
        img.setFont(font);
        img.setColor(color);
        
        int lineSpacing = 60;
        int totalHeight = lines.length * lineSpacing;
        int startY = ((height - totalHeight) / 2 + font.getSize()) - 25;
    
        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            GreenfootImage textImg = new GreenfootImage(line, font.getSize(), color, new Color(0, 0, 0, 0));
            int x = (width - textImg.getWidth()) / 2;
            int y = startY + (i * lineSpacing);
            img.drawImage(textImg, x, y);
        }
        
        setImage(img);
    }
}
