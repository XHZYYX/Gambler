package game.gambler.part.Scene;

import java.util.Map;

public class SceneManager {

    private static SceneManager _instance;
    public SceneManager getInstance(){
        if(_instance==null){
            _instance = new SceneManager();
        }
        return  _instance;
    }
    //当前场景
    private Scene Now;
    //场景集合
    private Map<String,Scene> SceneMap;

    public void init(){

    }
    public void update(){
        //绘制场景
    }
    public void shutdown(){

    }
    public void changeScene(){

    }

    public Scene querySceneByName(String name){
        return SceneMap.get(name);
    }
}
