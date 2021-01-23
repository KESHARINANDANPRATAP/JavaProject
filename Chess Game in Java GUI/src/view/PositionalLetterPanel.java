package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PositionalLetterPanel extends JPanel{

	public PositionalLetterPanel() {
		setLayout(new GridLayout(1,8));
		setBackground(Color.DARK_GRAY);
		String[] letters = {"a","b","c","d","e","f","g","h"};
		for (String letter : letters)
			add(new JLabel(letter));
	}

}
