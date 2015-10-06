/*
 * @author Richmond F, Edgar Z, Daniyal J
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomePage extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static JFrame welcomeFrame;
	private static String welcomeName;
	private static JPanel welcomePanel;
	private JButton welcomeButton;
	private String value;
	private JProgressBar bar;
	private JLabel welcomeLabel;
	private static final long serialVersionUID = 1L;

	static class welcomeThread extends Thread {
		private static int DELAY = 80;
		JProgressBar progressBar;

		public welcomeThread(JProgressBar bar) {
			progressBar = bar;
		}

		public void run() {
			int max = progressBar.getMaximum();
			int min = progressBar.getMinimum();
			Runnable runner = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					int value = progressBar.getValue();
					progressBar.setValue(value + 1);
				}
			};
			for (int i = min; i < max; i++) {
				try {
					EventQueue.invokeAndWait(runner);
					// now we sleep
					Thread.sleep(DELAY);
					if (i == max - 1) {
						welcomeFrame.setVisible(false);
						System.out.println("RENDERING MAINPAGE . . . . . . . ");
						MainPage display = new MainPage(
								"PARKING KIOSK DEV ENV", welcomeFrame);
						display.displayMainPage();
						display.middlePostion();

						display.addTextFields();
						display.addInputPanel();
						display.addNumberButtons();

						display.addSubmitButtons("NEXT");
						display.exitButton();
						display.addClearButton();
					}
				} catch (InterruptedException ex1) {

				} catch (InvocationTargetException ex2) {

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}// end of static class

	public WelcomePage(String title, JFrame frame) {
		welcomeName = title;
		welcomeFrame = frame;
	}

	public void displayWelcomeMessage() {

	}

	public void displayWelcomePanel() throws IOException{
		welcomeFrame = new JFrame(welcomeName);
		welcomePanel = new JPanel();
		//welcomeFrame.add(new JLabel(new ImageIcon(ImageIO.read(new File("C:\\Users\\RichMond\\workspace\\UI\\src\\yorku.gif")))));
		System.out.println(welcomeFrame.getContentPane());
		welcomeFrame.setSize(700, 600);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void welcomePageRunner() throws IOException {
		this.bar = new JProgressBar(0, 50);
		this.bar.setStringPainted(false);
		Random rnd = new Random();
		float red = rnd.nextFloat();
		float blue = rnd.nextFloat();
		float green = rnd.nextFloat();
		this.bar.setForeground(new Color(red , blue , green));
		this.welcomeButton = new JButton("PRESS HERE TO CONITNUE");
		this.welcomeButton.addActionListener(this);
		welcomeFrame.add(bar, BorderLayout.NORTH);
		welcomeFrame.add(welcomeButton, BorderLayout.SOUTH);
		this.welcomeLabel = new JLabel("Welcome To York University's Automated Parking System");
		welcomeLabel.setFont(new Font("SANS_SERIF",Font.BOLD, 18));
        String image_path = "yorku.gif";
        File path = new File(image_path);
        BufferedImage image = ImageIO.read(path);
        JLabel label = new JLabel(new ImageIcon(image));
		welcomeLabel.setBounds(100, 180, 600, 200);
		label.setBounds(100, -150, 500, 500);
		JLabel time = new JLabel("Current Date/Time: " + DateFormat.getDateTimeInstance().format(new Date()));
		time.setVerticalAlignment(JLabel.BOTTOM);
		time.setFont(new Font("MONOSPACED",Font.ITALIC, 16));
		time.setHorizontalAlignment(JLabel.RIGHT);
		welcomeFrame.add(welcomeLabel);
		welcomeFrame.add(label);
		welcomeFrame.add(time);
		//welcomeFrame.add(new welcomeClockPanel());
		// this.welcomeFrame.add(welcomePanel);
		welcomeFrame.setVisible(true);
	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		welcomeFrame.setLocation(dim.width / 2 - welcomeFrame.getSize().width
				/ 2, dim.height / 2 - welcomeFrame.getSize().height / 2);
		welcomeFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.welcomeButton.setEnabled(true);
		Thread stepper = new welcomeThread(bar);
		stepper.start();
		if (stepper.isAlive()) {
			if (stepper.isAlive()) {
				System.out.println("THREAD IS NOT DONE");
				System.out.println(stepper.getId());
				System.out.println(stepper.getPriority());
				System.out.println(stepper.getState());
				// System.out.println(stepper.activeCount());
			} else {
				//
			}
		}
	}
}
