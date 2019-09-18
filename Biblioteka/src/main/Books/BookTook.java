package Books;

import Korisnik.Korisnik;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
@Entity
@Table(name="booktook")
public class BookTook {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="idbooktook")
        private int id;
        @OneToOne
        @JoinColumn(name="book_id_books")
        private Book b;
        @ManyToOne
        @JoinColumn(name="k_idregistration")
        private Korisnik k;

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public Book getB() {
                return b;
        }

        public void setB(Book b) {
                this.b = b;
        }

        public Korisnik getK() {
                return k;
        }

        public void setK(Korisnik k) {
                this.k = k;
        }

}
