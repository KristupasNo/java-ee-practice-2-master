package lt.vu.persistence;

import lt.vu.entities.Festival;
import lt.vu.entities.Band;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FestivalsDAO {

    @Inject
    private EntityManager em;

    public List<Festival> loadAll() {
        return em.createNamedQuery("Festival.findAll", Festival.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Festival festival){
        this.em.persist(festival);
    }

    public Festival findOne(Integer id) {
        return em.find(Festival.class, id);
    }
    public List loadFestival(String s) {
        s = s.toUpperCase();
        return em.createQuery(
                        "select l " +
                                "from Festival as l " +
                                "where upper(l.name) like :festivalName")
                .setParameter("festivalName", s == null ? "" : "%" + s + "%").
                getResultList();
    }
}
