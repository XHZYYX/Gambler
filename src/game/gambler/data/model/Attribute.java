package game.gambler.data.model;

public class Attribute {
    //fk 等级
    private int grade;
    //fk 职业
    private int carrer_id;
    //知力
    private int base_Intellogence;
    //手力
    private int base_strength;
    //体力
    private int base_physical;
    //防御力
    private int base_defense;
    //攻击力
    private int base_attack;
    //最大攻击骰
    private int base_max_Strength;
    //最小攻击骰
    private int base_min_Strength;
    //最小魔法骰
    private int base_min_Magic;
    //最小魔法骰
    private int base_max_Magic;
    //基础血量
    private int base_HP;
    //基础魔法值
    private int base_MP;
    //攻击力成长
    private int growth_strength;
    //体力成长
    private int growth_physical;

    public Attribute(int grade, int carrer_id, int base_Intellogence,
                     int base_strength, int base_physical,
                     int base_defense, int base_attack,
                     int base_max_Strength, int base_min_Strength,
                     int base_min_Magic, int base_max_Magic, int base_HP,
                     int base_MP, int growth_strength, int growth_physical) {
        this.grade = grade;
        this.carrer_id = carrer_id;
        this.base_Intellogence = base_Intellogence;
        this.base_strength = base_strength;
        this.base_physical = base_physical;
        this.base_defense = base_defense;
        this.base_attack = base_attack;
        this.base_max_Strength = base_max_Strength;
        this.base_min_Strength = base_min_Strength;
        this.base_min_Magic = base_min_Magic;
        this.base_max_Magic = base_max_Magic;
        this.base_HP = base_HP;
        this.base_MP = base_MP;
        this.growth_strength = growth_strength;
        this.growth_physical = growth_physical;
    }

    public int getGrade() {
        return grade;
    }

    public int getCarrer_id() {
        return carrer_id;
    }

    public int getBase_Intellogence() {
        return base_Intellogence;
    }

    public int getBase_strength() {
        return base_strength;
    }

    public int getBase_physical() {
        return base_physical;
    }

    public int getBase_defense() {
        return base_defense;
    }

    public int getBase_attack() {
        return base_attack;
    }

    public int getBase_max_Strength() {
        return base_max_Strength;
    }

    public int getBase_min_Strength() {
        return base_min_Strength;
    }

    public int getBase_min_Magic() {
        return base_min_Magic;
    }

    public int getBase_max_Magic() {
        return base_max_Magic;
    }

    public int getBase_HP() {
        return base_HP;
    }

    public int getBase_MP() {
        return base_MP;
    }

    public int getGrowth_strength() {
        return growth_strength;
    }

    public int getGrowth_physical() {
        return growth_physical;
    }
}
