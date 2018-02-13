import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreBoard extends Actor
{
    private GreenfootImage image;
    public ScoreBoard(){
      image = new GreenfootImage( 300, 225);
      image.setColor( Color.BLACK );
      //image.fill();
      image.setFont( new Font(30) );
      //image.drawString("Score : " + Controller.score , 0, 0);
      setImage(image);
    } 
    public void update(){
      image.clear();
      image.scale( 100 + ("" + Controller.score).length()*20, 225 );
      image.drawString("Score : " + Controller.score , 0, 150);
    }
}
