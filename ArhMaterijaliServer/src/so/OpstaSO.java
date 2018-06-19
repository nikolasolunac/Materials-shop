/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author SOLUNAC
 */
public abstract class OpstaSO {
    
    public void izvrsi (OpstiDomenskiObjekat odo) throws Exception{
        try{
            proveriPreduslov(odo);
            izvrsiKonkretnuOperaciju(odo);
            potvrdi();
        }catch(Exception ex){
            ponisti();
            throw new Exception ("Greska kod izvrsenja SO: " +ex.getMessage());
        }
    }
    
    public void proveriPreduslov (OpstiDomenskiObjekat odo) throws Exception{
        
    }
    
    public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{
        
    }
    
    public void potvrdi() throws IOException, ClassNotFoundException, SQLException, Exception{
        db.DBBroker.getInstance().potvrdiTransakciju();
    }
    
    public void ponisti() throws IOException, ClassNotFoundException, SQLException, Exception{
        db.DBBroker.getInstance().ponistiTransakciju();
    }
    
}
