import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosionk here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class explosionk extends Actor
{
    /**
     * Act - do whatever the explosionk wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int height;
    int width;
    int rotation;
    int timer;
    int speed;
    int timer_max;
    public explosionk(int t){

        height = Greenfoot.getRandomNumber(20);
        width = Greenfoot.getRandomNumber(20);
        rotation = Greenfoot.getRandomNumber(360);
        if(height != 0 && width != 0){
            getImage().scale(width,height);
        }
        else{
            getImage().scale(13,25);
        }
        setRotation(rotation);
        
        timer = Greenfoot.getRandomNumber(10);
        speed = Greenfoot.getRandomNumber(10);
        timer_max = t;
    }
    public void act()
    {
        // Add your action code here.

        if(timer <=timer_max ){
            if(speed < 5){
                move(speed);
            }
            else{

                move(5);
            }
            timer ++;
        }
        else{
            getWorld().removeObject(this);
        }
    }
}
