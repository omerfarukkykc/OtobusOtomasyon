
package Models;


public class Ticket {
    public int bilet_ID;
    public int sefer_ID;
    public double fiyat;
    public int koltuk_ID;
    public int musteri_ID;
    public Ticket(int id,int seferID,double fiyat, int koltukID,int musteriID ){
        this.bilet_ID = id;
        this.sefer_ID = seferID;
        this.fiyat = fiyat;
        this.musteri_ID = musteriID;
        this.koltuk_ID = koltukID;
    }
            
}
