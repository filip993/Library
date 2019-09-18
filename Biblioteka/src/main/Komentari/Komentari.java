package Komentari;
import Korisnik.*;
import Books.*;

import javax.persistence.*;

@Entity
@Table(name="komentari")
public class Komentari {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "komentar_id")
    private int ID;
    @Column(name="komentaricol")
    private String komentar;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Korisnik korisnik;
    @ManyToOne
    @JoinColumn(name="book_id")
    private Book book;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
    public String getKomentar() {
        return this.komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar=komentar;
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(Korisnik korisnik) {
        this.korisnik = korisnik;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Komentari{" +
                "ID=" + ID +
                ", komentar='" + komentar + '\'' +
                ", korisnik=" + korisnik +
                ", book=" + book +
                '}';
    }
}
