/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so;

import domen.OpstiDomenskiObjekat;
import java.util.List;

/**
 *
 * @author SOLUNAC
 */
public class SOVratiListu extends OpstaSO{
    
    private List <OpstiDomenskiObjekat> lista;

    public List<OpstiDomenskiObjekat> getLista() {
        return lista;
    }
    
    @Override
    public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{
        lista = db.DBBroker.getInstance().vratiSve(odo);
    }
}
