package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SquareTool implements Tool {
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int width;
	private int height;

	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
		this.width = 0;
		this.height = 0;
	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.GREEN);
		this.width = Math.abs(x - x1);
		this.height = Math.abs(y - y1);
		x2 = x;
		y2 = y;
		if (x2 < x1 && y2 < y1) {
			g.drawRect(x2, y2, width, height);
		} else if (x2 < x1) {
			g.drawRect(x2, y1, width, height);
		} else if (y2 < y1) {
			g.drawRect(x1, y2, width, height);
		} else {
			g.drawRect(x1, y1, width, height);
		}
	}

	public void mouseDragged(Graphics g, int x, int y) {
		this.x2 = x;
		this.y2 = y;
		this.width = Math.abs(x - x1);
		this.height = Math.abs(y - y1);
	}

	public void drawPreview(Graphics g) {
		g.setColor(Color.GREEN);
		if (x2 < x1 && y2 < y1) {
			g.drawRect(x2, y2, width, height);
		} else if (x2 < x1) {
			g.drawRect(x2, y1, width, height);
		} else if (y2 < y1) {
			g.drawRect(x1, y2, width, height);
		} else {
			g.drawRect(x1, y1, width, height);
		}
	}
}