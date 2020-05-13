package game.gambler.part.data.model;

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

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public String getGood_name() {
        return good_name;
    }

    public void setGood_name(String good_name) {
        this.good_name = good_name;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }
}
