
/**
 * @author Richmond Frimpong, Edgar Zaganjori, Daniyal Javed cse : cse23004,
 *         cse23106, cse31034 YorkU Parking Meter GUI EECS3461 - Scott McKenzie
 */

public class Person {
	private final String studentNumber;
	private final String pin;
	private final String lastName;
	private final String firstName;
	private String status;

	Person(String[] commaVal) {
		/* trim to remove any white spaces before the commas */
		this.studentNumber = commaVal[0].trim();
		this.pin = commaVal[1].trim();
		this.lastName = commaVal[2].trim();
		this.firstName = commaVal[3].trim();
		this.status = commaVal[4].trim();
	}

	/**
	 * 
	 * @return studentNumber Student number entered
	 */
	String getStudentNumber() {
		return studentNumber;
	}

	/**
	 * 
	 * @return pin Pin number entered
	 */

	String getPin() {
		return pin;
	}

	/**
	 * 
	 * @return lastName Student's last number entered
	 */

	String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return firstName Student's first name entered
	 */

	String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return status Student's stats of 'ok' or 'arrears'
	 */

	String getStatus() {
		return status;
	}
}