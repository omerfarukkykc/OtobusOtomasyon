/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

/**
 *
 * @author omert
 */
public class DB {
    public DBBuses buses;
    public DBCities cities;
    public DBClients clients;
    public DBTickets tickets;
    public DBVoyages voyages;
    
    public DB() {
        buses = new DBBuses();
        cities = new DBCities();
        clients = new DBClients();
        tickets = new DBTickets();
        voyages = new DBVoyages();
    }
    public void refreshConn(){
        buses = new DBBuses();
        cities = new DBCities();
        clients = new DBClients();
        tickets = new DBTickets();
        voyages = new DBVoyages();
    }
}
