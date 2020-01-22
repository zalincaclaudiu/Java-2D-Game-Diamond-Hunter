package Game;

import java.awt.*;
import java.util.LinkedList;
import Items.*;

public class Handler {
    private LinkedList<Entity> entities=new LinkedList<Entity>();
    private Player player;
    private int currentX=16;
    private int currentY=16;

    public void update(){
//        for(int i=0;i<entities.size();++i){
//            Entity temp=entities.get(i);
//            temp.update();
//        }

        for(int i=currentX;i<currentX+8;++i) {
            for (int j = currentY; j < currentY + 8; ++j) {
                Entity temp = entities.get(40*i+j);
                temp.update();
            }
        }
        entities.getLast().update();
    }

    public void render(Graphics g){
//        for(int i=0;i<entities.size();++i){
//            Entity temp=entities.get(i);
//            temp.render(g);
//        }

        for(int i=currentX;i<currentX+8;++i) {
            for (int j = currentY; j < currentY + 8; ++j) {
                Entity temp = entities.get(40*i+j);
                //System.out.println(""+temp.getX()+" "+temp.getY());
                temp.render(g);
            }
        }
        entities.getLast().render(g);
        //System.out.println(entities.get(820));
    }

    /*public void insertEntities(Map map){
        int i,j;
        for(i=0;i<map.getNrLin();++i){
            for(j=0;j<map.getNrCol();++j){
                if(map.getValue(i,j)==1){
                    entities.add(new Grass(j*Game.tileSize,i*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                }
                if(map.getValue(i,j)==2){
                    entities.add(new Plant(j*Game.tileSize,i*Game.tileSize,BlockType.Plant,"Res/Plant.png"));
                }
                if(map.getValue(i,j)==3){
                    entities.add(new Flower(j*Game.tileSize,i*Game.tileSize,BlockType.Flower,"Res/Flower.png"));
                }
                if(map.getValue(i,j)==4){
                    entities.add(new Axe(j*Game.tileSize,i*Game.tileSize,BlockType.Axe,"Res/Axe.png"));
                }
                if(map.getValue(i,j)==5){
                    entities.add(new Boat(j*Game.tileSize,i*Game.tileSize,BlockType.Boat,"Res/Boat.png"));
                }
                if(map.getValue(i,j)==6){
                    entities.add(new Diamond(j*Game.tileSize,i*Game.tileSize,BlockType.Diamond,"Res/diamond.png"));
                }
                if(map.getValue(i,j)==7){
                    entities.add(new Tree(j*Game.tileSize,i*Game.tileSize,BlockType.Tree,"Res/Tree.png"));
                    nrIns++;
                }
                if(map.getValue(i,j)==8){
                    entities.add(new TreeCut(j*Game.tileSize,i*Game.tileSize,BlockType.Tree2,"Res/Tree2.png"));
                    nrIns++;
                }
                if(map.getValue(i,j)==9){
                    entities.add(new Water(j*Game.tileSize,i*Game.tileSize,BlockType.Water,"Res/Water.png"));
                    nrIns++;
                }

            }
        }
    }*/


    public void insertEntities(Map map){
        int i,j;
        for(i=0;i<map.getNrLin();++i){
            for(j=0;j<map.getNrCol();++j){
                if(map.getValue(i,j)==1){
                    entities.add(new Grass((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                }
                if(map.getValue(i,j)==2){
                    entities.add(new Plant((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Plant,"Res/Plant.png"));
                }
                if(map.getValue(i,j)==3){
                    entities.add(new Flower((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Flower,"Res/Flower.png"));
                }
                if(map.getValue(i,j)==4){
                    //entities.add(new Grass((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                    entities.add(new Axe((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Axe,"Res/Axe.png"));
                }
                if(map.getValue(i,j)==5){
                    //entities.add(new Grass((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                    entities.add(new Boat((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Boat,"Res/Boat.png"));
                }
                if(map.getValue(i,j)==6){
                    //entities.add(new Grass((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                    entities.add(new Diamond((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Diamond,"Res/diamond.png"));
                    HUD.nrDiamondsOnMap++;
                }
                if(map.getValue(i,j)==7){
                    entities.add(new Tree((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Tree,"Res/Tree.png"));
                }
                if(map.getValue(i,j)==8){
                    //entities.add(new Grass((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Grass,"Res/Grass.png"));
                    entities.add(new TreeCut((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Tree2,"Res/Tree2.png"));
                }
                if(map.getValue(i,j)==9){
                    entities.add(new Water((j-16)*Game.tileSize,(i-16)*Game.tileSize,BlockType.Water,"Res/Water.png"));
                }

            }
        }
    }




    public void addEntity(Entity e){
        entities.add(e);
    }
    public void removeEntity(Entity e){
        entities.remove(e);
    }
    public int nrEntities(){return entities.size();}
    public LinkedList<Entity> getEntities(){
        return entities;
    }

    public void addToCurrentX(int x){
        currentX+=x;
    }
    public void addToCurrentY(int y){
        currentY+=y;
    }

    public void showPosition(){
        System.out.println(""+currentX+" "+currentY);
    }
    public void setCurrentX(int x){currentX=x;}
    public void setCurrentY(int y){currentY=y;}
}
