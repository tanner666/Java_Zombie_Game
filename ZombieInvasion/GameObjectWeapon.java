package ZombieInvasion;

import ZombieInvasion.GameObject;
import ZombieInvasion.Handler;
import ZombieInvasion.ID;

import java.awt.*;

public class GameObjectWeapon extends GameObject {

    public GameObjectWeapon(ID id, Handler handler){
        super(id, handler);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
    protected void collision(int id_num, int damage) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.BasicZombie) {
                //collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.HEALTH -= damage;
                    //handler.object.set(id_num, new PlaceHolder(0,0, ID.Placeholder, handler,id_num));
                    //handler.object.remove(this);
                    System.out.println(tempObject.HEALTH);
                    if (tempObject.HEALTH <= 0) {
                        handler.addObject(new coin(tempObject.x + 25, tempObject.y + 100, ZombieInvasion.ID.Coin, 10, handler, handler.assign_id_Number()));
                        handler.removeObject(tempObject);
                    }
                }
            }
            /*if (tempObject.getID() == ID.BigBoy) {
                //collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.HEALTH -= damage;
                    //handler.object.remove(this);
                    System.out.println(tempObject.HEALTH);
                    if (tempObject.HEALTH <= 0) {
                        handler.addObject(new coin(tempObject.x + 25, tempObject.y + 100, ZombieInvasion.ID.Coin, 100, handler, handler.assign_id_Number()));
                        //handler.object.remove(tempObject);
                    }
                }
            }

             */
        }
    }
}
