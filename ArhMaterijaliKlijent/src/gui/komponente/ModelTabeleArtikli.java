/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Artikal;
import domen.OpstiDomenskiObjekat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SOLUNAC
 */
public class ModelTabeleArtikli extends AbstractTableModel {

    List<Artikal> listaArtikala;
    String[] kolone = {"ArtikalID", "Naziv", "Cena", "Opis", "TipArtikla", "JedinicaMere"};

    public ModelTabeleArtikli(List<OpstiDomenskiObjekat> lista) {
        listaArtikala = new ArrayList<>();
        for (OpstiDomenskiObjekat odo : lista){
            Artikal artikal = (Artikal) odo;
            listaArtikala.add(artikal);
        }
    }

    @Override
    public int getRowCount() {
        return listaArtikala.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Artikal artikal = listaArtikala.get(rowIndex);
        switch(columnIndex){
            case 0:
                return artikal.getArtikalID();
            case 1:
                return artikal.getNaziv();
            case 2:
                return artikal.getCena();
            case 3:
                return artikal.getOpis();
            case 4:
                return artikal.getTipArtikla().getNaziv();
            case 5:
                return artikal.getJedinicaMere();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName (int column){
        return kolone[column];
    }
    
    public Artikal vratiArtikal (int rb){
        return listaArtikala.get(rb);
    }
    
}
