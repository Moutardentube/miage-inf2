package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author ludovic
 */
public class AuthorDAO implements DAO<Author> {
    @Override
    public List<Author> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Author> q = em.createQuery("Select a from Author a", Author.class);

        return q.getResultList();
    }

    @Override
    public Author findById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        EntityManager em = emf.createEntityManager();

        TypedQuery<Author> q = em.createQuery("Select a from Author a where a.id = :id", Author.class);
        q.setParameter("id", id);
        
        return q.getSingleResult();
    }
}
