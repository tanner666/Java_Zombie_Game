package ZombieInvasion;

import ZombieInvasion.Projectiles.Rock;
import java.awt.*;

public class SlingShot extends GameObject{

    private int reload = 100;
    private final int damage = 10;

    public SlingShot(int x, int y, ID id, Handler handler){
        super(x, y, id, handler);
        this.handler = handler;
    }

    public void tick() {
        if(fire == true && reload >= 100) {
            handler.addObject(new Rock(x, y, ZombieInvasion.ID.Rock, damage, handler, handler.assign_id_Number()));
            reload = 0;
        }
        if(reload < 100)
            reload+=1;

        for (int i = 0; i < handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getID() == ID.Player){
                x = tempObject.getX();
                y = tempObject.getY() + 50;
            }
        }
    }

    public void render(Graphics g) {
        ImageImport i = new ImageImport(x , y - 10, "Images\\slingshotnb.png", g);
        i.scaleImage(25, 50);
        i.createImage();

        //reloading bar
        g.setColor(Color.gray);
        g.drawRect(x + 20,y - 60,25,5);
        g.setColor(Color.gray);
        g.fillRect(x + 20, y - 60, reload/4, 4);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 20);
    }
}
