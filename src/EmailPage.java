
/**
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;

public class EmailPage extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JFrame emailFrame;
	private String name;
	private JLabel email;
	private JTextField email_field;
	private JButton rowOne[];
	private JButton rowTwo[];
	private JButton rowThree[];
	private JButton numberRow[];
	private JButton clearButton;
	private JButton emailButtons[];
	private String emailRow[] = { "@my.yorku.ca", "@gmail.com", "@hotmail.com", "@yahoo.ca", "@live.com" };
	private String digit[] = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
	private String firstRow[] = { "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P" };
	private String secondRow[] = { "A", "S", "D", "F", "G", "H", "J", "K", "L", "@" };
	private String thirdRow[] = { "Z", "X", "C", "V", "B", "N", "M", "_", "." };
	private String value;

	/**
	 * Creates frame for the email page
	 * 
	 * @param frame
	 * @param text
	 */

	public EmailPage(JFrame frame, String text) {
		this.emailFrame = frame;
		this.name = text;
	}

	/**
	 * Displays the email page
	 * 
	 * @throws IOException
	 *             Input Output exception
	 */

	public void diplayEmailPage() throws IOException {
		this.emailFrame = new JFrame(this.name);
		this.emailFrame.getContentPane().setLayout(null);
		this.emailFrame.getContentPane().setBackground(Color.WHITE);
		this.emailFrame.setSize(700, 600);
		String image_path = "YorkLogo.gif";
		File path = new File(image_path);
		BufferedImage image = ImageIO.read(path);
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(330, 285, 500, 500);
		emailFrame.getContentPane().add(label);
		this.emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.emailFrame.setVisible(true);

	}

	/**
	 * Creates labels for input of email address
	 */

	public void addEmailLabelAndTextFeild() {
		JLabel prompt = new JLabel("Subscribe for our news letters and offers below.");
		prompt.setBounds(200, 0, 400, 100);
		this.email = new JLabel("EMAIL (OPTIONAL) :");
		this.email.setBounds(120, 100, 300, 30);
		this.email_field = new JTextField(30);
		this.email_field.setBounds(250, 100, 300, 30);
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		this.email_field.setBorder(border);
		this.email_field.setBackground(Color.LIGHT_GRAY);
		this.email_field.setEditable(false);
		this.emailFrame.getContentPane().add(prompt);
		this.emailFrame.getContentPane().add(email);
		this.emailFrame.getContentPane().add(email_field);
		this.emailFrame.setVisible(true);
	}

	/**
	 * Creates qwerty keyboard
	 */

	public void displayKeyboard() {
		int x, y;
		Border border = new BevelBorder(BevelBorder.RAISED);
		this.emailButtons = new JButton[emailRow.length];
		x = 60;
		y = 390;
		for (int i = 0; i < emailRow.length; i++) {
			JButton temp = new JButton(emailRow[i]);
			temp.setBounds(x, y, 110, 40);
			temp.setBorder(border);
			x += 120;
			temp.addActionListener(this);
			temp.setBackground(Color.BLACK);
			temp.setForeground(new Color(153, 190, 255));
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			;
			this.emailButtons[i] = temp;
			this.emailFrame.getContentPane().add(emailButtons[i]);
		}
		this.numberRow = new JButton[digit.length];
		x = 60;
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
			this.emailFrame.getContentPane().add(numberRow[i]);
		}
		this.rowOne = new JButton[firstRow.length];
		x = 60;
		y = 245;
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
			this.emailFrame.getContentPane().add(rowOne[i]);
		}
		this.rowTwo = new JButton[secondRow.length];
		x = 60;
		y = 290;
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
			this.emailFrame.getContentPane().add(rowTwo[i]);
		}
		// create the clear button
		ImageIcon backSPace = new ImageIcon("backspace.png");
		Image image = backSPace.getImage();
		Image temporary = image.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
		backSPace = new ImageIcon(temporary);
		this.clearButton = new JButton(backSPace);
		this.clearButton.setBackground(Color.BLACK);
		this.clearButton.setForeground(new Color(153, 190, 255));
		this.clearButton.setOpaque(true);
		this.clearButton.setBorderPainted(false);
		;
		this.clearButton.setBounds(600, 340, 50, 40);
		this.clearButton.setBorder(border);
		this.emailFrame.getContentPane().add(clearButton);
		clearButton.addActionListener(new ActionListener() {

			/**
			 * See JAVA API
			 */

			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("")) {
					if (email_field.getText().length() >= 1) {
						email_field.setText(email_field.getText().substring(0, email_field.getText().length() - 1));
					} else if (email_field.getText().length() == 0) {
						email_field.setText("");
					}
				}
			}
		});

		this.rowThree = new JButton[thirdRow.length];
		x = 60;
		y = 340;
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
			this.emailFrame.getContentPane().add(rowThree[i]);
		}
	}

	/**
	 * Creates the window in the center
	 */

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.emailFrame.setLocation(dim.width / 2 - this.emailFrame.getSize().width / 2,
				dim.height / 2 - this.emailFrame.getSize().height / 2);
		this.emailFrame.setVisible(true);
	}

	/**
	 * Creates the next button for going to the next page which is insurance
	 * page
	 */
	public void nextButton() {
		Border border = new BevelBorder(BevelBorder.RAISED);
		JButton backButton = new JButton("NEXT");
		backButton.setBorder(border);
		backButton.setForeground(new Color(153, 190, 255));
		backButton.setBackground(Color.BLACK);
		backButton.setOpaque(true);
		backButton.setBorderPainted(false);
		;
		backButton.setBounds(350, 450, 75, 30);
		this.emailFrame.getContentPane().add(backButton);
		this.emailFrame.setVisible(true);
		backButton.addActionListener(new ActionListener() {
			JFrame emailFrame = originalFrame();

			/**
			 * See Java API
			 */
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("NEXT")) {
					String emaildb = new String();
					emaildb = email_field.getText();
					if (isValidEmailAddress(emaildb) || emaildb.isEmpty()) {
						/*
						 * ADDED INSURANCE PAGE
						 */
						emailFrame.setVisible(false);
						InsurancePage insurance = new InsurancePage(this.emailFrame, "Insurance Dev");
						try {
							insurance.initialize();
						} catch (IOException e2) {
							e2.printStackTrace();
						}
						insurance.initializeKeyboard();
						insurance.middlePostion();
						try {
							insurance.showCombobox();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					} else {
						/* UI ERROR MESSAGE FOR EMAIL VALIDATION */
						EmailPage.emailErrorWindow();
					}

				}
			}

		});
	}

	/**
	 * Creates the exit button
	 */

	public void exitButton() {
		JButton exitButton = new JButton("EXIT");
		Border border = new BevelBorder(BevelBorder.RAISED);
		exitButton.setForeground(new Color(153, 190, 255));
		exitButton.setBackground(Color.BLACK);
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(false);
		;
		exitButton.setBounds(270, 450, 75, 30);
		exitButton.setBorder(border);
		this.emailFrame.getContentPane().add(exitButton);
		this.emailFrame.setVisible(true);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("EXIT")) {
					System.exit(0);
				}
			}

		});
	}

	/**
	 * See Java API
	 */

	@Override
	public void actionPerformed(ActionEvent event) {
		value = ((JButton) event.getSource()).getText().toLowerCase();
		email_field.setText(email_field.getText().toLowerCase() + value);
	}

	/**
	 * Method for verifying correct email input with regular expression
	 * 
	 * @param email
	 *            Email address entered
	 * @return Boolean for correct match
	 */

	public static boolean isValidEmailAddress(String email) {
		String reg = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(reg);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * Creates error window for incorrect email input
	 */

	public static void emailErrorWindow() {
		JOptionPane.showMessageDialog(null, "Please enter a valid email.", "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Creates email frame
	 * 
	 * @return emailframe
	 */

	public JFrame originalFrame() {
		return this.emailFrame;
	}
}