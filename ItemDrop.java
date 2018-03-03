import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ItemDrop here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ItemDrop extends Actor
{
    private double x;
    private double y;
    private GreenfootImage i1;
    private GreenfootImage i2;
    private boolean isRight;
    private boolean overLine;
    
    private MyWorld world;
    public ItemDrop(){
      i1 = new GreenfootImage("Flamingo/Flamingo1.png");
      i1.scale(75, 125);
      i1.setTransparency( 100 );
      
      i2 = new GreenfootImage("Flamingo/Flamingo1.png");
      i2.mirrorHorizontally();
      i2.scale(75, 125);
      i2.setTransparency( 100 );
      
      if( Greenfoot.getRandomNumber(2) < 1 ){
            isRight = true;
            setImage(i1);
        }
        else{
            isRight = false;
            setImage(i2);
      }
      
    }
    
    protected void addedToWorld(World world){
      this.world = (MyWorld) world;
    }
    
    public void act(){
      if( world.isPlaying() ){
          move( 0, 2 );
          setLocation( getX() , getY() + 2 );
          if( getY() > 475 ){
            spawn(0);
            overLine = false;
          }
          if( getY() > 305 && !overLine){
            List<Flamingo> n = getWorld().getObjects( Flamingo.class );
            for(Flamingo one: n){
              if( one.getTransparency() - 50 <= 0 ){
                //System.out.println(  one.getTransparency() - 50 <= 0  );
                gameOver();
              }
              if( one.getTransparency() - 50 >= 0 ) one.setTransparency( one.getTransparency() - 50 );
              else if( one.getTransparency() - 50 < 0 ){ 
                if( one.getTransparency() != 0 ) one.setTransparency( 0 );
              }
              
              world.resetCombo();
            }
            overLine = true;
          }
          if(getWorld() != null){
              List<Flamingo> n = getWorld().getObjects( Flamingo.class );
              for(Flamingo one: n){
                  if( one != null && one.isRight() == isRight && Math.abs(one.getX() - getX()) < 10 && Math.abs(one.getY() - getY()) < 10 ){
                    
                    if( one.getTransparency() + 50 > 255 ){
                      if(one.getTransparency() != 255){
                        one.setTransparency( 255 );
                      }
                    }else{
                      one.setTransparency( one.getTransparency() + 50 );
                    }
                    
                    spawn( getY() - 475 );
                    
                    world.getCombo();
                    world.addScore( 100 );
                    
                    if( Greenfoot.getRandomNumber( 2 ) < 1 ) 
                        Greenfoot.playSound("allSound/Movement/Climbing Ladder/sfx_movement_ladder1a.wav");
                    else 
                        Greenfoot.playSound("allSound/Movement/Climbing Ladder/sfx_movement_ladder1b.wav");
                    
                    
                  }
              }
          }
      }
    }
    public void spawn(int n){
      int x = Greenfoot.getRandomNumber(350);
      //if( Greenfoot.getRandomNumber(2) < 1 ) x = getX() - x;
      //else x = getX() + x;
      setXY(x, -400 +n);
        
        if( Greenfoot.getRandomNumber(2) < 1 ){
            isRight = true;
            setImage(i1);
        }
        else{
            isRight = false;
            setImage(i2);
        }
      setLocation( x, -400 + n);
    }
    public void setXY(double x, double y){
      this.x = x;
      this.y = y;
    }
    public void move(double x, double y){
      this.x += x;
      this.y += y;
    }
    public int getPx(){
      return (int) x;
    }
    public int getPy(){
      return (int) y;
    }
    public void gameOver(){
      if( world.isPlaying() )world.gameOver();
    }
}
