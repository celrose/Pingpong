import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    /*
     *  created by rcadavos 10/21/2016
     */
    
//static main that was never connected to the main game hahahahaha
public class Main {

    //Game's Main Menu
	public static void main(String[] args) {
        //new frame and new panel
		JFrame frame = new JFrame("Ping Pong");
		frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);
        mainMenu(panel);
        frame.setVisible(true);
	}

	private static void mainMenu(JPanel panel) {
		panel.setLayout(null);
        //When this button is clicked, the game will start
        JButton startButton = new JButton("START GAME");
        startButton.setBounds(100, 110, 200, 50);
        panel.add(startButton);

        //because of this action listener
        startButton.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          	JFrame playPong = new JFrame();
            playPong.setSize(400, 500);
            playPong.setResizable(false);
            playPong.setLocationRelativeTo(null);
            
            JPanel pongPanel = new JPanel(new BorderLayout());
            playPong.add(pongPanel);
            playPong.setVisible(true);

            startGame(pongPanel);

          }
        });
        //Button that shows the player controls of the game
        JButton controlsButton = new JButton("CONTROLS");
        controlsButton.setBounds(100, 180, 200, 50);
        panel.add(controlsButton);

        controlsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame control = new JFrame();
                control.setSize(400, 500);
                control.setResizable(false);
                control.setLocationRelativeTo(null);

                JPanel controlPanel = new JPanel();
                controlPanel.setLayout(null);

                String instructions = new String("<html><h2><center> PLAYER 1 </center></h2><br> <h2><center> use A and D</center> <br><center>to navigate left and right </center></h2> <br> <h2><center> PLAYER 2 </center></h2><br> <h2><center> use the LEFT and RIGHT </center> <br> <center>arrow keys to navite left and right.</center></h2><br></html>");
                JLabel controlLabel = new JLabel(instructions);
                controlLabel.setBounds(50, 20, 350, 380);

                //When this button is pressed, this closes the control frame and shows the Main Menu again
                JButton back = new JButton("BACK");
                back.setBounds(100, 350, 200, 50);
                
                control.add(controlPanel);
                controlPanel.add(controlLabel);
                controlPanel.add(back);
                control.setVisible(true);

                back.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        control.dispose();
                    }
                });
            }
        });
        
        //Exit botton to close the game
        JButton exitButton = new JButton("EXIT");
        exitButton.setBounds(100, 250, 200, 50);
        panel.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		System.exit(0);
        	}
        });
	}

    public static void startGame(JPanel pongPanel) {

    }
}

