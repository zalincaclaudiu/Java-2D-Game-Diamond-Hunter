package Control;

import Game.Entity;
import Game.Handler;
import Items.AnimationType;
import Items.BlockType;
import Items.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.Key;

public class Keys extends KeyAdapter {

    private Handler handler;
    private Player player;

    private boolean[] KeyDown=new boolean[4];

    public Keys(Handler handler, Player player){
        this.handler=handler;
        this.player=player;

        KeyDown[0]=false;
        KeyDown[1]=false;
        KeyDown[2]=false;
        KeyDown[3]=false;

    }
    public void keyPressed(KeyEvent e){
        int key=e.getKeyCode();

        for(int i=0;i<handler.getEntities().size();++i) {
            Entity temp=handler.getEntities().get(i);
            if(temp.getType()== BlockType.Player){
                // key events for player 1
                if(key==KeyEvent.VK_W) {
                    if(!player.isHasBoat() || !player.isOnWater()){
                        player.setAnimType(AnimationType.Up);
                    }
                    else {
                        player.setAnimType(AnimationType.UpBoat);
                    }
                    KeyDown[0]=true;
                    player.direction[0]=true;
                    temp.setSpeedY(-5);
                }
                if(key==KeyEvent.VK_S) {
                    if(!player.isHasBoat() || !player.isOnWater()){
                        player.setAnimType(AnimationType.Down);
                    }
                    else {
                        player.setAnimType(AnimationType.DownBoat);
                    }
                    System.out.println(player.isHasBoat()+" "+player.isOnWater());
                    KeyDown[1]=true;
                    player.direction[1]=true;
                    temp.setSpeedY(5);
                }
                if(key==KeyEvent.VK_A){
                    if(!player.isHasBoat() || !player.isOnWater()) {
                        player.setAnimType(AnimationType.Left);
                    }
                    else{
                        player.setAnimType(AnimationType.LeftBoat);
                    }
                    KeyDown[3]=true;
                    player.direction[3]=true;
                    temp.setSpeedX(-5);
                }
                if(key==KeyEvent.VK_D){
                    if(!player.isHasBoat() || !player.isOnWater()) {
                        player.setAnimType(AnimationType.Right);
                    }
                    else{
                        player.setAnimType(AnimationType.RightBoat);
                    }
                    KeyDown[2]=true;
                    player.direction[2]=true;
                    temp.setSpeedX(5);
                }
            }
            /*if(temp.getType()==BlockType.Diamond){
                if(key==KeyEvent.VK_UP) temp.setSpeedY(-5);
                if(key==KeyEvent.VK_DOWN) temp.setSpeedY(5);
                if(key==KeyEvent.VK_LEFT) temp.setSpeedX(-5);
                if(key==KeyEvent.VK_RIGHT) temp.setSpeedX(5);
            }*/
        }
        //System.out.println(key);
    }

    public void keyReleased(KeyEvent e){
        int key=e.getKeyCode();
        for(int i=0;i<handler.getEntities().size();++i) {
            Entity temp=handler.getEntities().get(i);
            if(temp.getType()== BlockType.Player){
                // key events for player 1
                if(key==KeyEvent.VK_W) {
                    KeyDown[0]=false;
                    player.direction[0]=false;
                    //temp.setSpeedY(0);
                }
                if(key==KeyEvent.VK_S){
                    KeyDown[1]=false;
                    player.direction[1]=false;
                    //temp.setSpeedY(0);
                }
                if(key==KeyEvent.VK_A){
                    KeyDown[3]=false;
                    player.direction[3]=false;
                    //temp.setSpeedX(0);
                }
                if(key==KeyEvent.VK_D){
                    KeyDown[2]=false;
                    player.direction[2]=false;
                    //temp.setSpeedX(0);
                }
            }
            /*if(temp.getType()==BlockType.Diamond){
                if(key==KeyEvent.VK_UP) temp.setSpeedY(0);
                if(key==KeyEvent.VK_DOWN) temp.setSpeedY(0);
                if(key==KeyEvent.VK_LEFT) temp.setSpeedX(0);
                if(key==KeyEvent.VK_RIGHT) temp.setSpeedX(0);
            }*/

            if(key==KeyEvent.VK_ESCAPE) System.exit(1);

            if(!KeyDown[0] && !KeyDown[1]) player.setSpeedY(0);
            if(!KeyDown[2] && !KeyDown[3]) player.setSpeedX(0);
        }
        //System.out.println(key);
    }
}
