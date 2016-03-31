package neustadt.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Singleton;

@Singleton
public class PaintProperties {

	private BufferedImage image;
	private Color color;
	private int weight;
	private boolean fill;
	private BasicStroke stroke;
	private int height;
	private int width;

	public PaintProperties() {
		this.weight = 3;
		this.stroke = new BasicStroke(weight);
		this.width= 800;
		this.height = 600;
		image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		color = Color.RED;
		this.fill = false;
	}

	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public BasicStroke getStroke(){
		return stroke;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
		stroke = new BasicStroke(weight);
	}

	public boolean isFill() {
		return fill;
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}