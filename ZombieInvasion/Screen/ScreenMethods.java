package ZombieInvasion.Screen;

import ZombieInvasion.Game;
import ZombieInvasion.Handler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ScreenMethods extends MouseAdapter {
    protected ZombieInvasion.Button back;
    protected Game game;
    protected Handler handler;
    protected boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y + height)
                return true;
            else
                return false;
        }
        else
            return false;
    }

    //this method is overloaded from the Mouse Adapter class and will run
    //automatically without being called (it just works somehow)
    //I use it to detect when the back or play buttons are clicked
    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(mouseOver(mx, my, back.getX(), back.getY(), back.getWidth(), back.getHeight())){
            game.gameScreen = Game.SCREEN.Game;
            Game.timer = System.currentTimeMillis();
            //handler.addObject(new Button)
        }
    }
    public void mouseReleased(MouseEvent e){

    }
}
