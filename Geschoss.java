import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Geschoss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Geschoss extends Actor
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
    lauf l;
    int winkel;
    int x;
    int y;
    int damage;
    public Geschoss(lauf lau){
        getImage().scale(20,20);
        speed = 7;
        v0 = 20;
        g = 9.8;
        t = 0;
        l = lau;
        timer = new SimpleTimer();
        turn(-85);
        damage = 1;
    }

    public void act()
    {   
        if(isTouching(Gebäude.class)== true|| isTouching(Gegner.class)){
            getWorld().addObject(new Explosion(15),getX(),getY());
            if(timer.millisElapsed() >20){
                getWorld().removeObject(this);
                timer.mark();
            }
        }
        else{
            winkel = l.winkel() *(-1)+7;
            schießen(winkel);
            if(isTouching(Shop.class) || getY() > 527){
         getWorld().removeObject(this);
        }
        }
        
        
    }

    public void schießen(int i){
        angle = i;
        x = (int) (v0 * t * Math.cos(Math.toRadians(angle)));
        y = (int) (v0 * t * Math.sin(Math.toRadians(angle)) - 0.5 * g * t * t);
        setLocation(getX() +x,getY()-y);
        
        t += 0.1;
    }

    public void ausrichtung(){
        double b = Math.sqrt(Math.pow(((double)l.getx()+(double)x)-((double)l.getx()), 2) + Math.pow(((double)l.gety() +(double)y)-((double)l.getx()) , 2));
        double c = getX() -l.getx();
        double abschusswinkel = Math.cos(b/c);
        turn((int)abschusswinkel);
    }
    public int damage(){
      return damage;
     }
}
