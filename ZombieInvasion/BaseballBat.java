package ZombieInvasion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BaseballBat extends GameObjectProjectile{

    BufferedImage bat1 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat.png"));
    BufferedImage bat2 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat2.png"));
    BufferedImage bat3 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat3.png"));
    BufferedImage bat4 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat4.png"));
    BufferedImage bat5 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat5.png"));
    BufferedImage bat6 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat6.png"));
    BufferedImage bat7 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat7.png"));
    BufferedImage bat8 = ImageIO.read(new File("C:\\Users\\gtann\\Pictures\\Pictures\\baseballbat8.png"));
    BufferedImage[] bats = {bat1, bat2, bat3, bat4, bat5, bat6, bat7, bat8};


    private final int DELAY = 20, DAMAGE = 25;
    private int delay = 0, rotationCounter = 0;
    private boolean startRotation = false, endRotation = false;

    public BaseballBat(int x, int y, ID id, Handler handler) throws IOException {
        super(x, y, id, handler);
        id_num = handler.assign_id_Number();
    }

    @Override
    public void tick() {
        if (delay == DELAY)
            collision(id_num, DAMAGE);

        if (delay == 0) {
            if (fire && !startRotation) {
                startRotation = true;
                rotationCounter++;
                delay = DELAY;
            }
        }
        else delay--;

        if (startRotation) {
            if (rotationCounter == 0) {
                startRotation = false;
                endRotation = false;
            } else if (endRotation)
                rotationCounter--;
            else
                rotationCounter++;
        }


        GameObject player = handler.getObject(0);
        x = player.getX();
        y = player.getY() + 50;

    }

    @Override
    public void render(Graphics g) {
        ImageImport i;
        if (!startRotation) {
            i = new ImageImport(x-10, y-65, bat1, g);
        }
        else {
            if (rotationCounter > bats.length-1) {
                endRotation = true;
                rotationCounter = bats.length -1;
            }
            i = new ImageImport (x-10*rotationCounter-10, y-65+4*rotationCounter, bats[rotationCounter], g);
        }
        i.scaleImage(90, 115);
        i.createImage();
        g.drawRect(x-75, y-50, 85, 100);
    }

    @Override
    public Rectangle getBounds() {
        if (delay <= DELAY && delay > DELAY - 5)
            return new Rectangle(x-75, y, 85, 85);
        else
            return null;
    }

    protected void collision(int id_num, int damage) {
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getID() != this.getID()) {
                //collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.HEALTH -= damage;
                    //handler.object.set(id_num, new PlaceHolder(0,0, ID.Placeholder, handler,id_num));
                    //handler.object.remove(this);
                    System.out.println(tempObject.HEALTH);
                    if (tempObject.HEALTH <= 0) {
                        handler.addObject(new coin(tempObject.x + 25, tempObject.y + 100, ZombieInvasion.ID.Coin, 10, handler, handler.assign_id_Number()));
                        handler.removeObject(tempObject);
                    }
                }
            }
            /*if (tempObject.getID() == ID.BigBoy) {
                //collision code
                if (getBounds().intersects(tempObject.getBounds())) {
                    tempObject.HEALTH -= damage;
                    //handler.object.remove(this);
                    System.out.println(tempObject.HEALTH);
                    if (tempObject.HEALTH <= 0) {
                        handler.addObject(new coin(tempObject.x + 25, tempObject.y + 100, ZombieInvasion.ID.Coin, 100, handler, handler.assign_id_Number()));
                        //handler.object.remove(tempObject);
                    }
                }
            }

             */
        }
    }
}
