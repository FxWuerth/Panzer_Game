import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    /**
     * Act - do whatever the Coin wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private static int Geld;
    Shop s;
    boolean showshop; 
    MinenS m;
    SimpleTimer timer;
    World w;
    private static  ArrayList<Actor> Gekauft;
    private static ArrayList<Integer> x;
    private static ArrayList<Integer> y;
    
    public Coin(){
        getImage().scale(30,30);
        Geld = 1000;
        s = new Shop();
        showshop = false;
        Gekauft = new ArrayList<Actor>();
        x = new ArrayList<Integer>();    
        y = new ArrayList<Integer>();    
        timer = new SimpleTimer();

    }

    public void act()
    {
        getWorld().showText(Integer.toString(Geld),getX() +50,getY());
        if(Greenfoot.mousePressed(this)){
            
            if(getWorld() instanceof ShopWorld){
               
              Greenfoot.setWorld(new PlayWorld(this));
              placeOnWorld();
            }
            
           else if(getWorld() instanceof PlayWorld){
                
                Greenfoot.setWorld(new ShopWorld(this));
        }
        }
        if(getWorld() instanceof PlayWorld){
            if(timer.millisElapsed() > 100){
                geldplus(1);
                timer.mark();
            }
        }
    }

    public static void geldminus(int geldä){
        if(Geld - geldä > 0){

            Geld = Geld - geldä;
        }
    }

    public static void geldplus(int geldä){
        Geld = Geld + geldä;
    }

    public static void addObject(Actor a,int xn,int yn){
        Gekauft.add(a);
        x.add(xn);
        y.add(yn);
    }

    public  void placeOnWorld(){
        for(int i = 0; i < Gekauft.size();i++){
            getWorld().addObject(Gekauft.get(i),x.get(i),y.get(i));
           
        }
        Gekauft.clear();
        x.clear();
        y.clear();
    }

    public static int geldanzeigen(){
        return Geld;
    }

    public void changeWorld(){

    }
}
/*if( showshop == false){
getWorld().addObject(s,850,300);
getWorld().setPaintOrder(Coin.class);
showshop = true;
angebote_Anzeigen();
}
else{
getWorld().removeObject(s);
angebote_löschen();
showshop = false;
}*/