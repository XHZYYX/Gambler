package game.gambler.part.data;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Road;
import game.gambler.core.Render.Sprite;
import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.model.*;
import game.gambler.part.data.view.ChooseRoleView;
import game.gambler.part.data.view.RoleAttributeView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*
* */
public class DataManager {
    Jdbc jdbc=Jdbc.getInstance();

    private static DataManager _instance;
    private MessageManager messageManager =MessageManager.getInstance();
    public static DataManager getInstance(){
        if(_instance==null){
            _instance = new DataManager();
        }
        return  _instance;
    }

    Map<String,Animation> playerMagicAnimation;

    public DataManager(){
        //初始话时加载数据：
        //技能动画
        playerMagicAnimation = new HashMap<>();
        String rootpath = "resource/images/magic/";
        Animation animation= new Animation();
        animation.addFrame(new ImageIcon(rootpath+"1/magic_1").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_2").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_3").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_4").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_5").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_6").getImage(),100);
        animation.addFrame(new ImageIcon(rootpath+"1/magic_7").getImage(),100);
        playerMagicAnimation.put("火球术",animation);
    }

    //保存当前登录的用户数据
    private User user;

    public Monsters getMonsters() {
        return monsters;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }

    private Monsters monsters;

    //保存当前选择的角色信息
    private Role role;

    public RoleAttributeView getRoleAttribute() {
        return roleAttribute;
    }

    public void setRoleAttribute(RoleAttributeView roleAttribute) {
        this.roleAttribute = roleAttribute;
    }

    //角色信息
    RoleAttributeView roleAttribute;
    //由当前角色生成的  精灵的 信息
    //当前的位置 以及动画的切换
    private Sprite playerSprite;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    int index = 0;//标明用户在关卡中的步数

    public List<Road> getRoadList() {
        return roadList;
    }

    public void setRoadList(List<Road> roadList) {
        this.roadList = roadList;
    }

    private List<Road>  roadList;

    private int dice;

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public Road move()  {
        Road road;
        while(dice>0){
            System.out.println("dice"+dice);
            index++;
            dice--;
            road = roadList.get(index);
            playerSprite.setY(road.getY()*32);
            playerSprite.setX(road.getX()*32);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(road.getType()==100){
                dice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"遇到城堡了"));
                break;
            }else if(road.getType()==101){
                dice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"遇到xxx了"));
            }else if(road.getType()==102){
                dice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"102剧情"));
            }else if(road.getType()==10){
                dice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"第一关boss"));
            }
        }
        road = roadList.get(index);
        switch(road.getType()){
            //蚂蚁
            case 1:Battle(1);break;
            case 2:Battle(2);break;
            case 3:Battle(3);break;
            case 4:Battle(4);break;
            case 5:Battle(5);break;
            case 10:Battle(6);break;
        }
        return null;
    }

    private void Battle(int Monsters_id) {
        DataManager.getInstance().setMonster(Monsters_id);
        messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"遇到怪物了"));
    }

    private void setMonster(int Monsters_id) {
        setMonsters(jdbc.queryMonsterById(Monsters_id));
    }



    private Map<String, Monsters> MonstersMap;

    private Map<String, Buff>BuffMap;

    private Map<String, Grade> GradeMap;

    //记录关卡
    private int checkPoint;

    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }

    public void update(){
        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.graphics_msg)){
            switch (message.getMsg_Content()){

            }
        }
    }

    public void loadUserInformation() {
        //加载当前用户下的全部角色信息 。这个信息存在哪
        //当前用户的信息在哪里存着
        User user = DataManager.getInstance().getUser();
        //通过user 查询改user下的全部role
        List<Role> Roles= jdbc.queryRolesByUserId(user.getUser_id());
        //根据角色信息加载页面
        /*
         * 需要的内容如下
         * 角色 id
         * 角色 名称
         * 角色 等级
         * 角色 职业
         * */
        List<ChooseRoleView> crvs = new ArrayList<>();
        for (Role role:Roles){
            crvs.add(jdbc.queryChooseRoleViewByRoleId(role.getRole_id()));
        }
        System.out.println("角色个数"+Roles.size());
        this.setRoleList(crvs);
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void LoadRole(int role_id){
        this.role=jdbc.queryRoleByRoleId(role_id);
        System.out.println(role.toString());
    }



    //怪物的数据

    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Sprite playerSprite) {
        this.playerSprite = playerSprite;
    }



    private List<ChooseRoleView> RoleList;
    public List<ChooseRoleView> getRoleList() {
        return RoleList;
    }
    public void setRoleList(List<ChooseRoleView> roleList) {
        RoleList = roleList;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public void newUser(String username,String password){
        jdbc.newUser(username,password);
    }


}
