package ZombieInvasion.waves;

import ZombieInvasion.*;
import ZombieInvasion.Zombies.BasicZombie;
import ZombieInvasion.Zombies.BigBoy;

import java.util.Random;

public class Wave1{
    private final int max_enemy_count = 2;
    private final int spacer = 200;
    private int x, y, enemy_count = 0, delay = 200;
    Handler handler;
    Random gen = new Random();
    private long start = System.currentTimeMillis(), timer;

    public Wave1(Handler handler){
        this.handler = handler;
    }

    public void tick() {
        enemy_count = handler.objectCount(ID.BasicZombie) + handler.objectCount(ID.BigBoy);
        //spawns one basic zombie
        if(delay >= spacer && enemy_count < max_enemy_count){
            float t = gen.nextFloat()*1;
            int id_num = handler.assign_id_Number();
            if(t < .9)
                handler.addObject(new BasicZombie((int)(20 + 200 * t), (int) (Game.HEIGHT - 150 - 200 * t), ID.BasicZombie, handler, id_num));
            else
                handler.addObject(new BigBoy(101, Game.HEIGHT/2, ID.BigBoy, handler, handler.assign_id_Number()));
            delay = 0;
            enemy_count++;
            System.out.println(enemy_count);
        }
        delay++;
        timer = System.currentTimeMillis() - start;
        Game.clamp((int)timer, 0, 60);

    }

}
