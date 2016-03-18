package neustadt.mco364.paint;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

@Singleton
public class PaintToolbar extends Container {
	private ToolButton[] buttons;
	private JButton colorChooser;
	private ToolButton lastPressed;
	private JButton undo, redo;

	@Inject
	public PaintToolbar(Canvas canvas, PaintProperties properties) {
		setLayout(new GridLayout(1, 7));

		JPanel undoRedoPanel = new JPanel();
		undoRedoPanel.setLayout(new GridLayout(2, 0));

		undo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/undo.png")).getImage().getScaledInstance(35,
				35, Image.SCALE_SMOOTH)));
		undo.setBackground(Color.WHITE);

		redo = new JButton();
		redo.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/redo.png")).getImage().getScaledInstance(35,
				35, Image.SCALE_SMOOTH)));
		redo.setBackground(Color.WHITE);

		undoRedoPanel.add(undo);
		undoRedoPanel.add(redo);

		add(undoRedoPanel);

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
				lastPressed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastPressed = button;
			}
		};

		buttons = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.jpg"),
				new ToolButton(new LineTool(properties), "/line.jpg"),
				new ToolButton(new SquareTool(properties), "/square.jpg"),
				new ToolButton(new OvalTool(properties), "/circle.jpg"),
				new ToolButton(new BucketTool(properties), "/bucket.jpg") };
		for (ToolButton button : buttons) {
			add(button);
			button.addActionListener(listener);
		}
		lastPressed = buttons[0];
		buttons[0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		colorChooser = new JButton("Choose Color");
		colorChooser.setBackground(Color.RED);

		add(colorChooser);

		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(colorChooser, "Choose Background Color",
						colorChooser.getBackground());
				if (color != null) {
					colorChooser.setBackground(color);
					properties.setColor(color);
				}
			}
		});

		undo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.undo();
			}
		});

		redo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.redo();
			}
		});
	}
}