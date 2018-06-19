/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Radnik;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SOLUNAC
 */
public class ModelTabeleKorisnici extends AbstractTableModel{

    List<Radnik> listaKorisnika;
    String[] kolone = {"RadnikID", "KorisnickoIme"};

    public ModelTabeleKorisnici() {
        listaKorisnika = new ArrayList<>();
    }
    
    public ModelTabeleKorisnici(List<Radnik> listaKorisnika) {
        this.listaKorisnika = listaKorisnika;
    }
    
    @Override
    public int getRowCount() {
        return listaKorisnika.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Radnik radnik = listaKorisnika.get(rowIndex);
        switch(columnIndex){
            case 0:
                return radnik.getRadnikID();
            case 1:
                return radnik.getKorisnickoIme();
            default:
                return "N/A";         
        }
    }
    
    @Override
    public String getColumnName (int column){
        return kolone[column];      
    }
    
    public void dodajKorisnika (Radnik radnik){
        listaKorisnika.add(radnik);
        fireTableDataChanged();
    }
    
    public void obrisiKorisnika (Radnik radnik){
        listaKorisnika.remove(radnik);
        fireTableDataChanged();
    }
    
}
