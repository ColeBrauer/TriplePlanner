package ui;

import javax.swing.*;
import java.util.Scanner;

public class Games {
    String Opponent = "GameMaster";

    public Games(String name){
        System.out.println("Game: " + name);
    }

    void setOpponent(String name) {
        Opponent = name;
    }
    String getOpponent(){
         System.out.println(" Your opponent is: "+ Opponent);
         return Opponent;

    }


   public static int HiLowGame() {
        Games G = new Games("HiLow");
        G.setOpponent("The Game Master");
       JOptionPane.showMessageDialog(null, "Your opponent for this match is:"+ G.getOpponent(), "Hi-Low Game", JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Your opponent for this match is:"+ G.getOpponent());
        //use Keyboard as input (scan=object that pulls input from keyboard-system.in
        Scanner scan = new Scanner(System.in);
        Scanner GameRules = new Scanner(System.in);
        System.out.println("Welcome to a number guessing game! Please select an integer to act as the upper boundary for the game ");
        int Bound = Integer.parseInt(JOptionPane.showInputDialog("Please input an upper bound(You will guess a number in between 0 and this number)"));
        int rightNumber = (int) (Math.random() * Bound + 1);
        int guess = 0;
        System.out.println("Game Master: I'm thinking of a number between 1 and " + Bound);
        while (guess != rightNumber) {
            JOptionPane.showMessageDialog(null, "Game Master: I'm thinking of a number between 1 and " + Bound, "Hi-Low Game", JOptionPane.INFORMATION_MESSAGE);
            guess = Integer.parseInt(JOptionPane.showInputDialog("You: Is it..."));

            if (guess < rightNumber) {
                JOptionPane.showMessageDialog(null, "Too small. Try again!", "Hi-Low Game", JOptionPane.ERROR_MESSAGE);
            } else if (guess > rightNumber) {
                JOptionPane.showMessageDialog(null, "Too large. Try again!", "Hi-Low Game", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Game Master: Well done, I give you one ticket. Come back soon!", "Hi-Low Game", JOptionPane.INFORMATION_MESSAGE);

            }
        }
        return (1);
    }

}
