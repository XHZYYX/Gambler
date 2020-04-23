package game.gambler.part.data.model;

public class Buff {
    //主键id
    private int Buff_id;
    //攻击力增益
    private int ActackIncrease;
    //血量增益
    private int HPIncrease;
    //防御力增益
    private int DefenseIncrease;
    //buff名称
    private String buff_name;
    //buff描述
    private String buff_description;

    public Buff() {
    }

    public Buff(int buff_id, int actackIncrease, int HPIncrease,
                int defenseIncrease, String buff_name, String buff_description) {
        Buff_id = buff_id;
        ActackIncrease = actackIncrease;
        this.HPIncrease = HPIncrease;
        DefenseIncrease = defenseIncrease;
        this.buff_name = buff_name;
        this.buff_description = buff_description;
    }

    public int getBuff_id() {
        return Buff_id;
    }

    public int getActackIncrease() {
        return ActackIncrease;
    }

    public int getHPIncrease() {
        return HPIncrease;
    }

    public int getDefenseIncrease() {
        return DefenseIncrease;
    }

    public String getBuff_name() {
        return buff_name;
    }

    public String getBuff_description() {
        return buff_description;
    }
}
