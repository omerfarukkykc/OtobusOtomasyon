
package Models;

import java.util.Date;


public class Voyage {
    public int seferID;
    public Date kalkisTarih;
    public Date varisTarih;
    public int kalkisYerID;
    public int varisYerID;
    public int otobusID;
    
    public Voyage(int seferID,Date kalkisTarih,Date varisTarih, int kalkisYer,int varisYer,int otobusID){
        this.seferID = seferID;
        this.kalkisTarih = kalkisTarih;
        this.varisTarih = varisTarih;
        this.kalkisYerID = kalkisYer;
        this.varisYerID = varisYer;
        this.otobusID = otobusID;
    }
    
    
}
