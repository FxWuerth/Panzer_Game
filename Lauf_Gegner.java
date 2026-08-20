import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lauf_Gegner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lauf_Gegner extends Actor
{
    /**
     * Act - do whatever the Lauf_Gegner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Actor Host;
    int winkel;
    double xgeschoss;
    double ygeschoss;
    SimpleTimer timer;
    boolean schiesen;
    public Lauf_Gegner(Actor a){
        Host = a;
        getImage().scale(80,60);
        winkel = -10;
        xgeschoss = 50;
        ygeschoss = 10;
        timer = new SimpleTimer();
        turn(winkel *(-1));
        schiesen = true;
    }

    public void act()
    {
        if(schiesen == true){
            if(timer.millisElapsed() > 1000){
                getWorld().addObject(new GeschossGegner(this),getX()-(int)ygeschoss-20,getY()-(int)ygeschoss+7);
                timer.mark();
            }
        }
        if(isTouching(Shop.class)){
            schießen(false);
        }
        else{
            schießen(true);

        }
         if(Host.getWorld() != null){
            setLocation(Host.getX()-7, Host.getY()-8);
        }
        else{
            getWorld().removeObject(this);
        }
    }

    public void kreisposgeschoss(){
        xgeschoss =(75* Math.cos(Math.toRadians(winkel)));
        ygeschoss = (75* Math.sin(Math.toRadians(winkel)))+3;
    }

    public int winkel(){
        return winkel;
    }

    public void schießen(boolean schi){
        if(schi == false){
            schiesen = false;
        }
        else{
            schiesen = true;
        }
    }
}