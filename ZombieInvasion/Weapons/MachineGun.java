package ZombieInvasion.Weapons;

import ZombieInvasion.*;
import ZombieInvasion.Projectiles.Bullet;
import java.awt.*;

import static ZombieInvasion.ID.Bullet;

public class MachineGun extends GameObject {
    private int reload = 200;
    private int mag = 25;
    private int spacer = 10;
    private final int damage = 15;

    public MachineGun(ID id, Handler handler){
        super(id, handler);
        x = Game.WIDTH - 80;
        y = Game.HEIGHT/2;
        this.handler = handler;
    }

    public void tick() {
        //adds a new bullet if mag isn't empty, proper bullet spacing time has passed, and space bar pushed
        if(fire == true && mag > 0 && spacer >= 10) {
            handler.addObject(new Bullet(x, y, Bullet, damage, handler, handler.assign_id_Number()));
            mag--;
            spacer = 0;
        }
        else if(mag == 0){
            reload = 0;
            mag--;
        }else if(reload < 200)
            reload+=1;
        else if(mag == -1 && reload >= 200)
            mag = 25;


        spacer++;


        GameObject player = handler.getObject(0);
        x = player.getX();
        y = player.getY() + 50;

    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x - 65, y - 15, "Images\\machinegunnb.png", g);
        i.scaleImage(140, 66);
        i.createImage();

        //reloading bar
        g.setColor(Color.red);
        g.drawRect(x + 19, y - 61, 27, 6);
        g.setColor(Color.black);
        g.fillRect(x + 20,y - 60,25,4);
        g.setColor(Color.gray);
        g.fillRect(x + 20, y - 60, mag, 4);

        Font fnt = new Font("arial", 1, 10);
        ImageImport k = new ImageImport(x+20, y-82, "Images\\reload.png", g);
        //reloading circle
        if(reload < 200){
            k.scaleImage(25, 20);
            k.createImage();
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString(""+((200-reload)/60 + 1), x+30, y-68);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 20);
    }
}
