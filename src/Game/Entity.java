package Game;

import Items.Animation;
import Items.BlockType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;


public abstract class Entity {
    protected BufferedImage image;

    protected int x;
    protected int y;

    protected BlockType type;
    protected int speedX, speedY;

    protected int width;
    protected int height;

    protected Animation animation;
    protected boolean isAnimation;

    protected boolean toRender;

    public Entity(int x, int y, BlockType t){
        this.x=x;
        this.y=y;
        this.type=t;
        this.width=48;
        this.height=48;
    }

    public abstract void update();
    public abstract void render(Graphics g);
    public abstract Rectangle getRectangle();

    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void setType(BlockType t){
        this.type=t;
    }
    public BlockType getType(){
        return type;
    }
    public void setSpeedX(int sx){
        this.speedX=sx;
    }
    public void setSpeedY(int sy){
        this.speedY=sy;
    }
    public int getSpeedX(){
        return speedX;
    }
    public int getSpeedY(){
        return speedY;
    }
    public int getWidth(){ return width;}
    public int getHeight(){ return height;}
    public void uploadImage(String path){
        image=ImageLoader.loadImage(path);
    }
    public void uploadSubImage(String path, int x, int y, int width, int height){
        try {
            BufferedImage img = ImageLoader.loadImage(path);
            image = img.getSubimage(x, y, width, height);
            ImageIO.write(image, "png", new File(""+type+".png"));
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
    }




}
