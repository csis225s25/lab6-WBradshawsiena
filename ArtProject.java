import java.awt.*;
import javax.swing.*;

/**
 * Lab 6 starter example
 * 
 * @author Gavin Clark, Wyatt B
 * @version Spring 2025
 */

// a class that extends JPanel to override the paintComponent method,
// allowing us to interact with Java's graphics system
class ArtPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
        Color color1 = new Color(255, 0, 0);
        Color color2 = new Color(0, 255, 0);
        Color color3 = new Color(0, 0, 255);
        g.drawRect(200, 100, 100, 100);
        g.fillRect(200, 300, 20, 40);
        g.setColor(color1);
        g.fillOval(200, 300, 20, 10);
        g.setColor(color2);
        g.fillArc(100, 20, 150 ,80, 45, 5);
        g.setColor(color3);
        g.drawLine(0, 0, 400, 500);
    }
}

public class ArtProject implements Runnable {

    /**
     * The run method to set up the graphical user interface
     */

    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("ArtProject");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // construct JPanel with a custom paintComponent method
        JPanel panel = new ArtPanel();
        frame.add(panel);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String args[]) {
        javax.swing.SwingUtilities.invokeLater(new ArtProject());
    }
}
