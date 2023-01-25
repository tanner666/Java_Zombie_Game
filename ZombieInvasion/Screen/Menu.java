package ZombieInvasion.Screen;

import ZombieInvasion.Button;
import ZombieInvasion.Game;
import ZombieInvasion.Handler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends ScreenMethods {
    private Handler handler;
    private Game game;
    private ZombieInvasion.Button normal;

    public Menu(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        normal = new Button(Game.WIDTH/2 - 100, Game.HEIGHT/2- 25, 200, 50, Color.white);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, normal.getX(), normal.getY(), normal.getWidth(), normal.getHeight())){
            game.gameState = Game.STATE.Game;
            Game.timer = System.currentTimeMillis();
            //handler.addObject(new Button)
        }
    }

    public void mouseReleased(MouseEvent e){

    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", Game.WIDTH/2 - 75, 70);

        normal.render(g, "Play", Color.white, fnt2);

    }
}
