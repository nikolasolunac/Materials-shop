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

public class Artikal extends OpstiDomenskiObjekat implements Serializable {

    private int artikalID;
    private String naziv;
    private double cena;
    private String opis;
    private String jedinicaMere;
    
    private TipArtikla tipArtikla;
    
    private String kriterijumPretrage;
    private boolean provera = false;
    
    public Artikal() {
    }

    public Artikal(int artikalID) {
        this.artikalID = artikalID;
    }

    public Artikal(int artikalID, String naziv, double cena, String opis, String jedinicaMere, TipArtikla tipArtikla) {
        this.artikalID = artikalID;
        this.naziv = naziv;
        this.cena = cena;
        this.opis = opis;
        this.jedinicaMere = jedinicaMere;
        this.tipArtikla = tipArtikla;
    }

    public int getArtikalID() {
        return artikalID;
    }

    public void setArtikalID(int artikalID) {
        this.artikalID = artikalID;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getJedinicaMere() {
        return jedinicaMere;
    }

    public void setJedinicaMere(String jedinicaMere) {
        this.jedinicaMere = jedinicaMere;
    }

    public TipArtikla getTipArtikla() {
        return tipArtikla;
    }

    public void setTipArtikla(TipArtikla tipArtikla) {
        this.tipArtikla = tipArtikla;
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
        int hash = 7;
        hash = 41 * hash + this.artikalID;
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
        final Artikal other = (Artikal) obj;
        if (this.artikalID != other.artikalID) {
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
        return "ArtikalID";
    }

    @Override
    public String vratiNazivTabele() {
        return "artikal";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new ArrayList<>();
        try {
            while (rs.next()){
                
                TipArtikla tipartikla = new TipArtikla();
                tipartikla.setTipArtiklaID(rs.getInt("TipArtiklaID"));
                tipartikla.setNaziv(rs.getString("tipartikla.Naziv"));
                
                Artikal artikal = new Artikal();
                artikal.setArtikalID(rs.getInt("ArtikalID"));
                artikal.setNaziv(rs.getString("artikal.Naziv"));
                artikal.setCena(rs.getDouble("Cena"));
                artikal.setOpis(rs.getString("Opis"));
                artikal.setJedinicaMere(rs.getString("JedinicaMere"));
                artikal.setTipArtikla(tipartikla);
                lista.add(artikal);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "artikal INNER JOIN tipartikla ON artikal.TipArtiklaID = tipartikla.TipArtiklaID";
    }        
    

    @Override
    public String vratiUslov() {
        if(!provera){
            try {
                int id = Integer.parseInt(kriterijumPretrage);
                return "ArtikalID= "+id;
            } catch (Exception e) {
                return "artikal.Naziv like '%"+kriterijumPretrage+"%'";
            }
        }
        else{
            return "artikal.Naziv= '"+naziv+"'";
        }
    }

    @Override
    public String vratiVrednostiZaOperacijuSacuvaj() {
        return "artikal.Naziv= '"+naziv+"', artikal.Cena= "+cena+", artikal.Opis= '"+opis+"', artikal.JedinicaMere= '"+jedinicaMere+"', artikal.TipArtiklaID= "+tipArtikla.getTipArtiklaID(); 
    }

    @Override
    public String vratiUslovZaOperacijuSacuvaj() {
        return "ArtikalID= "+artikalID;
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
