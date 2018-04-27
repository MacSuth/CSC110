package bankAccount;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoanGUIPanel extends JPanel {

	JFrame frame;

	LoanGUIPanel(JFrame f) {

		frame = f;
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		// Name of user
		JPanel nameLine = new JPanel();
		nameLine.setLayout(new FlowLayout());
		JLabel name = new JLabel("Name: ");
		JTextField nameField = new JTextField(30);
		nameLine.add(name);
		nameLine.add(nameField);
		this.add(nameLine);

		// Address of user
		JPanel addressLine = new JPanel();
		addressLine.setLayout(new FlowLayout());
		JLabel address = new JLabel("Address: ");
		JTextField addressField = new JTextField(30);
		addressLine.add(address);
		addressLine.add(addressField);
		this.add(addressLine);

		// Income of user
		JPanel incomeLine = new JPanel();
		incomeLine.setLayout(new FlowLayout());
		JLabel monthlyIncome = new JLabel("Monthly Income: ");
		JTextField incomeField = new JTextField(7);
		incomeLine.add(monthlyIncome);
		incomeLine.add(incomeField);
		this.add(incomeLine);

		// Rent of user
		JPanel rentLine = new JPanel();
		rentLine.setLayout(new FlowLayout());
		JLabel rent = new JLabel("Monthly Mortgage: ");
		JTextField rentField = new JTextField(7);
		rentLine.add(rent);
		rentLine.add(rentField);
		this.add(rentLine);

		// Apply button
		JButton n = new JButton("Apply");
		this.add(n);

		// Action Listener for button
		n.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				// Store name and address
				String name = nameField.getText();
				String address = nameField.getText();
				JLabel nameResult = new JLabel("Name: " + name);
				JLabel addressResult = new JLabel("Address: " + address);

				// Try to parse rent amount and income amount
				int rentAmount, incomeAmount;
				try {
					rentAmount = Integer.parseInt(rentField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter an integer value for the monthly mortgage.");
					return;
				}

				try {
					incomeAmount = Integer.parseInt(incomeField.getText());
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please enter an integer value for the monthly income.");
					return;
				}

				// create new frame to display results
				JFrame frame2 = new JFrame();
				JPanel resultPanel = new ResultPanel(nameResult, addressResult, incomeAmount, rentAmount, frame2);
				frame.dispose();
				frame2.add(resultPanel);
				frame2.setVisible(true);
				frame2.pack();
			}
		});

	}
}