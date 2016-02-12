package neustadt.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PaintFrame extends JFrame{

	private JButton line;
	public PaintFrame(){
		setTitle("PaintFrame");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		
		line = new JButton("Line");
		Canvas canvas = new Canvas();
		container.add(canvas, BorderLayout.CENTER);
		container.add(line, BorderLayout.NORTH);		
		setVisible(true);
		}
	
	
	public static void main(String[] args){
		new PaintFrame();
	}
}
