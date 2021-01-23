package model;

import java.util.ArrayList;

public class King extends Piece {

	public King(String colour) {
		super(colour);
		this.type = "King";
		createImageIcon();
	}

	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> availablePositions = new ArrayList<Coordinate>();

		availablePositions.add(new Coordinate(row - 1, column - 1)); // one north
		availablePositions.add(new Coordinate(row - 1, column)); // one north
		availablePositions.add(new Coordinate(row - 1, column + 1)); // one north
		availablePositions.add(new Coordinate(row, column - 1)); // one north
		availablePositions.add(new Coordinate(row, column + 1)); // one north
		availablePositions.add(new Coordinate(row + 1, column - 1)); // one north
		availablePositions.add(new Coordinate(row + 1, column)); // one north
		availablePositions.add(new Coordinate(row + 1, column + 1)); // one north

		return availablePositions;
	}

}
