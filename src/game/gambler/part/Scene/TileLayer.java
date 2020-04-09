package game.gambler.part.Scene;

public class TileLayer {
    int width;
    int height;
    int tile[][];

    public TileLayer(int width, int height, int[][] tile) {
        this.width = width;
        this.height = height;
        this.tile = tile;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getTile() {
        return tile;
    }

    public void setTile(int[][] tile) {
        this.tile = tile;
    }
}
