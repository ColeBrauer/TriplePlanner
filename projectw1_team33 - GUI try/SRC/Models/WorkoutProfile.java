package Models;

import java.io.*;
import java.util.ArrayList;

import static java.lang.System.out;

public class WorkoutProfile extends Profile {

    @Override
    public void save(String Filename) {
        try {
            FileWriter fw = new FileWriter(Filename);
            PrintWriter pw = new PrintWriter(fw);
            for (String event : Workouts) {
                pw.println(event);

            }
            pw.close();
        } catch (IOException e) {
            out.println("ERROR");
        }
    }

    @Override
    public ArrayList<String> load(String Filename){
        try{
            FileReader fr = new FileReader(Filename);
            BufferedReader br = new BufferedReader(fr);

            String str;
            while ((str = br.readLine()) != null){
                Workouts.add(str);
                SavedWorkouts.add(str);

            }

            br.close();
        } catch (IOException e){
            out.println("File not found");
        }
        return SavedWorkouts;
    }

}
