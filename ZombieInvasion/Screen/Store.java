package ZombieInvasion.Screen;

import ZombieInvasion.Button;
import ZombieInvasion.Game;
import ZombieInvasion.Handler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Store extends ScreenMethods {
    private Handler handler;
    private Game game;
    private ZombieInvasion.Button back;

    public Store(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        back = new Button(Game.WIDTH/2, Game.HEIGHT/2, 200, 200, Color.white);
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, back.getX(), back.getY(), back.getWidth(), back.getHeight())){
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
        g.drawString("Store", Game.WIDTH/2 - 75, 70);
        g.drawString("Store", Game.WIDTH/2 - 75, 70);

        back.render(g, "Play", Color.white, fnt2);

    }
}
