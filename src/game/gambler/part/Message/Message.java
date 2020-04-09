package game.gambler.part.Message;

public class Message {
    int msg_type;


    String msg_Content;//消息内容

    boolean isHandler = false;

    public Message(int msg_type, String msg_Content) {
        this.msg_type = msg_type;
        this.msg_Content = msg_Content;
    }
    public void finish(){
        isHandler = true;
    }

    public int getMsg_type() {
        return msg_type;
    }

    public void setMsg_type(int msg_type) {
        this.msg_type = msg_type;
    }

    public String getMsg_Content() {
        return msg_Content;
    }

    public void setMsg_Content(String msg_Content) {
        this.msg_Content = msg_Content;
    }
}
