package Models;

import DB.DBClients;


public class Client {
    public int id;
    public String lastname;
    public String tc;
    public String hescode;
    public String firstname;
    public DBClients.Gender gender;
    public Client( int id, String firstname, String lastname, String hesCode, String tc, DBClients.Gender gender){
        this.id = id;
        this.firstname = firstname;
        this.hescode = hesCode;
        this.tc = tc;
        this.lastname = lastname;
        this.gender = gender;
    }
}
