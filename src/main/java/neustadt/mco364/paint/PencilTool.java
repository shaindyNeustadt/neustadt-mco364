package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class PencilTool implements Tool {
	private int x;
	private int y;

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		g.setColor(Color.BLUE);
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
