package lt.vu.persistence;

import lt.vu.entities.Band;
import lt.vu.entities.Musician;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class MusiciansDAO {

    @Inject
    private EntityManager em;

    @Transactional
    public void create(Musician musician) {
        em.persist(musician);
    }

    public void persist(Musician musician){
        this.em.persist(musician);
    }

    public Musician findOne(Integer id){
        return em.find(Musician.class, id);
    }

    public Musician update(Musician musician){
        return em.merge(musician);
    }

    public List<Musician> findAll() { return em.createNamedQuery("Musician.findAll", Musician.class).getResultList(); }

}
