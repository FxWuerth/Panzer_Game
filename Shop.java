import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shop extends Actor
{
    /**
     * Act - do whatever the Shop wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    

    public void act()
    {
        shop();
    }

    public void shop(){
        setImage(new GreenfootImage(300,600));
        GreenfootImage image = getImage();
        image.setColor(Color.BLACK);
        image.drawRect(0,0,300,600);
        image.setColor(Color.GREEN);
        image.fillRect(1,1,300,600);
    }
    
    
    }

