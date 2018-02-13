import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RestartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartButton extends Button
{
    public RestartButton(){
      super( "restartButton", 100, 100 );
    }
    @Override
    public void action(){
      Controller.nowScene = "play";
      PlayingWorld.setIsPlaying( true );
      Controller.play.reset();
      Controller.startTime = System.nanoTime();
      Greenfoot.setWorld( Controller.play );
    }
}
