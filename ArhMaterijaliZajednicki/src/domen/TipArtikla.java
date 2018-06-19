/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */

public class TipArtikla extends OpstiDomenskiObjekat implements Serializable {

    private int tipArtiklaID;
    private String naziv;

    public TipArtikla() {
    }

    public TipArtikla(int tipArtiklaID) {
        this.tipArtiklaID = tipArtiklaID;
    }

    public TipArtikla(int tipArtiklaID, String naziv) {
        this.tipArtiklaID = tipArtiklaID;
        this.naziv = naziv;
    }

    public int getTipArtiklaID() {
        return tipArtiklaID;
    }

    public void setTipArtiklaID(int tipArtiklaID) {
        this.tipArtiklaID = tipArtiklaID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.tipArtiklaID;
        hash = 37 * hash + Objects.hashCode(this.naziv);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipArtikla other = (TipArtikla) obj;
        if (this.tipArtiklaID != other.tipArtiklaID) {
            return false;
        }
        if (!Objects.equals(this.naziv, other.naziv)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNaziv();
    }

    @Override
    public String vratiNazivID() {
        return "TipArtiklaID";
    }

    @Override
    public String vratiNazivTabele() {
        return "tipartikla";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try{
            while(rs.next()){
                TipArtikla tipartikla = new TipArtikla();
                tipartikla.setTipArtiklaID(rs.getInt("TipArtiklaID"));
                tipartikla.setNaziv(rs.getString("Naziv"));
                lista.add(tipartikla);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "tipartikla";
    }

    @Override
    public String vratiUslov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaOperacijuSacuvaj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiUslovZaOperacijuSacuvaj() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiVrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
