import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
   Test of the Java swing functionality

   @author Wyatt Bradshaw, Gavin Clark
   @version Spring 2025
*/
class MousePanel extends JPanel {
	
	private MousePressCounter count;

	public MousePanel(MousePressCounter count){
		this.count = count;
		addMouseListener(count);
		setLayout(new BorderLayout());
	}

	@Override
    public void paintComponent(Graphics g) {

        // first, we should call the paintComponent method we are
        // overriding in JPanel
        super.paintComponent(g);
		g.drawString("Mouse press count: " + count.getClicks(), (getWidth() / 2) - g.getFontMetrics().stringWidth("Mouse press count: ") / 2, (getHeight() / 2) - (g.getFontMetrics().getAscent()) / 2);
    }
}

public class MousePressCounter implements Runnable, ActionListener, MouseListener {

	private JButton resetButton;
	private int clicks;
	private MousePanel panel;

    /**
       The run method to set up the graphical user interface

    */
    @Override
    public void run() {

        // the usual JFrame setup steps
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("MousePressCounter");
        frame.setPreferredSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		clicks = 0;
		panel = new MousePanel(this);
        // construct JPanel with a custom paintComponent method
		resetButton = new JButton("Reset");
		resetButton.addActionListener(this);

		frame.setLayout(new BorderLayout());
		frame.add(resetButton, BorderLayout.SOUTH);
		frame.add(panel, BorderLayout.CENTER);

        // display the window we've created
        frame.pack();
        frame.setVisible(true);
    }
    
	@Override
	public void mouseClicked(MouseEvent e) {
		clicks++;
		panel.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e){
		clicks = 0;
		panel.repaint();
	}


	public int getClicks(){
		return clicks;
	}
    public static void main(String args[]) {

		javax.swing.SwingUtilities.invokeLater(new MousePressCounter());
		}
}
   