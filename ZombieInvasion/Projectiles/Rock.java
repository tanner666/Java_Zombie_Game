package ZombieInvasion.Projectiles;

import ZombieInvasion.*;

import java.awt.*;

public class Rock extends GameObjectProjectile{

    Handler handler;
    private int damage;
    private int id_num;

    public Rock(int x, int y, ID id, int damage, Handler handler, int id_num){
        super(x, y, id, handler);
        this.handler = handler;
        this.damage = damage;
        velX = 5;
    }

    public void tick() {
        x -= velX;
        collision(id_num, damage);
    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x, y, "C:\\Users\\gtann\\OneDrive\\Pictures\\round-rock.png", g);
        i.scaleImage(10, 10);
        i.createImage();

    }
    public Rectangle getBounds() {
        return new Rectangle(x, y , 20, 20);
    }


}
