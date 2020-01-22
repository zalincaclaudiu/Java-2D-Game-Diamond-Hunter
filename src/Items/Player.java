package Items;

import Game.*;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {

    private Handler handler;

    private BufferedImage[] downSprites;
    private BufferedImage[] leftSprites;
    private BufferedImage[] rightSprites;
    private BufferedImage[] upSprites;
    private BufferedImage[] downBoatSprites;
    private BufferedImage[] leftBoatSprites;
    private BufferedImage[] rightBoatSprites;
    private BufferedImage[] upBoatSprites;

    private AnimationType animType;

    private boolean hasAxe=false;
    private boolean hasBoat=false;
    private boolean onWater=false;

    public boolean[] direction={false,false,false,false};

    public Player(int x, int y, BlockType t, Handler handler, String path)
    {
        super(x,y,t);
        this.handler=handler;
        animation=new Animation(2,4);
        isAnimation=true;
        animation.setDelay(10);

        downSprites=new BufferedImage[2];
        leftSprites=new BufferedImage[2];
        rightSprites=new BufferedImage[2];
        upSprites=new BufferedImage[2];
        downBoatSprites=new BufferedImage[2];
        leftBoatSprites=new BufferedImage[2];
        rightBoatSprites=new BufferedImage[2];
        upBoatSprites=new BufferedImage[2];

        loadAllSprites(path);
        animType=AnimationType.Down;
    }

    @Override
    public void update(){
        switch (animType){
            case Up: setAnimation(upSprites);
                break;
            case Left: setAnimation(leftSprites);
                break;
            case Right: setAnimation(rightSprites);
                break;
            case Down: setAnimation(downSprites);
                break;
            case UpBoat: setAnimation(upBoatSprites);
                break;
            case LeftBoat: setAnimation(leftBoatSprites);
                break;
            case RightBoat: setAnimation(rightBoatSprites);
                break;
            case DownBoat: setAnimation(downBoatSprites);
                break;
        }

        animation.update();
        x += speedX;
        y += speedY;

        //x=Game.limit(x,0,Game.getWIDTH()-48);
        //y=Game.limit(y,0,Game.getHEIGHT()-70);
        if(x>Game.WIDTH2-200){
            handler.addToCurrentY(8);
            for(int i=0;i<handler.getEntities().size();++i){
                Entity temp=handler.getEntities().get(i);
                temp.setX(temp.getX()-8*48);
            }
        }
        if(x<0){
            handler.addToCurrentY(-8);
            for(int i=0;i<handler.getEntities().size();++i){
                Entity temp=handler.getEntities().get(i);
                temp.setX(temp.getX()+8*48);
            }
        }
        if(y>Game.HEIGHT2-200){
            handler.addToCurrentX(8);
            for(int i=0;i<handler.getEntities().size();++i){
                Entity temp=handler.getEntities().get(i);
                temp.setY(temp.getY()-8*48);
            }
        }
        if(y<0){
            handler.addToCurrentX(-8);
            for(int i=0;i<handler.getEntities().size();++i){
                Entity temp=handler.getEntities().get(i);
                temp.setY(temp.getY()+8*48);
            }
        }


        collision();
        //handler.showPosition();
    }

    @Override
    public void render(Graphics g){
        g.drawImage(animation.getImage(),x,y,Game.tileSize,Game.tileSize,null);
    }



    @Override
    public Rectangle getRectangle(){

        return new Rectangle(x+10,y+10,Game.tileSize-20,Game.tileSize-20);
    }

    public void loadSprites(String path, int lin, BufferedImage[] sprites ){
        BufferedImage image=ImageLoader.loadImage(path);
        for(int j=0;j<2;++j ){
            sprites[j]=image.getSubimage(j*16,lin*16,16,16);
        }
    }

    public void loadAllSprites(String path){
        loadSprites(path,0,downSprites);
        loadSprites(path,1,leftSprites);
        loadSprites(path,2,rightSprites);
        loadSprites(path,3,upSprites);
        loadSprites(path,4,downBoatSprites);
        loadSprites(path,5,leftBoatSprites);
        loadSprites(path,6,rightBoatSprites);
        loadSprites(path,7,upBoatSprites);
    }

    public void setAnimation(BufferedImage[] sprites){
        animation.frames=sprites;
    }
    public void collision(){
        for(int i=0;i<handler.getEntities().size();++i) {
            Entity temp=handler.getEntities().get(i);
            /*if(temp.getType()!=BlockType.Player) {
                if (temp.getType() != BlockType.Water) {
                    if (!getRectangle().intersects(temp.getRectangle())) {
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Diamond) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        //collision code
                        HUD.HEALTH += 6;
                        HUD.numberOfDiamonds++;
                        handler.getEntities().remove(temp);
                        System.out.println(1);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Axe) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        handler.getEntities().remove(temp);
                        hasAxe = true;
                        System.out.println(2);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Boat) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        handler.getEntities().remove(temp);
                        hasBoat = true;
                        System.out.println(3);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Tree2 && hasAxe) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        handler.getEntities().remove(temp);
                        System.out.println(4);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Tree2 && !hasAxe) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        System.out.println(5);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Water && hasBoat) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        onWater = true;
                        System.out.println(6);
                    }
                }
                if (temp.getType() == BlockType.Water && !hasBoat) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        System.out.println(7);
                        onWater = false;
                    }
                }
                if (temp.getType() == BlockType.Tree) {
                    if (getRectangle().intersects(temp.getRectangle())) {
                        System.out.println(8);
                        onWater = false;
                    }
                }
            }*/
            if(temp.getType()!=BlockType.Player) {
                if (getRectangle().intersects(temp.getRectangle())) {
                    if (temp.getType() == BlockType.Diamond) {
                        //collision code
                        HUD.numberOfDiamonds++;
                        int tempX=temp.getX();
                        int tempY=temp.getY();
                        handler.getEntities().remove(temp);
                        handler.getEntities().add(i,new Grass(tempX,tempY,BlockType.Grass,"Res/Grass.png"));
                        //System.out.println(1);
                    }
                    if (temp.getType() == BlockType.Axe) {
                        int tempX=temp.getX();
                        int tempY=temp.getY();
                        handler.getEntities().remove(temp);
                        handler.getEntities().add(i,new Grass(tempX,tempY,BlockType.Grass,"Res/Grass.png"));
                        hasAxe = true;
                        //System.out.println(2);
                    }
                    if (temp.getType() == BlockType.Boat) {
                        int tempX=temp.getX();
                        int tempY=temp.getY();
                        handler.getEntities().remove(temp);
                        handler.getEntities().add(i,new Grass(tempX,tempY,BlockType.Grass,"Res/Grass.png"));
                        hasBoat = true;
                        //System.out.println(3);
                    }
                    if (temp.getType() == BlockType.Tree2 && hasAxe) {
                        int tempX=temp.getX();
                        int tempY=temp.getY();
                        handler.getEntities().remove(temp);
                        handler.getEntities().add(i,new Grass(tempX,tempY,BlockType.Grass,"Res/Grass.png"));
                        //System.out.println(4);
                    }
                    if ((temp.getType() == BlockType.Tree2 && !hasAxe)||(temp.getType() == BlockType.Water && !hasBoat)||(temp.getType() == BlockType.Tree)) {
                        if(direction[0] && temp.getType()!=BlockType.Grass && y>temp.getY()){
                            y=Game.limit(y,temp.getY()+temp.getHeight(),Game.getHEIGHT());
                        }
                        if(direction[1] && temp.getType()!=BlockType.Grass && y<temp.getY() ){
                            y=Game.limit(y,0,temp.getY()-temp.getHeight());
                        }
                        if(direction[2] && temp.getType()!=BlockType.Grass && x<temp.getX()){
                            x=Game.limit(x,0,temp.getX()-temp.getWidth());
                        }
                        if(direction[3] && temp.getType()!=BlockType.Grass && x>temp.getX()){
                            x=Game.limit(x,temp.getX()+temp.getWidth(),Game.getWIDTH());
                        }
                        //System.out.println(5);
                    }
                    if (temp.getType() == BlockType.Water && hasBoat) {
                        onWater = true;
                        //System.out.println(6);
                    }
                    /*if (temp.getType() == BlockType.Water && !hasBoat) {
                        //System.out.println(7);
                    }
                    if (temp.getType() == BlockType.Tree) {

                        //System.out.println(8);
                    }*/
                    if (temp.getType() == BlockType.Grass || temp.getType() == BlockType.Plant || temp.getType()==BlockType.Flower){
                        onWater=false;
                    }
                }
            }
        }
    }

    public void setAnimType(AnimationType type){
        animType=type;
    }

    public boolean isHasBoat(){
        return hasBoat;
    }

    public boolean isOnWater(){
        return onWater;
    }

    public void setHasAxe(boolean b){
        hasAxe=b;
    }
    public void setHasBoat(boolean b){
        hasBoat=b;
    }
}
