import greenfoot.*; 
import java.util.*;
public class lauf extends Actor{
    GreenfootImage body;
    Actor host;

    int angle;
    int winkel;
    SimpleTimer timer;
    double xgeschoss;
    double ygeschoss;
    int radius;
    boolean schießen;
    public lauf(Actor a) {
        host = a;
        getImage().scale(150,100);
        timer = new SimpleTimer();
        angle = 0;
        winkel = 0;
        xgeschoss = 50;
        ygeschoss = 10;
        radius = 75;
        schießen = true;
    }

    public void addedToWorld(World w) {

    }
    public void act() {
        
        if(timer.millisElapsed() > 100 && Greenfoot.isKeyDown("w")){
            winkel --;
            abschusspos(true);
            turn(angle-1);
            timer.mark();
        }

        if(timer.millisElapsed() > 100 && Greenfoot.isKeyDown("s")){
            winkel ++;
            abschusspos(false);
            turn(angle+1);
            timer.mark();

        }
        if(schießen == true){
            if(timer.millisElapsed() > 300 && Greenfoot.isKeyDown("space")){
                kreisposgeschoss();
                getWorld().addObject(new Geschoss(this),getX()+(int)xgeschoss,getY()+ (int)ygeschoss);
                timer.mark();
            }
        }
        if( host.getWorld() != null ) {
            setLocation(host.getX()-15, host.getY()-8);
        } 
        else {
            getWorld().removeObject(this);
        }
    }

    public void schießen(boolean s){
     schießen = s;
    }
    public int winkel(){
        return winkel;
    }

    public void abschusspos(boolean plus){
        if(plus == true){  
            xgeschoss ++;
            ygeschoss ++; 
        }
        else{
            xgeschoss --;
            ygeschoss --;
        }
    }

    public void kreisposgeschoss(){
        xgeschoss =(75* Math.cos(Math.toRadians(winkel)));
        ygeschoss = (75* Math.sin(Math.toRadians(winkel)))+3;
    }

    public int getx(){
        return getX() + (int)xgeschoss;
    }

    public int gety(){
        return getX() + (int)ygeschoss;
    }

    /*private void testeKollision2() {
    List<Actor> enemy = new ArrayList<Actor>();
    enemy = getIntersectingObjects(Actor.class);
    System.out.println("Anzahl berührter Objekte: " +enemy.size());
    for( int i = 0; i < enemy.size(); i++ ) {
    if( enemy.get(i) instanceof ZombieHitBox){
    System.out.println("Eine ZombieHitBox berührt.");
    }
    if( enemy.get(i) instanceof Zombie){
    System.out.println("Die komplette ZombieHitBox berührt");
    }
    if (enemy.get(i) instanceof Kugel && name.equals("Kopf" )){
    getWorld().showText("Von Kugel am Kopf getroffen,",250,50);
    host.setImage("ppl2.png");
    getWorld().removeObject(enemy.get(i));

    }
    }
    }*/
}
