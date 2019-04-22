import java.awt.*;
import java.awt.Point;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class DrawRectangleOnMouseClick extends JPanel{

    MouseHandler mouseHandler = new MouseHandler();
    Point p1 = new Point(0, 0);
    Random rand = new Random();

    int x = rand.nextInt(400);
    int y = rand.nextInt(300);

    public DrawRectangleOnMouseClick(){
        this.setPreferredSize(new Dimension(500, 400));
        this.addMouseListener(mouseHandler);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(x, y, 100, 100);
        g.fillRect(x, y, 100, 100);
    }


    private class MouseHandler extends MouseAdapter {

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
        JFrame f = new JFrame("Draw Rectangle On Mouse Click");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new DrawRectangleOnMouseClick());
        f.pack();
        f.setVisible(true);
    }
}
