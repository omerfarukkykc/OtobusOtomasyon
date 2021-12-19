package DB;


public class DBBuses extends DBConnector{
    private final int defalutChairCount = 31;
    public DBBuses(){
        super();
    }
    public void addBus(String plaka){
        sql = "call AddOtobus('"+plaka+"','"+defalutChairCount+"')";
        this.Save();
    }
    public void delBus(int id){
        sql = "call DelOtobus('"+id+"')";
        this.Save();
    }
}
