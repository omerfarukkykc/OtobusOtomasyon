
package DB;

import Models.County;
import Models.City;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBCities extends DBConnector{
    private String sql;
    public DBCities(){
       super();
    }
    public ArrayList<City> getIller(){
        try {
            sql= "call getIller()";
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<City> mylist = new ArrayList<City>();
            while(ss.next()){
                mylist.add(new City(
                        ss.getInt("il_ID"),
                        ss.getString("ilAdi")
                        ));
            }
            return mylist;
        } catch (Exception e) {
        }
        return null;
    }
    public ArrayList<County> getIlceler(int ilID){
        try {
             sql= "call getIlceler("+ilID+")";
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<County> mylist = new ArrayList<County>();
            while(ss.next()){
                mylist.add(new County(
                        ss.getInt("ilce_ID"),
                        ss.getString("ilceAdi")));
            }
            return mylist;
        } catch (Exception e) {
        }
       return null;
    }
    public int getIlceID(int ilID, String ilce){
        sql ="SELECT ilce_ID FROM ilceler WHERE il_ID = '"+ilID+"' and ilceAdi = '"+ilce+"'";
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            while(ss.next()){
                return ss.getInt("ilce_ID");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public String getIlce(int id) {
        sql ="SELECT * FROM WHERE ilce_ID = '"+id+"'";
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            while(ss.next()){
                return ss.getString("ilceAdi");
            }
        } catch (Exception e) {
            
        }
        return null;
    }
   
}
