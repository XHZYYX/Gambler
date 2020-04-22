package game.gambler.data.model;

public class Role_Buff {
    private int role_id;
    private int buff_id;

    public Role_Buff() {
    }
    public Role_Buff(int role_id,int buff_id){
        this.role_id =role_id;
        this.buff_id = buff_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public int getBuff_id() {
        return buff_id;
    }
}
