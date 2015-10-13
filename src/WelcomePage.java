
/*
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
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
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

public class WelcomePage extends JFrame implements ActionListener {

	private static JFrame welcomeFrame = null;
	private static String welcomeName;
	private JButton welcomeButton;
	private JProgressBar bar;
	private static final long serialVersionUID = 1L;

	static class welcomeThread extends Thread {
		private static int DELAY = 40;
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
						welcomeFrame.dispose();
						MainPage display = new MainPage("York University Parking System", welcomeFrame);
						display.displayMainPage();
						display.addTextFields();
						display.addNumberButtons();
						display.addClearButton();
						display.addSubmitButtons("NEXT");
						display.exitButton();
					}
				} catch (InterruptedException ex1) {

				} catch (InvocationTargetException ex2) {

				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		}
	}// end of static class

	public WelcomePage(String title, JFrame frame) {
		welcomeName = title;
		welcomeFrame = frame;

	}

	public class displayWelcomeMessage extends JLabel {

		private static final long serialVersionUID = 1L;
		final String text[] = { "Welcome To", "York Univeristy's", "Automated Parking System" };
		int index = 0;
		int startingPoint = 10;
		final int delay = 1500;

		displayWelcomeMessage() {
			ActionListener counter = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					repaint();

					index++;
				}
			};
			new Timer(delay, counter).start(); // runs animation
		}

		@Override
		public void paintComponent(Graphics graphics) {

			if (index < text.length) {
				graphics.drawString(text[index], startingPoint, 20);

			}
		}
	} // end of animation class

	public void displayWelcomePanel() throws IOException {
		welcomeFrame = new JFrame(welcomeName);
		new JPanel();

		displayWelcomeMessage welcome = new displayWelcomeMessage();
		welcome.setBounds(260, 300, 400, 400);
		welcome.setFont(new Font("SANS_SERIF", Font.BOLD | Font.ITALIC, 20));
		welcomeFrame.getContentPane().add(welcome);
		welcome.setVisible(true);
		System.out.println(welcomeFrame.getTitle());
		welcomeFrame.setSize(700, 600);
		welcomeFrame.getContentPane().setBackground(Color.WHITE);
		welcomeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void welcomePageRunner() throws IOException {
		this.bar = new JProgressBar(0, 50);
		this.bar.setStringPainted(false);
		Random rnd = new Random();
		float red = rnd.nextFloat();
		float blue = rnd.nextFloat();
		float green = rnd.nextFloat();
		this.bar.setForeground(new Color(red, blue, green));
		Border border = new EtchedBorder(EtchedBorder.LOWERED);
		this.welcomeButton = new JButton("PRESS HERE TO CONITNUE");
		this.welcomeButton.setForeground(new Color(153, 190, 255));
		this.welcomeButton.setOpaque(true);
		this.welcomeButton.setBorderPainted(false);
		this.welcomeButton.setSize(50, 40);
		this.welcomeButton.setBorder(border);
		this.welcomeButton.addActionListener(this);
		welcomeFrame.add(bar, BorderLayout.NORTH);
		welcomeFrame.add(welcomeButton, BorderLayout.SOUTH);

		String image_path = "YorkLogo.gif";
		File path = new File(image_path);
		BufferedImage image = ImageIO.read(path);
		JLabel label = new JLabel(new ImageIcon(image));

		label.setBounds(100, -150, 500, 500);
		JLabel time = new JLabel("Current Date/Time: " + DateFormat.getDateTimeInstance().format(new Date()));
		time.setVerticalAlignment(JLabel.BOTTOM);
		time.setFont(new Font("MONOSPACED", Font.BOLD | Font.ITALIC, 17));
		time.setHorizontalAlignment(JLabel.RIGHT);

		welcomeFrame.add(label);
		welcomeFrame.add(time);
		welcomeFrame.setVisible(true);
	}

	public void middlePostion() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		welcomeFrame.setLocation(dim.width / 2 - welcomeFrame.getSize().width / 2,
				dim.height / 2 - welcomeFrame.getSize().height / 2);
		welcomeFrame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.welcomeButton.setEnabled(true);
		Thread stepper = new welcomeThread(bar);
		stepper.start();
		if (stepper.isAlive()) {
			if (stepper.isAlive()) {
				System.out.println(stepper.getId());
				System.out.println(stepper.getPriority());
				System.out.println(stepper.getState());
			} else {
				//
			}
		}
	}
}