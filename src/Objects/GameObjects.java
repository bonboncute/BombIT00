package Objects;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Animals.Animation;
import Animals.FrameImage;
import InterFace.GamePanel;
import InterFace.KeyHandler;

public class GameObjects {
    public boolean collision, collisionWithBomb, bombCollision, enemyCollision;
    public float posX, posY;
    BufferedImage image1, image2, image3, image4;
    FrameImage frame1, frame2, frame3, frame4;

    public float speed;
    public float width;
    public float height;
    public int count = 1;
    public String direction;
    public Animation forward, backward, leftside, rightside;
    public static Rectangle bound;

    public GamePanel gamePanel;
    public KeyHandler keyCode = new KeyHandler(gamePanel);
    Bomb bomb;

    public GameObjects() {
    }

    public void setPosX(float posX) {
        this.posX = posX;
    }

    public void setPosY(float posY) {
        this.posY = posY;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public boolean getCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public boolean getCollisionWithBomb() {
        return collisionWithBomb;
    }

    public void setCollisionWithBomb(boolean collisionWithBomb) {
        this.collisionWithBomb = collisionWithBomb;
    }

    public boolean getBombCollision() {
        return bombCollision;
    }

    public void setBombCollision(boolean bombCollision) {
        this.bombCollision = bombCollision;
    }

    public boolean getEnemyCollision() {
        return enemyCollision;
    }

    public void setEnemyCollision(boolean enemyCollision) {
        this.enemyCollision = enemyCollision;
    }

    public Rectangle getBoundForCollision() {
        bound = new Rectangle();
        bound.x = 12;
        bound.y = 23;
        bound.width = 39;
        bound.height = 39;
        return bound;
    }

    public void updateChar() {
    }

    public void draw(Graphics2D g2) {

    }
    // public void setBoundCollision(Rectangle bound) {
    // this.bound.x = bound.x;
    // this.bound.y = bound.y;
    // this.bound.width = bound.width;
    // this.bound.height = bound.height;
    // }
}
