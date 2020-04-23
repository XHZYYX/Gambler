package game.gambler.core.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import game.gambler.data.model.User;


public class Jdbc {

    private Connection connection;
    String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名testdb
    String url = "jdbc:mysql://39.96.24.156:3306/grmbler?autoReconnect=true&amp;failOverReadOnly=false";

    private Statement statement;
    // MySQL配置时的用户名
    String user = "root";
    // MySQL配置时的密码
    String password = "980609";

    private static Jdbc _instance;//场景中心的单例的
    public static Jdbc getInstance() throws SQLException, ClassNotFoundException {
        if(_instance==null)
            _instance=new Jdbc();
        return _instance;
    }

    private Jdbc() throws ClassNotFoundException, SQLException {
        // 加载驱动程序
        Class.forName(driver);
        // 1.getConnection()方法，连接MySQL数据库！！
        connection = (Connection) DriverManager.getConnection(url, user, password);
        // 2.创建statement类对象，用来执行SQL语句！！
        statement = (Statement) connection.createStatement();
        // 要执行的SQL语句
    }

//    public List<User> jquery(String sql) throws SQLException{
//        ArrayList<User> users= new ArrayList<>();
//        ResultSet rs = statement.executeQuery(sql);
//        while (rs.next()) {
//            User user = new User();
//            user.setId(Integer.parseInt(rs.getString("id")));
//            user.setName(rs.getString("name"));
//            user.setAge(Integer.parseInt(rs.getString("age")));
//            users.add(user);
//        }
//        return users;
//    }
    public String queryUserByid(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        return sql;
    }

    public User queryUserByName(String name) throws SQLException {
        String sql = "select * from User where username = '"+name+"'";
        ResultSet rs = statement.executeQuery(sql);
        User user=new User();
        while (rs.next()){
             User newuser = new User(rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getInt("checkpoint"),
                    rs.getInt("coin")
             );
            user = newuser;
        }
        return user;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println(1);
        Jdbc jdbc = new Jdbc();
        User user = jdbc.queryUserByName("fukang");
        System.out.println(user.toString());
    }

}
