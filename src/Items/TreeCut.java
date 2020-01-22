package Items;

import Game.Entity;

import java.awt.*;

public class TreeCut extends Entity {
    public TreeCut(int x, int y, BlockType t, String path){
        super(x,y,t);
        //uploadSubImage(path,16,16,16,16);
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
