package ZombieInvasion.Weapons;

import ZombieInvasion.*;
import ZombieInvasion.Projectiles.Rock;
import java.awt.*;

public class SlingShot extends GameObjectWeapon {
    private final int RELOAD_TIME = 70;

    private int reload = RELOAD_TIME;

    private final int damage = 20;
    private GameObject player;

    public SlingShot(ID id, Handler handler){
        super(id, handler);
        x = Game.WIDTH - 80;
        player = handler.getObject(0);
        y = Game.HEIGHT/2;
        this.handler = handler;

    }

    public void tick() {
        if(fire && reload >= RELOAD_TIME) {
            handler.addObject(new Rock(x, y, ZombieInvasion.ID.Rock, damage, handler, handler.assign_id_Number()));
            reload = 0;
        }
        if(reload < RELOAD_TIME)
            reload+=1;

        x = player.getX();
        y = player.getY() + 50;

    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x , y - 10, "Images\\slingshotnb.png", g);
        i.scaleImage(25, 50);
        i.createImage();

        //reloading bar
        g.setColor(Color.gray);
        g.drawRect(x + 20,y - 60,25,5);
        g.setColor(Color.gray);
        g.fillRect(x + 20, y - 60, (int)(reload/3*1.1), 4);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 20);
    }
}
