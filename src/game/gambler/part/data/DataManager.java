package game.gambler.part.data;

import game.gambler.core.Render.Animation;
import game.gambler.core.Render.Road;
import game.gambler.core.Render.Sprite;
import game.gambler.core.Util.Jdbc;
import game.gambler.core.Util.Random;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.UI.Box.TalkBox;
import game.gambler.part.UI.UIManager;
import game.gambler.part.data.model.*;
import game.gambler.part.data.view.ChooseRoleView;
import game.gambler.part.data.view.RoleAttributeView;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

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
    public DataManager(){
        //初始话时加载数据：
        //技能动画
        goodBaseList = jdbc.queryAllGoodBase();
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

    Map<String,Animation> playerMagicAnimation;
    //角色计算后的属性
    public RoleAttributeView temp = new RoleAttributeView();
    //角色想要购买的商品
    GoodBase wantToBuy;

    EquipmentBase wantToBuyE;
    //全部的基础商品集合
    List<GoodBase> goodBaseList;
    //角色的物品集合
    private List<Good> goodList;
    //保存当前登录的用户数据
    private List<EquipmentBase> equipmentBaseList;
    private List<Equipment> equipmentTrue;
    private List<Equipment> equipmentFalse;

    private User user;
    //人物的技能集合 魔法ID
    private List<Magic_Career_Grade> mcgList;
    private List<Monsters_Magic> mmlist;
    //玩家魔法集合
    private List<Magic> playerMagicList=new ArrayList<>();
    //怪物魔法集合
    private List<Magic> monsterMagicList = new ArrayList<>();
    private Magic playerMagic;
    private Magic monsterMagic;



    //当前怪物
    private Monsters monsters;
    //保存当前选择的角色信息
    private Role role;
    //角色信息
    RoleAttributeView roleAttribute;
    //由当前角色生成的  精灵的 信息
    //当前的位置 以及动画的切换
    private Sprite playerSprite;

    int index = 0;//标明用户在关卡中的步数

    private List<Road>  roadList;
    //玩家骰子值
    private int playerdice;
    //怪物骰子值
    private int monsterdice;


    public void PlayerUseMagic(){
        switch (playerMagic.getMagic_name()){
            case "大火球术":break;
            case "恢复":Magic_huifu();break;
        }
    }

    public void Magic_huifu(){
        Attribute attribute = temp.getAttribute();
        if (attribute.getBase_MP()>=playerMagic.getMagic_mana()){
            temp.getAttribute().setBase_HP(temp.getAttribute().getBase_HP()+playerMagic.getMagic_baseValue());
            new TalkBox("使用恢复技能，恢复10点生命值");
        }else{
            new TalkBox("MP值不足");
        }
    }
    public void ChangeEquipment(Equipment equipment) {
        String position="";
        for (EquipmentBase equipmentBase:equipmentBaseList){
            if (equipmentBase.getEquipment_name().equals(equipment.getEquipment_name())){
                position=equipmentBase.getEquipment_position();
                System.out.println(position);
            }
        }
        for(Equipment equipment1:equipmentTrue){
            System.out.println("2"+equipment1.getEquipment_name());
            for(EquipmentBase equipmentBase:equipmentBaseList){
                System.out.println(1+equipmentBase.getEquipment_name());
                if (equipmentBase.getEquipment_name().equals(equipment1.getEquipment_name())
                        &&equipmentBase.getEquipment_position().equals(position)){
                    System.out.println(equipmentBase.getEquipment_name());
                    System.out.println(equipment1.getEquipment_name());
                    jdbc.changeTrueEquipment(equipment);
                    jdbc.changeFalseEquipment(equipment1);
                    UIManager.getInstance().updateEquipmentBox();
                    loadEquipment();
                    loadRoleAttribute();
                    UIManager.getInstance().updateStatusBarPanel();
                    return;
                }
            }
        }
        jdbc.changeTrueEquipment(equipment);
        UIManager.getInstance().updateEquipmentBox();
        loadEquipment();
        loadRoleAttribute();
        UIManager.getInstance().updateStatusBarPanel();
    }

    public Road move()  {
        Road road;
        while(playerdice>0){
            System.out.println("playerdice"+playerdice);
            index++;
            playerdice--;
            road = roadList.get(index);
            playerSprite.setY(road.getY()*32);
            playerSprite.setX(road.getX()*32);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(road.getType()==100){
                playerdice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"遇到城堡了"));
                break;
            }else if(road.getType()==101){
                playerdice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"遇到xxx了"));
            }else if(road.getType()==102){
                playerdice = 0;
                messageManager.sendMessage(new Message(Message.Msgtype.all_msg,"102剧情"));
            }else if(road.getType()==10){
                playerdice = 0;
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
        Monsters m =jdbc.queryMonsterById(Monsters_id);
        setMonsters(m);
        mmlist = jdbc.queryMMListById();
        monsterMagicList=jdbc.queryMonsterMagic();
        System.out.println(m.getMonster_id());
    }
    private Map<String, Monsters> MonstersMap;

    private Map<String, Buff>BuffMap;

    private Map<String, Grade> GradeMap;

    //记录关卡
    private int checkPoint;

    public void update(){
        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&message.getMsg_type().equals(Message.Msgtype.all_msg)){
            switch (message.getMsg_Content()){
                case "释放魔法":PlayerUseMagic();break;
                case "获得神的祝福buff":getBuff(1);break;
                case "获得天使之翼buff":getBuff(2);break;
            }
        }
    }

    private void getBuff(int buff_id) {
        List<Role_Buff> role_buffs = jdbc.queryRoleBuff();
        for (Role_Buff role_buff:role_buffs){
            if (role_buff.getBuff_id() == buff_id)
                new TalkBox("你已经获得了这个buff");return;
        }
        jdbc.setPlayerBuff(buff_id);
        new TalkBox("获得神的祝福buff,攻击+5,防御+5,血量+10");
        loadRoleAttribute();
        UIManager.getInstance().updateStatusBarPanel();
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



    public void LoadRole(int role_id){
        this.role=jdbc.queryRoleByRoleId(role_id);
        System.out.println(role.toString());
    }

    //怪物的数据


    private List<ChooseRoleView> RoleList;

    //注册用户
    public void newUser(String username,String password){
        jdbc.newUser(username,password);
    }


    public boolean buyGoodBase(){
        int sellPrice = this.wantToBuy.getGood_SellingPrice();
        int coin = user.getCoin();
        if(coin>=sellPrice){
            //购买
            Good flag=new Good(-1,"",-1,-1,-1,-1);
            for (Good good:goodList){
                if (good.getGood_name().equals(wantToBuy.getGood_name())){
                    flag = good;
                }
            }
            if (flag.getGood_id()!=-1){//角色背包中有该物品
                jdbc.addgood(flag);
            }else{
                jdbc.newgood(wantToBuy);
            }
            this.goodList = jdbc.queryAllGood(role);
            jdbc.updataCoin(coin-sellPrice);
            this.user = jdbc.queryUserByName(user.getUsername());
            JLabel jLabel=(JLabel) UIManager.getInstance().queryUIByName("coin");
            jLabel.setVisible(false);
            jLabel.setText("金币："+user.getCoin());
            jLabel.setVisible(true);
            return true;
        }else{
            return false;
        }
    }

    public boolean buyEquipmentBase() {
        int sellPrice = this.wantToBuyE.getEquipment_SellingPrice();
        int coin = user.getCoin();
        if(coin>=sellPrice){
            //购买
            switch (wantToBuyE.getEquipment_name()){
                case "王大锤":jdbc.addEquipment(
                        new Equipment(0,role.getRole_id(),"王大锤",false,0,0,10,0));

                case "青虹剑":jdbc.addEquipment(
                        new Equipment(0,role.getRole_id(),"青虹剑",false,0,0,10,0)
                );
            }
            jdbc.updataCoin(coin-sellPrice);
            this.user = jdbc.queryUserByName(user.getUsername());
            JLabel jLabel=(JLabel) UIManager.getInstance().queryUIByName("coin");
            jLabel.setVisible(false);
            jLabel.setText("金币："+user.getCoin());
            jLabel.setVisible(true);
            return true;
        }else{
            return false;
        }
    }


    public void loadGoods(){
        setGoodList(jdbc.queryAllGood(role));
    }
    public void loadEquipment() {
        setEquipmentFalse(jdbc.queryFalseEquipment());
        setEquipmentTrue(jdbc.queryTrueEquipment());
    }
    public void sellEquipment(Equipment equipment) {
        jdbc.reduceEquipment(equipment);
        int temp=0;
        for (EquipmentBase equipmentBase:equipmentBaseList){
            if (equipment.getEquipment_name().equals(equipmentBase.getEquipment_name())){
                temp=equipmentBase.getEquipment_RecoveryPrice();
                break;
            }
        }
        jdbc.updataCoin(user.getCoin()+temp);
        this.user = jdbc.queryUserByName(user.getUsername());
    }
    public void sellGood(Good good) {
        jdbc.reducegood(good);
        int temp=0;
        for (GoodBase goodBase:goodBaseList){
            if (good.getGood_name().equals(goodBase.getGood_name())){
                temp=goodBase.getGood_RecoveryPrice();
                break;
            }
        }
        jdbc.updataCoin(user.getCoin()+temp);
        this.user = jdbc.queryUserByName(user.getUsername());
    }

    public void cloneRoleAttribute() {
        temp=roleAttribute.clone(roleAttribute);

    }

    public void battle() {
        monsterdice = Random.getInstance().getRandom(monsters.getMonster_max_Strength());
        if (playerdice>monsterdice){
            monsters.setMonster_HP(monsters.getMonster_HP()-temp.getAttribute().getBase_attack());
           new TalkBox("怪物掷出了"+monsterdice+"点,"+"你掷出了"+playerdice+"点,怪物受到了"+temp.getAttribute().getBase_attack()+"伤害");
        }else {

            temp.getAttribute().setBase_HP(temp.getAttribute().getBase_HP()-monsters.getMonster_attack());
            System.out.println(temp.getAttribute().getBase_HP());
            new TalkBox("怪物掷出了"+monsterdice+"点,"+"你掷出了"+playerdice+"点,你受的了"+monsters.getMonster_attack()+"伤害");
        }
        if (monsters.getMonster_HP()<=0)
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"玩家胜利"));
        else if (temp.getAttribute().getBase_HP()<=0){
            MessageManager.getInstance().sendMessage(new Message(Message.Msgtype.all_msg,"玩家失败"));
        }
    }

    public void loadRoleAttribute() {
        Attribute attribute= jdbc.queryAttribute(role);
        List<Equipment> equipment=jdbc.queryTrueEquipment();
        List<Buff> buffs = new ArrayList<>();
        for (Role_Buff role_buff:jdbc.queryRoleBuff()){
            buffs.add(jdbc.queryBuffbyId(role_buff.getBuff_id()));
        }
        RoleAttributeView battleAttributeView = new RoleAttributeView(attribute,equipment,buffs);
        setRoleAttribute(battleAttributeView);
    }





    public RoleAttributeView getTemp() {
        return temp;
    }

    public void setTemp(RoleAttributeView temp) {
        this.temp = temp;
    }

    public GoodBase getWantToBuy() {
        return wantToBuy;
    }

    public void setWantToBuy(GoodBase wantToBuy) {
        this.wantToBuy = wantToBuy;
    }
    public List<Magic> getMonsterMagicList() {
        return monsterMagicList;
    }
    public List<Magic> getPlayerMagicList() {
        return playerMagicList;
    }
    public void setPlayerMagicList(List<Magic> playerMagicList) {
        this.playerMagicList = playerMagicList;
    }
    public void setMonsterMagicList(List<Magic> monstaerMagicList) {
        this.monsterMagicList = monstaerMagicList;
    }
    public int getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(int checkPoint) {
        this.checkPoint = checkPoint;
    }
    public List<Road> getRoadList() {
        return roadList;
    }

    public void setRoadList(List<Road> roadList) {
        this.roadList = roadList;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public List<GoodBase> getGoodBaseList() {
        return goodBaseList;
    }

    public void setGoodBaseList(List<GoodBase> goodBaseList) {
        this.goodBaseList = goodBaseList;
    }
    public List<Good> getGoodList() {
        return goodList;
    }

    public void setGoodList(List<Good> goodList) {
        this.goodList = goodList;
    }
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
    public Sprite getPlayerSprite() {
        return playerSprite;
    }

    public void setPlayerSprite(Sprite playerSprite) {
        this.playerSprite = playerSprite;
    }
    public int getMonsterdice() {
        return monsterdice;
    }

    public void setMonsterdice(int monsterdice) {
        this.monsterdice = monsterdice;
    }

    public int getPlayerdice() {
        return playerdice;
    }

    public void setPlayerdice(int playerdice) {
        this.playerdice = playerdice;
    }
    public Monsters getMonsters() {
        return monsters;
    }

    public void setMonsters(Monsters monsters) {
        this.monsters = monsters;
    }
    public RoleAttributeView getRoleAttribute() {
        return roleAttribute;
    }

    public void setRoleAttribute(RoleAttributeView roleAttribute) {
        this.roleAttribute = roleAttribute;
    }
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    public List<Magic_Career_Grade> getMcgList() {
        return mcgList;
    }

    public void setMcgList(List<Magic_Career_Grade> mcgList) {
        this.mcgList = mcgList;
    }
    public List<Monsters_Magic> getMmlist() {
        return mmlist;
    }

    public void setMmlist(List<Monsters_Magic> mmlist) {
        this.mmlist = mmlist;
    }

    public Magic getPlayerMagic() {
        return playerMagic;
    }

    public void setPlayerMagic(Magic playerMagic) {
        this.playerMagic = playerMagic;
    }

    public Magic getMonsterMagic() {
        return monsterMagic;
    }

    public void setMonsterMagic(Magic monsterMagic) {
        this.monsterMagic = monsterMagic;
    }

    public void setWantToBuyE(EquipmentBase equipment) {
        this.wantToBuyE = equipment;
    }
    public EquipmentBase getWantToBuyE(){
        return  wantToBuyE;
    }


    public List<EquipmentBase> getEquipmentBaseList() {
        return equipmentBaseList;
    }

    public void setEquipmentBaseList(List<EquipmentBase> equipmentBaseList) {
        this.equipmentBaseList = equipmentBaseList;
    }

    public List<Equipment> getEquipmentTrue() {
        return equipmentTrue;
    }

    public void setEquipmentTrue(List<Equipment> equipmentTrue) {
        this.equipmentTrue = equipmentTrue;
    }

    public List<Equipment> getEquipmentFalse() {
        return equipmentFalse;
    }

    public void setEquipmentFalse(List<Equipment> equipmentFalse) {
        this.equipmentFalse = equipmentFalse;
    }


}
