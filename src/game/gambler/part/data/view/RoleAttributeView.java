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

        int attack=0;
        int defense=0;
        int health = 0;
        this.attribute = attribute;
        System.out.println(attribute.toString());
        if (equipments!=null){
            for (Equipment equipment:equipments){
                int enhancement=equipment.getEquipment_enhancement();
                attack+=equipment.getEquipment_attack()+enhancement;
                defense+=equipment.getEquipment_defence()+enhancement;
                health+=equipment.getEquipment_health()+enhancement;
            }
            this.attribute.setBase_attack(this.attribute.getBase_attack()+attack);
            this.attribute.setBase_defense(this.attribute.getBase_defense()+defense);
            this.attribute.setBase_HP(this.attribute.getBase_HP()+health);
        }
    }

    public RoleAttributeView clone(RoleAttributeView r2){

        Attribute a1 = new Attribute(r2.getAttribute());
        RoleAttributeView r1=  new RoleAttributeView(a1,null,null);
        return r1;
    }
}
