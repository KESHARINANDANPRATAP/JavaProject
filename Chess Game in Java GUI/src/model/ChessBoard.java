package model;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import view.GridSquare;

@SuppressWarnings("serial")
public class ChessBoard extends JPanel {

	public static final int axisLength = 8; // default = 8
	private GridSquare[][] squares = new GridSquare[axisLength][axisLength];
	public GridSquare selectedSquare;
	private ArrayList<Coordinate> validMoves;
	private String whosTurn;

	public ChessBoard() {
		setLayout(new GridLayout(axisLength, axisLength));
		initialiseBoard();
		newGame();
//		showAllMoves("White");
	}

	public GridSquare[][] getSquares() {
		return squares;
	}

	public void setSquares(GridSquare[][] squares) {
		this.squares = squares;
	}

	public GridSquare getSquare(int row, int column) {
		return squares[row][column];
	}

	private void initialiseBoard() {
		Color light = new Color(222, 184, 135);
		Color dark = new Color(128, 70, 27);
		for (int i = 0; i < axisLength; i++) {
			for (int j = 0; j < axisLength; j++) {
				if (i > 0 && squares[i - 1][j].getColour().equals(light))
					squares[i][j] = new GridSquare(this, dark, i, j);
				else if (i > 0 && squares[i - 1][j].getColour().equals(dark))
					squares[i][j] = new GridSquare(this, light, i, j);
				else if (j % 2 == 0)
					squares[i][j] = new GridSquare(this, light, i, j);
				else
					squares[i][j] = new GridSquare(this, dark, i, j);
				add(squares[i][j]);
			}
		}

	}

	private void resetBoard() {
		setSelectedSquare(null);
		for (int i = 0; i < axisLength; i++) {
			for (int j = 0; j < axisLength; j++) {
				squares[i][j].reset();
			}
		}
		resetSquareColouring();
	}

	public void newGame() {
		resetBoard();
		whosTurn = "White";
		int midpoint = (int) Math.floor(axisLength / 2);
		squares[midpoint - 4][midpoint - 4].setPiece(new Rook("Black"));
		squares[midpoint - 4][midpoint - 3].setPiece(new Knight("Black"));
		squares[midpoint - 4][midpoint - 2].setPiece(new Bishop("Black"));
		squares[midpoint - 4][midpoint - 1].setPiece(new Queen("Black"));
		squares[midpoint - 4][midpoint].setPiece(new King("Black"));
		squares[midpoint - 4][midpoint + 1].setPiece(new Bishop("Black"));
		squares[midpoint - 4][midpoint + 2].setPiece(new Knight("Black"));
		squares[midpoint - 4][midpoint + 3].setPiece(new Rook("Black"));
		for (int i = 0; i < 8; i++)
			squares[midpoint - 3][midpoint - 4 + i].setPiece(new Pawn("Black"));
		for (int i = 0; i < 8; i++)
			squares[midpoint + 2][midpoint - 4 + i].setPiece(new Pawn("White"));
		squares[midpoint + 3][midpoint - 4].setPiece(new Rook("White"));
		squares[midpoint + 3][midpoint - 3].setPiece(new Knight("White"));
		squares[midpoint + 3][midpoint - 2].setPiece(new Bishop("White"));
		squares[midpoint + 3][midpoint - 1].setPiece(new Queen("White"));
		squares[midpoint + 3][midpoint].setPiece(new King("White"));
		squares[midpoint + 3][midpoint + 1].setPiece(new Bishop("White"));
		squares[midpoint + 3][midpoint + 2].setPiece(new Knight("White"));
		squares[midpoint + 3][midpoint + 3].setPiece(new Rook("White"));
	}

	public void setSelectedSquare(GridSquare square) {
		// returns last selected square back to its original colour. (if exists)
		if (selectedSquare != null)
			selectedSquare.setBackground(selectedSquare.getColour());
		if (square != null && square.getPiece() != null) {
			selectedSquare = square;
			selectedSquare.setBackground(Color.LIGHT_GRAY);
		} else
			selectedSquare = null;

	}

	public GridSquare getSelectedSquare() {
		return selectedSquare;
	}

	public void setValidMoves(ArrayList<Coordinate> validMoves) {
		this.validMoves = validMoves;
	}

	public ArrayList<Coordinate> getValidMoves() {
		return validMoves;
	}

