package game.gambler.core.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtil {
    private static ImageUtil _instence;

    public static ImageUtil getImageUtil(){
        if(_instence==null){
            _instence = new ImageUtil();
        }return _instence;
    }


    public BufferedImage getCutInstance(BufferedImage image,int x, int y, int w, int h) {
        return image.getSubimage(x, y, w, h);
    }
    public Image getSCaleInstance(Image image ,int width,int height){

        Image img = image.getScaledInstance(width,height, Image.SCALE_FAST);
        return img;
    }
    public synchronized Image getCutInstance(Image image,int x, int y, int w, int h) {
        BufferedImage bi = new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
        try{
            Graphics2D grph = (Graphics2D) bi.getGraphics();
            grph.drawImage(image, 0,0,w,h, x,y,x+w, y+h, null);
            grph.dispose();
        }catch(Exception ex){
            Debug.log("exception:"+ex.getMessage());
        }
        return bi;
    }
    public Image getScaleInstance(Image img,double sx, double sy) {

        BufferedImage bi = new BufferedImage((int)(sx),(int)(sy),BufferedImage.TYPE_INT_ARGB);

        Graphics2D grph = (Graphics2D) bi.getGraphics();
        grph.scale(sx, sy);
        grph.drawImage(img, 0, 0, null);
        grph.dispose();
        return bi;
    }


}
