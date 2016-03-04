package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ToolButton extends JButton {

	private Tool tool;

	public ToolButton(Tool tool, String iconName) {
		this.tool = tool;
		this.setIcon(new ImageIcon(new ImageIcon(getClass().getResource(iconName)).getImage().getScaledInstance(75, 75,
				Image.SCALE_SMOOTH)));

		this.setBackground(Color.WHITE);
	}

	public Tool getTool() {
		return tool;
	}
}