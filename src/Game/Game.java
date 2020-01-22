package Game;
import Control.Keys;
import Items.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;

public class Game extends Canvas implements Runnable {

    private static int WIDTH = 655;
    private static int HEIGHT = 678+32;

    public static int tileSize=48;

    public static int WIDTH2=8*48+15;
    public static int HEIGHT2=8*48+38+48;
    private Thread thread;
    private boolean running = false;
    public static boolean RenderGame=true;

    public enum STATE{
        Menu,Game
    };

    public static STATE GameState=STATE.Menu;
    public static int level=0;
    public static int maxLevel=3;
    private Handler handler;
    private HUD hud;
    private Map map;
    public Player player;
    private Menu menu;
    public Game() throws IOException {
        handler=new Handler();
        menu=new Menu();
        level++;
        map=new Map("Res/Map"+level+".in");
        handler.insertEntities(map);
        player = new Player(tileSize, tileSize, BlockType.Player, handler, "Res/playersprites.png");
        handler.addEntity(player);
        this.addKeyListener(new Keys(handler,player));
        this.addMouseListener(menu);
        //new Window(WIDTH, HEIGHT, "My Game", this);
        hud=new HUD();
        new Window(WIDTH2,HEIGHT2,"My game", this);
        System.out.println(handler.nrEntities());
    }

    @Override
    public void run() {
        this.requestFocus();
        long lt = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lt) / ns;
            lt = now;
            if (delta >= 1) {
                update();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public void update(){
        if(GameState==STATE.Game) {
            handler.update();
            hud.update();
            try {
                if (HUD.numberOfDiamonds == HUD.nrDiamondsOnMap) {
                    if (!RenderGame) {
                        thread.sleep(4000);
                        nextLevel();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else{
            menu.update();
        }
    }

    public void render(){
        BufferStrategy bs=this.getBufferStrategy();
        if(bs==null){
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        g.setColor(Color.WHITE);
        g.fillRect(0,0,WIDTH2,HEIGHT2);

        if(GameState==STATE.Game) {
            if(RenderGame) {
                handler.render(g);
            }
            hud.render(g);
        }
        else{
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    public synchronized void start(){
        thread=new Thread(this);
        thread.start();
        running=true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running=false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static int getHEIGHT(){
        return HEIGHT;
    }

    public static int getWIDTH(){
        return WIDTH;
    }

    public static int limit(int var, int min, int max){
        if(var >= max)
            return var=max;
        else if(var <= min)
            return var=min;
        else
            return var;
    }

    public static void main(String[] args) throws IOException{
        new Game();
    }

    public void nextLevel() {
        try {
            level++;
            player.setX(tileSize);
            player.setY(tileSize);
            player.setSpeedX(0);
            player.setSpeedY(0);
            player.setHasAxe(false);
            player.setHasBoat(false);
            player.setAnimType(AnimationType.Down);
            HUD.numberOfDiamonds=0;
            HUD.nrDiamondsOnMap=0;
            map.loadMap("Res/Map" + level + ".in");
            handler.getEntities().clear();
            handler.insertEntities(map);
            handler.addEntity(player);
            handler.setCurrentX(16);
            handler.setCurrentY(16);
            Game.RenderGame=true;
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
