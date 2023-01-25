package ZombieInvasion.Screen;

import java.awt.event.MouseAdapter;

public class ScreenMethods extends MouseAdapter {
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
}
