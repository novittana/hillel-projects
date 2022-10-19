import util.Util;

import java.text.DateFormat;
import java.util.ArrayList;

public class User {
    protected Integer id;
    protected String name;
    protected String lastName;
    protected String email;
    protected String password;
    protected String country;
    protected String birthday;
    protected ArrayList<Auto> autoList = new ArrayList<Auto>();

    public User(String email, String password) {
        this.init("not set", "not set", email, password);
    }

    public User(String name, String lastName, String email, String password) {
        this.init(name, lastName, email, password);
    }

    protected void init(String name, String lastName, String email, String password) {
        System.out.println("//=====CREATING NEW USER=====//");
        this.id = Util.getId();
        this.name = name;
        this.lastName = lastName;
        System.out.println("Checking user email");
        if (Util.isEmailValid(email) == false) {
            System.out.println("Email is invalid - " + email);
        } else {
            System.out.println("Email is valid");
        }
        this.email = email;
        this.password = password;
        this.country = "not set";
        this.birthday = "not set";
    }
    public void setCountry(String value) {
        this.country = value;
    }

    public void setBirthday(String value) {
        this.birthday = value;
    }

    public void addAuto(Auto value) {
        this.autoList.add(value);
    }
    public void showInfo() {
        System.out.println("//-------USER------//");
        System.out.println("Id - " + this.id);
        System.out.println("Name - " + this.name);
        System.out.println("Last name - " + this.lastName);
        System.out.println("Email - " + this.email);
        System.out.println("Password - " + this.password);
        System.out.println("Country - " + this.country);
        System.out.println("Birthday - " + this.birthday);
        if (this.autoList.size() == 0) {
            System.out.println("Auto list is empty");
        } else {
            System.out.println("\t\t//--AUTO_LIST--//");
            for (int i = 0; i<this.autoList.size();i++) {
                System.out.println("\t\t");
                this.autoList.get(i).showInfo();
            }
        }
        System.out.println("//-----------------//");
        System.out.println();
        System.out.println();
        System.out.println();
    }
}

