package ui;

import Exceptions.Overexertion;
import Exceptions.WorkHarder;
import GUI.GUIMenus;
import Models.Profile;

import javax.swing.*;
import java.util.Scanner;

public class WorkoutScheduler {

    public static void WorkoutScheduler(Profile User, Profile FitUser) {
        Scanner MainmenuIn = new Scanner(System.in);
        Scanner WokroutNameIn = new Scanner(System.in);
        Scanner RepsIn = new Scanner(System.in);
        Scanner DaysIn = new Scanner(System.in);
        Scanner RemoveIn = new Scanner(System.in);


        Boolean Continue = true;

        FitUser.load("WorkoutList.txt");
        while (Continue) {
            Integer counter = 1;
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Workouts:");
            for (String s:FitUser.getWorkouts()) {
                System.out.println(counter+". "+s);
                counter++;
            }
            int AgendaMenuChoice = GUIMenus.WorkoutMenu();
            switch (AgendaMenuChoice) {

                case 1: {
                    Boolean loop = true;
//                    System.out.println("Enter the name of workout: ");
                    String EventName = JOptionPane.showInputDialog("Enter the name of workout");
//                    System.out.println("Enter the amount of reps: ");
                    String Reps = JOptionPane.showInputDialog("Enter the amount of reps");
                    while (loop) {
                        try {
                            Integer Repsresult = Integer.valueOf(Reps);
                            WorkingTooHard(Integer.valueOf(Reps));
                            WorkHarder(Integer.valueOf(Reps));
                            loop = false;
                        } catch (Overexertion overexertion) {
//                            System.out.println("WARNING:TOO MANY REPS! YOU MIGHT HURT YOURSELF");
//                            System.out.println("RECOMMENDED REPS: 8-12");
                            JOptionPane.showMessageDialog(null,  "WARNING:TOO MANY REPS! YOU MIGHT HURT YOURSELF (Recomended 8-12)", "Workout Scheduler", JOptionPane.WARNING_MESSAGE);
//                            System.out.println("How many reps would you like to do for this workout?:");
                            Reps = JOptionPane.showInputDialog("Enter the amount of reps");
                        } catch (WorkHarder underexertion) {
//                            System.out.println("You should try to push yourself more. I know you can do it!");
//                            System.out.println("RECOMMENDED REPS: 8-12");
//                            System.out.println("How many reps would you like to do for this workout?:");
                            JOptionPane.showMessageDialog(null,  "You should push yourself more (Recomended 8-12)", "Workout Scheduler", JOptionPane.WARNING_MESSAGE);
//                            System.out.println("How many reps would you like to do for this workout?:");
                            Reps = JOptionPane.showInputDialog("Enter the amount of reps");
                        } catch (NumberFormatException NFE) {
                            JOptionPane.showMessageDialog(null,  "REPS should be an integer value", "Workout Scheduler", JOptionPane.WARNING_MESSAGE);
                            Reps = JOptionPane.showInputDialog("Enter the amount of reps");
                        }
                    }
//                    System.out.println("On which days? : ");
                    String Days = JOptionPane.showInputDialog("On which days?");
                    FitUser.setWorkouts(EventName + " REPS: " + Reps + " On: " + Days);
                    System.out.println("Workout: " + EventName + " REPS: " + Reps + " On: " + Days + " Added to workout list");
                    JOptionPane.showMessageDialog(null,  "Workout: " + EventName + " REPS: " + Reps + " On: " + Days + " Added to workout list", "Workout Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    FitUser.save("WorkoutList.txt");
                    break;
                }

                case 2: {

                    System.out.println("Please enter the number corresonding to the workout you would like to delete");
                    Integer Deletechoice = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of Workout you would like to delete:"));
                    String ToDelete = FitUser.getWorkouts().get(Deletechoice-1);
                    FitUser.getWorkouts().remove(Deletechoice-1);
                    JOptionPane.showMessageDialog(null,  "Workout Sucessfully deleted", "Event Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    FitUser.save("WorkoutList.txt");
                    break;
                }
                case 3: {
                    System.out.println(User.getName() + ", coming up, you have " + FitUser.getWorkouts().size() + " event(s) : " + FitUser.getWorkouts());
                    break;
                }
                case 4: {
                    FitUser.save("WorkoutList.txt");
//                    System.out.println("Current Schedule: ");
//                    System.out.println(FitUser.getWorkouts());
                    JOptionPane.showMessageDialog(null,  "save succesful", "Workout Scheduler", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }

                case 5: {
//                    System.out.println("Last time, you scheduled: ");
//                    FitUser.load("WorkoutList.txt");
//                    for (String s : FitUser.getWorkouts()) {
//                        System.out.println(s);
//                    }
                    JOptionPane.showMessageDialog(null,  "Load succesful", "Workout Scheduler", JOptionPane.INFORMATION_MESSAGE);;

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
    public static void WorkingTooHard(Integer Reps) throws Overexertion {
        if (Reps > 12) {
            throw new Overexertion();
        }
    }

    public static void WorkHarder(Integer Reps) throws WorkHarder {
        if (Reps < 8) {
            throw new WorkHarder();
        }
    }

}
