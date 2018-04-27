package bankAccount;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.text.DecimalFormat;

public class BankPanel extends JPanel {

	private int acctNumber;
	private double balance;
	private String name;
	private String status;
	private double depWithAmt;

	private Random rand;

	private JLabel acctNameLabel;
	private JTextField acctNameTextField;
	private JLabel acctNumLabel;
	private JTextField acctNumTextField;
	private JLabel acctBalLabel;
	private JTextField acctBalTextField;
	private JLabel acctStatLabel;
	private JTextField acctStatTextField;
	private JButton depButton;
	private JButton withButton;
	private JLabel ioAmtLabel;
	private JTextField ioAmtTextField;

	private static int acctCount = 0;

	public BankPanel() {
		acctNumber = 0;
		balance = 0.0;
		name = "Unknown";
		status = "Okay";
		depWithAmt = 0.00;

		acctCount++;
		rand = new Random();

		acctNameLabel = new JLabel("Account Name ");
		acctNameTextField = new JTextField(10);
		acctNumLabel = new JLabel("Account Number ");
		acctNumTextField = new JTextField(10);
		acctBalLabel = new JLabel("Account Balance ");
		acctBalTextField = new JTextField(7);
		acctStatLabel = new JLabel("Account Status ");
		acctStatTextField = new JTextField(9);
		depButton = new JButton("Deposit");
		withButton = new JButton("Withdraw");
		ioAmtLabel = new JLabel("Deposit/Withdraw amount ");
		ioAmtTextField = new JTextField(6);

		depButton.addActionListener(new ButtonListener());
		withButton.addActionListener(new ButtonListener());

		this.add(acctNameLabel);
		this.add(acctNameTextField);
		this.add(acctNumLabel);
		this.add(acctNumTextField);
		this.add(acctBalLabel);
		this.add(acctBalTextField);
		this.add(acctStatLabel);
		this.add(acctStatTextField);
		this.add(depButton);
		this.add(withButton);
		this.add(acctNumLabel);
		this.add(acctNumTextField);
		this.add(ioAmtLabel);
		this.add(ioAmtTextField);

		this.setBackground(Color.cyan);
		this.setPreferredSize(new Dimension(250, 200));
		acctNameTextField.setText(name);
		acctNumTextField.setText(Integer.toString(acctNumber));
		acctBalTextField.setText(Double.toString(balance));
		acctStatTextField.setText(status);
		ioAmtTextField.setText(Double.toString(depWithAmt));
	}

	public BankPanel(int acctNo, double initBalance, String owner) {
		acctNumber = acctNo;
		balance = initBalance;
		name = owner;

		acctCount++;
	}

	public void setAcctNumber(int acct) {
		acctNumber = acct;
	}

	public void setBalance(double amount) {
		balance = amount;
	}

	public void setName(String someName) {
		name = someName;
	}

	public int getAcctNumber() {
		return acctNumber;
	}

	public double getBalance() {
		return balance;
	}

	public String getName() {
		return name;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

	public void withdraw(double amount) {
		balance = balance - amount;
	}

	// overloaded method. charges a fee!
	public void withdraw(double amount, double fee) {
		balance = balance - amount - fee;
	}

	public String toString() {
		return ("BankAccount : acctNumber " + acctNumber + " balance : " + balance + " name : " + name);
	}

	public static int getAcctCount() {
		return (acctCount);
	}

	private class ButtonListener implements ActionListener {
		double passengerAverage;

		public void actionPerformed(ActionEvent event) {
			
			if (event.getSource() == depButton) {
				
				depWithAmt = Double.parseDouble(ioAmtTextField.getText());
				balance = balance + depWithAmt;
				acctBalTextField.setText(Double.toString(balance));
				
				if (balance > 0) {
					
					setBackground(Color.green);
					acctStatTextField.setText("Good");
					
				}
				
				else if (balance == 0.00) {
					
					setBackground(Color.cyan);
					acctStatTextField.setText("Okay");
				}
				
				else {
					
					setBackground(Color.red);
					acctStatTextField.setText("Overdrawn");
				}
				
			}
			
			if (event.getSource() == withButton) {

				depWithAmt = Double.parseDouble(ioAmtTextField.getText());
				balance = balance - depWithAmt;
				acctBalTextField.setText(Double.toString(balance));
				
				if (balance > 0) {
					
					setBackground(Color.green);
					acctStatTextField.setText("Good");
										
				}
				
				else if (balance == 0.00) {
					
					setBackground(Color.cyan);
					acctStatTextField.setText("Okay");
				}
				
				else {
					
					setBackground(Color.red);
					acctStatTextField.setText("Overdrawn");
				}
			}

		}
	}

}// end of class definition
