package Models;

import Observer.ResponsibilityObserver;

public class Contact implements ResponsibilityObserver{
    String name;
    String phonenumber;
    String email;


    public  Contact(String Name,String phonenumber,String email){
        this.name = Name;
        this.phonenumber = phonenumber;
        this.email = email;
    }

    public void update(String s){
        System.out.println("Your contact has added a new event: "+s);
    }

}
