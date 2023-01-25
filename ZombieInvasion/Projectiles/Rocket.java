package ZombieInvasion.Projectiles;

import ZombieInvasion.*;

import java.awt.*;

public class Rocket extends GameObjectProjectile {
    Handler handler;
    private int damage;
    public Rocket(int x, int y, ID id, int damage, Handler handler, int id_num){
        super(x, y, id, handler);
        this.handler = handler;
        this.damage = damage;
        velX = 5;
        this.id_num = id_num;
    }

    public void tick() {
        //error here:
        collision(id_num, damage);
        x -= velX;
        if(x < 0)
            setPlaceHolder(id_num);
    }
    public Rectangle getBounds() {
        return new Rectangle(x - 68, y + 44, 100, 18);
    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x-68, y+3, "Images\\rocket_adobespark.png", g);
        i.scaleImage(100, 100);
        i.createImage();
        g.drawRect(x - 68, y + 44, 100, 18);

    }
}