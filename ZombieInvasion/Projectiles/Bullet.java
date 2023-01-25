package ZombieInvasion.Projectiles;

import ZombieInvasion.*;

import java.awt.*;

public class Bullet extends GameObjectProjectile {
    Handler handler;
    private int damage;
    //private int id_num;

    public Bullet(int x, int y, ID id, int damage, Handler handler, int id_num){
        super(x, y, id, handler);
        this.handler = handler;
        this.damage = damage;
        velX = 5;
        this.id_num = id_num;
    }

    public void tick() {
        collision(id_num, damage);
        x -= velX;
        if(x < 0)
            setPlaceHolder(id_num);
    }
    public Rectangle getBounds() {
        return new Rectangle(x - 60, y + 6, 10, 5);
    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x-68, y+3, "Images\\cartoonbulletarmorpierceincendiary.png", g);
        i.scaleImage(10, 15);
        i.createImage();

    }
}
