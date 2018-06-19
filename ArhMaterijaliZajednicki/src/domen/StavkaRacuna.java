/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author SOLUNAC
 */

public class StavkaRacuna extends OpstiDomenskiObjekat implements Serializable {

    private Racun racunID;
    private int redniBroj;
    private int kolicina;
    private double cena;
    private double vrednost;
    private Artikal artikal;
    
    private String kriterijumPretrage;
    private boolean provera = false;

    public Artikal getArtikal() {
        return artikal;
    }

    public void setArtikal(Artikal artikal) {
        this.artikal = artikal;
    }
    
    public StavkaRacuna() {
    }

    public Racun getRacunID() {
        return racunID;
    }

    public void setRacunID(Racun racunID) {
        this.racunID = racunID;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public boolean isProvera() {
        return provera;
    }

    public void setProvera(boolean provera) {
        this.provera = provera;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + Objects.hashCode(this.racunID);
        hash = 31 * hash + this.redniBroj;
        return hash;
    }

    /*
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StavkaRacuna)) {
            return false;
        }
        StavkaRacuna other = (StavkaRacuna) object;
        if ((this.stavkaRacunaPK == null && other.stavkaRacunaPK != null) || (this.stavkaRacunaPK != null && !this.stavkaRacunaPK.equals(other.stavkaRacunaPK))) {
            return false;
        }
        return true;
    }
    /*
    
    /*
    @Override
    public String toString() {
        return "domen.StavkaRacuna[ RacunId=" + racunID + ", RedniBroj=" + redniBroj + " ]";
    }
    */

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
        final StavkaRacuna other = (StavkaRacuna) obj;
        if (this.redniBroj != other.redniBroj) {
            return false;
        }
        if (!Objects.equals(this.racunID, other.racunID)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "StavkaRacuna{" + "racunID=" + racunID + ", redniBroj=" + redniBroj + '}';
    }

    @Override
    public String vratiNazivID() {
        return "RedniBroj";
    }

    @Override
    public String vratiNazivTabele() {
        return "stavkaracuna";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String vratiFromZaVratiSve() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        return racunID.getRacunID()+", "+redniBroj+", "+kolicina+", "+artikal.getCena()+", "+vrednost+", "+artikal.getArtikalID();
    }

    @Override
    public OpstiDomenskiObjekat ucitajJedan(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       
}
