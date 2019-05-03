package Models;

import Interfaces.Loadable;
import Interfaces.Saveable;
import Observer.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import static Models.Budget.LoadBudget;
import static Models.Budget.SaveBudget;
import static Models.Budget.loadtransaction;
import static java.lang.System.out;

public abstract class Profile extends Subject implements Saveable, Loadable, Serializable {
    String Name;
    Integer ProcrastinationPoints = 0;
    ArrayList<String> Responsibilities = new ArrayList<>();
    ArrayList<String> Workouts = new ArrayList<>();
    ArrayList<String> SavedResponsibilities = new ArrayList<>();
    ArrayList<String> SavedWorkouts = new ArrayList<>();
    ArrayList<Profile> Contacts;
    Integer budget= LoadBudget();
    ArrayList<Transaction> transactions = loadtransaction();
    Budget Budget = new Budget(budget, transactions);

    public void setBudget(Budget budget){
        SaveBudget(Integer.toString(budget.getBudget()));
        if(!(this.Budget == budget)) {
            this.Budget = budget;
            budget.setUser(this);

        }
    }



    public Models.Budget getBudget() {
        return Budget;
    }

    @Override
    public abstract void save(String Filename);

    @Override
    public abstract ArrayList<String> load(String Filename);

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: Returns username
    public String getName() {
        return Name;
    }

    //REQUIRES: Nothing
    //MODIFIES: this
    //EFFECTS: Sets the name of the user
    public void setName(String name) {
        this.Name = name;
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: Returns list of responsibilities
    public ArrayList<String> getResponsibilities() {
        return Responsibilities;
    }


    //REQUIRES: nothing
    //MODIFIES: this
    //EFFECTS: Keeps track of what tasks user has to do and when
    public void setResponsibilities(String responsibilities) {
        Responsibilities.add(responsibilities);
    }

    //REQUIRES: Nothing
    //MODIFIES: Nothing
    //EFFECTS: Returns amount of game points
    public int getProcrastinationPoints() {
        return ProcrastinationPoints;
    }

    //REQUIRES: nothing
    //MODIFIES: this
    //EFFECTS: Keeps track of users procrastination/Game points
    public void setProcrastinationPoints(Integer procrastinationpoints) {
        this.ProcrastinationPoints += procrastinationpoints;
    }

    public ArrayList<String> getWorkouts() {
        return Workouts;
    }

    public void setWorkouts(String workouts) {
       Workouts.add(workouts);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(Name, profile.Name) &&
                Objects.equals(ProcrastinationPoints, profile.ProcrastinationPoints) &&
                Objects.equals(Responsibilities, profile.Responsibilities) &&
                Objects.equals(Workouts, profile.Workouts) &&
                Objects.equals(SavedResponsibilities, profile.SavedResponsibilities) &&
                Objects.equals(SavedWorkouts, profile.SavedWorkouts) &&
                Objects.equals(Budget, profile.Budget);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Name, ProcrastinationPoints, Responsibilities, Workouts, SavedResponsibilities, SavedWorkouts, Budget);
    }
}

