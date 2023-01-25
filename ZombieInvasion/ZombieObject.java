package ZombieInvasion;

import java.awt.*;

public abstract class ZombieObject extends GameObject{

    public ZombieObject(int x, int y, ID id, Handler handler){
        super(x,y,id,handler);
    }

    public void tick() {
    }

    public void render(Graphics g) {
    }

    public Rectangle getBounds() {
        return null;
    }
    public boolean collision(){
        for (int i = 0; i < handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.Player){
                //collision code
                if(getBounds().intersects(tempObject.getBounds())){
                    return true;
                }
            }
        }
        return false;
    }
}
