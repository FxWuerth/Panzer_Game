import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GrünerHaken here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GrünerHaken <H extends ShopVerwalter,O extends Actor> extends Actor 
{
    /**
     * Act - do whatever the GrünerHaken wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    H host;
    O add;
    public GrünerHaken(H host,O object){
     getImage().scale(20,20);
     this.host = host;
     this.add = object;
    }
    public void addedToWorld(){
     HitBox h = new HitBox(this,30,30,0,10,true);
     getWorld().addObject(h,getX(),getY());
    }
    public void act()
    {
        if(host.getWorld() != null){
        setLocation(host.getX()+20,host.getY()-20);
        if(Greenfoot.mouseClicked(this)){
        Coin.addObject(add,host.getX(),host.getY());
        host.setMove(false);
        getWorld().removeObject(this);
        }
        }
        else{
         getWorld().removeObject(this);
        }
    }
    public void ObjectToAdd(Actor a){
    
    }
}
