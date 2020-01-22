package Items;

import Game.Entity;
import Game.ImageLoader;

import java.awt.*;

public class Plant extends Entity {
    public Plant(int x, int y, BlockType t, String path){
        super(x,y,t);
        //uploadSubImage(path,32,0,16,16);
        uploadImage(path);
        isAnimation=false;
        toRender=true;
    }
    public void update(){

    }
    public void render(Graphics g){
        if(toRender){
            g.drawImage(image,x,y,width,height,null);
        }
    }
    public void draw(Graphics g,int p, int q){g.drawImage(image,p,q,width,height,null);}
    public Rectangle getRectangle(){
        return new Rectangle(x,y,width,height);
    }
}
