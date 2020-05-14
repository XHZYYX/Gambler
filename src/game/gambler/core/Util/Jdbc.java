package game.gambler.core.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.*;
import game.gambler.part.data.view.ChooseRoleView;


public class Jdbc {

    private Connection connection;
    String driver = "com.mysql.jdbc.Driver";
    // URL指向要访问的数据库名testdb
    String url = "jdbc:mysql://39.96.24.156:3306/gambler?autoReconnect=true&amp;failOverReadOnly=false";

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
    //根据用户名 查询用户信息
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
    //根据用户查询全部角色信息
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
    //根据角色ID 查询 角色全部信息
    public Role queryRoleByRoleId(int role_id){
        Role role =new Role();
        try{
            String sql = "SELECT * FROM Role WHERE role_id ="+role_id;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                role = new Role(rs.getInt(1),rs.getInt(2),
                        rs.getInt(3),rs.getInt(4),
                        rs.getInt(5),rs.getString(6),rs.getInt(7));
            }
            return role;
        }catch (SQLException e){

        }
        return role;
    }
    //角色选择场景每个角色的信息视图  根据角色ID查询角色信息
    public ChooseRoleView queryChooseRoleViewByRoleId(int role_id ){
        String sql = "SELECT " +
                "Role.role_id," +
                "Role.role_name," +
                "Career.career_name," +
                "Grade.grade " +
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
        Monsters monsters=jdbc.queryMonsterById(1);
        System.out.println(monsters.getMonster_id());
        //User user = jdbc.queryUserByName("fukang");
        //System.out.println(user.toString());
    }
    //注册用户
    public void newUser(String username,String password){
        String sql = "INSERT INTO `User` (`username`, `password`, `checkpoint`, `coin`)" +
                " VALUES ('"+username+"', '"+password+"', '1', '100')";
        try{
            statement.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //查询全部职业
    public List<Career> queryAllCareer(){
        String sql = "SELECT * " +
                "FROM Career";
        List<Career> Career=new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Career career= new Career(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8));
                Career.add(career);
            }

        }catch (SQLException e){

        }
        return Career;
    }

    //新建角色
    public void newRole(Career career,String role) {
        int user_id=DataManager.getInstance().getUser().getUser_id();
        String sql = "INSERT INTO `Role` (`grade`, `user_id`, `career_id`, `role_name`, `currentEmpiricalValue`) " +
                "VALUES ('1', '"+user_id+"', '"+career.getCareer_id()+"','"+role+"', '0')";
        try{
            statement.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
    //通过monsters_id查询怪物
    public Monsters queryMonsterById(int monsters_id) {
        String sql ="SELECT * FROM Monsters " +
                "WHERE monster_id = "+ monsters_id;
        Monsters monsters = new Monsters();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                monsters = new Monsters(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),
                        rs.getInt(7),rs.getInt(8),
                        rs.getInt(9),rs.getInt(10));
            }
            return monsters;
        }catch (SQLException e){

        }
        return monsters;
    }


    //查询当前角色拥有的全部物品
    public List<Good> queryAllGood(Role role){
        String sql ="SELECT * FROM Good WHERE " +
                "role_id = '"+role.getRole_id()+"'";
        List<Good> goods = new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Good good= new Good(rs.getInt(1),rs.getString(2),
                        rs.getInt(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6));
                goods.add(good);
            }

        }catch (SQLException e){

        }
        return  goods;
    }


    //查询全部商品基础信息
    public List<GoodBase> queryAllGoodBase(){
        String sql = "SELECT * FROM GoodBase";
        List<GoodBase> goodBases = new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                GoodBase goodBase= new GoodBase(rs.getString(1),rs.getString(2),
                        rs.getString(3),rs.getInt(4),
                        rs.getInt(5));
                goodBases.add(goodBase);
            }

        }catch (SQLException e){

        }
        return goodBases;
    }

    //查询当前角色已经穿戴的装备
    public List<Equipment> queryTrueEquipment(Role role){
        String sql = "SELECT * FROM Equipment " +
                " WHERE role_id ='"+role.getRole_id()+"'" +
                " And equipment_boolean = true";
        List<Equipment> Equipments=new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Equipment equipment= new Equipment(rs.getInt(1),rs.getString(2),
                        rs.getBoolean(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getInt(7));
                Equipments.add(equipment);
            }

        }catch (SQLException e){

        }
        return Equipments;

    }
    //查询当前角色没有穿戴的装备
    public List<Equipment> queryFalseEquipment(Role role){
        String sql = "SELECT * FROM Equipment " +
                " WHERE role_id ='"+role.getRole_id()+"'" +
                " And equipment_boolean = false ";
        List<Equipment> Equipments=new ArrayList<>();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                Equipment equipment= new Equipment(rs.getInt(1),rs.getString(2),
                        rs.getBoolean(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),rs.getInt(7));
                Equipments.add(equipment);
            }
        }catch (SQLException e){
        }
        return Equipments;
    }
    //查询当前角色的基础属性
    public Attribute queryAttribute(Role role){
        String sql = "SELECT * FROM Attribute " +
                " WHERE career_id ='"+role.getCareer_id()+"'" +
                " And grade = '"+role.getGrade()+"'";

        Attribute attribute = new Attribute();
        try{
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                attribute = new Attribute(rs.getInt(1),rs.getInt(2),
                        rs.getInt(3),rs.getInt(4),
                        rs.getInt(5),rs.getInt(6),
                        rs.getInt(7),rs.getInt(8),
                        rs.getInt(9),rs.getInt(10),
                        rs.getInt(11),rs.getInt(12),
                        rs.getInt(13),rs.getInt(14),
                        rs.getInt(15)
                );
            }
            System.out.println(attribute.toString());
            return attribute;
        }catch (SQLException e){

        }
        return attribute;
    }
    //使已存在的good_id 的物品数量加1
    public void addgood(Good good){

        int num =good.getGood_num()+1;
        System.out.println(num);
        String sql ="UPDATE Good SET good_num = "+num+" WHERE good_id = "+good.getGood_id();
        try{
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void reducegood(Good good){
        int num =good.getGood_num()-1;
        System.out.println(num);
        String sql1 ="UPDATE Good SET good_num = "+num+" WHERE good_id = "+good.getGood_id();
        String sql2 = "DELETE FROM Good where good_id ="+good.getGood_id();
        try{
            if (num>0)
            statement.execute(sql1);
            else
                statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void newgood(GoodBase wantToBuy) {
        int role_id=DataManager.getInstance().getRole().getRole_id();
        String sql = "INSERT INTO `Good` (`good_name`, `role_id`,`good_num`) " +
                "VALUES ('"+wantToBuy.getGood_name()+"', '"+role_id+"', '1')";
        try{
            statement.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updataCoin(int Coin) {
        int user_id=DataManager.getInstance().getUser().getUser_id();
        String sql = "UPDATE User SET coin = "+Coin+" WHERE user_id = "+user_id;
        try{
            statement.execute(sql);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
