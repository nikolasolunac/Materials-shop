/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;

/**
 *
 * @author SOLUNAC
 */
public class SOObrisi extends OpstaSO{
    
    @Override
    public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{
        db.DBBroker.getInstance().obrisi(odo);
        
    }
}
