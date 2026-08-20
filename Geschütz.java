import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Geschütz here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Geschütz extends Actor
{
    /**
     * Act - do whatever the Geschütz wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    SimpleTimer timer;
    lauf l1;
    int speedx;
    private double h0 = 0, v0=0,g = 10 ,dt = 0.2;
    int leben;
    Healthbar he1;
     int explosionx;
    int explosiony;
    int ex_größe;
    Text text;
    int repairkosten;
    Base b;
    Coin c;
    public void addedToWorld(World w) {
        l1 = new lauf(this);//Kopf
        getWorld().addObject(l1, getX()-15, getY()-12);
        h0 = getY();
        getWorld().addObject(he1,getX(),getY()-30);
        
    }

    public Geschütz(){
        getImage().scale(80,45);
        timer = new SimpleTimer();
        speedx = 0;
        leben = 10;
        he1 = new Healthbar(this,leben, 5,50);
        explosionx = Greenfoot.getRandomNumber(50);
        explosiony = Greenfoot.getRandomNumber(50);
        ex_größe = Greenfoot.getRandomNumber(25);
        if(ex_größe < 10){
          ex_größe = 15;
        }
        repairkosten = 200;
        text = new Text(Integer.toString(repairkosten),30);
        b = new Base();
      
    }

    public void act()
    {
      

        he1.setLocation(getX(),getY()-30);
        if(Greenfoot.isKeyDown("D")){
            speedx = 1;
            setLocation(getX() + speedx,getY());
        } 
        if(Greenfoot.isKeyDown("A")){
            speedx = -1;
            setLocation(getX() + speedx,getY());
        }
      
        if(this.isTouching(Boden.class)){
            gravity(false);
        }
        else{
            gravity(true);
        }

        repair();
        if(this.isTouching(Gegner.class)){
        leben = 0;
        }
        if(this.isTouching(GeschossGegner.class)){
            leben = leben -1;
            he1.looseHealth();

        }
        else{
            if(leben==0){
                getWorld().addObject(new Explosion(ex_größe),getX()+explosionx,getY()+explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()+explosionx,getY()-explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()-explosionx,getY()-explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX()-explosionx,getY()+explosiony);
                getWorld().addObject(new Explosion(ex_größe),getX(),getY());
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

    public void repair(){
        if(this.isTouching(Base.class) == true){
            getWorld().addObject(text,180,440);
            text.loading_Animation();
            if(timer.millisElapsed() > 3000 && text.click() == true){
                leben ++;
                he1.sethealth(leben);
               
                timer.mark();
            }
            l1.schießen(false);
        }
        if(this.isTouching(Base.class) != true){
            l1.schießen(true);
            
            getWorld().removeObject(text);
        }

    }
}

