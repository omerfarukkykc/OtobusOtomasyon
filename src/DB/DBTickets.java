
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
    public void delTicket(int customer_ID,int voyageID){
        sql = "DELETE FROM biletler WHERE seferID = "+voyageID+" and musteri_ID = "+customer_ID;
        try {
            this.stat.execute(sql);
        } catch (Exception e) {
            
            System.out.println("DB.DBConnector.Save()");
            
        }
    }
    public void UpTicket(int id,int seferID,double fiyat,int koltukID,int musteriID){
        sql = "call UpBilet('"+id+"','"+seferID+"','"+fiyat+"','"+koltukID+"','"+musteriID+"')";
        this.Save();
    }
    public int getChairNumber(int customerID,int voyageID){
        sql = "SELECT koltuk_ID FROM biletler WHERE seferID = "+voyageID+" and musteri_ID = "+customerID;
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            while(ss.next()){
                return ss.getInt("koltuk_ID");
            }
        } catch (Exception e) {
            System.out.println("DB.DBTickets.getChairNumber()");
        }
        return -1;
    }
    public int getTicketID(int customerID,int voyageID){
        sql = "SELECT bilet_ID FROM biletler WHERE seferID = "+voyageID+" and musteri_ID = "+customerID;
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            while(ss.next()){
                return ss.getInt("bilet_ID");
            }
        } catch (Exception e) {
            System.out.println("DB.DBTickets.getTicketID()");
        }
        return -1;
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

    public ArrayList<Integer> getChairNumbers(int sefer_ID) {
        sql = "SELECT * FROM biletler WHERE seferID ="+sefer_ID;
         try {
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<Integer> mylist = new ArrayList<Integer>();
            while(ss.next()){
                mylist.add(
                        ss.getInt("koltuk_ID")
                );
            }
            return mylist;
        } catch (Exception e) {
        }
        return null;
    }

    public double getPrice(int userid, int sefer_ID) {
          sql = "SELECT fiyat FROM biletler WHERE seferID = "+sefer_ID+" and musteri_ID = "+userid;
         try {
            ResultSet ss = this.stat.executeQuery(sql);
            while(ss.next()){
                return ss.getDouble("fiyat");
            }
            
        } catch (Exception e) {
             System.out.println("DB.DBTickets.getPrice()");
        }
        return -1;
    }
}
