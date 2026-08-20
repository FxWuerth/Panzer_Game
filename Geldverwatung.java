import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Geldverwatung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Geldverwatung extends Actor
{
    /**
     * Act - do whatever the Geldverwatung wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int Geld;
    Coin c;
   
    public Geldverwatung(Coin ce){
      c = ce;
      Geld = c.geldanzeigen();
    }
    public void act()
    {
        // Add your action code here.
        Geld = c.geldanzeigen();
    }
    

    public void geldverwaltung(int geldä,boolean plus){
        if(plus == true){
            c.geldplus(geldä);
        }
        if(plus == false && Geld - geldä > 0){
            c.geldminus(geldä);
        }
    }
    public int geld(){
      return c.geldanzeigen();
    }
}
