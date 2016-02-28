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

public class PaintFrame extends JFrame {

	private JButton undo;
	private JButton redo;
	private JButton pencil;
	private JButton line;
	private JButton square;
	private JButton oval;
	private JButton bucket;
	private JButton colorChooser;
	private JButton lastPressed;
	private Color color;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		final Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);
		JPanel undoRedoPanel = new JPanel();
		undoRedoPanel.setLayout(new GridLayout(2, 0));
		undo = new JButton();
		undo.setIcon(new ImageIcon(new ImageIcon("./undo.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		undo.setBackground(Color.WHITE);
		redo = new JButton();
		redo.setIcon(new ImageIcon(new ImageIcon("./redo.png").getImage()
				.getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
		redo.setBackground(Color.WHITE);

		undoRedoPanel.add(undo);
		undoRedoPanel.add(redo);
		JPanel panel = new JPanel();

		pencil = new JButton();
		pencil.setIcon(new ImageIcon(new ImageIcon("./pencil.jpg").getImage()
				.getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
		pencil.setBackground(Color.WHITE);

		line = new JButton();
		line.setIcon(new ImageIcon(new ImageIcon("./line.jpg").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		line.setBackground(Color.WHITE);

		square = new JButton();
		square.setIcon(new ImageIcon(new ImageIcon("./square.jpg").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		square.setBackground(Color.WHITE);

		oval = new JButton();
		oval.setIcon(new ImageIcon(new ImageIcon("./circle.jpg").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		oval.setBackground(Color.WHITE);

		bucket = new JButton();
		bucket.setIcon(new ImageIcon(new ImageIcon("./bucket.jpg").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		bucket.setBackground(Color.WHITE);

		colorChooser = new JButton("Choose Color");
		colorChooser.setBackground(Color.RED);
		color = Color.RED;

		pencil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
		lastPressed = pencil;

		panel.setLayout(new GridLayout(1, 7));
		panel.add(undoRedoPanel);
		panel.add(pencil);
		panel.add(line);
		panel.add(square);
		panel.add(oval);
		panel.add(bucket);
		panel.add(colorChooser);

		container.add(panel, BorderLayout.NORTH);
		setVisible(true);

		colorChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(colorChooser,
						"Choose Background Color", colorChooser.getBackground());
				if (color != null) {
					colorChooser.setBackground(color);
					canvas.setColor(color);
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

		pencil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new PencilTool(color));
				pencil.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				lastPressed.setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 1));
				lastPressed = pencil;
			}
		});

		line.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new LineTool(color));
				line.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				lastPressed.setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 1));
				lastPressed = line;
			}
		});

		square.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new SquareTool(color));
				square.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				lastPressed.setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 1));
				lastPressed = square;
			}
		});

		oval.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new OvalTool(color));
				oval.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				lastPressed.setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 1));
				lastPressed = oval;
			}
		});

		bucket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new BucketTool(canvas.getBufferedImage(), color));
				bucket.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
				lastPressed.setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 1));
				lastPressed = bucket;
			}
		});
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
