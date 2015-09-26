/*
 * @author Richmond F, Edgar Z, Daniyal J
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class EmailPage implements ActionListener {
	private JFrame emailFrame;
	private String name;
	private JLabel email;
	private JPanel mainEmailPanel;
	private JPanel emailPanel;
	private JPanel keyboardPanel;
	private JTextField email_field;
	private JButton rowOne[];
	private JButton rowTwo[];
	private JButton rowThree[];
	private JButton numberRow[];
	private JButton clearButton;
	private JButton emailButtons[];
	private String emailRow[] = {"@my.yorku.ca", "@gmail.com" , "@hotmail.com", "@yahoo.ca", "@live.com"};
	private String 	digit[] = {"1" ,"2" ,"3","4","5" ,"6" ,"7","8" ,"9", "0"};
	private String firstRow[] = {"Q" ,"W" , "E" ,"R","T", "Y" , "U" , "I" , "O" , "P" };
	private String secondRow[] = {"A" ,"S" , "D", "F" , "G" , "H" , "J" , "K" , "L"};
	private String thirdRow[] = {"Z" ,"X" , "C", "V" , "B" , "N" , "M" ,"_" ,"@"};
	private String value;
	private JPanel buttonPanel;
	public EmailPage(JFrame frame , String text){
		this.emailFrame = frame;
		this.name = text;
	}
	public void diplayEmailPage(){
		this.emailFrame = new JFrame(this.name);
		this.mainEmailPanel = new JPanel();
		this.emailPanel = new JPanel();
		this.keyboardPanel = new JPanel();
		this.buttonPanel = new JPanel();
		this.keyboardPanel.setLayout(null);
		this.emailPanel.setLayout(null);
		this.mainEmailPanel.setLayout(new BoxLayout(mainEmailPanel, BoxLayout.Y_AXIS));
		this.emailFrame.setSize(750, 500);
		this.emailFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.emailFrame.setVisible(true);
	
	}
	public void addEmailLabelAndTextFeild(){
		this.email = new JLabel("EMAIL:");
		this.email.setBounds(250 ,20, 200, 50);
		this.email_field = new JTextField(30);
		this.email_field.setHorizontalAlignment(JTextField.LEFT);
		this.email_field.setBounds(250, 60, 300 , 30);
		this.emailPanel.add(email);
		this.emailPanel.add(email_field);
		this.mainEmailPanel.add(emailPanel);
		this.emailFrame.add(mainEmailPanel);
	}
	public void displayKeyboard(){
		 int x , y;
		 //Needs action preformed to be able to output common preset emails
		 // TODO implement action preformed for EMAIL row.
		 this.emailButtons = new JButton[emailRow.length];
		 x = 120;
		 y = 180;
		 for(int i = 0 ; i < emailRow.length ; i++){
			 JButton temp = new JButton(emailRow[i]);
			 temp.setBounds(x, y, 100, 40);
			 x+= 100;
			 temp.addActionListener(this);
			 this.emailButtons[i] = temp;
			 this.keyboardPanel.add(emailButtons[i]);
		 }
		 this.numberRow = new JButton[digit.length];
		 x = 80;
		 y = 0;
		 for(int i = 0 ; i < digit.length ; i++){
			 JButton temp = new JButton(digit[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.numberRow[i] = temp;
			 this.keyboardPanel.add(numberRow[i]);
		 }
		 this.rowOne = new JButton[firstRow.length];
		 x = 80;
		 y = 45;
		 for(int i = 0 ; i < firstRow.length ; i++){
			 JButton temp = new JButton(firstRow[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.rowOne[i] = temp;
			 this.keyboardPanel.add(rowOne[i]);
		 }
		 this.rowTwo = new JButton[secondRow.length];
		 x = 80;
		 y = 90;
		 for(int i = 0 ; i < secondRow.length ; i++){
			 JButton temp = new JButton(secondRow[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.rowTwo[i] = temp;
			 this.keyboardPanel.add(rowTwo[i]);
		 }
		//create the clear button
		 ImageIcon backSPace = new ImageIcon("backspace.png");
		 Image image = backSPace.getImage();
		 Image temporary = image.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
		 backSPace = new ImageIcon(temporary);
		 this.clearButton = new JButton(backSPace);
		 this.clearButton.setBounds(x , y , 50 , 85);
		 this.keyboardPanel.add(clearButton);
		 clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO DEBUG
				System.out.println("WHEN CLEAR BUTTON IS PRESSED . . . . . ");
				//
				if(e.getActionCommand().equals("")){
					if(email_field.getText().length() >= 1){
						email_field.setText(email_field.getText().substring(0, email_field.getText().length() - 1));
					}
					else{
						System.out.println("NOTHING TO DELETE");
					}
				}
			}
		});
		 
		 this.rowThree = new JButton[thirdRow.length];
		 x = 80;
		 y = 135;
		 for(int i = 0 ; i < thirdRow.length ; i++){
			 JButton temp = new JButton(thirdRow[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.rowThree[i] = temp;
			 this.keyboardPanel.add(rowThree[i]);	
		 }
		 
		 this.mainEmailPanel.add(keyboardPanel);
		 this.emailFrame.add(mainEmailPanel);
	}
	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.emailFrame.setLocation(dim.width / 2
				- this.emailFrame.getSize().width / 2, dim.height / 2
				- this.emailFrame.getSize().height / 2);
		this.emailFrame.setVisible(true);
	}
	public int backButton() {
		JButton backButton = new JButton("NEXT");
		buttonPanel.add(backButton);
		this.emailFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.emailFrame.setVisible(true);
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + " ---- " + e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("NEXT")) {
					//System.exit(0);
					System.out.println("****************");
				}else{
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
		return 0;
	}
	public void exitButton() {
		JButton exitButton = new JButton("EXIT");
		buttonPanel.add(exitButton);
		this.emailFrame.add(buttonPanel, BorderLayout.SOUTH);
		this.emailFrame.setVisible(true);
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
				}else{
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		for(int i = 48 ; i < 97 ; i++){
			if(event.getActionCommand().equals(Character.toString((char) i))){
				value  = ((JButton)event.getSource()).getText().toLowerCase();
				//DEBUG
				System.out.print("KEY => ");
				System.out.println(value + " WAS PRESSED IN EMAILPAGE");
				//
				email_field.setText(email_field.getText().toLowerCase() + value);
			}		
		}	
	}
}