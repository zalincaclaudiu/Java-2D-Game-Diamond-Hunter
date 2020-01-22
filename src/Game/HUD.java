package Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HUD {

    public static int numberOfDiamonds = 0;
    public static int nrDiamondsOnMap = 0;
    public BufferedImage[] numbers = new BufferedImage[10];
    public BufferedImage[] letters = new BufferedImage[26];
    public BufferedImage diamond = ImageLoader.loadImage("Res/Diamon.png");
    public BufferedImage bar = ImageLoader.loadImage("Res/bar.png");
    public BufferedImage slash;
    public int charSize = 24;

    public HUD() {
        BufferedImage image = ImageLoader.loadImage("Res/font.png");
        for (int i = 0; i < 6; ++i) {
            numbers[i] = image.getSubimage(16 + i * 8, 24, 8, 8);
        }
        for (int i = 0; i < 4; ++i) {
            numbers[i + 6] = image.getSubimage(i * 8, 32, 8, 8);
        }
        slash = image.getSubimage(32, 32, 8, 8);
        for (int i = 0; i < 26; ++i) {
            letters[i] = image.getSubimage((i % 8) * 8, (i / 8) * 8, 8, 8);
        }
    }

    public void update() {

    }

    public void render(Graphics g) {
        /*g.setColor(Color.gray);
        g.fillRect(15,15,180,32);
        g.setColor(Color.green);
        g.fillRect(15,15,HEALTH*2,32);
        g.setColor(Color.white);
        g.drawRect(15,15,180,32);*/
        g.drawImage(bar, 0, 8 * Game.tileSize, 8 * Game.tileSize, Game.tileSize, null);

        g.drawImage(numbers[numberOfDiamonds / 10], 144, 394, charSize, charSize, null);
        g.drawImage(numbers[numberOfDiamonds % 10], 144 + charSize, 394, charSize, charSize, null);
        g.drawImage(slash, 144 + 2 * charSize, 394, charSize, charSize, null);
        g.drawImage(numbers[nrDiamondsOnMap / 10], 144 + 3 * charSize, 394, charSize, charSize, null);
        g.drawImage(numbers[nrDiamondsOnMap % 10], 144 + 4 * charSize, 394, charSize, charSize, null);
        g.setColor(Color.green);
        g.fillRect(24, 402, (int) (numberOfDiamonds * (float) (89 / nrDiamondsOnMap)), 12);

        if(numberOfDiamonds==nrDiamondsOnMap) {
            levelCompleted(g);
        }

    }

    public void levelCompleted(Graphics g){
        String s=" level "+Game.level+" completed";
        char[] car=s.toCharArray();
        g.setColor(Color.white);
        g.fillRect(0,0,8*Game.tileSize,8*Game.tileSize);
        for(int i=0;i<car.length;++i){
            if(car[i]>='a' && car[i]<='z') {
                g.drawImage(letters[car[i] - 'a'], 3 + (i % 9) * 42, 96 + (i / 9) * 42, 42, 42, null);
            }
            if(car[i]>='0'&&car[i]<='9'){
                g.drawImage(numbers[car[i]-'0'], 3 + (i % 9) * 42, 96 + (i / 9) * 42, 42, 42, null);
            }
        }
        Game.RenderGame=false;
    }
}
