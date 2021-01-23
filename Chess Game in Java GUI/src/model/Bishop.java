package model;

import java.util.ArrayList;

public class Bishop extends Piece {

	public Bishop(String colour) {
		super(colour);
		this.type = "Bishop";
		createImageIcon();
	}

	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> availablePositions = new ArrayList<Coordinate>();
		availablePositions.add(new Coordinate(row - 1, column - 1, true));
		availablePositions.add(new Coordinate(row - 1, column + 1, true));
		availablePositions.add(new Coordinate(row + 1, column - 1, true));
		availablePositions.add(new Coordinate(row + 1, column + 1, true));
		return availablePositions;
	}
}
