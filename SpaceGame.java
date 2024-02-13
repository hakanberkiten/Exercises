import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.HeadlessException;

import javax.swing.JFrame;

 class Screen extends JFrame{
    

    public Screen(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) {
        Screen screen = new Screen("Space Game");

         screen.setResizable(false);
         screen.setFocusable(false);

         screen.setSize(800,600);

          screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          SpaceGame game = new SpaceGame();
          game.requestFocus();
          game.addKeyListener(game);

          game.setFocusable(true);
          game.setFocusTraversalKeysEnabled(false);

          screen.add(game);

          screen.setVisible(true);


    }
}

class Fire {
    private int x;
    private int y;

    public Fire(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}

public class SpaceGame extends JPanel implements KeyListener, ActionListener {
    Timer timer = new Timer(5, this);
    private long startTime; 
    private long stopTime;  
    private long elapsedTime;
    private int time = 0;
    private int countFire = 0;
    private BufferedImage image;

    private ArrayList<Fire> fires = new ArrayList<Fire>();

    private int addY = 10;

    private int ballX = 0;

    private int addX = 8;

    private int shipX = 0;

    private int addShipx = 20;

    public boolean check(){
    for(Fire fire : fires){
        if(new Rectangle(fire.getX(), fire.getY(), 10, 20).intersects(new Rectangle(ballX, 0 , 30 , 30))){
            return true;
            
        }
    }
    return false;

    }

    public SpaceGame() {
        try {
            image = ImageIO.read(new File("Ship.jpg"));
        } catch (IOException e) {
            Logger.getLogger(SpaceGame.class.getName()).log(Level.SEVERE, null, e);
        }
        setBackground(Color.BLACK);
        setFocusable(true); 

        addKeyListener(this); 
        timer.start();
        startTime = System.currentTimeMillis(); 

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        time += 5;

        ArrayList<Fire> firesToRemove = new ArrayList<Fire>();

        for (Fire fire : fires) {
            if (fire.getY() < 0) {
                firesToRemove.add(fire);
            } else {
                g.setColor(Color.RED);
                g.fillRect(fire.getX(), fire.getY(), 10, 20);
            }
        }

        fires.removeAll(firesToRemove);

        g.setColor(Color.CYAN);
        g.fillOval(ballX, 0, 30, 30);

        g.drawImage(image, shipX, 420, image.getWidth() / 10, image.getHeight() / 10, this);

        if(check()){
         timer.stop();
         stopTime = System.currentTimeMillis(); 
         elapsedTime = stopTime - startTime;
         String message = "Game Over :) \n" + "Used Fire: " + countFire/2 +"\n" + "Time: " + elapsedTime/ 1000.0; 
         JOptionPane.showMessageDialog(this, message);
         System.exit(0);  
        } 
    }



    @Override
    public void actionPerformed(ActionEvent e) {

        for(Fire fire : fires){
            fire.setY(fire.getY() - addY);

        }

        ballX += addX;

        if(ballX >= 750){
            addX = -addX;
        }
        if(ballX<=0){

         addX = -addX;   
        }
        repaint();

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c = e.getKeyCode();   
        if(c == KeyEvent.VK_LEFT){
            if(shipX<=0){
                shipX = 0;
            }
            else{
                shipX -= addShipx;
            }
  
        }
        else if(c == KeyEvent.VK_RIGHT){
            if(shipX>=640){
                shipX = 640;
            }
            else{
                shipX += addShipx;
            }
  
        }
        else if(c == KeyEvent.VK_SPACE){
            fires.add(new Fire(shipX + 70,420));
            countFire++;

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

     


    }
}
