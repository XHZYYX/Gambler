package game.gambler.part.Message;

public class Message {
    public enum Msgtype{
        logic_msg,graphics_msg;
    }
    Msgtype msg_type;//游戏逻辑信息 1


    String msg_Content;//消息内容

    boolean isHandler = false;

    public Message(Msgtype msg_type, String msg_Content) {
        this.msg_type = msg_type;
        this.msg_Content = msg_Content;
    }
    public void finish(){
        isHandler = true;
    }

    public Msgtype getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(Msgtype msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_Content() {
        return msg_Content;
    }

    public void setMsg_Content(String msg_Content) {
        this.msg_Content = msg_Content;
    }
}
