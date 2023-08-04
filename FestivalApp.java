import java.util.Scanner;

/* This is the driver class for this project. You need to run this class with three command line arguments corresponding to the name, starting date and maxinum number of allowed events of a festival. For exmaple run the below command from the termincal:
java FestivalApp "CSE Fest 2023" "2023-07-15" 10*/
public class FestivalApp {

  public static void main(String[] args) {
    // Task: The program will be run with three command line arguements related to a festival- (i) the festival's name, (ii) its starting date and (iii) the maximum number of events allowed in the festival. Create a FestivalManager object named 'festivalManager' and initialize it with the values passed from the command line as: FestivalManager festivalManager = new FestivalManager(...); Generate error if the required parameters are not passed from the command line.

    // Write your code here
    String festivalName = args[0];
    String startDate = args[1];
    int maximumEventCount = Integer.parseInt(args[2]);
    FestivalManager festivalManager = new FestivalManager(
      festivalName,
      startDate,
      maximumEventCount
    );

    int choice;
    Scanner scanner = new Scanner(System.in);

    do {
      // the following lines of code show a menu to take user's choice
      // System.out.println("Menu:");
      // System.out.println("1. Add an event");
      // System.out.println("2. Register student in an event");
      // System.out.println("3. View festival details");
      // System.out.println("4. View specific event");
      // System.out.println("5. View Event on Date");
      // System.out.println("6. View event with maximum participants");
      // System.out.println("7. View events for students");
      // System.out.println("8. Cancel registration");
      // System.out.println("9. Exit");
      // System.out.print("Enter option: ");

      choice = scanner.nextInt();
      scanner.nextLine(); // Consume the newline character

      switch (choice) {
        case 1: // Add an event
          /*
           * Task: using the scanner object, read the following information for an event:
           * (i) name as a string, (ii) starting date as a string in 'YYYY-MM-DD' format,
           * (iii) location as  astring, and (iv) max number of participants allowed in the
           * event as an integer. Invoke the function 'add event' of 'Festival Manager' to
           * add the event, i.e., call festivalManager.addEvent(...)
           */

          // Write your code here
          System.out.println("choice 1 clicked:");
          String eventName = scanner.nextLine();
          String startingDate = scanner.nextLine();
          String location = scanner.nextLine();
          int maxParticipants = scanner.nextInt();

          Event event = new Event(
            eventName,
            startingDate,
            location,
            maxParticipants
          );
          festivalManager.addEvent(event);
          break;
        // festivalManager.showDetails();
        case 2: // Register a student in an event
          /*
           * Task: read the name and id of a student and an event name. Then register the
           * student in the event by calling the function:
           * festivalManager.registerStudent(...)
           */

          // Write your code here
          System.out.println("choice 2 clicked:");
          String studentName = scanner.nextLine();
          String studentId = scanner.nextLine();
          String eventNameToBeRegistered = scanner.nextLine();

          Student std = new Student(studentName, studentId);
          festivalManager.registerStudent(eventNameToBeRegistered, std);
          break;
        case 3: // View festival details
          System.out.println("choice 3 clicked:");
          festivalManager.showDetails();
          break;
        case 4: // View event details
          /*
           * Task: read the name of an event and then show the details for the event by
           * calling the function: festivalManager.showEvent(...);
           */

          // Write your code here

          System.out.println("choice 4 clicked:");
          String eventToBeShown = scanner.nextLine();

          festivalManager.showEvent(eventToBeShown);
          break;
        case 5: // View event on date
          /*Task: read the date in 'YYYY-MM-DD' format and then show the events on that date by calling the function: festivalManager.showEventsOnDate(...);*/
          System.out.println("choice 5 clicked:");
          String eventOnDate = scanner.nextLine();

          festivalManager.showEventsOnDate(eventOnDate);
          break;
        case 6: // View event with maximum participants
          System.out.println("choice 6 clicked:");
          festivalManager.eventWithHighestParticipants();
          break;
        case 7: // View events for students
          /*Task: read the id of a student and then show the events the student is participating in by calling the function:  festivalManager.showEventsForStudent(...);*/

          //Write your code here

          System.out.println("choice 7 clicked:");
          String studentToBeShown = scanner.nextLine();

          festivalManager.showEventsForStudent(studentToBeShown);
          break;
        case 8: // Cancel registration
          /* Task: read the id of a student and an event name. Then remove the student from the participant list of the event by calling the function:  festivalManager.cancelRegistration(...); */

          //Write your code here

          System.out.println("choice 8 clicked:");
          String studentToBeRemoved = scanner.nextLine();
          String eventNameToBeRemoved = scanner.nextLine();

          festivalManager.cancelRegistration(
            eventNameToBeRemoved,
            studentToBeRemoved
          );
          break;
        case 9:
          System.out.println("choice 9 clicked:");
          System.out.println("finally Exiting the program.");
          break;
        default:
          System.out.println("Invalid option. Please try again.");
          break;
      }
      System.out.println();
    } while (choice != 9);

    scanner.close();
  }
}
