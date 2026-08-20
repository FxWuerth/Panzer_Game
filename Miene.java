import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Miene here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Miene extends Actor
{
    Coin c;
  
    public int damage;
    public Miene(){
      
        damage = 3;
    }

    public void act()
    {
        // Add your action code here.
        
    if(this.isTouching(Gegner.class)){
            getWorld().addObject(new explosionM(),getX(),getY());
            getWorld().removeObject(this);
        }
    
    mousdragged();
    }

    void mousdragged(){
        if(getWorld() instanceof ShopWorld){
        if ((Greenfoot.mouseDragged(this))) {
            MouseInfo mi = Greenfoot.getMouseInfo();
            setLocation(mi.getX(), mi.getY());
            return;
        }
    }
    }
    public int damage(){
    return damage;
    }
}
