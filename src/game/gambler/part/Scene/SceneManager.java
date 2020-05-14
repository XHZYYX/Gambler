package game.gambler.part.Scene;

import game.gambler.core.Render.Sprite;
import game.gambler.core.Util.FrameRate;
import game.gambler.core.Window.GameWindow;
import game.gambler.part.Message.Message;
import game.gambler.part.Message.MessageManager;
import game.gambler.part.Scene.Sprite.Dice;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.Monsters;


import java.util.*;

public class SceneManager {

    private DataManager dataManager= DataManager.getInstance();
    private static SceneManager _instance;
    public static SceneManager getInstance(){
        if(_instance==null){
            _instance = new SceneManager();
        }
        return  _instance;
    }
    GameWindow gameWindow;
    Map<String,Sprite> SpriteList = new HashMap<>();
    Boolean CollisionDetetctionFlag = false;


    public Scene getNow() {
        return Now;
    }

    public GameWindow getGameWindow(){
        return gameWindow;
    }
    public void setGameWindow(GameWindow gameWindow){
        this.gameWindow = gameWindow;
    }
    //当前场景
    private Scene Now;
    //场景集合
    private Stack<Scene> SceneMap = new Stack<>();
    FrameRate frameRate;

    public void init(){
        frameRate = new FrameRate();
        //加载当前场景
    }
    public void update(long elapsedTime){
        if (Now!=null){
            Now.update(elapsedTime);
        }

        if(SpriteList.isEmpty()){
            CollisionDetetctionFlag= false;
        }else {
            CollisionDetetctionFlag= true;
        }

       // if(!CollisionDetetctionFlag){

       // }

        MessageManager messageManager = MessageManager.getInstance();
        Message message = messageManager.currentMessage;
        if (message!=null&&(message.getMsg_type().equals(Message.Msgtype.graphics_msg)
                ||message.getMsg_type().equals(Message.Msgtype.all_msg))){
            switch (message.getMsg_Content()){
                case "打开登录页面": LoginScene();break;
                case "登录成功": loadingChooseRole();break;
                case "账号密码错误":break;
                case "进入游戏":loadingHome();break;
                case "打开购买物品的页面":shopping();break;
                case "进入关卡":loadingCheckPoint();break;
                case "移动":dice6();break;
                case "战斗":battle();break;
                case "掷骰子完成":diceOver();break;
                case "遇到怪物了":BattleScene();break;
                case "玩家胜利":Victory();break;
                case "玩家失败":Defeat();break;
                case "返回主城":backHome();break;

                case "test":test();break;

            }
        }
    }

    private void backHome() {
        Scene scene = new HomeScene();
        changeScene(scene);
    }

    //失败后返回关卡页面
    private void Defeat() {
        String sceneName="";
        switch (dataManager.getCheckPoint()){
            case 1:sceneName = "FirstChapter";
            case 2:sceneName = "SecondChapter";
            case 3:sceneName = "ThirdChapter";
        }
        loadingCheckPoint();
    }
    //胜利后返回关卡页面
    private void Victory() {
        String sceneName="";
        switch (dataManager.getCheckPoint()){
            case 1:sceneName = "FirstChapter";
            case 2:sceneName = "SecondChapter";
            case 3:sceneName = "ThirdChapter";
        }
        loadingCheckPoint();
    }
    //点击战斗后 触发掷骰子的动画
    private void battle() {
        Dice dice = (Dice) Now.getSpriteMap().get("dice");
        int max = DataManager.getInstance().getRoleAttribute().getAttribute().getBase_max_Strength();
        dice.start(max);
    }

    //打开战斗场景
    private void BattleScene() {
        Monsters monsters =dataManager.getMonsters();
        changeScene(new BattleScene());
    }

    private void diceOver() {
        String messageContent= MessageManager.getInstance().getTopMessageStack().getMsg_Content();
        switch (messageContent){
            case "移动": DataManager.getInstance().move();break;
            case "战斗": DataManager.getInstance().battle();break;
            case "魔法":  break;
        }
    }

    private void dice6() {
        Dice dice = (Dice) Now.getSpriteMap().get("dice");
        dice.start(6);
    }

    private void loadingCheckPoint() {
        int check = dataManager.getCheckPoint();
        switch (check){
            case 1:changeScene(new FirstChapterScene());break;
            case 2:changeScene(new FirstChapterScene());break;
            case 3:changeScene(new FirstChapterScene());break;
            case 4:changeScene(new FirstChapterScene());break;
            case 5:changeScene(new FirstChapterScene());break;
            case 6:changeScene(new FirstChapterScene());break;
        }


    }

    private void shopping() {

    }

    private void test() {
        Now= new FirstChapterScene();
        //Now.setFrameRate(frameRate);
        gameWindow.setVisible(false);
        gameWindow.getContentPane().add(Now);
        gameWindow.setVisible(true);
    }

    private void loadingChooseRole() {
        Scene scene = new ChooseRoleScene();
        changeScene(scene);
    }


    private void loadingHome() {
        Scene scene = new HomeScene();
        changeScene(scene);
    }

    private void LoginScene() {
        Now= new login();
        //Now.setFrameRate(frameRate);
        gameWindow.setVisible(false);
        gameWindow.getContentPane().add(Now);
        gameWindow.setVisible(true);
    }

    public void shutdown(){

    }





    public void changeScene(Scene scene){
        //将旧的场景移除 并加入新的场景
        gameWindow.setVisible(false);
        gameWindow.getContentPane().remove(Now);
        //saveSceneToMap(Now);
        SceneMap.push(Now);
        Now.stop();
        gameWindow.getContentPane().add(scene);
        Now = scene;
        gameWindow.setVisible(true);
    }





    public void draw(){
        //绘制当前场景
        //因为场景是主动绘制 所以不用管
    }







//    public void saveSceneToMap(Scene scene){
//        if(!SceneMap.containsKey(scene.getName())){
//            SceneMap.put(scene.getSceneName(),scene);
//        }
//    }

//    public Scene querySceneByName(String name){
//        return SceneMap.get(name);
//    }

}
