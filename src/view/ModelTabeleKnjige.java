/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Knjiga;

/**
 *
 * @author Mladen
 */
public class ModelTabeleKnjige extends AbstractTableModel {

    private List<Knjiga> listaKnjiga;
    private final String[] kolone={"id","Naslov","Autor","ISBN","Godina izdanja"};

    public ModelTabeleKnjige(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }
    
      
    
    @Override
    public int getRowCount() {
        return listaKnjiga.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Knjiga knjiga=listaKnjiga.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> knjiga.getId();
            case 1 -> knjiga.getNaslov();
            case 2 -> knjiga.getAutor().getIme()+ " " + knjiga.getAutor().getPrezime();
            case 3 -> knjiga.getISBN();
            case 4 -> knjiga.getGodinaIzdavanja();
            default -> null;
      
        };
   
       
    
    
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];
    }

    void osveziPodatke() {
        fireTableDataChanged();
    }
    
    
    
    
    
}
