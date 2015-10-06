public class Person
   {
      private final String studentNumber;
      private final String pin;
      private final String lastName;
      private final String firstName;
	private String status;

      Person(String[] commaVal)
      {
    	  /*trim to remove any white spaces before the commas*/
          this.studentNumber = commaVal[0].trim();
          this.pin           = commaVal[1].trim();
          this.lastName      = commaVal[2].trim();
          this.firstName     = commaVal[3].trim();
          this.status 		 = commaVal[4].trim();
      }

      String getStudentNumber()
      {
         return studentNumber;
      }

      String getPin()
      {
         return pin;
      }

      String getLastName()
      {
         return lastName;
      }

      String getFirstName()
      {
         return firstName;
      }
      String getStatus(){
    	  return status;
      }
   }