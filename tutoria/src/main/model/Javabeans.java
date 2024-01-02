package main.model;

public class Javabeans {
    private int idnumber;
    private String  name;
    private String number;
    private String email;
    public Javabeans(){

    }
    public Javabeans(int idnumber, String  name, String number, String email){
        this.idnumber = idnumber;
        this.name = name;
        this.number = number;
        this.email = email;
    }

    public void setIdnumber(int idnumber) {
        this.idnumber = idnumber;
    }

    public int getIdnumber() {
        return idnumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
