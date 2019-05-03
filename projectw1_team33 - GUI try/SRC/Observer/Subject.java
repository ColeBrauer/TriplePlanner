package Observer;

import Models.Responsibility;
import Models.WorkoutProfile;
import ui.WorkoutScheduler;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    ArrayList<ResponsibilityObserver> observers = new ArrayList<ResponsibilityObserver>() {
    };

    public void addobserver(ResponsibilityObserver obs) {
        if (!(observers.contains(obs))) {
            observers.add(obs);
        }
    }
    public void notifyobservers(String newevent){
        for (ResponsibilityObserver obs:observers) {
            obs.update(newevent);

        }
    }
}
