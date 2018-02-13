import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller extends World
{
    public static PlayingWorld play;
    public static StartWorld menu;
    public static RestartWorld restart;
    public static String nowScene;
    public static long startTime;
    public static long score;
    public static ScoreBoard scoreBoard;
    /**
     * Constructor for objects of class Controller.
     * 
     */
    public Controller() throws Exception
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
    }
}