	public ArrayList<Coordinate> getValidMoves(ArrayList<Coordinate> possibleMoves) {
		ArrayList<Coordinate> validMoves = new ArrayList<Coordinate>();
		if (possibleMoves != null) {
			for (Coordinate possibleMove : possibleMoves) {
				if (checkValidity(possibleMove.getRow(), possibleMove.getColumn())) {
					validMoves.add(possibleMove);
				}
			}
		}
		validMoves.addAll(addExtendingMoves(validMoves));
		this.validMoves = validMoves;
		return validMoves;
	}

	private ArrayList<Coordinate> addExtendingMoves(ArrayList<Coordinate> validMoves) {
		ArrayList<Coordinate> newMoves = new ArrayList<Coordinate>();
		for (Coordinate move : validMoves) {
			if (move.doesExtendsForever()) {
				int row = selectedSquare.getRow();
				int column = selectedSquare.getColumn();
				int rowDifference = move.getRow() - row;
				int columnDifference = move.getColumn() - column;

				for (int i = 1; i < axisLength; i++) {
					if (row + i * rowDifference < axisLength && row + i * rowDifference >= 0
							&& column + i * columnDifference < axisLength && column + i * columnDifference >= 0) {

						newMoves.add(new Coordinate(row + i * rowDifference, column + i * columnDifference));
						if (squares[row + i * rowDifference][column + i * columnDifference].getPiece() != null) {
							if (squares[row + i * rowDifference][column + i * columnDifference].getPiece()
									.getColour() == selectedSquare.getPiece().getColour())
								newMoves.remove(newMoves.get(newMoves.size() - 1));

							break;
						}
					}

				}
			}
		}
		return newMoves;
	}

	private boolean checkValidity(int row, int column) {
		if (row >= 0 && row < axisLength && column >= 0 && column < axisLength) {
			Piece piece = squares[row][column].getPiece();
			if (selectedSquare.getPiece().getType() != "Pawn") {

				if (piece != null) {
					return (piece.getColour() != selectedSquare.getPiece().getColour());
				} else {
					return true;
				}

			} else {
				return pawnLogic(row, column); // pawns are completely different to all other pieces so they need
												// some unique logic

			}
		}
		return false;
	}

	private boolean pawnLogic(int row, int column) { // row, col relates to possible squares to move to
		Piece piece = squares[row][column].getPiece();
		if (selectedSquare.getColumn() == column) { // pawn moves going straight
			if (selectedSquare != null) {
				if (selectedSquare.getPiece().getColour() == "White") { // logic for white
					if (row + 2 == selectedSquare.getRow()) // logic for 2 forward
						return (squares[row + 1][column].getPiece() == null && piece == null);
				} else { // logic for black
					if (row - 2 == selectedSquare.getRow()) // logic for 2 forward
						return (squares[row - 1][column].getPiece() == null && piece == null);
				}
			}
			// 1 move for black and white defaults to return statements
			return (piece == null);
		} else { // pawn moves going sideways
			return (piece != null && piece.getColour() != selectedSquare.getPiece().getColour());
		}
	}

	public void squareClicked(GridSquare square) {
		if (square.getPiece() != null && square.getPiece().getColour() == whosTurn) {
			if ((selectedSquare == null) || (square.getPiece() != null
					&& selectedSquare.getPiece().getColour() == square.getPiece().getColour())) {
				resetSquareColouring();
				selectPieceAndShowMoves(square);
			}
		} else {
			if (selectedSquare != null && isMoveLegal(square)) {
				moveSelectedPieceToSquare(square);
			}
		}
	}

	private void selectPieceAndShowMoves(GridSquare square) {
		setSelectedSquare(square);
		getValidMoves(selectedSquare.getPiece().getPossibleMoves(square.getRow(), square.getColumn()));
		if (getValidMoves() != null) {
			for (Coordinate validSquare : getValidMoves()) {
				squares[validSquare.getRow()][validSquare.getColumn()].setBackground(Color.PINK);
				squares[validSquare.getRow()][validSquare.getColumn()].setBorder(BorderFactory.createBevelBorder(1));
			}
		}
	}

	private void moveSelectedPieceToSquare(GridSquare square) {
		if (getValidMoves() != null) {
			for (Coordinate validSquare : getValidMoves()) {

				if (validSquare.getRow() == square.getRow() && validSquare.getColumn() == square.getColumn()) {
					square.setPiece(selectedSquare.getPiece());
					selectedSquare.setPiece(null);
//					try { // uncomment to play pop sound on every move
//						AudioPlayer.player.start(new AudioStream(new FileInputStream("src/audio/pop.wav")));
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
					checkForPromotion(square);
					if (whosTurn == "White")
						whosTurn = "Black";
					else
						whosTurn = "White";
					break;
				}
			}
		}
		resetSquareColouring();
//		showAllMoves(whosTurn);
		selectedSquare = null;
		validMoves = null;
	}

