package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {
	private int x1;
	private int y1;
	private int width;
	private int height;

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.width = 0;
		this.height = 0;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(Color.ORANGE);
		width = x - x1;
		height = y - y1;
		g.drawOval(x1, y1, width, height);
	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		this.width = x - x1;
		this.height = y - y1;
	}

	@Override
	public void drawPreview(Graphics g) {
		g.setColor(Color.ORANGE);
		g.drawOval(x1, y1, width, height);
	}

}
