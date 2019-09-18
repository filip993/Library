package Messages;

import Korisnik.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="messages")
public class Messages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idmessages")
    private int id;
    @ManyToOne
    @JoinColumn(name="k1_idregistration")
    private Korisnik k1;
    @ManyToOne
    @JoinColumn(name="k2_idregistration")
    private Korisnik k2;
    @Column(name="message")
    private String message;
    @Column(name="date")
    private Date date;


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Korisnik getK2() {
        return k2;
    }

    public void setK2(Korisnik k2) {
        this.k2 = k2;
    }

    public Korisnik getK1() {
        return k1;
    }

    public void setK1(Korisnik k1) {
        this.k1 = k1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
