package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoadableTests {
//    Loadable testP;
//    Profile testa = new Profile();
//
//    @BeforeEach
//    void setup(){
//        testP = new Profile();
//
//    }
//
//    @Test
//public void TestLoad(){
//
}
//}
//case 2: {
//        Scanner MainmenuIn = new Scanner(System.in);
//        Scanner EventIn = new Scanner(System.in);
//        Scanner DeadlineIn = new Scanner(System.in);
//
//
//        Boolean Continue = true;
//        while (Continue) {
//        System.out.println("EventScheduler");
//        System.out.println("-----------");
//        System.out.println("[1] Schedule new event");
//        System.out.println("[2] Remove event");
//        System.out.println("[3] View events");
//        System.out.println("[4] Save schedule");
//        System.out.println("[5] Load schedule");
//        System.out.println("[6] Close agenda");
//        System.out.println("*ACHTUNG!* SAVING CURRENT SCHEDULE WILL OVERWRITE EXISTING SAVE FILE");
//        int AgendaMenuChoice = MainmenuIn.nextInt();
//        switch (AgendaMenuChoice) {
//        case 1: {
//        System.out.println("Enter the name of a planned event: ");
//        String EventName = EventIn.nextLine();
//        System.out.println("Enter the deadline of the event: ");
//        String Deadline = DeadlineIn.nextLine();
//        User.setResponsibilities(EventName + ", on " + Deadline);
//        System.out.println("Event " + EventName + " at " + Deadline + " Added to responsibilities list");
//        break;
//        }
//        case 2: {
//        break;
//        }
//        case 3: {
//        System.out.println(User.getName() + ", coming up, you have " + User.Responsibilities.size() + " event(s) : " + User.getResponsibilities());
//        break;
//        }
//        case 4: {
//        User.save("ResponsibilityList.txt");
//        System.out.println("Current Schedule: ");
//        System.out.println(User.getResponsibilities());
//        System.out.println("Current Schedule saved successfully");
//        break;
//        }
//
//        case 5: {
//        System.out.println("Last time, you scheduled: ");
//        User.load("ResponsibilityList.txt");
//        for (String s : User.getResponsibilities()) {
//        System.out.println(s);
//        }
//        System.out.println("Those events have been added to your current schedule");
//
//        break;
//        }
//
//
//        case 6: {
//        System.out.println("Have a nice week!");
//        Continue = false;
//        break;
//        }
//
//        }
//
//        }
//        break;
//        }