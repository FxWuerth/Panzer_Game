import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class explosionkM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class explosionkM extends explosionM
{
   
   
    int height;
    int width;
    int rotation;
    int timer;
    int speed;

    public explosionkM(){

        height = Greenfoot.getRandomNumber(20);
        width = Greenfoot.getRandomNumber(20);
        rotation = Greenfoot.getRandomNumber(60);
        if(height != 0 && width != 0){
            getImage().scale(width,height);
        }
        else{
            getImage().scale(13,25);
        }
        setRotation(290-rotation);
        
        timer = Greenfoot.getRandomNumber(10);
        speed = Greenfoot.getRandomNumber(10);

    }
    public void act()
    {
        // Add your action code here.

        if(timer <=20 ){
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
