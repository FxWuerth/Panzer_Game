import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;

/**
 * Write a description of class Gegner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gegner extends Actor
{
    /**
     * Act - do whatever the Gegner wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private double h0 = 0, v0=0,g = 10 ,dt = 0.2;
    Lauf_Gegner l;
    int speed;
    int leben;
    Healthbar h1;
    boolean bew;
    int explosionx;
    int explosiony;
    int ex_größe;
    Geldverwatung ge;
    boolean IsWand;
    public void addedToWorld(World w) {
        l = new Lauf_Gegner(this);
        getWorld().addObject(l,getX()-7,getY()-8);
        getWorld().addObject(h1,getX(),getY()-30);
        h0 = getY();
        speed = 1;
        bew = true;
        
    }

    public Gegner(){
        getImage().scale(60,60);
        leben = 10;
        h1 = new Healthbar(this,leben ,5,50);
         explosionx = Greenfoot.getRandomNumber(50);
        explosiony = Greenfoot.getRandomNumber(50);
        ex_größe = Greenfoot.getRandomNumber(25);
        if(ex_größe < 10){
          ex_größe = 15;
        }
         
    }

    public void act()
    {
        h1.setLocation(getX(),getY() -30);
        checkneighbours();
        IsWand = getObjectsInRange(200, Wand.class).size() > 0;
        if(this.isTouching(Boden.class)){
            gravity(false);
        }
        else{
            gravity(true);
        }
        
        if(isTouching(Geschoss.class) == true){
            leben --;
            h1.looseHealth();
            
        }
        
        if(isTouching(Miene.class) == true){
                leben = leben -3;
                h1.looseHealth();
                h1.looseHealth();
                h1.looseHealth();
                            }
        else{
            if(leben <= 0){
                getWorld().addObject(new Explosion(ex_größe),getX()+explosionx,getY()+explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()+explosionx,getY()-explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()-explosionx,getY()-explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()-explosionx,getY()+explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX(),getY());
                Coin.geldplus(300);
                getWorld().removeObject(this);
            }
        }
        
    }

    public void gravity(boolean grav){
        if(grav == true){
            if(getY()<(getWorld().getHeight())){
                double ht = h0+v0*dt+0.5*g*dt*dt;
                v0+=g*dt;
                setLocation(getX(),(int)ht);
                h0=ht;
            }
        }
    }
    public void bewegen(boolean bew){
    if(bew == true){
    setLocation(getX() -speed, getY());
    }
    
    }
    public void checkneighbours(){
    
       
    if (IsWand == true){
                 bewegen(false);
                 System.out.println("Funktioniert");
        }
        else{
        bewegen(true);
        }
    
    }
   
}
