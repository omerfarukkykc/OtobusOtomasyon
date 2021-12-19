package yolcurezevasyon;

import DB.DBBuses;
import DB.DBCities;
import DB.DBClients;
import DB.DBTickets;
import java.sql.SQLException;


public class YolcuRezevasyon {

    
    public static void main(String[] args) throws SQLException {
       DBTickets tic = new DBTickets();
       tic.addTicket(1, 45.6, 2, 1);
        System.out.println("yolcurezevasyon.YolcuRezevasyon.main()"+tic.getTicket(5).fiyat);
//        
//        ArrayList<User> users = userc.getUsers();
//        NewJFrame form= new NewJFrame();
//        DefaultTableModel model =(DefaultTableModel)NewJFrame.jTable1.getModel();
//        for(User user : users){
//            model.addRow(new Object[]{user.firstname,user.lastname,user.username,user.password});
//        }
        
        
        
        
        
               
       
       
       
       
    }
    
}
