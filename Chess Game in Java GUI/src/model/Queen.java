package model;

import java.util.ArrayList;

public class Queen extends Piece {

	public Queen(String colour) {
		super(colour);
		this.type = "Queen";
		createImageIcon();
	}
	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> availablePositions = new ArrayList<Coordinate>();
		availablePositions.addAll(new Bishop(colour).getPossibleMoves(row,column));
		availablePositions.addAll(new Rook(colour).getPossibleMoves(row,column));
		return availablePositions;
	}
}
