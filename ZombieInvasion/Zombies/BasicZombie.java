package ZombieInvasion.Zombies;

import ZombieInvasion.*;

import java.awt.*;
import java.util.LinkedList;

public class BasicZombie extends GameObjectZombie {

    private ZombieInvasion.Handler handler;
    private int timer = 0;
    private int id_number;


    public BasicZombie(int x, int y, ZombieInvasion.ID id, Handler handler, int id_num){
        super(x,y,id,handler);
        this.handler = handler;
        base_speed = 3;
        velX = 1;
        velY = 0;
        HEALTH = 50;
        id_number = id_num;
        wait = 50;
    }

    public void tick(){
        if (timer == 5) {
            x += velX;
            timer = 0;
        }
        timer++;

        if(y <= 0 || y >= Game.HEIGHT-48){ velY = 0;}

        if (HEALTH <= 0) {
            System.out.println("id: " + id_number);
            GameObject zombie = handler.getObject(id_number);
            System.out.println("NAME: " + zombie.getID());
            setPlaceHolder(id_number);
            System.out.println("Zombie Removed at id_number: " + id_number);
        }

        if(collision()){
            velX = 0;
            wait = 0;
        }

        if(wait >= 50){
            velX = base_speed;
        }
        wait++;

        if (reachedEnd())
            Game.stop();

    }

    public void render(Graphics g){
        ImageImport i = new ImageImport(x, y, "Images\\BasicZombie1cut.png", g);
        i.scaleImage(100,119);
        i.createImage();
        g.setColor(Color.red);
        g.drawRect(x + 25,y + 9,35,101);
        g.drawRect(x + 30, y, 25, 5);
        g.fillRect(x + 30, y, HEALTH/2, 5);





    }

    public Rectangle getBounds(){
        return new Rectangle(x + 25, y + 9, 35, 101);
    }
}
