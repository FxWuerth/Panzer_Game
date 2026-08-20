import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kASTEN here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kasten extends Actor
{
    /**
     * Act - do whatever the kASTEN wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor host;
    public Kasten(Actor a){
     GreenfootImage image = new GreenfootImage(25,25);
    image.setColor(Color.BLACK);
    image.drawRect(0, 0, 24, 24);
    host = a;
    setImage(image);
    }
    public void act()
    {
        if(host.getWorld() != null){
        setLocation(host.getX(),host.getY());
        }
        else{
        getWorld().removeObject(this);
        }
        
    }
}
