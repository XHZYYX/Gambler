package game.gambler.data.model;

public class Record {
    private int record_id;
    private int role_id;
    private int record_positionX;
    private int record_positionY;
    private int temp_hp;
    private int temp_mp;
    private int record_checkpoint;

    public Record(int record_id, int role_id, int record_positionX,
                  int record_positionY, int temp_hp, int temp_mp,
                  int record_checkpoint) {
        this.record_id = record_id;
        this.role_id = role_id;
        this.record_positionX = record_positionX;
        this.record_positionY = record_positionY;
        this.temp_hp = temp_hp;
        this.temp_mp = temp_mp;
        this.record_checkpoint = record_checkpoint;
    }

    public int getRecord_id() {
        return record_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public int getRecord_positionX() {
        return record_positionX;
    }

    public int getRecord_positionY() {
        return record_positionY;
    }

    public int getTemp_hp() {
        return temp_hp;
    }

    public int getTemp_mp() {
        return temp_mp;
    }

    public int getRecord_checkpoint() {
        return record_checkpoint;
    }
}
