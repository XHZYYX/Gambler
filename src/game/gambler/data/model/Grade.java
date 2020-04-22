package game.gambler.data.model;

public class Grade {
    //等级
    private int grade;
    //经验值
    private int EmpiricalValue;

    public Grade(int grade, int empiricalValue) {
        this.grade = grade;
        EmpiricalValue = empiricalValue;
    }

    public int getGrade() {
        return grade;
    }

    public int getEmpiricalValue() {
        return EmpiricalValue;
    }
}
