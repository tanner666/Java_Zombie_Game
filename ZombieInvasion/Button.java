package ZombieInvasion;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Button extends MouseAdapter {
    private int x,y, width, height, price;
    private Color color;
    private ID id;
    //private MouseEvent e;
    private Game game;
    private Handler handler;
    private Game.SCREEN screen;
    private GameObject obj;

    public Button(Game game, int x, int y, int width, int height, Color color, Game.SCREEN screen){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        price = 0;
    }
    public Button(Game game, int x, int y, int width, int height, Color color, int price, GameObject obj){
        this.game = game;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.price = price;
        this.obj = obj;
    }

    public void tick(){

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

    //checks if mouse is over the button
    protected boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    public void buttonClicked(int mx, int my){
        //detects when button is clicked
        if (mouseOver(mx, my, x, y, width, height)) {
            //buy
            if (price != 0){
                if (Game.balance >= price && game.weapon.getID() != obj.getID()) {
                    game.changeWeapon(obj);
                    Game.balance -= price;
                }
            }
            //switch screens
            else {
                game.changeScreen(Game.SCREEN.Game);
                Game.timer = System.currentTimeMillis();
            }
        }
    }

    public void mouseReleased(MouseEvent e){

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
