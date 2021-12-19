package yolcurezevasyon;

import DB.DBCities;
import DB.DBClients;
import java.sql.SQLException;


public class YolcuRezevasyon {

    
    public static void main(String[] args) throws SQLException {
        DBCities Sehirler = new DBCities();
        DBClients clients = new DBClients();
        clients.deleteClient(9);
        
        NewJFrame form= new NewJFrame();
        
//        
//        ArrayList<User> users = userc.getUsers();
//        NewJFrame form= new NewJFrame();
//        DefaultTableModel model =(DefaultTableModel)NewJFrame.jTable1.getModel();
//        for(User user : users){
//            model.addRow(new Object[]{user.firstname,user.lastname,user.username,user.password});
//        }
        
        
        
        
        
               
       
       
       
       
    }
    
}
