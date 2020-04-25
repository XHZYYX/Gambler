package game.gambler.core.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import game.gambler.part.data.model.Role;
import game.gambler.part.data.model.User;
import game.gambler.part.data.view.ChooseRoleView;


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
    public static Jdbc getInstance() {
        if(_instance==null)
            _instance=new Jdbc();
        return _instance;
    }

    private Jdbc() {
        try{
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            connection = (Connection) DriverManager.getConnection(url, user, password);
            // 2.创建statement类对象，用来执行SQL语句！！
            statement = (Statement) connection.createStatement();
            // 要执行的SQL语句
        }catch (ClassNotFoundException| SQLException e){

        }

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
    public String queryUserByid(String sql)  {
        try{
            ResultSet rs = statement.executeQuery(sql);
            return sql;
        }catch (SQLException e){

        }
        return null;
    }

    public User queryUserByName(String name)  {
        try{
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
        }catch (SQLException e){

        }
        return null;
    }
    public List<Role> queryRolesByUserId(int user_id){
        List<Role> Roles=new ArrayList<>();
        try{
            String sql = "select * from Role where user_id = '"+user_id+"'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
               Role role = new Role(rs.getInt(1),rs.getInt(2),
                       rs.getInt(3),rs.getInt(4),
                       rs.getInt(5),rs.getString(6),rs.getInt(7));
                Roles.add(role);
            }

        }catch (SQLException e){

        }
        return Roles;
    }

    public ChooseRoleView queryChooseRoleViewByRoleId(int role_id ){
        String sql = "SELECT " +
                "Role.role_id," +
                "Role.role_name," +
                "Career.career_name," +
                "Grade.grade\n" +
                "FROM " +
                "Role " +
                "INNER JOIN Grade ON Role.grade = Grade.grade " +
                "INNER JOIN Career ON Role.career_id = Career.career_id " +
                "WHERE " +
                "Role.role_id = "+role_id;
//        String sql = "SELECT Grade.grade, Career.career_name, Role.role_name, Role.role_id FROM Role"+
//                " INNER JOIN Career ON Role.career_id = Career.career_id"+
//                "INNER JOIN Grade ON Role.grade = Grade.grade"+
//        "WHERE Role.role_id = "+role_id;
        ChooseRoleView crv = new ChooseRoleView();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                 crv = new ChooseRoleView(rs.getInt(1),
                        rs.getInt(4),rs.getString(3),
                        rs.getString(2));
            }
            return crv;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {

        System.out.println(1);
        Jdbc jdbc = new Jdbc();
        User user = jdbc.queryUserByName("fukang");
        System.out.println(user.toString());
    }

}
