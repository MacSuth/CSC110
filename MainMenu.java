package bankAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu extends JPanel{

	private JFrame frame;
	private JLabel line1;
	private JLabel line2;
	private JButton depWith;
	private JButton loan;
	
	MainMenu() {
		
		frame = new JFrame("Welcome");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		// Welcome and ask user for purpose
		line1 = new JLabel("Welcome to your banking application!");
		line2 = new JLabel("Do you need a Deposit/Withdrawal or a Loan Application?");
		add(line1);
		add(line2);
		
		// Set up two buttons, one for dep/with and one for loans
		depWith = new JButton("Deposit/Withdrawal");
		loan = new JButton("Loan Application");
		add(depWith);
		add(loan);
		
		depWith.addActionListener(new ButtonListener());
		loan.addActionListener(new ButtonListener());
	}
	
	private class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == depWith) {
				
				  JFrame frame = new JFrame ("My Bank Account");
				  frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

				  BankPanel panel = new BankPanel();
				  frame.getContentPane().add(panel);

				  frame.pack();
				  frame.setVisible(true);
			}
			
			else if (event.getSource() == loan) {
				
				JFrame f = new JFrame();
				
				JPanel LoanGUI = new LoanGUIPanel(f);
			
				f.add(LoanGUI);
				
				f.setVisible(true);
				f.setSize(500, 300);
				f.pack();
			}
		}
	}
}
