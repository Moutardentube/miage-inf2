package fr.sorbonne.miage.m1.beans;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author ludovic
 */
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique=true)
    private Integer id;
    
    @Column(nullable = false)
    private String lastName;
    
    @Column(nullable = false)
    private String Firstname;
    
    @ManyToMany(mappedBy = "authors")
    private Collection<Book> books;
    
    public Author() {
        
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public Collection<Book> getBooks() {
        return books;
    }

    public void setBooks(Collection<Book> books) {
        this.books = books;
    }
}
