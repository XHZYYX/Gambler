package game.gambler.part.data.model;

public class Monsters {
    private int monster_id;

    public void setMonster_HP(int monster_HP) {
        this.monster_HP = monster_HP;
    }

    public void setMonster_MP(int monster_MP) {
        this.monster_MP = monster_MP;
    }

    public Monsters() {
    }

    public Monsters(Monsters monsters){
        this.monster_id = monsters.monster_id;
        this.monster_name = monsters.monster_name;
        this.monster_HP = monsters.monster_HP;
        this.monster_MP = monsters.monster_MP;
        this.monster_attack = monsters.monster_attack;
        this.monster_defense = monsters.monster_defense;
        this.monster_max_magic = monsters.monster_max_magic;
        this.monster_min_magic = monsters.monster_min_magic;
        this.monster_max_Strength = monsters.monster_max_Strength;
        this.monster_min_Strength = monsters.monster_min_Strength;
    }

    public int getMonster_id() {
        return monster_id;
    }

    public String getMonster_name() {
        return monster_name;
    }

    public int getMonster_HP() {
        return monster_HP;
    }

    public int getMonster_MP() {
        return monster_MP;
    }

    public int getMonster_attack() {
        return monster_attack;
    }

    public int getMonster_defense() {
        return monster_defense;
    }

    public int getMonster_max_magic() {
        return monster_max_magic;
    }

    public int getMonster_min_magic() {
        return monster_min_magic;
    }

    public int getMonster_max_Strength() {
        return monster_max_Strength;
    }

    public int getMonster_min_Strength() {
        return monster_min_Strength;
    }

    public Monsters(int monster_id, String monster_name, int monster_HP, int monster_MP, int monster_attack, int monster_defense, int monster_max_magic, int monster_min_magic, int monster_max_Strength, int monster_min_Strength) {
        this.monster_id = monster_id;
        this.monster_name = monster_name;
        this.monster_HP = monster_HP;
        this.monster_MP = monster_MP;
        this.monster_attack = monster_attack;
        this.monster_defense = monster_defense;
        this.monster_max_magic = monster_max_magic;
        this.monster_min_magic = monster_min_magic;
        this.monster_max_Strength = monster_max_Strength;
        this.monster_min_Strength = monster_min_Strength;
    }

    private String monster_name;
    private int monster_HP;
    private int monster_MP;
    private int monster_attack;
    private int monster_defense;
    private int monster_max_magic;
    private int monster_min_magic;
    private int monster_max_Strength;
    private int monster_min_Strength;
}
