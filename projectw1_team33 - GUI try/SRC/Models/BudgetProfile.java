//package Models;
//
//import java.io.*;
//import java.util.ArrayList;
//
//import static java.lang.System.out;
//
//public class BudgetProfile extends Budget {
//
//    public BudgetProfile(Integer budget, ArrayList<Transaction> transactions) {
//        super(budget, transactions);
//    }
//
//    public void SaveBudget(String Filename) {
//        try {
//            FileWriter fw = new FileWriter(Filename);
//            PrintWriter pw = new PrintWriter(fw);
//            for (Transaction event : transactions) {
//                pw.println(event);
//
//            }
//            pw.close();
//        } catch (IOException e) {
//            out.println("ERROR");
//        }
//    }
//
//    public Integer LoadBudget(String Filename){
//        ArrayList<String> unparsed = new ArrayList<>();
//        try{
//            FileReader fr = new FileReader(Filename);
//            BufferedReader br = new BufferedReader(fr);
//
//            String str;
//            while ((str = br.readLine()) != null){
//                unparsed.add(str);
//            }
//
//            br.close();
//        } catch (IOException e){
//            out.println("File not found");
//        }
//        Integer parsed = Integer.parseInt(unparsed.get(0));
//        return parsed;
//    }
//
//
//
//}
