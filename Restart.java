import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Restart here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Restart extends Actor
{
    private MyWorld world;
    public Restart(){
      GreenfootImage image = new GreenfootImage("UI/restart.png");
      image.scale( 60, 60);
      setImage(image);
    } 
    
    protected void addedToWorld( World world){
      this.world = (MyWorld) world;
    }
    
    public void act(){
      if( Greenfoot.mouseClicked(this) ){
          Greenfoot.playSound("allSound/General Sounds/Menu Sounds/sfx_menu_select4.wav");
          world.restart();
      }
    }
}
