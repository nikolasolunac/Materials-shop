/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontroler;

import domen.Artikal;
import domen.Kupac;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.Radnik;
import forme.FmLogovanje;
import forme.FmPretragaArtikala;
import forme.FmPretragaKupaca;
import forme.FmPretragaRacuna;
import forme.FmUnosArtikla;
import forme.FmUnosKupca;
import forme.FmUnosRacuna;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiTransferObjekat;
import transfer.ServerskiTransferObjekat;

/**
 *
 * @author SOLUNAC
 */
public class KontrolerKlijent {
    
    private Socket socket;
    private int brojPorta;
    private String IPAdresa;
    
    private static KontrolerKlijent instance;
    
    private int aktivan_sk;
    private String kriterijumPretrage = "";

    private Kupac selektovanKupac;
    private Artikal selektovanArtikal;
    private Racun selektovanRacun;

    private FmUnosKupca fmUnosKupca;
    private FmPretragaKupaca fmPretrazivanjeKupaca;
    private FmUnosArtikla fmUnosArtikla;
    private FmPretragaArtikala fmPretrazivanjeArtikala;
    private FmUnosRacuna fmUnosRacuna;
    private FmPretragaRacuna fmPretrazivanjeRacuna;
    private FmLogovanje fmLogovanje;

