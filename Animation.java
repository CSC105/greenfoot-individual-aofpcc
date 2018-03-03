import greenfoot.*;
/**
 * Animation by Aof
 * 
 * @author Bunyarit
 * @version 1.0
 */
public class Animation
{
    private int currentFrame;
    private int allFrames;
    private String nameSprite;
    private GreenfootImage[] sprites;
    private int startAt;
    public Animation(String name, int allFrames, int width, int height, int transparency, int startAt, boolean mirrorHorizontally){
        this.allFrames = allFrames;
        this.startAt = startAt;
        nameSprite = name;
        sprites = new GreenfootImage[allFrames+startAt];
        currentFrame = startAt-1;
        for(int i = startAt; i < allFrames; ++i){
          sprites[i] = new GreenfootImage(name+i+".png");
          sprites[i].scale(width, height);
          sprites[i].setTransparency(transparency);
          if( mirrorHorizontally ) sprites[i].mirrorHorizontally();
        }
    }
    
    public void nextFrame(){
        currentFrame++;
        if(currentFrame == allFrames ) currentFrame = startAt;
    }
    
    public GreenfootImage getFrame(){
      nextFrame();
      return sprites[currentFrame];
    }
    
    public int getAllFrames(){
      return allFrames;
    }
    
    public int getCurrentFrame(){
      return currentFrame;
    }
    
    public int getStartAt(){
      return startAt;
    }
    
    public void setTransparency(int transparency){
      for(int i = startAt; i < allFrames; ++i){
         sprites[i].setTransparency(transparency);
      }
    }
}
