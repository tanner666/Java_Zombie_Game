package ZombieInvasion;

import java.awt.*;

public abstract class GameObject {
    //everything in the game (players, enemies, items, etc) are all game objetcs
    protected int x, y, id_num;
    protected ID id;
    protected int velX, velY; //speed in x and y direction
    protected boolean fire;
    protected int animate_state;
    protected int HEALTH;

    protected Handler handler;

    public GameObject(int x, int y, ID id, Handler handler){
        this.x = x;
        this.y = y;
        this.id = id;
        this.handler = handler;
    }
    public GameObject(ID id, Handler handler){
        this.id = id;
        this.handler = handler;
    }

    //since these are abstract, makes it so we have to define these for each of our players/enemies etc.
    public abstract void tick();
    public abstract void render(Graphics g);
    //java Rectangle class has a method called intersects
    public abstract Rectangle getBounds();

    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setID(ID id){
        this.id = id;
    }
    public void setVelX(int velx){
        velX = velx;
    }
    public void setVelY(int vely){
        velY = vely;
    }
    public void setFire(boolean b){fire = b;}
    public void setAnimate_State(int state){
        animate_state = state;
    }
    public int getHealth(){
        return HEALTH;
    }
    public void setHealth(int health){
        HEALTH = health;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public ID getID(){
        return id;
    }
    public int getID_num(){
        return id_num;
    }
    public void setID_num(int id_num){
        this.id_num = id_num;
    }
    public int getVelX(){
        return velX;
    }
    public int getVelY(){
        return velY;
    }
    public void decrementID(){

    }

}
