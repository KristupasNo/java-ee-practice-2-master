package lt.vu.usecases;

import lt.vu.entities.ConcertHall;
import lt.vu.persistence.ConcertHallsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class ConcertHalls {

    @Inject
    private ConcertHallsDAO concertHallsDAO;

    private List<ConcertHall> allConcertHalls;
    private ConcertHall newConcertHall = new ConcertHall();

    @PostConstruct
    public void init() {
        loadAllConcertHalls();
    }

    public List<ConcertHall> getAllConcertHalls() {
        return allConcertHalls;
    }

    public void loadAllConcertHalls() {
        this.allConcertHalls = concertHallsDAO.loadAll();
    }

    public ConcertHall getNewConcertHall() {
        return newConcertHall;
    }

    public void setNewConcertHall(ConcertHall newConcertHall) {
        this.newConcertHall = newConcertHall;
    }

    @Transactional
    public String createConcertHall() {
        this.concertHallsDAO.persist(newConcertHall);
        return "/concertHalls?faces-redirect=true";
    }
}
