package ZombieInvasion;

import ZombieInvasion.waves.Wave1;

import java.awt.*;

public class Spawner{
    private Handler handler;
    private Game game;
    private Wave1 wave1;
    long timer = 0;
    private boolean wave_end = false;


    public Spawner(Handler handler, Game game){
        this.handler = handler;
        this.game = game;
        wave1 = new Wave1(this.handler);
    }

    public void tick() {
        timer = System.currentTimeMillis() - Game.timer;
        timer = Game.clamp((int)timer, 0, 20000);

         if (timer < 20000) {
             wave1.tick();
             wave_end = true;
         }
         else if(wave_end){
             //clear_objects();
             game.gameScreen = Game.SCREEN.Store;
         }
         //else if(System.currentTimeMillis() - Game.timer < 120000){

         //}
    }

    public void clear_objects(){
        for (int i = 0; i < handler.object.size(); i++) {
            ZombieInvasion.GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() == ID.BasicZombie || tempObject.getID() == ID.BigBoy ||
                    tempObject.getID() == ID.Coin || tempObject.getID() == ID.Placeholder || tempObject.getID() == ID.Bullet) {
                handler.removeObject(tempObject);
                i--;
            }

        }
    }

    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect(Game.WIDTH - 100, 100, 100, 50);
        g.setColor(Color.white);
        g.drawString(String.valueOf(20 - timer/1000), Game.WIDTH - 100, 100);
    }
}


