import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

    public int score1;
    public int score2;

    Ball ball = new Ball(this);
    Racquet racquet1 = new Racquet(this, 150, 330);
    Racquet racquet2 = new Racquet(this, 150, 50);

    public int speed = 1;

    private String getScore() {
        return String.format("%d - %d", score1, score2);
    }

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet1.keyReleased(e);
                racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT)
                    racquet1.moveLeft();
                if (e.getKeyCode() == KeyEvent.VK_RIGHT)
                    racquet1.moveRight();
                if (e.getKeyCode() == KeyEvent.VK_A)
                    racquet2.moveLeft();
                if (e.getKeyCode() == KeyEvent.VK_S)
                    racquet2.moveRight();
            }
        });

        setFocusable(true);
        score1 = score2 = 0;
    }

    private void move() throws InterruptedException{
        ball.move();
        racquet1.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRect(0,0,300,400);
        
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet1.paint(g2d);
        racquet2.paint(g2d);

        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Helvetica", Font.BOLD, 30));
        g2d.drawString(String.valueOf(score1), 10, 30);
        g2d.setColor(Color.BLUE);
        g2d.setFont(new Font("Helvetica", Font.BOLD, 30));
        g2d.drawString(String.valueOf(score2), 10, 330);
    }

    public void gameOver() throws InterruptedException{
        if(JOptionPane.showConfirmDialog(this, "Game over! Play again?",
                "Game Over", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            score1 = score2 = 0;
            play();
        }else{
            System.exit(ABORT);
        }
    }

    public void displayScore() {
        JOptionPane.showMessageDialog(this, "Player 1:" + score1 +  "\n Player 2:" + score2,
                "Game Over", JOptionPane.YES_NO_OPTION);
    }

    public void play() throws InterruptedException{
        while (true) {
            move();
            repaint();
            Thread.sleep(10);
            if(score1 == 3 || score2 == 3) {
                gameOver();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("PING PONG");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        game.play();
    }
}