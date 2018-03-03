import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Background here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Background extends Actor
{
    private double x;
    private double y;
    public Background(double x, double y){
      this.x = x;
      this.y = y;
    }
    
    public int getPx(){
      return (int)x;
    }
    public int getPy(){
      return (int)y;
    }
    public void move(double x, double y){
      this.x += x;
      this.y += y;
    }
    public void setPxy(double x, double y){
      this.x = x;
      this.y = y;
    }
}
