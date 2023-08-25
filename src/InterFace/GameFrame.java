package InterFace;

// import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public static final int width = 1100;
    public static final int height = 720;
    GamePanel gamePanel;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("TOM AND JERRY");
        setPreferredSize(new Dimension(width, height));
        setResizable(false);
        this.pack();

        gamePanel = new GamePanel();
        add(gamePanel);

        setLocationRelativeTo(null);
        setVisible(true);

    }

    public void startGame() {
        gamePanel.startThread();
    }

}
