package neustadt.mco364.paint;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool extends Tool {
	private BufferedImage image;

	public BucketTool(PaintProperties properties) {
		super(properties);
		this.image = properties.getImage();
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		fill(x, y);
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
	}

	public void mouseDragged(Graphics2D g, int x, int y) {
	}

	public void drawPreview(Graphics2D g) {
	}

	public void fill(int x1, int y1) {
		int backgroundColor = image.getRGB(x1, y1);
		if (backgroundColor == properties.getColor().getRGB()) {
			return;
		}
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x1, y1));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.getX();
			int y = p.getY();
			if (x > 0 && y > 0 && x < image.getWidth() && y < image.getHeight()
					&& backgroundColor == image.getRGB(x, y)) {

				image.setRGB(x, y, properties.getColor().getRGB());

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}
	}
}