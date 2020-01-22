package Game;

import Items.BlockType;
import Items.Flower;
import Items.Grass;
import Items.Plant;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Map {

    private int[][] map;
    private int nrCol;
    private int nrLin;


    private Grass grass;

    public Map(String path) throws IOException
    {
        loadMap(path);
    }

    public void loadMap(String path) throws IOException
    {
        BufferedReader buff = new BufferedReader(new FileReader(path));
        nrLin = Integer.parseInt(buff.readLine());
        nrCol = Integer.parseInt(buff.readLine());
        map = new int[nrLin][nrCol];
        for (int i = 0; i < nrLin; ++i) {
            String[] s = buff.readLine().split(" ");
            for (int j = 0; j < nrCol; ++j) {
                map[i][j] = Integer.parseInt(s[j]);
            }
        }
    }

    public void drawMap(Graphics g){
        Grass gr=new Grass(-1,-1, BlockType.Grass,"Res/Grass.png");
        /*Plant p=new Plant(-1,-1,BlockType.Plant,"Res/Plant.png");
        Flower f=new Flower(-1,-1,BlockType.Flower,"Res/Flower.png");*/
        for(int i=0;i<nrLin;++i) {
            for(int j=0;j<nrCol;++j) {
                if(map[i][j]==4 || map[i][j]==5 || map[i][j]==6 || map[i][j]==8){
                    gr.draw(g,j*Game.tileSize,i*Game.tileSize);
                }
                /*if(map[i][j]==2){
                    p.draw(g,j*16,i*16);
                }
                if(map[i][j]==3){
                    f.draw(g,j*16,i*16);
                }*/
            }

        }
    }
    public void drawMap2(Graphics g){
        Grass gr=new Grass(-1,-1, BlockType.Grass,"Res/Grass.png");
        /*Plant p=new Plant(-1,-1,BlockType.Plant,"Res/Plant.png");
        Flower f=new Flower(-1,-1,BlockType.Flower,"Res/Flower.png");*/
        for(int i=0;i<8;++i) {
            for(int j=0;j<8;++j) {
                if(map[i][j]==4 || map[i][j]==5 || map[i][j]==6 || map[i][j]==8){
                    gr.draw(g,(j-17)*Game.tileSize,(i-17)*Game.tileSize);
                }
                /*if(map[i][j]==2){
                    p.draw(g,j*16,i*16);
                }
                if(map[i][j]==3){
                    f.draw(g,j*16,i*16);
                }*/
            }

        }
    }

    public void ShowMap()
    {
        for(int i=0;i<nrLin;++i)
        {
            for(int j=0;j<nrCol;++j)
            {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }

    public int getValue(int x, int y)
    {
        return map[x][y];
    }
    public int getNrLin(){
        return nrLin;
    }

    public int getNrCol(){
        return nrCol;
    }

    public void setValue(int val, int i, int j){
        map[i][j]=val;
    }

}
