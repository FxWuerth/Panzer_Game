import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayWorld extends World
{
    Coin c;
    /**
     * Constructor for objects of class PlayWorld.
     * 
     */
    public PlayWorld(Coin co)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(1000, 600, 1); 
        c = co;
        setBackground("images/b.jpg");
        addObject(new Geschütz(),100,300);
        //addObject(new Gebäude(),500,100);
        addObject(new Boden(), 500,550);
        addObject(new Gegner(),900,500);
        addObject(new Base(),75,100);
        addObject(c, 900,30);
    }
    
}
