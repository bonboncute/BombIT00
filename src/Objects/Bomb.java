package Objects;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import Animals.Animation;
import Animals.FrameImage;
import InterFace.GamePanel;

public class Bomb {
    private BufferedImage boom1, boom2, boom3, boom4, boom5;
    private FrameImage frame1, frame2, frame3, frame4, frame5;
    private static long timeBomb;

    public static Animation boom, upExplode, downExplode, leftExplode, rightExplode, centerExplode;
    public static Animation wallExplode;
    public static boolean explode;
    public static boolean explodeWall;

    public GamePanel gamePanel;
    public static int x;
    public static int y;
    public static Bomb bomb;

    public Bomb(int xIndex, int yIndex, GamePanel gamePanel) {
        this.x = xIndex * gamePanel.map.tileSize;
        this.y = yIndex * gamePanel.map.tileSize;
        timeBomb = System.nanoTime();
        // setBombPos();
        this.gamePanel = gamePanel;
        setBombImage();

    }

    // public void setBombPos() {
    // x = 300;
    // y = 300;
    // }

    public static int getX() {
        return x;
    }

    // public void setX(int x) {
    // this.x = x;
    // }

    public static int getY() {
        return y;
    }

    // public void setY(int y) {
    // this.y = y;
    // }

    // public static boolean getExplode() {
    // return explode;
    // }

    // public void setExplode(boolean explode) {
    // Bomb.explode = explode;
    // }

    // public static boolean isExplodeWall() {
    // return explodeWall;
    // }

    // public void setExplodeWall(boolean explodeWall) {
    // Bomb.explodeWall = explodeWall;
    // }

    public void setBombImage() {
        try {
            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Bgr/1.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Bgr/2.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom = new Animation();
            boom.add(frame1, 300 * 1000000);
            boom.add(frame2, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/4.1.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/3.1.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/2.1.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/1.1.png"));
            frame4 = new FrameImage("frame4", boom4);

            upExplode = new Animation();
            upExplode.add(frame1, 300 * 1000000);
            upExplode.add(frame2, 300 * 1000000);
            upExplode.add(frame3, 300 * 1000000);
            upExplode.add(frame4, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/4.2.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/3.2.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/2.2.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/1.2.png"));
            frame4 = new FrameImage("frame4", boom4);

            downExplode = new Animation();
            downExplode.add(frame1, 300 * 1000000);
            downExplode.add(frame2, 300 * 1000000);
            downExplode.add(frame3, 300 * 1000000);
            downExplode.add(frame4, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/4.3.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/3.3.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/2.3.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/1.3.png"));
            frame4 = new FrameImage("frame4", boom4);

            leftExplode = new Animation();
            leftExplode.add(frame1, 300 * 1000000);
            leftExplode.add(frame2, 300 * 1000000);
            leftExplode.add(frame3, 300 * 1000000);
            leftExplode.add(frame4, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/4.4.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/3.4.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/2.4.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/1.4.png"));
            frame4 = new FrameImage("frame4", boom4);

            rightExplode = new Animation();
            rightExplode.add(frame1, 300 * 1000000);
            rightExplode.add(frame2, 300 * 1000000);
            rightExplode.add(frame3, 300 * 1000000);
            rightExplode.add(frame4, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/4.5.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/3.5.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/2.5.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/1.5.png"));
            frame4 = new FrameImage("frame4", boom4);

            centerExplode = new Animation();
            centerExplode.add(frame1, 300 * 1000000);
            centerExplode.add(frame2, 300 * 1000000);
            centerExplode.add(frame3, 300 * 1000000);
            centerExplode.add(frame4, 300 * 1000000);

            boom1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/5.png"));
            frame1 = new FrameImage("frame1", boom1);

            boom2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/6.png"));
            frame2 = new FrameImage("frame2", boom2);

            boom3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/7.png"));
            frame3 = new FrameImage("frame3", boom3);

            boom4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/8.png"));
            frame4 = new FrameImage("frame4", boom4);

            boom5 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Boom/9.png"));
            frame5 = new FrameImage("frame4", boom5);

            wallExplode = new Animation();
            wallExplode.add(frame1, 300 * 1000000);
            wallExplode.add(frame2, 300 * 1000000);
            wallExplode.add(frame3, 300 * 1000000);
            wallExplode.add(frame4, 300 * 1000000);
            wallExplode.add(frame5, 300 * 1000000);
        } catch (Exception e) {

        }

    }

    public static void placeBomb(GamePanel gamePanel, GameObjects object) {
        if (bomb == null) {
            int xIndex = Math.round(object.posX / gamePanel.map.tileSize);
            int yIndex = Math.round(object.posY / gamePanel.map.tileSize);
            bomb = new Bomb(xIndex, yIndex, gamePanel);
            gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize] = 3;
        }
    }

    public static void bombExplode(GamePanel gamePanel) {
        if (bomb != null) {
            if (System.nanoTime() - timeBomb < (10000 * 1000000)) {
                explode = false;
                // countBomb++;
            } else {
                explode = true;
                explodeWall = true;
                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 2)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                            / gamePanel.map.tileSize] = -1;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 2)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                            / gamePanel.map.tileSize] = -1;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        + 1] == 2)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            + 1] = -1;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        - 1] == 2)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            - 1] = -1;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX()
                        / gamePanel.map.tileSize] == 3)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() /
                            gamePanel.map.tileSize] = 5;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 0)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 4;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 0)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 4;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        + 1] == 0)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            + 1] = 4;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        - 1] == 0)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            - 1] = 4;

            }
        }
        if (explode == true) {
            if (System.nanoTime() - timeBomb > (15000 * 1000000)) {
                gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() /
                        gamePanel.map.tileSize] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 4)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                        / gamePanel.map.tileSize] == 4)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        + 1] == 4)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            + 1] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        - 1] == 4)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            - 1] = 0;

                bomb = null;
                explode = false;

            }

        }
        if (explodeWall == true) {
            if (System.nanoTime() - timeBomb > (15000 * 1000000)) {
                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                        / gamePanel.map.tileSize] == -1)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize + 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                        / gamePanel.map.tileSize] == -1)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize - 1][Bomb.getX()
                            / gamePanel.map.tileSize] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        + 1] == -1)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            + 1] = 0;

                if (gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                        - 1] == -1)
                    gamePanel.map.loadMap[Bomb.getY() / gamePanel.map.tileSize][Bomb.getX() / gamePanel.map.tileSize
                            - 1] = 0;

                explodeWall = false;
            }

        }

    }

}
