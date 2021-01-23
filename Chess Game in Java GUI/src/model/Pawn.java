package model;

import java.util.ArrayList;

public class Pawn extends Piece {

	public Pawn(String colour) {
		super(colour);
		super.setType("Pawn");
		createImageIcon();
	}

	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> availablePositions = new ArrayList<Coordinate>();
		if (super.getColour() == "White") {
			availablePositions.add(new Coordinate(row - 1, column)); // one north
			if (row==(int) Math.floor(ChessBoard.axisLength/2)+2) //put this logic in the chessboard class
			availablePositions.add(new Coordinate(row - 2, column)); // two north
			availablePositions.add(new Coordinate(row - 1, column - 1)); // one north, one west
			availablePositions.add(new Coordinate(row - 1, column + 1)); // one north, one east
		} else {
			availablePositions.add(new Coordinate(row + 1, column)); // one south
			if (row==(int) Math.floor(ChessBoard.axisLength/2)-3) //put this logic in the chessboard class
			availablePositions.add(new Coordinate(row + 2, column)); // two south
			availablePositions.add(new Coordinate(row + 1, column + 1)); // one south, one west
			availablePositions.add(new Coordinate(row + 1, column - 1)); // one south, one east
		}
		return availablePositions;
	}
}
