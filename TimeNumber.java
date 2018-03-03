import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TimeNumber here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimeNumber extends Actor
{
    private Number number;
    public TimeNumber(int n){
      number = new Number();
      setImage( number.getNumber(n) );
    }  
    
    public void setNumber(int n){
      setImage( number.getNumber(n) ); 
    }
    
    public void setTransparency(int t){
      number.setTransparency(t);
    }
}
