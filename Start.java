import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start extends Actor
{
    private MyWorld world;
    public Start(){
      GreenfootImage image = new GreenfootImage("UI/start.png");
      image.scale( 120, 130);
      setImage(image);
    } 
    
    protected void addedToWorld( World world){
      this.world = (MyWorld) world;
    }
    
    public void act(){
      if( Greenfoot.mouseClicked(this) ){
          Greenfoot.playSound("allSound/General Sounds/Menu Sounds/sfx_menu_select4.wav");
          world.restart();
          world.removeObject(this);
      }
    }    
}
