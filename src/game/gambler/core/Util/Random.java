package game.gambler.core.Util;

public class Random {
    private static Random _instance;//场景中心的单例的
    public static Random getInstance() {
        if(_instance==null)
            _instance=new Random();
        return _instance;
    }

    public int getRandom(int max){
        long  r;
        int i;
        while(true) {
            r = System.currentTimeMillis();
            //取模 也就是1----max的随机数
            i = (int)(r  % max);
            if(0 != i) {
                break;
            }
        }
        return i;
    }

}
