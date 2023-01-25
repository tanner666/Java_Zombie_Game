package ZombieInvasion;

import java.awt.*;

public class Player extends ZombieInvasion.GameObject {

    private int wait = 0;
    private int health = 100;

    public Player(int x, int y, ZombieInvasion.ID id, Handler handler){
        super(x, y, id, handler);
        this.handler = handler;
    }

    public void tick(){
        x += velX;
        y += velY;

        x = ZombieInvasion.Game.clamp(x, 0, ZombieInvasion.Game.WIDTH-65);
        y = ZombieInvasion.Game.clamp(y, 110, Game.HEIGHT-145);

        if (wait == 0){
            collision();
            wait = 10;
        }
        else
            wait--;

        health = Game.clamp(health, 0, 100);

    }

    private void collision(){
        for (int i = 0; i < handler.object.size();i++){
            GameObject tempObject = handler.object.get(i);
            if(tempObject.getID() == ID.BasicZombie){
                //collision code
                if(getBounds().intersects(tempObject.getBounds())){
                    health -= 2;
                    System.out.println(health);
                    tempObject.setVelX(0);
                }
            }
            if(tempObject.getID() == ID.BigBoy){
                //collision code
                if(getBounds().intersects(tempObject.getBounds())){
                    health -= 10;
                    tempObject.setVelX(0);
                }
            }
        }
    }

    //public void setAnimate_state(int state){
       // animate_state = state;
    //}

    public void render(Graphics g){
        ImageImport i;
        switch(animate_state){
            case 1:
                i = new ImageImport(x, y, "Images\\characterv3f.png", g);
                break;
            case 3:
                i = new ImageImport(x, y, "Images\\characterv3b.png", g);
                break;
            default:
                i = new ImageImport(x, y, "Images\\characterv3.png", g);
                break;
        }
        i.scaleImage(80,110);
        i.createImage();
    }

    public Rectangle getBounds(){
        return new Rectangle(x + 13, y + 7, 60, 100);
    }

    public void setHealth(int health){
        this.health = health;
    }
    public int getHealth(){
        return health;
    }
}

