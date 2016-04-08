package neustadt.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class SquareTool extends Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;

	public SquareTool(CanvasRepaintManager manager, PaintProperties properties) {
		super(manager, properties);
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
		this.width = 0;
		this.height = 0;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		this.width = Math.abs(x - x1);
		this.height = Math.abs(y - y1);
		x2 = x;
		y2 = y;
		int tempX = Math.min(x1, x2);
		int tempY = Math.min(y1, y2);
		g.drawRect(tempX, tempY, width, height);
	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
		this.width = Math.abs(x - x1);
		this.height = Math.abs(y - y1);
	}

	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getStroke());
		int tempX = Math.min(x1, x2);
		int tempY = Math.min(y1, y2);
		g.drawRect(tempX, tempY, width, height);
	}
}