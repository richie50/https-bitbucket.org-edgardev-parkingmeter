
/**
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

/**
 * 
 * Default Runner for the project incorperating all files.
 */
public class a1 {

	public static void main(String[] args) throws IOException {
		JFrame frame = null;
		WelcomePage welcome = new WelcomePage("Welcome to YorkU", frame);
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					welcome.displayWelcomePanel();
				} catch (IOException e) {
					// Do nothing as it will generate welcome page panel
				}
				try {
					welcome.welcomePageRunner();
				} catch (IOException e) {
					// Do nothing as it will generate welcome page runner
				}
				welcome.middlePostion();
			}
		};
		EventQueue.invokeLater(runner);
		welcome.setVisible(false);
	}
}