package game.gambler.data.model;

public class Career {
    //职业id
    private int career_id;
    //职业名称
    private String career_name;
    //职业描述
    private String career_description;
    //攻击力
    private int atk;
    //防御力
    private int def;
    //知力
    private int intelligence;
    //手力
    private int strength;
    //体力
    private int physical;

    public Career(int career_id, String career_name, String career_description,
                  int atk, int def, int intelligence, int strength, int physical) {
        this.career_id = career_id;
        this.career_name = career_name;
        this.career_description = career_description;
        this.atk = atk;
        this.def = def;
        this.intelligence = intelligence;
        this.strength = strength;
        this.physical = physical;
    }

    public int getCareer_id() {
        return career_id;
    }

    public String getCareer_name() {
        return career_name;
    }

    public String getCareer_description() {
        return career_description;
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getStrength() {
        return strength;
    }

    public int getPhysical() {
        return physical;
    }
}
