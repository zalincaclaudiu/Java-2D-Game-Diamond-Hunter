package Items;

import Game.Entity;
import Game.ImageLoader;

import java.awt.*;

public class Axe extends Entity {
    public Axe(int x, int y, BlockType t, String path){
        super(x,y,t);
        //uploadSubImage(path,16,16,16,16);
        uploadImage(path);
        isAnimation=false;
    }
    public void update(){

    }
    public void render(Graphics g){
        g.drawImage(ImageLoader.loadImage("Res/Grass.png"),x,y,width,height,null);
        g.drawImage(image,x,y,width,height,null);
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
}
