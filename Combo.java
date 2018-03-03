import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Combo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Combo extends Actor
{
    private int now;
    private List<TimeNumber> numbers;
    
    private int allDigit;
    private World world;
    
    private int score;
    private int transparency;
    
    private GreenfootImage image;
    
    public Combo(int score){
      image = new GreenfootImage("Number/multi.png");
      image.scale( 120,30 );
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
      int start;
      int diff = 20;
      if( numbers.size()%2 == 0 ){
        start = getX() - (numbers.size()/2)*(diff) + (diff/2);
      }else{
        start = getX() - ((numbers.size()-1)/2)*diff;
      }
      for(int i = numbers.size()-1; i >= 0; --i){
        numbers.get(i).setLocation( start, getY() + 30);
        start += diff;
      }
    }
    
    public void act(){
      if( transparency > 0 ){
        setLocation(getX(), getY());
        transparency -= 3;
        image.setTransparency(transparency);
        for(TimeNumber n : numbers){
          n.setLocation(n.getX(), n.getY());
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
    }}
