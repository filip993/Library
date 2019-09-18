package Tagovi;

import Books.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.ws.rs.DELETE;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags")
public class BookTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_tag")
    private int id;
    @ManyToMany(mappedBy = "bookTag")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Book> books= new ArrayList<Book>();
    @JoinColumn(name="tag")
    private String tag;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void insert(Book book) {
        this.books.add(book);
    }

    public String getTag() {
        return this.tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "BookTag{" +
                "id=" + id +
                ", books=" + books +
                ", tag='" + tag + '\'' +
                '}';
    }
}
