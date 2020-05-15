package game.gambler.part.Scene;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Sprite;
import game.gambler.core.Render.TileMap;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Sprite.Creature;
import game.gambler.part.Scene.Sprite.NPC;
import game.gambler.part.Scene.Sprite.Player;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.view.ChooseRoleView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HomeScene extends Scene{
    KeyAdapter move;
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

        DataManager.getInstance().setPlayerSprite(player );
        NPC npc1=new NPC(down);
        npc1.setX(160);
        npc1.setY(220);
        this.npcMap.put("npc1",npc1);
        NPC npc2=new NPC(down);
        npc2.setX(160);
        npc2.setY(450);
        this.npcMap.put("npc2",npc2);
        NPC npc3=new NPC(down);
        npc3.setX(450);
        npc3.setY(680);
        this.npcMap.put("npc3",npc3);
        NPC npc4=new NPC(down);
        npc4.setX(864);
        npc4.setY(256);
        this.npcMap.put("npc4",npc4);

        move =new KeyAdapter() {
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
                if(e.getKeyCode() == KeyEvent.VK_E){
                    if(SceneManager.getInstance().CollisionDetetctionFlag){
                        if(SceneManager.getInstance().SpriteList.get("npc1")!=null){
                            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"打开购买装备页面"));
                        }else if(SceneManager.getInstance().SpriteList.get("npc2")!=null){
                            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"打开购买商品页面"));
                        }else if(SceneManager.getInstance().SpriteList.get("npc3")!=null){
                            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.graphics_msg,"关卡选择"));
                        }else if(SceneManager.getInstance().SpriteList.get("npc4")!=null){
                            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"获得神的祝福buff"));
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                player.setVelocityX(0);
                player.setVelocityY(0);
            }
        };

        SceneManager.getInstance().getGameWindow().addKeyListener(move);
    }

    public void stop(){
        this.running = false;
        SceneManager.getInstance().getGameWindow().removeKeyListener(move);
        // sceneRender.stop();
    }


    @Override
    public void update(long elapsedTime){
        if(null!=this.getNpcMap()){
            for(String creatureName:this.getNpcMap().keySet()){
                Creature creature = this.getNpcMap().get(creatureName);
                if(this.CollisionDetetction(this.getPlayer(),creature)){
                    if (!SceneManager.getInstance().SpriteList.containsValue(creature))
                        SceneManager.getInstance().SpriteList.put(creatureName,this.getNpcMap().get(creatureName));
                }else{
                    if (SceneManager.getInstance().SpriteList.containsValue(creature))
                        SceneManager.getInstance().SpriteList.remove(creatureName);
                }
            }
        }
        for (Sprite sprite:spriteMap.values()){
            sprite.update(elapsedTime);
        }
    }


    @Override
    public void render(Graphics2D graphics) {
        tileMap.draw(graphics);
        for (Sprite sprite:npcMap.values()){
            graphics.drawImage(sprite.getImage(),(int)sprite.getX(),(int)sprite.getY(),null);
        }
        for (Sprite sprite:spriteMap.values()){
            graphics.drawImage(sprite.getImage(),(int)sprite.getX(),(int)sprite.getY(),null);
        }
    }

}
