package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author ludovic
 */
public class BookDAO  implements DAO<Book> {
    @Override
    public List<Book> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();
        
        TypedQuery<Book> q = em.createQuery("SELECT b FROM Book b", Book.class);

        return q.getResultList();
    }

    @Override
    public Book findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Book> q = em.createQuery("Select b from Book b where b.isbn = :id", Book.class);
        q.setParameter("id", id);
        
        return q.getSingleResult();
    }
}
