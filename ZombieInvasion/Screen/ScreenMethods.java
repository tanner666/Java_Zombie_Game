package ZombieInvasion.Screen;

import ZombieInvasion.Button;
import ZombieInvasion.Game;
import ZombieInvasion.Handler;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class ScreenMethods extends MouseAdapter {
    protected Game game;
    protected Button back;
    protected Handler handler;

    public void mousePressed(MouseEvent e) {
    }


}
