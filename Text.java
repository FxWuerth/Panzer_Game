import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Text here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Text extends Actor
{
    /**
     * Act - do whatever the Text wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    Font stringFont;
    boolean clicked;
    Loading l;
    SimpleTimer timer;
    public Text(String text,int size)
    {
        GreenfootImage gi= new greenfoot.GreenfootImage(100,30);
        gi.setColor(Color.WHITE);
        stringFont = new Font( "SansSerif",size);
        gi.setFont(stringFont);
        gi.drawString(text,3,30);
        clicked = false;
        setImage(gi);
        l = new Loading();
        timer = new SimpleTimer();
    }

    public void act()
    {
        // Add your action code here.
        clicked();
    }

    public void clicked(){
        if(Greenfoot.mouseClicked(this) && timer.millisElapsed() < 3000){
            clicked = true;
        }
        else{
        timer.mark();
        }
    }

    public boolean click(){
        return clicked;
    }

    public void loading_Animation(){
        if(clicked == true){
            getWorld().addObject(l,210,440);
        }
        if(timer.millisElapsed() > 3000 && clicked == true){
            getWorld().removeObject(this);
            timer.mark();
        }
    }
}
