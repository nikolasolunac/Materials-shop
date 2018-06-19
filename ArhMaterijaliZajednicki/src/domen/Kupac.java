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

/**
 *
 * @author SOLUNAC
 */

public class Kupac extends OpstiDomenskiObjekat implements Serializable {
    
    private int kupacID;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private Mesto mesto;

    private String kriterijumPretrage;
    private boolean provera = false;
    
    public Kupac() {
    }

    public Kupac(int kupacID) {
        this.kupacID = kupacID;
    }

    public Kupac(int kupacID, String ime, String prezime, String telefon, String email, Mesto mesto) {
        this.kupacID = kupacID;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.mesto = mesto;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
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

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Mesto getMesto() {
        return mesto;
    }

    public void setMesto(Mesto mesto) {
        this.mesto = mesto;
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
        hash = 71 * hash + this.kupacID;
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
        final Kupac other = (Kupac) obj;
        if (this.kupacID != other.kupacID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getIme()+" "+getPrezime();
    }

    @Override
    public String vratiNazivID() {
        return "KupacID";
    }

    @Override
    public String vratiNazivTabele() {
        return "kupac";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        List<OpstiDomenskiObjekat> lista = new LinkedList<>();
        try {
            while (rs.next()){
                
                Mesto mesto = new Mesto();
                mesto.setMestoID(rs.getInt("MestoID"));
                mesto.setPtt(rs.getInt("PTT"));
                mesto.setNaziv(rs.getString("Naziv"));
                
                Kupac kupac = new Kupac();
                kupac.setKupacID(rs.getInt("KupacID"));
                kupac.setIme(rs.getString("Ime"));
                kupac.setPrezime(rs.getString("Prezime"));
                kupac.setTelefon(rs.getString("Telefon"));
                kupac.setEmail(rs.getString("Email"));
                kupac.setMesto(mesto);
                lista.add(kupac);
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "kupac INNER JOIN mesto ON kupac.MestoID = mesto.MestoID";
    }

    @Override
    public String vratiUslov() {
        if(!provera){
            try {
                int id = Integer.parseInt(kriterijumPretrage);
                return "KupacID= "+id;
            } catch (Exception e) {
                return "kupac.Ime like '%"+kriterijumPretrage+"%' OR kupac.Prezime like '%"+kriterijumPretrage+"%' OR kupac.Telefon like '%"+kriterijumPretrage+"%' OR kupac.Email like '%"+kriterijumPretrage+"%'";
            }
        }
        else{
            return "kupac.Ime = '"+ime+"' AND kupac.Prezime = '"+prezime+"' AND kupac.Telefon = '"+telefon+"' AND kupac.Email = '"+email+"' AND kupac.MestoID = "+mesto.getMestoID();
        }
    }

    @Override
    public String vratiVrednostiZaOperacijuSacuvaj() {
        return "kupac.Ime = '"+ime+"', kupac.Prezime = '"+prezime+"', kupac.Telefon = '"+telefon+"', kupac.Email = '"+email+"', MestoID = '"+mesto.getMestoID()+"'";
    }

    @Override
    public String vratiUslovZaOperacijuSacuvaj() {
        return "KupacID= " + kupacID;
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
