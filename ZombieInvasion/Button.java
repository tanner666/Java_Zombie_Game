package ZombieInvasion;

import java.awt.*;

public class Button {
    private int x,y, width, height, mx, my;
    private Color color;
    private ID id;
    //private MouseEvent e;

    private Handler handler;

    public Button(int x, int y, int width, int height /*ID id*/, Color color){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        //this.id = id;
        this.color = color;
    }

    public void tick(){
       // MousePressed(e);
    }

    public void render(Graphics g){
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    public void render(Graphics g, String s, Color color, Font fnt){
        g.setColor(this.color);
        g.drawRect(x,y,width,height);
        g.setColor(color);
        g.setFont(fnt);
        int size = fnt.getSize();
        g.drawString(s, x+width/2 - size*s.length()/4, y+height/2+size/3);
    }


    //java Rectangle class has a method called intersects
    public Rectangle getBounds(int width, int height){
        return new Rectangle(x, y, width, height);
    }

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setID(ID id){
        this.id = id;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public ID getID(){
        return id;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
}
