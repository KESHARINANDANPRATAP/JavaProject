package view;

import java.awt.Color;

import javax.swing.JPanel;

import model.ChessBoard;

@SuppressWarnings("serial")
public class HeaderPanel extends JPanel{

	public HeaderPanel(ChessBoard board) {
		setBackground(Color.DARK_GRAY);
		add(new NewGameButton(board));
	}

}
