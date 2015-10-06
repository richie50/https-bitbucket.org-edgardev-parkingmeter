import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;

public class InsurancePage extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private String name;
	private JLabel expLabel;
	private JButton nextButton;
	public InsurancePage(JFrame frame, String text) {
		this.mainFrame = frame;
		this.name = text;
	}

	public void prepareGUI() {
		mainFrame = new JFrame("Insurance");
		mainFrame.setSize(700, 600);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.getContentPane().setLayout(null);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		headerLabel = new JLabel("");
		headerLabel
		.setText("Please select your insurance company \n and your permit expiry from the list:");
		int styleHeader  = Font.BOLD | Font.ITALIC;
		headerLabel.setFont(new Font("Garamond" , styleHeader , 20));
		headerLabel.setBounds( 80, 30, 600 , 60);
		mainFrame.getContentPane().add(headerLabel);
		statusLabel = new JLabel("");
		expLabel = new JLabel("");
		nextButton = new JButton("NEXT");
		nextButton.setBounds( 350, 300 , 100 , 35);
		nextButton.addActionListener(this);
		mainFrame.getContentPane().add(nextButton);
		mainFrame.setVisible(true);
	}
	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		mainFrame.setLocation(dim.width / 2 - mainFrame.getSize().width
				/ 2, dim.height / 2 - mainFrame.getSize().height / 2);
		mainFrame.setVisible(true);
	}
	public void showComboboxDemo() throws IOException {
		expLabel.setText("Please enter the expiry (mm/yyyy):");
		final DefaultComboBoxModel<String> insName = new DefaultComboBoxModel<String>();
		File file = new File("companies.txt");
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line;
		while ((line = bufferedReader.readLine()) != null) {
			insName.addElement(line);
		}
		fileReader.close();
		JComboBox<String> inSelect = new JComboBox<String>(insName);
		inSelect.setSelectedIndex(0);
		inSelect.setPrototypeDisplayValue("XXXXXXXXXXXXXXXXXX");
		inSelect.setBounds(170, 100 , 350 , 30);
		JScrollPane inList = new JScrollPane(inSelect);
		mainFrame.getContentPane().add(inSelect);
		// adding expiry month
		final DefaultComboBoxModel<Integer> insExpM = new DefaultComboBoxModel<Integer>();

		for (int i = 1; i < 13; i++) {
			insExpM.addElement(i);
		}
		JComboBox<Integer> inEx = new JComboBox<Integer>(insExpM);
		inSelect.setSelectedIndex(0);
		inEx.setBounds(250 , 150 , 60 , 30);
		JScrollPane inExx = new JScrollPane(inEx);
		mainFrame.getContentPane().add(inEx);
		// add expiry year
		final DefaultComboBoxModel<Integer> insExpY = new DefaultComboBoxModel<Integer>();
		for (int i = 2015; i < 2021; i++) {
			insExpY.addElement(i);
		}
		JComboBox<Integer> inY = new JComboBox<Integer>(insExpY);
		inSelect.setSelectedIndex(0);
		inY.setBounds(350, 150 , 60 , 30);
		JScrollPane inExxY = new JScrollPane(inY);
		mainFrame.getContentPane().add(inY);
		JButton showButton = new JButton("SELECT");
		showButton.setBounds(250 , 300 , 100 , 35);
		showButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "";
				if (inSelect.getSelectedIndex() != -1) {
					data = "Insurance company selected: \n"
							+ inSelect.getItemAt(inSelect.getSelectedIndex())
							+ " (" + inEx.getItemAt(inEx.getSelectedIndex())
							+ "/" + inY.getItemAt(inY.getSelectedIndex()) + ")";
				}
				statusLabel.setBounds(100 , 180 , 500 , 70);
				statusLabel.setText(data);
				int style  = Font.BOLD | Font.ITALIC;
				statusLabel.setFont(new Font("Jokerman" , style , 15));
				statusLabel.setBackground(Color.GREEN);
			}
		});
		mainFrame.getContentPane().add(showButton);
		mainFrame.getContentPane().add(statusLabel);
		mainFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String val = ((JButton)event.getSource()).getActionCommand();
		System.out.println("INSURANCE PAGE . . . . . . " + val);
		this.mainFrame.setVisible(false);
		this.mainFrame = new JFrame("ALSMOST");
		this.mainFrame.setSize(700, 600);
		this.mainFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.mainFrame.setVisible(true);
	}
}