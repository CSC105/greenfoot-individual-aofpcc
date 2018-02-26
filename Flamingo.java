import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Actor
{
    private Animation animWalking;
    private GreenfootImage jumping;
    private boolean onGround;
    private boolean isWalking;
    private int u = 0;
    private int a = 1;
    private int defaultY = 276;
    private int jumpForce = 17;
    
    private boolean superJump;
    private long lastTime;
    private GreenfootSound soundJump = new GreenfootSound("jump.mp3");
    public Flamingo(int sizeX, int sizeY){
      animWalking = new Animation( "Flamingo", 36, sizeX, sizeY );
      jumping = new GreenfootImage( "Flamingo1.png");
      jumping.scale(sizeX, sizeY);
      setImage( animWalking.getFrame() );
      onGround = true;
      superJump = false;
    }
    public void act() // v = u + at
    {
        if( check() ){
           Controller.play.restart();
        }
        
        if( u > 0 ){
          onGround = false;
          if(System.nanoTime() - lastTime > 100){
            u -= a;
          }
          setLocation( getX(), getY()-(u) );
        }else if( !onGround && u <= 0 ){
          if(System.nanoTime() - lastTime > 100){
            u -= a;
          }
          if( getY()-u < defaultY ) setLocation( getX(), getY()-u );
          else{
            setLocation( getX(), defaultY );
            u = 0;
            onGround = true;
            superJump = false;
          }
        }
        
        if( Greenfoot.isKeyDown("space") ){
          if(!superJump && onGround){
              isWalking = false;
              jump();
              //soundJump.play();
              Greenfoot.playSound("jump.mp3");
              superJump = true;
              lastTime = System.nanoTime();
          }
          else if( superJump ){
            jump();
            superJump = false;
            lastTime = System.nanoTime();
          }
        }if(onGround){
          isWalking = true;
        }
        
        if( PlayingWorld.isPlaying && onGround ){
            setImage( animWalking.getFrame() );
        }
        else {
            setImage( jumping );
        }
        // Add your action code here.
    }  
    
    public void jump(){
      u = jumpForce;
    }
    
    public boolean check(){
      List<Obstacle> l = getIntersectingObjects(Obstacle.class);
      for( Obstacle ob : l ){
        if( ( ob.getX() > 43 && ob.getX() < 140) && getY() > 210 ){
          return true;
        }
      }
      return false;
    }
    
}
