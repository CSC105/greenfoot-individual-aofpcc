import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ground here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ground extends Actor
{
    private GreenfootImage image;
    public Ground(){
      image = new GreenfootImage( 600, 5 );
      image.setColor( Color.BLACK );
      image.fill();
      setImage(image);
    }    
}
