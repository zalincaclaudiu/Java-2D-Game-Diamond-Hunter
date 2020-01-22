package Items;

import Game.Entity;

import java.awt.*;

public class Tree extends Entity {
    public Tree(int x, int y, BlockType t, String path){
        super(x,y,t);
        uploadImage(path);
        isAnimation=false;
    }
    public void render(Graphics g){
        g.drawImage(image,x,y,width,height,null);
        isAnimation=false;
    }
    public void update(){

    }
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
}
