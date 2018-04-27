package bankAccount;

import java.awt.Dimension;

import javax.swing.*;

public class AllGUI {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		
		JPanel WelcomeGUI = new MainMenu();
		
		f.getContentPane().add(WelcomeGUI);

		f.pack();
		f.setVisible(true);
	}

}
