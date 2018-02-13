import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartWorld extends Controller
{
    private PlayButton start;
    /**
     * Constructor for objects of class Start.
     * 
     */
    public StartWorld() throws Exception
    {    
        if( menu == null ) menu = this;
        start = new PlayButton();
        addObject( start, 300, 200 );
    }
}
