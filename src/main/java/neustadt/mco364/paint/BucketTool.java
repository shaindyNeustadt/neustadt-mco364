package neustadt.mco364.paint;

import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.geom.Area;

public class BucketTool implements Tool {

	@Override
	public void mousePressed(Graphics g, int x, int y) {
		Polygon poly = new Polygon();
		g.fillPolygon(poly);
	}

	@Override
	public void mouseReleased(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(Graphics g, int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawPreview(Graphics g) {
		// TODO Auto-generated method stub

	}

}
