package ZombieInvasion.Screen;

import ZombieInvasion.Button;
import ZombieInvasion.Game;
import ZombieInvasion.Handler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends ScreenMethods {

    public Menu(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        back = new Button(Game.WIDTH/2 - 100, Game.HEIGHT/2- 25, 200, 50, Color.white);
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", Game.WIDTH/2 - 75, 70);

        back.render(g, "PLAY!", Color.white, fnt2);

    }
}
