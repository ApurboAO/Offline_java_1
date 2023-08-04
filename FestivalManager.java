/* This class stores information of a festival which are name, starting date and list of events that will take place during the festival. */
public class FestivalManager {

  private String name;
  private String startDate;
  private Event[] events;
  int eventsAdded = 0;

  //Task: Write code for the constructor below to initialize the member variables properly
  public FestivalManager(String name, String startDate, int maxEventCount) {
    // write your code here
    this.name = name;
    this.startDate = startDate;
    this.events = new Event[maxEventCount];
  }

  //Task: Write code for the function below. This function adds an event to this festival. Check for the following case: (i) total event count does not exceed the maximum number of events allowed for this festival
  public void addEvent(Event e) {
    // write your code here
    System.out.println();
    System.out.println("Event " + e.getEventName() + "  Added");
    events[eventsAdded] = e;
    eventsAdded++;
  }

  //Task: Write code for the function below. This function registers a student for an event in this festival. Check for the following case: (i) event does not exist
  public void registerStudent(String eventName, Student s) {
    boolean eventFound = false;
    System.out.println();
    for (int i = 0; i < eventsAdded; i++) {
      if (eventName.equals(events[i].getEventName())) {
        eventFound = true;
        if (!events[i].isRegistered(s.getId())) {
          events[i].addParticipant(s);
          System.out.println("Registration successful. participants added: "+s.getId());

        } else {
          System.out.println(
            "This student is already registered for the event."
          );
        }
        break;
      }
    }
    if (!eventFound) {
      System.out.println("This event does not exist.");
    }
  }

  // Task: Write code for the function below. The function shows the details of this festival. Make sure the output matches with the supplied sample output.
  public void showDetails() {
    //Write your code here
    System.out.println();
    System.out.println("Festival Name: " + name);
    System.out.println("Starting date: " + startDate);
    System.out.println("Total event: " + eventsAdded);
    for (int i = 0; i < eventsAdded; i++) {
      events[i].showDetails();
    }
  }

  // Task: Write code for the function below. This function shows details of the event in the argument. Check for the following case: (i) event does not exist
  public void showEvent(String eventName) {
    //Write your code here
    System.out.println();
    System.out.println("Event details : ");
    boolean eventExists = false;
    for (int i = 0; i < eventsAdded; i++) {
      if (eventName.equals(events[i].getEventName())) {
        events[i].showDetails();
        eventExists = true;
      }
    }
    if (!eventExists) {
      System.out.println("This event does not exist.");
    }
  }

  // Task: Write code for the function below. This function shows details of the events that will start on the date passed as its argument. Check for the following case: (i) event does not exist
  public void showEventsOnDate(String eventDate) {
    //Write your code here
    boolean eventExistsDate = false;
    System.out.println();
    System.out.println("Events on Date : "+ eventDate);
    for (int i = 0; i < eventsAdded; i++) {
      if (eventDate.equals(events[i].getEventDate())) {
        System.out.println(events[i].getEventName());
        eventExistsDate = true;
      }
    }
    if (!eventExistsDate) {
      System.out.println("This event does not exist.");
    }
  }

  //Task: Write code for the function below. This function shows the details of the events with maximum number of participants. If there are multiple events, show all.
  public void eventWithHighestParticipants() {
    int maxParticipants = 0;
    System.out.println();
    for (int i = 0; i < eventsAdded; i++) {
      if (events[i].getParticipantCount() > maxParticipants) {
        maxParticipants = events[i].getParticipantCount();
      }
    }
    if (maxParticipants == 0) {
      System.out.println("No events registered yet.");
    } else {
      System.out.println("Events with the highest participants:");
      for (int i = 0; i < eventsAdded; i++) {
        if (events[i].getParticipantCount() == maxParticipants) {
          events[i].showDetails();
        }
      }
    }
  }

  //Task: Write code for the function below. This function takes a student Id as input and then lists all the events this particular student has registered for. Make sure your output matches the supplied sample output.
  public void showEventsForStudent(String studentId) {
    //Write your code here
    System.out.println("Student : " + studentId + "  registered for :");
    for (int i = 0; i < eventsAdded; i++) {
      if (events[i].isRegistered(studentId)) {
        System.out.println(events[i].getEventName());
      }
    }
  }

  //Task: Write code for the function below. This functions takes an event's name and a student's ID as arguments and then removes the student from the registered student list of the event. Check for the following cases: (i) event does not exist, (ii) student is not registered for the event

  public void cancelRegistration(String eventName, String studentId) {
    //Write your code here
    boolean eventExistence = false;
    System.out.println();
    for (int i = 0; i < eventsAdded; i++) {
      if (eventName.equals(events[i].getEventName())) {
        eventExistence = true;
        if (events[i].isRegistered(studentId)) {
          events[i].removeParticipant(studentId);
          System.out.println("Registration canceled successfully.");
          System.out.println("Student "+studentId+" removed from event "+ events[i].getEventName());
        } else {
          System.out.println("This student is not registered for the event.");
        }
        break;
      }
    }
    if (!eventExistence) {
      System.out.println("This event does not exist.");
    }
  }
}
