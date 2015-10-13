import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class welcomeClockPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel timer;

	public welcomeClockPanel() {
		setLayout(new BorderLayout());
		timer = new JLabel();
		timer.setVerticalAlignment(JLabel.BOTTOM);
		timer.setHorizontalAlignment(JLabel.RIGHT);
		timer.setFont(UIManager.getFont("Label.font").deriveFont(Font.ROMAN_BASELINE, 16f));
		tickTock();
		add(timer);
		Timer clock = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tickTock();
			}
		});
		clock.setRepeats(true);
		clock.setCoalesce(true);
		clock.setInitialDelay(0);
		clock.start();
	}

	public void tickTock() {
		timer.setText("Current Date/Time: " + DateFormat.getDateTimeInstance().format(new Date()));
	}
}