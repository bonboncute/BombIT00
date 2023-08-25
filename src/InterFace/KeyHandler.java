package InterFace;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    private GamePanel gamePanel;
    public int code;
    public boolean up, down, left, right, placeBomb, pause;

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        code = e.getKeyCode();
        if (gamePanel.gameState == gamePanel.menu) {
            gamePanel.menuState.guideState = false;
            if (code == KeyEvent.VK_UP) {
                gamePanel.menuState.menuChoose--;
                if (gamePanel.menuState.menuChoose < 0)
                    gamePanel.menuState.menuChoose = 3;
            }
            if (code == KeyEvent.VK_DOWN) {
                gamePanel.menuState.menuChoose++;
                if (gamePanel.menuState.menuChoose > 3)
                    gamePanel.menuState.menuChoose = 0;
            }

            if (code == KeyEvent.VK_ENTER) {
                if (gamePanel.menuState.menuChoose == 0)
                    gamePanel.gameState = gamePanel.play;
                else if (gamePanel.menuState.menuChoose == 1)
                    gamePanel.menuState.guideState = true;
                else if (gamePanel.menuState.menuChoose == 2) {
                    gamePanel.gameState = gamePanel.settings;
                    gamePanel.inMenu = true;
                } else if (gamePanel.menuState.menuChoose == 3)
                    System.exit(code);

            }
        } else if (gamePanel.gameState == gamePanel.settings) {
            if (code == KeyEvent.VK_UP) {
                gamePanel.menuState.settingChoose--;
                if (gamePanel.menuState.settingChoose < 0)
                    gamePanel.menuState.settingChoose = 2;
            }
            if (code == KeyEvent.VK_DOWN) {
                gamePanel.menuState.settingChoose++;
                if (gamePanel.menuState.settingChoose > 2)
                    gamePanel.menuState.settingChoose = 0;
            }
            if (gamePanel.menuState.settingChoose >= 2) {
                if (code == KeyEvent.VK_LEFT) {
                    gamePanel.menuState.settingChoose--;
                    if (gamePanel.menuState.settingChoose < 2)
                        gamePanel.menuState.settingChoose = 4;
                }
                if (code == KeyEvent.VK_RIGHT) {
                    gamePanel.menuState.settingChoose++;
                    if (gamePanel.menuState.settingChoose > 4)
                        gamePanel.menuState.settingChoose = 2;
                }
            }

            if (code == KeyEvent.VK_ENTER) {
                if (gamePanel.menuState.settingChoose == 0)
                    gamePanel.cache.musicMute();

                else if (gamePanel.inMenu == true) {
                    if (gamePanel.menuState.settingChoose == 2) {
                        gamePanel.gameState = gamePanel.menu;
                        gamePanel.inMenu = false;
                    }
                } else if (gamePanel.inPlay == true) {
                    if (gamePanel.menuState.settingChoose == 2) {
                        gamePanel.setGameObject();
                        gamePanel.gameState = gamePanel.play;

                    }
                    if (gamePanel.menuState.settingChoose == 3) {
                        gamePanel.gameState = gamePanel.menu;
                        gamePanel.setGameObject();
                    }
                    if (gamePanel.menuState.settingChoose == 4) {
                        gamePanel.gameState = gamePanel.play;
                    }
                    gamePanel.inPlay = false;
                }

            }

            if (code == KeyEvent.VK_LEFT) {
                if (gamePanel.menuState.settingChoose == 1 && gamePanel.cache.range > 1) {
                    gamePanel.cache.range--;
                    gamePanel.cache.volume();
                }
            }
            if (code == KeyEvent.VK_RIGHT) {
                if (gamePanel.menuState.settingChoose == 1 && gamePanel.cache.range < 5) {
                    gamePanel.cache.range++;
                    gamePanel.cache.volume();
                }
            }

        } else if (gamePanel.gameState == gamePanel.play) {
            if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
                up = true;

            }
            if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
                down = true;
            }
            if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
                left = true;
            }
            if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
                right = true;
            }
            if (code == KeyEvent.VK_SPACE) {
                placeBomb = true;
            }
            if (code == KeyEvent.VK_P) {
                if (gamePanel.gameState == gamePanel.play) {
                    gamePanel.gameState = gamePanel.pause;
                    pause = true;
                }

            }
            if (code == KeyEvent.VK_ESCAPE) {
                gamePanel.gameState = gamePanel.settings;
                gamePanel.inPlay = true;
            }
            if (code == KeyEvent.VK_M) {
                gamePanel.cache.musicMute();
            }
        } else if (pause == true) {
            if (code == KeyEvent.VK_LEFT) {
                gamePanel.menuState.pauseChoose--;
                if (gamePanel.menuState.pauseChoose < 0)
                    gamePanel.menuState.pauseChoose = 1;

            }
            if (code == KeyEvent.VK_RIGHT) {
                gamePanel.menuState.pauseChoose++;
                if (gamePanel.menuState.pauseChoose > 1)
                    gamePanel.menuState.pauseChoose = 0;
            }
            if (code == KeyEvent.VK_ENTER) {
                if (gamePanel.menuState.pauseChoose == 0)
                    gamePanel.gameState = gamePanel.play;

                else if (gamePanel.menuState.pauseChoose == 1) {
                    gamePanel.gameState = gamePanel.menu;
                    gamePanel.setGameObject();
                }
                pause = false;

            }
        } else if (gamePanel.gameState == gamePanel.gameOver || gamePanel.gameState == gamePanel.win) {

            if (code == KeyEvent.VK_LEFT) {
                gamePanel.menuState.overChoose--;
                if (gamePanel.menuState.overChoose < 0)
                    gamePanel.menuState.overChoose = 1;

            }
            if (code == KeyEvent.VK_RIGHT) {
                gamePanel.menuState.overChoose++;
                if (gamePanel.menuState.overChoose > 1) {
                    gamePanel.menuState.overChoose = 0;
                }
            }
            if (code == KeyEvent.VK_ENTER) {

                if (gamePanel.menuState.overChoose == 0) {
                    gamePanel.setGameObject();
                    gamePanel.gameState = gamePanel.play;

                } else if (gamePanel.menuState.overChoose == 1) {
                    gamePanel.setGameObject();
                    gamePanel.gameState = gamePanel.menu;

                }
                gamePanel.stopUpdate = false;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        code = e.getKeyCode();
        if (code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
            up = false;
        }
        if (code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
            down = false;
        }
        if (code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
            left = false;

        }
        if (code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
            right = false;
        }
        if (code == KeyEvent.VK_SPACE) {
            placeBomb = false;

        }
    }

}