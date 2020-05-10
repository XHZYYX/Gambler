package game.gambler.part.UI.Panel;

import java.awt.*;

public class ProgressBar {
    private int max_Value;
    private int min_Value;

    private String title;
    private int x,y,w,h;

    private Color borderColor;
    private Color barColor;

    private int currentValue;

    public ProgressBar(int x,int y,int w ,int h,int max_Value){
        this.x =x;
        this.y =y;
        this.w =w;
        this.h =h;
        this.max_Value = max_Value;
        this.min_Value = 0;
        this.currentValue =max_Value;
    }


    public void render(Graphics graphics){
        graphics.setColor(borderColor);
        graphics.drawRect(x,y,w,h);
        graphics.setColor(barColor);
        if (currentValue>=max_Value){
            graphics.fillRect(x+1,y+1,w-1,h-2);
        }else{
            graphics.fillRect(x+1,y+1,(currentValue*w/max_Value)-1,h-1);
        }
        graphics.setColor(Color.BLACK);
        graphics.drawString(title+currentValue+"/"+max_Value,x,y+h);

    }
    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public void setBarColor(Color barColor) {
        this.barColor = barColor;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCurrentValue(int currentValue) {
        this.currentValue = currentValue;
    }
}
