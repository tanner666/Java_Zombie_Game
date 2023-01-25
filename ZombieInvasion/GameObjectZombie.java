package ZombieInvasion;

public abstract class GameObjectZombie extends GameObject{
    Handler handler;
    protected int wait;
    public GameObjectZombie(int x, int y, ID id, Handler handler) {
        super(x, y, id, handler);
        this.handler = handler;
    }

    protected void setPlaceHolder(int id_num){
        handler.object.set(id_num, new PlaceHolder(0,0, ID.Placeholder,handler,id_num));
    }

    protected boolean collision() {
        //checks if zombie intersects the player
        GameObject tempObject = handler.object.get(0);
        if (getBounds().intersects(tempObject.getBounds()))
            return true;
        return false;
    }
}
