package InterFace;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import Animals.CacheDataLoader;

import Objects.Jerry;
import Objects.Tom;
import Objects.GameObjects;
import Objects.Map;
import Objects.Menu;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    public Thread thread;
    public boolean isRunning = true;
    public int gameState;
    public int menu = 0;
    public int play = 1;
    public int pause = 2;
    public int gameOver = 3;
    public int win = 4;
    public int settings = 5;
    public boolean stopUpdate, inMenu, inPlay;
    public Image BG;

    private KeyHandler keyCode = new KeyHandler(this);
    public GameObjects object;
    public Menu menuState;
    public Map map;
    public CacheDataLoader cache = new CacheDataLoader();

    public Jerry jerry;
    public Tom tom1;
    public Tom tom2;
    public Tom tom3;
    public Tom tom4;
    public Tom tom5;
    public ArrayList<GameObjects> enemy;

    public GamePanel() {

        this.addKeyListener(keyCode);
        this.setFocusable(true);
        try {
            cache.playMusic();
            setGameObject();
            BG = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/bgr.png"));
        } catch (IOException e) {
        }
    }

    public void setGameObject() {
        stopUpdate = false;
        menuState = new Menu(this);
        object = new GameObjects();
        map = new Map(0, 0, this);
        // cache = new CacheDataLoader();
        // cache.loadSound();
        // cache.playMusic();

        jerry = new Jerry(this, keyCode);
        tom1 = new Tom(240, 80, this);
        tom2 = new Tom(80, 500, this);
        tom3 = new Tom(440, 320, this);
        tom4 = new Tom(680, 160, this);
        tom5 = new Tom(720, 480, this);

        enemy = new ArrayList<GameObjects>();
        enemy.add(tom1);
        enemy.add(tom2);
        enemy.add(tom3);
        enemy.add(tom4);
        enemy.add(tom5);

    }

    public void updateGame() {
        if (gameState == pause) {

        } else {
            jerry.updateChar();
            for (int i = 0; i < enemy.size(); i++)
                enemy.get(i).updateChar();
            if (enemy.size() == 0) {
                gameState = win;
                // stopUpdate = true;
            }

        }
        if (gameState == win || gameState == gameOver) {
            stopUpdate = true;
        }

    }

    public void startThread() {
        if (thread == null) {
            thread = new Thread(this);
            thread.start();
        }
    }

    @Override
    public void run() {
        long FPS = 60;
        long period = 1000000000 / FPS;
        long beginTime;
        long sleepTime;

        beginTime = System.nanoTime();

        while (isRunning) {
            if (stopUpdate != true)
                updateGame();

            repaint();

            long deltaTime = System.nanoTime() - beginTime;
            sleepTime = period - deltaTime;

            try {
                if (sleepTime > 0)
                    Thread.sleep(sleepTime / 1000000);
                else
                    Thread.sleep(period / 2000000);
            } catch (InterruptedException e) {
                beginTime = System.nanoTime();
            }

        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (gameState == menu) {
            menuState.draw(g2);
        } else if (gameState == settings) {
            menuState.drawSetting(g2);
        } else {
            g.drawImage(BG, 0, 0, null);
            map.draw(g2);
            for (GameObjects object : enemy) {
                object.draw(g2);

            }
            jerry.draw(g2);
        }
        if (gameState == pause) {
            menuState.drawPause(g2);
        }
        if (gameState == gameOver) {
            menuState.drawGameOver(g2);
        }
        if (gameState == win) {
            menuState.drawWinGame(g2);
        }
        // else if (gameState == settings) {
        // menuState.drawSetting(g2);
        // }
        g2.dispose();
    }

}