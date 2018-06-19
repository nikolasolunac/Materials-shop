/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOLUNAC
 */

public class Racun extends OpstiDomenskiObjekat implements Serializable {

    private int racunID;
    private Date datum;
    private double vrednost;
    private Kupac kupacID;
    private Radnik radnikID;
    private List<StavkaRacuna> listaStavki;
    
    private String kriterijumPretrage;
    private boolean racuniKupca = false;  

    public Racun() {
        listaStavki = new ArrayList();
    }

    public Racun(int racunID, Date datum, double vrednost, Radnik radnik, Kupac kupac, List<StavkaRacuna> listaStavki) {
        this.racunID = racunID;
        this.datum = datum;
        this.vrednost = vrednost;
        this.radnikID = radnik;
        this.kupacID = kupac;
        this.listaStavki = listaStavki;
    }

    public Racun(int racunID) {
        this.racunID = racunID;
        listaStavki = new ArrayList();
    }
    
    /*
    SimpleDateFormat simpDate = new SimpleDateFormat("dd-MM-yyyy");
    java.util.Date today = new Date();
    java.sql.Date date = new java.sql.Date(today.getTime()); 
    System.out.println(simpDate.format(date)); 
    
    DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
    Date date=new Date();
    String s=df.format(date);
    System.out.println(s);
    */

    public int getRacunID() {
        return racunID;
    }
    
    public void setRacunID(int racunID) {
        this.racunID = racunID;
    }

    public Date getDatum() {
        Date datum = new Date();
        return datum;
    }

    public void setDatum(Date datum) {
        this.datum = datum;
    }

    public double getVrednost() {
        return vrednost;
    }

    public void setVrednost(double vrednost) {
        this.vrednost = vrednost;
    }

    public Kupac getKupacID() {
        return kupacID;
    }

    public void setKupacID(Kupac kupacID) {
        this.kupacID = kupacID;
    }

    public Radnik getRadnikID() {
        return radnikID;
    }

    public void setRadnikID(Radnik radnikID) {
        this.radnikID = radnikID;
    }

    public List<StavkaRacuna> getListaStavki() {
        return listaStavki;
    }

    public void setListaStavki(List<StavkaRacuna> listaStavki) {
        this.listaStavki = listaStavki;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public boolean isRacuniKupca() {
        return racuniKupca;
    }

    public void setRacuniKupca(boolean racuniKupca) {
        this.racuniKupca = racuniKupca;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + this.racunID;
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
        final Racun other = (Racun) obj;
        if (this.racunID != other.racunID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Racun{" + "racunID=" + racunID + ", datum=" + datum + ", vrednost=" + vrednost + ", radnik=" + radnikID + ", kupac=" + kupacID + ", listaStavki=" + listaStavki + '}';
    }

    @Override
    public String vratiNazivID() {
        return "RacunID";
    }

    @Override
    public String vratiNazivTabele() {
        return "racun";
    }

    @Override
    public List<OpstiDomenskiObjekat> vratiListu(ResultSet rs) throws SQLException {
        try {
            List<OpstiDomenskiObjekat> lista = new LinkedList<>();
            boolean pom = rs.next();
            while (pom) {

                Kupac k = new Kupac();
                k.setKupacID(rs.getInt("kupac.KupacID"));

                Radnik r = new Radnik();
                r.setRadnikID(rs.getInt("radnik.RadnikID"));

                Racun racun = new Racun();
                int racID = rs.getInt("racun.RacunID");
                racun.setRacunID(racID);
                racun.setDatum(new java.util.Date(rs.getDate("racun.Datum").getTime()));
                racun.setVrednost(rs.getDouble("racun.Vrednost"));
                racun.setKupacID(k);
                racun.setRadnikID(r);

                while (pom && rs.getInt("racun.RacunID") == racID) {

                    TipArtikla ta = new TipArtikla();
                    ta.setTipArtiklaID(rs.getInt("TipArtiklaID"));
                    ta.setNaziv(rs.getString("tipartikla.Naziv"));

                    Artikal a = new Artikal();
                    a.setArtikalID(rs.getInt("artikal.ArtikalID"));
                    a.setNaziv(rs.getString("artikal.Naziv"));
                    a.setCena(rs.getDouble("artikal.Cena"));
                    a.setOpis(rs.getString("Opis"));
                    a.setJedinicaMere(rs.getString("JedinicaMere"));
                    a.setTipArtikla(ta);

                    StavkaRacuna sr = new StavkaRacuna();
                    sr.setRedniBroj(rs.getInt("stavkaracuna.RedniBroj"));
                    sr.setRacunID(racun);
                    sr.setArtikal(a);
                    sr.setKolicina(rs.getInt("stavkaracuna.Kolicina"));
                    sr.setCena(rs.getDouble("stavkaracuna.Cena"));
                    sr.setVrednost(rs.getDouble("stavkaracuna.Vrednost"));

                    racun.getListaStavki().add(sr);
                    if (!rs.next()) {
                        pom = false;
                    }
                }

                lista.add(racun);
            }
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(Artikal.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
    }

    @Override
    public String vratiFromZaVratiSve() {
        return "racun INNER JOIN kupac ON racun.KupacID = kupac.KupacID "
                + "INNER JOIN radnik ON racun.RadnikID = radnik.RadnikID "
                + "INNER JOIN stavkaracuna ON racun.RacunID = stavkaracuna.RacunID "
                + "INNER JOIN artikal ON stavkaracuna.ArtikalID = artikal.ArtikalID "
                + "INNER JOIN tipartikla ON artikal.TipArtiklaID = tipartikla.TipArtiklaID";
    }

    @Override
    public String vratiUslov() {
        
        try {
            if(!racuniKupca){
            int id = Integer.parseInt(kriterijumPretrage);
            return "racun.RacunID= " + id;
            } else {
             int id = Integer.parseInt(kriterijumPretrage);
             return "kupac.KupacID= " + id;       
            }
        } catch (Exception e) {
            Date datum = null;
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

            try {
                datum = sdf.parse(kriterijumPretrage);
            } catch (ParseException ex) {
                Logger.getLogger(Racun.class.getName()).log(Level.SEVERE, null, ex);
            }
            return "Datum = '" + new java.sql.Date(datum.getTime()) + "'";

        }
    }

    @Override
    public String vratiVrednostiZaOperacijuSacuvaj() {
        return "Datum = '" + new java.sql.Date(datum.getTime()) + "', Vrednost = " + vrednost + ", RadnikID = " + radnikID.getRadnikID() + ", KupacID = " + kupacID.getKupacID();
    }

    @Override
    public String vratiUslovZaOperacijuSacuvaj() {
        return "RacunID = " +racunID;
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
