package game.gambler.core.Render;


import java.awt.*;

//<tileset firstgid="1" name="外部 B" tilewidth="32" tileheight="32">
//  <image source="test/testx/B.png" width="512" height="512"/>
// </tileset>
public class TileSet {
    int firstid;
    int tilewidth;
    int tileheight;
    Image image;


    public TileSet(int firstid, int tilewidth, int tileheight, Image image) {
        this.firstid = firstid;
        this.tilewidth = tilewidth;
        this.tileheight = tileheight;
        this.image = image;
    }
    public int getFirstid() {
        return firstid;
    }

    public void setFirstid(int firstid) {
        this.firstid = firstid;
    }

    public int getTilewidth() {
        return tilewidth;
    }

    public void setTilewidth(int tilewidth) {
        this.tilewidth = tilewidth;
    }

    public int getTileheight() {
        return tileheight;
    }

    public void setTileheight(int tileheight) {
        this.tileheight = tileheight;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}