	private void checkForPromotion(GridSquare square) {
		if (square.getPiece().getColour() == "White" && square.getRow() == 0 && square.getPiece().getType() == "Pawn") {
			square.setPiece(new Queen("White"));
		}
		if (square.getPiece().getColour() == "Black" && square.getRow() == axisLength - 1
				&& square.getPiece().getType() == "Pawn") {
			square.setPiece(new Queen("Black"));
		}
		// TODO allow for choosing of the piece, via pop up with radio buttons(icons)?
	}

	private void resetSquareColouring() {
		for (int i = 0; i < axisLength; i++) { // returns all squares to their original colours
			for (int j = 0; j < axisLength; j++) {
				getSquare(i, j).setBackground(getSquare(i, j).getColour());
				getSquare(i, j).setBorder(null);
			}
		}
	}

	private boolean isMoveLegal(GridSquare square) {
		return (isMoveValid(square) && !willBeInCheck(square));
//		return true;
	}

	private boolean isMoveValid(GridSquare square) {
		for (Coordinate coordinate : getValidMoves()) {
			if (coordinate.getRow() == square.getRow() && coordinate.getColumn() == square.getColumn()) {
				return true;
			}
		}
		return false;
	}

	private boolean willBeInCheck(GridSquare square) {
		Piece oldPiece = selectedSquare.getPiece();
		Piece newPiece = square.getPiece();
		ArrayList<Coordinate> oldValidMoves = getValidMoves();

		String notWhosTurn;
		if (whosTurn == "White")
			notWhosTurn = "Black";
		else
			notWhosTurn = "White";

		square.setPiece(selectedSquare.getPiece());
//		selectedSquare.setPiece(null);

		GridSquare kingSquare = null;
		for (int i = 0; i < axisLength; i++) {
			for (int j = 0; j < axisLength; j++) {
				if (squares[i][j].getPiece() != null && squares[i][j].getPiece().getType() == "King"
						&& squares[i][j].getPiece().getColour() == whosTurn) {
					kingSquare = squares[i][j];
//					System.out.println("king rowcol: " + i + j);
				}
			}
		}
//		System.out.println("square row, col: " + square.getRow() + ", " + square.getColumn());
//		System.out.println("selected square row, col: " + selectedSquare.getRow() + ", " + selectedSquare.getColumn());
		System.out.println(selectedSquare.getRow()+", "+selectedSquare.getColumn());
		for (Coordinate coord : getAllMoves(notWhosTurn)) {
			if (coord.getRow() == kingSquare.getRow() && coord.getColumn() == kingSquare.getColumn()) {
				System.out.println("King in check");
				selectedSquare.setPiece(oldPiece);
				square.setPiece(newPiece);
				setValidMoves(oldValidMoves);
				return true; // king will be in check
			}
		}
		setValidMoves(oldValidMoves);
		return false; // king will not be in check

	}

	private ArrayList<Coordinate> getAllMoves(String colour) {
		int oldSelectedSquareRow = selectedSquare.getRow();
		int oldSelectedSquareColumn = selectedSquare.getColumn();

		ArrayList<Coordinate> moves = new ArrayList<Coordinate>();
		if (colour != "White" && colour != "Black")
			return null;
		for (int row = 0; row < axisLength; row++) {
			for (int col = 0; col < axisLength; col++) {
				GridSquare square = squares[row][col];
				setSelectedSquare(square);
				if (square.getPiece() != null && square.getPiece().getColour() == colour) {
					moves.addAll(getValidMoves(square.getPiece().getPossibleMoves(row, col)));
				}
			}
		}
		setSelectedSquare(squares[oldSelectedSquareRow][oldSelectedSquareColumn]);
		return moves;
	}

	@SuppressWarnings("unused")
	private void showAllMoves(String colour) {
		ArrayList<Coordinate> coordinates = getAllMoves(colour);
		for (Coordinate coordinate : coordinates) {
			squares[coordinate.getRow()][coordinate.getColumn()].setBackground(Color.PINK);
			squares[coordinate.getRow()][coordinate.getColumn()].setBorder(BorderFactory.createBevelBorder(1));
		}
	}

}
