import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

public class Tester {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		JFrame frame = null;
		WelcomePage welcome = new WelcomePage(frame, "WELCOME");
		Runnable runner = new Runnable() {		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				//welcome = new WelcomePage(frame, "WELCOME");
				welcome.displayWelcomePanel();
				welcome.run();
				welcome.middlePostion();
			}
		};
		EventQueue.invokeLater(runner);
		welcome.setVisible(false);
	}

}
