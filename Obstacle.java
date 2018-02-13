import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Obstacle extends Actor
{
    private GreenfootImage image;
    private boolean isRolling;
    private int currentRotation;
    public Obstacle(String name, boolean isRolling, int x, int y){
      image = new GreenfootImage( name + ".png" );
      setImage( image );
      this.isRolling = isRolling;
      image.scale(x, y);
    }
    
    public void act() 
    {
        if( PlayingWorld.isPlaying && isRolling ){
          currentRotation = (currentRotation+10)%360;
          setRotation( currentRotation );
        }
    }    
}
