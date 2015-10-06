import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.*;

public class Tester {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		JFrame frame = null;
		WelcomePage welcome = new WelcomePage("WELCOME", frame);
		Runnable runner = new Runnable() {		
			@Override
			public void run() {
				try {
					welcome.displayWelcomePanel();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("IMAGE DOESNT EXIST!!!!");
				}
				try {
					welcome.welcomePageRunner();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				welcome.middlePostion();
			}
		};
		EventQueue.invokeLater(runner);
		welcome.setVisible(false);
	}

}
