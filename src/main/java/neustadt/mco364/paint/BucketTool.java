package neustadt.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketTool implements Tool {

	public void mousePressed(Graphics g, BufferedImage buffer, int x, int y) {
		fill(buffer, x, y);
	}

	public void mouseReleased(Graphics g, int x, int y) {
	}

	public void mouseDragged(Graphics g, int x, int y) {
	}

	public void drawPreview(Graphics g) {
	}

	public void fill(BufferedImage buffer, int x1, int y1) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x1, y1));

		while (!queue.isEmpty()) {
			Point p = queue.remove();
			int x = p.getX();
			int y = p.getY();
			if (x > 0 && y > 0 && x < buffer.getWidth()
					&& y < buffer.getHeight() && isEmpty(buffer, x, y)) {

				buffer.setRGB(x, y, -256);

				queue.add(new Point(x - 1, y));
				queue.add(new Point(x + 1, y));
				queue.add(new Point(x, y - 1));
				queue.add(new Point(x, y + 1));
			}
		}
	}

	public boolean isEmpty(BufferedImage image, int posX, int posY) {
		int color = image.getRGB(posX, posY);
		return color == 0;
	}

}