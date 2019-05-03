package ui;

import GUI.GUIMenus;
import Models.Profile;
import Observer.Subject;

import java.util.Scanner;
import Observer.Subject;

import javax.swing.*;

public class EventScheduler extends Subject{

    public static void EventScheduler(Profile User) {
        Scanner MainmenuIn = new Scanner(System.in);
        Scanner EventIn = new Scanner(System.in);
        Scanner DeadlineIn = new Scanner(System.in);
        Scanner RemoveIn = new Scanner(System.in);

        Boolean Continue = true;
        User.load("ResponsibilityList.txt");
        while (Continue) {
            Integer counter = 1;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Upcoming Events:");
            for (String s:User.getResponsibilities()) {
                System.out.println(counter+". "+s);
                counter++;
            }

            int AgendaMenuChoice = GUIMenus.SchedulerMenu();
            switch (AgendaMenuChoice) {
                case 1: {
                    String EventName = JOptionPane.showInputDialog("Enter the name of upcoming Event");
                    String Deadline = JOptionPane.showInputDialog("Enter the deadline of said Event");
                    User.setResponsibilities(EventName+" On "+ Deadline);
                    User.save("ResponsibilityList.txt");
                    JOptionPane.showMessageDialog(null,  "Event " + EventName + " on " + Deadline + " Added to responsibilities list", "Event Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    User.notifyobservers(EventName);
                    break;
                }
                case 2: {
                    Integer Deletechoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Event you would like to delete:"));
                    String ToDelete = User.getResponsibilities().get(Deletechoice-1);
                    User.getResponsibilities().remove(Deletechoice-1);
                    JOptionPane.showMessageDialog(null,  "Event Sucessfully deleted", "Event Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    User.save("ResponsibilityList.txt");
                    break;
                }
                case 3: {
                    JOptionPane.showMessageDialog(null,  User.getName() + ", coming up, you have " + User.getResponsibilities().size() + " event(s) : " + User.getResponsibilities(), "Event Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
                case 4: {
                    User.save("ResponsibilityList.txt");
                    System.out.println("Current Schedule: ");
                    System.out.println(User.getResponsibilities());
                    System.out.println("Current Schedule saved successfully");
                    break;
                }

                case 5: {
                    System.out.println("Your past schedule has been added to your current one.");
                    User.load("ResponsibilityList.txt");
                    System.out.println("This is your current, up-to-date schedule:");
                    for (String s : User.getResponsibilities()) {
                        System.out.println(s);
                    }
                    break;
                }


                case 6: {
                    System.out.println("Have a nice week!");
                    Continue = false;
                    break;
                }

            }

        }
    }

}
