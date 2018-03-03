import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Number here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number extends Actor
{
    private GreenfootImage[] images;
    public Number(){
      images = new GreenfootImage[10];
      for(int i = 0; i < 10; i++){
        images[i] = new GreenfootImage( "Number/" + i + ".png" );
        images[i].scale( 28, 32 );
      }
    }
    
    public GreenfootImage getNumber(int i){
      return images[i];
    }
    
    public void setTransparency(int transparency){
      for(int i = 0; i < 10; i++){
        images[i].setTransparency(transparency);
      }
    }
}
