package game.gambler.data.model;

public class EquipmentBase {
    //装备名称
    private String equipment_name;
    //所属位置
    private String equipment_position;
    //图片路径
    private String equipment_imagePath;
    //回收价格
    private int equipment_RecoveryPrice;
    //出售价格
    private int equipment_SellingPrice;
    //等级限制
    private int grade;

    public EquipmentBase(String equipment_name, String equipment_position,
                         String equipment_imagePath, int equipment_RecoveryPrice,
                         int equipment_SellingPrice, int grade) {
        this.equipment_name = equipment_name;
        this.equipment_position = equipment_position;
        this.equipment_imagePath = equipment_imagePath;
        this.equipment_RecoveryPrice = equipment_RecoveryPrice;
        this.equipment_SellingPrice = equipment_SellingPrice;
        this.grade = grade;
    }

    public String getEquipment_name() {
        return equipment_name;
    }

    public String getEquipment_position() {
        return equipment_position;
    }

    public String getEquipment_imagePath() {
        return equipment_imagePath;
    }

    public int getEquipment_RecoveryPrice() {
        return equipment_RecoveryPrice;
    }

    public int getEquipment_SellingPrice() {
        return equipment_SellingPrice;
    }

    public int getGrade() {
        return grade;
    }
}
