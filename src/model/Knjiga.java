/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Mladen
 */
public class Knjiga {
    private String naslov;
    private Autor autor;
    private String ISBN;
    private int godinaIzdavanja;
    private Zanr zanr;

    public Knjiga() {
    }

    public Knjiga(String naslov, Autor autor, String ISBN, int godinaIzdavanja, Zanr zanr) {
        this.naslov = naslov;
        this.autor = autor;
        this.ISBN = ISBN;
        this.godinaIzdavanja = godinaIzdavanja;
        this.zanr = zanr;
    }

    
    
    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    
    @Override
    public String toString() {
        return "Knjiga{" + "naslov=" + naslov + ", autor=" + autor + ", ISBN=" + ISBN + ", godinaIzdavanja=" + godinaIzdavanja + '}';
    }
    
    
}
