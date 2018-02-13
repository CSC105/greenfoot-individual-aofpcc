import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private GreenfootImage image;
    public Button(String name, int x, int y){
      image = new GreenfootImage( name + ".png" );
      image.scale(x, y);
      setImage(image);
    }
    public void act(){
      if( Greenfoot.mouseClicked(this) ){
        action();
      }
    }
    public void action(){
    
    }
}
