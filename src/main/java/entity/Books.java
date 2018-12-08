package entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")

public class Books implements Serializable{

    @Id
    @Column(name = "book_id", unique = true)
    private int id;

    @Column(name = "ISBN", nullable = false )
    private int ISBN;

    @Column(name = "titlu", nullable = false )
    private String titlu;

    @Column(name = "autor", nullable = false)
    private String autor;

    @Column(name = "anAparitie", nullable = false)
    private String anAparitie;

    @Column(name = "cineAImprumutat", nullable = true)
    private String cineAImprumutat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getAnAparitie() {
        return anAparitie;
    }

    public void setAnAparitie(String anAparitie) {
        this.anAparitie = anAparitie;
    }

    public String getCineAImprumutat() {
        return cineAImprumutat;
    }

    public void setCineAImprumutat(String cineAImprumutat) {
        this.cineAImprumutat = cineAImprumutat;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Books book = (Books) o;
        return id == book.id &&
                Objects.equals(ISBN, book.ISBN);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, ISBN);
    }


    @Override
    public String toString(){
        return id + " " + ISBN + " " + titlu +  " " + autor;
    }
}
