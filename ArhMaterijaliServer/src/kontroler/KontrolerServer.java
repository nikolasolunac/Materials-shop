/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Artikal;
import domen.Kupac;
import domen.Mesto;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.Radnik;
import domen.TipArtikla;
import forme.FmServer;
import java.util.List;
import server.Komunikacija;
import so.OpstaSO;
import so.SOKreiraj;
import so.SOObrisi;
import so.SOPretrazi;
import so.SOProveraRadnika;
import so.SOVratiListu;
import so.SOZapamti;
import so.SOZapamtiRacun;

/**
 *
 * @author SOLUNAC
 */
public class KontrolerServer {
    
    private static KontrolerServer instance;
    private FmServer forma;
    
    public KontrolerServer(){   
    }

    public static KontrolerServer getInstance() {
        if (instance==null){
            instance = new KontrolerServer();
        }
        return instance;  
    }

    public FmServer getForma() {
        return forma;
    }

    public void setForma(FmServer forma) {
        this.forma = forma;
    }
    
    public void pokreniServer (FmServer forma){
        Komunikacija kom = new Komunikacija (forma);
        kom.start();
    }
    //
    public List<OpstiDomenskiObjekat> vratiListuMesta()throws Exception{
        OpstaSO so = new SOVratiListu();
        so.izvrsi(new Mesto());
        return((SOVratiListu) so).getLista();
    }
    //
    public Kupac kreirajKupca() throws Exception{
        OpstaSO so2 = new SOKreiraj();
        so2.izvrsi(new Kupac());
        return new Kupac (((SOKreiraj) so2).getId());
    }
    //
    public void zapamtiKupca(Kupac kupac) throws Exception{
        OpstaSO so = new SOZapamti();
        so.izvrsi(kupac);
    }
    //
    public List<OpstiDomenskiObjekat> pretraziKupce(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Kupac kupac = new Kupac();
        kupac.setKriterijumPretrage(kriterijum);
        so.izvrsi(kupac);
        return((SOPretrazi) so).getLista();
    }
    //
    public void obrisiKupca(String kriterijumBrisanja) throws Exception{
        Kupac kupac = new Kupac();
        kupac.setKriterijumPretrage(kriterijumBrisanja);
        OpstaSO so = new SOObrisi();
        so.izvrsi(kupac);
    }
    //
    public List<OpstiDomenskiObjekat> vratiListuKupaca()throws Exception{
        OpstaSO so = new SOVratiListu();
        so.izvrsi(new Kupac());
        return((SOVratiListu) so).getLista();
    }
    
    public boolean proveriKupca (Kupac kupac) throws Exception{
        OpstaSO so = new SOPretrazi();
        kupac.setProvera(true);
        so.izvrsi(kupac);
        List<OpstiDomenskiObjekat> lista =((SOPretrazi) so).getLista();
        return lista.isEmpty();   
    }
    //
    public void azurirajKupca(Kupac kupac) throws Exception{
        OpstaSO so = new SOZapamti();
        so.izvrsi(kupac);
    }
    //
    public Artikal kreirajArtikal() throws Exception{
        OpstaSO so2 = new SOKreiraj();
        so2.izvrsi(new Artikal());
        return new Artikal (((SOKreiraj) so2).getId());
    }
   //
    public void zapamtiArtikal(Artikal artikal) throws Exception{
        OpstaSO so = new SOZapamti();
        so.izvrsi(artikal);
    }
    //
    public void obrisiArtikal(String kriterijumBrisanja) throws Exception{
        Artikal artikal = new Artikal();
        artikal.setKriterijumPretrage(kriterijumBrisanja);
        OpstaSO so = new SOObrisi();
        so.izvrsi(artikal);
    }
    //
    public List<OpstiDomenskiObjekat> pretraziArtikle(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Artikal artikal = new Artikal();
        artikal.setKriterijumPretrage(kriterijum);
        so.izvrsi(artikal);
        return((SOPretrazi) so).getLista();
    }
    //
    public List<OpstiDomenskiObjekat> vratiListuArtikala()throws Exception{
        OpstaSO so = new SOVratiListu();
        so.izvrsi(new Artikal());
        return((SOVratiListu) so).getLista();
    }
    //
    public List<OpstiDomenskiObjekat> vratiListuTipovaArtikala()throws Exception{
        OpstaSO so = new SOVratiListu();
        so.izvrsi(new TipArtikla());
        return((SOVratiListu) so).getLista();
    }
    
    public boolean proveriArtikal (Artikal artikal) throws Exception{
        OpstaSO so = new SOPretrazi();
        artikal.setProvera(true);
        so.izvrsi(artikal);
        List<OpstiDomenskiObjekat> lista =((SOPretrazi) so).getLista();
        return lista.isEmpty();   
    }
    //
    public Racun kreirajRacun() throws Exception{
        OpstaSO so2 = new SOKreiraj();
        so2.izvrsi(new Racun());
        return new Racun (((SOKreiraj) so2).getId());
    }
    //
    public void zapamtiRacun(Racun racun) throws Exception{
        OpstaSO so = new SOZapamtiRacun();
        so.izvrsi(racun);
    }
    //
    public List<OpstiDomenskiObjekat> pretraziRacune(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Racun racun = new Racun();
        racun.setKriterijumPretrage(kriterijum);
        so.izvrsi(racun);
        return((SOPretrazi) so).getLista();
    }
    //
    public void obrisiRacun(String kriterijumBrisanja) throws Exception{
        Racun racun = new Racun();
        racun.setKriterijumPretrage(kriterijumBrisanja);
        OpstaSO so = new SOObrisi();
        so.izvrsi(racun);
    }
    //
    public OpstiDomenskiObjekat proveraRadnika(Radnik radnik) throws Exception {
        OpstaSO so = new SOProveraRadnika();
        so.izvrsi(radnik);
        return ((SOProveraRadnika) so).getRadnik();
    }
    //
    public List<OpstiDomenskiObjekat> vratiListuRacuna()throws Exception{
        OpstaSO so = new SOVratiListu();
        so.izvrsi(new Artikal());
        return((SOVratiListu) so).getLista();
    }
    //
    public List<OpstiDomenskiObjekat> pretraziRacuneKupca(String kriterijum) throws Exception{
        OpstaSO so = new SOPretrazi();
        Racun racun = new Racun();
        racun.setKriterijumPretrage(kriterijum);
        racun.setRacuniKupca(true);
        so.izvrsi(racun);
        return((SOPretrazi) so).getLista();
    }
    
    
    
}
