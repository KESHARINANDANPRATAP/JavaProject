package model;

import java.util.ArrayList;

public class Rook extends Piece {

	public Rook(String colour) {
		super(colour);
		this.type = "Rook";
		createImageIcon();
	}

	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> availablePositions = new ArrayList<Coordinate>();
		availablePositions.add(new Coordinate(row - 1, column, true));
		availablePositions.add(new Coordinate(row + 1, column, true));
		availablePositions.add(new Coordinate(row, column - 1, true));
		availablePositions.add(new Coordinate(row, column + 1, true));
		return availablePositions;
	}
}
