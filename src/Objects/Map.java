package Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import Animals.CacheDataLoader;
import InterFace.GamePanel;

public class Map {
    public int[][] loadMap = new int[17][22];;
    public int tileSize = 40;
    private float posX, posY;
    private GamePanel gamePanel;
    CacheDataLoader cacheDataLoader;
    // GameObjects object;
    private Image[] image = new Image[10];
    // float x, y;
    // ArrayList<Integer> enemyPosX = new ArrayList<Integer>();
    // ArrayList<Integer> enemyPosY = new ArrayList<Integer>();

    public Map(float posX, float posY, GamePanel gamePanel) {
        this.posX = posX;
        this.posY = posY;
        this.gamePanel = gamePanel;
        setMap();
        try {
            image[1] = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Bgr/grass.png"));
            image[2] = ImageIO.read(new File("C:/Users/Admin/OneDrive/Desktop/BombIT0/BombIT00/Data/Object/11.png"));

        } catch (Exception e) {
        }
    }

    public void setMap() {
        cacheDataLoader = new CacheDataLoader();
        loadMap = cacheDataLoader.map;

    }

    public void checkCollision(GameObjects object) {
        int leftX = (int) object.getPosX() + object.getBoundForCollision().x;
        int rigthX = (int) object.getPosX() + object.getBoundForCollision().x + object.getBoundForCollision().width;
        int topY = (int) object.getPosY() + object.getBoundForCollision().y + 4;
        int bottomY = (int) object.getPosY() + object.getBoundForCollision().y + object.getBoundForCollision().height
                + 4;

        int leftCol = leftX / tileSize;
        int rightCol = rigthX / tileSize;
        int topRow = topY / tileSize;
        int bottomRow = bottomY / tileSize;

        int num1, num2;

        switch (object.getDirection()) {
            case "up":
                topRow = (int) (topY - object.speed) / tileSize;
                num1 = (int) loadMap[topRow][leftCol];
                num2 = (int) loadMap[topRow][rightCol];

                if (num1 == 1 || num2 == 1 || num1 == 2 || num2 == 2) {
                    object.collision = true;
                }
                if (num1 == 3 || num2 == 3)
                    object.bombCollision = true;
                break;

            case "down":
                bottomRow = (int) (bottomY + object.speed) / tileSize;
                num1 = (int) loadMap[bottomRow][leftCol];
                num2 = (int) loadMap[bottomRow][rightCol];

                if (num1 == 1 || num2 == 1 || num1 == 2 || num2 == 2) {
                    object.collision = true;
                }
                if (num1 == 3 || num2 == 3)
                    object.bombCollision = true;
                break;

            case "left":
                leftCol = (int) (leftX - object.speed) / tileSize;
                num1 = (int) loadMap[topRow][leftCol];
                num2 = (int) loadMap[bottomRow][leftCol];

                if (num1 == 1 || num2 == 1 || num1 == 2 || num2 == 2) {
                    object.collision = true;
                }
                if (num1 == 3 || num2 == 3)
                    object.bombCollision = true;
                break;

            case "right":
                rightCol = (int) (rigthX + object.speed) / tileSize;
                num1 = (int) loadMap[topRow][rightCol];
                num2 = (int) loadMap[bottomRow][rightCol];

                if (num1 == 1 || num2 == 1 || num1 == 2 || num2 == 2) {
                    object.collision = true;
                }
                if (num1 == 3 || num2 == 3)
                    object.bombCollision = true;
                break;

        }

    }

    public void checkCollisionWithBomb(GameObjects object) {
        int charCol = (int) (object.getPosX() + object.getBoundForCollision().x
                + object.getBoundForCollision().width / 2) / tileSize;
        int charRow = (int) (object.getPosY() + object.getBoundForCollision().x
                + object.getBoundForCollision().height / 2) / tileSize;

        int num = (int) loadMap[charRow][charCol];

        if (Bomb.bomb != null) {
            if (Bomb.explode == true) {

                if (num == 4 || num == 5)
                    object.collisionWithBomb = true;
            }
        }
        int enemyCol, enemyRow;

        for (GameObjects obj : gamePanel.enemy) {

            enemyCol = (int) (obj.getPosX() + obj.getBoundForCollision().x + obj.getBoundForCollision().width / 2)
                    / tileSize;
            enemyRow = (int) (obj.getPosY() + obj.getBoundForCollision().y + obj.getBoundForCollision().height / 2)
                    / tileSize;

            if (charCol == enemyCol && charRow == enemyRow || charCol == enemyCol && charRow == enemyRow - 1) {
                object.enemyCollision = true;
            }
        }
    }

    public void draw(Graphics2D g2) {
        g2.setColor(Color.yellow);

        for (int i = 0; i < loadMap.length; i++) {
            for (int j = 0; j < loadMap[0].length; j++) {
                if (loadMap[i][j] == 1) {
                    g2.drawImage(image[1], (int) posX + j * tileSize, (int) posY + i *
                            tileSize, tileSize, tileSize, null);

                } else if (loadMap[i][j] == 2) {

                    g2.drawImage(image[2], (int) posX + j * tileSize, (int) posY + i *
                            tileSize, tileSize, tileSize, null);

                } else if (loadMap[i][j] == 3) {
                    if (Bomb.bomb != null)
                        if (Bomb.explode != true) {

                            Bomb.boom.Update(System.nanoTime());
                            Bomb.boom.draw(5 + j * tileSize, 5 + i * tileSize, g2);
                        }

                } else if (loadMap[i][j] == -1) {
                    Bomb.wallExplode.Update(System.nanoTime());
                    Bomb.wallExplode.draw(j * tileSize, i * tileSize, g2);

                } else if (loadMap[i][j] == 5) {
                    if (Bomb.bomb != null) {
                        if (Bomb.explode == true) {
                            Bomb.centerExplode.Update(System.nanoTime());
                            Bomb.centerExplode.draw(j * tileSize, i * tileSize, g2);
                            if (loadMap[i - 1][j] == 4) {
                                Bomb.upExplode.Update(System.nanoTime());
                                Bomb.upExplode.draw(j * tileSize, (i - 1) * tileSize, g2);
                            }
                            if (loadMap[i + 1][j] == 4) {
                                Bomb.downExplode.Update(System.nanoTime());
                                Bomb.downExplode.draw(j * tileSize, (i + 1) * tileSize, g2);
                            }
                            if (loadMap[i][j - 1] == 4) {
                                Bomb.leftExplode.Update(System.nanoTime());
                                Bomb.leftExplode.draw((j - 1) * tileSize, i * tileSize, g2);
                            }
                            if (loadMap[i][j + 1] == 4) {
                                Bomb.rightExplode.Update(System.nanoTime());
                                Bomb.rightExplode.draw((j + 1) * tileSize, i * tileSize, g2);
                            }
                        }
                    }

                }
            }

        }
    }

}
