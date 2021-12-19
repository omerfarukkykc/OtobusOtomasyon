
package DB;

import Models.Ticket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBTickets extends DBConnector{
    public DBTickets(){
        super();
    }
    public void addTicket(int seferID,double fiyat,int koltukID,int musteriID){
        sql = "call AddBilet('"+seferID+"','"+fiyat+"','"+koltukID+"','"+musteriID+"')";
        this.Save();
    }
    public Ticket getTicket(int id){
        sql = "call GetBilet("+id+")";
        return this.Return().get(0);
    }
    public void delTicket(int id){
        sql = "call DelBilet("+id+")";
        this.Save();
    }
    private ArrayList<Ticket> Return() {
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<Ticket> mylist = new ArrayList<Ticket>();
            while(ss.next()){
                mylist.add(new Ticket(
                        ss.getInt("bilet_ID"),
                        ss.getInt("seferID"),
                        ss.getFloat("fiyat"),
                        ss.getInt("koltuk_ID"),
                        ss.getInt("musteri_ID")
                ));
            }
            return mylist;
        } catch (Exception e) {
        }
        return null;
    }
}
