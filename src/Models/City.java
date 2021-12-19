package Models;

import DB.DBCities;
import java.util.ArrayList;

public class City {
    public int id;
    public String name;
    public City(int id, String ilAdi){
        this.id = id;
        this.name = ilAdi;
       
    }

    public ArrayList<County> getIlceler(){
       DBCities db = new DBCities();
       return db.getIlceler(this.id);
    }
    
    
}

