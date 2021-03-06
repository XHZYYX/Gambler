package game.gambler.core.Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import game.gambler.core.Render.Animation;
import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.*;
import game.gambler.part.data.view.ChooseRoleView;

import javax.xml.crypto.Data;


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
        if (_instance == null)
            _instance = new Jdbc();
        return _instance;
    }

    private Jdbc() {
        try {
            // 加载驱动程序
            Class.forName(driver);
            // 1.getConnection()方法，连接MySQL数据库！！
            connection = (Connection) DriverManager.getConnection(url, user, password);
            // 2.创建statement类对象，用来执行SQL语句！！
            statement = (Statement) connection.createStatement();
            // 要执行的SQL语句
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public static void main(String[] args) {
        // System.out.println(1);
        Jdbc jdbc = new Jdbc();

//        List<Equipment> equipment = jdbc.queryTrueEquipment();
//        System.out.println(equipment.size());
        Role role = new Role(5,1,1,1,1,"",12);
        jdbc.upgrade(role);
        int x = jdbc.getUpgradeExperience(1);
        System.out.println(x);

//        List<Magic_Career_Grade> magic_career_grades = jdbc.queryPlayerMagicID();
//        for (Magic_Career_Grade m : magic_career_grades) {
//            System.out.println(m.getMagic_id());
//        }


        // Monsters monsters=jdbc.queryMonsterById(1);
        //System.out.println(monsters.getMonster_id());
        //User user = jdbc.queryUserByName("fukang");
        //System.out.println(user.toString());
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

    public String queryUserByid(String sql) {
        try {
            ResultSet rs = statement.executeQuery(sql);
            return sql;
        } catch (SQLException e) {

        }
        return null;
    }

    public List<Role_Buff> queryRoleBuff(){
        int role_id=DataManager.getInstance().getRole().getRole_id();
        String sql = "SELECT * " +
                "FROM Role_Buff WHERE role_id="+role_id;
        List<Role_Buff> Role_Buffs = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role_Buff role_buff = new Role_Buff(rs.getInt(1), rs.getInt(2));
                Role_Buffs.add(role_buff);
            }

        } catch (SQLException e) {
        }
        return Role_Buffs;
    }
    //根据用户名 查询用户信息
    public User queryUserByName(String name) {
        try {
            String sql = "select * from User where username = '" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            User user = new User();
            while (rs.next()) {
                User newuser = new User(rs.getInt("user_id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getInt("checkpoint"),
                        rs.getInt("coin")
                );
                user = newuser;
            }
            return user;
        } catch (SQLException e) {
        }
        return null;
    }

    //根据用户查询全部角色信息
    public List<Role> queryRolesByUserId(int user_id) {
        List<Role> Roles = new ArrayList<>();
        try {
            String sql = "select * from Role where user_id = '" + user_id + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Role role = new Role(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7));
                Roles.add(role);
            }

        } catch (SQLException e) {

        }
        return Roles;
    }

    //根据角色ID 查询 角色全部信息
    public Role queryRoleByRoleId(int role_id) {
        Role role = new Role();
        try {
            String sql = "SELECT * FROM Role WHERE role_id =" + role_id;
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getString(6), rs.getInt(7));
            }
            return role;
        } catch (SQLException e) {

        }
        return role;
    }

    //角色选择场景每个角色的信息视图  根据角色ID查询角色信息
    public ChooseRoleView queryChooseRoleViewByRoleId(int role_id) {
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
                "Role.role_id = " + role_id;
//        String sql = "SELECT Grade.grade, Career.career_name, Role.role_name, Role.role_id FROM Role"+
//                " INNER JOIN Career ON Role.career_id = Career.career_id"+
//                "INNER JOIN Grade ON Role.grade = Grade.grade"+
//        "WHERE Role.role_id = "+role_id;
        ChooseRoleView crv = new ChooseRoleView();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                crv = new ChooseRoleView(rs.getInt(1),
                        rs.getInt(4), rs.getString(3),
                        rs.getString(2));
            }
            return crv;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //注册用户
    public void newUser(String username, String password) {
        String sql = "INSERT INTO `User` (`username`, `password`, `checkpoint`, `coin`)" +
                " VALUES ('" + username + "', '" + password + "', '1', '100')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //查询全部职业
    public List<Career> queryAllCareer() {
        String sql = "SELECT * " +
                "FROM Career";
        List<Career> Career = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Career career = new Career(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
                Career.add(career);
            }
        } catch (SQLException e) {
        }
        return Career;
    }

    //新建角色
    public void newRole(Career career, String role) {
        int user_id = DataManager.getInstance().getUser().getUser_id();
        String sql = "INSERT INTO `Role` (`grade`, `user_id`, `career_id`, `role_name`, `currentEmpiricalValue`) " +
                "VALUES ('1', '" + user_id + "', '" + career.getCareer_id() + "','" + role + "', '0')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //通过monsters_id查询怪物
    public Monsters queryMonsterById(int monsters_id) {
        String sql = "SELECT * FROM Monsters " +
                "WHERE monster_id = " + monsters_id;
        Monsters monsters = new Monsters();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                monsters = new Monsters(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6),
                        rs.getInt(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10));
            }
            return monsters;
        } catch (SQLException e) {

        }
        return monsters;
    }


    //查询当前角色拥有的全部物品
    public List<Good> queryAllGood(Role role) {
        String sql = "SELECT * FROM Good WHERE " +
                "role_id = '" + role.getRole_id() + "'";
        List<Good> goods = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Good good = new Good(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6));
                goods.add(good);
            }

        } catch (SQLException e) {

        }
        return goods;
    }


    //查询全部商品基础信息
    public List<GoodBase> queryAllGoodBase() {
        String sql = "SELECT * FROM GoodBase";
        List<GoodBase> goodBases = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                GoodBase goodBase = new GoodBase(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5));
                goodBases.add(goodBase);
            }

        } catch (SQLException e) {

        }
        return goodBases;
    }

    //查询当前角色已经穿戴的装备
    public List<Equipment> queryTrueEquipment() {
       Role role = DataManager.getInstance().getRole();

        String sql = "SELECT * FROM Equipment " +
                " WHERE role_id ='" + role.getRole_id() + "'" +
                " And equipment_boolean = '1'";
        List<Equipment> Equipments = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Equipment equipment = new Equipment(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getBoolean(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                Equipments.add(equipment);
            }

        } catch (SQLException e) {

        }
        return Equipments;

    }

    //查询当前角色没有穿戴的装备
    public List<Equipment> queryFalseEquipment() {
        Role role = DataManager.getInstance().getRole();

        String sql = "SELECT * FROM Equipment " +
                " WHERE role_id ='" + role.getRole_id() + "'" +
                " And equipment_boolean = false ";
        List<Equipment> Equipments = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Equipment equipment = new Equipment(rs.getInt(1), rs.getInt(2), rs.getString(3),
                        rs.getBoolean(4), rs.getInt(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                Equipments.add(equipment);
            }
        } catch (SQLException e) {
        }
        return Equipments;
    }

    //查询当前角色的基础属性
    public Attribute queryAttribute(Role role) {
        String sql = "SELECT * FROM Attribute " +
                " WHERE career_id ='" + role.getCareer_id() + "'" +
                " And grade = '" + role.getGrade() + "'";

        Attribute attribute = new Attribute();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                attribute = new Attribute(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3), rs.getInt(4),
                        rs.getInt(5), rs.getInt(6),
                        rs.getInt(7), rs.getInt(8),
                        rs.getInt(9), rs.getInt(10),
                        rs.getInt(11), rs.getInt(12),
                        rs.getInt(13), rs.getInt(14),
                        rs.getInt(15)
                );
            }
            System.out.println(attribute.toString());
            return attribute;
        } catch (SQLException e) {

        }
        return attribute;
    }

    //使已存在的good_id 的物品数量加1
    public void addgood(Good good) {

        int num = good.getGood_num() + 1;
        System.out.println(num);
        String sql = "UPDATE Good SET good_num = " + num + " WHERE good_id = " + good.getGood_id();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void reducegood(Good good) {
        int num = good.getGood_num() - 1;
        System.out.println(num);
        String sql1 = "UPDATE Good SET good_num = " + num + " WHERE good_id = " + good.getGood_id();
        String sql2 = "DELETE FROM Good where good_id =" + good.getGood_id();
        try {
            if (num > 0)
                statement.execute(sql1);
            else
                statement.execute(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newgood(GoodBase wantToBuy) {
        int role_id = DataManager.getInstance().getRole().getRole_id();
        String sql = "INSERT INTO `Good` (`good_name`, `role_id`,`good_num`) " +
                "VALUES ('" + wantToBuy.getGood_name() + "', '" + role_id + "', '1')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updataCoin(int Coin) {
        int user_id = DataManager.getInstance().getUser().getUser_id();
        String sql = "UPDATE User SET coin = " + Coin + " WHERE user_id = " + user_id;
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Magic_Career_Grade> queryPlayerMagicID() {
        int career_id = 1;// DataManager.getInstance().getRole().getCareer_id();
        int grade = 1;//DataManager.getInstance().getRole().getGrade();
        String sql = "SELECT * FROM Maigc_Career_Grade WHERE career_id =" + career_id +
                " AND grade <=" + grade;
        List<Magic_Career_Grade> mcgList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Magic_Career_Grade magic = new Magic_Career_Grade(rs.getInt(1), rs.getInt(2),
                        rs.getInt(3));
                mcgList.add(magic);
            }
        } catch (SQLException e) {
        }
        return mcgList;
    }

    public void setExperience(int value){
        Role role =DataManager.getInstance().getRole();
        String sql = "UPDATE Role SET currentEmpiricalValue = "+value+" WHERE role_id="+role.getRole_id();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
        }
    }

    //升级
    public void upgrade(Role role){
        int grade = role.getGrade();
        grade++;
        int id = role.getRole_id();
        String sql = "UPDATE Role SET grade = "+grade+" WHERE role_id="+id;
        try {
            statement.execute(sql);
        } catch (SQLException e) {
        }
    }

    //查询当前玩家升级所需经验值
    public int getUpgradeExperience(int grade){
        String sql = "SELECT Grade.EmpiricalValue FROM Grade WHERE grade= "+grade;
        int experience=0;
        try {
            System.out.println(1);
            ResultSet rs = statement.executeQuery(sql);
            System.out.println(2);
            while (rs.next()) {
                experience=rs.getInt(1);
            }
        } catch (SQLException e) {
        }
        return experience;
    }


    public List<Magic> queryPlayerMagic() {
        List<Magic_Career_Grade> mcgList = DataManager.getInstance().getMcgList();
        List<Magic> magics = new ArrayList<>();
        for (Magic_Career_Grade mcg : mcgList) {
            String sql = "SELECT * FROM Magic WHERE magic_id =" + mcg.getMagic_id();
            try {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Magic magic = new Magic(rs.getInt(1), rs.getString(2),
                            rs.getInt(3), rs.getString(4),
                            rs.getString(5), rs.getInt(6));
                    magics.add(magic);
                }
            } catch (SQLException e) {
            }
        }
        return magics;
    }


    public List<Monsters_Magic> queryMMListById() {
        String sql = "SELECT * FROM Monstaers_Magic WHERE monster_id =" + DataManager.getInstance().getMonsters().getMonster_id();
        List<Monsters_Magic> mmlist = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Monsters_Magic mm = new Monsters_Magic(rs.getInt(1),
                        rs.getInt(2));
                mmlist.add(mm);
            }
        } catch (SQLException e) {
        }
        return mmlist;
    }

    public List<Magic> queryMonsterMagic() {
        List<Monsters_Magic> mmList = DataManager.getInstance().getMmlist();
        List<Magic> magics = new ArrayList<>();
        for (Monsters_Magic mm : mmList) {
            String sql = "SELECT * FROM Magic WHERE magic_id =" + mm.getMagic_id();
            try {
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    Magic magic = new Magic(rs.getInt(1), rs.getString(2),
                            rs.getInt(3), rs.getString(4),
                            rs.getString(5), rs.getInt(6));
                    magics.add(magic);
                }
            } catch (SQLException e) {
            }
        }
        return magics;
    }

    public void addEquipment(Equipment equipment) {
        int role_id = DataManager.getInstance().getRole().getRole_id();
        String sql = "INSERT INTO `Equipment` (`role_id`, `equipment_name`," +
                "`equipment_boolean`,`equipment_enhancement`,`equipment_defence`,`equipment_attack`," +
                "`equipment_health`) " +
                "VALUES ('" + role_id + "', '" + equipment.getEquipment_name() + "','0','" + equipment.getEquipment_enhancement() + "','"
                + equipment.getEquipment_defence() + "', '"
                + equipment.getEquipment_attack() + "', '" + equipment.getEquipment_health() + "')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<EquipmentBase> queryEquipmentBase() {
        String sql = "SELECT * FROM EquipmentBase ";
        List<EquipmentBase> equipmentBaseList = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                EquipmentBase equipmentBase = new EquipmentBase(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getInt(4),
                        rs.getInt(5));
                equipmentBaseList.add(equipmentBase);
            }
        } catch (SQLException e) {
        }
        return equipmentBaseList;
    }

    public void reduceEquipment(Equipment equipment) {
        String sql = "DELETE FROM Equipment where equipment_id =" + equipment.getEquipment_id();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeFalseEquipment(Equipment equipment) {
        String sql = "UPDATE Equipment SET Equipment.equipment_boolean = 0 WHERE equipment_id ="+equipment.getEquipment_id();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeTrueEquipment(Equipment equipment) {
        String sql = "UPDATE Equipment SET Equipment.equipment_boolean = 1 WHERE equipment_id ="+equipment.getEquipment_id();
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Buff queryBuffbyId(int id) {
        Buff buff=new Buff();
        String sql = "SELECT * FROM Buff WHERE Buff_id="+id;

        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                buff = new Buff(rs.getInt(1),
                        rs.getInt(2),rs.getInt(2),
                        rs.getInt(4),rs.getString(5),rs.getString(6));
            }
        } catch (SQLException e) {
        }
        return buff;
    }

    public void setPlayerBuff(int buff_id){
        String sql="INSERT INTO `Role_Buff` (`role_id`,`Buff_id`) "+
                " VALUES ('"+DataManager.getInstance().getRole().getRole_id()+ "', '" +buff_id+"')";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


