package game.gambler.part.data.model;

public class Magic_Career_Grade {
    private int career_id;
    private int grade;
    private int magic_id;



    public Magic_Career_Grade( int career_id, int grade,int magic_id) {
        this.magic_id = magic_id;
        this.career_id = career_id;
        this.grade = grade;
    }

    public int getMagic_id() {
        return magic_id;
    }

    public int getCareer_id() {
        return career_id;
    }

    public int getGrade() {
        return grade;
    }
}
