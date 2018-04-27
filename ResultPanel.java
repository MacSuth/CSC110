package bankAccount;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
//import java.util.Random;

public class ResultPanel extends JPanel {

	// variable to reference parent frame
	JFrame frame;

	ResultPanel(JLabel name, JLabel address, int income, int rent, JFrame f) {

		frame = f;
		int creditScore;
		if (income < 5000) {
			creditScore = (int) Math.floor(Math.random() * 200) + 450;
		} else {
			creditScore = (int) Math.floor(Math.random() * 200) + 650;
		}

		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.add(name);
		this.add(address);
		JLabel incomeLabel = new JLabel("Income: $" + income);
		this.add(incomeLabel);
		JLabel rentLabel = new JLabel("Rent: $" + rent);
		this.add(rentLabel);
		JLabel creditLabel = new JLabel("Credit Score: " + creditScore);
		this.add(creditLabel);
		JLabel creditCard = new JLabel("Credit Card: ");
		JLabel car = new JLabel("Car Loan: ");
		JLabel mortgage = new JLabel("Mortgage: ");

		if (creditScore < 620) {
			creditCard.setText(creditCard.getText() + "Denied");
			car.setText(car.getText() + "Denied");
			mortgage.setText(mortgage.getText() + "Denied");
		} else if (creditScore >= 620 && creditScore < 650) {
			creditCard.setText(creditCard.getText() + "Approved");
			car.setText(car.getText() + "Denied");
			mortgage.setText(mortgage.getText() + "Denied");
		} else if (creditScore >= 650 && creditScore < 750) {
			creditCard.setText(creditCard.getText() + "Approved");
			car.setText(car.getText() + "Approved");
			mortgage.setText(mortgage.getText() + "Denied");
		} else {
			creditCard.setText(creditCard.getText() + "Approved");
			car.setText(car.getText() + "Approved");
			mortgage.setText(mortgage.getText() + "Approved");
		}

		this.add(creditCard);
		this.add(car);
		this.add(mortgage);

		JButton restart = new JButton("Restart");
		this.add(restart);
		restart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
				JFrame f = new JFrame();
				JPanel loanGUI = new LoanGUIPanel(f);
				f.add(loanGUI);
				f.setVisible(true);
				f.pack();
			}

		});
	}
}
