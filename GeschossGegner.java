import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Geschoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GeschossGegner extends Actor
{
    /**
     * Act - do whatever the Geschoss wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed;
    int v0;
    int angle;
    double g;
    double t;
    SimpleTimer timer;
    Lauf_Gegner l;
    int winkel;
    int x;
    int y;
    public GeschossGegner(Lauf_Gegner lau){
        getImage().scale(20,20);
        speed = 7;
        v0 = 20;
        g = 9.8;
        t = 0;
        l = lau;
        timer = new SimpleTimer();
        turn(105);
    }

    public void act()
    {   
        if(isTouching(Base.class) == true || isTouching(Gebäude.class)== true|| isTouching(Geschütz.class) == true|| isTouching(Wand.class) == true){
                getWorld().addObject(new Explosion(15),getX(),getY());
                if(timer.millisElapsed() >20){
                getWorld().removeObject(this);
                timer.mark();
                }
        }
       else{ 
        winkel = l.winkel() *(-1)+7;
        schießen(winkel);
        
        if(getX() < 10){
                getWorld().removeObject(this);
            }
        }
        
    }

    public void schießen(int i){
        angle = i;
        x = (int) (v0 * t * Math.cos(Math.toRadians(angle)));
        y = (int) (v0 * t * Math.sin(Math.toRadians(angle)) - 0.5 * g * t * t);
        setLocation(getX() -x,getY()-y);
        t += 0.1;
    }

    public void treffer(){

        if(this.isTouching(Base.class)){

            if(timer.millisElapsed() >= 50){
                getWorld().addObject(new Explosion(15),getX(),getY());
                timer. mark();
            }
            getWorld().removeObject(this);
        }
    }
}
