package game.gambler.part.data;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.data.model.*;
import game.gambler.part.data.view.ChooseRoleView;

import java.util.List;
import java.util.Map;

/*
*
* */
public class DataManager {
    Jdbc jdbc=Jdbc.getInstance();

    private static DataManager _instance;

    public static DataManager getInstance(){
        if(_instance==null){
            _instance = new DataManager();
        }
        return  _instance;
    }

    //保存当前登录的用户数据
    private User user;

    //保存当前选择的角色信息
    private Role role;

    //由当前角色生成的  精灵的 信息
    //当前的位置 以及动画的切换
    private Sprite playerSprite;

    private int dice;

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
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

//    private void loadUserInformation() {
//        //加载当前用户下的全部角色信息 。这个信息存在哪
//        //当前用户的信息在哪里存着
//        User user = DataManager.getInstance().getUser();
//        //通过user 查询改user下的全部role
//        List<Role> Roles= jdbc.queryRolesByUserId(user.getUser_id());
//        //根据角色信息加载页面
//        /*
//         * 需要的内容如下
//         * 角色 id
//         * 角色 名称
//         * 角色 等级
//         * 角色 职业
//         * */
//        List<ChooseRoleView> crvs = new ArrayList<>();
//        for (Role role:Roles){
//            crvs.add(jdbc.queryChooseRoleViewByRoleId(role.getRole_id()));
//        }
//        System.out.println("角色个数"+Roles.size());
//    }

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
}
