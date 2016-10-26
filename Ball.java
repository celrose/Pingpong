import java.awt.*;
import java.awt.Color;
import java.awt.Graphics2D;

public class Ball {
    
    private static final int DIAMETER = 15;
    boolean collision = true;
    int x = 115;
    int y = 185;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() throws InterruptedException{
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0)
            ya = game.speed;
        else if (y + ya > game.getHeight() - DIAMETER || y + ya < DIAMETER ) {
            if(y + ya > game.getHeight() - DIAMETER) {
                game.score1++;
                xa = 1;
                ya = -1;
            }else{
                game.score2++;
                xa = -1;
                ya = 1;
            }
            game.displayScore();
            x = 115;
            y = 185;
            game.speed = 1;
            game.racquet1.turn = 0;
            game.racquet2.turn = 0;
            game.racquet1.x = game.racquet2.x = 125;
            game.racquet1.y = 330;
            game.racquet2.y = 70;
        }

        else if (collision1()){
            collision = true;
            ya = -game.speed;
            y = game.racquet1.getTopY() - DIAMETER;
            game.speed++;
            game.racquet1.turn++;
        } else if(collision2()) {
            collision = false;
            ya = game.speed;
            y = game.racquet2.getBottomY() + DIAMETER;
            game.speed++;
            game.racquet2.turn++;
        }else
            changeDirection = false;
               
        x = x + xa;
        y = y + ya;
    }

    private boolean collision1() { 
    	return game.racquet1.getBounds().intersects(getBounds());
    }

    private boolean collision2() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
    	g.setColor(Color.BLACK);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}