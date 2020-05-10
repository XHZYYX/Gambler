package game.gambler.part.data.model;

public class Role {
    //角色id
    private int role_id;
    //等级
    private int grade;
    //绑定用户id
    private int user_id;
    //存档id
    private int record_id;
    //绑定职业id
    private int career_id;
    //角色名称
    private String role_name;
    //当前经验值
    private int currentEmpiricalValue;

    public Role(){
    }


    public Role(Role role){
        this.role_id = role.role_id;
        this.grade = role.grade;
        this.user_id = role.user_id;
        this.record_id = role.record_id;
        this.career_id = role.career_id;
        this.role_name = role.role_name;
        this.currentEmpiricalValue = role.currentEmpiricalValue;



    }
    public Role(int role_id, int grade, int user_id, int record_id,
                int career_id, String role_name, int currentEmpiricalValue) {
        this.role_id = role_id;
        this.grade = grade;
        this.user_id = user_id;
        this.record_id = record_id;
        this.career_id = career_id;
        this.role_name = role_name;
        this.currentEmpiricalValue = currentEmpiricalValue;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRecord_id() {
        return record_id;
    }

    public void setRecord_id(int record_id) {
        this.record_id = record_id;
    }

    public int getCareer_id() {
        return career_id;
    }

    public void setCareer_id(int career_id) {
        this.career_id = career_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public int getCurrentEmpiricalValue() {
        return currentEmpiricalValue;
    }

    public void setCurrentEmpiricalValue(int currentEmpiricalValue) {
        this.currentEmpiricalValue = currentEmpiricalValue;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id=" + role_id +
                ", grade=" + grade +
                ", user_id=" + user_id +
                ", record_id=" + record_id +
                ", career_id=" + career_id +
                ", role_name='" + role_name + '\'' +
                ", currentEmpiricalValue=" + currentEmpiricalValue +
                '}';
    }
}
