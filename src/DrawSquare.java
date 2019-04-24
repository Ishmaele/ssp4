import sun.plugin2.util.ColorUtil;

import java.awt.*;
import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DrawSquare extends JPanel{

    MouseListen mouseListen = new MouseListen();
    Point p1 = new Point(0, 0);
    Random rand = new Random();

    int x = rand.nextInt(400);
    int y = rand.nextInt(300);

    public DrawSquare(){
        this.setPreferredSize(new Dimension(500, 400));
        this.addMouseListener(mouseListen);
    }
    public void paintComponent(Graphics g) {
        Color myRandColor = new Color(rand.nextInt( 255),rand.nextInt( 255),rand.nextInt( 255));
        int width = ThreadLocalRandom.current().nextInt(50, 150);
        //int height = ThreadLocalRandom.current().nextInt(50, 150);
        g.drawRect(x, y, width, width);
        g.setColor(myRandColor);
        g.fillRect(x, y, width, width);
    }

    public class MouseListen extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            p1 = e.getPoint();

            if (p1.x>x && p1.x<(x+100) && p1.y>y && p1.y <(y+100))
            {
                repaint();
                x = rand.nextInt(400);
                y = rand.nextInt(300);
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame("Draw Square");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new DrawSquare());
        f.pack();
        f.setVisible(true);
    }
}
