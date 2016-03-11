package neustadt.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	private JButton undo;
	private JButton redo;
	private JButton colorChooser;
	private JButton lastPressed;
	private PaintProperties properties;
	private ToolButton[] buttons;

	@Inject
	public PaintFrame(PaintProperties properties) {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		this.properties = properties;

		final Canvas canvas = new Canvas(properties);
		container.add(canvas, BorderLayout.CENTER);

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

		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
				button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
				lastPressed.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
				lastPressed = button;
			}
		};

		JPanel toolbar = new JPanel();
		toolbar.setLayout(new GridLayout(1, 7));
		toolbar.add(undoRedoPanel);
		buttons = new ToolButton[] { new ToolButton(new PencilTool(properties), "/pencil.jpg"),
				new ToolButton(new LineTool(properties), "/line.jpg"),
				new ToolButton(new SquareTool(properties), "/square.jpg"),
				new ToolButton(new OvalTool(properties), "/circle.jpg"),
				new ToolButton(new BucketTool(properties), "/bucket.jpg") };
		for (ToolButton button : buttons) {
			toolbar.add(button);
			button.addActionListener(listener);
		}
		lastPressed = buttons[0];
		buttons[0].setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		colorChooser = new JButton("Choose Color");
		colorChooser.setBackground(Color.RED);

		toolbar.add(colorChooser);

		container.add(toolbar, BorderLayout.NORTH);
		setVisible(true);

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

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new PaintModule());
		PaintProperties properties = injector.getInstance(PaintProperties.class);

		PaintFrame frame = injector.getInstance(PaintFrame.class);
	}
}