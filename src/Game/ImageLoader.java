package Game;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;

public class ImageLoader {
    public static BufferedImage loadImage(String path){
        try{
            return ImageIO.read(new File(path));
        }
        catch(IOException e){
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }
}

