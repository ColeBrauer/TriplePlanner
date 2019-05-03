package ui;

import Models.Budget;
import Models.Transaction;

import javax.swing.*;
import java.util.Scanner;

import static GUI.GUIMenus.BudgeterMenu;

public class Budgeter {

    public static void Budgeter(Budget User){
        Scanner ChangebudgetIn = new Scanner(System.in);
        Scanner MainmenuIn = new Scanner(System.in);
        Scanner AddBudget = new Scanner(System.in);
        Scanner RemoveIn = new Scanner(System.in);

        Boolean Loop = true;
        while(Loop) {
            Integer changebudget = JOptionPane.showConfirmDialog(null,
                    "You're current budget is $" + User.getBudget() + ". Would you like to adjust it?", "choose one", JOptionPane.YES_NO_OPTION);
            if ( changebudget == JOptionPane.YES_OPTION) {
//                System.out.println("Enter new budget");
//                Scanner NewBudgetIn = new Scanner(System.in);
                Integer NewBudget = Integer.parseInt(JOptionPane.showInputDialog("Enter New budget:"));
                User.setBudget(NewBudget);

            } else if (changebudget == JOptionPane.NO_OPTION) {
                Loop = false;
            }}
            Boolean Continue = true;
            while (Continue) {
                System.out.println("-----------------------------------------");
                Menu.MenuTitle("Budgeter");
                System.out.println("Total Budget: $" + User.getBudget());
                System.out.println("Total expenses: $" + addTransactionTotal(User));
                System.out.println("Funds remaining: $" + remainingFunds(User));
                System.out.println("Pending transactions: ");
                Integer counter = 1;
                for (Transaction R: User.getTransactions()) {
                    System.out.println(counter+". "+R.getTransactionName()+" For $"+R.getTransactionAmount());
                    counter++;
                }
                System.out.println("-----------------------------------------");
                Menu.MenuOption(1, "Adjust Budget");
                Menu.MenuOption(2, "Add Transaction");
                Menu.MenuOption(3, "Pay For Transaction");
                Menu.MenuOption(4, "Return to main menu");

                int BudgetMainMenuChoice = BudgeterMenu();
                switch (BudgetMainMenuChoice) {
                    case 1: {
                        Object[] possibleValues = { "Add", "Subtract" };
                        Object selectedValue = JOptionPane.showInputDialog(null,
                                "Would you like to add or subtract from your current budget?",Integer.toString(User.getBudget()) ,
                                JOptionPane.INFORMATION_MESSAGE, null,
                                possibleValues, possibleValues[0]);
                        if (selectedValue == possibleValues[0]){
                            String inputString = JOptionPane.showInputDialog("Enter amount to add");
                            Integer inputValue = Integer.parseInt(inputString);
                            User.setBudget(User.getBudget() + inputValue);
                        }
                        else if (selectedValue == possibleValues[1]){
                            String inputString = JOptionPane.showInputDialog("Enter amount to subtract");
                            Integer inputValue = Integer.parseInt(inputString);
                            User.setBudget(User.getBudget() - inputValue);
                        }
                        break;
                    }
                    case 2: {
//                        Scanner TransactionName = new Scanner(System.in);
//                        Scanner TransactionAmount = new Scanner(System.in);
//                        System.out.println("Enter name for this transaction: ");
                        String Tname = JOptionPane.showInputDialog("Enter the name of this transaction");
                        System.out.println("Enter amount for " + Tname + ": ");
                        Integer Tamount = Integer.parseInt(JOptionPane.showInputDialog("Enter amount for " + Tname + ": "));
                        User.addTransaction(new Transaction(Tname,Tamount));
                        break;
                    }
                    case 3:{
//                        Integer counter = 1;
//                        for (Transaction R: User.getTransactions()) {
//                            System.out.println(counter+". "+R.getTransactionName()+" For $"+R.getTransactionAmount());
//                            counter++;
//                        }
                        System.out.println("Please enter the number corresonding to the Transaction you would like to delete");
                        Integer Deletechoice = Integer.parseInt(JOptionPane.showInputDialog("Please enter the number corresonding to the transaction you would like pay"));
                        Transaction ToDelete = User.getTransactions().get(Deletechoice-1);
                        User.getTransactions().remove(Deletechoice-1);
                        JOptionPane.showMessageDialog(null,  "Payment made!", "Budgeter", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    }
                    case 4:{
                        Continue = false;
                        break;
                    }


                }
            }
        }


    public static Integer addTransactionTotal(Budget b){
        Integer TotalTransactions = 0;
        for (Transaction T: b.getTransactions()) {
            TotalTransactions = TotalTransactions + T.getTransactionAmount();
        }
        return TotalTransactions;
    }
    public static Integer remainingFunds(Budget b){
        Integer remainingFunds = b.getBudget() - addTransactionTotal(b);

        return remainingFunds;
    }
}
