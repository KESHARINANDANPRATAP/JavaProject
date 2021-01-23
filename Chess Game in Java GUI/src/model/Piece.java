package model;

import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public abstract class Piece {

	protected String colour;
	protected String type;
	protected ImageIcon image;

	public Piece(String colour) {
		setColour(colour);
		
	}

	protected void createImageIcon() {
		image = new ImageIcon(
				((new ImageIcon("src/images/" + colour + type + ".png")).getImage())
				.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH));
	}
	private void setColour(String colour) {
		if (colour != null && (colour == "Black" || colour == "White"))
			this.colour = colour;
		else
			System.out.println("invalid colour given");
	}

	public String getColour() {
		return colour;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Coordinate> getPossibleMoves(int currentRow, int currentColumn) {
		return null;
	}

	public Icon getImage() {
		return image;
	}

}