    public static KontrolerKlijent getInstance() {
        if (instance == null){
            instance = new KontrolerKlijent();
        }
        return instance;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public int getBrojPorta() {
        return brojPorta;
    }

    public void setBrojPorta(int brojPorta) {
        this.brojPorta = brojPorta;
    }

    public String getIPAdresa() {
        return IPAdresa;
    }

    public void setIPAdresa(String IPAdresa) {
        this.IPAdresa = IPAdresa;
    }

    public static void setInstance(KontrolerKlijent instance) {
        KontrolerKlijent.instance = instance;
    }

    public int getAktivan_sk() {
        return aktivan_sk;
    }

    public void setAktivan_sk(int aktivan_sk) {
        this.aktivan_sk = aktivan_sk;
    }

    public String getKriterijumPretrage() {
        return kriterijumPretrage;
    }

    public void setKriterijumPretrage(String kriterijumPretrage) {
        this.kriterijumPretrage = kriterijumPretrage;
    }

    public Kupac getSelektovanKupac() {
        return selektovanKupac;
    }

    public void setSelektovanKupac(Kupac selektovanKupac) {
        this.selektovanKupac = selektovanKupac;
    }

    public Artikal getSelektovanArtikal() {
        return selektovanArtikal;
    }

    public void setSelektovanArtikal(Artikal selektovanArtikal) {
        this.selektovanArtikal = selektovanArtikal;
    }

    public Racun getSelektovanRacun() {
        return selektovanRacun;
    }

    public void setSelektovanRacun(Racun selektovanRacun) {
        this.selektovanRacun = selektovanRacun;
    }

    public FmUnosKupca getFmUnosKupca() {
        return fmUnosKupca;
    }

    public void setFmUnosKupca(FmUnosKupca fmUnosKupca) {
        this.fmUnosKupca = fmUnosKupca;
    }

    public FmPretragaKupaca getFmPretrazivanjeKupaca() {
        return fmPretrazivanjeKupaca;
    }

    public void setFmPretrazivanjeKupaca(FmPretragaKupaca fmPretrazivanjeKupaca) {
        this.fmPretrazivanjeKupaca = fmPretrazivanjeKupaca;
    }

    public FmUnosArtikla getFmUnosArtikla() {
        return fmUnosArtikla;
    }

    public void setFmUnosArtikla(FmUnosArtikla fmUnosArtikla) {
        this.fmUnosArtikla = fmUnosArtikla;
    }

    public FmPretragaArtikala getFmPretrazivanjeArtikala() {
        return fmPretrazivanjeArtikala;
    }

    public void setFmPretrazivanjeArtikala(FmPretragaArtikala fmPretrazivanjeArtikala) {
        this.fmPretrazivanjeArtikala = fmPretrazivanjeArtikala;
    }

    public FmUnosRacuna getFmUnosRacuna() {
        return fmUnosRacuna;
    }

    public void setFmUnosRacuna(FmUnosRacuna fmUnosRacuna) {
        this.fmUnosRacuna = fmUnosRacuna;
    }

    public FmPretragaRacuna getFmPretrazivanjeRacuna() {
        return fmPretrazivanjeRacuna;
    }

    public void setFmPretrazivanjeRacuna(FmPretragaRacuna fmPretrazivanjeRacuna) {
        this.fmPretrazivanjeRacuna = fmPretrazivanjeRacuna;
    }

    public FmLogovanje getFmLogovanje() {
        return fmLogovanje;
    }

    public void setFmLogovanje(FmLogovanje fmLogovanje) {
        this.fmLogovanje = fmLogovanje;
    }
    
    public void poveziSeNaServer() {
        try {
            socket = new Socket(IPAdresa, brojPorta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void posaljiZahtev(KlijentskiTransferObjekat kto) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(kto);
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ServerskiTransferObjekat primiOdgovor() {
        ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            sto = (ServerskiTransferObjekat) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KontrolerKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sto;
    }
    
    public List<OpstiDomenskiObjekat> vratiListuMesta() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_LISTU_MESTA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public Kupac kreirajKupca() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.KREIRAJ_KUPCA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (Kupac) sto.getRezultat();
    }
    
    public void zapamtiKupca(Kupac kupac) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.ZAPAMTI_KUPCA);
        kto.setParametar(kupac);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
    }
    
    public List<OpstiDomenskiObjekat> pretraziKupce(String kriterijum) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.PRETRAZI_KUPCE);
        kto.setParametar(kriterijum);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public void obrisiKupca(String kriterijumBrisanja) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.OBRISI_KUPCA);
        kto.setParametar(kriterijumBrisanja);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }

    }
    
    public List<OpstiDomenskiObjekat> vratiListuKupaca() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_LISTU_KUPACA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }

        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public void azurirajKupca(Kupac kupac) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.AZURIRAJ_KUPCA);
        kto.setParametar(kupac);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
    }
    
    public Artikal kreirajArtikal() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.KREIRAJ_ARTIKAL);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (Artikal) sto.getRezultat();
    }
    
    public void zapamtiArtikal(Artikal artikal) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.ZAPAMTI_ARTIKAL);
        kto.setParametar(artikal);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
    }
    
    public void obrisiArtikal(String kriterijumBrisanja) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.OBRISI_ARTIKAL);
        kto.setParametar(kriterijumBrisanja);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
    }
    
    public List<OpstiDomenskiObjekat> pretraziArtikle(String kriterijum) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.PRETRAZI_ARTIKLE);
        kto.setParametar(kriterijum);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public List<OpstiDomenskiObjekat> vratiListuArtikala() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_LISTU_ARTIKALA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public List<OpstiDomenskiObjekat> vratiListuTipovaArtikala() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_LISTU_TIPOVA_ARTIKALA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public Racun kreirajRacun() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.KREIRAJ_RACUN);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (Racun) sto.getRezultat();
    }

    public void zapamtiRacun(Racun racun) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.ZAPAMTI_RACUN);
        kto.setParametar(racun);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }

    }
    
    public List<OpstiDomenskiObjekat> pretraziRacune(String kriterijum) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.PRETRAZI_RACUNE);
        kto.setParametar(kriterijum);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }

        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public void obrisiRacun(String kriterijumBrisanja) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.OBRISI_RACUN);
        kto.setParametar(kriterijumBrisanja);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
    }
    
    public Radnik pronadjiRadnika(String korisnickoIme, char[] lozinka) throws Exception {
        String sifra = "";
        for (char karakter : lozinka) {
            sifra += karakter;
        }

        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.PRONADJI_RADNIKA);
        Radnik radnik = new Radnik();
        radnik.setKorisnickoIme(korisnickoIme);
        radnik.setLozinka(sifra);
        kto.setParametar(radnik);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (Radnik) sto.getRezultat();
    }
  
    public List<OpstiDomenskiObjekat> vratiListuRacuna() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_LISTU_RACUNA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public List<OpstiDomenskiObjekat> pretraziRacuneKupca(String kriterijum) throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.PRETRAZI_RACUNE_KUPCA);
        kto.setParametar(kriterijum);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (List<OpstiDomenskiObjekat>) sto.getRezultat();
    }
    
    public void odjaviSeSaServera() {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.ODJAVI_SE_SA_SERVERA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);
    }
    
    public Radnik vratiUlogovanogRadnika() throws Exception {
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        kto.setOperacija(util.Util.VRATI_ULOGOVANOG_RADNIKA);
        kontroler.KontrolerKlijent.getInstance().posaljiZahtev(kto);

        ServerskiTransferObjekat sto = kontroler.KontrolerKlijent.getInstance().primiOdgovor();
        if (sto.getStatus() == util.Util.SERVER_STATUS_OPERACIJA_NOT_OK) {
            throw new Exception(sto.getGreska());
        }
        return (Radnik) sto.getRezultat();

    }
    
    public void osveziUkupnuVrednostRacuna() {
        if (fmUnosRacuna != null) {
            fmUnosRacuna.osvezi();
        }
    }
    
    public void osveziTabeluKupaca() {
        if (fmPretrazivanjeKupaca != null) {
            fmPretrazivanjeKupaca.osvezi();
        }
    }   
    
}
