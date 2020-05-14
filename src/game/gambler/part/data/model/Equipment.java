package game.gambler.part.data.model;

public class Equipment {
    //装备唯一id
    private int equipment_id;

    private int role_id;
    private String equipment_name;
    //装备是否装备
    private boolean equipment_boolean;

    //装备强化等级
    private int equipment_enhancement;

    //装备增加防御
    private int equipment_defence;
    //装备增加攻击
    private int equipment_attack;
    //装备增加血量
    private int equipment_health;

    public Equipment(int equipment_id,int role_id, String equipment_name,
                     boolean equipment_boolean, int equipment_enhancement,
                     int equipment_defence, int equipment_attack, int equipment_health) {
        this.equipment_id = equipment_id;
        this.role_id = role_id;
        this.equipment_name = equipment_name;
        this.equipment_boolean = equipment_boolean;
        this.equipment_enhancement = equipment_enhancement;
        this.equipment_defence = equipment_defence;
        this.equipment_attack = equipment_attack;
        this.equipment_health = equipment_health;
    }

    public int getEquipment_id() {
        return equipment_id;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public boolean isEquipment_boolean() {
        return equipment_boolean;
    }

    public int getEquipment_enhancement() {
        return equipment_enhancement;
    }

    public int getEquipment_defence() {
        return equipment_defence;
    }

    public int getEquipment_attack() {
        return equipment_attack;
    }

    public int getEquipment_health() {
        return equipment_health;
    }
}
