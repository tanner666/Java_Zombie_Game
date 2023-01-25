package ZombieInvasion;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;

public class ImageImport extends JPanel{
    private ImageIcon image;
    private int x, y;
    Graphics g;

    public ImageImport(int x, int y, String path, Graphics g){
        image = new ImageIcon(path);
        this.x = x;
        this.y = y;
        this.g = g;
    }
    public ImageImport(int x, int y, BufferedImage bi, Graphics g){
        image = new ImageIcon(bi);
        this.x = x;
        this.y = y;
        this.g = g;
    }

    public void createImage(){
        super.paintComponent(g);
        g.drawImage(image.getImage(), x, y, null);

        //g.drawImage(dbImage, 200, 200, this);

        //g.setColor(Color.WHITE);
    }
    public void scaleImage(int width, int height){
        //ImageIcon imageIcon = new ImageIcon(new ImageIcon("icon.png").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
        image = new ImageIcon(image.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
    }
}
