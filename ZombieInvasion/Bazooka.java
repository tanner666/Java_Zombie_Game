package ZombieInvasion;

import ZombieInvasion.Projectiles.Rocket;
import java.awt.*;

public class Bazooka extends GameObject{
    private int reload = 100;
    private int mag = 1;
    private final int damage = 100, RELOAD = 100;

    public Bazooka(int x, int y, ID id, Handler handler){
        super(x, y, id, handler);
        this.handler = handler;
    }

    public void tick() {
        //adds a new bullet if mag isn't empty, proper bullet spacing time has passed, and space bar pushed
        if(fire && mag > 0) {
            handler.addObject(new Rocket(x, y, ID.Rocket, damage, handler, handler.assign_id_Number()));
            mag--;
        }
        else if(mag == 0){
            reload = 0;
            mag--;
        }else if(reload < 100)
            reload+=1;
        else if(mag == -1)
            mag = 1;

        GameObject player = handler.getObject(0);
        x = player.getX();
        y = player.getY() + 50;

    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x - 65, y - 15, "C:\\Users\\gtann\\Pictures\\Pictures\\bazooka.png", g);
        i.scaleImage(140, 66);
        i.createImage();

        //reloading bar
        g.setColor(Color.red);
        g.drawRect(x + 19, y - 61, 27, 6);
        g.setColor(Color.black);
        g.fillRect(x + 20,y - 60,25,4);
        g.setColor(Color.gray);
        g.fillRect(x + 20, y - 60, mag*25, 4);

        Font fnt = new Font("arial", 1, 10);
        ImageImport k = new ImageImport(x+20, y-82, "C:\\Users\\gtann\\Pictures\\Pictures\\reload.png", g);
        //reloading circle
        if(reload < RELOAD){
            k.scaleImage(25, 20);
            k.createImage();
            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString(""+((RELOAD-reload)/60 + 1), x+30, y-68);
        }
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 20);
    }
}
