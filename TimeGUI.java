import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class TimeGUI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeGUI extends Actor
{
    private int now;
    private List<TimeNumber> numbers;
    
    private int allDigit;
    private World world;
    public TimeGUI(){
      GreenfootImage image = new GreenfootImage("Number/Time.png");
      image.scale( 77,48 );
      setImage(image);
    }
    
    protected void addedToWorld(World world){
      numbers = new ArrayList<TimeNumber>();
      this.world = world;
      addDigit();
    }
    
    public void addDigit(){
      numbers.add( new TimeNumber(0) );
      world.addObject( numbers.get(numbers.size()-1), getX(), getY() + 40 );
      //allDigit = 1;
      allDigit++;
    }
    
    public void arrange(){
      int start;
      int diff = 20;
      if( numbers.size()%2 == 0 ){
        start = 300 - (numbers.size()/2)*(diff) + (diff/2);
      }else{
        start = 300 - ((numbers.size()-1)/2)*diff;
      }
      for(int i = numbers.size()-1; i >= 0; --i){
        numbers.get(i).setLocation( start, getY() + 40);
        start += diff;
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
    
    public void gameOver(){
      for(Actor a : numbers){
        world.removeObject(a);  
      }
    }
    
}
