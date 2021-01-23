package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import model.ChessBoard;
import model.Piece;

@SuppressWarnings("serial")
public class GridSquare extends JButton implements ActionListener {

	private Color colour;
	private Piece piece;
	private int row;
	private int column;
	private ChessBoard board;

	public GridSquare(ChessBoard board, Color colour, int row, int column) {
		this.board = board;
		this.row = row;
		this.column = column;
		setLayout((LayoutManager) new FlowLayout(FlowLayout.CENTER, 0, 0));
		setBorder(null);
		setColour(colour);
		setBackground(this.colour);
		setPreferredSize(new Dimension(100, 100));
		addActionListener(this);
	}

	private void setColour(Color colour) {
		Color light = new Color(222,184,135);
		Color dark = new Color(128,70,27);

		if (colour.equals(dark) || colour.equals(light))
			this.colour = colour;
	}

	public Color getColour() {
		return colour;
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
		if (piece != null)
//			setIcon(new ImageIcon(
//					((new ImageIcon("src/images/" + piece.getColour() + piece.getType() + ".png")).getImage())
//							.getScaledInstance(90, 90, java.awt.Image.SCALE_SMOOTH)));
		setIcon(piece.getImage());

		else
			setIcon(null);
	}

	public void reset() {
		piece = null;
		setIcon(null);
		board.setSelectedSquare(null);

	}

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		board.squareClicked(this);
	}
}
