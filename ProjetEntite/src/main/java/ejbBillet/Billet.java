package ejbBillet;


import ejbUser.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "Billet")
//@Table(name = "billet")
public class Billet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String  depart;
    private String arivee;
    private String date;
    private int prix;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn
    private User user;

    public Billet() {}

    public User getUser() {return user;}

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getDepart() {
        return depart;
    }

    public String getArivee() {
        return arivee;
    }

    public String getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public void setArivee(String arivee) {
        this.arivee = arivee;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}

