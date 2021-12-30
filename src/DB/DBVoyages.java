package DB;

import Models.Client;
import Models.Voyage;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class DBVoyages extends DBConnector{
    public DBVoyages(){
        super();
    }
    public void addVoyage(Date kalkisTarih,Date varisTarih,int kyd,int vyd,int otobusID){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sql = "call AddSefer('"+format.format(kalkisTarih)+"','"+format.format(varisTarih)+"','"+kyd+"','"+vyd+"','"+otobusID+"')";  
        this.Save();
    }
    public Voyage getVoyage(int id){
        sql = "SELECT * FROM seferler WHERE sefer_ID = "+id;
        return this.ReturnVoyages().get(0);
    }
    
    public ArrayList<Voyage> getVoyages(Date basla,Date bitir,int kid,int vid){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sql = "call GetSeferler('"+format.format(basla)+"','"+format.format(bitir)+"','"+kid+"','"+vid+"')"; 
        return this.ReturnVoyages();
    }
    public ArrayList<Client> getClients(int id){
        sql = "call GetYolcular('"+id+"')";
        return this.ReturnClients();
    }
    public void getBusInfo(){
        
    }
    private ArrayList<Client> ReturnClients(){
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
                        DBClients.Gender.valueOf(ss.getString("cinsiyeti"))
                ));
            }
            return mylist;
        } catch (Exception e) {
            System.err.println("DB.DBClients.Return()");
            return null;
        }
    }
    private ArrayList<Voyage> ReturnVoyages(){
        try {
            ResultSet ss = this.stat.executeQuery(sql);
            ArrayList<Voyage> mylist = new ArrayList<Voyage>();
            while(ss.next()){
                mylist.add(new Voyage(
                        ss.getInt("sefer_ID"),
                        ss.getDate("kalkisTarih"),
                        ss.getDate("varisTarih"),
                        ss.getInt("kalkisYer_ID"),
                        ss.getInt("varisYer_ID"),
                        ss.getInt("otobus_ID")
                ));
            }
            return mylist;
        } catch (Exception e) {
            System.err.println("DB.DBVoyages.ReturnVoyages()");
            return null;
        }
    }
    public Date createDate(int year,int month,int day){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
       return cal.getTime();
    }

    public void delVoayage(int i) {
        sql = "call DelVoyage('"+i+"')";
        this.Save();
    }
    
}
