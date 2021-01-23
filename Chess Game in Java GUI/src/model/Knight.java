package model;

import java.util.ArrayList;


public class Knight extends Piece {

	public Knight(String colour) {
		super(colour);
		this.type = "Knight";
		createImageIcon();
	}
	
	@Override
	public ArrayList<Coordinate> getPossibleMoves(int row, int column) {
		ArrayList<Coordinate> possibleMoves = new ArrayList<Coordinate>();
			possibleMoves.add(new Coordinate(row - 2, column-1)); //one north
			possibleMoves.add(new Coordinate(row - 2, column+1)); //two north
			possibleMoves.add(new Coordinate(row - 1, column - 2)); //one north, one west
			possibleMoves.add(new Coordinate(row - 1, column + 2)); //one north, one east
			possibleMoves.add(new Coordinate(row +1, column-2)); //one north
			possibleMoves.add(new Coordinate(row +1, column+2)); //two north
			possibleMoves.add(new Coordinate(row +2, column - 1)); //one north, one west
			possibleMoves.add(new Coordinate(row +2, column + 1)); //one north, one east
		return possibleMoves;
	}
}
