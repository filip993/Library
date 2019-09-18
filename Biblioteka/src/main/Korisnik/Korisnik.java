package Korisnik;
import Books.Book;
import Books.BookTook;
import Messages.Messages;
import Statusi.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "registration")
public class Korisnik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idregistration",updatable = false, nullable = false)
    private int id;
    @Column(name="firstname")
    private String first_name;
    @Column(name="lastname")
    private String last_name;
    @Column(name="email")
    private String email;
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "k")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> book = new ArrayList<Book>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="friends", joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name="friend_id")
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Korisnik> friends = new ArrayList<Korisnik>();


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "k")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Statusi> statusi;


    @OneToMany(cascade=CascadeType.ALL,mappedBy = "k1")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Messages> messages = new ArrayList<Messages>();

    @OneToMany(mappedBy = "k",cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BookTook> booksTook= new ArrayList<>();


    public List<BookTook> getBooksTook() {
        return booksTook;
    }

    public void setBooksTook(List<BookTook> booksTook) {
        this.booksTook = booksTook;
    }

    public List<Statusi> getStatusi() {
        return this.statusi;
    }

    public void setStatusi(List<Statusi> statusi) {
        this.statusi = statusi;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    public List<Korisnik> getFriends() {
        return this.friends;
    }

    public void setFriends(List<Korisnik> friends) {
        this.friends = friends;
    }

    public Korisnik() {

    }
    public void setId(int id) {
        this.id = id;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public List<Messages> getMessages() {
        return this.messages;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return this.id;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }
    public String getLast_name() {
        return last_name;
    }
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return  this.email;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", book=" + book +
                ", friends=" + friends +
                ", statusi=" + statusi +
                ", messages=" + messages +
                ", booksTook=" + booksTook +
                '}';
    }
}
