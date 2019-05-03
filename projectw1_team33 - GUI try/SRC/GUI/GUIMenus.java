package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;

public class GUIMenus {

    // NOTE: I DO NOT OWN ANY OF THE PICTURES BELOW! THEY ARE ALL TAKEN FROM GOOGLE IMAGES
    private static ImageIcon MainMenuImage= new ImageIcon("MainMenu.png");
    private static ImageIcon ScheduleImage = new ImageIcon("Schedule.png");
    private static ImageIcon WorkoutImage=new ImageIcon("Dumbbell.png");
    private static ImageIcon BudgetImage = new ImageIcon("Budget.png");

    public static Integer Mainmenu(){

        Object[] possibleValues = {
                "Play Guessing Number Game",
                "Scheduler",
                "Workout Scheduler",
                "Budgeter",
                "Check Weather",
                "Exit"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select an option",
                "Main Menu",
                JOptionPane.INFORMATION_MESSAGE,
                MainMenuImage,
                possibleValues,
                possibleValues[0]
                );
        int choice = 1;
        for (Object o:possibleValues) {
            if (selectedValue == o){
                return choice;}
                else choice ++;

        }
        if (selectedValue == null){
            return 6;
        }
        return choice;
    }

    public static Integer SchedulerMenu(){
        Object[] possibleValues = {
                "Schedule New Event",
                "Remove Event (WIP)",
                "View Schedule",
                "Back-up Schedule",
                "load Backed-Up Schedule",
                "Return to Main menu"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select an option", "Scheduler Menu",
                JOptionPane.INFORMATION_MESSAGE, ScheduleImage,
                possibleValues, possibleValues[0]);
        int choice = 1;
        for (Object o:possibleValues) {
            if (selectedValue == o){
                return choice;}
            else choice ++;
        }
        if (selectedValue == null){
            return 6;
        }
        return choice;
    }

    public static Integer WorkoutMenu(){
        Object[] possibleValues = {
                "Schedule New Workout",
                "Remove Workout (WIP)",
                "View Scheduled Workouts",
                "Back-up Workout Schedule",
                "load Backed-Up Workout Schedule",
                "Return to Main menu"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select an option", "Workout Menu",
                JOptionPane.INFORMATION_MESSAGE, WorkoutImage,
                possibleValues, possibleValues[0]);
        int choice = 1;
        for (Object o:possibleValues) {
            if (selectedValue == o){
                return choice;}
            else choice ++;
        }
        if (selectedValue == null){
            return 6;
        }
        return choice;
    }
    public static Integer BudgeterMenu(){
        Object[] possibleValues = {
                "Adjust Balance",
                "Add Transaction",
                "Pay Existing Transaction",
                "Return to Main menu"};
        Object selectedValue = JOptionPane.showInputDialog(null,
                "Select an option", "Budgeter",
                JOptionPane.INFORMATION_MESSAGE, BudgetImage,
                possibleValues, possibleValues[0]);
        int choice = 1;
        for (Object o:possibleValues) {
            if (selectedValue == o){
                return choice;}
            else choice ++;
        }
        if (selectedValue == null){
            return 4;
        }
        return choice;
    }
}
