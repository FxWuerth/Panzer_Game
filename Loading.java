import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Loading here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loading extends Actor
{
    /**
     * Act - do whatever the Loading wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int rotation;

    public Loading(){
        getImage().scale(40,40);

    }

    public void act()
    {
        // Add your action code here.

        rotation = rotation +3;
        setRotation(rotation);
        if(rotation > 360){
            rotation = 0;
        }

        getWorld().removeObject(this);
    }
}
