package game.gambler.part.data.view;

import game.gambler.part.data.DataManager;
import game.gambler.part.data.model.*;

import java.util.List;

public class RoleAttributeView {

    private int role_id;
    private Attribute attribute;

    public int getRole_id() {
        return role_id;
    }

    public Attribute getAttribute() {
        return attribute;
    }
    public RoleAttributeView(){}
    public RoleAttributeView(Attribute attribute, List<Equipment> equipments, List<Buff> buffs){

        int Equipment_attack=0;
        int Equipment_defense=0;
        int Equipment_health = 0;
        int Buff_attack=0;
        int Buff_defense=0;
        int Buff_health=0;
        this.attribute = attribute;
        System.out.println(attribute.toString());
        if (equipments!=null){
            for (Equipment equipment:equipments){
                int enhancement=equipment.getEquipment_enhancement();
                Equipment_attack+=equipment.getEquipment_attack();
                Equipment_defense+=equipment.getEquipment_defence();
                Equipment_health+=equipment.getEquipment_health();
                Equipment_defense+=enhancement;
                Equipment_defense+=enhancement;
                Equipment_health+=enhancement;
            }
            this.attribute.setBase_attack(this.attribute.getBase_attack()+Equipment_attack);
            System.out.println("装备增加攻击力"+Equipment_attack);
            this.attribute.setBase_defense(this.attribute.getBase_defense()+Equipment_defense);
            System.out.println("装备增加防御力"+Equipment_defense);
            this.attribute.setBase_HP(this.attribute.getBase_HP()+Equipment_health);
        }
        if (buffs!=null){
            for (Buff buff:buffs){
                Buff_attack+=buff.getAttackIncrease();
                Buff_defense+=buff.getDefenseIncrease();
                Buff_health+=buff.getHPIncrease();
            }
            this.attribute.setBase_attack(this.attribute.getBase_attack()+Buff_attack);
            this.attribute.setBase_defense(this.attribute.getBase_defense()+Buff_defense);
            this.attribute.setBase_HP(this.attribute.getBase_HP()+Buff_health);
        }
    }

    public RoleAttributeView clone(RoleAttributeView r2){

        Attribute a1 = new Attribute(r2.getAttribute());
        RoleAttributeView r1=  new RoleAttributeView(a1,null,null);
        return r1;
    }
}
