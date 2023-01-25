package ZombieInvasion;

import java.awt.*;

public class coin extends GameObject{
    Handler handler;
    private int value;
    //private int id_num;

    public coin(int x, int y, ID id, int value, Handler handler, int id_num){
        super(x, y, ID.Coin, handler);
        this.handler = handler;
        this.value = value;
        this.id_num = id_num;
    }

    @Override
    public void tick() {
        if(collision()) {
            Game.balance += value;
            //handler.object.set(id_num, new PlaceHolder(0,0, ID.Placeholder, handler, id_num));
            handler.removeObject(this);
            System.out.println("Balance" + Game.balance);
        }
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(x, y, 10, 10);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, 10, 10);
    }

    private boolean collision(){
        for (int i = 0; i < handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject == null)
                continue;
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
