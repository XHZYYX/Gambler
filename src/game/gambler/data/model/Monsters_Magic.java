package game.gambler.data.model;

public class Monsters_Magic {
    private int monster_id;
    private int magic_id;

    public Monsters_Magic(int monster_id, int magic_id) {
        this.monster_id = monster_id;
        this.magic_id = magic_id;
    }

    public int getMonster_id() {
        return monster_id;
    }

    public int getMagic_id() {
        return magic_id;
    }
}
