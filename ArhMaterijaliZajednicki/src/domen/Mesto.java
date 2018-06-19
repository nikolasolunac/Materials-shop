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

/**
 *
 * @author SOLUNAC
 */

public class Mesto extends OpstiDomenskiObjekat implements Serializable {

    private int mestoID;
    private int ptt;
    private String naziv;
    
    private String kriterijumPretrage;
    private boolean provera = false;

    public Mesto() {
    }

    public Mesto(int mestoID) {
        this.mestoID = mestoID;
    }

    public Mesto(int mestoID, int ptt, String naziv) {
        this.mestoID = mestoID;
        this.ptt = ptt;
        this.naziv = naziv;
    }

    public int getMestoID() {
        return mestoID;
    }

    public void setMestoID(int mestoID) {
        this.mestoID = mestoID;
    }

    public int getPtt() {
        return ptt;
    }

    public void setPtt(int ptt) {
        this.ptt = ptt;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.mestoID;
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
        final Mesto other = (Mesto) obj;
        if (this.mestoID != other.mestoID) {
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
        return "MestoID";
    }

    @Override
    public String vratiNazivTabele() {
        return "mesto";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while(rs.next()){
                Mesto mesto = new Mesto();
                mesto.setMestoID(rs.getInt("mestoID"));
                mesto.setPtt(rs.getInt("ptt"));
                mesto.setNaziv(rs.getString("naziv"));
                lista.add(mesto);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "mesto";
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
