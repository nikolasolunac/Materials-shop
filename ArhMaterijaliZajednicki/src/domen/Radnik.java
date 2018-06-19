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

public class Radnik extends OpstiDomenskiObjekat implements Serializable {

    private int radnikID = 1;
    private String ime;
    private String prezime;
    private String korisnickoIme;
    private String lozinka;
    
    private String kriterijumPretrage;
    private boolean provera = false;

    public Radnik() {
    }

    public Radnik(int radnikID) {
        this.radnikID = radnikID;
    }

    public Radnik(int radnikID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.radnikID = radnikID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }

    public int getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(int radnikID) {
        this.radnikID = radnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.radnikID;
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
        final Radnik other = (Radnik) obj;
        if (this.radnikID != other.radnikID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Radnik{" + "radnikID=" + radnikID + '}';
    }

    @Override
    public String vratiNazivID() {
        return "RadnikID";
    }

    @Override
    public String vratiNazivTabele() {
        return "radnik";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while(rs.next()){
                Radnik r = new Radnik();
                r.setRadnikID(rs.getInt("RadnikID"));
                r.setIme(rs.getString("Ime"));
                r.setPrezime(rs.getString("Prezime"));
                r.setKorisnickoIme(rs.getString("KorisnickoIme"));
                r.setLozinka(rs.getString("Lozinka"));
                lista.add(r);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "radnik";
    }

    @Override
    public String vratiUslov() {
        return "KorisnickoIme = '"+korisnickoIme+"' AND Lozinka = '"+lozinka+"'";
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
        OpstiDomenskiObjekat radnik = null;
        
        if(rs.isBeforeFirst()){
            rs.next();
            int radnikID = rs.getInt("RadnikID");
            String ime = rs.getString("Ime");
            String prezime = rs.getString("Prezime");
            String korisnickoIme = rs.getString("KorisnickoIme");
            String lozinka = rs.getString("Lozinka"); 
            radnik = new Radnik (radnikID, ime, prezime, korisnickoIme, lozinka);
        }
        return radnik;
    }
    
    
}
