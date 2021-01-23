package model;

public class Coordinate {

	private int row;
	private int column;
	private boolean extendsForever;

	public Coordinate(int row, int column) {
		this.row = row;
		this.column = column;
		this.extendsForever = false;
	}

	public Coordinate(int row, int column, boolean extendsForever) {
		this.row = row;
		this.column = column;
		this.extendsForever = extendsForever;
	}

	public int getColumn() {
		return column;
	}
	
	public int getRow() {
		return row;
	}


	public boolean doesExtendsForever() {
		return extendsForever;
	}

}
