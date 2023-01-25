package ZombieInvasion.Zombies;

import ZombieInvasion.*;

import java.awt.*;

public class BigBoy extends GameObjectZombie {
    private Handler handler;
    private int timer = 0;
    //wait time when zombie collides with player
    private int wait = 50;
    private int id_num;

    public BigBoy(int x, int y, ZombieInvasion.ID id, Handler handler, int id_num){
        super(x,y,id,handler);
        this.handler = handler;
        velX = 1;
        velY = 0;
        HEALTH = 300;
        this.id_num = id_num;
    }

    public void tick(){
        if (timer == 5) {
            x += velX;
            timer = 0;
        }
        timer++;
        wait++;

        if(y <= 0 || y >= Game.HEIGHT-48){ velY = 0;}
        if(x <= 0 || x >= Game.WIDTH-30){velX = 0;}

        if(collision()){
            velX = 0;
            wait = 0;
        }

        if(wait >= 50){
            velX = 1;
        }
        //handler.addObject(new Trail(x, y, 16, 16, 0.01, ID.Trail, Color.red, handler));
    }

    public void render(Graphics g){
        ImageImport i = new ImageImport(x, y, "Images\\BigBoynb.png", g);
        i.scaleImage(180,205);
        i.createImage();
        g.setColor(Color.red);
        g.drawRect(x + 19,y+5,142,195);
        g.drawRect(x + 20, y-15, 150, 5);
        g.fillRect(x + 20, y-15, HEALTH/2, 5);

    }


    public Rectangle getBounds(){
        return new Rectangle(x + 19, y + 5, 142, 195);
    }
}
