/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import model.Zanr;

/**
 *
 * @author Mladen
 */
public class Controller {
    private List<Knjiga> listaKnjiga = new ArrayList<>();;
    private List<Autor> listaAutora = new ArrayList<>();;
    
    private static Controller instance;
    
    public static Controller getInstance(){
        if (instance==null){
            instance=new Controller();
        }
        return instance;
    
    }
    
    

    public Controller() {
    
    Autor autor1= new Autor("Ivo", "Andric", 1899, "Biografija Iva Andrica bla bla bla");
    Autor autor2= new Autor("Danilo", "Kis", 1915, "Biografija Danila Kisa bla bla bla");
    Autor autor3= new Autor("Mesa", "Selimovic", 1917, "Biografija Mese Selimovica bla bla bla");
    
    Knjiga knjiga1= new Knjiga("Na Drini cuprija", autor1, "123456789", 1945, Zanr.ROMAN);
    Knjiga knjiga2= new Knjiga("Basta, pepeo", autor2, "123456789", 1977, Zanr.ISTORIJSKI);
    Knjiga knjiga3= new Knjiga("Tvrdjava", autor3, "123456789", 1912, Zanr.POEZIJA);
    
    listaKnjiga.add(knjiga1);
    listaKnjiga.add(knjiga2);
    listaKnjiga.add(knjiga3);
    listaAutora.add(autor1);
    listaAutora.add(autor2);
    listaAutora.add(autor3);
    
    
    } 

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int selektovaniRed) {
        listaKnjiga.remove(selektovaniRed);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
       listaKnjiga.add(novaKnjiga);
    }
    
    
}
