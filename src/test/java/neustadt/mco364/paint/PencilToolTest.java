package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class PencilToolTest {
	@Test
	public void testPencilTool() {
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		PencilTool tool = new PencilTool(properties);

		Graphics g = Mockito.mock(Graphics.class);

		tool.mousePressed(g, 2, 5);

		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).fillOval(2, 5, 1, 1);

	}
}