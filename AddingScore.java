import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class AddingScore here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AddingScore extends Actor
{
    private int now;
    private List<TimeNumber> numbers;
    
    private int allDigit;
    private World world;
    
    private int score;
    private int transparency;
    
    private GreenfootImage image;
    
    public AddingScore(int score){
      image = new GreenfootImage("Number/Adding.png");
      image.scale( 30,30 );
      setImage(image);
      this.score = score;
      transparency = 255;
    }
    
    protected void addedToWorld(World world){
      numbers = new ArrayList<TimeNumber>();
      this.world = world;
      setTime(score);
    }
    
    public void addDigit(){
      numbers.add( new TimeNumber(0) );
      world.addObject( numbers.get(numbers.size()-1), getX(), getY() );
      //allDigit = 1;
      allDigit++;
    }
    
    public void arrange(){
      int start = 20;
      int diff = 20;
      start += getX();
      for(int i = numbers.size()-1; i >= 0; --i){
        numbers.get(i).setLocation( start, getY());
        start += diff;
      }
    }
    
    public void act(){
      if( transparency > 0 ){
        setLocation(getX(), getY() - 1);
        transparency -= 5;
        image.setTransparency(transparency);
        for(TimeNumber n : numbers){
          n.setLocation(n.getX(), n.getY() - 1);
          n.setTransparency( transparency );
        }
        if( transparency < 20 ){
         for(TimeNumber n : numbers){
            world.removeObject(n);
         }
         world.removeObject(this);
        }
      }
    }
    
    public void setTime(int time){
      //System.out.println(time + " " + Math.pow(10, allDigit ) );
      while( time >= Math.pow(10, allDigit ) ){
        addDigit();
        arrange();
      }
      int a = 0;
      while( time > 0 ){
        int c = time%10;
        numbers.get(a++).setNumber(c);
        time /= 10;
      }
    }
     
}
