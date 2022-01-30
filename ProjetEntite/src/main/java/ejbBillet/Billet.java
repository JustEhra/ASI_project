package ejbBillet;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Billet implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private String  depart;
    private String arivee;
    private int date;
    private int prix;
    private int quantiteEnStock;

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public int getId() {
        return id;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
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

    public int getDate() {
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

    public void setDate(int date) {
        this.date = date;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}

