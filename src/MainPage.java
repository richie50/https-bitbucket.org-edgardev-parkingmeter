
/**
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.SoftBevelBorder;

public class MainPage extends JFrame implements ActionListener, MouseListener {
	private JFrame mainFrame;
	private String main_page_name;
	private JTextField currField;
	private JTextField sn_field;
	private JPasswordField pin_password_field;
	private String firstRow[] = { "1", "2", "3" };
	private String secondRow[] = { "4", "5", "6" };
	private String thirdRow[] = { "7", "8", "9" };
	private JButton one[];
	private JButton two[];
	private JButton three[];
	private JButton submitButton;
	private static final long serialVersionUID = 1L;

	/**
	 * Creates frame for the main page
	 * 
	 * @param text
	 * @param frame
	 */

	public MainPage(String text, JFrame frame) {
		this.mainFrame = frame;
		this.main_page_name = text;
	}

	/**
	 * Sets the text
	 * 
	 * @param txt
	 */

	public void setText(String txt) {
		this.main_page_name = txt;
	}

	/**
	 * Displays the main page
	 * 
	 * @throws IOException
	 *             Input output exception
	 */

	public void displayMainPage() throws IOException {
		this.mainFrame = new JFrame(this.main_page_name);
		this.mainFrame.setSize(700, 600);
		this.mainFrame.getContentPane().setBackground(Color.WHITE);
		this.mainFrame.getContentPane().setLayout(null);
		String image_path = "YorkLogo.gif";
		File path = new File(image_path);
		BufferedImage image = ImageIO.read(path);
		JLabel label = new JLabel(new ImageIcon(image));
		label.setBounds(330, 280, 500, 500);
		mainFrame.getContentPane().add(label);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width / 2,
				dim.height / 2 - mainFrame.getSize().height / 2);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}

	/**
	 * Displays the text fields of student and pin
	 */

	public void addTextFields() {

		JLabel StudentNumber, PIN;
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		StudentNumber = new JLabel("Student Number:");
		StudentNumber.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 20));
		StudentNumber.setBounds(250, 25, 200, 20);
		this.mainFrame.getContentPane().add(StudentNumber);
		this.sn_field = new JTextField(30);
		this.sn_field.setEditable(false);
		this.sn_field.setBackground(Color.LIGHT_GRAY);
		this.sn_field.setBorder(border);
		this.sn_field.setBounds(235, 50, 250, 30);
		this.mainFrame.getContentPane().add(sn_field);
		// added focus listener to tell which field is currently active
		this.sn_field.addFocusListener(new FocusListener() {

			/**
			 * Creates focus on current field
			 */

			public void focusGained(FocusEvent e) {
				currField = sn_field;
			}

			/**
			 * Added tooltip for focus
			 */

			public void focusLost(FocusEvent e) {
				// ADDED TOOLTIP
				JTextField field = (JTextField) e.getSource();
				String number = field.getText();
				if (number.isEmpty() || number.length() < 9 || number.length() > 9) {
					sn_field.setToolTipText("Your Student Number should be nine digits");
				}
			}
		});
		PIN = new JLabel("PIN:");
		PIN.setFont(new Font(Font.SANS_SERIF, Font.BOLD | Font.ITALIC, 20));
		PIN.setBounds(320, 110, 200, 20);
		this.mainFrame.getContentPane().add(PIN);
		this.pin_password_field = new JPasswordField(30);
		this.pin_password_field.setEditable(false);
		this.pin_password_field.setBackground(Color.LIGHT_GRAY);
		this.pin_password_field.setBorder(border);
		this.pin_password_field.setBounds(230, 150, 250, 30);
		this.mainFrame.getContentPane().add(pin_password_field);
		this.pin_password_field.addMouseListener(this);
		// added focus listener to tell which field is currently active
		this.pin_password_field.addFocusListener(new FocusListener() {

			/**
			 * Focus on pin field
			 */
			public void focusGained(FocusEvent e) {
				currField = pin_password_field;
			}

			/**
			 * Added tooltip on pin field
			 */

			public void focusLost(FocusEvent e) {
				// ADDED TOOLTIP
				JPasswordField field = (JPasswordField) e.getSource();
				char password[] = field.getPassword();
				if (password.length == 0 || password.length < 4 || password.length > 4) {
					pin_password_field.setToolTipText("Pin should be four digits");
				}
			}
		});
	}

	/**
	 * Adding numeric keyboard Styled to match rest of UI, black background with
	 * light blue font easier to use.
	 */

	public void addNumberButtons() {
		Border border = new BevelBorder(BevelBorder.RAISED);
		int x, y;
		this.one = new JButton[firstRow.length];
		x = 250;
		y = 250;
		for (int i = 0; i < firstRow.length; i++) {
			one[i] = new JButton(firstRow[i]);
			one[i].setBounds(x, y, 50, 40);
			one[i].setBorder(border);
			x += 60;
			one[i].addActionListener(this);
			one[i].setBackground(Color.BLACK);
			one[i].setForeground(new Color(153, 190, 255));
			one[i].setOpaque(true);
			one[i].setBorderPainted(false);
			this.mainFrame.getContentPane().add(one[i]);
		}
		this.two = new JButton[secondRow.length];
		x = 250;
		y = 300;
		for (int i = 0; i < secondRow.length; i++) {
			two[i] = new JButton(secondRow[i]);
			two[i].setBounds(x, y, 50, 40);
			two[i].setBorder(border);
			x += 60;
			two[i].addActionListener(this);
			two[i].setBackground(Color.BLACK);
			two[i].setForeground(new Color(153, 190, 255));
			two[i].setOpaque(true);
			two[i].setBorderPainted(false);
			this.mainFrame.getContentPane().add(two[i]);
		}
		x = 250;
		y = 350;
		this.three = new JButton[thirdRow.length];
		for (int i = 0; i < thirdRow.length; i++) {
			three[i] = new JButton(thirdRow[i]);
			three[i].setBounds(x, y, 50, 40);
			three[i].setBorder(border);
			x += 60;
			three[i].addActionListener(this);
			three[i].setBackground(Color.BLACK);
			three[i].setForeground(new Color(153, 190, 255));
			three[i].setOpaque(true);
			three[i].setBorderPainted(false);
			this.mainFrame.getContentPane().add(three[i]);
		}
		// make the zero button
		JButton zero = new JButton("0");
		zero.setBounds(310, 400, 50, 40);
		zero.setBorder(border);
		zero.addActionListener(this);
		zero.setBackground(Color.BLACK);
		zero.setForeground(new Color(153, 190, 255));
		zero.setOpaque(true);
		zero.setBorderPainted(false);
		this.mainFrame.getContentPane().add(zero);
	}

	/**
	 * Add the backspace image and button
	 */

	public void addClearButton() {
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		ImageIcon backSpace = new ImageIcon("backspace.png");
		Image image = backSpace.getImage();
		Image temp = image.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH);
		backSpace = new ImageIcon(temp);
		JButton clear = new JButton(backSpace);
		clear.setBackground(Color.BLACK);
		clear.setForeground(new Color(153, 190, 255));
		clear.setOpaque(true);
		clear.setBorderPainted(false);
		clear.setBounds(370, 400, 50, 40);
		clear.setBorder(border);
		this.mainFrame.getContentPane().add(clear);
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				// DEBUG
				if (e.getActionCommand().equals("")) {
					if (currField.getText().length() >= 1) {
						currField.setText(currField.getText().substring(0, currField.getText().length() - 1));
					} else if (currField.getText().length() == 0) {
						currField.setText("");
					}
				}
			}
		});
	}

	/**
	 * Adding the submit button to verify input from students database
	 * 
	 * @param text
	 *            Submit button
	 */

	public void addSubmitButtons(String text) {
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		submitButton = new JButton(text);
		submitButton.setBackground(Color.BLACK);
		submitButton.setForeground(new Color(153, 190, 255));
		submitButton.setOpaque(true);
		submitButton.setBorderPainted(false);
		submitButton.setBounds(350, 450, 80, 30);
		submitButton.setBorder(border);
		submitButton.addActionListener(this);
		this.mainFrame.getContentPane().add(submitButton);
	}

	/**
	 * Added the exit button
	 */

	public void exitButton() {
		Border border = new SoftBevelBorder(SoftBevelBorder.RAISED);
		JButton exitButton = new JButton("EXIT");
		exitButton.setBackground(Color.BLACK);
		exitButton.setForeground(new Color(153, 190, 255));
		exitButton.setOpaque(true);
		exitButton.setBorderPainted(false);
		exitButton.setBounds(250, 450, 80, 30);
		exitButton.setBorder(border);
		this.mainFrame.getContentPane().add(exitButton);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (e.getActionCommand().equals("EXIT")) {
					System.exit(0);
				}
			}

		});
		this.mainFrame.setResizable(false);
		;
		this.mainFrame.repaint();
	}

	/**
	 * 
	 * Refer to JAVA API
	 */

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {

		if (currField == null) {
			currField = sn_field;
		}
		if (this.sn_field.getText().toString().length() >= 9) {
			currField = pin_password_field;
		}

		String value = new String();
		if (e.getActionCommand().equals("NEXT")) {
			String studentdb = sn_field.getText();
			String pindb = pin_password_field.getText();
			/** CHANGE THE FILE PATH **/
			final Path FILE_PATH = Paths.get("students.txt");
			Optional<Person> matchingStudent = null;
			try {
				matchingStudent = Files.lines(FILE_PATH).map(line -> line.split(","))
						.map(commaVal -> new Person(commaVal))
						.filter(person -> person.getStudentNumber().equals(studentdb) && person.getPin().equals(pindb)
								&& (person.getStatus().equals("ok") || person.getStatus().equals("arrears")))
						.findFirst();
			} catch (IOException e1) {

				e1.printStackTrace();
			}
			if (matchingStudent.isPresent())
				try {
					{
						Person matchingPerson = matchingStudent.get();
						/* Code used to Debug */
						// System.out.println("Hello " +
						// matchingPerson.getFirstName().toUpperCase() + " "
						// + matchingPerson.getLastName().toUpperCase());
						// System.out.println("\tSTUDENT STATUS > > > > >" +
						// matchingPerson.getStatus());

						// add valid info to the file
						final String newLine = System.getProperty("line.separator");
						File file = new File("Ticket_database.txt");
						PrintWriter writer = null;
						try {
							if (!file.exists()) {
								file.createNewFile();
							}
							writer = new PrintWriter(new FileOutputStream(file));// overwrites
																					// the
																					// file
																					// each
																					// time
							writer.write(matchingPerson.getStudentNumber() + newLine + matchingPerson.getFirstName()
									+ " " + matchingPerson.getLastName() + " \n" + matchingPerson.getStatus());
						} catch (IOException e1) {
						} finally {
							if (writer != null) {
								writer.flush();
								writer.close();
							}
						}
						// we display the email page
						this.mainFrame.setVisible(false);
						EmailPage email = new EmailPage(this.mainFrame, "Email");
						try {
							email.diplayEmailPage();
						} catch (IOException e1) {
						}
						email.middlePostion();
						email.addEmailLabelAndTextFeild();
						email.displayKeyboard();
						email.nextButton();
						email.exitButton();
					}
				} catch (Exception e1) {
				}
			else {
				studentErrorWindow();
			}
			// writing the numbers on the fields to student field and pin field,
			// using focus listeners we know
			// which one is the current field.
		} else if (e.getActionCommand().equals("1")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("2")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("3")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("4")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("5")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("6")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("7")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("8")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("9")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("0")) {
			value = ((JButton) e.getSource()).getText();
			currField.setText(currField.getText() + value);
		}
	}

	/**
	 * Mouse clicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	/**
	 * Mouse entered
	 */

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	/**
	 * Mouse exited
	 */

	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Mouse pressed
	 */

	@Override
	public void mousePressed(MouseEvent e) {
	}

	/**
	 * Mouse released
	 */

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Returns the current field
	 * 
	 * @return currField Current field
	 */

	public JTextField getCurrentField() {
		return this.currField;
	}

	/**
	 * Creates an error window every time false information is input
	 */

	public void studentErrorWindow() {
		JOptionPane.showMessageDialog(null, "No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
		JTextField reset = getCurrentField();
		reset.setText("");
	}
}