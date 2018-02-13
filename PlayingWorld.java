import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayingWorld extends Controller
{
    public static boolean isPlaying;
    private List<Obstacle> list;
    private Random rand;
    private Obstacle ob1, ob2;
    private Flamingo fl;
    public PlayingWorld() throws Exception
    {    
        setIsPlaying(false);
        setPaintOrder( Flamingo.class );
        if( play == null ) play = this;
        if( menu == null || restart == null ){
          menu = new StartWorld();
          nowScene = "menu";
          restart = new RestartWorld();
          Controller.scoreBoard = new ScoreBoard();
          restart.addObject( scoreBoard, 300, 100 );
        }
        if( Controller.nowScene.equals("menu") ){
          Greenfoot.setWorld(menu);
        }
        rand = new Random();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        list = new ArrayList<Obstacle>();
        fl = new Flamingo( 100, 150 );
        addObject( fl, 100, 276 );
        ob1 = new Obstacle( "blade_3", true, 50, 50 );
        ob2 = new Obstacle( "blade_3", true, 50, 50 );
        list.add(ob1);
        list.add(ob2);
        addObject( ob1, 450, 300 );
        addObject( ob2, 1000, 300 );
        Ground g = new Ground();
        addObject( g, 300, 350 );
        Greenfoot.setSpeed( 50 );
    }
    
    public void act(){
      /*if( fl != null ){
          List<Actor> l = fl.getObjectsInRange(10);
          restart();
      }*/
      if( isPlaying ){
          for( Obstacle obs : list ){
            if( obs.getX()-6 >= -5 )  obs.setLocation( obs.getX()-6, obs.getY() );
            else obs.setLocation( rand.nextInt()%50 + 875 , obs.getY() );
          }
      }
    }
    public static void setIsPlaying( boolean b ){
      isPlaying = b;
    }
    public void reset(){
      removeObject(fl);
      fl = null;
      fl = new Flamingo( 100, 150 );
      addObject( fl, 100, 276 );
      ob1.setLocation( 450, 300 );
      ob2.setLocation( 1000, 300 );
    }
    public void restart(){
        Controller.nowScene = "restart";
        isPlaying = false;
        Controller.score = (long)((System.nanoTime() - Controller.startTime)*1596.38/1000000000);
        //System.out.println( Controller.score );
        Controller.restart.restart();
        Greenfoot.setWorld(restart);
    }
    
}
