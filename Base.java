import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Base here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Base extends Actor
{
    private double h0 = 0, v0=0,g = 10 ,dt = 0.2;
    int leben;
    Healthbar h1;
    public void addedToWorld(World MyWorld){
        h0 = getY();
        getWorld().addObject(h1,getX(),getY()-50);
    }

    public Base(){
        leben = 10;
        h1 = new Healthbar(this,leben,10,100);
    }

    public void act()
    {
        // Add your action code here.
        h1.setLocation(getX(),getY() -50);
        
        if(this.isTouching(Boden.class)){
            gravity(false);
        }
        else{
            gravity(true);
        }
        if(this.isTouching(GeschossGegner.class)){
         leben =leben - 1;
         h1.looseHealth();
          if(leben == 0){
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

    public void leben(){
        
        if(isTouching(GeschossGegner.class)){
         leben =leben - 1;
          if(leben == 0){
        getWorld().removeObject(this);
        }
        }
        
    }
    
}
