package game.gambler.part.Scene;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.part.Scene.Sprite.Player;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class HomeScene extends Scene{

    public HomeScene(){
        TileMap tileMap = new TileMap("resource/map/map.tmx");
        this.tileMap = tileMap;


        //根据Role_id 获取 对应的职业，
        String carrer_name;
        int roleid=DataManager.getInstance().getRole().getRole_id();
        for (ChooseRoleView c :DataManager.getInstance().getRoleList()) {
            if(roleid == c.getRole_id()){
                carrer_name = c.getCareer_name();
                break;
            }
        }

        Animation left = new Animation();
        for (int i  =1;i<4;i++){
            left.addFrame(new ImageIcon("resource/images/sprite/法师/left"+i+".png").getImage(),250);
        }
        Animation up = new Animation();
        for (int i  =1;i<4;i++){
            up.addFrame(new ImageIcon("resource/images/sprite/法师/up"+i+".png").getImage(),250);
        }
        Animation right = new Animation();
        for (int i  =1;i<4;i++){
            right.addFrame(new ImageIcon("resource/images/sprite/法师/right"+i+".png").getImage(),250);
        }
        Animation down = new Animation();
        for (int i  =1;i<4;i++){
            down.addFrame(new ImageIcon("resource/images/sprite/法师/down"+i+".png").getImage(),250);
        }

        Player player = new Player(left,right,up,down,down,down);
        player.setX(100);
        player.setY(257);
        //加载Sprite
        this.spriteMap.put("player",player);

        SceneManager.getInstance().getGameWindow().addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_UP){
                    player.setVelocityY(Float.parseFloat("-0.2"));
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN){
                    player.setVelocityY(Float.parseFloat("0.2"));
                }
                if(e.getKeyCode() == KeyEvent.VK_LEFT){
                    player.setVelocityX(Float.parseFloat("-0.2"));
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    player.setVelocityX(Float.parseFloat("0.2"));
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.setVelocityX(0);
                player.setVelocityY(0);
            }
        });
    }

    @Override
    public void render(Graphics2D graphics) {
        tileMap.draw(graphics);
        for (Sprite sprite:spriteMap.values()){
           // System.out.println(sprite.getImage());
            graphics.drawImage(sprite.getImage(),(int)sprite.getX(),(int)sprite.getY(),null);
        }
    }

}
