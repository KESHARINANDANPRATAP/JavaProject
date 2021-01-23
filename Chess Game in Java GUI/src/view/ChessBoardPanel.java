package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

import model.ChessBoard;

@SuppressWarnings("serial")
public class ChessBoardPanel extends JPanel{

	public ChessBoardPanel(ChessBoard board) {
		setLayout(new BorderLayout());
		add(board, BorderLayout.CENTER);
		add(new PositionalNumberPanel(), BorderLayout.WEST);
		add(new PositionalLetterPanel(), BorderLayout.SOUTH);
	}

}
