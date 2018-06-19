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
public class SOProveraRadnika extends OpstaSO {
    
    private OpstiDomenskiObjekat radnik;
    
    public OpstiDomenskiObjekat getRadnik(){
        return radnik;
    }
    
    @Override
    public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{
        radnik = db.DBBroker.getInstance().pronadjiRadnika(odo);
    }
              
}
