import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainPage implements ActionListener, MouseListener {
	private JFrame mainFrame;
	private JPanel mainPanel;
	private String main_page_name;
	private JLabel StudentNumber;
	private JLabel PIN;
	private JPanel panel;
	private JPanel numberPanel;
	private JPanel buttonPanel;
	private JPanel iconPanel;
	private JTextField sn_field;
	private JTextField pin_field;
	private JButton one, two, three, four, five, six, seven, eight, nine, zero;
	private JButton submitButton;
	private int checker;
	private static final long serialVersionUID = 1L;

	public MainPage(String text, JFrame frame) {
		this.mainFrame = frame;
		this.main_page_name = text;
	}

	public void setText(String txt) {
		this.main_page_name = txt;
	}

	public void displayMainPage() throws IOException {
		this.mainFrame = new JFrame(this.main_page_name);
		this.mainPanel = new JPanel();
		this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		this.panel = new JPanel();
		this.numberPanel = new JPanel();
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
		this.StudentNumber = new JLabel("Student Number:");
		this.sn_field = new JTextField(30);
		this.sn_field.setHorizontalAlignment(JTextField.LEFT);
		this.sn_field.setBounds(250, 125, 250, 30);
		this.StudentNumber.setFont(new Font("monospace", Font.PLAIN, 20));
		this.sn_field.addMouseListener(this);
		this.PIN = new JLabel("PIN:");
		this.pin_field = new JTextField(30);
		this.pin_field.setHorizontalAlignment(JTextField.LEFT);
		this.PIN.setFont(new Font("monospace", Font.PLAIN, 20));
		this.pin_field.setBounds(250, 190, 250, 30);
		this.pin_field.addMouseListener(this);
		// this.mainFrame.setVisible(true);
	}

	public void addIcon() {
		this.iconPanel = new JPanel();
		// adds a logo to the frame
		ImageIcon image = new ImageIcon("background.gif");
		JLabel backgroundImage = new JLabel(image);
		backgroundImage.setBounds(5, 5, 10, 10);
		this.iconPanel.add(backgroundImage);
		this.mainFrame.add(iconPanel, BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
	}

	public void addPanel() {
		// add the labels to the panel
		this.StudentNumber.setBounds(290, 100, 200, 20);
		this.PIN.setBounds(340, 160, 200, 20);
		this.panel.setLayout(null);
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
		this.one = new JButton("1");
		this.one.setBounds(110, 0, 40, 30);
		//this.one.addActionListener(this);
		this.one.addActionListener(new PinTextFieldListener());
		this.one.addActionListener(new StudentNumberListerner());
		this.numberPanel.add(one);
		// this.mainPanel.add(numberPanel);
		// two
		this.two = new JButton("2");
		this.two.setBounds(120, 0, 40, 30);
		this.two.addActionListener(this);
		this.numberPanel.add(two);
		// this.mainPanel.add(numberPanel);
		// three
		this.three = new JButton("3");
		this.three.setBounds(130, 0, 40, 30);
		this.three.addActionListener(this);
		
		this.numberPanel.add(three);
		// this.mainPanel.add(numberPanel);
		// four
		this.four = new JButton("4");
		this.four.setBounds(110, 50, 40 , 30);
		this.four.addActionListener(this);
		this.numberPanel.add(four);
		// this.mainPanel.add(numberPanel);
		// five
		this.five = new JButton("5");
		this.five.setBounds(120, 50, 40, 30);
		this.five.addActionListener(this);
		this.numberPanel.add(five);
		// this.mainPanel.add(numberPanel);
		// six
		this.six = new JButton("6");
		this.six.setBounds(130, 50, 40, 30);
		this.six.addActionListener(this);
		this.numberPanel.add(six);

		this.seven = new JButton("7");
		this.seven.setBounds(130, 30, 40, 30);
		this.seven.addActionListener(this);
		this.numberPanel.add(seven);

		this.eight = new JButton("8");
		this.eight.setBounds(130, 30, 40, 30);
		this.eight.addActionListener(this);
		this.numberPanel.add(eight);

		this.nine = new JButton("9");
		this.nine.setBounds(130, 30, 40, 30);
		this.nine.addActionListener(this);
		this.numberPanel.add(nine);

		this.mainPanel.add(numberPanel);
		this.mainFrame.add(mainPanel);
	}
	public void addClearButton(){
		ImageIcon backSpace = new ImageIcon("backspace.png");
		Image image = backSpace.getImage();
		Image temp = image.getScaledInstance(30, 20, java.awt.Image.SCALE_SMOOTH);
		backSpace = new ImageIcon(temp);
		JButton clear = new JButton(backSpace);
		clear.setSize(10, 5);
		buttonPanel.add(clear);
		this.mainFrame.add(buttonPanel , BorderLayout.SOUTH);
		this.mainFrame.setVisible(true);
		clear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getActionCommand() + " ---- "
						+ e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if(e.getActionCommand().equals("")){
					sn_field.setText("");
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
		// TODO Auto-generated method stub
		System.out.println("--------DEBUG FOR SUBMIT BUTTON-------------");
		System.out.println(e.getActionCommand());
		System.out.println(e.getID() + " and " + e.getSource());
		if (e.getActionCommand().equals("NEXT")) {
			// check to see if input is valid
			this.mainFrame = new JFrame("EDGAR IS A FAGGOT");
			mainFrame.setSize(700, 600);
			mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainFrame.setVisible(true);
		}
		
	}
	class StudentNumberListerner implements ActionListener{
		String value = new String();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 if (e.getActionCommand().equals("1")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("2")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("3")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("4")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("5")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("6")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("7")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("8")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			} else if (e.getActionCommand().equals("9")) {
				value = ((JButton) e.getSource()).getText();
				System.out.println(value);
				sn_field.setText(sn_field.getText() + value);
			}
		}
		
	}
	class PinTextFieldListener implements ActionListener{
		private String pinValue = new String();
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.out.println(e.getActionCommand());
			System.out.println(e.getID() + " and " + e.getSource());
			if (e.getActionCommand().equals("1")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("2")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("3")) {
				pinValue= ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("4")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("5")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("6")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("7")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("8")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			} else if (e.getActionCommand().equals("9")) {
				pinValue = ((JButton) e.getSource()).getText();
				System.out.println(pinValue);
				pin_field.setText(pin_field.getText() + pinValue);
			}
		}
	} //end of inner class Listerner
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
}
