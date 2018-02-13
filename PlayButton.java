import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    public PlayButton(){
      super( "playButton", 100, 100 );
    }
    @Override
    public void action(){
      Controller.nowScene = "play";
      PlayingWorld.setIsPlaying( true );
      Controller.startTime = System.nanoTime();
      Greenfoot.setWorld( Controller.play );
    }
}
