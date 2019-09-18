package Statusi;

import Korisnik.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name="status")
public class Statusi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idstatus")
    private int id;
    @Column(name="status")
    private String status;
    @ManyToOne
    @JoinColumn(name="k_idregistration")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Korisnik k;

    public Korisnik getK() {
        return k;
    }

    public void setK(Korisnik k) {
        this.k = k;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}