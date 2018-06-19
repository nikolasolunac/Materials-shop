/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;


import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author SOLUNAC
 */
public class DBBroker {
    
    private static DBBroker instance;
    private Connection connection;
    
    private DBBroker() throws IOException, ClassNotFoundException, SQLException{
        
        String driver = Util.getInstance().get("driver");
        Class.forName(driver);
        System.out.println("Driver je ucitan!");
        connection = DriverManager.getConnection(Util.getInstance().get("url"), Util.getInstance().get("username"), Util.getInstance().get("password"));
        System.out.println("Konekcija je uspostavljena!");
        connection.setAutoCommit(false);
        
    }

    public static DBBroker getInstance() throws IOException, ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new DBBroker();
        }
        return instance;
    }
       
    public void potvrdiTransakciju() {
        try {
            connection.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public void ponistiTransakciju() {
        try {
            connection.rollback();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM " + odo.vratiFromZaVratiSve();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.vratiListu(rs);
    }
    
    public int vratiPoslednjiID(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT MAX(" +odo.vratiNazivID()+ ") AS MAX FROM " + odo.vratiNazivTabele();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        rs.next();
        return rs.getInt("MAX");
    }
    
    public List<OpstiDomenskiObjekat> vratiSaUslovom(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM " +odo.vratiFromZaVratiSve()+ " WHERE " +odo.vratiUslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.vratiListu(rs);
    }
    
    public void kreiraj (OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "INSERT INTO " +odo.vratiNazivTabele()+ " (" +odo.vratiNazivID()+ ") VALUES (" +odo.vratiVrednostPrimarnogKljuca()+ ")";
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    
    public void sacuvaj (OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaOperacijuSacuvaj() + " WHERE " + odo.vratiUslovZaOperacijuSacuvaj();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    
    public void obrisi (OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "DELETE FROM " +odo.vratiNazivTabele()+ " WHERE " +odo.vratiUslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
   
    public void ubaciSvePodatke (OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "INSERT INTO " +odo.vratiNazivTabele()+ " VALUES (" +odo.vratiVrednostiZaInsert()+ ")";
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }
    
    public OpstiDomenskiObjekat pronadjiRadnika(OpstiDomenskiObjekat odo) throws SQLException{
        String upit = "SELECT * FROM "+ odo.vratiNazivTabele() + " WHERE " + odo.vratiUslov();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return odo.ucitajJedan(rs);   
    }

}
