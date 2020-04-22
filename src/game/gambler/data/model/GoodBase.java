package game.gambler.data.model;

public class GoodBase {
    //物品名称
    private String good_name;
    //物品描述
    private String good_description;
    //图片地址
    private String good_imagePath;
    //回收价格
    private int good_RecoveryPrice;
    //出售价格
    private int good_SellingPrice;

    public GoodBase(String good_name, String good_description, String good_imagePath,
                    int good_RecoveryPrice, int good_SellingPrice) {
        this.good_name = good_name;
        this.good_description = good_description;
        this.good_imagePath = good_imagePath;
        this.good_RecoveryPrice = good_RecoveryPrice;
        this.good_SellingPrice = good_SellingPrice;
    }

    public String getGood_name() {
        return good_name;
    }

    public String getGood_description() {
        return good_description;
    }

    public String getGood_imagePath() {
        return good_imagePath;
    }

    public int getGood_RecoveryPrice() {
        return good_RecoveryPrice;
    }

    public int getGood_SellingPrice() {
        return good_SellingPrice;
    }
}
