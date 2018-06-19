/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.komponente;

import domen.Artikal;
import domen.Racun;
import domen.StavkaRacuna;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SOLUNAC
 */
public class ModelTabeleStavkeRacuna extends AbstractTableModel {

    Racun racun;
    String[] kolone = {"RedniBroj","Artikal", "Kolicina", "Vrednost"};

    public ModelTabeleStavkeRacuna(Racun racun) {
        this.racun = racun;
    }
    
    @Override
    public int getRowCount() {
        return racun.getListaStavki().size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StavkaRacuna sr = racun.getListaStavki().get(rowIndex);
        switch(columnIndex){
            case 0:
                return rowIndex + 1;
            case 1:
                return sr.getArtikal();
            case 2:
                return sr.getKolicina();
            case 3:
                return sr.getVrednost();
            default:
                return "N/A";
        }
    }
    
    @Override
    public String getColumnName (int column){
        return kolone[column];
    }
    
    public boolean isCellEditable (int rowIndex, int columnIndex){
        if (columnIndex == 1 || columnIndex == 2){
            return true;
        }
        return false;
    }
    
    @Override
    public void setValueAt (Object aValue, int rowIndex, int columnIndex){
        
        StavkaRacuna sr = racun.getListaStavki().get(rowIndex);
        
        if (columnIndex == 1){
            sr.setArtikal((Artikal) aValue);
        }
        
        if (columnIndex == 2){
            sr.setKolicina(Integer.parseInt((String) aValue));
            if(sr.getKolicina() < 0){
                JOptionPane.showMessageDialog(null, "Količina ne sme biti u minusu!", "Greška!", JOptionPane.ERROR_MESSAGE);
                return;
            }
            sr.setVrednost(truncateTo(sr.getKolicina() * sr.getArtikal().getCena(), 2));
            racun.setVrednost(truncateTo(izracunajUkupnuVrednost(), 2));
            kontroler.KontrolerKlijent.getInstance().osveziUkupnuVrednostRacuna();
            fireTableDataChanged();
        }     
    }
    
    
    private double truncateTo(double unroundedNumber, int decimalPlaces) {
        int truncatedNumberInt = (int) (unroundedNumber * Math.pow(10, decimalPlaces));
        double truncatedNumber = (double) (truncatedNumberInt / Math.pow(10, decimalPlaces));
        return truncatedNumber;
    }
    
    public Racun getRacun(){
        return racun;
    }
    
    public boolean proveriBrojStavki(){
        if (racun.getListaStavki().isEmpty()){
            return false;
        }
        return true;
    }
    
    public double izracunajUkupnuVrednost(){
        double rez = 0;
        for (StavkaRacuna sr : racun.getListaStavki()){
            rez += sr.getVrednost();
        }
        return rez;    
    }
    
    public void dodajStavkuRacuna(){
        StavkaRacuna sr = new StavkaRacuna();
        sr.setRacunID(racun);
        racun.getListaStavki().add(sr);
        fireTableDataChanged();
    }
    
    public void obrisiStavkuRacuna(int rb){
        racun.getListaStavki().remove(rb);
        racun.setVrednost(izracunajUkupnuVrednost());
        fireTableDataChanged();
    }
}
