package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import model.ChessBoard;

@SuppressWarnings("serial")
public class NewGameButton extends JButton implements ActionListener{

	ChessBoard board;
	
	public NewGameButton(ChessBoard board) {
		this.board = board;
		setText("New Game");
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		board.newGame();
	}

}
