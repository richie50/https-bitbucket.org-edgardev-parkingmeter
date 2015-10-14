
/**
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

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
	 * Default init of variables needed for this page.
	 */

	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JLabel monthLabel;
	private JLabel yearLabel;
	private JLabel expLabel;
	private JTextField model;
	private JTextField make;
	private JTextField plateNumber;
	private JButton nextButton;
	private JButton clearButton;
	private JButton rowOne[];
	private JButton rowTwo[];
	private JButton rowThree[];
	private JButton numberRow[];
	private JTextField currField;
	private String digit[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private String firstRow[] = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" };
	private String secondRow[] = { "A", "S", "D", "F", "G", "H", "J", "K", "L" };
	private String thirdRow[] = { "Z", "X", "C", "V", "B", "N", "M" };

	/**
	 * Frame for insurance page
	 * 
	 * @param frame
	 * @param text
	 */

	public InsurancePage(JFrame frame, String text) {
		this.mainFrame = frame;
	}

	/**
	 * Creates the window in the center
	 */

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
				dim.height / 2 - mainFrame.getSize().height / 2);
		mainFrame.setVisible(true);
	}

	/**
	 * Initialize the insurance page
	 * 
	 * @throws IOException
	 *             Input output exception
	 */

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
		nextButton.setBackground(Color.BLACK);
		nextButton.setForeground(new Color(153, 190, 255));
		nextButton.setOpaque(true);
		nextButton.setBorderPainted(false);
		nextButton.setBounds(350, 425, 80, 30);
		nextButton.setBorder(border);
		nextButton.addActionListener(this);
		make = new JTextField();
		JLabel makeLabel = new JLabel("Make :");
		Border field_border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		this.make.setBorder(field_border);
		this.make.setBackground(Color.LIGHT_GRAY);
		this.make.setEditable(false);
		make.setBounds(190, 140, 80, 30);
		makeLabel.setBounds(145, 140, 50, 30);
		this.make.addFocusListener(new FocusListener() {

			/**
			 * Focus created on the current field on make
			 */
			@Override
			public void focusGained(FocusEvent e) {
				currField = make;
			}

			/**
			 * Focus lost on the current field
			 */

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		model = new JTextField();
		model.setBounds(320, 140, 80, 30);
		JLabel modelLabel = new JLabel("Model :");
		this.model.setBorder(field_border);
		this.model.setBackground(Color.LIGHT_GRAY);
		this.model.setEditable(false);
		modelLabel.setBounds(270, 140, 50, 30);
		this.model.addFocusListener(new FocusListener() {

			/**
			 * Focus gained on the current field to model
			 */
			@Override
			public void focusGained(FocusEvent e) {
				currField = model;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		plateNumber = new JTextField();
		plateNumber.setBounds(440, 140, 80, 30);
		JLabel plateLabel = new JLabel("Plate :");
		this.plateNumber.setBorder(field_border);
		this.plateNumber.setBackground(Color.LIGHT_GRAY);
		this.plateNumber.setEditable(false);
		plateLabel.setBounds(400, 140, 50, 30);
		this.plateNumber.addFocusListener(new FocusListener() {

			/**
			 * Focus on currfield to plate
			 */
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

	/**
	 * Creates the keyboard for the insurance page and set the layout for the
	 * keyboard not limited to location, but also design.
	 */
	public void initializeKeyboard() {
		int x, y;
		Border border = new BevelBorder(BevelBorder.RAISED);
		this.numberRow = new JButton[digit.length];
		x = 65;
		y = 200;
		for (int i = 0; i < digit.length; i++) {
			JButton temp = new JButton(digit[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			temp.setBackground(Color.BLACK);
			temp.setForeground(new Color(153, 190, 255));
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			;
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
			temp.setBackground(Color.BLACK);
			temp.setForeground(new Color(153, 190, 255));
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			;
			this.rowOne[i] = temp;
			mainFrame.getContentPane().add(rowOne[i]);
		}
		this.rowTwo = new JButton[secondRow.length];
		x = 90;
		y = 310;
		for (int i = 0; i < secondRow.length; i++) {
			JButton temp = new JButton(secondRow[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			temp.setBackground(Color.BLACK);
			temp.setForeground(new Color(153, 190, 255));
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			;
			this.rowTwo[i] = temp;
			mainFrame.getContentPane().add(rowTwo[i]);
		}
		this.rowThree = new JButton[thirdRow.length];
		x = 115;
		y = 365;
		for (int i = 0; i < thirdRow.length; i++) {
			JButton temp = new JButton(thirdRow[i]);
			temp.setBounds(x, y, 50, 40);
			temp.setBorder(border);
			x += 60;
			temp.addActionListener(this);
			temp.setBackground(Color.BLACK);
			temp.setForeground(new Color(153, 190, 255));
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			;
			this.rowThree[i] = temp;
			mainFrame.getContentPane().add(rowThree[i]);
		}

		/*
		 * use a png image of a backspace button that everyone knows of for
		 * easier use in UI.
		 */

		ImageIcon backSPace = new ImageIcon("backspace.png");
		Image image = backSPace.getImage();
		Image temporary = image.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
		backSPace = new ImageIcon(temporary);
		this.clearButton = new JButton(backSPace);
		this.clearButton.setBackground(Color.BLACK);
		this.clearButton.setForeground(new Color(153, 190, 255));
		this.clearButton.setOpaque(true);
		this.clearButton.setBorderPainted(false);
		// this.clearButton.setBounds(530, 365, 60, 40);
		this.clearButton.setBounds(535, 365, 50, 40);
		this.clearButton.setBorder(border);
		this.mainFrame.getContentPane().add(clearButton);
		clearButton.addActionListener(new ActionListener() {

			/**
			 * See Java API
			 */
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("")) {
					if (currField.getText().length() >= 1) {
						currField.setText(currField.getText().substring(0, currField.getText().length() - 1));
					} else if (currField.getText().length() == 0) {
						currField.setText("");
					}
				}
			}
		});
		mainFrame.setVisible(true);
	}

	final DefaultComboBoxModel<Integer> insExpM = new DefaultComboBoxModel<Integer>();
	final JComboBox<Integer> inEx = new JComboBox<Integer>(insExpM);

	final DefaultComboBoxModel<Integer> insExpY = new DefaultComboBoxModel<Integer>();
	final JComboBox<Integer> inY = new JComboBox<Integer>(insExpY);

	/**
	 * Creates the combo box
	 * 
	 * @throws IOException
	 *             Input output exception
	 */
	public void showCombobox() throws IOException {
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
		inSelect.setBackground(Color.BLACK);
		inSelect.setForeground(new Color(153, 190, 255));
		inSelect.setBounds(170, 35, 350, 30);
		new JScrollPane(inSelect);
		mainFrame.getContentPane().add(inSelect);
		// adding expiry month

		for (int i = 1; i < 13; i++) {
			insExpM.addElement(i);
		}
		inSelect.setSelectedIndex(0);
		inEx.setBackground(Color.BLACK);
		inEx.setForeground(new Color(153, 190, 255));
		inEx.setBounds(250, 95, 60, 30);
		new JScrollPane(inEx);
		mainFrame.getContentPane().add(inEx);
		// add expiry year
		for (int i = 2015; i < 2021; i++) {
			insExpY.addElement(i);
		}
		inSelect.setSelectedIndex(0);
		inY.setBackground(Color.BLACK);
		inY.setForeground(new Color(153, 190, 255));
		inY.setBounds(350, 95, 90, 30);
		new JScrollPane(inY);
		mainFrame.getContentPane().add(inY);
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		JButton showButton = new JButton("Next Field");
		showButton.setBounds(260, 425, 80, 30);
		showButton.setBorder(border);
		showButton.setBackground(Color.BLACK);
		showButton.setForeground(new Color(153, 190, 255));
		showButton.setOpaque(true);
		showButton.setBorderPainted(false);
		;
		showButton.addActionListener(new ActionListener() {
			/**
			 * See Java API
			 */
			public void actionPerformed(ActionEvent e) {
				if (currField == make) {
					currField = model;
				} else if (currField == model) {
					currField = plateNumber;
				} else if (currField == plateNumber) {
					currField = make;
				}
			}
		});
		mainFrame.getContentPane().add(showButton);
		mainFrame.getContentPane().add(statusLabel);
		mainFrame.setVisible(true);
	}

	/**
	 * See Java API
	 */
	public void actionPerformed(ActionEvent event) {
		// set default field to make so when the user starts typing its directed
		// to make
		if (currField == null) {
			currField = make;
		}
		// check if Make is greater then 8, put into model because no car
		// manufacturer has a length greater the 8
		if (this.make.getText().toString().length() >= 8) {
			currField = model;
		}
		// if model is greater then 8 in length, put forward to plates
		if (this.model.getText().toString().length() >= 8) {
			currField = plateNumber;
		}
		// if plate is greater then 8, take the substring from index 0 to 8,
		// then set the field to make again in case user wants to edit make
		// again.
		if (this.plateNumber.getText().toString().length() >= 8) {
			this.plateNumber.setText(this.plateNumber.getText().substring(0, 8));
			currField = make;
		}
		// if print ticket is not pressed, user is still enter info, so the
		// fields are written to.
		if (!event.getActionCommand().equals("Print Ticket")) {
			String val = ((JButton) event.getSource()).getText().toLowerCase();
			currField.setText(currField.getText().toLowerCase() + val);
		}
		// this is where our receipt is made, a bunch of error checking
		// included!
		if (event.getActionCommand().equals("Print Ticket")) {
			String carMake = make.getText();
			String carPlate = plateNumber.getText();
			String carModel = model.getText();

			if (carMake.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the make of your vehicle.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (carModel.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the model of your vehicle.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			else if (carPlate.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please enter the plate of your vehicle.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}
			// after error checking is done, launch a new frame with the receipt
			else {
				this.mainFrame.setVisible(true);
				this.mainFrame = new JFrame("RECIEPT");
				this.mainFrame.setLayout(new GridLayout());

				this.mainFrame.setSize(1000, 400);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
						dim.height / 2 - mainFrame.getSize().height / 2);
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
					System.out.println("file does not exist, make sure path is correct");
				}
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				String line;
				try {
					while ((line = bufferedReader.readLine()) != null) {
						lst.add(line);
					}
				} catch (IOException e) {
				}

				String sn = (String) lst.get(0);
				String name = (String) lst.get(1);
				String status = (String) lst.get(2);

				// check if student is ok to park
				if (status.equals("ok")) {
					// added accepted image
					JLabel acc = new JLabel(new ImageIcon("accept.png"));
					acc.setBounds(100, 50, 80, 80);
					JLabel label = new JLabel();
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setVerticalAlignment(SwingConstants.CENTER);
					label.setFont(new Font("Serif", Font.BOLD, 25));
					// formating output for the receipt
					label.setText("<html> Hello " + name + "<br>Account charged $3.50 per day<br> Student Number : "
							+ sn + "<br>" + "Date issued : " + cal.getTime() + "<br>" + " Make:    "
							+ carMake.toUpperCase() + "<br>" + "Model: " + carModel.toUpperCase() + "<br>"
							+ "     Plates: " + carPlate.toUpperCase() + "<br>" + "Permit valid till "
							+ inEx.getItemAt(inEx.getSelectedIndex()) + "/" + inY.getItemAt(inY.getSelectedIndex())
							+ "<br>" + "</html>");
					this.mainFrame.add(acc);
					this.mainFrame.add(label);

				}
				// student has outstanding fees, declined.
				else if (status.equals("arrears")) {
					// image on receipt
					JLabel dec = new JLabel(new ImageIcon("declined.png"));
					dec.setBounds(100, 50, 80, 80);
					JLabel label = new JLabel();
					label.setHorizontalAlignment(SwingConstants.CENTER);
					label.setVerticalAlignment(SwingConstants.CENTER);
					label.setFont(new Font("Serif", Font.BOLD, 25));
					label.setForeground(Color.red);
					// formating text
					label.setText("<html>PERMISSION DENIED DUE TO:<br>"
							+ "OUTSTANDING BALANCE <br><font color='black'> For further "
							+ "information please contact: YorkU Parking Services <br> 416-736-5335</font></html>");
					this.mainFrame.add(dec);
					this.mainFrame.add(label);
				}
			}
		}
	}
}