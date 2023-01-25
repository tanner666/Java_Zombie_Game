package ZombieInvasion;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
    private static boolean AD, DA;
    private ZombieInvasion.Handler handler;
    public KeyInput(Handler handler){
        this.handler = handler;
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++){
            ZombieInvasion.GameObject tempObject = handler.object.get(i);
            if (tempObject == null)
                continue;
            if(tempObject.getID() == ZombieInvasion.ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_W)
                    tempObject.setVelY(-3);
                else if(key == KeyEvent.VK_S)
                    tempObject.setVelY(3);
                else if(key == KeyEvent.VK_A) {
                    tempObject.setVelX(-3);
                    AD = true;
                    tempObject.setAnimate_State(1);
                }
                else if(key == KeyEvent.VK_D) {
                    tempObject.setVelX(3);
                    DA = true;
                    tempObject.setAnimate_State(3);
                }

            }
            if(tempObject.getID() == ZombieInvasion.ID.SlingShot || tempObject.getID() == ZombieInvasion.ID.MachineGun
            || tempObject.getID() == ID.Bazooka || tempObject.getID() == ID.BaseballBat) {
                //key events for slingshot
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.setFire(true);
                }
            }
        }
        if(key == KeyEvent.VK_ESCAPE) System.exit(0);

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            if (tempObject == null)
                continue;
            if(tempObject.getID() == ID.Player){
                //key events for player 1
                if(key == KeyEvent.VK_W)
                    tempObject.setVelY(0);
                else if(key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                else if(key == KeyEvent.VK_A) {
                    if(DA != true)
                        tempObject.setVelX(0);
                    AD = false;
                    if(tempObject.animate_state == 1)
                        tempObject.setAnimate_State(2);
                }
                else if(key == KeyEvent.VK_D)  {
                    if(AD != true)
                        tempObject.setVelX(0);
                    DA = false;
                    if(tempObject.animate_state == 3)
                        tempObject.setAnimate_State(2);
                }

            }
            ID id = tempObject.getID();
            if(id == ZombieInvasion.ID.SlingShot || id == ZombieInvasion.ID.MachineGun
            || id == ID.Bazooka || id == ID.BaseballBat) {
                //key events for slingshot
                if (key == KeyEvent.VK_SPACE) {
                    tempObject.setFire(false);
                }
            }
        }
    }
}
