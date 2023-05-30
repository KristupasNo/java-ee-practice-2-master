package lt.vu.persistence;

import lt.vu.entities.Band;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BandsDAO {

    @Inject
    private EntityManager em;

    public List<Band> loadAll() {
        return em.createNamedQuery("Band.findAll", Band.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Band band){
        this.em.persist(band);
    }

    public Band findOne(Integer id) {
        return em.find(Band.class, id);
    }

    public List loadBand(String s) {
        s = s.toUpperCase();
        return em.createQuery(
                        "select t " +
                                "from Band as t " +
                                "where upper(t.name) like :bandName")
                .setParameter("bandName", s == null ? "" : "%" + s + "%").
                getResultList();
    }
}
