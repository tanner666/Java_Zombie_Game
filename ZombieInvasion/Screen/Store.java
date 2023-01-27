package ZombieInvasion.Screen;

import ZombieInvasion.Button;
import ZombieInvasion.Game;
import ZombieInvasion.Handler;
import ZombieInvasion.ID;
import ZombieInvasion.Weapons.Bazooka;
import ZombieInvasion.Weapons.MachineGun;
import ZombieInvasion.Weapons.SlingShot;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Store extends ScreenMethods {
    private Button weapon1, weapon2, weapon3, weapon4;
    public Store(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        back = new Button(game, Game.WIDTH/2 - 50, Game.HEIGHT/2 + 100, 100, 50,Color.white, Game.SCREEN.Game);
        weapon1 = new Button(game, Game.WIDTH/2 - 400, Game.HEIGHT/2 - 100, 200, 50,Color.white, 10, new SlingShot(ID.SlingShot, handler));
        weapon2 = new Button(game, Game.WIDTH/2 + 200, Game.HEIGHT/2 -  100, 200, 50,Color.white, 20, new MachineGun(ID.SlingShot, handler));
        weapon3 = new Button(game, Game.WIDTH/2 - 400, Game.HEIGHT/2 +  100, 200, 50,Color.white, 30, new Bazooka(ID.SlingShot, handler));
        weapon4 = new Button(game, Game.WIDTH/2 + 200, Game.HEIGHT/2 + 100, 200, 50,Color.white, 100, new SlingShot(ID.SlingShot, handler));
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        Font fnt = new Font("arial", 1, 50);
        Font fnt2 = new Font("arial", 1, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Store", Game.WIDTH/2 - 75, 70);
        g.setFont(fnt2);

        back.render(g, "Play", Color.white, fnt2);
        weapon1.render(g, "SlingShot", Color.white, fnt2);
        weapon2.render(g, "MachineGun", Color.white, fnt2);
        weapon3.render(g, "Bazooka", Color.white, fnt2);
        weapon4.render(g, "TBD", Color.white, fnt2);

    }
    public void mousePressed(MouseEvent e) {
        int x, y;
        x = e.getX();
        y = e.getY();
        back.buttonClicked(x, y);
        weapon1.buttonClicked(x,y);
        weapon2.buttonClicked(x,y);
        weapon3.buttonClicked(x,y);
        weapon4.buttonClicked(x,y);

    }
}
