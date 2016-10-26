import java.awt.*;
import java.awt.event.KeyEvent;

public class Racquet 
{
    private static final int WIDTH = 60;
    private static final int HEIGHT = 10;
    public int turn = 0;

    int x;
    int y;
    int xa = 0;
    
    private Game game;

    public Racquet(Game game, int x, int y) {
        this.game = game;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(x, y, WIDTH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void moveLeft() {
        xa = -game.speed;
    }

    public void moveRight() {
        xa = game.speed;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public int getTopY() {
        return y - HEIGHT;
    }

    public int getBottomY() {
        return y;
    }

}