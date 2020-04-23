package game.gambler.part.data;

import game.gambler.part.data.model.Buff;
import game.gambler.part.data.model.Grade;
import game.gambler.part.data.model.Monsters;
import game.gambler.part.data.model.User;

import java.util.Map;

public class DataManager {

    private static DataManager _instance;
    public static DataManager getInstance(){
        if(_instance==null){
            _instance = new DataManager();
        }
        return  _instance;
    }
    //用户的数据应该存在那里
    private User user;
    //怪物的数据
    private Map<String, Monsters> MonstersMap;

    private Map<String, Buff>BuffMap;

    private Map<String, Grade> GradeMap;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
