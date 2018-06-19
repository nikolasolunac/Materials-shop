/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Kupac;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SOLUNAC
 */
public class ModelTabeleKupci extends AbstractTableModel {
    
    List<Kupac> listaKupaca;
    String[] kolone = {"KupacID", "Ime", "Prezime", "Telefon", "Email", "Mesto"};

    public ModelTabeleKupci(List<OpstiDomenskiObjekat> lista) {
        listaKupaca = new ArrayList<>();
        if (lista != null){
            for (OpstiDomenskiObjekat odo : lista){
                Kupac kupac = (Kupac) odo;
                listaKupaca.add(kupac);
            }
        }   
    }
    
    @Override
    public int getRowCount() {
        return listaKupaca.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kupac kupac = listaKupaca.get(rowIndex);
        switch(columnIndex){
            case 0:
                return kupac.getKupacID();
            case 1:
                return kupac.getIme();
            case 2:
                return kupac.getPrezime();
            case 3:
                return kupac.getTelefon();
            case 4:
                return kupac.getEmail();
            case 5:
                return kupac.getMesto().getNaziv();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName (int column){
        return kolone[column];
    }
    
    public Kupac vratiKupca (int rb){
        return listaKupaca.get(rb);
    }
}
