/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.OpstiDomenskiObjekat;
import domen.Racun;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SOLUNAC
 */
public class ModelTabeleRacuni extends AbstractTableModel{
    
    List<Racun> listaRacuna;
    String[] kolone = {"RacunID", "Datum", "Vrednost", "KupacID", "RadnikID"};

    public ModelTabeleRacuni(List<OpstiDomenskiObjekat> lista) {
        listaRacuna = new ArrayList<>();
            for (OpstiDomenskiObjekat odo : lista){
                Racun racun = (Racun) odo;
                listaRacuna.add(racun);
            }
    }
    
    @Override
    public int getRowCount() {
        return listaRacuna.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Racun rac = listaRacuna.get(rowIndex);
        switch(columnIndex){
            case 0:
                return rac.getRacunID();
            case 1:
                return new SimpleDateFormat ("dd.MM.yyyy").format(rac.getDatum());
            case 2:
                return rac.getVrednost();
            case 3:
                return rac.getKupacID().getKupacID();
            case 4:
                return rac.getRadnikID().getRadnikID();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName (int column){
        return kolone[column];
    }
    
    public Racun vratiRacun (int rb){
        return listaRacuna.get(rb);
    }
}
