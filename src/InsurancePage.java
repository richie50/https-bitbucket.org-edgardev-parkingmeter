import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class InsurancePage extends JFrame implements ActionListener {

	/**
	 * I INC:UDED A INSURANCE TEST CLASS RUN THAT STUPID
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private String name;
	private JLabel expLabel;
	private JTextField model;
	private JTextField make;
	private JTextField plateNumber;
	private JButton nextButton;
	private JButton rowOne[];
	private JButton rowTwo[];
	private JButton rowThree[];
	private JButton numberRow[];
	private JTextField currField;
	private String digit[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private String firstRow[] = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" };
	private String secondRow[] = { "A", "S", "D", "F", "G", "H", "J", "K", "L" };
	private String thirdRow[] = { "Z", "X", "C", "V", "B", "N", "M" };
	private JPanel keyboardPanel;

	public InsurancePage(JFrame frame, String text) {
		this.mainFrame = frame;
		this.name = text;
	}

	public void initialize() throws IOException {
		mainFrame = new JFrame("Insurance");
		mainFrame.setSize(700, 600);
		mainFrame.getContentPane().setBackground(Color.WHITE);
		String image_path = "YorkLogo.gif";
		File path = new File(image_path);
		BufferedImage image = ImageIO.read(path);
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(330, 285, 500, 500);
		mainFrame.getContentPane().add(label);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		headerLabel = new JLabel("");
		headerLabel.setText("Select your insurance company from the drop down below");
		// int styleHeader = Font.BOLD | Font.ITALIC;
		headerLabel.setFont(new Font("Garamond", Font.CENTER_BASELINE, 14));
		headerLabel.setBounds(140, -10, 500, 60);
		mainFrame.getContentPane().add(headerLabel);
		statusLabel = new JLabel("");
		expLabel = new JLabel("Please enter expiry date(MM/YY) :");
		expLabel.setBounds(220, 70, 300, 20);
		monthLabel = new JLabel("Month:");
		monthLabel.setBounds(200, 100, 50, 20);
		yearLabel = new JLabel("Year:");
		yearLabel.setBounds(315, 100, 50, 20);
		nextButton = new JButton("Print Ticket");
		// nextButton.setBounds(380, 500, 100, 35);
		nextButton.setBounds(350, 425, 80, 30);
		nextButton.setBorder(border);
		nextButton.addActionListener(this);
		make = new JTextField(); // FIELD EDGAR
		JLabel makeLabel = new JLabel("Make :");
		make.setBounds(190, 140, 80, 30);
		makeLabel.setBounds(145, 140, 50, 30);
		this.make.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				currField = make;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		model = new JTextField(); // FIELD EDGAR
		model.setBounds(320, 140, 80, 30);
		JLabel modelLabel = new JLabel("Model :");
		modelLabel.setBounds(270, 140, 50, 30);
		this.model.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				currField = model;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		plateNumber = new JTextField(); // FIELD EDGAR
		plateNumber.setBounds(440, 140, 80, 30);
		JLabel plateLabel = new JLabel("Plate :");
		plateLabel.setBounds(400, 140, 50, 30);
		this.plateNumber.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				currField = plateNumber;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		mainFrame.getContentPane().add(expLabel);
		mainFrame.getContentPane().add(nextButton);
		mainFrame.getContentPane().add(monthLabel);
		mainFrame.getContentPane().add(yearLabel);
		mainFrame.getContentPane().add(plateNumber);
		mainFrame.getContentPane().add(make);
		mainFrame.getContentPane().add(model);
		mainFrame.getContentPane().add(modelLabel);
		mainFrame.getContentPane().add(plateLabel);
		mainFrame.getContentPane().add(makeLabel);
		mainFrame.setVisible(true);
	}

	public void initializeKeyboard() {
		int x, y;
		Border border = new BevelBorder(BevelBorder.RAISED);
		this.numberRow = new JButton[digit.length];
		x = 55;
		y = 200;
		for (int i = 0; i < digit.length; i++) {
			JButton temp = new JButton(digit[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			this.numberRow[i] = temp;
			mainFrame.getContentPane().add(numberRow[i]);
		}
		this.rowOne = new JButton[firstRow.length];
		x = 60;
		y = 255;
		for (int i = 0; i < firstRow.length; i++) {
			JButton temp = new JButton(firstRow[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			this.rowOne[i] = temp;
			mainFrame.getContentPane().add(rowOne[i]);
		}
		this.rowTwo = new JButton[secondRow.length];
		x = 75;
		y = 310;
		for (int i = 0; i < secondRow.length; i++) {
			JButton temp = new JButton(secondRow[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			this.rowTwo[i] = temp;
			mainFrame.getContentPane().add(rowTwo[i]);
		}
		this.rowThree = new JButton[thirdRow.length];
		x = 150;
		y = 365;
		for (int i = 0; i < thirdRow.length; i++) {
			JButton temp = new JButton(thirdRow[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			this.rowThree[i] = temp;
			mainFrame.getContentPane().add(rowThree[i]);
		}
		mainFrame.setVisible(true);
	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
				dim.height / 2 - mainFrame.getSize().height / 2);
		mainFrame.setVisible(true);
	}

	public void showComboboxDemo() throws IOException {
		final DefaultComboBoxModel<String> insName = new DefaultComboBoxModel<String>();
		File file = new File("companies.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			insName.addElement(line);
		}
		fileReader.close();
		final JComboBox<String> inSelect = new JComboBox<String>(insName);
		inSelect.setSelectedIndex(0);
		inSelect.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
		inSelect.setBounds(170, 35, 350, 30);
		JScrollPane inList = new JScrollPane(inSelect);
		mainFrame.getContentPane().add(inSelect);
		// adding expiry month
		final DefaultComboBoxModel<Integer> insExpM = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i < 13; i++) {
			insExpM.addElement(i);
		}
		final JComboBox<Integer> inEx = new JComboBox<Integer>(insExpM);
		inSelect.setSelectedIndex(0);
		inEx.setBounds(250, 95, 60, 30);
		JScrollPane inExx = new JScrollPane(inEx);
		mainFrame.getContentPane().add(inEx);
		// add expiry year
		final DefaultComboBoxModel<Integer> insExpY = new DefaultComboBoxModel<Integer>();
		for (int i = 2015; i < 2021; i++) {
			insExpY.addElement(i);
		}
		final JComboBox<Integer> inY = new JComboBox<Integer>(insExpY);
		inSelect.setSelectedIndex(0);
		inY.setBounds(350, 95, 90, 30);
		JScrollPane inExxY = new JScrollPane(inY);
		mainFrame.getContentPane().add(inY);
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		JButton showButton = new JButton("Next Field");
		showButton.setBounds(260, 425, 80, 30);
		showButton.setBorder(border);
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (currField == make) {
					currField = model;
				} else if (currField == model) {
					currField = plateNumber;
				} else if (currField == plateNumber) {
					// display Popup next Field is empty or set back to make
				}
			}
		});
		mainFrame.getContentPane().add(showButton);
		mainFrame.getContentPane().add(statusLabel);
		mainFrame.setVisible(true);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 * ATT: EDGAR FEEL FREE TO CHANGE THIS LISTENER , I ALREADY SET LISTENERS ON
	 * THE BUTTONS JUST DO UR MAGIC. BRUH LOL
	 */
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		// String val = ((JButton)event.getSource()).getActionCommand();
		// System.out.println("INSURANCE PAGE . . . . . . " + val);

		if (currField == null) {
			currField = make;
		}
		if (this.make.getText().toString().length() >= 8) {
			currField = model;
		}
		if (this.model.getText().toString().length() >= 8) {
			currField = plateNumber;
		}
		if (this.plateNumber.getText().toString().length() >= 8) {
			this.plateNumber.setText(this.plateNumber.getText().substring(0, 9));
		}

		if (!event.getActionCommand().equals("Print Ticket")) {
			String val = ((JButton) event.getSource()).getText().toLowerCase();
			System.out.print("KEY => ");
			System.out.println(val + " WAS PRESSED IN INSURANCEPAGE");
			currField.setText(currField.getText().toLowerCase() + val);
		}

		if (event.getActionCommand().equals("Print Ticket")) {
			String carMake = make.getText();
			String carPlate = plateNumber.getText();
			this.mainFrame.setVisible(true);
			this.mainFrame = new JFrame("RECIEPT");
			this.mainFrame.setLayout(new GridLayout());

			this.mainFrame.setSize(500, 400);
			this.mainFrame.getContentPane().setBackground(Color.WHITE);
			this.mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.mainFrame.setVisible(true);

			Calendar cal = GregorianCalendar.getInstance();

			ArrayList<String> lst = new ArrayList<String>();

			File file = new File("Ticket_database.txt");
			FileReader fileReader = null;
			try {
				fileReader = new FileReader(file);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			try {
				while ((line = bufferedReader.readLine()) != null) {

					lst.add(line);
				}
			} catch (IOException e) {

				e.printStackTrace();
			}

			String sn = (String) lst.get(0);
			String name = (String) lst.get(1);
			String status = (String) lst.get(2);

			if (status.equals("ok")) {

				JLabel label = new JLabel();
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setVerticalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Serif", Font.BOLD, 25));
				label.setText("<html>Hello " + name + "<br>Account charged $3.50 <br> Student Number : " + sn + "<br>"
						+ " Make:    " + carMake.toUpperCase() + "     Plates: " + carPlate.toUpperCase() + "<br>"
						+ cal.getTime() + "</html>");
				this.mainFrame.add(label);

			}

			else if (status.equals("arrears")) {
				JLabel label = new JLabel();
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setVerticalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("Serif", Font.BOLD, 25));
				label.setForeground(Color.red);
				label.setText("<html>PERMISSION DENIED DUE TO:<br>" + "OUTSTANDING BALANCE</html>");
				this.mainFrame.add(label);
			}

		}
	}
}