package neustadt.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public interface Tool {

	void mousePressed(Graphics g, BufferedImage buffer, int x, int y);

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);

	void drawPreview(Graphics g);
}