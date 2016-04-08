package neustadt.mco364.paint;

import javax.inject.Singleton;

import com.google.inject.Inject;

@Singleton
public class CanvasRepaintManager {

	private Canvas canvas;

	@Inject
	public CanvasRepaintManager(Canvas canvas) {
		this.canvas = canvas;
	}

	public void repaint(int x1, int x2, int y1, int y2) {

		int x = Math.min(x1, x2);
		int y = Math.min(y1, y2);
		int width = Math.abs(x1 - x2);
		int height = Math.abs(y1 - y2);

		canvas.repaint(x, y, width, height);
	}
}