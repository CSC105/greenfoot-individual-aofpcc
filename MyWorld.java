import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import greenfoot.core.WorldHandler;
import java.util.*;

import java.awt.Cursor;
import java.awt.image.*;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.event.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    // Combo
    private int combo;
    private int maxCombo;
    
    public GreenfootSound bgSound;
    public Background[][] bgs;
    private boolean isPlaying;
    
    //private long startTime;
    //private int current;
    
    private Actor player;
    private Actor g1, g2, g3;
    
    // Item drop
    private ItemDrop i1, i2;
    
    //Score
    private TimeGUI time;
    private int score;
    private int cRate;
    
    private JPanel panel = WorldHandler.getInstance().getWorldCanvas();
    private Cursor cursor;
    private MouseInfo mouse;
    private MouseImage mouseImage = new MouseImage();
    
    private GameOver gameOver;
    
    public MyWorld()
    {   
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        bgs = new Background[2][];
        bgs[0] = new Background[11];
        bgs[0][0] = new Layer0( 464, 20 );
        bgs[0][1] = new Layer1( 464, 000 );
        bgs[0][2] = new Layer2( 464, 000 );
        bgs[0][3] = new Layer3( 464, 000 );
        bgs[0][4] = new Layer4( 464, 000 );
        bgs[0][5] = new Layer5( 464, 000 );
        bgs[0][6] = new Layer6( 464, 000 );
        bgs[0][7] = new Layer7( 464, 000 );
        bgs[0][8] = new Layer8( 464, 000 );
        bgs[0][9] = new Layer9( 464, 000 );
        bgs[0][10] = new Layer10( 464, 000 );
        for(int i = 0 ; i < 11; ++i){
          addObject( bgs[0][i], bgs[0][i].getPx(), bgs[0][i].getPy() );
        }
        
        bgs[1] = new Background[11];
        bgs[1][0] = new Layer0( 464 + 927, 020 );
        bgs[1][1] = new Layer1( 464 + 927, 000 );
        bgs[1][2] = new Layer2( 464 + 927, 000 );
        bgs[1][3] = new Layer3( 464 + 927, 000 );
        bgs[1][4] = new Layer4( 464 + 927, 000 );
        bgs[1][5] = new Layer5( 464 + 927, 000 );
        bgs[1][6] = new Layer6( 464 + 927, 000 );
        bgs[1][7] = new Layer7( 464 + 927, 000 );
        bgs[1][8] = new Layer8( 464 + 927, 000 );
        bgs[1][9] = new Layer9( 464 + 927, 000 );
        bgs[1][10] = new Layer10( 464 + 927, 000 );
        for(int i = 0 ; i < 11; ++i){
          addObject( bgs[1][i], bgs[1][i].getPx(), bgs[1][i].getPy() );
        }
        
        setPaintOrder(  Start.class, MouseImage.class, Restart.class, TimeNumber.class,  TimeGUI.class,  GameOver.class, Combo.class, 
                        AddingScore.class,Flamingo.class, ItemDrop.class , Layer0.class,Layer1.class,Layer2.class,Layer3.class,Layer4.class,
                        Layer5.class,Layer6.class,Layer7.class,Layer8.class,Layer9.class,Layer10.class);
        bgSound = new GreenfootSound("soundBg.mp3");
        bgSound.setVolume(35);
        //bgSound.playLoop();
        
        player = new Flamingo();
        g1 = new Enemy();
        g2 = new Enemy();
        g3 = new Enemy();
        
        //addObject( player, 300, 300 );
        //ddObject( g1 , 600, 100 );
        //addObject( g2 , 800, 120 );
        //addObject( g3 , 1000, 130 );
        Greenfoot.setSpeed( 50 );
        
        addObject( new Start(), 300, 200 );
        
        
        //gameOver
        gameOver = new GameOver(0,0);
        
        /*
        i1 = new ItemDrop();
        int x = Greenfoot.getRandomNumber(350);
        i1.setXY( x, -100 );
        addObject( i1, x, -100 );
        
        i2 = new ItemDrop();
        x = Greenfoot.getRandomNumber(350);
        i2.setXY( x, -400 );
        addObject( i2, x, -400 );
        
        time = new TimeGUI();
        addObject( time, 300, 30 );
        */
        
        //isPlaying = true;
        
        //startTime = System.nanoTime();
        //current = 0;
        
        score = 0;
        
        //mouse
        GreenfootImage image = new GreenfootImage("Cursor/grabHand/hand 01.png");
        image.scale( 30, 30);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point cursorHotSpot = new Point(12,12);
        cursor = toolkit.createCustomCursor(image.getAwtImage(), cursorHotSpot, "Cursor"); 
        //addObject( mouseImage, 0, 0);
    }
    
    public boolean isPlaying(){
      return isPlaying;
    }
    
    public void reset(){
      player.setLocation(100, 300);
      g1.setLocation(600, 100);
      g2.setLocation(800, 120);
      g3.setLocation(1000, 130);
      //startTime = System.nanoTime();
      //current = 0;
      bgSound.playLoop();
    }
    
    public void act(){
      mouse = Greenfoot.getMouseInfo();
      if( mouse != null ){
        //mouseImage.setLocation( mouse.getX(), mouse.getY());
        panel.setCursor(cursor);
      }
      if( isPlaying ){
         if( cRate++ > 3 ){
             score++;
             cRate = 0;
         }
         time.setTime(score);
         /*
         if( (System.nanoTime()-startTime)/50000 > current ){
            System.out.println( System.nanoTime() );
            current =  (int)((System.nanoTime()-startTime)/50000);
            time.setTime(current);
         }
         */
      }
    }
    
    public void addScore( int score ){
      this.score += score * combo;
      animAddScore(score * combo);
    }
    
    public void animAddScore(int score){
      addObject( new AddingScore(score), 325, 100 );
    }
    
    public void moveAllBg(double d){
      moveBg( bgs[0] , d);
      moveBg( bgs[1] , d);
      moveItem( d );
    }
    
    public void moveItem(double d){
      List<ItemDrop> actors = getObjects( ItemDrop.class );
      for(ItemDrop a : actors){
        a.move( - Math.pow((11),0.5) * d, 0 );
        a.setLocation( a.getPx(), a.getPy() );
      }
    }
    
    public void moveBg( Background[] bg, double g ){
      for(int i = 0; i < 11; ++i){
        bg[i].move( - Math.pow((11-i),0.5) * g, 0 );
        if( bg[i].getPx() < -464 ){
            bg[i].setPxy( 464 + 926, bg[i].getY() );
        }
        else if( bg[i].getPx() >= 464 + 927 ){
            bg[i].setPxy( -463, bg[i].getY() );
        }
        bg[i].setLocation( bg[i].getPx(), bg[i].getY() );
      }
    }
    
    public void getCombo(){
      combo++;
      if( combo > maxCombo ) maxCombo = combo;
      if( combo > 1 ){
        addObject( new Combo(combo), 500, 100 );
      }
    }
    
    public void resetCombo(){
      combo = 0;
    }
    
    public void gameOver(){
      bgSound.stop();
        
      isPlaying = false;
      time.gameOver();
      removeObject( player );
      removeObject( time );
      removeObject(i1);
      removeObject(i2);
      gameOver = new GameOver(score, maxCombo);
      addObject( gameOver, 300, 200 );
      
      GreenfootImage image = new GreenfootImage("Cursor/grabHand/hand 01.png");
      image.scale( 30, 30);
      Toolkit toolkit = Toolkit.getDefaultToolkit();
      Point cursorHotSpot = new Point(12,12);
      cursor = toolkit.createCustomCursor(image.getAwtImage(), cursorHotSpot, "Cursor"); 
      
      Greenfoot.playSound( "allSound/Death Screams/Alien/sfx_deathscream_alien1.wav" );
    }
    
    public void restart(){
      gameOver.remove();
      //removeObject(gameOver);
      score = 0;
      maxCombo = 0;
      
      addObject( player, 300, 300 );
      ((Flamingo)player).setTransparency(255);
      i1 = new ItemDrop();
      int x = Greenfoot.getRandomNumber(350);
      i1.setXY( x, -100 );
      addObject( i1, x, -100 );
        
      i2 = new ItemDrop();
      x = Greenfoot.getRandomNumber(350);
      i2.setXY( x, -400 );
      addObject( i2, x, -400 );
        
      time = new TimeGUI();
      addObject( time, 300, 30 );
        
      isPlaying = true;
      
      int[] pixels = new int[16 * 16];
      Image image = Toolkit.getDefaultToolkit().createImage( new MemoryImageSource(16, 16, pixels, 0, 16));
      cursor = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0, 0), "invisibleCursor");
      bgSound.playLoop();
      Greenfoot.setSpeed( 50 );
    }
}
