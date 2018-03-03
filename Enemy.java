import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Actor
{
    private Animation anim;
    private int frameDelay = 0;
    private MyWorld world;
    public Enemy(){
      anim = new Animation( "enemy/enemy" , 31, 75, 50, 100, 3, false);
      setImage(anim.getFrame());
      //this.world = world;
    }
    
    protected void addedToWorld(World world){
        this.world = (MyWorld)world;
    }
    
    public void act(){
      if( world.isPlaying() ){
          frameDelay++;
          if( frameDelay > 1 ){
            setImage(anim.getFrame()); 
            frameDelay = 0;
          }
          if( getX() > -50 ) setLocation( getX() -5, getY() );
          else{
            setLocation( 700, (int)(Math.random() * 300 + 50 ) );
          }
          Actor player = getOneIntersectingObject(Flamingo.class);
          if(player != null && isTouchPlayer(player) ){
            //world.endGame();
          }
      }   
    }
    
    public boolean isTouchPlayer(Actor player){
      return !((player.getY() - getY() > 50 && player.getX() - getX() > 20) || (getX() - player.getX() < 40) );
    }
}
