import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    private GreenfootImage image;

    private List<TimeNumber> scores; // score
    private List<TimeNumber> maxComboes; // score
    
    //private int allDigit;
    private World world;
    
    private Restart restart;
    
    private int score;
    private int maxCombo;
    
    private int sD;  // Score Digit
    private int mD;  // MaxCombo Digit
    
    public GameOver( int score, int maxCombo ){
      image = new GreenfootImage("gameOver.png");
      image.scale( 300, 256 );
      setImage(image);
      this.score = score;
      this.maxCombo = maxCombo;
      restart = new Restart();
      //setTime( score , scores, 20);
    }
   
    protected void addedToWorld(World world){
      scores = new ArrayList<TimeNumber>();
      maxComboes = new ArrayList<TimeNumber>();
      this.world = world;
      addDigit();
      mAddDigit();
      setTime(score);
      mSetTime(maxCombo);
      world.addObject( restart, 300, getY() + 75);
    }
    
    public void addDigit(){
      scores.add( new TimeNumber(0) );
      world.addObject( scores.get(scores.size()-1), getX() + 35, getY() - 43 );
      //allDigit = 1;
      sD++;
    }
    
    public void arrange(){
      int start = getX() + 35;
      int diff = 20;
      for(int i = scores.size()-1; i >= 0; --i){
        scores.get(i).setLocation( start, getY() - 43);
        start += diff;
      }
    }
    
    public void setTime(int time){
      //System.out.println(time + " " + Math.pow(10, allDigit ) );
      while( time >= Math.pow(10, sD ) ){
        addDigit();
        arrange();
      }
      int a = 0;
      while( time > 0 ){
        int c = time%10;
        scores.get(a++).setNumber(c);
        time /= 10;
      }
    }
    
    // max Score
    public void mAddDigit(){
      maxComboes.add( new TimeNumber(0) );
      world.addObject( maxComboes.get(maxComboes.size()-1), getX() + 35, getY() - 3 );
      //allDigit = 1;
      mD++;
    }
    
    public void mArrange(){
      int start = getX() + 35;
      int diff = 20;
      for(int i = maxComboes.size()-1; i >= 0; --i){
        maxComboes.get(i).setLocation( start, getY() - 3);
        start += diff;
      }
    }
    
    public void mSetTime(int time){
      //System.out.println(time + " " + Math.pow(10, allDigit ) );
      while( time >= Math.pow(10, mD ) ){
        mAddDigit();
        mArrange();
      }
      int a = 0;
      while( time > 0 ){
        int c = time%10;
        maxComboes.get(a++).setNumber(c);
        time /= 10;
      }
    }
    
    public void remove(){
      if( world!=null){
          world.removeObject(restart);
          for( TimeNumber n : scores){
            world.removeObject(n);  
          }
          for( TimeNumber n : maxComboes){
            world.removeObject(n);  
          }
          world.removeObject(this); 
      }
    }
    
    
}
