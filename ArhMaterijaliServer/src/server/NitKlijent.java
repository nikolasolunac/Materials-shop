/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import domen.Artikal;
import domen.Kupac;
import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.Radnik;
import gui.komponente.ModelTabeleKorisnici;
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
public class NitKlijent extends Thread{
    
    private Socket socket;
    private boolean aktivan;
    private Radnik radnik;
    private Komunikacija kom;

    public NitKlijent(Socket socket, Komunikacija kom) {
        this.socket = socket;
        aktivan = true;
        this.kom = kom;
    }
    
    @Override
    public void run(){
        while(aktivan){
            try {
                KlijentskiTransferObjekat kto = primiZahtev();
                ServerskiTransferObjekat sto = new ServerskiTransferObjekat();
                switch(kto.getOperacija()){
                    case util.Util.VRATI_LISTU_MESTA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().vratiListuMesta();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.KREIRAJ_KUPCA:{
                        try {
                            Kupac rez = kontroler.KontrolerServer.getInstance().kreirajKupca();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.ZAPAMTI_KUPCA:{
                        try {
                            boolean tacno = kontroler.KontrolerServer.getInstance().proveriKupca((Kupac) kto.getParametar());
                            if(tacno){
                                kontroler.KontrolerServer.getInstance().zapamtiKupca((Kupac) kto.getParametar());
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            }
                            else {
                                throw new Exception (util.Util.VEC_POSTOJI_PORUKA);
                            }
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.PRETRAZI_KUPCE:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().pretraziKupce((String) kto.getParametar());
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.AZURIRAJ_KUPCA:{
                        try {
                            kontroler.KontrolerServer.getInstance().azurirajKupca((Kupac) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.OBRISI_KUPCA:{
                        try {
                        kontroler.KontrolerServer.getInstance().obrisiKupca((String) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.VRATI_LISTU_KUPACA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().vratiListuKupaca();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.KREIRAJ_ARTIKAL:{
                        try {
                            Artikal rez = kontroler.KontrolerServer.getInstance().kreirajArtikal();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.ZAPAMTI_ARTIKAL:{
                        try {
                            boolean tacno = kontroler.KontrolerServer.getInstance().proveriArtikal((Artikal) kto.getParametar());
                            if(tacno){
                                kontroler.KontrolerServer.getInstance().zapamtiArtikal((Artikal) kto.getParametar());
                                sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            }
                            else {
                                throw new Exception (util.Util.VEC_POSTOJI_PORUKA);
                            }
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.PRETRAZI_ARTIKLE:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().pretraziArtikle((String) kto.getParametar());
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                            
                    case util.Util.VRATI_LISTU_ARTIKALA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().vratiListuArtikala();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;    
                    
                    case util.Util.KREIRAJ_RACUN:{
                        try {
                            Racun rez = kontroler.KontrolerServer.getInstance().kreirajRacun();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);                    
                    }
                    break;
                    
                    case util.Util.ZAPAMTI_RACUN:{
                        try {
                            kontroler.KontrolerServer.getInstance().zapamtiRacun((Racun) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.PRETRAZI_RACUNE:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().pretraziRacune((String) kto.getParametar());
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);                                                
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.OBRISI_RACUN:{
                        try {
                            kontroler.KontrolerServer.getInstance().obrisiRacun((String) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.PRONADJI_RADNIKA:{
                        try {
                            OpstiDomenskiObjekat rez = kontroler.KontrolerServer.getInstance().proveraRadnika((Radnik) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(rez);
                            ((ModelTabeleKorisnici) kontroler.KontrolerServer.getInstance().getForma().getJtblKorisnici().getModel()).dodajKorisnika(radnik);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.VRATI_ULOGOVANOG_RADNIKA:{
                        try {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                            sto.setRezultat(radnik);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.OBRISI_ARTIKAL:{
                        try {
                            kontroler.KontrolerServer.getInstance().obrisiArtikal((String) kto.getParametar());
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.VRATI_LISTU_TIPOVA_ARTIKALA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().vratiListuTipovaArtikala();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break; 
                    
                    case util.Util.VRATI_LISTU_RACUNA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().vratiListuRacuna();
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        }
                        posaljiOdgovor(sto);
                    }
                    break; 
                    
                    case util.Util.PRETRAZI_RACUNE_KUPCA:{
                        try {
                            List<OpstiDomenskiObjekat> rez = kontroler.KontrolerServer.getInstance().pretraziRacuneKupca((String) kto.getParametar());
                            sto.setRezultat(rez);
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_OK);                                                
                        } catch (Exception e) {
                            sto.setStatus(util.Util.SERVER_STATUS_OPERACIJA_NOT_OK);
                            sto.setGreska(e.getMessage());
                        } 
                        posaljiOdgovor(sto);
                    }
                    break;
                    
                    case util.Util.ODJAVI_SE_SA_SERVERA:{
                        socket.close();
                        aktivan = false;
                        ((ModelTabeleKorisnici) kontroler.KontrolerServer.getInstance().getForma().getJtblKorisnici().getModel()).obrisiKorisnika(radnik);
                    }
                    break;                                      
                }               
            } catch (Exception e) {
            }
        }
    } 
    
    public KlijentskiTransferObjekat primiZahtev(){
        KlijentskiTransferObjekat kto = new KlijentskiTransferObjekat();
        try {
            ObjectInputStream in = new ObjectInputStream (socket.getInputStream());
            kto = (KlijentskiTransferObjekat) in.readObject();
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kto;       
    }
    
    public void posaljiOdgovor(ServerskiTransferObjekat sto){
        try {
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(sto);
        } catch (IOException ex) {
            Logger.getLogger(NitKlijent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
