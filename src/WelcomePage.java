
/*
 * @author Richmond F, Edgar Z, Daniyal J
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.Timer;
import javax.swing.*;

public class WelcomePage implements ActionListener {
	private JFrame welcomeFrame;
	private JFrame mainFrame;
	private String welcomeName;
	private JPanel welcomePanel;
	private JPanel welcomeButton;
	private String value;
	private String welcomeText;

	public WelcomePage(JFrame frame, String text) {
		this.welcomeFrame = frame;
		this.welcomeName = text;
	}

	public void displayWelcomePanel() {

		this.welcomeFrame = new JFrame(this.welcomeName);
		this.welcomePanel = new JPanel();
		this.welcomePanel.setLayout(new BoxLayout(this.welcomePanel, BoxLayout.Y_AXIS));
		this.welcomeButton = new JPanel();
		this.welcomeFrame.setSize(750, 500);
		welcomeFrame.add(new welcomeClockPanel());
		this.welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.welcomeFrame.setVisible(true);

	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.welcomeFrame.setLocation(dim.width / 2 - this.welcomeFrame.getSize().width / 2,
				dim.height / 2 - this.welcomeFrame.getSize().height / 2);
		this.welcomeFrame.setVisible(true);
	}

	public int welcomeButton() {
		JButton continueButton = new JButton("Continue");
		welcomeButton.add(continueButton);
		this.welcomeFrame.add(welcomeButton, BorderLayout.SOUTH);
		this.welcomeFrame.setVisible(false);
		// this.mainFrame.setVisible(true);
		continueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// DEBUG
				System.out.println(e.getActionCommand() + "\n >>" + e.getSource());
				System.out.println(e.paramString());
				// DEBUG
				if (e.getActionCommand().equals("Continue")) {
					// System.exit(0);
					MainPage mp = new MainPage("Parking Dev", mainFrame);
					try {
						mp.displayMainPage();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.out.println("&&&&&&&&&&CONTINUE&&&&&&");
				} else {
					System.out.println("SOMETHING WEIRD HAPPEN !!!!!!!!!!!!");
				}

			}

		});
		this.welcomeFrame.setVisible(false);
		return 0;
	}

	public void exitButton() {
		JButton exitButton = new JButton("EXIT");
		welcomeButton.add(exitButton);
		this.welcomeFrame.add(welcomeButton, BorderLayout.SOUTH);
		this.welcomeFrame.setVisible(true);
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
		System.out.print("KEY => ");
		System.out.println(value + " WAS PRESSED IN EMAILPAGE");
	}

	public class welcomeClockPanel extends JPanel {

		private JLabel timer;
		private JLabel welcomeLabel;

		public welcomeClockPanel() {
			setLayout(new BorderLayout());
			timer = new JLabel();
			welcomeLabel = new JLabel();
			welcomeLabel.setVerticalAlignment(JLabel.CENTER);
			welcomeLabel.setFont(UIManager.getFont("Label.font").deriveFont(Font.ROMAN_BASELINE, 16f));
			timer.setVerticalAlignment(JLabel.BOTTOM);
			timer.setHorizontalAlignment(JLabel.RIGHT);
			timer.setFont(UIManager.getFont("Label.font").deriveFont(Font.ROMAN_BASELINE, 16f));
			tickTock();
			message();
			add(timer);
			add(welcomeLabel);
			Timer clock = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tickTock();
					// message();
				}
			});
			clock.setRepeats(true);
			clock.setCoalesce(true);
			clock.setInitialDelay(0);
			clock.start();
		}

		public void message() {
			welcomeLabel.setText("Welcome to York University's Parking System");
		}

		public void tickTock() {
			timer.setText("Current Date/Time: " + DateFormat.getDateTimeInstance().format(new Date()));
		}
	}
}
