package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

public class Canvas extends JPanel {
	private BufferedImage buffer;
	private Tool tool;
	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private Color color;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.RED;
		tool = new PencilTool(color);
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mousePressed(MouseEvent event) {
				redo.clear();
				undo.push(new BufferedImage(buffer.getColorModel(), buffer
						.copyData(null), buffer.isAlphaPremultiplied(), null));
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}
		});
		this.addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseMoved(MouseEvent e) {
			}
		});

	}

	public void setTool(Tool t) {
		tool = t;
	}

	public void setColor(Color color) {
		tool.setColor(color);
	}

	public BufferedImage getBufferedImage() {
		return buffer;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);
	}

	public void undo() {
		if (!undo.isEmpty()) {

			redo.push(buffer);
			buffer = undo.pop();
			repaint();
		}
	}

	public void redo() {
		if (!redo.isEmpty()) {

			undo.push(buffer);
			buffer = redo.pop();
			repaint();
		}
	}

}