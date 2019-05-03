package Models;

import Interfaces.Loadable;
import Interfaces.Saveable;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static java.lang.System.out;

public class Budget {
    Profile user;
    private Integer budget = 1000;
    protected ArrayList<Transaction> transactions;

    public Budget(Integer budget, ArrayList<Transaction> transactions) {
        this.budget = budget;
        this.transactions = transactions;
    }

    public void setUser(Profile User) {
        if (!(this.user == User)) {
            this.user = User;
            User.setBudget(this);
        }
    }

    public void setBudget(Integer budget) {
        SaveBudget(Integer.toString(budget));
        this.budget = budget;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction s) {
        transactions.add(s);
        savetransaction();
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    static public void SaveBudget(String Amount) {
        try {
            FileWriter fw = new FileWriter("BudgetData.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.println(Amount);

            pw.close();
        } catch (IOException e) {
            out.println("ERROR");
        }
    }
    static public Integer LoadBudget(){
        ArrayList<String> unparsed = new ArrayList<>();
        try{
            FileReader fr = new FileReader("BudgetData.txt");
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null){
                unparsed.add(str);
            }

            br.close();
        } catch (IOException e){
            out.println("File not found");
        }
        Integer parsed = Integer.parseInt(unparsed.get(0));
        return parsed;
    }

    public void savetransaction() {
        try {
            FileWriter fwTN = new FileWriter("TransactionName.txt");
            PrintWriter pwTN = new PrintWriter(fwTN);
            FileWriter fwTA = new FileWriter("TransactionAmount.txt");
            PrintWriter pwTA = new PrintWriter(fwTA);

            for (Transaction t : transactions) {
                pwTN.println(t.getTransactionName());
                pwTA.println(t.getTransactionAmount());
            }
            pwTN.close();
            pwTA.close();
        } catch (IOException e) {
            out.println("ERROR");
        }
    }

    static public ArrayList<Transaction> loadtransaction(){
        ArrayList<Transaction> ReconnectedTransaction = new ArrayList<>();
        try{
            ArrayList<String> disconnectedName = new ArrayList<>();
            ArrayList<Integer> disconnectedAmount = new ArrayList<>();
            FileReader frTN = new FileReader("TransactionName.txt");
            BufferedReader brTN = new BufferedReader(frTN);
            FileReader frTA = new FileReader("TransactionAmount.txt");
            BufferedReader brTA = new BufferedReader(frTA);

            String str;
            while ((str = brTN.readLine()) != null){
                disconnectedName.add(str);
            }
            Integer inte;
            while ((str = brTA.readLine()) != null){
                inte = Integer.parseInt(str);
                disconnectedAmount.add(inte);
            }

            for (int i = 0; i <= (disconnectedAmount.size()-1); i++) {
                ReconnectedTransaction.add(new Transaction(disconnectedName.get(i),disconnectedAmount.get(i)));
            }
            brTN.close();
            brTA.close();
        } catch (IOException e){
            out.println("File not found");
        }
        return ReconnectedTransaction;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Budget budget1 = (Budget) o;
        return Objects.equals(user, budget1.user) &&
                Objects.equals(budget, budget1.budget) &&
                Objects.equals(transactions, budget1.transactions);
    }

    @Override
    public int hashCode() {

        return Objects.hash(user, budget, transactions);
    }
}

