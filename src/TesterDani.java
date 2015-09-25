/*
 * Author Daniyal Javed , Tested by Richmond Frimpong
 * A class that goes iterates over a local database and find matching records 
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import javax.swing.*;

public class TesterDani {

	public static void main(String[] args) throws IOException{
		/**CHANGE THE FILE PATH**/
		final Path FILE_PATH = Paths.get("C:\\Users\\RichMond\\workspace\\UI\\student.txt");
		String studentdb = "457642455";
		String pindb = "2164";
	      Optional<Person> matchingStudent = null;
		try {
			matchingStudent = Files.lines(FILE_PATH)
			              .map(line -> line.split(","))
			              .map(commaVal -> new Person(commaVal))
			              .filter(person -> person.getStudentNumber().equals(studentdb) && person.getPin().equals(pindb))
			              .findFirst();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	      if (matchingStudent.isPresent())
	      {
	         Person matchingPerson = matchingStudent.get();
	         System.out.println("Hello " + matchingPerson.getFirstName().toUpperCase() + " " + matchingPerson.getLastName().toUpperCase());
	         JFrame frame = new JFrame("AUTHENTICATION CORRECT");
	         frame.setSize(200, 100);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	         JLabel label = new JLabel("OK   " + matchingPerson.getFirstName().toUpperCase()+"  ");
	         label.setAlignmentX(JComponent.CENTER_ALIGNMENT);
	         frame.add(label);
	         frame.setVisible(true);
	      }
	      else
	      {
	         System.out.println("No matching record found".toUpperCase());
	      }
	}

}