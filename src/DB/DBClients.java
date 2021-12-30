package DB;

import Models.Client;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DBClients extends DBConnector{

    
    public enum Gender{
        KADIN,
        ERKEK
    }
    private String sql;
    public DBClients() {
       super();
    }
    public int getLastClientID() {
        sql = "SELECT musteri_ID FROM musteriler ORDER BY musteri_ID DESC LIMIT 1";
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            while (ss.next()) {
                return ss.getInt("musteri_ID");
            }
        } catch (Exception e) {
        }
        return -1;
    }
    public void addClient(String firstName, String lastName,String tc,String hesCode,Gender gender){
        sql= "call AddMusteri('"+firstName+"','"+lastName+"','"+tc+"','"+hesCode+"','"+gender.name()+"')";
        try {
            this.stat.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public Client getClient(int id){
        sql= "CALL GetMusteri("+id+")";
        return this.Return().get(0);
    }
    public ArrayList<Client> getClients(){
        sql= "CALL GetMusteriler()";
        return this.Return();
    }
    public void updateClient(int id,String firstName, String lastName,String tc,String hesCode,String gender){
        sql =  "UPDATE musteriler SET adi ='"+firstName+"',soyadi = '"+lastName+"',tc = '"+tc+"', hesKodu = '"+hesCode+"',cinsiyeti = '"+gender+"' WHERE musteri_ID = "+id;
        try {
             this.stat.execute(sql);
         } catch (Exception e) {

             System.out.println("DB.DBClients.updateClient()");

         }
     }
    public void deleteClient(int id){
        sql= "CALL DelMusteri("+id+")";
        try {
            this.stat.execute(sql);
        } catch (Exception e) {
            
            System.out.println("DB.DBConnector.Save()");
            
        }
    }
    
    private ArrayList<Client> Return(){
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<Client> mylist = new ArrayList<Client>();
            while(ss.next()){
                mylist.add(new Client(
                        ss.getInt("musteri_ID"),
                        ss.getString("adi"),
                        ss.getString("soyadi"),
                        ss.getString("tc"),
                        ss.getString("hesKodu"),
                        Gender.valueOf(ss.getString("cinsiyeti"))
                ));
            }
            return mylist;
        } catch (Exception e) {
            System.err.println("DB.DBClients.Return()");
            return null;
        }
    }
}
