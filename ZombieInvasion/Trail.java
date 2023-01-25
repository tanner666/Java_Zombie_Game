package ZombieInvasion;

import java.awt.*;

public class Trail extends GameObject {

    private float alpha = 1;
    private Color color;

    private int width, height;
    private double life;

    //life = 0.01 to 0.1

    public Trail(int x, int y, int width, int height, ID id, Color color, Handler handler){
        super(x, y ,id, handler);
        this.color = color;
        this.width = width;
        this.height = height;
        this.handler = handler;
    }

    public void tick() {
        if (alpha > 0.1){
            alpha -= 0.1 - 0.001;
        }else{
            handler.removeObject(this);
        }
    }


    public void render(Graphics g) {
        //transparency method only works with graphics2D
        Graphics2D g2d = (Graphics2D)g;
        g2d.setComposite(makeTransparent(alpha));

        g.setColor(color);
        g.fillRect(x, y, width ,height);

        g2d.setComposite(makeTransparent(1)); //must do this for it to work properly
    }

    private AlphaComposite makeTransparent(float alpha){
        int type = AlphaComposite.SRC_OVER;
        System.out.println(alpha);
        return (AlphaComposite.getInstance(type, alpha));
    }


    public Rectangle getBounds() {
        return null;
    }
}
