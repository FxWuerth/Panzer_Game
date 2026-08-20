import greenfoot.*; 
import java.util.*;
public class HitBox extends Actor{
    GreenfootImage body;
    int offsetX;
    int offsetY;
    Actor host;
   

    public HitBox(Actor a, int w, int h, int dx, int dy, boolean visible) {
        host = a;
        offsetX = dx;
        offsetY = dy;
        body = new GreenfootImage(w, h);
        if(visible) {
            body.setColor(Color.RED);
            body.setTransparency(80);
            body.fill();
        }
        setImage(body);
        
    }

    public void act() {
       //zuerst Kollision testen!
        if( host.getWorld() != null ) {
            setLocation(host.getX()+offsetX, host.getY()+offsetY);
        } 
        else {
            getWorld().removeObject(this);
        }

    }

    
}
