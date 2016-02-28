package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {
	private Color color;
	private int backgroundColor;
	private BufferedImage image;

	public BucketTool(BufferedImage image, Color color) {
		this.image = image;
		this.color = color;
		this.backgroundColor = 0;
	}

	public void mousePressed(Graphics g, int x, int y) {
		this.backgroundColor = image.getRGB(x, y);
		fill(x, y);
	}

	public void mouseReleased(Graphics g, int x, int y) {
	}

	public void mouseDragged(Graphics g, int x, int y) {
	}

	public void drawPreview(Graphics g) {
	}

	public void fill(int x1, int y1) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x1, y1));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.getX();
			int y = p.getY();
			if (x > 0 && y > 0 && x < image.getWidth() && y < image.getHeight()
					&& isEmpty(x, y)) {

				image.setRGB(x, y, color.getRGB());

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}
	}

	public boolean isEmpty(int posX, int posY) {
		int color = image.getRGB(posX, posY);
		return color == backgroundColor;
	}

	public void setColor(Color color) {
		this.color = color;
	}

}