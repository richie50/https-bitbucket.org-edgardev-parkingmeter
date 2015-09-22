import java.io.IOException;

import javax.swing.*;

public class Tester {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		JFrame frame = null;
		MainPage display = new MainPage("PARKING KIOSK DEV ENV" , frame); 
		display.displayMainPage();
		display.middlePostion();
		//display.addIcon();
		display.addTextFields();
		display.addPanel();
		display.addNumberButtons();
		display.addSubmitButtons("NEXT");
		display.exitButton();
		display.addClearButton();
	}

}
