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
    public Animation(String name, int allFrames, int width, int height){
        this.allFrames = allFrames;
        nameSprite = name;
        sprites = new GreenfootImage[allFrames];
        currentFrame = -1;
        for(int i = 1; i <= allFrames; ++i){
          sprites[i-1] = new GreenfootImage(name+i+".png");
          sprites[i-1].scale(width, height);
        }
    }
    
    public void nextFrame(){
        currentFrame++;
        if(currentFrame == allFrames ) currentFrame = 0;
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
}
