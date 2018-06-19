/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SOLUNAC
 */
public abstract class OpstiDomenskiObjekat {
    
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public int vratiVrednostPrimarnogKljuca() {
        return id;
    }
    
    public abstract String vratiNazivID();
    
    public abstract String vratiNazivTabele();
    
    public abstract List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException;
    
    public abstract String vratiFromZaVratiSve();
    
    public abstract String vratiUslov();
    
    public abstract String vratiVrednostiZaOperacijuSacuvaj();
    
    public abstract String vratiUslovZaOperacijuSacuvaj();
    
    public abstract String vratiVrednostiZaInsert();
    
    public abstract OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws SQLException;
    
}
