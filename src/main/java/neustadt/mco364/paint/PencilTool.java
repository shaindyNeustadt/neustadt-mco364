package neustadt.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class PencilTool extends Tool {
	private int x;
	private int y;

	public PencilTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.fillOval(x, y, properties.getWeight(), properties.getWeight());
		manager.repaint(x, y, x+properties.getWeight(), y+properties.getWeight());
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
	}

	public void mouseDragged(Graphics2D g, int x1, int y1) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		g.drawLine(this.x, this.y, x1, y1);
		manager.repaint(this.x, this.y, x1, y1);
		this.x = x1;
		this.y = y1;
	}

	public void drawPreview(Graphics2D g) {
	}
}