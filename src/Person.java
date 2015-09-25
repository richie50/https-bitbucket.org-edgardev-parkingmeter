public class Person
   {
      private final String studentNumber;
      private final String pin;
      private final String lastName;
      private final String firstName;

      Person(String[] commaVal)
      {
    	  /*trim to remove any white spaces before the commas*/
          this.studentNumber = commaVal[0].trim();
          this.pin           = commaVal[1].trim();
          this.lastName      = commaVal[2].trim();
          this.firstName     = commaVal[3].trim();
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
   }