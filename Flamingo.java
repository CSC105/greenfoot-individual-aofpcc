import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flamingo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Flamingo extends Actor
{
    private Animation animRight;
    private Animation animLeft;
    
    private boolean onGround;
    private MyWorld world;
    private boolean isWalking;
    private boolean isRight;
    private int transparency;
    
    public Flamingo(){
      transparency = 255;
      
      animRight = new Animation("Flamingo/Flamingo", 36, 75, 125, transparency, 1, false);
      animLeft = new Animation("Flamingo/Flamingo", 36, 75, 125, transparency, 1, true);
      
      setImage( animRight.getFrame() );
      isRight = true;
      onGround = true;
      //this.world = world;
    }
    
    protected void addedToWorld(World world){
      this.world = (MyWorld)world;
    }
    
    public int getTransparency(){
      return transparency;
    }
    
    public void act(){
      if( world.isPlaying()){
          isWalking = false;
          
          if( Greenfoot.isKeyDown("up") )fly();
          if( Greenfoot.isKeyDown("down") ){
            if( getY()+5 <= 300 )setLocation( getX(), getY()+5 );  
          }
          if( Greenfoot.isKeyDown("right") ){
            isRight = true;
            isWalking = true;
            if( getWorld() != null ) world.moveAllBg( 0.7 );
          }
          if( Greenfoot.isKeyDown("left") ){
            isRight = false;
            isWalking = true;
            if( getWorld() != null ) world.moveAllBg( -0.7 );
          }
          
          if(getY() < 300){
              onGround = false;
              if( isRight ){
                  while( animRight.getCurrentFrame() != animRight.getStartAt() ){
                      animRight.nextFrame();
                  }
                  setImage( animRight.getFrame() );
              }else{
                  while( animLeft.getCurrentFrame() != animLeft.getStartAt() ){
                      animLeft.nextFrame();
                  }
                  setImage( animLeft.getFrame() );
              }
              
          }
          else if( getY() == 300 ){
              if( isWalking ){
                 if(isRight)setImage( animRight.getFrame() );
                 else setImage( animLeft.getFrame() );
              }
              onGround = true;
          }else if( getY() > 300 ){
              if( isWalking ){
                 if(isRight)setImage( animRight.getFrame() );
                 else setImage( animLeft.getFrame() );
              }
              onGround = true;
              setLocation( getX(), 300 );
          }
          
          if( !isWalking ){
            if( isRight ){
                  while( animRight.getCurrentFrame() != animRight.getStartAt() ){
                      setImage( animRight.getFrame() );
                  }
              }else{
                  while( animLeft.getCurrentFrame() != animLeft.getStartAt() ){
                      setImage( animLeft.getFrame() );
                  }
              }
          }
          
      }
    }
    
    public boolean isRight(){
     return isRight;
    }
    
    public void setTransparency(int transparency){
      this.transparency = transparency;
      animRight.setTransparency(transparency);
      animLeft.setTransparency(transparency);
    }
    
    public void fly(){
      if( getY() - 5 >= 75 )setLocation( getX(), getY()-5 );
    }
}
