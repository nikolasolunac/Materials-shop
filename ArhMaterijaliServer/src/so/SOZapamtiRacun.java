/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import domen.Racun;
import domen.StavkaRacuna;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author SOLUNAC
 */
public class SOZapamtiRacun extends OpstaSO{

    @Override
    public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{     
        Racun racun = (Racun) odo;
        postaviRedneBrojeveStavkeRacuna(racun);
        db.DBBroker.getInstance().sacuvaj(racun);
        for (StavkaRacuna sr : racun.getListaStavki()) {
            db.DBBroker.getInstance().ubaciSvePodatke(sr);
        }
    }

    private void postaviRedneBrojeveStavkeRacuna(Racun racun) throws IOException, ClassNotFoundException, SQLException {
        int rb = db.DBBroker.getInstance().vratiPoslednjiID(new StavkaRacuna()) + 1;
        for (StavkaRacuna sr : racun.getListaStavki()) {
            sr.setRedniBroj(rb);
            rb++;
        }
    }      
}
