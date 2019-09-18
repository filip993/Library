package Books;

import Author.*;
import Komentari.Komentari;
import Korisnik.*;
import Tagovi.BookTag;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_books")
    public int idBooks;
    @Column(name = "book_name")
    private String bookName;
    @Column(name = "book_price")
    private int bookPrice;
    @Column(name = "kolicina")
    private int kolicina;
    @ManyToOne
    @JoinTable(name = "registration_book", joinColumns = @JoinColumn(name = "book_id_books"),
            inverseJoinColumns = @JoinColumn(name = "Korisnik_idregistration"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private Korisnik k;
    @ManyToOne
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private Author auth ;
    @Column(name="about")
    private String about;
    @Transient
    private String type="Book";

    public Korisnik getK() {
        return k;
    }

    @ManyToMany
    @JoinTable(name="book_tags",joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="tags_id"))
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BookTag> bookTag= new ArrayList<BookTag>();

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "book")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Komentari> komentari = new ArrayList<Komentari>();


    public List<Komentari> getKomentari() {
        return komentari;
    }

    public void setKomentari(List<Komentari> komentari) {
        this.komentari = komentari;
    }

    public void setBookTag(List<BookTag> bookTag) {
        this.bookTag = bookTag;
    }

    public List<BookTag> getBookTag() {
        return this.bookTag;
    }


    public void setK(Korisnik k) {
        this.k = k;
    }

    public int getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(int idBooks) {
        this.idBooks = idBooks;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(int bookPrice) {
        this.bookPrice = bookPrice;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public Author getAuthor() {
        return this.auth;
    }

    public void setAuthor(Author author) {
        this.auth = author;
    }

    public String getAbout() {
        return this.about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return
                "idBooks=" + idBooks +
                ", bookName='" + bookName + '\'' +
                ", bookPrice=" + bookPrice +
                ", kolicina=" + kolicina + ",type="+type;
    }
}















