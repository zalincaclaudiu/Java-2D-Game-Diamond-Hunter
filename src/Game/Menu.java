package Game;

import Items.BlockType;
import Items.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends MouseAdapter {
    private HUD menuHud=new HUD();
    class Option{
        public Option(int x, int y, int width, int height){
            this.x=x;
            this.y=y;
            this.width=width;
            this.height=height;
        }
        int x;
        int y;
        int width;
        int height;
    }
    private Option play=new Option(92,180,200,20);
    private Option help=new Option(152,240,80,20);
    private Option quit=new Option(152,300,80,20);

    public void mousePressed(MouseEvent e){
        int mx=e.getX();
        int my=e.getY();

        if(mouseOnOption(mx,my,play)){
            Game.GameState= Game.STATE.Game;
        }
        if(mouseOnOption(mx,my,quit)){
            System.exit(1);
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOnOption(int mx, int my, Option p){
        if(((mx>=p.x)&&(mx<=p.x+p.width))&&((my>=p.y)&&(my<=p.y+p.height))){
            return true;
        }
        return false;
    }

    public void update(){

    }

    public void render(Graphics g){
        char[] car;
        String[] words={"start game","   exit   ","menu"};
        for(int i=0;i<words.length-1;++i){
            car=words[i].toCharArray();
            for(int j=0;j<car.length;++j){
                if(car[j]>='a'&&car[j]<='z') {
                    g.drawImage(menuHud.letters[car[j]-'a'],92+j*20,180+i*60,20,20,null);
                }
            }
        }
        car=words[2].toCharArray();
        for(int j=0;j<car.length;++j){
            if(car[j]>='a'&&car[j]<='z'){
                g.drawImage(menuHud.letters[car[j]-'a'],142+j*25,96,25,25,null);
            }
        }
        /*g.setColor(Color.BLUE);
        g.drawRect(2*Game.tileSize,Game.tileSize,4*Game.tileSize,Game.tileSize);
        g.drawRect(2*Game.tileSize,3*Game.tileSize,4*Game.tileSize,Game.tileSize);
        g.drawRect(2*Game.tileSize,5*Game.tileSize,4*Game.tileSize,Game.tileSize);*/
    }

}
