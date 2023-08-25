package Objects;

// import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
// import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Animals.Animation;
// import Animals.CacheDataLoader;
import Animals.FrameImage;
import InterFace.GamePanel;
import InterFace.KeyHandler;

public class Jerry extends GameObjects {

    // private float posX;
    // private float posY;

    // private float width;
    // private float height;z
    // private float mass;

    // GameObjects object = new GameObjects();
    // Bomb bomb;

    public Jerry(GamePanel gamePanel, KeyHandler keyCode) {
        this.gamePanel = gamePanel;
        this.keyCode = keyCode;

        setPos();
        setImage();

    }

    public void setPos() {
        posX = 40;
        posY = 40;
        speed = 2;
    }

    public Rectangle getBoundForCollision() {
        bound = new Rectangle();
        bound.x = 7;
        bound.y = 10;
        bound.width = 24;
        bound.height = 24;
        return bound;
    }

    public void setImage() {
        try {
            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/2.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/2.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/2.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/2.3.png"));
            frame4 = new FrameImage("frame4", image4);

            backward = new Animation();
            backward.add(frame1, 300 * 1000000);
            backward.add(frame2, 300 * 1000000);
            backward.add(frame3, 300 * 1000000);
            backward.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/1.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/1.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/1.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/1.3.png"));
            frame4 = new FrameImage("frame4", image4);

            forward = new Animation();
            forward.add(frame1, 300 * 1000000);
            forward.add(frame2, 300 * 1000000);
            forward.add(frame3, 300 * 1000000);
            forward.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/4.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/4.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/4.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/4.3.png"));
            frame4 = new FrameImage("frame4", image4);

            leftside = new Animation();
            leftside.add(frame1, 300 * 1000000);
            leftside.add(frame2, 300 * 1000000);
            leftside.add(frame3, 300 * 1000000);
            leftside.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/3.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/3.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/3.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Jerry/3.3.png"));
            frame4 = new FrameImage("frame4", image4);

            rightside = new Animation();
            rightside.add(frame1, 300 * 1000000);
            rightside.add(frame2, 300 * 1000000);
            rightside.add(frame3, 300 * 1000000);
            rightside.add(frame4, 300 * 1000000);

        } catch (IOException e) {
        }

    }

    // @Override
    public void updateChar() {
        // super.updateChar();
        collision = false;
        collisionWithBomb = false;
        enemyCollision = false;

        gamePanel.map.checkCollisionWithBomb(this);
        if (this.getCollisionWithBomb() == true || this.getEnemyCollision() == true) {
            gamePanel.gameState = gamePanel.gameOver;
            // gamePanel.stopUpdate = true;
        }

        if (keyCode.placeBomb == true) {
            Bomb.placeBomb(gamePanel, this);
        }

        if (keyCode.up == true) {
            direction = "up";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true) {
                posY += 0;
            } else
                posY -= speed;

        } else if (keyCode.down == true) {
            direction = "down";
            gamePanel.map.checkCollision(this);

            if (this.getCollision() == true) {
                posY += 0;
            } else
                posY += speed;

        } else if (keyCode.left == true) {
            direction = "left";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true) {
                posX += 0;
            } else
                posX -= speed;

        } else if (keyCode.right == true) {
            direction = "right";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true) {
                posX += 0;
            } else
                posX += speed;
        }

        Bomb.bombExplode(gamePanel);

    }

    public void draw(Graphics2D g2) {
        if (keyCode.up == true) {
            count = 2;
            backward.Update(System.nanoTime());
            backward.draw((int) getPosX(), (int) getPosY(), g2);

            if (backward.getCurrentFrame() == 1)
                backward.setIgnoreFrame(0);
        }

        else if (keyCode.down == true) {
            count = 1;
            forward.Update(System.nanoTime());
            forward.draw((int) getPosX(), (int) getPosY(), g2);

            if (forward.getCurrentFrame() == 1)
                forward.setIgnoreFrame(0);
        }

        else if (keyCode.left == true) {
            count = 3;
            leftside.Update(System.nanoTime());
            leftside.draw((int) getPosX(), (int) getPosY(), g2);

            if (leftside.getCurrentFrame() == 1)
                leftside.setIgnoreFrame(0);
        }

        else if (keyCode.right == true) {
            count = 4;
            rightside.Update(System.nanoTime());
            rightside.draw((int) getPosX(), (int) getPosY(), g2);

            if (rightside.getCurrentFrame() == 1)
                rightside.setIgnoreFrame(0);

        } else {
            if (count == 1)
                forward.draw((int) getPosX(), (int) getPosY(), g2);
            else if (count == 2)
                backward.draw((int) getPosX(), (int) getPosY(), g2);
            else if (count == 3)
                leftside.draw((int) getPosX(), (int) getPosY(), g2);
            else if (count == 4)
                rightside.draw((int) getPosX(), (int) getPosY(), g2);
        }

    }
}
