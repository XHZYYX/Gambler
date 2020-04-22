package game.gambler.data.model;

public class Good {
    private int good_id;
    private String good_name;
    private int role_id;
    private int locationX;
    private int locationY;
    private int good_num;

    public Good(int good_id, String good_name, int role_id,
                int locationX, int locationY, int good_num) {
        this.good_id = good_id;
        this.good_name = good_name;
        this.role_id = role_id;
        this.locationX = locationX;
        this.locationY = locationY;
        this.good_num = good_num;
    }
}
