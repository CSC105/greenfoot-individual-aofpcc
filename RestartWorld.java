import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RestartWorld extends Controller
{
    /**
     * Constructor for objects of class Start.
     * 
     */
    public RestartWorld() throws Exception
    {    
        if( restart == null ) restart = this;
        RestartButton re = new RestartButton();
        addObject( re, 300, 300 );
    }
    
    public void restart(){
      scoreBoard.update();
    }
}
