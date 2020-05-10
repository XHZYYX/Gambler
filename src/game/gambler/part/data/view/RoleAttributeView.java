package game.gambler.part.data.view;

import game.gambler.part.data.model.*;

import java.util.List;

public class RoleAttributeView {

    private int role_id;


    public int getRole_id() {
        return role_id;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public List<Magic> getMagicList() {
        return magicList;
    }

    private Attribute attribute;
    private List<Magic> magicList;

    public RoleAttributeView(Attribute attribute, List<Equipment> equipments, List<Buff> buffs){

        int attack=0;
        int defense=0;
        int health = 0;
        this.attribute = new Attribute(attribute);
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
