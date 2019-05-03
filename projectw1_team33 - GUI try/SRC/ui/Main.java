package ui;

import Exceptions.Overexertion;
import Exceptions.WorkHarder;
import GUI.GUIMenus;
import Models.*;

import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;
import java.io.Serializable;

public class Main implements Serializable {

    public static void main(String[] args) {
        Profile User = new ResponsibilityProfile();



        Profile FitUser = new WorkoutProfile();
        Main main = new Main();
        User.setProcrastinationPoints(0);

        String Username;
        Scanner scanUsername = new Scanner(System.in);

        Username = JOptionPane.showInputDialog("What is your name? ");;                            // scanUsername.next();
        User.setName(Username);
        Contact me = new Contact(Username, "6045555555", "XXX");
        User.addobserver(me);

        while (true) {
            main.MainMenu(User, FitUser);


        }
    }

    public void MainMenu(Profile User, Profile FitUser) {

        int MainMenuChoice = GUIMenus.Mainmenu();

            switch (MainMenuChoice) {
                case 1: {
                    User.setProcrastinationPoints(Games.HiLowGame());
                    break;
                }
                case 2: {
                    EventScheduler.EventScheduler(User);
                }
                break;
                case 3: {
                    WorkoutScheduler.WorkoutScheduler(User, FitUser);
                    break;
                }
                case 4: {
                    Budgeter.Budgeter(User.getBudget());
                    break;
                }
                case 5: {
                    try {
                        ReadWebPageEx.GetWeather();
                    } catch (Exception IOException) {
                    }
                    break;
                }
                case 6: {
                    Exit(User);
                }
            }
        }


    public void Exit(Profile User) {
//        System.out.println("You finished with " + User.getProcrastinationPoints() + " procrastination points... Good job...");
//        System.out.println("I am still working on features for this project. There is a lot more to come so stay tuned!");
//        System.out.println("BYE! -Cole Brauer");
        System.exit(0);
    }
}



