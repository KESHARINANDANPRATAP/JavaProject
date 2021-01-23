package view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PositionalNumberPanel extends JPanel{

	public PositionalNumberPanel() {
		setLayout(new GridLayout(8,1));
		setBackground(Color.DARK_GRAY);

		String[] numbers = {"1","2","3","4","5","6","7","8"};
		for (String number : numbers)
			add(new JLabel(number));
	}

}
