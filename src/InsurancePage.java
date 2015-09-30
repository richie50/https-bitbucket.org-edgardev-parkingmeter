import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InsurancePage implements ActionListener {

	private JFrame insuranceFrame;
	private JLabel insuranceLabel;
	private JPanel insurancePanel;
	private JPanel mainInsurancePanel;
	private String insuranceName;
	private JPanel inputPanel;
	private JTextField insuranceField;
	private JButton rowOne[];
	private JButton rowTwo[];
	private JButton rowThree[];
	private JButton rowFour[];
	private String firstRow[] = { "Co-operators Insurance Company of Canada", "State Farm Underwriters Incorporated" };
	private String secondRow[] = { "Allstate International Insurance Company Ltd",
			"Metropolitan Life Insurance Company" };
	private String thirdRow[] = { "Bang Em Up Insurance Company of Vaughan", "Tightwads Incorporated" };
	private String fourthRow[] = { "Gottcha Insurance Company, Inc", "OTHER" };
	private String value;
	private JPanel buttonPanel;

	public InsurancePage(JFrame frame, String name) {
		this.insuranceFrame = frame;
		this.insuranceName = name;
	}

	public void diplayInsurancePage() {
		this.insuranceFrame = new JFrame(this.insuranceName);
		this.mainInsurancePanel = new JPanel();
		this.insurancePanel = new JPanel();
		this.inputPanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.inputPanel.setLayout(null);
		this.insurancePanel.setLayout(null);
		this.mainInsurancePanel.setLayout(new BoxLayout(mainInsurancePanel, BoxLayout.Y_AXIS));
		this.insuranceFrame.setSize(750, 500);
		this.insuranceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.insuranceFrame.setVisible(true);

	}

	public void addLabelAndText() {
		this.insuranceLabel = new JLabel("Insurance Company");
		this.insuranceLabel.setBounds(250, 20, 200, 50);
		this.insuranceField = new JTextField(30);
		this.insuranceField.setHorizontalAlignment(JTextField.LEFT);
		this.insuranceField.setBounds(250, 60, 300, 30);
		this.insurancePanel.add(insuranceLabel);
		this.insurancePanel.add(insuranceField);
		this.mainInsurancePanel.add(insurancePanel);
		this.insuranceFrame.add(mainInsurancePanel);
	}

	public void displayInput() {
		int x, y;
		// Needs action preformed to be able to output common preset emails
		// TODO implement action preformed for EMAIL row.
		this.rowOne = new JButton[firstRow.length];
		x = 200;
		y = 200;
		for (int i = 0; i < firstRow.length; i++) {
			JButton temp = new JButton(firstRow[i]);
			temp.setBounds(x, y, 150, 40);
			x += 100;
			temp.addActionListener(this);
			this.rowOne[i] = temp;
			this.inputPanel.add(rowOne[i]);
		}
		this.rowTwo = new JButton[secondRow.length];
		x = 80;
		y = 0;
		for (int i = 0; i < secondRow.length; i++) {
			JButton temp = new JButton(secondRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.rowTwo[i] = temp;
			this.inputPanel.add(rowTwo[i]);
		}
		this.rowThree = new JButton[thirdRow.length];
		x = 80;
		y = 45;
		for (int i = 0; i < thirdRow.length; i++) {
			JButton temp = new JButton(thirdRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.rowThree[i] = temp;
			this.inputPanel.add(rowThree[i]);
		}
		this.rowFour = new JButton[fourthRow.length];
		x = 80;
		y = 90;
		for (int i = 0; i < fourthRow.length; i++) {
			JButton temp = new JButton(fourthRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.rowFour[i] = temp;
			this.inputPanel.add(rowFour[i]);
		}
		this.mainInsurancePanel.add(inputPanel);
	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.insuranceFrame.setLocation(dim.width / 2 - this.insuranceFrame.getSize().width / 2,
				dim.height / 2 - this.insuranceFrame.getSize().height / 2);
		this.insuranceFrame.setVisible(true);
	}

	public int backButton() {
		JButton backButton = new JButton("BACK");
		buttonPanel.add(backButton);
		this.insuranceFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.insuranceFrame.setVisible(true);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + " ---- " + e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("BACK")) {
					// System.exit(0);
					System.out.println("****************");
				} else {
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
		return 0;
	}

	public int nextButton() {
		JButton backButton = new JButton("NEXT");
		buttonPanel.add(backButton);
		this.insuranceFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.insuranceFrame.setVisible(true);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + "\n >>" + e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("NEXT")) {
					// System.exit(0);
					System.out.println("&&&&&&&&&&NEXT&&&&&&");
				} else {
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
		return 0;
	}

	public void exitButton() {
		JButton exitButton = new JButton("EXIT");
		buttonPanel.add(exitButton);
		this.insuranceFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.insuranceFrame.setVisible(true);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + " ---- " + e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("EXIT")) {
					System.out.println("****************");
					System.exit(0);
					System.out.println("****************");
				} else {
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		value = ((JButton) event.getSource()).getText().toLowerCase();
		if (value.toString().equals("OTHER")) {
			insuranceField.setText("");
		} else {
			insuranceField.setText(insuranceField.getText().toLowerCase() + value);
		}
		System.out.print("KEY => ");
		System.out.println(value + " WAS PRESSED IN INSURANCEPAGE");
	}
}