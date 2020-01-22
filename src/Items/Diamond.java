package Items;

import Game.Entity;
import Game.Game;
import Game.ImageLoader;

import java.awt.*;

public class Diamond extends Entity {

    public Diamond(int x, int y, BlockType t,String path){
        super(x,y,t);
        animation=new Animation(4,5);
        for(int i=0;i<4;++i){
            uploadSubImage(path,i*16,0,16,16);
            animation.setImgFrame(image,i);
        }
        isAnimation=true;

    }

    @Override
    public void update(){
        animation.update();
    }

    @Override
    public void render(Graphics g){
        g.drawImage(ImageLoader.loadImage("Res/Grass.png"),x,y,width,height,null);
        g.drawImage(animation.getImage(),x,y,width,height,null);
    }

    @Override
    public Rectangle getRectangle(){

        return new Rectangle(x,y,width,height);
    }
}
