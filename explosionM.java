import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosionM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class explosionM extends Actor
{
    int number;
    SimpleTimer timertod;
    int zähler;
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public explosionM(){
        getImage().scale(30,30);
      
        timertod = new SimpleTimer();
        number = 0;
        zähler = 0;
    }

    public void act()
    {
        // Add your action code here.

     if(number == 0){
            animation();
            number ++;
            if(timertod.millisElapsed() <1000){
            getWorld().removeObject(this);
            timertod.mark();
        }
        }
     
    }

    public void animation(){
        for(int i = 0; i<= 40;i ++){
            getWorld().addObject(new explosionkM(),getX(),getY());
        }
        
    }
}

