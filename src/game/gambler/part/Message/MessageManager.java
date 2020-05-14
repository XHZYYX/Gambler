package game.gambler.part.Message;

import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageManager {

    private static MessageManager _instance;//场景中心的单例的
    public static MessageManager getInstance(){
        if(_instance==null)
            _instance=new MessageManager();
        return _instance;
    }

    private Message message;

    private Stack<Message> MessageStack = new Stack<>();


    private  Queue<Message> MessageQueue = new LinkedBlockingQueue<>();

    public Message currentMessage=null;

    public void sendMessage(Message message){
        MessageQueue.offer(message);

    }

    public void pushMessageStack(Message message){
        //MessageStack.push(message);
        this.message= message;
    }

    public Message getTopMessageStack() {
        return message;
        //return MessageStack.pop();
    }

    public void handle(){

    }

    public void init(){

    }


    public void update(long elapsedTime){
            currentMessage = MessageQueue.peek();
            if (currentMessage!=null&&currentMessage.isHandler ==true)
            {
                MessageQueue.poll();
                System.out.println(currentMessage.getMsg_Content());
                currentMessage = MessageQueue.peek();
            }


    }
}
