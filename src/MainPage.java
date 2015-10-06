/*
 * @author Richmond F, Edgar Z, Daniyal J
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;

//import sun.swing.SwingAccessor.JTextComponentAccessor;

public class MainPage implements ActionListener, MouseListener {
	private JFrame mainFrame;
	private JPanel mainPanel;
	private String main_page_name;
	private JLabel StudentNumber;
	private JLabel PIN;
	private JTextField currField;
	private JPanel panel;
	private JPanel numberPanel;
	private JPanel buttonPanel;
	private JPanel iconPanel;
	private JTextField sn_field;
	private JTextField pin_field;
	private String firstRow[] = { "1", "2", "3" };
	private String secondRow[] = { "4", "5", "6" };
	private String thirdRow[] = { "7", "8", "9" };
	private JButton one[];
	private JButton two[];
	private JButton three[];
	private JButton submitButton;
	private static final long serialVersionUID = 1L;

	public MainPage(String text, JFrame frame) {
		this.mainFrame = frame;
		this.main_page_name = text;
	}

	public void setText(String txt) {
		this.main_page_name = txt;
	}
	
	public void displayMainPage() throws IOException {
		//this.mainFrame.setVisible(false);
		this.mainFrame = new JFrame(this.main_page_name);
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.mainPanel.setMaximumSize(this.mainPanel.getMinimumSize());
		this.panel = new JPanel();
		this.numberPanel = new JPanel();
		this.numberPanel.setLayout(null);
		this.numberPanel.setLayout(null);
		this.buttonPanel = new JPanel();
		this.mainFrame.setSize(700, 600);
		this.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.mainFrame.setLocation(dim.width / 2
				- this.mainFrame.getSize().width / 2, dim.height / 2
				- this.mainFrame.getSize().height / 2);
		this.mainFrame.setVisible(true);
	}

	public void addTextFields() {
		// needs fix to determine if Student or PIN
		this.StudentNumber = new JLabel("Student Number:");
		this.sn_field = new JTextField(30);
		// this.sn_field.setHorizontalAlignment(JTextField.LEFT);
		this.sn_field.setEditable(true);
		this.sn_field.setBounds(250, 125, 250, 30);
		this.StudentNumber.setFont(new Font("monospace", Font.PLAIN, 20));
		this.sn_field.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				currField = sn_field;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		this.PIN = new JLabel("PIN:");
		this.pin_field = new JTextField(30);
		this.pin_field.setHorizontalAlignment(JTextField.LEFT);
		this.pin_field.setEditable(true);
		this.PIN.setFont(new Font("monospace", Font.PLAIN, 20));
		this.pin_field.setBounds(250, 190, 250, 30);
		this.pin_field.addMouseListener(this);
		this.pin_field.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				currField = pin_field;
			}

			@Override
			public void focusLost(FocusEvent e) {
			}
		});
		// this.mainFrame.setVisible(true);
	}

	public void addIcon() {
		this.iconPanel = new JPanel();
		// adds a logo to the frame
		ImageIcon image = new ImageIcon("yorku.gif");
		JLabel backgroundImage = new JLabel(image);
		backgroundImage.setBounds(5, 5, 10, 10);
		this.iconPanel.add(backgroundImage);
		this.mainFrame.add(iconPanel, BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
	}

	public void addInputPanel() {
		// add the labels to the panel
		this.panel.setLayout(null);
		this.StudentNumber.setBounds(250, 100, 200, 20);
		this.PIN.setBounds(250, 170, 200, 20);
		this.panel.add(StudentNumber);
		this.panel.add(PIN);
		// add the textfields
		this.panel.add(sn_field);
		this.panel.add(pin_field);
		this.mainPanel.add(panel);
		this.mainFrame.add(mainPanel);
	}

	public void addSubmitButtons(String text) {
		submitButton = new JButton(text);
		this.buttonPanel.add(submitButton);
		submitButton.addActionListener(this);
		this.mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
	}

	public void addNumberButtons() {
		int x, y;
		this.one = new JButton[firstRow.length];
		x = 280;
		y = 50;
		for (int i = 0; i < firstRow.length; i++) {
			JButton temp = new JButton(firstRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.one[i] = temp;
			this.numberPanel.add(one[i]);
		}
		this.two = new JButton[secondRow.length];
		x = 280;
		y = 100;
		for (int i = 0; i < secondRow.length; i++) {
			JButton temp = new JButton(secondRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.two[i] = temp;
			this.numberPanel.add(two[i]);
		}
		x = 280;
		y = 150;
		this.three = new JButton[thirdRow.length];
		for (int i = 0; i < thirdRow.length; i++) {
			JButton temp = new JButton(thirdRow[i]);
			temp.setBounds(x, y, 50, 40);
			x += 60;
			temp.addActionListener(this);
			this.three[i] = temp;
			this.numberPanel.add(three[i]);
		}
		// make the zero button
		JButton zero = new JButton("0");
		zero.setBounds(340, 200, 50, 40);
		zero.addActionListener(this);
		this.numberPanel.add(zero);

		this.mainPanel.add(numberPanel);
		this.mainFrame.add(mainPanel);
	}

	public void addClearButton() {
		ImageIcon backSpace = new ImageIcon("backspace.png");
		Image image = backSpace.getImage();
		Image temp = image.getScaledInstance(30, 20,
				java.awt.Image.SCALE_SMOOTH);
		backSpace = new ImageIcon(temp);
		JButton clear = new JButton(backSpace);
		clear.setSize(20, 10);
		buttonPanel.add(clear);
		this.mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
		// init to student Number Field by default;
		clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getActionCommand() + " ---- "
						+ e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("")) {
					if (currField.getText().length() >= 1) {
						currField.setText(currField.getText().substring(0,
								currField.getText().length() - 1));
					} else {
						System.out.println("NOTHING TO DELETE");
					}
				}
			}
		});
	}

	public void exitButton() {
		JButton exitButton = new JButton("EXIT");
		buttonPanel.add(exitButton);
		this.mainFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + " ---- "
						+ e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("EXIT")) {
					System.exit(0);
				}
			}

		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (currField == null) {
			currField = sn_field;
		}
		if (this.sn_field.getText().toString().length() >= 9) {
			currField = pin_field;
		}
		if (this.pin_field.getText().toString().length() >= 4) {
			this.pin_field.setText(this.pin_field.getText().substring(0, 4));
		}
		String value = new String();
		System.out.println("--------DEBUG FOR SUBMIT BUTTON-------------");
		System.out.println(e.getActionCommand());
		System.out.println(e.getID() + " and " + e.getSource());
		if (e.getActionCommand().equals("NEXT")) {
			String studentdb = sn_field.getText();
			String pindb = pin_field.getText();
			/** CHANGE THE FILE PATH **/
			final Path FILE_PATH = Paths
					.get("student.txt");
			Optional<Person> matchingStudent = null;
			try {
				matchingStudent = Files
						.lines(FILE_PATH)
						.map(line -> line.split(","))
						.map(commaVal -> new Person(commaVal))
						.filter(person -> person.getStudentNumber().equals(
								studentdb)
								&& person.getPin().equals(pindb) && (person.getStatus().equals("ok") 
								|| person.getStatus().equals("arrears"))).findFirst();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (matchingStudent.isPresent()) {
				Person matchingPerson = matchingStudent.get();
				System.out.println("Hello "
						+ matchingPerson.getFirstName().toUpperCase() + " "
						+ matchingPerson.getLastName().toUpperCase());
				System.out.println("\tSTUDENT STATUS > > > > >" + matchingPerson.getStatus());
				//add valid info to the file
				final String newLine = System.getProperty("line.separator");
				File file = new File("Ticket_database.txt");
				PrintWriter writer = null;
				try {
					if(!file.exists()){
						file.createNewFile();
					}
					writer = new PrintWriter(new FileOutputStream(file));//overwrites the file each time
					writer.write(matchingPerson.getStudentNumber() + newLine 
							+ matchingPerson.getFirstName() + " " + matchingPerson.getLastName() + " " +
							matchingPerson.getStatus());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally{
					if(writer != null){
						writer.flush();
						writer.close();
					}
				}
				// we display the email page
				this.mainPanel.setVisible(true);
				this.mainFrame.setVisible(false);
				EmailPage email = new EmailPage(this.mainFrame, "Email");
				email.diplayEmailPage();
				email.middlePostion();
				email.addEmailLabelAndTextFeild();
				email.displayKeyboard();
				email.nextButton();
				email.backButton();
				email.exitButton();
			} else {
				MainPage.studentErrorWindow();
				System.out.println("No matching record found".toUpperCase());
			}
			
		} else if (e.getActionCommand().equals("1")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("2")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("3")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("4")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("5")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("6")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("7")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("8")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("9")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		} else if (e.getActionCommand().equals("0")) {
			value = ((JButton) e.getSource()).getText();
			System.out.println(value);
			currField.setText(currField.getText() + value);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getID());
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getID());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	public static void studentErrorWindow() {
		JOptionPane.showMessageDialog(null, "No matching record found.", "Error", JOptionPane.ERROR_MESSAGE);
	}
}
