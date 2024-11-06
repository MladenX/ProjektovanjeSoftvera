/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Knjiga;
import java.sql.ResultSet;
import model.Autor;
import model.Zanr;

/**
 *
 * @author Mladen
 */
public class DBBroker {

    public List<Knjiga> ucitajKnjiguIzBaze() {
        List<Knjiga> lista=new ArrayList<>();
        try {
            String upit = "SELECT * FROM KNJIGA K JOIN AUTOR A ON k.autorId=a.id";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            int id=rs.getInt("k.id");
            String naslov=rs.getString("k.naslov");
            int godIz=rs.getInt("k.godinaIzdanja");
            String ISBN=rs.getString("k.ISBN");
            String zanr=rs.getString("k.zanr");
            Zanr z = Zanr.valueOf(zanr);
            String ime=rs.getString("a.ime");
            String prezime=rs.getString("a.prezime");
            String biografija=rs.getString("a.biografija");
            int godR=rs.getInt("a.godinaRodjenja");
            int idA=rs.getInt("a.id");
            Autor a=new Autor(idA, ime, prezime, godR, biografija);
            
            Knjiga k = new Knjiga(id, naslov, a, ISBN, godIz, z);
            lista.add(k);
            
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public List<Autor> ucitajAutoraIzBaze() {
        List<Autor> lista=new ArrayList<>();
        try {
            String upit = "SELECT * FROM autor a";
            Statement st = Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs = st.executeQuery(upit);
            while(rs.next()){
            
            String ime=rs.getString("a.ime");
            String prezime=rs.getString("a.prezime");
            String biografija=rs.getString("a.biografija");
            int godR=rs.getInt("a.godinaRodjenja");
            int idA=rs.getInt("a.id");
            Autor a=new Autor(idA, ime, prezime, godR, biografija);
        
            lista.add(a);
            
            
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    public void obrisiKnjigu(int id) {
        try {
            String upit="DELETE FROM knjiga WHERE id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        try {
            String upit = "INSERT INTO knjiga (id, naslov, autorId, ISBN, godinaIzdanja, zanr) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1, novaKnjiga.getId());
            ps.setString(2, novaKnjiga.getNaslov());
            ps.setInt(3, novaKnjiga.getAutor().getId());
            ps.setString(4, novaKnjiga.getISBN());
            ps.setInt(5, novaKnjiga.getGodinaIzdavanja());
            ps.setString(6, String.valueOf(novaKnjiga.getZanr()));
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void azurirajKnjigu(Knjiga knjigazaIzmenu) {
         try {
            String upit = "UPDATE knjiga SET naslov=?, autorId=?, godinaIzdanja=?, zanr=? where id=?";
            PreparedStatement ps = Konekcija.getInstance().getConnection().prepareStatement(upit);
            
            ps.setString(1, knjigazaIzmenu.getNaslov());
            ps.setInt(2, knjigazaIzmenu.getAutor().getId());
           // ps.setString(4, knjigazaIzmenu.getISBN());
            ps.setInt(3, knjigazaIzmenu.getGodinaIzdavanja());
            ps.setString(4, String.valueOf(knjigazaIzmenu.getZanr()));
            ps.setInt(5, knjigazaIzmenu.getId());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
