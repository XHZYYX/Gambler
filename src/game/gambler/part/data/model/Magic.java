package game.gambler.part.data.model;

public class Magic {
    public Magic() {
    }

    public int getMaigc_id() {
        return maigc_id;
    }

    public void setMaigc_id(int maigc_id) {
        this.maigc_id = maigc_id;
    }

    public String getMagic_name() {
        return magic_name;
    }

    public void setMagic_name(String magic_name) {
        this.magic_name = magic_name;
    }

    public int getMagic_mana() {
        return magic_mana;
    }

    public void setMagic_mana(int magic_mana) {
        this.magic_mana = magic_mana;
    }

    public String getMagic_case() {
        return magic_case;
    }

    public void setMagic_case(String magic_case) {
        this.magic_case = magic_case;
    }

    public String getMagic_description() {
        return magic_description;
    }

    public void setMagic_description(String magic_description) {
        this.magic_description = magic_description;
    }

    public int getMagic_baseValue() {
        return magic_baseValue;
    }

    public void setMagic_baseValue(int magic_baseValue) {
        this.magic_baseValue = magic_baseValue;
    }

    //主键 id
    private int maigc_id;
    //魔法名称
    private String magic_name;

    public Magic(int maigc_id, String magic_name, int magic_mana, String magic_case, String magic_description, int magic_baseValue) {
        this.maigc_id = maigc_id;
        this.magic_name = magic_name;
        this.magic_mana = magic_mana;
        this.magic_case = magic_case;
        this.magic_description = magic_description;
        this.magic_baseValue = magic_baseValue;
    }

    //魔法消耗
    private int magic_mana;
    //使用场景
    private String magic_case;
    //魔法描述
    private String magic_description;
    //基础数值
    private int magic_baseValue;
}
