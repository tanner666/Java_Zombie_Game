package ZombieInvasion;

import java.awt.*;

public class HUD {

    private Handler handler;
    private int green;
    private int health;

    public HUD(Handler handler){
        this.handler = handler;
    }

    public void tick(){
        health = handler.object.get(0).getHealth();
        green = health * 2;
        green = Game.clamp(green, 0, 255);

    }

    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(Game.WIDTH - 250, 15, 200,32);
        g.setColor(new Color(75, green,0));
        g.fillRect(Game.WIDTH - 250, 15, health*2,32);
        g.setColor(Color.white);
        g.drawRect(Game.WIDTH - 250, 15, 200,32);
        Font fnt = new Font("arial", 1, 20);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Balance: " + Game.balance, 15, 30);
    }
}
