/*
 * @author Richmond F, Edgar Z, Daniyal J
 * @cse : cse23004, cse23106, cse31034
 * YorkU Parking Meter GUI
 * EECS3461 - Scott McKenzie
 */

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.swing.*;

public class WelcomePage extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static JFrame welcomeFrame;
	private String welcomeName;
	private JPanel welcomePanel;
	private JButton welcomeButton;
	private String value;
	private JProgressBar bar;
	private static final long serialVersionUID = 1L;

	static class welcomeThread extends Thread{
		private static int DELAY = 100;
		JProgressBar progressBar;
		
		public welcomeThread(JProgressBar bar){
			progressBar = bar;
		}
		public void run(){
			int max = progressBar.getMaximum();
			int min = progressBar.getMinimum();
			Runnable runner = new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					int value  = progressBar.getValue();
					progressBar.setValue(value + 1);	
				}
			};
			for (int i = min ; i < max ; i++){
				try{
					EventQueue.invokeAndWait(runner);
					//now we sleep
					Thread.sleep(DELAY);
					System.out.println("THREAD INTERRUPTED  " + Thread.interrupted());
					System.out.println("CHECKER VALUE " + i);
					if( i == max - 1){
						System.out.println("RENDERING MAINPAGE . . . . . . . ");
						MainPage display = new MainPage("PARKING KIOSK DEV ENV" , welcomeFrame); 
						display.displayMainPage();
						display.middlePostion();
						
						display.addTextFields();
						display.addInputPanel();
						display.addNumberButtons();
						
						display.addSubmitButtons("NEXT");
						display.exitButton();
						display.addClearButton();
					}
				}catch(InterruptedException ex1){
					
				}catch(InvocationTargetException ex2){
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	} //end of static class
	public WelcomePage(JFrame frame, String text) {
		welcomeFrame = frame;
		this.welcomeName = text;
	}

	public void displayWelcomeMessage() {
		
	}
	
	public void displayWelcomePanel() {
		welcomeFrame = new JFrame(this.welcomeName);
		welcomePanel = new JPanel();
		//this.welcomePanel.setLayout(new BoxLayout(this.welcomePanel, BoxLayout.Y_AXIS));
		welcomeFrame.setSize(700, 600);
		welcomeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void run(){
		this.bar = new JProgressBar(0 , 50);
		this.bar.setStringPainted(true);
		this.welcomeButton = new JButton("CLICK");
		this.welcomeButton.addActionListener(this);
		welcomeFrame.add(bar , BorderLayout.NORTH);
		welcomeFrame.add(welcomeButton , BorderLayout.SOUTH);
		//this.welcomeFrame.add(welcomePanel);
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
		// TODO Auto-generated method stub
		this.welcomeButton.setEnabled(true);
		Thread stepper = new welcomeThread(bar);
		stepper.start();
		if(stepper.isAlive()){
			System.out.println("THREAD IS NOT DONE");
			System.out.println(stepper.getId());
			System.out.println(stepper.getPriority());
			System.out.println(stepper.getState());
			//System.out.println(stepper.activeCount());
		}else{
			System.out.println("FUCK!!");
		}
	}

}
