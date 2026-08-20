import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Kreuz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kreuz extends Actor
{
    /**
     * Act - do whatever the Kreuz wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Kreuz(){
    setImage(new GreenfootImage(30,30));
        GreenfootImage image = getImage();
        image.setColor(Color.BLACK);
        image.drawRect(0,0,30,30);
        image.fillRect(1, 1, 30, 30);
    
    
    }
    public void act()
    {
        // Add your action code here.
        
    }
}
