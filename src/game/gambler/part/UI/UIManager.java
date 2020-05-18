package game.gambler.part.UI;


import game.gambler.core.Util.Jdbc;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Scene;
import game.gambler.part.Scene.SceneManager;
import game.gambler.part.UI.Box.*;
import game.gambler.part.UI.Button.*;
import game.gambler.part.UI.Panel.*;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Role;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


//提供UI控制的方法 而不是处理游戏逻辑
public class UIManager {


    //
    JTextField username;






    private static UIManager _instance;
    private Jdbc jdbc;
    public static UIManager getInstance(){
        if(_instance==null){
            _instance = new UIManager();
        }
        return  _instance;
    }
    private Map<String,Component> UImap;
    public UIManager(){
         jdbc=Jdbc.getInstance();
        this.UImap = new HashMap<>();
    }

    public void init(){

    }

    public void add(String componentName,Component component){
        this.UImap.put(componentName,component);
    }
    public void update(long elapsedTime){
        MessageManager messageManager =MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&(message.getMsg_type().equals(Message.Msgtype.graphics_msg)
                ||message.getMsg_type().equals(Message.Msgtype.all_msg))){
            switch (message.getMsg_Content()){
                case "打开登录页面":loginUI();break;
                case "打开注册框":registerUI();break;
                case "登录成功": chooseRole();break;
                case "进入游戏": HomeUI();break;
                case "账号密码错误":reLogin();break;
                case "打开属性面板": attributeBoxUI();break;
                case "打开购买商品页面":ShopUI();break;
                case "关卡选择": CheckPointChooseUI();break;
                case "进入关卡": ChapterControllerUI();break;
                case "遇到城堡了": chengbao();break;
                case "用户名重复": registerUserError();break;
                case "两次密码不一致": registerPassWDError();break;
                case "打开创建角色":newRoleUI();break;
                case "打开背包":openBackPackBox();break;
                case "遇到怪物了":BattleController();break;
                case "玩家胜利":Victory();break;
                case "玩家失败":Defeat();break;
                case "返回主城":HomeUI();break;
                case "打开魔法":PlayerMagicUI();break;
                case "打开装备面板":openEquipmentBox();break;
                case "打开购买装备页面":openEquipmentShopBox();break;
            }
        }
    }

    private void openEquipmentShopBox() {
        new EquipmentShopBox(256,128);
    }

    private void openEquipmentBox() {
        new EquipmentBox();
    }

    private void PlayerMagicUI() {
        new PlayerMagicBox("行动");
    }

    private  void Defeat(){
        show(queryUIByName("ChapterControllerBar"));
        updateChapterControllerBar();
        new ResuscitateTalkBox("你死了,是否使用救命草");
    }
    private void Victory() {
       show(queryUIByName("ChapterControllerBar"));
        updateChapterControllerBar();
        new TalkBox("恭喜你打败了怪兽");
    }




    private void BattleController() {
        show(new BattleControllerBar());
    }

    private void openBackPackBox() {
        new BackpackBox();
    }

    private void newRoleUI() {
        new CareerChooseBox();
    }

    private void registerPassWDError() {
        JLabel label = (JLabel)UIManager.getInstance().queryUIByName("ui-register-repasswd_error-tooltip");
        label.setText("两次密码不一致");
        RegisterBOX OldregisterBOX=(RegisterBOX)this.UImap.get("ui-register-registerBox");
        OldregisterBOX.setVisible(true);
    }

    private void registerUserError() {
        JLabel label = (JLabel)UIManager.getInstance().queryUIByName("ui-register-user_error-tooltip");
        System.out.println(label.getX());
        label.setText("用户名重复");
        RegisterBOX OldregisterBOX=(RegisterBOX)this.UImap.get("ui-register-registerBox");
        OldregisterBOX.setVisible(true);
    }

    private void chengbao() {
        new TalkBox("这是我的对话啊");
        System.out.println("cccc");
    }

    private void ChapterControllerUI() {
        show(new ChapterControllerBar());
    }

    private void CheckPointChooseUI() {
        new CheckPointChooseBox(256,128,DataManager.getInstance().getUser().getCheckpoint());
    }

    private void ShopUI() {
        new ShopBox(256,128);
        System.out.println("CCC");
    }

    private void attributeBoxUI() {
        new PropertyBox();
    }

    private void chooseRole() {

        //根据获取的信息组织页面
        ImageButton newRole = new newRoleButotn();
        ImageButton play = new playButton();

        show(newRole,new RoleChoosePanel(),play);


    }

    private void reLogin() {

        JPasswordField jPasswordField = (JPasswordField)queryUIByName("UI-login-password-input");
        JTextField username = (JTextField)queryUIByName("UI_login_username_input");
        new TalkBox("账号密码错误");
        //jPasswordField.setText("");
    }

    private void HomeUI() {
        DataManager.getInstance().cloneRoleAttribute();
        //左上角的属性框
        StatusBarPanel statusBarPanel = new StatusBarPanel(new Role());
        //左下角的菜单栏  背包 //属性 //装备
        MeanBar meanBar = new MeanBar(1000,680,300,70);
        meanBar.add(new inventoryButton());
        meanBar.add(new attitudeButton());
        meanBar.add(new equipmentButton());
        show(statusBarPanel,meanBar);
    }

    private void loginUI(){
        LoginPanel loginPanel = new LoginPanel();
        this.add("ui_login_panel",loginPanel);
//        //账号密码输入框
//        JTextField username = new JTextField(16);
//        username.setBounds(593,490,194,26);
//        this.UImap.put("UI-login-username-input",username);
//        JPasswordField passwd = new JPasswordField ();
//        passwd.setBounds(593,535,194,26);
//        registerButton register = new registerButton();
//        loginButton login = new loginButton();
//        this.UImap.put("UI-login-password-input",passwd);
        show(loginPanel);
        //show(username,passwd,register,login);
        //登录 注册按钮
    }

    private void PropertyBoxUI(){
       // PropertyBox propertyBox = new PropertyBox(20,20);
        JFrame j =SceneManager.getInstance().getGameWindow();
        Scene scene  = SceneManager.getInstance().getNow();
        System.out.println("PropertyBoxUI");

    }
    private void registerUI() {
        RegisterBOX registerBOX = new RegisterBOX(390,234);
        this.UImap.put("ui-register-registerBox",registerBOX);
    }

    public void draw(){
        //调用全部组件的draw方法
    }

    public void showPropertyBox(){

    }

    public Component queryUIByName(String name){
        return this.UImap.get(name);
    }




    public void show(Component... components){
        Scene scene  = SceneManager.getInstance().getNow();
        scene.setVisible(false);
        scene.addGUI(components);
        scene.setVisible(true);
    }

    public void updateBackpackBox(){
        BackpackBox backpackBox=(BackpackBox)queryUIByName("BackpackBox");
        backpackBox.dispose();
        UImap.remove(backpackBox);
    }
    public void updateEquipmentBox(){
        EquipmentBox equipmentBox=(EquipmentBox)queryUIByName("EquipmentBox");
        equipmentBox.dispose();
        UImap.remove(equipmentBox);
    }
    public void updateChapterControllerBar(){
        ChapterControllerBar chapterControllerBar=(ChapterControllerBar)queryUIByName("ChapterControllerBar");
        chapterControllerBar.setVisible(false);
        chapterControllerBar.reset();
        chapterControllerBar.setVisible(true);
    }
    public void updateStatusBarPanel(){
        StatusBarPanel statusBarPanel = (StatusBarPanel)queryUIByName("StatusBarPanel");
        statusBarPanel.setVisible(false);
        statusBarPanel.reset();
        statusBarPanel.setVisible(true);
    }

}
