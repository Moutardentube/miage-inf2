package fr.sorbonne.miage.m1.beans;

import java.util.Collection;
import javax.persistence.*;

@Entity
public class Book {
    @Id
    @Column(nullable = false, length = 10, unique=true)
    private Integer isbn;
    
    @Column(nullable = false)
    private String title;
    
    @Column(nullable = false, precision = 2)
    private Float price;
    
    @ManyToMany
    @JoinTable
    private Collection<Author> authors;
    
    public Book() {
        
    }
    
    public Book(Integer isin, String title, Float price) {
        this.isbn = isin;
        this.title = title;
        this.price = price;
    }

    public Integer getIsbn() {
        return isbn;
    }

    public void setIsbn(Integer isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Collection<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Collection<Author> authors) {
        this.authors = authors;
    }
}
