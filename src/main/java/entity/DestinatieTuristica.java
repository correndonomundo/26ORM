package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "destinatiiTuristice")

public class DestinatieTuristica implements Serializable {

    @Id
    @Column(name = "destinatie_id", unique = true)
    private int id;

    @Column(name = "coordonate", nullable = false )
    private int coordonate;

    @Column(name = "oras", nullable = false)
    private String oras;

    @Column(name = "obiectiv", nullable = false)
    private String obiectiv;

    @Column(name = "rating", nullable = true)
    private String rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoordonate() {
        return coordonate;
    }

    public void setCoordonate(int coordonate) {
        this.coordonate = coordonate;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getObiectiv() {
        return obiectiv;
    }

    public void setObiectiv(String obiectiv) {
        this.obiectiv = obiectiv;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }


    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        DestinatieTuristica dest = (DestinatieTuristica) o;
        return id == dest.id &&
                Objects.equals(coordonate, dest.coordonate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, coordonate);
    }


    @Override
    public String toString(){
        return id + " " + coordonate + " " + oras +  " " + obiectiv;
    }
}
