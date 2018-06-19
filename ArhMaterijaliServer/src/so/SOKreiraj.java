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
public class SOKreiraj extends OpstaSO {
    
   private int id;
   
   public int getId(){
       return id;
   }
   
   @Override
   public void izvrsiKonkretnuOperaciju (OpstiDomenskiObjekat odo) throws Exception{
       id = db.DBBroker.getInstance().vratiPoslednjiID(odo)+1;
       odo.setId(id);
       db.DBBroker.getInstance().kreiraj(odo);
   }
   

}
