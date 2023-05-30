package lt.vu.persistence;

import lt.vu.entities.ConcertHall;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ConcertHallsDAO {

    @Inject
    private EntityManager em;

    public List<ConcertHall> loadAll() {
        return em.createNamedQuery("ConcertHall.findAll", ConcertHall.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(ConcertHall concertHall){
        this.em.persist(concertHall);
    }

    public ConcertHall findOne(Long id) {
        return em.find(ConcertHall.class, id);
    }

    public List loadConcertHallByName(String s) {
        s = s.toUpperCase();
        return em.createQuery(
                        "select c " +
                                "from ConcertHall as c " +
                                "where upper(c.name) like :concertHallName")
                .setParameter("concertHallName", s == null ? "" : "%" + s + "%").
                getResultList();
    }
}
