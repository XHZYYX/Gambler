package game.gambler.part.data.view;

public class ChooseRoleView {
    private int role_id;
    private int grade;
    private String career_name;
    private String role_name;

    public ChooseRoleView(){}
    public ChooseRoleView(int role_id, int grade, String career_name, String role_name) {
        this.role_id = role_id;
        this.grade = grade;
        this.career_name = career_name;
        this.role_name = role_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public int getGrade() {
        return grade;
    }

    public String getCareer_name() {
        return career_name;
    }

    public String getRole_name() {
        return role_name;
    }
}
