import java.awt.Dimension;
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
	private String firstRow[] = {"Q" ,"W" , "E" ,"R","T", "Y" , "U" , "I" , "O" , "P" };
	private String secondRow[] = {"A" ,"S" , "D", "F" , "G" , "H" , "J" , "K" , "L"};
	private String thirdRow[] = {"Z" ,"X" , "C", "V" , "B" , "N" , "M" };
	public EmailPage(JFrame frame , String text){
		this.emailFrame = frame;
		this.name = text;
	}
	public void diplayEmailPage(){
		this.emailFrame = new JFrame(this.name);
		this.mainEmailPanel = new JPanel();
		this.emailPanel = new JPanel();
		this.keyboardPanel = new JPanel();
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
		 this.rowOne = new JButton[firstRow.length];
		 x = 80;
		 y = 5;
		 for(int i = 0 ; i < firstRow.length ; i++){
			 JButton temp = new JButton(firstRow[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.rowOne[i] = temp;
			 this.keyboardPanel.add(rowOne[i]);
		 }
		 this.rowTwo = new JButton[secondRow.length];
		 x = 120;
		 y = 50;
		 for(int i = 0 ; i < secondRow.length ; i++){
			 JButton temp = new JButton(secondRow[i]);
			 temp.setBounds(x, y, 50, 40);
			 x+= 60;
			 temp.addActionListener(this);
			 this.rowTwo[i] = temp;
			 this.keyboardPanel.add(rowTwo[i]);
		 }
		 this.rowThree = new JButton[thirdRow.length];
		 x = 180;
		 y = 95;
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
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}