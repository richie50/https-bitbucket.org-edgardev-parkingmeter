
/*
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

public class Tester {

	public static void main(String[] args) throws IOException {
		JFrame frame = null;
		WelcomePage welcome = new WelcomePage("WELCOME", frame);
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					welcome.displayWelcomePanel();
				} catch (IOException e) {

				}
				try {
					welcome.welcomePageRunner();
				} catch (IOException e) {

				}
				welcome.middlePostion();
			}
		};
		EventQueue.invokeLater(runner);
		welcome.setVisible(false);
	}

}
