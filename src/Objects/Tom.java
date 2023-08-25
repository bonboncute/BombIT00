package Objects;

import java.awt.Graphics2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Animals.Animation;
import Animals.FrameImage;
import InterFace.GamePanel;

public class Tom extends GameObjects {
    private int randomNum;
    public boolean enemyDied;

    public Tom(float posX, float posY, GamePanel gamePanel) {
        this.gamePanel = gamePanel;

        setImage();
        randomNum = randomDirection();
        this.posX = posX;
        this.posY = posY;
        speed = 1;

    }

    // public void setPos() {
    // posX = 40;
    // posY = 40;
    // speed = (float) 1;
    // }

    public int randomDirection() {
        int max = 5;
        int min = 1;
        return (int) (Math.random() * (max - min) + 1);
    }

    public void setImage() {
        try {
            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/2.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/2.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/2.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/2.3.png"));
            frame4 = new FrameImage("frame4", image4);

            backward = new Animation();
            backward.add(frame1, 300 * 1000000);
            backward.add(frame2, 300 * 1000000);
            backward.add(frame3, 300 * 1000000);
            backward.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/1.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/1.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/1.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/1.3.png"));
            frame4 = new FrameImage("frame4", image4);

            forward = new Animation();
            forward.add(frame1, 300 * 1000000);
            forward.add(frame2, 300 * 1000000);
            forward.add(frame3, 300 * 1000000);
            forward.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/4.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/4.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/4.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/4.3.png"));
            frame4 = new FrameImage("frame4", image4);

            leftside = new Animation();
            leftside.add(frame1, 300 * 1000000);
            leftside.add(frame2, 300 * 1000000);
            leftside.add(frame3, 300 * 1000000);
            leftside.add(frame4, 300 * 1000000);

            image1 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/3.1.png"));
            frame1 = new FrameImage("frame1", image1);

            image2 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/3.2.png"));
            frame2 = new FrameImage("frame2", image2);

            image3 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/3.4.png"));
            frame3 = new FrameImage("frame3", image3);

            image4 = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Tom/3.3.png"));
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

        collision = false;
        collisionWithBomb = false;
        bombCollision = false;

        gamePanel.map.checkCollisionWithBomb(this);
        if (this.getCollisionWithBomb() == true) {
            gamePanel.enemy.remove(this);
            enemyDied = true;

        }

        if (randomNum == 1) {
            direction = "up";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true || this.getBombCollision() == true) {
                randomNum = randomDirection();

            } else
                posY -= speed;

        } else if (randomNum == 2) {
            direction = "down";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true || this.getBombCollision() == true) {
                randomNum = randomDirection();

            } else
                posY += speed;
        } else if (randomNum == 3) {
            direction = "left";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true || this.getBombCollision() == true) {
                randomNum = randomDirection();
            } else
                posX -= speed;
        } else if (randomNum == 4) {
            direction = "right";
            gamePanel.map.checkCollision(this);
            if (this.getCollision() == true || this.getBombCollision() == true) {
                randomNum = randomDirection();

            } else
                posX += speed;
        }

    }

    // @Override
    public void draw(Graphics2D g2) {

        if (randomNum == 1) {
            count = 2;
            backward.Update(System.nanoTime());
            backward.draw((int) getPosX(), (int) getPosY(), g2);

            if (backward.getCurrentFrame() == 1)
                backward.setIgnoreFrame(0);

        }

        else if (randomNum == 2) {
            count = 1;
            forward.Update(System.nanoTime());
            forward.draw((int) getPosX(), (int) getPosY(), g2);

            if (forward.getCurrentFrame() == 1)
                forward.setIgnoreFrame(0);

        }

        else if (randomNum == 3) {
            count = 3;
            leftside.Update(System.nanoTime());
            leftside.draw((int) getPosX(), (int) getPosY(), g2);

            if (leftside.getCurrentFrame() == 1)
                leftside.setIgnoreFrame(0);

        }

        else if (randomNum == 4) {
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
