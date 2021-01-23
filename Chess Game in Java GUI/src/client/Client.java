package client;

import model.ChessBoard;
import view.MainFrame;

public class Client {

	public static void main(String[] args) {
		ChessBoard Board = new ChessBoard();
		new MainFrame(Board);
	}

}
