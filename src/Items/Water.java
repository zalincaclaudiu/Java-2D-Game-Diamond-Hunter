package Items;

import Game.Entity;

import java.awt.*;

public class Water extends Entity {
    public Water(int x, int y, BlockType t, String path){
        super(x,y,t);
        //uploadSubImage(path,32,16,16,16);
        uploadImage(path);
        isAnimation=false;
    }
    public void update(){

    }
    public void render(Graphics g){
        g.drawImage(image,x,y,width,height,null);
    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
}
