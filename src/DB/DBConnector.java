package DB;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnector {
    private final String DB_URL = "jdbc:mysql://localhost/otobusotomasyon";
    private final String USERNAME = "root";
    private final String PASSWORD = "1234";
    Connection conn = null;
    Statement stat = null;
    public DBConnector(){
        try {
            conn = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            stat = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
