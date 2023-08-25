package Objects;

import java.awt.Graphics2D;

import InterFace.GamePanel;

public class GameWorld {
    GamePanel gamePanel;
    // KeyHandler keyCode = new KeyHandler(this);
    public Jerry cat;
    // public Cow cow;

    public GameWorld(GamePanel gamePanel) {
        super();
        // this.keyCode = keyCode;
        // cat = new Jerry();
        // cow = new Cow(800, 500, 80, 80, 0.1f);
    }

    public void UpdateWorld() {
        cat.updateChar();
        // cow.updateChar();
    }

    public void Render(Graphics2D g2) {
        cat.draw(g2);
        // cow.draw(g2);
    }

}
