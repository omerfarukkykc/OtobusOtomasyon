package DB;

import Models.Bus;
import java.sql.ResultSet;
import java.util.ArrayList;


public class DBBuses extends DBConnector{
    public DBBuses(){
        super();
    }
    public void addBus(String plaka,int armut){
        sql = "call AddOtobus('"+plaka+"','"+armut+"')";
        this.Save();
    }
    public void delBus(int id){
        sql = "call DelOtobus('"+id+"')";
        
        this.Save();
    }
    public Bus getBus(int id){
        sql = "SELECT * FROM otobusler WHERE otobus_ID ="+id;
        return this.Return().get(0);
    }
    public ArrayList<Bus>getBuses() {
        sql = "call GetOtobusler()";
        return this.Return();
    }
    private ArrayList<Bus> Return(){
       try {
           ResultSet ss = this.stat.executeQuery(sql);
           ArrayList<Bus> mylist = new ArrayList<Bus>();
           while(ss.next()){
               mylist.add(new Bus(
                       ss.getInt("otobus_ID"),
                       ss.getString("plaka"),
                       ss.getInt("koltukSayisi")
               ));
           }
           return mylist;
       } catch (Exception e) {
           System.err.println("DB.DBClients.Return()");
           return null;
       }
    }

    public void upBus(int busID, String text, int valueOf) {
        sql = "UPDATE otobusler SET plaka = '"+text+"', koltukSayisi = "+valueOf+" WHERE otobus_ID = "+busID;
        try {
            this.stat.execute(sql);
        } catch (Exception e) {
            
            System.out.println("DB.DBConnector.Save()");
            
        }
    }

    
}
