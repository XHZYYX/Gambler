package game.gambler.core.Render;

import org.dom4j.Document;
import org.dom4j.Element;
//import game.gambler.core.Render.Graphics.RGraphicsBase;
import game.gambler.core.Util.Debug;
import game.gambler.core.Util.XMLBoot;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static game.gambler.core.Util.ImageUtil.getImageUtil;

public class TileMap {

    Document TilemapTMX;//tiledmap tml文件

    List<TileSet> tileSets = new ArrayList<>();

    List<TileLayer> tileLayers=new ArrayList<>();//存放图层吐块的二维数组

    int tilewidth,tileheight;//地图块的宽高
    int width,height;//整个地图宽高块数


    public boolean CollisionDetetction(int x,int y,int direction){
        TileSet tileSet = tileSets.get(tileSets.size()-1);
        TileLayer tileLayer = tileLayers.get(tileLayers.size()-1);
        //x,y所处的这个块是否是 可以待的地方
        if (tileLayer.getTile()[y/tileSet.getTileheight()][x/tileSet.getTilewidth()]!=0){
           // System.out.println(x/tileSet.getTilewidth()+"  "+y/tileSet.getTileheight());
            return true;
        }
        return false;
    }

    //存放对应gid 的图片
    List<Image> TileImage = new ArrayList<>();


    public TileMap(){}

    public TileMap(String TMXfilePath){
        TilemapTMX = XMLBoot.readXMLFileDocument(TMXfilePath);
        loadTileMap();
    }

    public void loadTileMap(){
        //判断文件是否为空
        if(TilemapTMX==null){
            Debug.log("file path for map not right.");
            return;
        }
        //获取文档根节点
        Element root=TilemapTMX.getRootElement();

        //如果根节点为空 或 根节点不是map 退出函数
        if(root==null||!root.getName().equals("map")){
            Debug.log("map file has no root or root name not map!");//则输出该文件没有根节点 或 不是map
            return;
        }

        //获取地图块的宽高
         tilewidth=Integer.parseInt(root.attributeValue("tilewidth"));
         tileheight=Integer.parseInt(root.attributeValue("tileheight"));

        //用自我折磨来证明我真的很用心
        TileImage=new ArrayList<Image>();
        //加载tileset
        loadTileSet(root);
        //根据加载出的tileset 将所有图片分割存入TileImage
        loadTileImage();
        //加载图层
        loadTIleLayer(root);
    }

    public void loadTileSet(Element root){
        List<Element> tileSets = root.elements("tileset");
        if (tileSets!=null){
            for(Element e: tileSets){
                int firstid = Integer.parseInt(e.attributeValue("firstgid"));
                int tilewidth = Integer.parseInt(e.attributeValue("tilewidth"));
                int tileheight = Integer.parseInt(e.attributeValue("tileheight"));

                Image image = loadImage(e.element("image").attributeValue("source"));
                TileSet tileSet = new TileSet(firstid,tilewidth,tileheight,image);
                this.tileSets.add(tileSet);
                System.out.println(tileSet.toString());
            }
        }
    }

    public void loadTileImage(){
        int count = 1;
        TileImage.add(0,null);
        for (int i=0;i<tileSets.size();i++)
        {
            System.out.println("第"+i+"个set");
            TileSet tileSet = tileSets.get(i);

            Image image = tileSet.image;
//16
            int cutx = image.getWidth(null)/tileSet.tilewidth;
            int cuty = image.getHeight(null)/tileSet.tileheight;
//12
            for(int j=0;j<cuty;j++){//12次
                for(int h =0;h<cutx;h++){//16次
                    TileImage.add(count,getImageUtil().getCutInstance(image,
                            h*tileSet.tilewidth,j*tileSet.tileheight,
                            tileSet.tilewidth,tileSet.tileheight));
                    count++;
                }
            }
        }

    }

//<layer name="块层 1" width="40" height="24">
//  <data>
//   <tile gid="514"/>
//   <tile gid="514"/>
//    <data>
//    </layer>
    public void loadTIleLayer(Element root){
        List<Element> tileLayers = root.elements("layer");
        if (tileLayers!=null){
            for(Element e: tileLayers){
                String name = e.attributeValue("name");
                int width = Integer.parseInt(e.attributeValue("width"));
                int height = Integer.parseInt(e.attributeValue("height"));
                //第一个layer
                Element data=e.element("data");//获取layer 的data 数据
                int tile[][] = new int[height][width];//初始化 tile 地图数组
                int x=0,y=0;//计数变量
                Iterator<Element> tileiter=data.elementIterator();//data的遍历
                while(tileiter.hasNext()){
                    Element ele=tileiter.next();
                    int gid=Integer.parseInt(ele.attributeValue("gid"));
                        tile[x][y]=gid;
                        Debug.log("set gid:["+x+","+y+"]"+gid);
                    ++y;
                    if(y>=width){
                        y%=width;
                        ++x;
                    }
                }
                printArr1(tile);
                //循环写入gid tile 数组并将其作为参数传入 tlleLayer构造函数
                TileLayer tileLayer = new TileLayer(width, height, tile);
                this.tileLayers.add(tileLayer);
            }
        }

    }

    public static void printArr1(int[][] arr) {
        for(int x=0; x<arr.length; x++) {
            for(int y=0; y<arr[x].length; y++) {
                System.out.print(arr[x][y]+" ");
            }
            System.out.println();
        }
    }

    private final Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

    public void draw(Graphics2D g){
        //gid 对应的图片 TileImage
        //图层 TileLayers
        //首先遍历图层集合
//        int cout =1;
//        for (int i = 0; i < 48; i++) {
//            for (int j=0;j<16;j++){
//                g.drawImage(TileImage.get(cout), i*35, j*35);
//                cout++;
//            }
//
//        }
        for (TileLayer tileLayer:tileLayers){
            int arr[][] = tileLayer.getTile();
            for(int x=0; x<arr.length; x++) {
                for(int y=0; y<arr[x].length; y++) {
                   g.drawImage(TileImage.get(arr[x][y]),y*tilewidth,x*tileheight,null);
                   //rx+y*texture.getWidth(),ry+texture.getHeight()*x, texture
                }
            }

        }



    }
}
