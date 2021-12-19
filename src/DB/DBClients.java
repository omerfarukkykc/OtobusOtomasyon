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
    public DBClients() throws SQLException  {
       super();
    }
    public void addClient(String firstName, String lastName,String tc,String hesCode,Gender gender){
        sql= "call AddMusteri('"+firstName+"','"+lastName+"','"+tc+"','"+hesCode+"','"+gender.name()+"')";
        this.Save();
    }
    public Client getClient(int id) throws SQLException{
        sql= "CALL GetMusteri("+id+")";
        return this.Return().get(0);
    }
    public ArrayList<Client> getClients() throws SQLException{
        sql= "CALL GetMusteriler()";
        return this.Return();
    }
    public void updateClient(){
        
    }
    public void deleteClient(int id){
        sql= "CALL DelMusteri("+id+")";
        this.Save();
    }
    
    private ArrayList<Client> Return() throws SQLException{
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
    }
}
