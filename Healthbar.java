import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Healthbar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Healthbar extends Actor
{
    int health;
    int width;
    int height;
    int pixelsperhealthPoint;
    SimpleTimer timer;
    Actor host;
    public Healthbar(Actor ac,int hel,int h,int w){
        height = h;
        width = w;
        health = hel;
        pixelsperhealthPoint = (int)width /(int) health;
        update();
        timer = new SimpleTimer();
        host = ac;
    }

    public void act()
    {
        // Add your action code here.
        if(host.getWorld() != null){
        if(health == 0){
            getWorld().removeObject(this);
        }
        else{
            if(timer.millisElapsed() > 50){
                update();
            }
        }
    }
    else{
    getWorld().removeObject(this);
    }
    }

    public void sethealth(int i){
        health = i;
    }

    public void update(){
        setImage(new GreenfootImage(width +2,height +2));
        GreenfootImage image = getImage();
        image.setColor(Color.WHITE);
        image.drawRect(0,0,width +1,height +1);
        image.setColor(Color.RED);
        image.fillRect(1,1,health*pixelsperhealthPoint,height);
    }

    public void looseHealth(){
        health --;
    }
}
