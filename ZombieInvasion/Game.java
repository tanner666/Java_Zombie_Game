package ZombieInvasion;

import ZombieInvasion.Screen.Menu;
import ZombieInvasion.Screen.Store;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.Random;

public class Game extends Canvas implements Runnable{
    public static final int WIDTH = 916, HEIGHT = 513;
    public static long timer;
    private Thread thread;
    private boolean running = false;
    public static int balance = 0;

    private ZombieInvasion.Handler handler;
    private Spawner spawner;
    private Random r;
    private ZombieInvasion.HUD hud;
    private ZombieInvasion.Screen.Menu menu;
    private Store store;

    private static boolean ml_menu = true, ml_store = false;

    public enum STATE{
        Menu,
        Game,
        Store;
    }

    public STATE gameState = STATE.Menu;

    public Game() throws IOException {
        handler = new Handler();
        menu = new Menu(handler,this);
        store = new Store(handler, this);
        this.addMouseListener(menu);
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Let's build a game", this);

        hud = new HUD(handler);
        handler.addObject(new Player(WIDTH - 80, HEIGHT/2, ZombieInvasion.ID.Player, handler));

        handler.addObject(new Bazooka(WIDTH - 80, HEIGHT/2, ID.Bazooka, handler));
        //Spawn.wave1(handler);
        //handler.addObject(new BigBoy(50, HEIGHT/2 - 32, ID.BigBoy, handler));
        spawner = new Spawner(handler, this);
    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop(){
        try{
            thread.join();
            running = false;
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    //loop that runs the game
    public void run(){
        this.requestFocus();  //this makes it so you don't have to click on screen to start game
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //method to run the backend of the game
    private void tick(){
        if(gameState == STATE.Game) {
            if(ml_menu){
                this.removeMouseListener(menu);
                ml_menu = false;
            }
            else if(ml_store){
                this.removeMouseListener(store);
                ml_store = false;
            }

            spawner.tick();
            handler.tick();
            hud.tick();
        }
        if(gameState == STATE.Menu){
            if(!ml_menu) {
                this.addMouseListener(menu);
                 ml_menu = true;
            }
        }
        if(gameState == STATE.Store){
            if(!ml_store){
                this.addMouseListener(store);
                ml_store = true;
            }
        }
    }

    //method to display the game on screen
    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        if(gameState == STATE.Menu){
            menu.render(g);
        }
        else if(gameState == STATE.Store){
            store.render(g);
        }
        else {
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            ImageImport i = new ImageImport(0, 0, "C:\\Users\\gtann\\Pictures\\Pictures\\darkroad2.jpg", g);
            i.createImage();
            handler.render(g);
            hud.render(g);
            spawner.render(g);
        }

        g.dispose();
        bs.show();
    }

    //clamps a value between a min and max value
    public static int clamp(int var, int min, int max){
        if(var >= max)
            return var = max;
        else if(var <= min)
            return var = min;
        else
            return var;
    }

    public static void main(String[] args) throws IOException {
        new Game();
    }
}
