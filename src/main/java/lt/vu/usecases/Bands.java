package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Band;
import lt.vu.entities.Festival;
import lt.vu.persistence.BandsDAO;
import lt.vu.persistence.MusiciansDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Model
public class Bands {

    @Inject
    private BandsDAO bandsDAO;

    @Getter @Setter
    private Band bandToCreate = new Band();

    @Getter
    private List<Band> allBands;
    @Getter
    private List<Festival> festivals;
    @Getter
    private List<Band> loadedBands;
    @Getter @Setter
    private String bandToSearch = "";

    @PostConstruct
    public void init(){
        loadAllBands();
    }

    @Transactional
    public void createBand(){
        this.bandsDAO.persist(bandToCreate);
    }

    private void loadAllBands(){
        this.allBands = bandsDAO.loadAll();
    }

    @Transactional
    public void loadBandLike() {
        this.loadedBands = bandsDAO.loadBand(bandToSearch);
    }
}
