package game.gambler.data.model;

public class User {
    //用户id
    private int user_id;
    //用户名
    private String username;
    //密码
    private String password;
    //关卡进度
    private int checkpoint;
    //金币
    private int coin;

    public User(){

    }
    public User(int user_id, String username, String password, int checkpoint, int coin) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.checkpoint = checkpoint;
        this.coin = coin;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", checkpoint=" + checkpoint +
                ", coin=" + coin +
                '}';
    }
}
