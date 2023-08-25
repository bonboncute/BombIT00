package Objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import InterFace.GamePanel;

public class Menu {
    public Image menuBg, guideImage, gameOver, winGame, pause, settingImage;
    public BufferedImage button, cont1, cont2, exit1, exit2, res1, res2;
    public BufferedImage mute1, mute2, unMute1, unMute2, back1, back2;
    public BufferedImage rePlay1, rePlay2, home1, home2, play1, play2;
    public BufferedImage[] start = new BufferedImage[2];
    public BufferedImage[] guide = new BufferedImage[2];
    public BufferedImage[] setting = new BufferedImage[2];
    public BufferedImage[] quit = new BufferedImage[2];
    GamePanel gamePanel;
    public int menuChoose, pauseChoose, overChoose, settingChoose;
    public boolean guideState;

    public Menu(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        try {
            menuChoose = 0;
            pauseChoose = 0;
            overChoose = 0;
            settingChoose = 0;

            menuBg = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/bg_menu.png"));
            button = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/butt.png"));
            guideImage = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/GUIDE.png"));
            settingImage = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/CC.png"));

            cont1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/con1.png"));
            cont2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Cont.png"));
            exit1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/ex.png"));
            exit2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/exi.png"));
            res1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/res.png"));
            res2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/rest.png"));

            mute1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Mute1.png"));
            mute2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Mute2.png"));
            unMute1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Unmute1.png"));
            unMute2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Unmute2.png"));
            back1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/back1.png"));
            back2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/back2.png"));

            rePlay1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Replay1.png"));
            rePlay2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Replay2.png"));
            home1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Home1.png"));
            home2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Home2.png"));
            play1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Play1.png"));
            play2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Play2.png"));

            pause = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/pause.png"));
            gameOver = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Gameover.png"));
            winGame = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Menu/Youwin.png"));

            for (int i = 0; i < 2; i++) {
                start[i] = button.getSubimage(i * 114, 0, 114, 49);
                guide[i] = button.getSubimage(i * 114, 1 * 49, 114, 49);
                setting[i] = button.getSubimage(i * 114, 2 * 49, 114, 49);
                quit[i] = button.getSubimage(i * 114, 3 * 49, 114, 49);
            }

        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(menuBg, 0, 0, null);
        if (menuChoose == 0)
            g2.drawImage(start[1], 740, 320, 160, 70, null);
        else
            g2.drawImage(start[0], 740, 320, 160, 70, null);

        if (menuChoose == 1)
            g2.drawImage(guide[1], 740, 320 + 80, 160, 70, null);
        else
            g2.drawImage(guide[0], 740, 320 + 80, 160, 70, null);

        if (menuChoose == 2)
            g2.drawImage(setting[1], 740, 320 + 2 * 80, 160, 70, null);
        else
            g2.drawImage(setting[0], 740, 320 + 2 * 80, 160, 70, null);

        if (menuChoose == 3)
            g2.drawImage(quit[1], 740, 320 + 3 * 80, 160, 70, null);
        else
            g2.drawImage(quit[0], 740, 320 + 3 * 80, 160, 70, null);

        if (guideState == true)
            g2.drawImage(guideImage, 50, 15, null);

    }

    public void drawPause(Graphics2D g2) {
        g2.drawImage(pause, 0, 0, null);
        if (pauseChoose == 0)
            g2.drawImage(cont2, 280, 400, 150, 60, null);
        else
            g2.drawImage(cont1, 280, 400, 150, 60, null);

        if (pauseChoose == 1)
            g2.drawImage(exit2, 600, 400, 150, 60, null);
        else
            g2.drawImage(exit1, 600, 400, 150, 60, null);
    }

    public void drawGameOver(Graphics2D g2) {
        g2.drawImage(gameOver, 0, 0, null);
        if (overChoose == 0)
            g2.drawImage(res2, 280, 440, 150, 60, null);
        else
            g2.drawImage(res1, 280, 440, 150, 60, null);

        if (overChoose == 1)
            g2.drawImage(exit2, 600, 442, 150, 60, null);
        else
            g2.drawImage(exit1, 600, 442, 150, 60, null);
    }

    public void drawWinGame(Graphics2D g2) {
        g2.drawImage(winGame, 0, 0, null);
        if (overChoose == 0)
            g2.drawImage(res2, 280, 440, 150, 60, null);
        else
            g2.drawImage(res1, 280, 440, 150, 60, null);

        if (overChoose == 1)
            g2.drawImage(exit2, 600, 442, 150, 60, null);
        else
            g2.drawImage(exit1, 600, 442, 150, 60, null);
    }

    public void drawSetting(Graphics2D g2) {

        // g2.setColor(Color.decode("#14701E"));
        // g2.fillRect(0, 0, 1100, 720);

        g2.drawImage(settingImage, 0, 0, null);

        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(2.5f));
        g2.drawRect(450, 330, 200, 20);

        g2.setColor(Color.BLACK);
        g2.fillRect(450, 330, gamePanel.cache.range * 40, 20);

        if (settingChoose == 0) {

            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(400, 225, 300, 50, 30, 30);

            if (gamePanel.cache.songMute == true)
                g2.drawImage(mute2, 630, 230, null);
            else
                g2.drawImage(unMute2, 630, 230, null);

        } else {

            if (gamePanel.cache.songMute == true)
                g2.drawImage(mute1, 630, 230, null);
            else
                g2.drawImage(unMute1, 630, 230, null);

        }
        if (settingChoose == 1) {
            g2.setColor(Color.BLACK);
            g2.setStroke(new BasicStroke(1.5f));
            g2.drawRoundRect(400, 280, 300, 100, 30, 30);

        }
        if (gamePanel.inMenu == true) {
            if (settingChoose == 2)
                g2.drawImage(back2, 475, 400, 150, 60, null);
            else
                g2.drawImage(back1, 475, 400, 150, 60, null);
        }

        if (gamePanel.inPlay == true) {
            if (settingChoose == 2)
                g2.drawImage(rePlay2, 455, 405, null);
            else
                g2.drawImage(rePlay1, 450, 400, 50, 50, null);

            if (settingChoose == 3)
                g2.drawImage(home2, 535, 405, null);
            else
                g2.drawImage(home1, 530, 400, 50, 50, null);

            if (settingChoose == 4)
                g2.drawImage(play2, 615, 405, null);
            else
                g2.drawImage(play1, 610, 400, 50, 50, null);

        }
    }
}
