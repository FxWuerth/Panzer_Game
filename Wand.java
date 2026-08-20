import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wand here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wand extends Actor
{
    /**
     * Act - do whatever the Wand wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int leben;
    Healthbar h;
    public Wand(){
    getImage().scale(30,60);
    leben = 5;
    h = new Healthbar(this,leben,5,30);
    }
    public void addedToWorld(World w){
    getWorld().addObject(h,getX(),getY()-45);
    }
    public void act()
    {
        // Add your action code here.
        h.setLocation(getX(),getY() -45);
        if(this.isTouching(GeschossGegner.class)){
        leben --;
        h.looseHealth();
        }
        if(leben == 0){
        getWorld().removeObject(this);
        }
    }
}
