package ZombieInvasion;

import java.awt.*;

public class PlaceHolder extends GameObject{
    private Handler handler;
    private int id_num;


    public PlaceHolder(int x, int y, ID id, Handler handler, int id_num){
        super(x,y,id, handler);
        this.handler = handler;
        this.id_num = id_num;
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
}
