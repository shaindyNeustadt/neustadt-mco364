package neustadt.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private Integer x;
	private Integer y;
	private BufferedImage buffer;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mousePressed(MouseEvent event) {
				Graphics g = buffer.getGraphics();
				g.setColor(Color.BLUE);
				g.fillOval(event.getX(), event.getY(), 3, 3);
				repaint();
			}

			public void mouseReleased(MouseEvent e) {
				x = null;
				y = null;
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				Graphics g = buffer.getGraphics();
				g.setColor(Color.BLUE);
				// Graphics2D g2 = (Graphics2D) g;
				 //g2.setStroke(new BasicStroke(8));
				if (x != null && y != null) {
					g.drawLine(event.getX(), event.getY(), x, y);
					x = event.getX();
					y = event.getY();
				} else {
					g.drawLine(event.getX(), event.getY(), event.getX(), event.getY());
					x = event.getX();
					y = event.getY();
				}
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
	}
}