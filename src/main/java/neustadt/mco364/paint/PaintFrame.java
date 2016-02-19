package neustadt.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil;
	private JButton line;
	private JButton square;
	private JButton oval;
	private JButton bucket;

	public PaintFrame() {
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);
		JPanel panel = new JPanel();
		pencil = new JButton("Pencil");
		line = new JButton("Line");
		square = new JButton("Square");
		oval = new JButton("Oval");
		bucket = new JButton("Bucket");
		panel.setLayout(new GridLayout(1, 5));
		panel.add(pencil);
		panel.add(line);
		panel.add(square);
		panel.add(oval);
		panel.add(bucket);
		container.add(panel, BorderLayout.NORTH);
		setVisible(true);

		pencil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new PencilTool());
			}
		});
		
		line.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new LineTool());
			}
		});
		
		
		square.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new SquareTool());
			}
		});
		
		oval.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new OvalTool());
			}
		});
		
		bucket.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				canvas.setTool(new BucketTool());
			}
		});
	}

	public static void main(String[] args) {
		new PaintFrame();
	}
}
