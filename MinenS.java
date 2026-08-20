import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.*;

/**
 * Write a description of class MinenS here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinenS extends ShopVerwalter

{
    /**
     * Act - do whatever the MinenS wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    int kosten;
    Text text;
    boolean c;
    boolean click;
    boolean kaufen;
    Geldverwatung g;
    GrünerHaken<MinenS,Miene> s;
    public MinenS(boolean ce,boolean k){
        kosten = 300;
        text = new Text(Integer.toString(kosten),18);
        click = false;
        c = ce;
        kaufen = k;
        s = new GrünerHaken<MinenS,Miene>(this,new Miene());
    }

    public void addedToWorld(World w){
        if(c != false){
        getWorld().addObject(s,getX()+20,getY()-20);
    }
    }

    public void act()
    {
        mouseclicked();
        mousdragged();
    }

    public void mouseclicked(){

        if(Greenfoot.mouseClicked(this) && Coin.geldanzeigen()-kosten >= 0 && c == false && kaufen == true){
            getWorld().addObject(new MinenS(true,false),500,100);
            Coin.geldminus(kosten);
            click = true;
        }
        else{
            click = false;
        }

    }

    public void show(boolean  bool){
        if(bool == true){
            getWorld().addObject(text,getX()+32,getY()+20);
        }
        if(bool == false){
            getWorld().removeObject(text);

        }
    }   

    void mousdragged(){

        if(getWorld() instanceof ShopWorld && c == true){
            if ((Greenfoot.mouseDragged(this))) {
                MouseInfo mi = Greenfoot.getMouseInfo();
                setLocation(mi.getX(), mi.getY());
                return;
            }
        }
    }

    public boolean clicked(){
        return click;
    }

    public void setMove(boolean ce){
    c = ce;
    }

        

    
}


