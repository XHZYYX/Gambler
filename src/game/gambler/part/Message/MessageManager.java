package game.gambler.part.Message;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageManager {

    private static MessageManager _instance;//场景中心的单例的
    public static MessageManager getInstance(){
        if(_instance==null)
            _instance=new MessageManager();
        return _instance;
    }


    private  Queue<Message> MessageQueue = new LinkedBlockingQueue<>();

    public Message currentMessage=null;

    public  void sendMessage(Message message){
        MessageQueue.offer(message);

    }

    public void handle(){

    }






    public void update(){
        if (MessageQueue.size()==0) return;
        currentMessage = MessageQueue.peek();
        if (currentMessage.isHandler ==true)
        {
            MessageQueue.poll();
            currentMessage = MessageQueue.peek();
        }
    }
}
